package com.ssea.miniapp.Manager.impl;

import com.ssea.miniapp.Manager.TokenManager;
import com.ssea.miniapp.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisTokenManager implements TokenManager{
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public TokenModel createToken(String openid){
        if(openid==null||openid.length()==0){
            return null;
        }
        //官方推荐强哈希算法
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(openid);
        redisTemplate.opsForValue().set(openid,hashedPassword,12, TimeUnit.HOURS);
        return new TokenModel(openid,hashedPassword);
    }
    public boolean checkToken(TokenModel model){
        if(model==null) return false;
        String token=redisTemplate.opsForValue().get(model.getOpenid());
        if(token==null||!token.equals(model.getToken())) return false;
        //验证成功，延长token过期时间
        redisTemplate.opsForValue().getOperations().expire(model.getOpenid(),12,TimeUnit.HOURS);
        return true;
    }

    public void deleteToken(String openid) {

    }
}
