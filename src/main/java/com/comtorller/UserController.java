package com.comtorller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.dao.Iuserdao;
import com.pojo.User;
import com.service.user.Iuserservice;
import com.util.Message;
import com.util.MyUtil;
import com.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ld on 2019/3/26.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    Iuserservice iuserservice;
    @GetMapping("login")
    public String login(){
        return "user/login";
    }
    @PostMapping("login")
    @ResponseBody
    public Message dologin(User user, HttpServletResponse response,HttpSession session,String code) throws IOException {
        //判断登陆信息
        Message message=null;
        User login=iuserservice.login(user);
        if(login==null)
            message=new Message(0,"用户名不存在"); //ajax将返回结果放到message中接收
        else {
            if(!user.getPassword().equals(login.getPassword())) {
                message = new Message(0, "密码错误");
            } else{
                if(session.getAttribute("char")==null) {
                    message = new Message(0, "登录超时");
                } else {
                    String img=session.getAttribute("char").toString();
                    if(!img.equalsIgnoreCase(code))
                        message=new Message(0,"验证码输入错误");
                    else
                        message=new Message(1,"登录成功");
                }
            }
        }
        return message;
    }
    @GetMapping("img")
    public void getimg(HttpServletResponse response, HttpSession session) throws IOException {
        char[] chars= MyUtil.getStr();
        BufferedImage img=new BufferedImage(100,43,BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = img.createGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0,0,100,43);
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font("微软雅黑", Font.BOLD,32));
        graphics.drawString(new String(chars),10,25);
        session.setAttribute("char",new String(chars));
        ImageIO.write(img,"JPG",response.getOutputStream() );
    }
    @GetMapping("index")
    public  String goindex(){
        return  "user/index";
    }
    @GetMapping("list")
    public  String list(ModelMap modelMap){
        return "user/list";
    }
    @GetMapping("getList")
    @ResponseBody
    public Message getlist(User user){
        return new Message(1,iuserservice.list(user)) ;
    }
}
