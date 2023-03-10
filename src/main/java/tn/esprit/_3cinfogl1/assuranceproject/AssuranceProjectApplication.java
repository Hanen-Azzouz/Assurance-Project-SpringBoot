package tn.esprit._3cinfogl1.assuranceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy

public class AssuranceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssuranceProjectApplication.class, args);
    }

}
