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
    private UserService userService;//ע��ҵ��ӿ�
    
    /**
     * �û��б�
     */
    @RequestMapping(value="/userList.do")
    public String userList(ModelMap modelMap) {
        LOG.info("�����û��б�");
        //��ӡһ�仰���ԣ��������ݿ���
        return "user/userList"; //����SpringMVC�����ļ���õ�ǰ׺�ͺ�׺���Զ�תΪ��/WEB-INF/jsp/user/userList.jsp
    }
    
    /**
     * �������������û�
     */
    @RequestMapping(value="/getUserById.do")
    public String getUserById(@RequestParam long id) {
        LOG.info("id is :"+id);
        UserInfo userInfo = userService.getById(UserInfo.class,id);
        LOG.info("user's name is :"+userInfo.getName());
        return "user/userList";
    }
    
    /**
     * �����û�
     */
    @RequestMapping(value="/saveUser.do")
    public String saveUser(UserInfo userInfo,RedirectAttributes redirectAttributes) {
        LOG.info("�����û�");
        userService.save(userInfo);
        //�ض�������ʾ��Ϣ��ʹ��RedirectAttributes���ݣ���JSPҳ�������${message}��ȡ
        //��ʾ��Ϣֻ����һ�Σ�ˢ��Ҳ�����ظ���ʾ��
        redirectAttributes.addFlashAttribute("message", "�����ɹ�");
        
        //�ض��򣬷�ֹ���ظ��ύ
        return "redirect:userList.do";//����ڵ�ǰ·��  
        //return "redirect:/user/userList.do";//����ڵ�ǰ��Ŀ��·��
    }
    

}