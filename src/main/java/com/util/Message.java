package com.util;

/**
 * Created by ld on 2019/3/27.
 */
public class Message {
    private Integer code;
    private Object message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Message(Integer code, Object message) {
        this.code = code;
        this.message = message;
    }
}
