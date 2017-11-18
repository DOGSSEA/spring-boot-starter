package com.ssea.miniapp.Manager.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssea.miniapp.Manager.TiketManager;
import com.ssea.miniapp.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisTiketManager implements TiketManager {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    public void addTikets(String openid, List<Ticket> tikets) {
         if(openid==null||openid.length()==0||tikets==null) return;
         Gson gson = new Gson();
        redisTemplate.opsForValue().set(openid,gson.toJson(tikets),12, TimeUnit.HOURS);
    }

    public List<Ticket> getTikets(String openid) {
        if(openid==null||openid.length()==0) return null;
        Gson gson=new Gson();
        List<Ticket> tickets=null;
        String listJson=redisTemplate.opsForValue().get(openid);
        if(StringUtils.isEmpty(listJson)) return null;
        return  gson.fromJson(listJson,new TypeToken<List<Ticket>>(){}.getType());
    }
}
