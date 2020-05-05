package com.wplin1596.jupitersdk.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @ClassName CommonDataResponseVo
 * @Author wplin1596
 * @Date 2020/4/30 17:48
 * @Version 1.0.0
 */
public class CommonDataResponseVo<T> extends CommonSimpleResponseVo {
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
