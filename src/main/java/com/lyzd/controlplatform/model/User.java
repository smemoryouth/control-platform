package com.lyzd.controlplatform.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**description：
* @author 阿劼
* @data 2019/11/19 8:37
*/
@Component
public class User implements Serializable {

    private String userId;

    private String password;

    private String phone;

    private String userName;

    private static final long serialVersionUID = 1L;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", userName=").append(userName);
        sb.append("]");
        return sb.toString();
    }
}