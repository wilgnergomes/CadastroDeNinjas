package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String voasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //#CRUD

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId() {
        return "Mostrando todos os ID";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterando o ninja por ID";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Deletando ninja por ID";
    }
}
