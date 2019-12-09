package com.lyzd.controlplatform.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyzd.controlplatform.web.exception.ParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
* Title: SpringExceptionResolver 
* Description:  
* @author wangbingbing  
* @date 2019年6月10日
 */
@ControllerAdvice
@ResponseBody
public class SpringExceptionResolver{
	private  final Logger  log  = LoggerFactory.getLogger(SpringExceptionResolver.class);
	@ExceptionHandler(value={ParamException.class})
	public Map<String,Object> resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getRequestURL().toString();
        //ModelAndView mv;
        Map<String,Object> map = new HashMap<String, Object>();
        String defaultMsg = "System error";

        // 这里我们要求项目中所有请求json数据，都使用.json结尾
        if (url.endsWith(".json")) {
            if ( ex instanceof ParamException) {
                JsonData result = JsonData.fail(ex.getMessage());
                map.put("map", result.toMap());
            } else {
                log.error("unknown json exception, url:" + url, ex);
                JsonData result = JsonData.fail(defaultMsg);
                map.put("map", result.toMap());
            }
        } else if (url.endsWith(".page")){ // 这里我们要求项目中所有请求page页面，都使用.page结尾
            log.error("unknown page exception, url:" + url, ex);
            JsonData result = JsonData.fail(defaultMsg);
            map.put("map", result.toMap());
        } else {
            log.error("unknow exception, url:" + url, ex);
            JsonData result = JsonData.fail(defaultMsg);
            map.put("map", result.toMap());
        }

        return map;
    }
}
