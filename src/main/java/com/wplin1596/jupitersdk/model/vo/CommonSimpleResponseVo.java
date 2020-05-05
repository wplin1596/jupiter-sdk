package com.wplin1596.jupitersdk.model.vo;

import java.io.Serializable;

/**
 * @Description TODO
 * @ClassName CommonSimpleResponseVo
 * @Author wplin1596
 * @Date 2020/4/30 17:53
 * @Version 1.0.0
 */
public class CommonSimpleResponseVo implements Serializable {
    private Boolean result;
    private Integer code;
    private String message;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
