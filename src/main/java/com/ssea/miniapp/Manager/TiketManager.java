package com.ssea.miniapp.Manager;


import com.ssea.miniapp.model.Ticket;

import java.util.List;

public interface TiketManager {
    //保存用户取号记录
    public  void addTikets(String openid,List<Ticket> tikets);
   //获取取号列表
    public List<Ticket> getTikets(String openid);
}
