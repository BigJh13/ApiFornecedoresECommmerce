package api.com.tchakabum.service;

import api.com.tchakabum.model.FornecedorVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FornecedorService {

    void criarFornecedor(FornecedorVO fornecedorVO);

    List<FornecedorVO> getFornecedores();

    void alterarFornecedor(FornecedorVO fornecedorVO, Long id);

    void excluirFornecedor(Long id);

}
