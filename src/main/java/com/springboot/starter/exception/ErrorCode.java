package com.springboot.starter.exception;

public enum ErrorCode {
    ERROR_USER_RESUME("user.resume.error", "Resume should not be empty");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
