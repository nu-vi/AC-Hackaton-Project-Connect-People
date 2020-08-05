package joao.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.URL;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showCustomer(@PathVariable Integer id, Model model) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Customer customer1 = mapper.readValue(new URL("http://localhost:8080/javabank4/api/customer/" + id), Customer.class);



        model.addAttribute("customer", customer1);

        return "customer/show";
    }

}
