package com.ssea.miniapp.model;

import javax.persistence.*;

/* 用户提交的信息表*/
@Entity
@Table(name = "user")
public class User {

    //用户id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "openid")
    private long id;
    private String name;
    private String[] phones;
    private String idCard;

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setPhone(String[] phones) {
        this.phones = phones;
    }

    public String[] getPhone() {
        return this.phones;
    }
}
