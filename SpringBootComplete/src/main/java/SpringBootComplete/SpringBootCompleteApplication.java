package SpringBootComplete;

import SpringBootComplete.domain.Cliente;
import SpringBootComplete.repository.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@Configuration
@EnableJpaRepositories
@EntityScan
@ComponentScan
public class SpringBootCompleteApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootCompleteApplication.class);
	
	@Autowired
	private IClienteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCompleteApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication");
		Cliente cliente = createCliente();
		repository.save(cliente);
		
	}
	
	private Cliente createCliente(){
		return Cliente.builder()
				.cidade("Belo Horizonte")
				.cpf(8874L)
				.end("Rua da Bahia")
				.email("Teste@teste.com")
				.estado("MG")
				.nome("Pedro Henrique")
				.numero(512)
				.tel(3482L)
				.build();
	}

}
