package Carros.primeira_API.Validacoes;

public enum CorCarro {

    PRETO, AZUL, BRANCO, VERMELHO, AMARELO, CINZA, PRATA;

   protected static Boolean validarCorCarro(String cor){

        for (CorCarro c : CorCarro.values()){

            if(c.name().equalsIgnoreCase(cor)){
                return true;
            }
        }
        return false;
    }
}
