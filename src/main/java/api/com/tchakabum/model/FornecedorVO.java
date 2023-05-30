package api.com.tchakabum.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude
public class FornecedorVO {

    private Long id;
    private String nomeFornecedor;
    private LocalDate dataAbertura;
    private String cnpjFornecedor;
    private String emailFornecedor;
    private String razaoSocial;
    private String logradouro;
    private String cep;
    private String numero;
    private String bairro;
    private String estado;
    private String cidade;
}
