package br.com.springboot.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author devel
 * classe responsavel por iniciar o projeto spring
 * nela informamaos que o SpringBoot ira gerenciar o projeto	
 */
@SpringBootApplication
public class Configuracao {
	
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
	
//	@Bean
//	public DataSource dataSource(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
//	    dataSource.setUsername("root");
//	    dataSource.setPassword("admin");
//	    return dataSource;
//	}
}
