package com.lyzd.controlplatform.web.util;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.JsonParser.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author wangbingbing
 * @date 2019-11-20 14:19
 */
public class JsonMapper {
    private  final static Logger  log  = LoggerFactory.getLogger(JsonMapper.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // config
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    }

    public static <T> String obj2String(T src) {
        if (src == null) {
            return null;
        }
        try {
            return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
        } catch (Exception e) {
            log.warn("parse object to String exception, error:{}", e);
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T string2Obj(String src, TypeReference<T> typeReference) {
        if (src == null || typeReference == null) {
            return null;
        }
        try {
            return (T) (typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src, typeReference));
        } catch (Exception e) {
            log.warn("parse String to Object exception, String:{}, TypeReference<T>:{}, error:{}", src, typeReference.getType(), e);
            return null;
        }
    }


    /**
     * Json字符串转换成List
     * @param json
     * @param clazz 实体对象所属类Class
     * @return
     */
    public  static <T> T jsonToList(String json, Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);//设置可用单引号
        mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);//设置字段可以不用双引号包括
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            return mapper.readValue(json, javaType);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * Json字符串转换成List
     * @param json
     * @param typeReference TypeReference<T>
     * <p>
     *  <pre>new TypeReference<List<User>>() {}</pre>
     * </p>
     * @return
     */
    public static <T> T jsonToList(String json, TypeReference<T> typeReference){
        objectMapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);//设置可用单引号
        objectMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);//设置字段可以不用双引号包括
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
