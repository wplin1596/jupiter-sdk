package com.wplin1596.jupitersdk.service.impl;

import com.wplin1596.jupitersdk.dao.FileRepository;
import com.wplin1596.jupitersdk.model.po.FilePo;
import com.wplin1596.jupitersdk.model.vo.FileVo;
import com.wplin1596.jupitersdk.service.FileService;
import com.wplin1596.jupitersdk.util.FileUtils;
import com.wplin1596.jupitersdk.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @ClassName FileServiceImpl
 * @Author wplin1596
 * @Date 2020/5/4 13:20
 * @Version 1.0.0
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public void saveFile(FileVo fileVo) throws IOException {
        String filePath = FileUtils.getFilePath(fileVo.getFileName());
        FilePo po = convertFilePo(fileVo, filePath);
        fileRepository.save(po);

        FileUtils.writeFile(filePath, fileVo.getFileContent());
    }

    @Override
    public List<FileVo> queryFileAll() {
        List<FilePo> filePos = fileRepository.findAll();
        return filePos.stream().map(po -> {
            FileVo vo = new FileVo();
            vo.setId(po.getId());
            vo.setFileName(po.getName());
            vo.setFileContent(po.getContent());
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public void editFile(FileVo fileVo) throws IOException {
        FilePo filePo = fileRepository.findById(fileVo.getId()).get();
        if (filePo == null) {
            return;
        }
        if (filePo.getName().equals(fileVo.getFileName())) {
            // 文件名没有变更，修改文件内容
            filePo.setContent(fileVo.getFileContent());
            fileRepository.save(filePo);
            FileUtils.writeFile(filePo.getPath(), filePo.getContent());
        } else {
            // 文件名变更，删除原有文件，新增新文件
            String newFilePath = FileUtils.getFilePath(fileVo.getFileName());
            String oldFilePath = filePo.getPath();

            filePo.setName(fileVo.getFileName());
            filePo.setContent(fileVo.getFileContent());
            filePo.setPath(newFilePath);

            fileRepository.save(filePo);
            FileUtils.writeFile(newFilePath, filePo.getContent());
            FileUtils.deleteFile(oldFilePath);
        }
    }

    @Override
    public FileVo queryFileById(String id) {
        FilePo filePo = fileRepository.findById(id).get();
        return new FileVo(filePo);
    }

    @Override
    public FilePo queryFilePoById(String id) {
        return fileRepository.findById(id).get();
    }

    private FilePo convertFilePo(FileVo fileVo, String path) {
        FilePo po = new FilePo();
        po.setId(IdUtils.id());
        po.setName(fileVo.getFileName());
        po.setContent(fileVo.getFileContent());
        po.setPath(path);
        return po;
    }
}
