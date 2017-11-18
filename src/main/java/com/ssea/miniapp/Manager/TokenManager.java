package com.ssea.miniapp.Manager;

import com.ssea.miniapp.model.TokenModel;

public interface TokenManager {
   /*
   @param 用户的openid
   @return 包含token的类
   */
   public TokenModel  createToken(String openid);

   /*
   @param model包含token
   @return  token合法性
    */
   public boolean checkToken(TokenModel model);
   /*
    清除token
    @param 用户的openid
    */
   public void deleteToken(String openid);
}
