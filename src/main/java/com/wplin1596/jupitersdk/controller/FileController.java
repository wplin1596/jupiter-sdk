package com.wplin1596.jupitersdk.controller;

import com.wplin1596.jupitersdk.model.po.FilePo;
import com.wplin1596.jupitersdk.model.vo.CommonSimpleResponseVo;
import com.wplin1596.jupitersdk.model.vo.FileVo;
import com.wplin1596.jupitersdk.service.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Description TODO
 * @ClassName FileController
 * @Author wplin1596
 * @Date 2020/4/30 12:34
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @ResponseBody
    @PostMapping("/save")
    public CommonSimpleResponseVo saveFile(@RequestBody FileVo fileVo) {
        CommonSimpleResponseVo responseVo = new CommonSimpleResponseVo();
        try {
            fileService.saveFile(fileVo);
            responseVo.setResult(true);
            responseVo.setCode(200);
            responseVo.setMessage("success");
        } catch (IOException e) {
            responseVo.setMessage(e.getMessage());
        } catch (Exception e) {
            responseVo.setMessage(e.getMessage());
        }
        return responseVo;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<FileVo> fileVos = fileService.queryFileAll();
        model.addAttribute("fileList", fileVos);
        return "list";
    }

    @ResponseBody
    @PostMapping("/edit")
    public CommonSimpleResponseVo edit(@RequestBody FileVo fileVo) {
        CommonSimpleResponseVo responseVo = new CommonSimpleResponseVo();
        try {
            fileService.editFile(fileVo);
            responseVo.setResult(true);
            responseVo.setCode(200);
            responseVo.setMessage("success");
        } catch (IOException e) {
            responseVo.setMessage(e.getMessage());
        } catch (Exception e) {
            responseVo.setMessage(e.getMessage());
        }
        return responseVo;
    }

    @GetMapping("/detail")
    public String detail(String id, Model model) {
        FileVo vo = fileService.queryFileById(id);
        model.addAttribute("file", vo);
        return "edit";
    }

    @ResponseBody
    @GetMapping("/check")
    public CommonSimpleResponseVo check(String id) {
        return fileService.checkEditFile(id);
    }

    @GetMapping("/download")
    public void download(String id, HttpServletResponse response) throws IOException {
        FilePo po = fileService.queryFilePoById(id);
        response.setContentType("application/x-download;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(po.getName(),"UTF-8"));

        FileInputStream fis = new FileInputStream(new File(po.getPath()));
        OutputStream os = response.getOutputStream();
        IOUtils.copy(fis, os);

        fis.close();
    }
}
