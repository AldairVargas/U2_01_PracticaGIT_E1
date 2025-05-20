package mx.edu.utez.automoviles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutomovilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomovilesApplication.class, args);
        System.out.println("🚗 Servidor Automóviles iniciado correctamente en http://localhost:8080");
    }

}
