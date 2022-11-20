package com.user.registrationAndLogin.exceptionsAndErrors.errorResponse;

public class ErrorResponse {
    private String message;
    private String cause;
    private String jsonPath;

    public ErrorResponse(String message, String cause, String jsonPath) {
        this.message = message;
        this.cause = cause;
        this.jsonPath = jsonPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }
}
