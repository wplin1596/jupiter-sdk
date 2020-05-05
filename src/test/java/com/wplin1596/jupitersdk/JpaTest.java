package com.wplin1596.jupitersdk;

import com.wplin1596.jupitersdk.dao.FileRepository;
import com.wplin1596.jupitersdk.model.po.FilePo;
import com.wplin1596.jupitersdk.model.vo.FileVo;
import com.wplin1596.jupitersdk.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description TODO
 * @ClassName JpaTest
 * @Author wplin1596
 * @Date 2020/5/4 13:13
 * @Version 1.0.0
 */
@SpringBootTest
public class JpaTest {
    @Autowired
    FileRepository fileRepository;

    @Autowired
    FileService fileService;

    @Test
    public void add_tes() {
        FilePo filePo = new FilePo();
        filePo.setId("1231231");
        filePo.setName("test.txt");
        filePo.setContent("dadadada");
        filePo.setPath("dada");
        fileRepository.save(filePo);
    }

    @Test
    public void query_test() {
        List<FileVo> vos = fileService.queryFileAll();
        for (FileVo vo : vos) {
            System.out.println(vo);
        }
    }

    @Test
    public void query_one_test() {
        FilePo filePo = fileRepository.findById("77a160bbec6446b1a3b84fca8983256b").get();
        System.out.println(filePo);
    }
}
