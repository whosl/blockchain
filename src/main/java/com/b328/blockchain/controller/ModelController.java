package com.b328.blockchain.controller;

import com.b328.blockchain.entity.Model;
import com.b328.blockchain.service.IModelService;
import com.b328.blockchain.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class ModelController {
    @Autowired
    @Qualifier("ModelService1")
    IModelService modelService;

    /**
     * 通过id检索模板信息
     * @param id
     * @return Message
     */
    @CrossOrigin
    @RequestMapping(value = "/getModel/{id}", method = RequestMethod.GET)
    public Model getMessageById(@PathVariable(name = "id") int id) {
        return modelService.getModelById(id);
    }



}
