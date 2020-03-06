package com.codeid.restservice.models;

public class ResponseMessage<T> {
    private int code;
    private String message;
    private T data;

    public ResponseMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<T>(0, null, data);
    }

    public static ResponseMessage error(int code, String message) {
        return new ResponseMessage(code, message, null);
    }

}