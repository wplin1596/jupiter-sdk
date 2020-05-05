package com.wplin1596.jupitersdk.model.vo;

import com.wplin1596.jupitersdk.model.po.FilePo;

/**
 * @Description TODO
 * @ClassName FileVo
 * @Author wplin1596
 * @Date 2020/4/30 22:18
 * @Version 1.0.0
 */
public class FileVo {
    private String id;
    private String fileName;
    private String fileContent;

    public FileVo() {
    }

    public FileVo(FilePo filePo) {
        this.id = filePo.getId();
        this.fileName = filePo.getName();
        this.fileContent = filePo.getContent();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FileVo{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileContent='" + fileContent + '\'' +
                '}';
    }
}
