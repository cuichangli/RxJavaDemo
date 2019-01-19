package com.ideal.rxjavademo.flatmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者     ideal
 * 创建时间   2019/1/19 9:25
 * 描述	     创建模拟数据
 * 更新描述   $$$$
 */
public class PersonList {
    public static List<Person> getData() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Person person = new Person();
            person.setName("My personName is " + i);
            List<Plan> listplan = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                Plan plan = new Plan();
                plan.setTime(String.valueOf(System.currentTimeMillis()));
                plan.setContent("i:"+i+"---->j:"+j);
                List<String> actionList = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                    actionList.add("i:" + i + "--->j:" + j + "---->k:" + k);
                }
                plan.setActionList(actionList);
                listplan.add(plan);
            }
            person.setPlanList(listplan);
            personList.add(person);
        }
        return personList;
    }
}
