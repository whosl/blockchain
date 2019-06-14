package com.b328.blockchain.service;

import com.b328.blockchain.mapper.MessageMapper;
import com.b328.blockchain.entity.Message;
import com.b328.blockchain.result.Result;
import com.b328.blockchain.result.ResultCode;
import com.b328.blockchain.result.ResultFactory;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Qualifier("MessageService1")
public class MessageService implements IMessageService {
    @Autowired
    MessageMapper messageMapper;

    /**
     * 向前端返回消息页面
     * @param pageNum
     * @param pageSize
     * @return List<Message>
     */
    @Override
    public List<Message> getMessagePage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Message> messages = messageMapper.getAllMessages();
        return messages;
    }

    /**
     * 通过id查找留言信息
     * @param id
     * @return message
     */
    @Override
    public Message getMessageById(Integer id) {
        Message message = messageMapper.getMessageById(id);
        if(messageMapper.ispAsigned(id) == 1)message.setpAsigned(true);
        else message.setpAsigned(false);
        if(messageMapper.ispBsigned(id) == 1)message.setpBsigned(true);
        else message.setpBsigned(false);
        return message;
    }

    /**
     * 向message表中添加一条数据
     * @param message
     * @return int
     */
    @Override
    public int addMessage(Message message) {
        message.setCreateDate(new Timestamp(new Date().getTime()));
        return messageMapper.addMessage(message);
    }

    @Override
    public Result signContract(String username, Integer id){
        if(messageMapper.getpartyAById(id).equals(username)){//is partyA
            if(messageMapper.ispAsigned(id)==1){ //signed
               return ResultFactory.buildFailResult(ResultCode.HaveExist);
            }else{
                messageMapper.pAsign(id);
            }
        }else if(messageMapper.getpartyBById(id).equals(username)){//is partyB
            if(messageMapper.ispBsigned(id)==1){ //signed
                return ResultFactory.buildFailResult(ResultCode.HaveExist);
            }else{
                messageMapper.pBsign(id);
            }
        }
        return ResultFactory.buildSuccessResult(ResultCode.SUCCESS);
    }

}
