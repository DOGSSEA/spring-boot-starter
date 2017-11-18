package com.ssea.miniapp.model;

public class TokenModel {
    private String openid;
    private String token;
    public  TokenModel(String openid,String token){
        this.openid=openid;
        this.token=token;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
