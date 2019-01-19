package com.ideal.rxjavademo.flatmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者     ideal
 * 创建时间   2019/1/19 9:13
 * 描述	     2.1 flatMap 使用类
 * 更新描述   $$$$
 */
public class Plan {
    private String time;
    private String content;
    private List<String> actionList=new ArrayList<>();

    public Plan() {
    }

    public Plan(String time, String content) {
        this.time = time;
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getActionList() {
        return actionList;
    }

    public void setActionList(List<String> actionList) {
        this.actionList = actionList;
    }
}
