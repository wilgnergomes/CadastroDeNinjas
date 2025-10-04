package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id) {
        MissoesDTO missao = missoesService.listarMissoesPorId(id);
        if (missao == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o ID" + id + " não pertence a lista." );
        }

        return ResponseEntity.ok(missao);


    }

    @PostMapping("/criar")
    public ResponseEntity<MissoesDTO> criarMissoes(@RequestBody MissoesDTO missoesDTO) {
        MissoesDTO missao = missoesService.criarMissoes(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(missao);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {
        MissoesDTO missao = missoesService.alterarMissoesPorId(id, missaoAtualizada);
        if ( missao == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missão com o ID" + id + " não pertence a lista." );
        }

        return ResponseEntity.ok(missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissoesPorId(id);
    }

}
