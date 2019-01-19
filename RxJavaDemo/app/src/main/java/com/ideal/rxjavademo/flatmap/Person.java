package com.ideal.rxjavademo.flatmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者     ideal
 * 创建时间   2019/1/19 9:13
 * 描述	     2.1 flatMap 使用类
 * 更新描述   $$$$
 */
public class Person {
    //人名
    private String     name;
    //计划清单
    private List<Plan> planList = new ArrayList<>();

    public Person() {
    }

    public Person(String name, List<Plan> planList) {
        this.name = name;
        this.planList = planList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }
}
