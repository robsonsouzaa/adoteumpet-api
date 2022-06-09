package br.com.treinaweb.adoteumpet.api.shared.handlers;

import br.com.treinaweb.adoteumpet.api.shared.dtos.ErrorResponse;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final PropertyNamingStrategies.SnakeCaseStrategy snakeCaseStrategy = new PropertyNamingStrategies.SnakeCaseStrategy();

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        var body = new ErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                ex.getClass().getSimpleName(),
                "Houveram erros de validação",
                LocalDateTime.now(),
                convertFieldErrors(ex.getBindingResult().getFieldErrors())
        );

        ex.getBindingResult().getFieldErrors();
        return new ResponseEntity<>(body, status);
    }

    private Map<String, List<String>> convertFieldErrors(List<FieldError> fieldErrors) {
        var errors = new HashMap<String, List<String>>();

        fieldErrors.forEach(fieldError -> {
            var field = snakeCaseStrategy.translate(fieldError.getField());
            if (errors.containsKey(field)) {
                errors.get(field).add(fieldError.getDefaultMessage());
            } else {
                errors.put(
                        field,
                        Stream.of(fieldError.getDefaultMessage()).collect(Collectors.toList())
                );
            }
        });

        return errors;
    }
}
