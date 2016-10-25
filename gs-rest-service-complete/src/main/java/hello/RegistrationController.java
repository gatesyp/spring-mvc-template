package hello;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public Response registerUser(@RequestParam Map<String,String> req) {
        User user = new User(counter.incrementAndGet(),
                            req.get("first"), req.get("last"), req.get("email"), 
                            req.get("age"), Double.parseDouble(req.get("height")), 
                            Double.parseDouble(req.get("weight")), Double.parseDouble(req.get("bmi"))
                            );
        updateDatabase(user);
        
        return new Response(counter.get(), "200");
    }
    
    void updateDatabase(User user){
    	
    }
}
