package api.com.tchakabum.repository;

import api.com.tchakabum.entity.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository  extends JpaRepository<FornecedorEntity, Long> {
}
