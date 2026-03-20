package Carros.primeira_API.Service;

import Carros.primeira_API.Excecoes.CampoPreenchimento;
import Carros.primeira_API.Model.Carro;

import java.time.LocalDate;
import java.util.*;

public class ValidarCarro {

    public static void validarMarca(String marca) {
        if(marca == null || marca.trim().isEmpty()) {
            throw new CampoPreenchimento("Você deve digitar a marca do carro!");
        }

        String marcaEscolhida= marca.trim();

        if(MarcaCarro.validarMarcaCarro(marcaEscolhida)) {
            MarcaCarro.valueOf(marcaEscolhida.toUpperCase());
        }
        else{
            throw new CampoPreenchimento("Marca do carro inválida!");
        }
    }

    public static void validarModelo(String marca, String modelo) {
        if(modelo == null || modelo.trim().isEmpty()) {
            throw new CampoPreenchimento("Você deve digitar a modelo do carro!");
        }

        String meuModelo = modelo.trim();
        String marcaFormatada = marca.trim().toUpperCase();

        Map<String, List<String>> meusVeiculos = new HashMap<>();

        meusVeiculos.put("CHEVROLET", Arrays.asList("Onix","Onix Plus","Tracker","Spin","Montana","S10","Equinox"));
        meusVeiculos.put("FIAT", Arrays.asList("Strada","Argo","Mobi","Pulse","Fastback","Toro","Cronos"));
        meusVeiculos.put("VOLKSWAGEN", Arrays.asList("Polo","Virtus","T-Cross","Nivus","Taos","Saveiro"));
        meusVeiculos.put("TOYOTA", Arrays.asList("Corolla","Corolla Cross","Hilux","Yaris","SW4"));
        meusVeiculos.put("HYUNDAI", Arrays.asList("HB20","HB20S","Creta","Tucson","Santa Fe"));
        meusVeiculos.put("JEEP", Arrays.asList("Renegade","Compass","Commander","Wrangler"));
        meusVeiculos.put("NISSAN", Arrays.asList("Kicks","Versa","Sentra","Frontier","Leaf"));
        meusVeiculos.put("RENAULT", Arrays.asList("Kwid","Duster","Oroch","Sandero","Logan"));
        meusVeiculos.put("FORD", Arrays.asList("Ranger","Maverick","Territory","Mustang","Bronco"));
        meusVeiculos.put("BMW", Arrays.asList("Serie 1","Serie 3","X1","X3","X5","iX"));
        meusVeiculos.put("BYD", Arrays.asList("Dolphin","Dolphin Mini","Song Plus","Yuan Plus","Seal"));
        meusVeiculos.put("HONDA", Arrays.asList("Civic","City","HR-V","WR-V","ZR-V"));
        meusVeiculos.put("PEUGEOT", Arrays.asList("208","2008","3008","Partner"));
        meusVeiculos.put("SUBARU", Arrays.asList("Impreza","XV","Forester","Outback"));
        meusVeiculos.put("SUZUKI", Arrays.asList("Jimny","Vitara","S-Cross","Swift"));
        meusVeiculos.put("KIA", Arrays.asList("Picanto","Rio","Cerato","Sportage","Seltos"));
        meusVeiculos.put("CITROEN", Arrays.asList("C3","C3 Aircross","C4 Cactus","Jumpy"));

        if(!meusVeiculos.containsKey(marcaFormatada)) {
            throw new CampoPreenchimento("O modelo do carro não é compatível! ou nem existem");
        }

        boolean modeloValido = meusVeiculos.get(marcaFormatada).stream().anyMatch(m -> m.equalsIgnoreCase(meuModelo));

        if(!modeloValido) {
            throw new CampoPreenchimento("Modelo não pertence a marca respectivamente!");
        }
    }

    public static void validarCor(String cor) {
        if(cor == null || cor.trim().isEmpty()) {
            throw new CampoPreenchimento("Você deve digitar a cor do carro! ");
        }

        String corEscolhida= cor.trim();

        if(CorCarro.validarCorCarro(corEscolhida)) {
            CorCarro.valueOf(corEscolhida.toUpperCase());
        }
        else{
            throw new CampoPreenchimento("Cor inválida para o carro!");
        }
    }

    public static void validarAno(int ano) {

        int anoSelecionada = LocalDate.now().getYear();

        if(ano <= 0) {
            throw new CampoPreenchimento("Erro: o ano não pode ser igual ou menor que 0!");
        }

        if(ano > anoSelecionada) {
               throw new CampoPreenchimento("Erro:Esse ano não pode ser maior que o ano atual!!");
        }

    }

    public static void validarPlaca(String placa) {
        if(placa==null ||placa.trim().isEmpty()) {
            throw new CampoPreenchimento("Você deve digitar a placa do carro!");
        }
        placa= placa.trim();

        if(!placa.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}|[A-Z]{3}[0-9]{4}")){
            throw new CampoPreenchimento("A placa do seu carro não segue os Padrões do MercoSul");
        }

    }

    public static void validarCarroCompleto(Carro carro){

       validarMarca(carro.getMarca());
       validarModelo(carro.getMarca(),carro.getModelo());
       validarCor(carro.getCor());
       validarAno(carro.getAno());
       validarPlaca(carro.getPlaca());

  }

}
