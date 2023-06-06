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
    private String nome;
    private LocalDate dataAbertura; 
    private String cnpj;
    private String email;
    private String razaoSocial;
    private String logradouro;
    private String cep;
    private String numero;
    private String bairro;
    private String estado;
    private String cidade;
}
