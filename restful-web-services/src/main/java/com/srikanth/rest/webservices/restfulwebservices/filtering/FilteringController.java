package com.srikanth.rest.webservices.restfulwebservices.filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class FilteringController {

    @GetMapping("/someBean")
    public MappingJacksonValue getSomeBean(){
        SomeBean someBean = new SomeBean("Val1","Val2","Val3");
        MappingJacksonValue mappingJacksonValue =new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter someBeanPropertyFilter=SimpleBeanPropertyFilter.filterOutAllExcept("value1","value2");
        FilterProvider filters= new SimpleFilterProvider().addFilter("someBeanPropertyFilter",someBeanPropertyFilter);
        mappingJacksonValue.setFilters( filters);
        return mappingJacksonValue;
    }
    @GetMapping("/getListSomeBean")
    public MappingJacksonValue getListSomeBean(){
        List<SomeBean> list=Stream.of(new SomeBean("Val4","Val5","Val6"),new SomeBean("Val14","Val15","Val16")).collect(Collectors.toList());
        MappingJacksonValue mappingJacksonValue =new MappingJacksonValue(list);
        SimpleBeanPropertyFilter someBeanPropertyFilter=SimpleBeanPropertyFilter.filterOutAllExcept("value3");
        FilterProvider filters= new SimpleFilterProvider().addFilter("someBeanPropertyFilter",someBeanPropertyFilter);
        mappingJacksonValue.setFilters( filters);
        return mappingJacksonValue;
    }
}
