package br.com.zup.edu.contadigital.exception;

import java.time.LocalDateTime;

public class RegraDeNegocioException extends Exception {

    private String field;
    private String message;
    private LocalDateTime thrownTime = LocalDateTime.now();

    public RegraDeNegocioException(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public LocalDateTime getThrownTime() {
        return thrownTime;
    }
}
