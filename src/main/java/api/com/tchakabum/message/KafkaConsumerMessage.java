package api.com.tchakabum.message;

import api.com.tchakabum.model.FornecedorVO;
import api.com.tchakabum.service.FornecedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumerMessage {

    private final Logger LOG = (Logger) LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private FornecedorService fornecedorService;

    @KafkaListener(topics = "fornecedor-post-topic", groupId = "store-posts-group")
    public void listening(FornecedorVO fornecedorVO){
        LOG.info("informação de novo fornecedor recebido {}");
        fornecedorService.criarFornecedor(fornecedorVO);
    }
}
