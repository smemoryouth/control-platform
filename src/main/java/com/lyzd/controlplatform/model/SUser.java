package com.lyzd.controlplatform.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/** description：
* @author 阿劼
* @data 2019/11/26 14:53
*/
@Component
public class SUser implements Serializable {
    private Integer id;

    private String name;

    private String office;

    private String group;

    private Date registrationTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", office=").append(office);
        sb.append(", group=").append(group);
        sb.append(", registrationTime=").append(registrationTime);
        sb.append("]");
        return sb.toString();
    }
}