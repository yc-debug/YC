package com;

import com.JsonReading;

import java.util.List;

public class main {

    public static void main(String args[]) throws Exception {
        //获取json文件
        JsonReading reader = new JsonReading(JsonReading.class.getClassLoader().getResource("test.json").getPath());
        redisencap test = new redisencap();

        test.loading();

        //对读取json文件内容操作,对json内每个用户信息转为user实体，并返回文件中的所有用户的数据
        List<student>students = reader.getStudents();

        //一个action包括Num的增加，list、set、zset的增加
        for (student s:students){
            test.action(s);
        }

        //查找用户登录周期
        System.out.println(test.getFreq("user1"));
        System.out.println(test.getFreq("user100"));

        //incr测试
        System.out.println("当前系统点击数:" + test.getInt());
        test.increase("NUM",10);
        System.out.println("当前系统点击数:" + test.getInt());

        //STR测试
        test.setkey("test","test-STR");
        System.out.println(test.getSTR("test"));

        //获得LIST SET ZSET
        System.out.println(test.getLIST("LIST",10));
        System.out.println(test.getSET("SET"));
        System.out.println(test.getZSET("ZSET",10));

        //保存记录，保存至 target/classes/com/log.json
        test.save();
    }
}
