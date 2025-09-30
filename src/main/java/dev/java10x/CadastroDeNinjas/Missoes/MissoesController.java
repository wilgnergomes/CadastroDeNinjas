package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//LOCALHOST:8080/
@RestController
@RequestMapping("missoes")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return  missoesService.listarMissoes();
    }
    // POST -- Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoesModel) {
        return missoesService.criarMissoes(missoesModel);
    }

    // PUT -- Mandar uma requisição para alterar as missões
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso" ;
    }

    // GET -- Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missao deletada com sucesso" ;
    }

}
