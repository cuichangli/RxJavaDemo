package com.ideal.rxjavademo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "RxJava";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,RxActivity.class));
//        //1.每一秒发送一个数据=从零开始，递增1，即0,1,2,3......
//        Observable.interval(1,TimeUnit.SECONDS)
//                //2.通过takeUntil的Predicate传入判断条件
//                .takeUntil(new Predicate<Long>() {
//            @Override
//            public boolean test(Long integer) throws Exception {
//                return (integer>10);
//                // 返回true时，就停止发送事件
//                // 当发送的数据满足>3时，就停止发送Observable的数据
//            }
//        }).subscribe(new Observer<Long>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.i(TAG,"onSubscribe：");
//            }
//
//            @Override
//            public void onNext(Long value) {
//                Log.i(TAG,"发送了事件："+value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i(TAG,"onError：");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i(TAG,"onComplete：");
//            }
//        });
    }
}
