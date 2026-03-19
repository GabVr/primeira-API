package Carros.primeira_API.Excecoes;

public class CampoPreenchimento extends RuntimeException {
    public CampoPreenchimento(String message) {
        super(message);
    }
}
