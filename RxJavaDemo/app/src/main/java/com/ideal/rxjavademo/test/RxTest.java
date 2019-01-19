package com.ideal.rxjavademo.test;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * 创建者     ideal
 * 创建时间   2019/1/16 10:34
 * 描述	     测试类
 * 更新描述   $$$$
 */
public class RxTest {
    private static final String TAG = "RxTest";

    public static void main(String[] args) {
        //linkOperate();
        ErrorOperate();
    }

    /**
     * Rx的链式操作
     */
    private static void linkOperate() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onComplete();
            }
            // 采用flatMap（）变换操作符
        }).flatMap(new Function<Integer, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Integer integer) throws Exception {
                final List<String> list = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    list.add("我是事件" + integer + "拆分后的子事件" + i);
                    // 通过flatMap中将被观察者生产的事件序列先进行拆分，再将每个事件转换为一个新的发送三个String事件
                    //                    // 最终合并，再发送给被观察
                }
                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                System.out.println("o:" + o.toString());
            }
        });
    }

    /**
     * 错误信息
     */
    private static void ErrorOperate() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onError(new Exception("发生错误了"));
                e.onNext(3);
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(@NonNull Observable<Throwable> throwableObservable) throws Exception {

                // 返回新的被观察者 Observable
                // 此处有两种情况：
                // 1. 原始的Observable不重新发送事件：新的被观察者 Observable发送的事件 = Error事件
                // 2. 原始的Observable重新发送事件：新的被观察者 Observable发送的事件 = 数据事件
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(@NonNull Throwable throwable) throws Exception {

                        // 1. 若返回的Observable发送的事件 = Error事件，则原始的Observable不重新发送事件
                        // 该异常错误信息可在观察者中的onError（）中获得
                        // return Observable.error(new Throwable("retryWhen终止啦"));

                        // 2. 若返回的Observable发送的事件 = 数据事件，则原始的Observable重新发送事件（若持续遇到错误，则持续重试）
                        return Observable.just(1);
                    }
                });

            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer value) {
                System.out.println("接收到了事件" + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("对Error事件作出响应" + e.toString());
                // 获取异常错误信息
            }

            @Override
            public void onComplete() {
                System.out.println("对Complete事件作出响应");
            }
        });

    }
}