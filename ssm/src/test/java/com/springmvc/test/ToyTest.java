package com.springmvc.test;

import com.springmvc.pojo.Toy;
import com.springmvc.service.ToyService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class ToyTest {
    private ToyService toyService;
    @Before
    public void init(){
        ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
        toyService=ctx.getBean("toyService",ToyService.class);
    }

    @Test
    public void testAdd(){
        Toy toy=new Toy();
        toy.setName("按摩棒");
        toy.setPrice(999d);
        toy.setCreateDate(new Date());
        int count =toyService.add(toy);
        System.out.println(count);
    }

}
