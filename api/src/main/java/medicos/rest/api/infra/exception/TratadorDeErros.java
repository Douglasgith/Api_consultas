package medicos.rest.api.infra.exception;


import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();

    }

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var errros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(errros.stream().map(DadosErroValidacao :: new).toList());


}
private record DadosErroValidacao(String campo, String mensagem){

        public DadosErroValidacao (FieldError error){
            this(error.getField(), error.getDefaultMessage());

        }

}

}
