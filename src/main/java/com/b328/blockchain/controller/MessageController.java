package com.b328.blockchain.controller;

import com.b328.blockchain.entity.Message;
import com.b328.blockchain.entity.vo.SignInfoVo;
import com.b328.blockchain.entity.vo.MessagePageVo;
import com.b328.blockchain.result.Result;
import com.b328.blockchain.result.ResultCode;
import com.b328.blockchain.result.ResultFactory;
import com.b328.blockchain.service.IMessageService;
import com.b328.blockchain.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class MessageController {
    @Autowired
    @Qualifier("MessageService1")
    IMessageService IMessageService;
    @Autowired
    UserService userService;


    /**
     *向前端返回消息页面
     * @param messagePageVo
     * @return PageInfo<Message>
     */
    @CrossOrigin
    @RequestMapping(value = "/getMessagePage", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<Message> getMessagePage(@RequestBody MessagePageVo messagePageVo) {
        List<Message> messages = IMessageService.getMessagePage(messagePageVo.getPageNum(), messagePageVo.getPageSize());
        PageInfo<Message> pageInfo = new PageInfo<>(messages);
        return pageInfo;
    }

    /**
     * 通过id检索留言信息
     * @param id
     * @return Message
     */
    @CrossOrigin
    @RequestMapping(value = "/getMessage/{id}", method = RequestMethod.GET)
    public Message getMessageById(@PathVariable(name = "id") int id) {
        return IMessageService.getMessageById(id);
    }

    /**
     * 添加一个留言
     * @param message
     * @return int
     */
    @CrossOrigin
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    @ResponseBody
    public Message addMessage(@RequestBody Message message) {
        if (message.getContent().equals("") || message.getTitle().equals("")||message.getPartyA().equals("")||message.getPartyB().equals("")) {
            message.setId(0);
            return message;
        }
        else if(IMessageService.addMessage(message)==0){
            message.setId(0);
            return message;
        }else {
            return message;
        }
    }

    /**
     * 签署当前合同
     * @param signInfoVo
     * @return Result
     */
    @CrossOrigin
    @RequestMapping(value = "/sign", method = RequestMethod.POST)
    @ResponseBody
    public Result sign(/*@PathVariable(name = "id") int id*/@Valid @RequestBody SignInfoVo signInfoVo) {
        return IMessageService.signContract(signInfoVo.getUser_name(),signInfoVo.getMessage_id());
    }

}
