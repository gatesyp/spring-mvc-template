package hello;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private static final String template = "Hello, %s!";
    @Autowired
    private ApplicationContext context;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public Response registerUser(@RequestParam Map<String,String> req) {
    	
    	System.out.println("IN REGISTER API");
//    	System.out.println(req.containsValue(24));
//    	System.out.println(req.toString());

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

}
