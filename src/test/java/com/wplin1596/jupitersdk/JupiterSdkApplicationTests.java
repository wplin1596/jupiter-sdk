package com.wplin1596.jupitersdk;

import com.wplin1596.jupitersdk.util.FileUtils;
import com.wplin1596.jupitersdk.util.IdUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ClassUtils;

import java.io.IOException;

@SpringBootTest
class JupiterSdkApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void idTest() {
        System.out.println(IdUtils.id());
    }

    @Test
    void filePathTest() {
        System.out.println(ClassUtils.getDefaultClassLoader().getResource("").getPath());
    }

    @Test
    void fileSaveTest() throws IOException {
        FileUtils.writeFile("test.txt", "test,test,test,test,test");
    }
}
