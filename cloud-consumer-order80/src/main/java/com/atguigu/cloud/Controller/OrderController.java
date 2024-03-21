package com.atguigu.cloud.Controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: CC
 * @Description:
 * @Date: 17:36 2024/3/19
 */
@RestController
public class OrderController {
//    public static final String PaymentSrv_URL="http://localhost:8001";
    public static final String PaymentSrv_URL="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO, ResultData.class);
    }

    @DeleteMapping(value = "/consumer/pay/del/{id}")
    public ResultData delOrder(@PathVariable("id") Integer id){
        return restTemplate.exchange(PaymentSrv_URL+"/pay/del/"+id,HttpMethod.DELETE,null, ResultData.class,id).getBody();
    }

    @PutMapping(value = "/consumer/pay/update")
    public ResultData updateOrder(@RequestBody PayDTO payDTO){
//        return restTemplate.exchange(PaymentSrv_URL+"/pay/update",HttpMethod.PUT,null,ResultData.class);
        return null;
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id, ResultData.class,id);

    }

}
