package com.github.bingoohuang.springrestclient.tests;

import com.alibaba.fastjson.JSON;
import com.github.bingoohuang.springrestclient.boot.domain.Account;
import com.github.bingoohuang.springrestclient.boot.domain.Customer;
import com.github.bingoohuang.springrestclient.boot.domain.PayParty;
import com.google.common.collect.Maps;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PostTest {
    @Test
    public void test1() throws UnirestException {
        PayParty payParty = new PayParty("s100", "b200", "p300", "n400");
        String json = JSON.toJSONString(payParty);

        HttpResponse<String> response = Unirest.post("http://localhost:4849/addParty")
                .header("Content-Type", "application/json;charset=UTF-8")
                .body(json)
                .asString();
        assertThat(response.getBody(), is(equalTo("100")));
    }

    @Test
    public void test2() throws UnirestException {


          /*
            @RequestBody @RequestParam("fromAccount") Account fromAccount,
            @RequestBody @RequestParam("actor") Customer actor,
            @RequestBody @RequestParam("toAccount") Account toAccount,
            @RequestBody @RequestParam("amount") int amount,
            @RequestParam("sendConfirmationSms") boolean sendConfirmationSms
          */

        Account fromAccount = new Account(100, "from");

        String json = JSON.toJSONString(fromAccount);
        HttpResponse<String> response = Unirest.post("http://localhost:4849/transfer")
                .header("Content-Type", "application/json;charset=UTF-8")
                .queryString("sendConfirmationSms", "true")
                .body(json)
                .asString();

        Account account = JSON.parseObject(response.getBody(), Account.class);
        assertThat(account, is(equalTo(new Account(1234, "bingoo"))));
    }
}
