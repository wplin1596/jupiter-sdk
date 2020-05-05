package com.wplin1596.jupitersdk.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @ClassName FileUtils
 * @Author wplin1596
 * @Date 2020/4/30 23:18
 * @Version 1.0.0
 */
@Component
public class FileUtils {

    private static String filePath;

    public static String getFilePath(String fileName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowDate = sdf.format(new Date());
        String dirPath = filePath + "/" + nowDate;
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return dirPath + "/" + fileName;
    }

    public static void writeFile(String filePath, String fileContent) throws IOException {
        FileOutputStream os = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        osw.write(fileContent);
        osw.close();
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }

    @Value("${file.path}")
    public void setFilePath(String filePath) {
        FileUtils.filePath = filePath;
    }
}
