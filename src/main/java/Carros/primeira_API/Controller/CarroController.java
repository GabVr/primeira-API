package Carros.primeira_API.Controller;

import Carros.primeira_API.Model.Carro;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/carro")
public class CarroController {

   private List<Carro> listaCarros = new ArrayList<>();

    @PostMapping
    public Carro criarCarro(@RequestBody Carro carro) {
         this.listaCarros.add(carro);
         return carro;
    }

    @GetMapping
    public  List<Carro> pegarListaCarros() {
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
    public String removerCarro(@PathVariable String modelo) {

        boolean remover = listaCarros.removeIf(carro -> carro.getModelo().equalsIgnoreCase(modelo));

        if (remover){
            return "Carro removido com sucesso!";
        }
        throw new RuntimeException("Carro não encontrado");
    }
}