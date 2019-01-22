package com.ideal.rxjavademo;

/**
 * 创建者     ideal
 * 创建时间   2019/1/16 9:43
 * 描述	     学习说明
 * 更新描述   $$$$
 */
public class Word {
    /*
     1.在app的buildGradle加入RxJava依赖
        implementation 'io.reactivex.rxjava2:rxjava:2.0.1'
        implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
     2. RxJava 中的调度器                      作用
        Schedulers.computation();           用于使用计算任务，如事件循环和回调处理
        Schedulers.io();                    用于IO密集型任务，如果义务阻塞IO操作
        Schedulers.newThread();             创建一个新的线程
        AndroidSchedulers.mainThread();     Android的UI线程，用于操作UI.

    */
}
