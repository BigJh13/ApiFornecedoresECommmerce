package api.com.tchakabum.controller;

import api.com.tchakabum.model.FornecedorVO;
import api.com.tchakabum.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity criarFornecedor(@RequestBody FornecedorVO fornecedorVO){
        fornecedorService.criarFornecedor(fornecedorVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<FornecedorVO>> listarFornecedor() {
        return ResponseEntity.status(HttpStatus.FOUND).body(fornecedorService.getFornecedores());
    }

    @PutMapping("/{id}")
    public ResponseEntity editarFornecedor(@RequestBody FornecedorVO fornecedorVO, @PathVariable("id") Long id) {
        fornecedorService.alterarFornecedor(fornecedorVO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFornecedor(@PathVariable("id") Long id) {
        fornecedorService.excluirFornecedor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
