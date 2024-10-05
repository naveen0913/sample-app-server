package com.sample.sample.Responses;

public class AuthResponse {

    private int code;
    private String message;
    private Object Data;

    public AuthResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        Data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }
}
