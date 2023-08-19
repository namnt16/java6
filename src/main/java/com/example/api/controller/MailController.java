package com.example.api.controller;

import com.example.api.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    private final MailService emailService;
    @Autowired
    public MailController(MailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send-email/{ten}/{email}/{sdt}/{tenphim}/{soghe}/{phong}")
    public String sendEmail(@PathVariable("ten") String ten,@PathVariable("email") String email,@PathVariable("sdt") String sdt,@PathVariable("tenphim") String tenphim,@PathVariable("soghe") String soghe,@PathVariable("phong") String phong) {
        try {
            String to = email;
            String subject = "Dat ve thanh cong";
            String content = "Chung toi xac nhan don dat ve thanh cong cua quy khach "+" Ten: "+ten+" sdt: "+ sdt+" Ten phim: "+ tenphim+" So ghe:"+soghe + " Phong:"+ phong;
            emailService.sendEmail(to, subject, content);
            return "Email sent!";

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;}
}
