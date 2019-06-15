package com.b328.blockchain.controller;

import com.b328.blockchain.entity.Model;
import com.b328.blockchain.service.IModelService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class ModelController {
    @Autowired
    IModelService iModelService;

    /**
     * 通过id检索模板信息
     * @param id
     * @return Message
     */
    @CrossOrigin
    @RequestMapping(value = "/getModel", method = RequestMethod.GET)
    public Model getMessageById(@PathVariable(name = "id") int id) {
        return iModelService.getModelById(id);
    }



}
