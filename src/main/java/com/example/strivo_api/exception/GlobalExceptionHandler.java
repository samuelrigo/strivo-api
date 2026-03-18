package com.example.strivo_api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErroResponse> campoVazio(MethodArgumentNotValidException ex){
        String campo = ex.getBindingResult().getFieldErrors().get(0).getField();
        String mensagem = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        ErroResponse erro = new ErroResponse("400", campo + ": " + mensagem);
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler
    public ResponseEntity<ErroResponse> excecaoGenerica(RuntimeException ex){
        ErroResponse erro = new ErroResponse("500", "Erro interno de servidor");
        return ResponseEntity.internalServerError().body(erro);
    }
}
