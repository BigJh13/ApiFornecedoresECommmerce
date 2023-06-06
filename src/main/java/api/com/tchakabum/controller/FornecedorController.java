package api.com.tchakabum.controller;

import java.util.List;

import api.com.tchakabum.model.FornecedorVO;
import api.com.tchakabum.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fornecedor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FornecedorVO criarFornecedor(@RequestBody FornecedorVO fornecedorVO){
        return fornecedorService.criarFornecedor(fornecedorVO);
    }

    @GetMapping()
    public ResponseEntity<List<FornecedorVO>> listarFornecedor() {
        return ResponseEntity.status(HttpStatus.FOUND).body(fornecedorService.getFornecedores());
    }
    
    @GetMapping("/{id}")
    public FornecedorVO buscarPorId(@PathVariable Long id) {
        return fornecedorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public void editarFornecedor(@RequestBody FornecedorVO fornecedor, @PathVariable("id") Long id) {
        fornecedorService.alterarFornecedor(fornecedor, id);
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(@PathVariable("id") Long id) {
        fornecedorService.excluirFornecedor(id);
    }
}
