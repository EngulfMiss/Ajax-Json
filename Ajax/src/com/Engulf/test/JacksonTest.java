package com.Engulf.test;

import com.Engulf.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class JacksonTest {
    //java对象转为JSON字符串
    @Test
    public void test1() throws Exception {
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        /*
            转换方法：
                writeValue(参数1,obj);
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串,并将json数据填充到字符输出流中
                        OutputStream:将obj对象转换为JSON字符串,并将json数据填充到字节输出流中

                writeValueAsString(obj):将对象转为json字符串
         */
        String json = mapper.writeValueAsString(p);
        //{"name":"张三","age":23,"gender":"男"}
        System.out.println(json);

        //writeValue:将json字符串写入文件中
        //mapper.writeValue(new File("E:\\test\\testdemo\\upload\\a.txt"),p);

        //writeValue 将数据关联到Writer中
        mapper.writeValue(new FileWriter("E:\\test\\testdemo\\upload\\new.txt"),p);
    }

    @Test
    public void test2() throws Exception{
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }

    @Test
    public void test3() throws Exception{
        //1.创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("李四");
        p2.setAge(26);
        p2.setGender("女");
        p2.setBirthday(new Date());


        Person p3 = new Person();
        p3.setName("王五");
        p3.setAge(33);
        p3.setGender("男");
        p3.setBirthday(new Date());

        //创建List集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p);
        ps.add(p2);
        ps.add(p3);


        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);
        //[{"name":"张三","age":23,"gender":"男","birthday":"2020-07-24"},{"name":"李四","age":26,"gender":"女","birthday":"2020-07-24"},{"name":"王五","age":33,"gender":"男","birthday":"2020-07-24"}]
        System.out.println(json);


    }

    @Test
    public void test4() throws Exception{
        //1.创建Person对象
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");


        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        //{"gender":"男","name":"张三","age":23}
        System.out.println(json);


    }

    @Test
    public void test5() throws Exception{
        //演示JSON字符串转换为Java对象
        //1.初始化字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        //2.创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //3.Json对象转换为Java对象
        Person p = mapper.readValue(json,Person.class);
        System.out.println(p);
    }
}
