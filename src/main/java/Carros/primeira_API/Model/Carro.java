package Carros.primeira_API.Model;


import Carros.primeira_API.Excecoes.CampoPreenchimento;
import org.springframework.stereotype.Service;

import Carros.primeira_API.Validacoes.*;


@Service
public class Carro {

    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private String placa;

    public  String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        ValidarCarro.validarMarca(marca);
        this.marca = marca.trim();
    }

    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
       if(this.marca == null){
            throw new CampoPreenchimento("Defina a marca antes do modelo do carro!");
        }

        ValidarCarro.validarModelo(this.marca, modelo);
        this.modelo = modelo.trim();
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        ValidarCarro.validarCor(cor);
        this.cor = cor.trim();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        ValidarCarro.validarAno(ano);
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        ValidarCarro.validarPlaca(placa);
        this.placa = placa.trim();
    }

}
