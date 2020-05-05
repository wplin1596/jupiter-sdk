package com.wplin1596.jupitersdk.dao;

import com.wplin1596.jupitersdk.model.po.FilePo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @ClassName FileRepository
 * @Author wplin1596
 * @Date 2020/5/4 13:02
 * @Version 1.0.0
 */
public interface FileRepository extends JpaRepository<FilePo, String> {

}
