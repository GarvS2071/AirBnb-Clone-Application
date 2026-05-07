package com.example.Airbnb_Clone.advices;

import com.example.Airbnb_Clone.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException exception){
        log.error("handleResourceNotFoundException :"+exception.toString());
        ApiError apiError = ApiError.builder()
                .httpstatus(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError){
        try{
            return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getHttpStatus());
        } catch (Throwable e) {
            log.error("Error while building error response", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(AuthenticationException exception){
        log.error("Unexpected error ocurred", exception);
        ApiError apiError=ApiError.builder()
                .httpstatus(HttpStatus.UNAUTHORIZED)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apirError);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiResponse<?>> handleInternServerError(JwtException exception){
        log.error("Unexpected error ocurred", exception);
        ApiError apiError=ApiError.builder()
                .httpstatus(HttpStatus.UNAUTHORIZED)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ApiResponse<?>> handleAccessDeniedException(AuthorizationDeniedException exception){
        log.error("Access denied 123", exception);
        ApiError apiError=ApiError.builder()
                .httpstatus(HttpStatus.FORBIDDEN)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotFoundException(MethodArgumentNotValidException exception) {
        log.error("handleMethodArgumentNotFoundException: "+exception.toString());
        List<String> errors = exception.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        ApiError apirError=ApiError.builder()
                .httpstatus(HttpStatus.BAD_REQUEST)
                .message("Input Validation failed")
                .errors(errors)
                .build();
        return buildErrorResponseEntity(apirError);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Throwable exception) {
        log.error("Unexpected error ocurred", exception);
        ApiError apiError=ApiError.builder()
                .httpstatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);

    }
}