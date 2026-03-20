package Carros.primeira_API.Service;


import Carros.primeira_API.Excecoes.CampoPreenchimento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidarRequisicao {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public static ResponseEntity<String>  validarRequisicaoHTTP(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O Body da requisição não pode estar vazia");
    }

    @ExceptionHandler(CampoPreenchimento.class)
    public static ResponseEntity<String> validarCorpo(CampoPreenchimento e) {
        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }

}
