package com.ssea.miniapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {
    //排队号码
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    //业务号码
    private int businessType;
    //受理窗口
    private int[] windows;

    private String openid;

    //取票时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}
