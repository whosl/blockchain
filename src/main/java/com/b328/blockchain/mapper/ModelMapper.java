package com.b328.blockchain.mapper;

import com.b328.blockchain.entity.Model;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelMapper {

    /**
     * 根据id查找模板
     * @return  List<Model>
     */
    @Select("SELECT * FROM Model WHERE id = #{id}")
    Model getModelById(Integer id);
}
