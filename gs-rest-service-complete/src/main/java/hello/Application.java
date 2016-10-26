package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	ApplicationContext context =
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
        SpringApplication.run(Application.class, args);
//         test code to make sure database runs


    }
}
