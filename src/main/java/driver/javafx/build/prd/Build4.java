package driver.javafx.build.prd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Configuration: Responsavel por configurar os serviços do spring
 * @ComponentScan: Configura as diretivas de varredura.
 *
 * conta.sistema: Pacote do Hexágono
 * conta.servicos.repositorio: Pacote dos Adaptadores Secundários, ou seja, são as implementações dos repositórios.
 *
 * Build 3: Adaptador Interface Gráfica → Sistema ← Adaptadores Real em Homologação
 *          O Objetivo é homologar o sistema.
 *
 * **/

@Configuration
@EnableTransactionManagement
@ComponentScan({
        "conta.prd",
        "conta.tela",
        "conta.sistema",
        "conta.servicos.repositorio",
    })
public class Build4 {

    @Bean
    public DataSource dataSource() {
        var db = new SimpleDriverDataSource();
        db.setDriverClass(org.hsqldb.jdbcDriver.class);
        db.setUrl("jdbc:hsqldb:file:C:/CodigoCurso/Arquitetura-hexagonal-db/");
        db.setUsername("SA");
        db.setPassword("1234");
        return db;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSourceTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
