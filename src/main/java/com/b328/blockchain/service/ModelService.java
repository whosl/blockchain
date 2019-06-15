package com.b328.blockchain.service;

import com.b328.blockchain.entity.Model;
import com.b328.blockchain.mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class ModelService implements IModelService{
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Model getModelById(Integer id){
        return modelMapper.getModelById(id);
    }
}
