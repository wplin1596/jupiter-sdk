package com.wplin1596.jupitersdk.service;

import com.wplin1596.jupitersdk.model.po.FilePo;
import com.wplin1596.jupitersdk.model.vo.CommonSimpleResponseVo;
import com.wplin1596.jupitersdk.model.vo.FileVo;

import java.io.IOException;
import java.util.List;

/**
 * @Description TODO
 * @ClassName FileService
 * @Author wplin1596
 * @Date 2020/5/4 13:19
 * @Version 1.0.0
 */
public interface FileService {
    void saveFile(FileVo fileVo) throws IOException;

    List<FileVo> queryFileAll();

    void editFile(FileVo fileVo) throws IOException;

    FileVo queryFileById(String id);

    FilePo queryFilePoById(String id);

    CommonSimpleResponseVo checkEditFile(String id);
}
