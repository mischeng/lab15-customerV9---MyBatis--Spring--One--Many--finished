package jee.support.service;

import jee.support.entity.Ticket;
import jee.support.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
//加载配置文件
public class TicketServiceTest {

    @Autowired
    TicketService ticketService;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getTicket() {
        ticketService.getTicket(30);
    }

    @Test
    public void addTicket() {
        Ticket ticket = new Ticket();
//        设置用户信息
        User user = new User();
        user.setUserId(4);
        ticket.setUser(user);
        ticket.setBody("tst");
        ticket.setSubject("subje");
        ticket.setMoney(3333.9f);
        ticket.setType("type");
        ticket.setDateCreated(new Date());
        System.out.println(ticketService.addTicket(ticket));
    }

        @Test
    public  void delTicket(){
        int res = ticketService.delTicket(45);
        assertEquals(res, 1);
    }

    @Test
    public  void getTicketList(){

    }

    @Test
    public  void updateTicket(){
        Ticket ticket = new Ticket();
      //  ticket.setUserId(10);
        ticket.setBody("test updated body");
        ticket.setSubject("subje");
        ticket.setMoney(3333.9f);
        ticket.setType("type");
        long   id = 36;
        ticketService.updateTicket(id, ticket);
        assertEquals(ticketService.getTicket(id).getBody(), "test updated body");
    }

    @Test
    public void findSubjectLike(){
        List<Ticket> list = ticketService.findBySubjectLike("6");
        list.forEach(s->System.out.println(s));
    }

}