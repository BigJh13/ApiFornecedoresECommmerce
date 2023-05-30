package api.com.tchakabum.service;

import api.com.tchakabum.entity.FornecedorEntity;
import api.com.tchakabum.model.FornecedorVO;
import api.com.tchakabum.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
    public void alterarFornecedor(FornecedorVO fornecedorVO, Long id) {

        fornecedorRepository.findById(id).ifPresentOrElse(item -> {
            item.setNomeFornecedor(fornecedorVO.getNomeFornecedor());
            item.setDataAbertura(fornecedorVO.getDataAbertura());
            item.setCnpj(fornecedorVO.getCnpjFornecedor());
            item.setEmail(fornecedorVO.getEmailFornecedor());
            item.setRazaoSocial(fornecedorVO.getRazaoSocial());
            item.setLogradouro(fornecedorVO.getLogradouro());
            item.setCep(fornecedorVO.getCep());
            item.setNumero(fornecedorVO.getNumero());
            item.setBairro(fornecedorVO.getBairro());
            item.setEstado(fornecedorVO.getEstado());
            item.setCidade(fornecedorVO.getCidade());
        }, ()->{
            throw new NoSuchElementException();
        });
    }

    @Override
    public void excluirFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }

    private FornecedorVO mapFornecedorEntityParaVO(FornecedorEntity fornecedorEntity) {

        return FornecedorVO.builder()
                .nomeFornecedor(fornecedorEntity.getNomeFornecedor())
                .dataAbertura(fornecedorEntity.getDataAbertura())
                .cnpjFornecedor(fornecedorEntity.getCnpj())
                .emailFornecedor(fornecedorEntity.getEmail())
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

        fornecedorEntity.setNomeFornecedor(fornecedorVO.getNomeFornecedor());
        fornecedorEntity.setDataAbertura(fornecedorVO.getDataAbertura());
        fornecedorEntity.setCnpj(fornecedorVO.getCnpjFornecedor());
        fornecedorEntity.setEmail(fornecedorVO.getEmailFornecedor());
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
