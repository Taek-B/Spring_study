package com.myspring.pro28.ex03;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*@Controller*/
@EnableAsync
public class MailController {
    @Autowired
    private MailService mailService;
 
    @RequestMapping(value = "/sendMail.do", method = RequestMethod.GET)
    public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) 
                                                          throws Exception{
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        mailService.sendMail("gkdns1004@gmail.com","테스트 메일_택부_임의로 구글로보내기","안녕하세요.택부_보낸 메일 내용입니다.");
        mailService.sendPreConfiguredMail("미리 설정된 주소 네이버로 보내기. 택부택부 테스트 메일입니다.");
        out.print("메일을 보냈습니다!!");
    }
}


