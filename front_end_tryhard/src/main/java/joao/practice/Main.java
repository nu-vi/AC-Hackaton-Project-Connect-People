package joao.practice;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Main {



    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Customer customer = mapper.readValue(new URL("http://localhost:8080/javabank4/api/customer/1"), Customer.class);

    }
}
