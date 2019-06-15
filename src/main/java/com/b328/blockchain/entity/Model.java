package com.b328.blockchain.entity;

public class Model {
    /**
     * 模板id
     */
    private Integer id;
    /**
     * 模板标题
     */
    private String title;
    /**
     * 模板内容
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
