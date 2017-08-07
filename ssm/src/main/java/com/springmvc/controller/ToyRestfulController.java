package com.springmvc.controller;

import com.springmvc.pojo.Toy;
import com.springmvc.service.ToyService;
import com.springmvc.util.JsonDateValueProcessor;
import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class ToyRestfulController {
    @Resource(name = "toyService")
    private ToyService toyService;

    @RequestMapping(value = "toy",method = RequestMethod.POST,produces = "application/json;charset=utf-8" )
    public @ResponseBody String add(Toy toy){
        int count=toyService.add(toy);
        return String.valueOf(count);
    }

    @RequestMapping(value = "toy",method = RequestMethod.PUT,produces = "application/json;charset=utf-8" )
    public @ResponseBody String modify(Toy toy){
        int count=toyService.modify(toy);
        return String.valueOf(count);
    }

    @RequestMapping(value = "toy",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8" )
    public @ResponseBody String remove(@RequestParam(value = "id",required = true)Integer id){
        int count=toyService.remove(id);
        return String.valueOf(count);
    }

    @RequestMapping(value = "toy/{id}",method = RequestMethod.GET,produces = "application/json;charset=utf-8" )
    public
    @ResponseBody
    Toy findById(@PathVariable("id")Integer id){
        Toy toy=toyService.findById(id);
        JsonConfig jc=new JsonConfig();
        jc.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSON json = JSONSerializer.toJSON(toy,jc);
        return toy;
    }

    @RequestMapping(value = "toy",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public @ResponseBody String list(@RequestParam(value = "name",required = false)
                                                 String name,
                                     @RequestParam(value = "beginDate",required = false)
                                     @DateTimeFormat(pattern = "yyyy-MM-dd")
                                             Date beginDate,
                                    @RequestParam(value = "endDate",required = false)
                                    @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                 Date endDate){
        List<Toy> toys= toyService.findByParam(name, beginDate, endDate);
        //Gson gson=new Gson();
        //String json = gson.toJson(toys);
        JsonConfig jc=new JsonConfig();
        jc.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
        JSON json = JSONSerializer.toJSON(toys,jc);
        return json.toString();
    }
}
