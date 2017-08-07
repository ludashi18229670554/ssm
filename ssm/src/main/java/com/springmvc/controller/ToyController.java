package com.springmvc.controller;

import com.springmvc.pojo.Toy;
import com.springmvc.service.ToyService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class ToyController {
    @Resource(name = "toyService")
    private ToyService toyService;
    @RequestMapping("list")
    public String list(@RequestParam(value = "name",required = false)String name,
                       @RequestParam(value = "beginDate",required = false)
                               @DateTimeFormat(pattern = "yyyy-MM-dd")
                               Date beginDate,
                       @RequestParam(value = "endDate",required = false)
                           @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate,
                       ModelMap modelMap){
        System.out.println(name+beginDate+endDate);
        if(name!=null) {
            name = "%" + name + "%";
        }
        List<Toy> toys=toyService.findByParam(name,beginDate,endDate);
        modelMap.put("toys",toys);
        return "list";
    }
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Toy toy){
        if(toy!=null&&toy.getId()!=null){
            toyService.modify(toy);
        }else{
            toyService.add(toy);
        }
        return "redirect:list";
    }
    @RequestMapping("findById")
    public ModelAndView finfById(@RequestParam(value = "id",required = true)Integer id){
        Toy toy=toyService.findById(id);
        ModelAndView mv=new ModelAndView("edit");
        mv.addObject("toy",toy);
        return  mv;
    }
    @RequestMapping("remove")
    public String remove(@RequestParam(value = "id",required = true)Integer id){
        toyService.remove(id);
        return "redirect:list";
    }
}
