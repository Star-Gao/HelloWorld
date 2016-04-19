package com.test.entity.privilege;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * 用户信息
 */

@Entity
@Table(name="t_user_info")
public class UserInfo implements Serializable{

    private static final long serialVersionUID = -3838732995856086555L;
    
    @Id
    @SequenceGenerator(name="t_user_s",sequenceName="t_user_info_s",allocationSize=1)
    private Long id;
    
    //账号
    @Column(length=20,nullable=false)
    private String account;
    //密码
    @Column(length=20,nullable=false)
    private String password;
    //姓名
    @Column(length=32,nullable=false)
    private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
    

}