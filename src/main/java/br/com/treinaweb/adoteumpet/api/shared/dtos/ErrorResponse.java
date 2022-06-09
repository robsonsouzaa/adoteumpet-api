package br.com.treinaweb.adoteumpet.api.shared.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ErrorResponse {

    private int status;
    private String error;
    private String cause;
    private String message;
    private LocalDateTime timestamp;

    private Map<String, List<String>> errors;

    public ErrorResponse() {}

    public ErrorResponse(int status, String error, String cause, String message, LocalDateTime timestamp, Map<String, List<String>> errors) {
        this.status = status;
        this.error = error;
        this.cause = cause;
        this.message = message;
        this.timestamp = timestamp;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, List<String>> errors) {
        this.errors = errors;
    }
}
