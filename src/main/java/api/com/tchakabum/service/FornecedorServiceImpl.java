package api.com.tchakabum.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.com.tchakabum.entity.FornecedorEntity;
import api.com.tchakabum.exception.NaoEncontradoException;
import api.com.tchakabum.model.FornecedorVO;
import api.com.tchakabum.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService{

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public void criarFornecedor(FornecedorVO fornecedorVO) {
        FornecedorEntity fornecedorEntity = mapFornecedorVOParaEntity(fornecedorVO);
        fornecedorRepository.save(fornecedorEntity);
    }

    @Override
    public List<FornecedorVO> getFornecedores() {
        List<FornecedorVO> listaFornecedores = new ArrayList<>();
        fornecedorRepository.findAll().forEach(item->{
            listaFornecedores.add(mapFornecedorEntityParaVO(item));
        });
        return listaFornecedores;
    }
    
    @Override
    public FornecedorVO buscarPorId(Long id) {
    	FornecedorEntity fornecedor = fornecedorRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Nenhum fornecedor encontrado"));
    	return mapFornecedorEntityParaVO(fornecedor);
    }

    @Override
    public void alterarFornecedor(FornecedorVO fornecedorVO, Long id) {

        fornecedorRepository.findById(id).ifPresentOrElse(item -> {
            item.setNome(fornecedorVO.getNome());
            item.setDataAbertura(fornecedorVO.getDataAbertura());
            item.setCnpj(fornecedorVO.getCnpj());
            item.setEmail(fornecedorVO.getEmail());
            item.setRazaoSocial(fornecedorVO.getRazaoSocial());
            item.setLogradouro(fornecedorVO.getLogradouro());
            item.setCep(fornecedorVO.getCep());
            item.setNumero(fornecedorVO.getNumero());
            item.setBairro(fornecedorVO.getBairro());
            item.setEstado(fornecedorVO.getEstado());
            item.setCidade(fornecedorVO.getCidade());
        }, () -> {throw new NaoEncontradoException("Nenhum fornecedor encontrado");
        });
    }

    @Override
    public void excluirFornecedor(Long id) {
    	FornecedorEntity fornecedor = fornecedorRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Nenhum fornecedor encontrado"));
        fornecedorRepository.delete(fornecedor);
    }

    private FornecedorVO mapFornecedorEntityParaVO(FornecedorEntity fornecedorEntity) {

        return FornecedorVO.builder()
                .nome(fornecedorEntity.getNome())
                .dataAbertura(fornecedorEntity.getDataAbertura())
                .cnpj(fornecedorEntity.getCnpj())
                .email(fornecedorEntity.getEmail())
                .razaoSocial(fornecedorEntity.getRazaoSocial())
                .logradouro(fornecedorEntity.getLogradouro())
                .cep(fornecedorEntity.getCep())
                .numero(fornecedorEntity.getNumero())
                .bairro(fornecedorEntity.getBairro())
                .estado(fornecedorEntity.getEstado())
                .cidade(fornecedorEntity.getCidade())
                .build();
    }

    private FornecedorEntity mapFornecedorVOParaEntity(FornecedorVO fornecedorVO) {

        FornecedorEntity fornecedorEntity = new FornecedorEntity();

        fornecedorEntity.setNome(fornecedorVO.getNome());
        fornecedorEntity.setDataAbertura(fornecedorVO.getDataAbertura());
        fornecedorEntity.setCnpj(fornecedorVO.getCnpj());
        fornecedorEntity.setEmail(fornecedorVO.getEmail());
        fornecedorEntity.setRazaoSocial(fornecedorVO.getRazaoSocial());
        fornecedorEntity.setLogradouro(fornecedorVO.getLogradouro());
        fornecedorEntity.setCep(fornecedorVO.getCep());
        fornecedorEntity.setNumero(fornecedorVO.getNumero());
        fornecedorEntity.setBairro(fornecedorVO.getBairro());
        fornecedorEntity.setEstado(fornecedorVO.getEstado());
        fornecedorEntity.setCidade(fornecedorVO.getCidade());

        return fornecedorEntity;
    }
}
