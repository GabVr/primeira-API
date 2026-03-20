package Carros.primeira_API.Controller;

import Carros.primeira_API.Excecoes.CampoPreenchimento;
import Carros.primeira_API.Model.Carro;

import Carros.primeira_API.Service.ValidarCarro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/carro")
public class CarroController {

   private List<Carro> listaCarros = new ArrayList<>();



   @PostMapping
    public ResponseEntity<Carro> criarCarro(@RequestBody Carro carro) {

       ValidarCarro.validarCarroCompleto(carro);

       for (Carro c : listaCarros) {

           if (c.getPlaca().equals(carro.getPlaca())) {
               throw new CampoPreenchimento("Erro: Não pode existir 2 ou mais carros com uma mesma placa.");
           }

       }

       this.listaCarros.add(carro);
       return ResponseEntity.status(HttpStatus.CREATED).body(carro);


    }

    @GetMapping
    public  List<Carro> pegarListaCarros() {

        if(this.listaCarros.isEmpty() || this.listaCarros == null) {

            throw new CampoPreenchimento("Nenhum carro encontrado! ou a sua lista está vazia.");
        }

        return this.listaCarros;
    }

    @GetMapping("/modelo/{modelo}")
    public Carro buscarModelo(@PathVariable String modelo) {

          for (Carro carro : this.listaCarros) {
             if (carro.getModelo().equalsIgnoreCase(modelo)) {
                 return carro;
            }
          }
        throw new RuntimeException("Não foi possível encontrar o seu carro com base no modelo");
    }

    @GetMapping("/ano/{ano}")
    public Carro buscarPorAno(@PathVariable int ano) {

        for (Carro carro : this.listaCarros) {
            if (carro.getAno() == ano) {
                return carro;
            }
        }
        throw new RuntimeException("Não foi possível encontrar o seu carro com base no ano");
    }

    @PutMapping("/ano/{ano}")
    public Carro atualizarCarroPorAno(@PathVariable int ano,@RequestBody Carro carro) {

        for (int i = 0; i < this.listaCarros.size(); i++) {
                if (this.listaCarros.get(i).getAno() == ano) {
                    listaCarros.set(i, carro);
                    return carro;
                }
        }
        throw new RuntimeException("Não foi possível atualizar o seu carro com base no ano");
    }



    @PutMapping("/modelo/{modelo}")
    public Carro atualizarCarroPorModelo(@PathVariable String modelo,@RequestBody Carro carro) {

        for (int i=0; i<this.listaCarros.size(); i++) {
                if (this.listaCarros.get(i).getModelo().equalsIgnoreCase(modelo)) {
                    listaCarros.set(i, carro);
                    return carro;
                }
        }
        throw new RuntimeException("Não foi possível atualizar o seu carro com base no modelo");
    }

    @DeleteMapping("/modelo/{modelo}")
    public ResponseEntity<String> removerCarro(@PathVariable String modelo) {

        boolean remover = listaCarros.removeIf(carro -> carro.getModelo().equalsIgnoreCase(modelo));

        if (remover){
            return ResponseEntity.status(HttpStatus.OK).body("Carro removido com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Carro não foi encontrado para ser removido!");
    }
}