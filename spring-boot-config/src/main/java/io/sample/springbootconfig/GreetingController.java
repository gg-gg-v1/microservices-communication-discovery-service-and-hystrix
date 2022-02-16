package io.sample.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class GreetingController {

    @Value("${my.greeting:default value}")
    private String greetingMessage;

    @Value("some direct message")
    private String message;

    @Value("${my.list.values}")
    private List<String> listValue;

    @Value("${dbValues}")
    private String dbValues;

    @Autowired
    private DbSettings dbSettings;

    public GreetingController(){

    }

    @GetMapping("/greeting")
    public String getGreetingMessage() {
        return greetingMessage+message+listValue+dbValues;
    }

    @GetMapping("/greeting2")
    public String getGreetingMessage2() {
        return dbSettings.getConnection()+dbSettings.getHost();
    }

}
