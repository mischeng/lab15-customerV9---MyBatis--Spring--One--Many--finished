package jee.support.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jee.support.entity.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})

public class PageHelperTest {

    @Autowired
    TicketDao ticketDao;

    @Test
    public void testPageHelper() {
    PageHelper.startPage(1, 5);
    List<Ticket> list = ticketDao.findBySubjectLike("6");
    PageInfo<Ticket> pageInfo = new PageInfo<>(list);

    System.out.println("一共"+pageInfo.getPages()+"页");

    }
}

