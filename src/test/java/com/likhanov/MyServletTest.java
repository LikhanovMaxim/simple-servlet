package com.likhanov;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyServletTest {
    //        TODO fix this test
    @Test
    public void whenPostRequestUsingHttpClient_thenCorrect()
            throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        String nameWar = "simple-servlet/"; //TODO
        HttpGet method = new HttpGet("http://localhost:8080/" + nameWar + "hi");

        List<BasicNameValuePair> nvps = new ArrayList<>();
//        nvps.add(new BasicNameValuePair("height", String.valueOf(2)));
//        nvps.add(new BasicNameValuePair("weight", String.valueOf(80)));

//        method.setEntity(new UrlEncodedFormEntity(nvps));
        HttpResponse httpResponse = client.execute(method);


//        assertEquals("Success", ((BasicHttpResponse) ((HttpResponseProxy) httpResponse).original).code);
        assertEquals("Success", httpResponse.getHeaders("Test")[0].getValue());
        assertEquals("20.0", httpResponse.getHeaders("BMI")[0].getValue());
    }
}
