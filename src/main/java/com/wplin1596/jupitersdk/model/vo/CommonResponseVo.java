package com.wplin1596.jupitersdk.model.vo;

import java.io.Serializable;

/**
 * @Description TODO
 * @ClassName CommonResponseVo
 * @Author wplin1596
 * @Date 2020/4/30 17:43
 * @Version 1.0.0
 */
public class CommonResponseVo<T> extends CommonSimpleResponseVo {

    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
