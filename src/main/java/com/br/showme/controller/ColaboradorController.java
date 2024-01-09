package com.br.showme.controller;

import com.br.showme.model.Colaborador;
import com.br.showme.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController {
/* testes do git */

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public List<Colaborador> obterTodosColaboradores() {
        return colaboradorService.obterTodosColaboradores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> obterColaboradorPorId(@PathVariable Long id) {
        Optional<Colaborador> colaborador = colaboradorService.obterColaboradorPorId(id);
        return colaborador.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Colaborador> adicionarColaborador(@RequestBody Colaborador colaborador) {
        Colaborador novoColaborador = colaboradorService.adicionarColaborador(colaborador);
        return ResponseEntity.ok(novoColaborador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirColaborador(@PathVariable Long id) {
        colaboradorService.excluirColaborador(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> editarColaborador(@PathVariable Long id, @RequestBody Colaborador novoColaborador) {
        Colaborador colaboradorEditado = colaboradorService.editarColaborador(id, novoColaborador);
        if (colaboradorEditado != null) {
            return ResponseEntity.ok(colaboradorEditado);
        }
        return ResponseEntity.notFound().build();
    }
}
