package hello;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController implements ApplicationContextAware {

    @Autowired
    private static ApplicationContext context;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public Response registerUser(@RequestParam Map<String,String> req) {
    	
    	context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    	System.out.println(req.get("first"));
        User user = new User(counter.incrementAndGet(),
                            req.get("first"), req.get("last"), req.get("email"), 
                            req.get("age"), Double.parseDouble(req.get("height")), 
                            Double.parseDouble(req.get("weight")), Double.parseDouble(req.get("bmi"))
                            );

        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        userDAO.insert(user);

        User user1 = userDAO.findByUserId(1);
        System.out.println(user1);
        
        return new Response(counter.get(), "200");
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }
    
	@Override
	public void setApplicationContext(ApplicationContext ac) throws BeansException {
		this.context = ac;
	}

}
