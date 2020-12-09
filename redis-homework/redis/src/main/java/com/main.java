package com;

import com.JsonReading;

import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String args[]) throws Exception {
        //获取json文件
        JsonReading reader = new JsonReading(JsonReading.class.getClassLoader().getResource("SD.json").getPath());
        redisencap getjson = new redisencap();

        getjson.loading();

        //对读取json文件内容操作,对json内每个用户信息转为user实体，并返回文件中的所有用户的数据
        List<student>students = reader.getStudents();

        //一个action包括Num的增加，list、set、zset的增加
        for (student s:students){
            getjson.action(s);
        }

        //查找用户登录周期
        System.out.println(getjson.getFreq("yc"));
        System.out.println(getjson.getFreq("user"));

        //incr测试
        System.out.println("当前系统点击数:" + getjson.getInt());
        getjson.increase("NUM",5);
        System.out.println("当前系统点击数:" + getjson.getInt());


        System.out.println("\n\n\n\n");
        int i=0;
        int inc=1;
        while(i==0){
            System.out.println("1.增加(默认为1)");
            System.out.println("2.设置增加量");
            System.out.println("3.显示当前总数");
            System.out.println("4.查看所有List");
            System.out.println("5.查看所有Set");
            System.out.println("6.查看所有ZSet");
            System.out.println("7.减少(默认为1)");
            System.out.println("0.退出程序");
            System.out.println("请输入对应的操作序号：");

            Scanner input=new Scanner(System.in);
            String choice=input.nextLine();//获取输入选项
            switch (choice){
                case "1":{
                    getjson.increase("NUM",inc);
                    System.out.println("当前系统点击数:" + getjson.getInt());
                    break;
                }
                case "2":{
                    Scanner in=new Scanner(System.in);
                    inc=Integer.valueOf(in.nextLine());
                    break;
                }
                case "3":{
                    System.out.println("当前系统点击数:" + getjson.getInt());
                    break;
                }
                case "4":{
                    System.out.println(getjson.getLIST("LIST",10));
                    break;
                }
                case "5":{
                    System.out.println(getjson.getSET("SET"));
                    break;
                }
                case "6":{
                    System.out.println(getjson.getZSET("ZSET",10));
                    break;
                }
                case "7":{
                    getjson.dec("NUM");
                    System.out.println("当前系统点击数:" + getjson.getInt());
                    break;
                }
                case "0":{
                    i=1;
                    break;
                }
            }
        }

        //保存记录，保存至 target/classes/com/log.json
        getjson.save();
    }
}
