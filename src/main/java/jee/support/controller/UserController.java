package jee.support.controller;

import jee.support.constants.Constants;
import jee.support.entity.Ticket;
import jee.support.entity.User;
import jee.support.service.TicketService;
import jee.support.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    TicketService ticketService;
    @RequestMapping(value = "/user/add" ,method = RequestMethod.POST)
    protected  String add(Ticket  ticket,
                          HttpServletRequest request,
                          Model model,
                          HttpSession session){

        List attachmentList = null;
        User user = (User)session.getAttribute(Constants.SESSION_USER);
        System.out.println(user.getUserId());
        ticket.setUser(user);
        ticket.setAttachments(attachmentList);
        long id=this.ticketService.addTicket(ticket);
        System.out.println(id);
        return "123456";
    }

}
