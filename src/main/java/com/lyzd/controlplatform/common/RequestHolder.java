package com.lyzd.controlplatform.common;

import com.lyzd.controlplatform.model.SysUser;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;



public class RequestHolder {

    private static final ThreadLocal<SysUser> userHolder = new ThreadLocal<SysUser>();
    private static final Map<String, SysUser> SYSUSER_MAP= new ConcurrentHashMap<>();
    private static final Map<String,HttpServletRequest> requestHolder = new ConcurrentHashMap<String,HttpServletRequest>();

    public static void add(SysUser sysUser) {
        userHolder.set(sysUser);
        SYSUSER_MAP.put(sysUser.getId().toString(), sysUser);
    }

    public static void add(HttpServletRequest request) {
        Cookie []cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("uid".equals(name)){
                    requestHolder.put(cookie.getValue(), request);
                    break;
                }
            }
        }
    }

    public static SysUser getCurrentUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                String name = cookie.getName();
                if("uid".equals(name)) {
                    return SYSUSER_MAP.get(cookie.getValue());
                }
            }
        }
        return null;
    }


    public static void remove() {
        userHolder.remove();
        requestHolder.clear();
    }
}
