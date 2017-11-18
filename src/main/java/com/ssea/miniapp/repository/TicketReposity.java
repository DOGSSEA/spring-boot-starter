package com.ssea.miniapp.repository;

import com.ssea.miniapp.model.Ticket;
import com.ssea.miniapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TicketReposity  extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
      List<Ticket> findByOpenid(String openid);
}
