package com.srikanth.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorld {

    private MessageSource messageSource;

    public HelloWorld(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    //@RequestMapping( method= RequestMethod.GET,path = "hello-world")
    @GetMapping(path = "hello-world")
    public String getMessage(){
        return "Hello World";
    }

    @GetMapping(path = "hello-world-bean")
    public HelloWorldBean getBeanMessage(){
        return new HelloWorldBean("Hello world");
    }

    @GetMapping(path = "hello-world-pathvarible/users/{name}")
    public HelloWorldBean getBeanPathVariableMessage(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world %s ",name));
    }

    @GetMapping(path = "good-morning")
    public String getWisher(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);


    }
}
