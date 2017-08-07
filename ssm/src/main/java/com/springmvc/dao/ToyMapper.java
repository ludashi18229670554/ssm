package com.springmvc.dao;

import com.springmvc.pojo.Toy;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository("toyMapper")
public interface ToyMapper {
    @Insert("insert into toy(name,price,create_date) values(#{name},#{price,jdbcType=DOUBLE},#{createDate,jdbcType=DATE})")
    int add(Toy toy);

    @Update("update toy set name=#{name},price=#{price,jdbcType=DOUBLE},create_date=#{createDate,jdbcType=DATE} where id=#{id}")
    int modify(Toy toy);

    @Delete("delete from toy where id=#{id}")
    int remove(Integer id);

    @Select("select id,name,price,create_date createDate from toy where id=#{id}")
    Toy findById(Integer id);

    @Select("select id,name,price,create_date createDate from toy")
    List<Toy> find();

    List<Toy> findByParam(@Param("name") String name,
                          @Param("beginDate")Date beginDate,
                          @Param("endDate")Date endDate);

    List<Toy> findPager(
            @Param("page") Integer page,
            @Param("rows") Integer rows,
            @Param("sort") String sort,
            @Param("order") String order,
            @Param("name") String name);

    int getTotal(@Param("name") String name);
}
