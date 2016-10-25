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
        // test code to make sure database runs
        // change Spring-Datasource to point at cesl database
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");

        User user = new User(1, "mkyong","lastname","myemail", "age231", 23.2, 22.3, 94.23);
        userDAO.insert(user);

        User user1 = userDAO.findByUserId(1);
        System.out.println(user1);
    }
}
