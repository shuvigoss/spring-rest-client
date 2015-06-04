package com.github.bingoohuang.springrestclient.spring;

import com.github.bingoohuang.springrestclient.annotations.CreateClassFileForDiagnose;
import com.github.bingoohuang.springrestclient.annotations.SpringRestClientEnabled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringRestClientEnabled
@CreateClassFileForDiagnose
@RequestMapping("/another")
public interface AnotherApi {
    @RequestMapping("/add")
    int add(@RequestParam("offset") int offset);
}
