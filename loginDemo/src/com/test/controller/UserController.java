package com.test.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.entity.privilege.UserInfo;
import com.test.service.privilege.UserService;


/**
 * User Controller
 */

@Controller
@RequestMapping(value="/user")
public class UserController {
    
    private static final Log LOG = LogFactory.getLog(UserController.class);
    
    
    @Autowired
    private UserService userService;//注入业务接口
    
    /**
     * 用户列表
     */
    @RequestMapping(value="/userList.do")
    public String userList(ModelMap modelMap) {
        LOG.info("访问用户列表");
        //打印一句话测试，不查数据库了
        return "user/userList"; //根据SpringMVC配置文件配好的前缀和后缀，自动转为：/WEB-INF/jsp/user/userList.jsp
    }
    
    /**
     * 根据主键查找用户
     */
    @RequestMapping(value="/getUserById.do")
    public String getUserById(@RequestParam long id) {
        LOG.info("id is :"+id);
        UserInfo userInfo = userService.getById(UserInfo.class,id);
        LOG.info("user's name is :"+userInfo.getName());
        return "user/userList";
    }
    
    /**
     * 保存用户
     */
    @RequestMapping(value="/saveUser.do")
    public String saveUser(UserInfo userInfo,RedirectAttributes redirectAttributes) {
        LOG.info("保存用户");
        userService.save(userInfo);
        //重定向后的提示信息，使用RedirectAttributes传递，在JSP页面可以用${message}获取
        //提示信息只出现一次，刷新也不会重复提示，
        redirectAttributes.addFlashAttribute("message", "操作成功");
        
        //重定向，防止表单重复提交
        return "redirect:userList.do";//相对于当前路径  
        //return "redirect:/user/userList.do";//相对于当前项目根路径
    }
    

}