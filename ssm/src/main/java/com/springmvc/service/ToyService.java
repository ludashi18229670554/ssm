package com.springmvc.service;

import com.springmvc.dao.ToyMapper;
import com.springmvc.pojo.Toy;
import com.springmvc.util.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class ToyService {
    @Resource(name = "toyMapper")
    private ToyMapper toyMapper;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int add(Toy toy) {
        return toyMapper.add(toy);
    }

    public Pager<Toy> find(Integer page, Integer rows, String sort, String order, String name) {
        Pager<Toy> pager = new Pager<>();
        pager.setRows(toyMapper.findPager(page, rows, sort, order, name));
        pager.setTotal(toyMapper.getTotal(name));
        return pager;
    }
    public List<Toy> findByParam(String name,Date beginDate,Date endDate){
        return toyMapper.findByParam(name, beginDate, endDate);
    }

    public int modify(Toy toy){
        return toyMapper.modify(toy);
    }
    public int remove(Integer id){
        return toyMapper.remove(id);
    }
    public Toy findById(Integer id){
        return toyMapper.findById(id);
    }
}