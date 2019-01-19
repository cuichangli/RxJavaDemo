package com.ideal.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ideal.rxjavademo.flatmap.Person;
import com.ideal.rxjavademo.flatmap.PersonList;
import com.ideal.rxjavademo.flatmap.Plan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;


/**
 * 各种例子参考
 */
public class RxActivity extends AppCompatActivity {
    private static final String TAG = "RxActivity";
    @BindView(R.id.btn_1)
    Button mBtn1;
    @BindView(R.id.btn_2)
    Button mBtn2;
    @BindView(R.id.btn_3)
    Button mBtn3;
    @BindView(R.id.btn_4)
    Button mBtn4;
    @BindView(R.id.btn_5)
    Button mBtn5;
    @BindView(R.id.btn_6)
    Button mBtn6;
    @BindView(R.id.btn_7)
    Button mBtn7;
    @BindView(R.id.btn_8)
    Button mBtn8;
    @BindView(R.id.btn_9)
    Button mBtn9;
    @BindView(R.id.btn_10)
    Button mBtn10;
    @BindView(R.id.btn_11)
    Button mBtn11;
    @BindView(R.id.btn_12)
    Button mBtn12;
    @BindView(R.id.btn_13)
    Button mBtn13;
    @BindView(R.id.btn_14)
    Button mBtn14;
    @BindView(R.id.btn_15)
    Button mBtn15;
    @BindView(R.id.btn_16)
    Button mBtn16;
    @BindView(R.id.btn_17)
    Button mBtn17;
    @BindView(R.id.btn_17_1)
    Button mBtn171;
    @BindView(R.id.btn_18)
    Button mBtn18;
    @BindView(R.id.btn_19)
    Button mBtn19;
    @BindView(R.id.btn_20)
    Button mBtn20;
    @BindView(R.id.btn_21)
    Button mBtn21;
    @BindView(R.id.btn_22)
    Button mBtn22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id
            .btn_10, R.id.btn_11, R.id.btn_12, R.id.btn_13, R.id.btn_14, R.id.btn_15, R.id.btn_16, R.id.btn_17, R.id.btn_17_1,
            R.id.btn_18, R
            .id.btn_19, R.id
            .btn_20, R.id.btn_21, R.id.btn_22})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1://第一种方式
                firstMothed();
                break;
            case R.id.btn_2://链式调用
                linkCreate();
                break;
            case R.id.btn_3://操作符create 创建验证
                TestIsCreate();
                break;
            case R.id.btn_4://操作符just
                TestJust();
                break;
            case R.id.btn_5://操作符from
                TestFrom();
                break;
            case R.id.btn_6://操作符fromCallable
                TestFromCallable();
                break;
            case R.id.btn_7://操作符:1.3.3 fromFuture()
                TestFromFuture();
                break;
            case R.id.btn_8://1.3.4，操作符fromIterable
                TestFromIterable();
                break;
            case R.id.btn_9://1.4，操作符TestDefer
                TestDefer();
                break;
            case R.id.btn_10://1.5 timer
                testTimer();
                break;
            case R.id.btn_11://1.6 interval
                testInterval();
                break;
            case R.id.btn_12://1.7 intervalRange
                testIntervalRange();
                break;
            case R.id.btn_13://1.8 range
                testRange();
                break;
            case R.id.btn_14://1.9 rangeLong
                testRangeLong();
                break;
            case R.id.btn_15://1.10 empty()&never()&error()
                testEmpty();
                break;
            case R.id.btn_16://2.1 map
                testMap();
                break;
            case R.id.btn_17_1://2.2.1 flatMap map
                testFlatMap1();
                break;
            case R.id.btn_17://2.2.2 flatMap
                testFlatMap2();
                break;
            case R.id.btn_18://2.3 concatMap
                testconcatMap();
                break;
            case R.id.btn_19://2.4 buffer
                testBuffer();
                break;
            case R.id.btn_20://2.5 groupBy
                testGroupBy();
                break;
            case R.id.btn_21://2.6 scan
                testScan();
                break;
            case R.id.btn_22://2.7 window
                testWindow();
                break;

            default:
                break;
        }
    }

    /******第一种方式**********************************************************************/
    private void firstMothed() {
        //1.创建被观察者  <Integer> 需要手动输入，要不默认为Object
        Observable mObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        //2.创建观察者 <Integer> 需要手动输入，要不默认为Object
        Observer mObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe()");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "onNext():" + value);

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError()");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete()");
            }
        };
        //订阅
        mObservable.subscribe(mObserver);
    }

    /******第二种方式:链式调用**********************************************************************/
    private void linkCreate() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe()");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "onNext():" + value);

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError()");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete()");
            }
        });
    }

    //TODO 操作符使用
    /******1.创建操作符**********************************************************************/
    /*
    1.1 create()
        方法预览
        public static<T> Observable<T> create(ObservableOnSubscribe<T> source)
        作用：创建一个被观察者
        用法：代码非常简单，创建 ObservableOnSubscribe并重写subscribe方法，就可以通过ObservableEmitter发射器向观察者发送事件
    */
    Observable<String> mObservable1 = Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> emitter) throws Exception {
            emitter.onNext("创建一个被观察者！");
        }
    });

    //创建被观察者，验证这个被观察者是否成功创建
    private void TestIsCreate() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "TestIsCreate--->onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "TestIsCreate--->onNext:" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "TestIsCreate--->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "TestIsCreate--->onComplete");
            }
        };
        //订阅
        mObservable1.subscribe(observer);
    }

    /*
     1.2 just
     方法预览：
     public static<T> Observable<T> just(T item)
     public static<T> Observable<T> just(T item1,T item2,T item3,T item4,T item5,T item6,T item7,T item8,T item9,T item10);
     作用：创建一个被观察者，并发送事件，发送的事件不可以超过10个。
     用法：直接采用链式调用
    */
    public void TestJust() {
        Observable.just(1, 2, 3).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "TestJust--->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "TestJust--->onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "TestJust--->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "TestJust--->onComplete");
            }
        });
    }

    /*
    1.3 From 操作符
    1.3.1 fromArray()
        方法预览：
        public static <T> Observable<T> fromArray(T...items)
        作用：和just()类似，只不过fromArray可以传入多余10个的变量，并且可以闯入一个数组
     */
    public void TestFrom() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Observable.fromArray(array).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "TestFrom--->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "TestFrom--->onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "TestFrom--->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "TestFrom--->onComplete");
            }
        });
    }

    /*
    1.3.2 fromCallable()
    方法预览： public static<T> Observable<T> fromCallable(Callable<? extends T> supplier)
    作用：这里的Callable 是 java.util.concurrent 中的Callable ,Callable和Runnable的用法基本一致，只是他会返回一个结果值，这个结果值就是发给观察者的
    用法：
     */
    public void TestFromCallable() {
        Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "TestFromCallable-->accept:" + integer);
            }
        });
    }
    /*
    1.3.3 fromFuture()
    方法预览
    public static <T> Observable<T> fromFuture(Future<? extends T> future)
    作用：参数中的Future 是java.util.concurrent中的Future，Future的作用是增加了cancel()等方法操作Callable,它可以通过get()方法来获取Callable返回的值。
    用法：doOnSubscribe() 的作用就是只有订阅时才会发送事件，具体会在下面讲解。
     */

    private void TestFromFuture() {
        final FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Log.d(TAG, "TestFromFuture call()");
                return "返回结果";
            }
        });
        Observable.fromFuture(futureTask)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        futureTask.run();
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "TestFromFuture--->accept:" + s);
            }
        });
    }

    /*
        1.3.4 fromIterable()
        方法预览：
        public static <T> Observable<T> fromIterable(Iterable<? extends T> source)
        作用：直接发送一个List集合数据给观察者
        用法：
     */
    private void TestFromIterable() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        Observable.fromIterable(list).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "TestFromIterable-->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "TestFromIterable-->onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "TestFromIterable-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "TestFromIterable-->onComplete");
            }
        });
    }

    /*
    1.4 defer()
    方法预览
    public static <T> Observable<T> defer(Callable<? extends observableSource<? extends T>> supplier)
    作用： 这个方法的作用就是直到被观察者被订阅后才会创建被观察者
    用法：因为defer()只有观察者订阅的时候才会创建新的被观察者，所以每订阅一次就会打印一次，并且都是打印i最新的值。
     */
    //i要定义为成员变量,初始值为100
    Integer i = 100;

    private void TestDefer() {
        final Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(i);
            }
        });
        i = 200;
        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testDefer-->onSubscrib");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "testDefer-->onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testDefer-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testDefer-->onComplete");
            }
        };
        observable.subscribe(observer);
        i = 300;
        observable.subscribe(observer);

    }

    /*
    1.5 timer
    方法预览:
    public static Observable<Long> timer(long delay,TimeUnit unit)
    作用：当到指定时间后就会发送一个OL的值给观察者
    用法：间隔时间为3s

     */
    private void testTimer() {
        final long start = System.currentTimeMillis();
        Log.d(TAG, "start:" + start);
        Observable.timer(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "testTimer-->onSubscribe");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "delay:" + (System.currentTimeMillis() - start));
                        Log.d(TAG, "testTimer-->onNext" + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "testTimer-->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "testTimer-->onComplete");
                    }
                });
    }

    /*
    1.6 interval
    方法预览：
    public static Observable<Long> interval(long period,TimeUnit unit)
    public static Observable<Long> interval(long initialDelay,long period,TimeUnit unit)
    作用：每隔一段时间就会发送一个时间，这个事件是从0开始，不断增1的数字
    用法：initialDelay参数就是OnSubscribe回调之后，再次回调onNext的间隔时间，从打印日志可以看出首次时间为initialDelay 3s,然后每隔2秒就会发出一次数字递增1的事件。
     */
    long start = 0L;

    private void testInterval() {
        start = System.currentTimeMillis();
        Observable.interval(3, 2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testInterval-->onSubscribe");
            }

            @Override
            public void onNext(Long aLong) {
                long end = System.currentTimeMillis();
                Log.d(TAG, "interval:" + (end - start) / 1000 + " s");
                start = end;
                Log.d(TAG, "testInterval-->onNext" + aLong);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testInterval-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testInterval-->onComplete");
            }
        });
    }

    /*
    1.7 intervalRange
    方法预览,start:起始数值；count,发送数量；initialDelay,首次延迟；period：发送间隔；unit:时间单位
    public static Observable<Long> intervalRange(long start,long count,long initialDelay,long period,TimeUnit unit)
    public static Observable<Long> intervalRange(long start,long count,long initialDelay,long period,TimeUnit unit,Scheduler
    scheduler)
    作用:可以指定发送事件的开始值和数量，其他与interval()的功能一样
    用法：起始数值3，发送六次，初始间隔3，发送间隔2，时间单位：秒
     */
    private void testIntervalRange() {
        start = System.currentTimeMillis();
        Observable.intervalRange(3, 6, 3, 2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testIntervalRange-->onSubscribe");
            }

            @Override
            public void onNext(Long aLong) {
                long end = System.currentTimeMillis();
                Log.d(TAG, "interval:" + (end - start) / 1000 + "s");
                start = end;
                Log.d(TAG, "testIntervalRange-->onNext" + aLong);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testIntervalRange-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testIntervalRange-->onComplete");
            }
        });
    }

    /*
    1.8 range
    方法预览：
    public static Observable<Integer> range(final int start,final int count)
    作用：同时发送一定范围的时间序列
    用法：
     */
    private void testRange() {
        Observable.range(2, 5).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testRange-->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "testRange-->onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testRange-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testRange-->onComplete");
            }
        });
    }

    /*
    1.9 rangeLong
    方法预览：
    public static Observable<Long> rangeLong(long start,Long count)
    作用：同时发送一定范围的时间序列,与rangde()不同的是数据类型为Long
    用法：
     */
    private void testRangeLong() {
        Observable.rangeLong(2L, 6L).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testRangeLong-->onSubscribe");
            }

            @Override
            public void onNext(Long integer) {
                Log.d(TAG, "testRangeLong-->onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testRangeLong-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testRangeLong-->onComplete");
            }
        });
    }

    /*
    1.10 empty()&never()&error()
    方法预览：
    public static<T> Observable<T> empty()
    public static<T> Observable<T> never()
    public static<T> Observable<T> error(final Throwable exception)
    作用：empty() 直接发送onComplete()事件
          never():不发送任何事件
          error():发送onError()事件
    用法：
     */
    private void testEmpty() {
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testEmpty-->onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.d(TAG, "testEmpty-->onNext");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testEmpty-->onError:" + e.getMessage());
                Log.d(TAG, "testEmpty-->onError:" + e.toString());
                Log.d(TAG, "testEmpty-->onError:" + e.getCause());
                Log.d(TAG, "testEmpty-->onError:" + e.getLocalizedMessage());
                Log.d(TAG, "testEmpty-->onError:" + e.getStackTrace());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testEmpty-->onComplete");
            }
        };
        Observable.empty().subscribe(observer);
        Observable.never().subscribe(observer);
        Observable.error(new Error("出现错误")).subscribe(observer);
    }
    //TODO 转换操作符

    /******2.转换操作符**********************************************************************/
    /*
    2.1 map
    方法预览
    public final <R> Observable<R> map(Function<? super T,? extends R> mapper)
    作用： map可以将被观察者发送的数据类型转变成其他的类型
    用法：以下代码将Integer类型的数据转换成String
     */
    private void testMap() {
        Observable.just(1, 2, 3)
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "I'm " + integer;
                    }
                }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testMap-->onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "testMap-->onNext:" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testMap-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testMap-->onComplete");
            }
        });
    }

    /*
    2.2 flatmap
    方法预览：
    public final <R> Observable<R> flatMap(Function<? super T,? extends ObservableSource<? extends R>> mapper)
    作用：这个方法可以将时间序列中的元素进行整合加工，返回一个新的被观察者
    用法：flatMap() 其实与map() 类似，但是flatMap() 返回的是一个Observerable. 现在yoga一个雷子来说明flatMap()的用法
         先定义一个Plan类，见flatmap Plan 类
         再定义一个Person类，见flatmap 包下Person 类
         现在的需求是要将Person集合中的每一个元素中的Plan的action打印出来
         PersonList 获取模拟数据
     */
    //2.2.1 map 实现方式 ,
    //          可以看到onNext用了for循环来实现，如果代码逻辑复杂起来的话，可能需要多重循环才可以实现
    private void testFlatMap1() {
        Observable.fromIterable(PersonList.getData())
                .map(new Function<Person, List<Plan>>() {
                    @Override
                    public List<Plan> apply(Person person) throws Exception {
                        return person.getPlanList();
                    }
                }).subscribe(new Observer<List<Plan>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testFlatMap1-->onSubscribe");
            }

            @Override
            public void onNext(List<Plan> plans) {
                for (Plan plan : plans) {
                    List<String> planActionList = plan.getActionList();
                    for (int i = 0; i < planActionList.size(); i++) {
                        Log.d(TAG, "testFlatMap1-->onNext:" + planActionList.get(i));
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testFlatMap1-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testFlatMap1-->onComplete");
            }
        });
    }

    // 2.2.2使用flatMap实现,从代码可以看出，只需要连个flatMap()就可以完成需求，并且代码逻辑非常清晰。
    private void testFlatMap2() {
        Observable.fromIterable(PersonList.getData())
                .flatMap(new Function<Person, ObservableSource<Plan>>() {
                    @Override
                    public ObservableSource<Plan> apply(Person person) {
                        return Observable.fromIterable(person.getPlanList());
                    }
                }).flatMap(new Function<Plan, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Plan plan) {
                return Observable.fromIterable(plan.getActionList());
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testFlatMap2-->onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "testFlatMap2-->onNext" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testFlatMap2-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testFlatMap2-->onComplete");
            }
        });
    }

    /*
     2.3 concatMap
     方法预览
     public final <R> Observable<R> concatMap(Fujnction<? super T,? extends ObservableSource<? extends R>> mapper)
     public final <R> Observable<R> concatMap(Fujnction<? super T,? extends ObservableSource<? extends R>> mapper,int prefetch)
     作用：concatMap() 和flataMap() 基本上是一样的，只不过concatMap() 转发出来的事件是有序的，而flatMap() 是无序的。
     用法：
     */
    private void testconcatMap() {
        Observable.fromIterable(PersonList.getData())
                //此处更换flatMap 和concatMap
                //区别 flatMap当 i=2时，因为延迟，在最后显示。
                //和concatmap 当 i=2时，正常顺序显示
                .concatMap(new Function<Person, ObservableSource<Plan>>() {
                    @Override
                    public ObservableSource<Plan> apply(Person person) {
                        //此处验证flatmap()发送的事件是否是无序的
                        if ("My personName is 2".equals(person.getName())) {
                            return Observable.fromIterable(person.getPlanList()).delay(10, TimeUnit.MILLISECONDS);
                        }
                        return Observable.fromIterable(person.getPlanList());
                    }
                }).subscribe(new Observer<Plan>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testconcatMap-->onSubscribe");
            }

            @Override
            public void onNext(Plan s) {

                Log.d(TAG, "testconcatMap-->onNext" + s.getContent());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testconcatMap-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testconcatMap-->onComplete");
            }
        });
    }

    /*
    2.4 buffer
    方法预览
    public fianl Observable<List<T>> buffer(int count,int skip)
    作用：从需要发送的事件当中获取一定数量的事件，并将这些事件放到缓冲区当中一并发出。
    用法：buffer有两个参数，一个是count,另一个skip.count缓冲区元素的数量，skip就代表缓冲区满了之后，发送下一次事件序列的时候要跳过多少元素。
         比较抽象，直接看代码：
         从结果可以看出，每次发送事件，指针都会往后移动skip数值的元素，直到指针移动到没有元素的时候就会停止取值。
     */
    private void testBuffer() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .buffer(3, 2)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "testBuffer-->onSubscribe");
                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        Log.d(TAG, "testBuffer-->onNext————缓冲区大小:" + integers.size());
                        for (Integer i : integers) {
                            Log.d(TAG, "testBuffer-->onNext" + i);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "testBuffer-->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "testBuffer-->onComplete");
                    }
                });
    }
    /*
    2.5 groupBy
     方法预览：
     public final <K> Observable<GroupedObservable<K,T>> groupBy(Function<? super T,? extends k> keySelector)
     作用：将发送的数据进行分组，每个分组都会返回一个被观察者
     用法:在groupBy()方法返回的参数是分组的名字，每返回一个值，那就代表会创建一个组，以下的代码就是将1~10的数据分成3组；
     */
    private void testGroupBy(){
        Observable.just(1,2,3,4,5,6,7,8,9,10)
                .groupBy(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        Log.d(TAG,"apply:"+integer);
                        return integer%3;
                    }
                }).subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"testGroupBy-->onSubscribe");
            }

            @Override
            public void onNext(final GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                Log.d(TAG,"->onNext-->GroupedObservable");
                integerIntegerGroupedObservable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG,"->onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG,"->onNext->groupName:"+integerIntegerGroupedObservable.getKey()+",value:"+integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG,"->onComplete");
                    }
                });
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"testGroupBy-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"testGroupBy-->onComplete");
            }
        });
    }
    /*
    2.6 scan
    方法预览：
    public final Observable<T> scan(BiFunction<T,T,T> acumulator)
    作用：将数据以一定的逻辑聚合起来
    用法：
     */
    private void testScan(){
        Observable.just(1,2,3,4,5,6)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        Log.d(TAG,"apply()-->integer:"+integer+",integer2:"+integer2);
                        return integer+integer2;
                    }
                }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"testScan->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG,"testScan->onNext:"+integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"testScan->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"testScan->onComplete");
            }
        });
    }
    /*
    2.7 window()
       方法预览：
       public final Observable<Observable<T> window(long count)
       作用：发生指定数量的事件时，就将这些事件分为一组。window 中的count的参数就是代表指定的数量，例如将count指定为2，那么每发两个数据就会将这两个数据分成一组。
       用法：从结果可以发现，window()将1-5的事件分成了3组。
     */
    private void testWindow(){
        Observable.just(1,2,3,4,5,6)
                .window(2).subscribe(new Observer<Observable<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"testWindow->onSubscribe");
            }

            @Override
            public void onNext(Observable<Integer> integerObservable) {
                Log.d(TAG,"testWindow->onNext:");
                integerObservable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG,"->onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG,"->onNext:"+integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG,"->onComplete");
                    }
                });
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"testWindow->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"testWindow->onComplete");
            }
        });
    }

    /*
       Log.d(TAG,"->onSubscribe");
       Log.d(TAG,"->onNext:"+s);
       Log.d(TAG,"->onError");
       Log.d(TAG,"->onComplete");
     */
}
