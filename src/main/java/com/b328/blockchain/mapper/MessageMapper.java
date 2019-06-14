package com.b328.blockchain.mapper;

import com.b328.blockchain.entity.Message;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    /**
     * 返回所有留言
     * @return  List<Message>
     */
    @Select("SELECT * FROM Message ORDER BY id DESC")
    @Results(@Result(property = "createDate", column = "create_date"))
    List<Message> getAllMessages();

    /**
     * 通过id查找留言
     * @param id
     * @return Message
     */
    @Select("SELECT * FROM Message WHERE id = #{id}")
    Message getMessageById(Integer id);

    /**
     * 添加留言
     * @param message
     * @return int
     */
    @Insert("INSERT INTO Message(create_date, author, title, content, partyA, partyB) VALUES(#{createDate}, #{author}, #{title}, #{content}, #{partyA}, #{partyB})")
    int addMessage(Message message);

    @Update("UPDATE Message SET partyA = 1 WHERE id = #{id}")
    void pAsign(Integer id);

    @Update("UPDATE Message SET partyB = 1 WHERE id = #{id}")
    void pBsign(Integer id);

    @Select("SELECT partyA from Message WHERE id = #{id}")
    String getpartyAById(Integer id);

    @Select("SELECT partyA from Message WHERE id = #{id}")
    String getpartyBById(Integer id);

    @Select("SELECT pAsigned from Message WHERE id = #{id}")
    Integer ispAsigned(Integer id);

    @Select("SELECT pBsigned from Message WHERE id = #{id}")
    Integer ispBsigned(Integer id);
}
