package Carros.primeira_API.Validacoes;

public enum MarcaCarro {

    CHEVROLET, FIAT, VOLKSWAGEN, TOYOTA,
    HYUNDAI, JEEP, NISSAN, RENAULT,
    FORD, BMW, BYD, HONDA, PEUGEOT, SUBARU, SUZUKI, KIA, CITROEN;

    protected static Boolean validarMarcaCarro(String marca) {

        for(MarcaCarro m : MarcaCarro.values()) {
            if(marca.equalsIgnoreCase(m.name())) {
                return true;
            }
        }
        return false;
    }
}
