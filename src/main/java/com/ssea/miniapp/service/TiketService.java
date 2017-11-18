package com.ssea.miniapp.service;

import com.ssea.miniapp.Manager.impl.RedisTiketManager;
import com.ssea.miniapp.repository.TicketReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.ssea.miniapp.model.Ticket;

@Service
public class TiketService {
    @Autowired
    TicketReposity ticketReposity;
    @Autowired
    RedisTiketManager redisTiketManager;
    public List<Ticket> getTikets(String openid){
           //先从redis中读取
           if(openid==null||openid.length()==0) return null;
           List<Ticket> tickets=redisTiketManager.getTikets(openid);
           if(tickets!=null) return tickets;
           //不存在则到Mysql中读取
           tickets=ticketReposity.findByOpenid(openid);
           if(tickets!=null)
               redisTiketManager.addTikets(openid,tickets);
           return tickets;
    }
}
