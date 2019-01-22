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
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;


/**
 * 各种例子参考
 * 4.14 onExceptionResumeNext  ???这个有点不太明白
 * 6.1 方法定义错误，需要核对
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
    @BindView(R.id.btn_23)
    Button mBtn23;
    @BindView(R.id.btn_24)
    Button mBtn24;
    @BindView(R.id.btn_25)
    Button mBtn25;
    @BindView(R.id.btn_26)
    Button mBtn26;
    @BindView(R.id.btn_27)
    Button mBtn27;
    @BindView(R.id.btn_28)
    Button mBtn28;
    @BindView(R.id.btn_29)
    Button mBtn29;
    @BindView(R.id.btn_30)
    Button mBtn30;
    @BindView(R.id.btn_31)
    Button mBtn31;
    @BindView(R.id.btn_32)
    Button mBtn32;
    @BindView(R.id.btn_33)
    Button mBtn33;
    @BindView(R.id.btn_34)
    Button mBtn34;
    @BindView(R.id.btn_35)
    Button mBtn35;
    @BindView(R.id.btn_36)
    Button mBtn36;
    @BindView(R.id.btn_37)
    Button mBtn37;
    @BindView(R.id.btn_38)
    Button mBtn38;
    @BindView(R.id.btn_39)
    Button mBtn39;
    @BindView(R.id.btn_40)
    Button mBtn40;
    @BindView(R.id.btn_41)
    Button mBtn41;
    @BindView(R.id.btn_42)
    Button mBtn42;
    @BindView(R.id.btn_43)
    Button mBtn43;
    @BindView(R.id.btn_44)
    Button mBtn44;
    @BindView(R.id.btn_45)
    Button mBtn45;
    @BindView(R.id.btn_46)
    Button mBtn46;
    @BindView(R.id.btn_47)
    Button mBtn47;
    @BindView(R.id.btn_48)
    Button mBtn48;
    @BindView(R.id.btn_49)
    Button mBtn49;
    @BindView(R.id.btn_50)
    Button mBtn50;
    @BindView(R.id.btn_51)
    Button mBtn51;
    @BindView(R.id.btn_52)
    Button mBtn52;
    @BindView(R.id.btn_53)
    Button mBtn53;
    @BindView(R.id.btn_54)
    Button mBtn54;
    @BindView(R.id.btn_55)
    Button mBtn55;
    @BindView(R.id.btn_56)
    Button mBtn56;
    @BindView(R.id.btn_57)
    Button mBtn57;
    @BindView(R.id.btn_58)
    Button mBtn58;
    @BindView(R.id.btn_59)
    Button mBtn59;
    @BindView(R.id.btn_60)
    Button mBtn60;
    @BindView(R.id.btn_61)
    Button mBtn61;
    @BindView(R.id.btn_62)
    Button mBtn62;
    @BindView(R.id.btn_63)
    Button mBtn63;
    @BindView(R.id.btn_64)
    Button mBtn64;
    @BindView(R.id.btn_65)
    Button mBtn65;
    @BindView(R.id.btn_66)
    Button mBtn66;
    @BindView(R.id.btn_67)
    Button mBtn67;
    @BindView(R.id.btn_68)
    Button mBtn68;
    @BindView(R.id.btn_69)
    Button mBtn69;
    @BindView(R.id.btn_70)
    Button mBtn70;
    @BindView(R.id.btn_71)
    Button mBtn71;
    @BindView(R.id.btn_72)
    Button mBtn72;
    @BindView(R.id.btn_73)
    Button mBtn73;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id
            .btn_10, R.id.btn_11, R.id.btn_12, R.id.btn_13, R.id.btn_14, R.id.btn_15, R.id.btn_16, R.id.btn_17, R.id.btn_17_1,
            R.id.btn_18, R.id.btn_19, R.id.btn_20, R.id.btn_21, R.id.btn_22, R.id.btn_23, R.id.btn_24, R.id.btn_25, R.id
            .btn_26, R.id.btn_27, R.id.btn_28, R.id.btn_29, R.id.btn_30, R.id.btn_31, R.id.btn_32, R.id.btn_33, R.id.btn_34, R
            .id.btn_35, R.id.btn_36, R.id.btn_37, R.id.btn_38, R.id.btn_39, R.id.btn_40, R.id.btn_41, R.id.btn_42, R.id.btn_43,
            R.id.btn_44, R.id.btn_45, R.id.btn_46, R.id.btn_47, R.id.btn_48, R.id.btn_49, R.id.btn_50, R.id.btn_51, R.id
            .btn_52, R.id.btn_53, R.id.btn_54, R.id.btn_55, R.id.btn_56, R.id.btn_57, R.id.btn_58, R.id.btn_59, R.id.btn_60,
            R.id.btn_61, R.id.btn_62, R.id.btn_63, R.id.btn_64, R.id.btn_65, R.id.btn_66, R.id.btn_67, R.id.btn_68, R.id
            .btn_69, R.id.btn_70, R.id.btn_71, R.id.btn_72, R.id.btn_73})
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
            case R.id.btn_23://3.1 concat
                testConcat();
                break;
            case R.id.btn_24://3.2 concatArray
                testconcatArray();
                break;
            case R.id.btn_25://3.3 merge
                testMerge();
                break;
            case R.id.btn_26://3.4 concatArrayDelayError() & mergerArrayDelayError()
                testConcatarrayDelayError();
                break;
            case R.id.btn_27://3.5 zip
                testZip();
                break;
            case R.id.btn_28://3.6 combineLatest() & combineLatestDelayError()
                testCombineLatest();
                break;
            case R.id.btn_29://3.7 reduce
                testReduce();
                break;
            case R.id.btn_30://3.8 collect
                testCollect();
                break;
            case R.id.btn_31://3.9 startWith() & startWithArray()
                testStartWith();
                break;
            case R.id.btn_32://3.10 count
                testCount();
                break;
            case R.id.btn_33://4.1 delay
                testDelay();
                break;
            case R.id.btn_34://4.2 doOnEach
                testDoOnEach();
                break;
            case R.id.btn_35://4.3 doOnNext
                testDoOnNext();
                break;
            case R.id.btn_36://4.4 doAfterNext
                testDoAfterNext();
                break;
            case R.id.btn_37://4.5 doOnComplete
                testOnComplete();
                break;
            case R.id.btn_38://4.6 doOnError
                testDoOnError();
                break;
            case R.id.btn_39://4.7 doOnSubscribe
                testDoOnSubscribe();
                break;
            case R.id.btn_40://4.8 doOnDispose
                testDoOnDispose();
                break;
            case R.id.btn_41://4.9 doOnLifeCycle
                testDoOnLifecycle();
                break;
            case R.id.btn_42://4.10 doOnTerminate &doAfterTerminate
                testDoOnTerminate();
                break;
            case R.id.btn_43://4.11 doFinally
                testDoFinally();
                break;
            case R.id.btn_44:// 4.12 onErrorReturn
                testOnErrorReturn();
                break;
            case R.id.btn_45:// 4.13  onErrorResumeNext
                testOnErrorResumeNext();
                break;
            case R.id.btn_46:// 4.14 onExceptionResunmeNext
                testOnExceptionResumeNext();
                break;
            case R.id.btn_47:// 4.15 retry
                testRetry();
                break;
            case R.id.btn_48:// 4.16 retryUntil
                testRetryUntil();
                break;
            case R.id.btn_49:// 4.17 retryWhen
                retryWhen();
                break;
            case R.id.btn_50:// 4.18 repeat
                testRepeat();
                break;
            case R.id.btn_51:// 4.19 repeatWhen
                testRepeatWhen();
                break;
            case R.id.btn_52:// 4.20 subseribeOn
                testSubscribeOn();
                break;
            case R.id.btn_53:// 4.21 observeOn
                testObserveOn();
                break;
            case R.id.btn_54:// 5.1 filter
                testFilter();
                break;
            case R.id.btn_55:// 5.2 ofType
                testOfType();
                break;
            case R.id.btn_56:// 5.3 skip
                testSkip();
                break;
            case R.id.btn_57:// 5.4 distinct
                testDistinct();
                break;
            case R.id.btn_58:// 5.5 distinctUntilChanged
                testDistinctUntilChanged();
                break;
            case R.id.btn_59:// 5.6 take
                testTake();
                break;
            case R.id.btn_60:// 5.7 debounce
                testDebounce();
                break;
            case R.id.btn_61:// 5.8 firstElement() & & lastElement
                testFirstElement();
                break;
            case R.id.btn_62:// 5.9 elementAt() & elementAtOrError()
                testElementAt();
                break;
            case R.id.btn_63:// 6.1 all
                testAll();
                break;
            case R.id.btn_64:// 6.2 takeWhile
                testTakeWhile();
                break;
            case R.id.btn_65:// 6.3 skipWhile
                testSkipWhile();
                break;
            case R.id.btn_66:// 6.4 takeuntil
                takeUntil();
                break;
            case R.id.btn_67:// 6.5 skipUntil
                testSkipUntil();
                break;
            case R.id.btn_68:// 6.6 sequenceEqual
                testSequenceEqual();
                break;
            case R.id.btn_69:// 6.7 contains
                testContains();
                break;
            case R.id.btn_70:// 6.8 isEmpty
                testIsEmpty();
                break;
            case R.id.btn_71:// 6.9 amb
                testAmb();
                break;
            case R.id.btn_72:// 6.10 defaultIfEmpty
                testDefaultIfEmpty();
                break;
            case R.id.btn_73:
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

    //TODO 1.操作符使用
    /****************************************************************************************/
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

    //TODO 2.转换操作符

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
    private void testGroupBy() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .groupBy(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        Log.d(TAG, "apply:" + integer);
                        return integer % 3;
                    }
                }).subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testGroupBy-->onSubscribe");
            }

            @Override
            public void onNext(final GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                Log.d(TAG, "->onNext-->GroupedObservable");
                integerIntegerGroupedObservable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "->onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "->onNext->groupName:" + integerIntegerGroupedObservable.getKey() + ",value:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "->onComplete");
                    }
                });
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testGroupBy-->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testGroupBy-->onComplete");
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
    private void testScan() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        Log.d(TAG, "apply()-->integer:" + integer + ",integer2:" + integer2);
                        return integer + integer2;
                    }
                }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testScan->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "testScan->onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testScan->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testScan->onComplete");
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
    private void testWindow() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .window(2).subscribe(new Observer<Observable<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testWindow->onSubscribe");
            }

            @Override
            public void onNext(Observable<Integer> integerObservable) {
                Log.d(TAG, "testWindow->onNext:");
                integerObservable.subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "->onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "->onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "->onComplete");
                    }
                });
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testWindow->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testWindow->onComplete");
            }
        });
    }

    //TODO 3.组合操作符

    /********************************************************************************************************************************/
    /*
    3.1 concat
    方法预览：public static <T> Observable<T> concat(ObservableSource<? extends T> sourcel,ObservableSource<? ectends T> source2,
    ObservableSource<? eextends T> source3,ObservableSource<? extends T> source4)
    作用：可以将多个观察者组合在一起，然后按照之前发送顺序发送事件。需要注意的是，concat()最多只可以发送4个事件。
    用法：
     */
    private void testConcat() {
        Observable.concat(Observable.just(1, 2), Observable.just(3, 4), Observable.just(5, 6), Observable.just(7, 8))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "testConcat->onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "testConcat->onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "testConcat->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "testConcat->onComplete");
                    }
                });
    }

    /*
    3.2 concatArray
    方法预览：public static <T> Observable<T> concatArray(ObservableSource<? extends T> ... source)
    作用：与concat()作用一样，不过concatArray()可以发送多于4个被观察者
    用法：
     */
    private void testconcatArray() {
        Observable.concatArray(Observable.just(1, 2), Observable.just(3, 4), Observable.just(5, 6), Observable.just(7, 8),
                Observable.just(9, 10))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "testconcatArray->onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "testconcatArray->onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "testconcatArray->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "testconcatArray->onComplete");
                    }
                });
    }

    /*
    3.2 merge
    方法预览：public static <T> Observable<T> merge(ObservableSource<? extends T> sourcel,ObservableSource<? ectends T> source2,
    ObservableSource<? eextends T> source3,ObservableSource<? extends T> source4)
    作用：与concat()作用一样，只是concat()是串行发送事件，而merge()并行发送事件
    用法：现在来演示concat()和merge()的区别
         从结果可以看出A、B、C、D的事件都可以发出，区别在于串行和并行
    mergeArray 与merge的作用是一样的，只是它可以发送4个以上的观察者。
     */
    private void testMerge() {
        Observable.merge(Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return "A" + aLong;
            }
        }), Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return "B" + aLong;
            }
        }), Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return "C" + aLong;
            }
        }), Observable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return "D" + aLong;
            }
        })).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testMerge->onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "testMerge->onNext:" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testMerge->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testMerge->onComplete");
            }
        });
    }

    /*
    3.4 concatArrayDelayError() & mergerArrayDelayError()
    方法：
    public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T> ... source)
    public static <T> Observable<T> mergerArrayDelayError(ObservableSource<? extends T> ... source)
    作用：在concatArray()和mergeArray()两个方法当中，如果其中有一个被观察者发送了一个Error事件，那么就会停止发送事件，
         如果你想onError()事件延迟到所有被观察者都发送完事件后再执行的话，就可以使用concatArrayDelayError()和mergeArrayDelayError()
    用法：从结果可以看到，onError事件是在所有被观察者发送完事件才发送的。mergeArrayDelayError()也是有同样作用。
     */
    private void testConcatarrayDelayError() {
        //验证发送onError事件
        Observable.concatArray(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onError(new NumberFormatException());
            }
        }), Observable.just(2, 3, 4, 5))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "testConcatarrayDelayError->onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "testConcatarrayDelayError->onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "testConcatarrayDelayError->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "testConcatarrayDelayError->onComplete");
                    }
                });
        Log.d(TAG, "-------------------使用concatArrayDelayError后-----------------");
        Observable.concatArrayDelayError(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onError(new NumberFormatException());
            }
        }), Observable.just(2, 3, 4, 5))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "testConcatarrayDelayError->onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "testConcatarrayDelayError->onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "testConcatarrayDelayError->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "testConcatarrayDelayError->onComplete");
                    }
                });
    }

    /*
    3.5 zip
        方法预览：
        public static <T1,T2,R> Observable<R> zip(Observabelsource<? extends T1> source1,Observablesource<? extends
        T2，BiFunction<? super T1,? super T2,? extends R> zipper)
        作用：会将多个被观察者合并，根据各个被观察者发送事件的顺序一个个结合起来，最终发送的时间数量会与源Observable中最少事件的数量一样。
        用法：以下代码中有两个Observable,第一个发送事件的数量为5个，第二个发送的事件数量为6个；
             可以发现最终接收到的事件数量是5。
             因为在这之前第一个Observable已经发送了onComplete事件，所以第二个Observable不会再发送事件。
     */
    private void testZip() {
        Observable.zip(Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                String s = "A" + aLong;
                Log.d(TAG, "===========A发送事件：" + s);
                return s;
            }
        }), Observable.intervalRange(1, 6, 1, 1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                String s = "B" + aLong;
                Log.d(TAG, "===========B发送事件：" + s);
                return s;
            }
        }), new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) throws Exception {
                return s + "------&-----" + s2;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testZip->onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "testZip->onNext:" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testZip->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testZip->onComplete");
            }
        });
    }

    /*
    3.6 combineLatest() & combineLatestDelayError()
    方法预览：
    public static <T1,T2,R> Observable<R> combineLatest(ObservableSource<? extends T1> source1,ObservableSource<? exends T2>
    source2,BiFunction<? super T1,?super T2,? extends R>combiner)
    作用：
    combineLatest()的作用与zip()类似，但是combineLatest()发送事件的序列是与发送的时间线有关的，当combineLatest()
    中所有的Observable都发送了事件，只要其中有一个Observable发送事件，这个事件机会和其他Observable
    最近发送的事件结合起来发送，这样可能还是比较抽象，看看以下例子代码。
    用法：分析结果可以知道：当发送A1事件之后，因为B并没有发送任何事件，所以根本不会发生结合。当B发送了B1事件之后，就会与A最近发送的事件A2结合成A2B1,这样只有后面一有被观察者发送事件，这个事件就会与其他被观察者最近发送的事件结合起来了。
    combineLatestDelayError（）就是多了延迟发送onError()
     */
    private void testCombineLatest() {
        Observable.combineLatest(Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                String s = "A" + aLong;
                Log.d(TAG, "===========A发送事件：" + s);
                return s;
            }
        }), Observable.intervalRange(1, 6, 2, 2, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                String s = "B" + aLong;
                Log.d(TAG, "===========B发送事件：" + s);
                return s;
            }
        }), new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) throws Exception {
                return s + "------&-----" + s2;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testCombineLatest->onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "testCombineLatest->onNext:" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testCombineLatest->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testCombineLatest->onComplete");
            }
        });
    }

    /*
    3.7 reduce
     方法预览：
     public final MayBe<T> reduce(BiFunction<T,T,T> reducer)
     作用：与scan()操作符的作用也是将发送数据以一定的逻辑聚合起来，这两个的区别在于scan()每处理一次数据就会将事件发送给观察者，而reduce()会将所有数据聚合在一起才会发送事件给观察者。
     用法：其实就是前两个数据聚合之后，然后在与后一个数据聚合，一直到没有数据为止。
     */
    private void testReduce() {
        Observable.just(1, 2, 3, 4)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        Log.d(TAG, "applay-->integer:" + integer);
                        Log.d(TAG, "applay-->integer2:" + integer2);
                        return integer + integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "accept:" + integer);
            }
        });
    }

    /*
    3.8 collect
       方法预览：
       public final <U> single<U> collect(Callable<? extends U> initialValueSupplier, Biconsumer<? super U,? super T> collector)
       作用：将数据收集到数据结构当中
       用法：
     */
    private void testCollect() {
        Observable.just(1, 2, 3, 4)
                .collect(new Callable<ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> call() throws Exception {
                        return new ArrayList<>();
                    }
                }, new BiConsumer<ArrayList<Integer>, Integer>() {
                    @Override
                    public void accept(ArrayList<Integer> integers, Integer integer) throws Exception {
                        integers.add(integer);
                    }
                }).subscribe(new Consumer<ArrayList<Integer>>() {
            @Override
            public void accept(ArrayList<Integer> integers) throws Exception {
                Log.d(TAG, "accept:" + integers);
            }
        });
    }

    /*
    3.9 startWith() & startWithArray()
        方法预览：
        public final Observable<T> startWith(T item)
        public final Observable<T> startWithArray(T ... items)
        作用：在发送事件之前追加事件，startWith()追加一个事件，startWithArray()可以追加多个事件。追加是的事件会先发出。
        用法：
     */
    private void testStartWith() {
        Observable.just(1, 2, 3, 4)
                .startWithArray(17, 18, 19)
                .startWith(31)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "integer:" + integer);
                    }
                });
    }

    /*
    3.10 count
    方法预览：
    public final single<Long> count()
    作用：返回被观察者发送事件的数量。
    用法：
     */
    private void testCount() {
        Observable.just(1, 2, 3, 2, 3, 2, 3, 2, 3)
                .count()
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d(TAG, "accept:" + aLong);
                    }
                });
    }
    //TODO 4.功能操作符

    /*****************************************************************************************************************************/
    /*
    4.1 delay
     方法预览：
     public fianl Obsrvable<T> DELAY(long delay,TimeUnit unit)
     作用：延迟一段时间发送事件。
     用法：以下例子延迟了两秒发送事件，onSubscribe回调2秒之后onNext才会回调。
     */
    private void testDelay() {
        Observable.just(1, 2, 3, 4)
                .delay(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "testDelay->onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "testDelay->onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "testDelay->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "testDelay->onComplete");
                    }
                });
    }

    /*
    4.2 doOnEach
    方法预览：
    public final Observable<t> doOnEach(final Consumer<? super Notfication<T>> onNotification)
    作用：Observable每发送一件事件之前都会先回调这个方法。
    用法：每发送一个事件之前都会回调doOnEach方法，并且可以取出onNext发送的值。
     */
    private void testDoOnEach() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).doOnEach(new Consumer<Notification<Integer>>() {
            @Override
            public void accept(Notification<Integer> integerNotification) throws Exception {
                Log.d(TAG, "doOnEach:" + integerNotification.getValue());
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testDoOnEach->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "testDoOnEach->onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testDoOnEach->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testDoOnEach->onComplete");
            }
        });
    }

    /*
    4.3 doOnNext
    方法预览：
    public final Observable<t> doOnEach(final Consumer<? super T> onNext)
    作用：Observable每发送onNext之前都会先回调这个方法。
    用法：
     */
    private void testDoOnNext() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "doOnNext:" + integer);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testDoOnNext->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "testDoOnNext->onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testDoOnNext->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testDoOnNext->onComplete");
            }
        });
    }

    /*
    4.4 doAfterNext
    方法预览：
    public final Observable<t> doAfterNext(final Consumer<? super T> onAfterNext)
    作用：Observable每发送onNext之后都会先回调这个方法。
    用法：
     */
    private void testDoAfterNext() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).doAfterNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "testDoAfterNext:" + integer);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testDoAfterNext->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "testDoAfterNext->onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testDoAfterNext->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testDoAfterNext->onComplete");
            }
        });
    }

    /*
    4.5 doOnComplete
    方法预览：
    public final observable<T> doOnComplete(Action onComplete)
    作用：Observable 每发送onComplete()之前都会回调这个方法
    用法：
     */
    private void testOnComplete() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "doOnComplete");
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testOnComplete->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "testOnComplete->onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testOnComplete->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testOnComplete->onComplete");
            }
        });
    }

    /*
    4.6 doOnError
    方法预览：
    public fianl Observable<T> doOnError(Consumer<? extends Throwable> onError)
    作用：Observable 每发送onError()之前都会回调这个方法
    用法：
     */
    private void testDoOnError() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new NullPointerException());
                emitter.onComplete();
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.d(TAG, "doOnError:" + throwable);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "testDoOnError->onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "testDoOnError->onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "testDoOnError->onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "testDoOnError->onComplete");
            }
        });
    }

    /*
    4.7 doOnSubscribe
    方法预览：
    public fianl Observable<T> doOnSubscribe(Consumer<? super Disposable> onSubscribe)
    作用：Observable 每发送onSubscribe()之前都会回调这个方法
     */
    private void testDoOnSubscribe() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();

            }
        }).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                Log.d(TAG, "------doOnSubscribe");
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });

    }

    /*
    4.8 doOnDispose
    方法预览：
    public final Observable<T> doOnDispose(Action onDispose)
    作用:当调用Disposable的dispose()之后回调该方法。
     */
    private void testDoOnDispose() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();

            }
        }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "-----doOnDispose");
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
                this.d = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
                d.dispose();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.9 doOnLifecycle
    方法预览：
    public final Obserbable<T> doOnLifecycle(final Consumer<? super Disposable> onSubcribe,final Action onDispose)
    作用：在回调onSubscribe 之前回调该方法的第一个参数的回调方法，可以使用该回调方法决定是否取消订阅。
    用法：doOnLifecycle() 第二个参数的回调方法的作用与doOndeispose()是一样的。
         从样例打印结果:挡在onNext()方法进行取消订阅操作后，doOnDispose()和doOnLifecycle()都会被回调。
         如果使用doOnDispose Action 进行取消订阅，会发现doOnDispose Action和doOnLifecycle Action 都没有被回调。
     */
    private void testDoOnLifecycle() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();

            }
        }).doOnLifecycle(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                Log.d(TAG, "----------doOnLifecycle accept");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "----------------doOnLifecycle Accept");
            }
        }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "---------------------doOnDispose Action");
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
                this.d = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
                d.dispose();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });

        Log.i(TAG, "------------doOnLifeCycle--------");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();

            }
        }).doOnLifecycle(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                Log.d(TAG, "----------doOnLifecycle accept");
                disposable.dispose();
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "----------------doOnLifecycle Accept");
            }
        }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "---------------------doOnDispose Action");
            }
        }).subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.10 doOnTerminate() & doAfterTerminate()
    方法预览：
    Public final Observable<T> doOnTerminate(final Action onTerminate)
    public final Observable<T> doAfterTerminate(Action onFinally)
    作用：doOnTerminate是在onError 或者onComplete 发送之前回调，而doAfterTerminate则是onError或者onComplete发送之后回调
    用法：
     */
    private void testDoOnTerminate() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();

            }
        }).doOnTerminate(new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "---------------------doOnTerminate Action");
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
        Log.d(TAG, "-------------------------doAfterTerminate--------------------------------------------------------");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();

            }
        }).doAfterTerminate(new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "---------------------doOnTerminate Action");
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.11 doFinally()
    方法预览：
    public final Observable<T> doFinally(Action onFinally)
    作用：在所有事件发送完毕之后回调该方法。
    用法：doFinally()和doAfterTerminate()到底有什么区别？区别就在于取消订阅，如果取消订阅之后doAfterTerminate()就不会被回调，而doFinally()无论怎么样都会被回调，且都在事件序列的最后。
         如果调用了dispose()方法，doAfterTerminate()不会被回调。
         如果把onNext()中的dispose()注释掉，doAfterTerminate()已经成功回调，doFinally()还是会在事件序列的最后。
     */
    private void testDoFinally() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();

            }
        }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "---------------------doFinally Action");
            }
        }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "---------------------doOnDispose");
            }
        }).doAfterTerminate(new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "---------------------doAfterTerminate");
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
                this.d = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
                d.dispose();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.12 onERrorReturn
     方法预览：
     public final Observable<T> onErrorReturn(Function<? super Throwable,?extends T> valueSupplier)
     作用：当接收到一个onError()事件之后回调，返回的值会回调onNext()方法，并正常结束该事件序列。
     用法：以下示例中不会再调用4,5的事件
     */
    private void testOnErrorReturn() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new NullPointerException());
                //以下不调用了，onNext 404,onComplete
                emitter.onNext(4);
                emitter.onNext(5);

            }
        }).onErrorReturn(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable throwable) throws Exception {
                Log.d(TAG, "--------onErrorReturn:" + throwable);
                return 404;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.13 onErrorResumeNext
    方法预览：
    public final Observable<T> onErrorResumeNext(Function<? super Throwable,? extends observableSource<? extends T>>
    resumeFunction)
    作用：当接收到onError()事件时，返回一个新的Observable,并正常结束事件序列。
     */
    private void testOnErrorResumeNext() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new NullPointerException());
                emitter.onNext(4);
            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> apply(Throwable throwable) throws Exception {
                Log.d(TAG, "---------------------------onErrorRsumeNext:" + throwable);
                return Observable.just(14, 15, 16);
            }
        }).subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.14 onExceptionResumeNext
    方法预览：
    public final Observable<T> onExceptionResumeNext(final ObservableSource<? extends T> next)
    作用：与onErrorResumeNext()作用基本一致，但是这个方法只能捕捉Ecxeption.
    用法：
     */
    private void testOnExceptionResumeNext() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new Error("404"));//从结果知道;观察者收到onError()事件，证明onExcepionResumeNext()不能捕捉Error事件。
                //emitter.onError(new Exception("404"));//这个方法成功捕获Exception 事件。
                emitter.onNext(4);
            }
        }).onExceptionResumeNext(new Observable<Integer>() {
            @Override
            protected void subscribeActual(Observer<? super Integer> observer) {
                observer.onNext(21);
                observer.onNext(22);
                observer.onComplete();
            }
        }).subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.15 retry
    方法预览：
    public final Observable<T> retry(long times)
    作用：如果出现错误事件，则会重新发送所有事件序列。times是代表重新发的次数。
    用法：以下代码重新发送2次后，发送onError
     */
    private void testRetry() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new Exception("404"));
                emitter.onNext(4);
            }
        }).retry(2).subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.16 retryUntil
    方法预览：
    public final Observable<T> retryUntil(final BooleanSupplier stop)
    作用：出现错误事件之后，可以通过此方法判断是否继续发送事件。
    用法：以下代码当返回true时，停止发送；当返回false，持续发送。
     */
    private int m = 5;

    private void testRetryUntil() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new Exception("404"));
                emitter.onNext(4);
            }
        }).retryUntil(new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() throws Exception {
                if (m == 6) {
                    return true;
                }
                return false;
            }
        })
                .subscribe(new Observer<Integer>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "----onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----onComplete");
                    }
                });
    }

    /*
    4.17 retryWhen
    方法预览
    public fianl void retryWhen(Func1<? super Observable<? extends java.lang.Throwable>,? extends Observable<?>>
    notificationHandler)
    作用：当被观察者接收到异常或者错误事件时会回调该方法，这个方法会返回一个新的被观察者。如果返回的被观察者发送Error事件则之前的被观察者不会继续发送事件，如果发送正常事件则之前的被观察者会继续不断重试发送事件。
    用法：把404换成303,会持续不断的发送消息。
     */
    private void retryWhen() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("abc");
                emitter.onNext("bbd");
                emitter.onError(new Exception("404"));
                emitter.onNext("ccd");

            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
                        if (!throwable.toString().equals("java.lang.Exception: 404")) {//注意String字符串404，前面有空格
                            // if(!throwable.toString().equals("java.lang.Exception: 303")){//换成303，数据会一直发
                            return Observable.just("可以忽略的异常");
                        } else {
                            return Observable.error(new Throwable("终止啦"));
                        }
                    }
                });
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "----onNext:" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.18 repeat
    public final Observable<T> repeat(long times)
    作用：重复发送被观察者的事件，times为发送次数
    用法：当repeat()内部无参数，会持续发送；数据不是按次序发送
     */
    private void testRepeat() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).repeat(3).subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.19 repeatWhen
     方法预览：
     public final Observable<T> repeatWhen(final Function<? super Observable<Object>,? extends ObservableSource<?>> handler)
     作用：这个方法可以返回一个新的被观察者，设定一个逻辑来决定是否重复发送事件。
     用法：这里分三种情况，如果新的观察者返回onComplete或者onError事件，则旧的被观察者不会再继续发送事件。如果被观察者返回其他事件，则会重复发送事件。
     */
    private void testRepeatWhen() {
        Log.d(TAG, "-----------------------onComplete----------------------------");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return Observable.empty();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
        Log.d(TAG, "-----------------------Observable.error(new Exception(404))----------------------------");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return Observable.error(new Exception("404"));
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
        Log.d(TAG, "-----------------------Observable.just(4)----------------------------");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return Observable.just(4);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
        Log.d(TAG, "-----------------------null----------------------------");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return null;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    4.20 subscrbeOn
    方法预览：
    public final Observable<T> subscribeOn(Scheduler scheduler)
    作用：指定被观察者的线程，要注意的是，如果多次调用此方法，只有第一次有效。
    用法：1>打印结果被观察者的线程名字是主线程。
         2>.subscribeOn(Schedulers.newThread()),打印结果被观察者十字一条新的线程。
         3>.多次调用，可以看到第二次调用的subscribeOn(Schedulers.newThread())并没有效果。
     */
    private void testSubscribeOn() {
        Log.i(TAG, "----------1>打印结果被观察者的线程名字是主线程。-------------------------------------------------------------");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "-------------------currentThread name:" + Thread.currentThread().getName());
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        Log.i(TAG, "----------2>.subscribeOn(Schedulers.newThread())" +
                "-------------------------------------------------------------");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "-------------------currentThread name:" + Thread.currentThread().getName());
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "----onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----onComplete");
                    }
                });
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        Log.i(TAG, "----------3>.多次调用-------------------------------------------------------------");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "-------------------currentThread name:" + Thread.currentThread().getName());
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.computation())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "----onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----onComplete");
                    }
                });
    }

    /*
    4.21 observeOn()
    方法预览：
    public final Observable<T> observeOn(Scheduler scheduler)
    作用：指定观察者的线程，每指定一次就会生效一次。
    用法：查看打印结果可以知道，observeOn成功切换了线程。
     */
    private void testObserveOn() {
        Observable.just(1, 2, 3)
                .observeOn(Schedulers.newThread())
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Exception {
                        Log.d(TAG, "------------flatmap Thread name:" + Thread.currentThread().getName());
                        return Observable.just("ideal:" + integer);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "---------------------------------onNext Thread name:" + Thread.currentThread().getName());
                        Log.d(TAG, "----onNext:" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----onComplete");
                    }
                });
    }
    //TODO 5.过滤操作符

    /*********************************************************************************************************************************/
    /*
    5.1 filter()
    方法预览：
    public final Observable<T> filter(Predicate<? super T> predicate)
    作用：通过一定逻辑来过滤被观察者发送的事件，如果返回true则会发送事件，否则不会发送。
    用法：以下事件只有在不等于2的事件才会发送。

     */
    private void testFilter() {
        Observable.just(1, 2, 3)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer != 2;
                    }
                }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "----onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "---------------------------------onNext Thread name:" + Thread.currentThread().getName());
                Log.d(TAG, "----onNext:" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "----onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "----onComplete");
            }
        });
    }

    /*
    5.2 ofType
    方法预览：
    public fianl <U> Obsrvable<U> ofType(final Class<U> clazz)
    作用：可以过滤不符合该类型事件。
    用法：
     */
    private void testOfType() {
        Observable.just(1, 2, 3, "ideal", "kuke")
                .ofType(Integer.class)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "----onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----onComplete");
                    }
                });
    }

    /*
    5.3 skip
    方法预览：
    pubic final Observable<T> skip(long count)
    作用：跳过郑旭某些事件，count代表跳过事件的数量
    用法：
    skipLast()作用也是跳过某些事件，不过它是用来跳过正序的后面的事件。//这里没有讲解
     */
    private void testSkip() {
        Observable.just(1, 2, 3)
                .skip(2)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "----onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----onComplete");
                    }
                });
    }

    /*
    5.4 distinct
    方法预览：
    public final Observable<T> distinct()
    作用：过滤事件序列中的重复事件。
     */
    private void testDistinct() {
        Observable.just(1, 2, 3, 3, 2, 1)
                .distinct()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "----onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----onComplete");
                    }
                });
    }

    /*
    5.5 distinctUntilChanged
    方法预览：
    public final Observable<T> distinctUntilChanged()
    作用：过滤掉连续重复的事件
         例如：事件序列中连续出现两次3，所以第二次3并不会发出。
     */
    private void testDistinctUntilChanged() {
        Observable.just(1, 2, 3, 3, 2, 1)
                .distinctUntilChanged()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "----onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----onComplete");
                    }
                });
    }

    /*
    5.6 take
    方法预览：
    public final Observable<T> take(long count)
    作用：控制观察者接收的事件的数量
    用法：
    takeLast() 的作用就是控制观察者只能接受事件序列的后面几件事情。这里没做示例。
     */
    private void testTake() {
        Observable.just(1, 2, 3, 3, 2, 1)
                .take(3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "----onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----onComplete");
                    }
                });
    }

    /*
    5.7 debounce
    方法预览：
    public final Observable<T> debounce(long timeout,TimeUnit unit)
    作用：如果两件事发送的时间间隔小于设定的时间间隔则前一件事就不会发送给观察者。
    以下示例：1，没有发出去。如果时间改为1000，1就会发出去。
     */
    private void testDebounce() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                Thread.sleep(900);
                emitter.onNext(2);
            }
        }).debounce(1, TimeUnit.SECONDS)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "----onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----onComplete");
                    }
                });
    }

    /*
    5.8 firstElement() && lastElement()
    方法预览：
    public final Maybe<T> firstElement()
    public final Maybe<T> lastElement()
    作用：firstElement取时间序列的第一个元素，lastElement()取时间序列的最后一个元素。
    用法：
     */
    private void testFirstElement() {
        Log.d(TAG, "------------------firstElement------------------------------");
        Observable.just(1, 2, 3, 4)
                .firstElement()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i(TAG, "------------------------firstElement:" + integer);
                    }
                });
        Log.d(TAG, "------------------lastElement------------------------------");
        Observable.just(1, 2, 3, 4)
                .lastElement()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.i(TAG, "------------------------------lastElement:" + integer);
                    }
                });

    }

    /*
    5.9 elementAt() & elementAtOrError()
    方法预览：
    public final Maybe<T> elementAt(long index)
    public fianl Single<T> elementAtOrError(long index)
    作用：elementAt()可以指定取出事件序列中事件，但是输入的index超出事件序列的总数的话就不会出现任何结果。这种情况下，你想发出异常信息的话就用elementAtOrError().
    用法：
     */
    private void testElementAt() {
        Log.d(TAG, "-------------index=0----------------------");
        Observable.just(1, 2, 3, 4)
                .elementAt(0)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "-------------accept:" + integer);
                    }
                });
        Log.d(TAG, "-------------index=5--超出索引，没有打印结果--------------------");
        Observable.just(1, 2, 3, 4)
                .elementAt(5)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "-------------accept:" + integer);
                    }
                });
        //        Log.d(TAG,"----------elementAtOrError---index=5--抛出异常OnErrorNotImplementedException--------------------");
        //        Observable.just(1,2,3,4)
        //                .elementAtOrError(5)
        //                .subscribe(new Consumer<Integer>() {
        //                    @Override
        //                    public void accept(Integer integer) throws Exception {
        //                     Log.d(TAG,"-------------accept:"+integer);
        //                    }
        //                });
    }
    //TODO 6. 条件操作符

    /***************************************************************************************************************************/
    /*
    6.1 all
    方法预览：
    public final Single<Boolean> all(Predicate<? super T> predicate)
    作用：判断时间序列是否全部满足某个时间，如果都满足则返回true,反之则返回false.
    用法：

     */
    private void testAll() {
        Observable.just(1, 2, 3, 4)
                .all(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 5;
                    }
                }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.d(TAG, "-------accept:" + aBoolean);
            }
        });
    }

    /*
    6.2 takeWhile()
    方法预览：
    public final Observable<T> takeWhile(Predicate<? super T> predicate)
    作用：可以设置条件，当摸个数据满足条件时就会发送该数据，反之则不发送。
    用法：

     */
    private void testTakeWhile() {
        Observable.just(1, 2, 3, 4)
                .takeWhile(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 3;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "integer:" + integer);
            }
        });
    }

    /*
    6.3 skipWhile
    方法预览：
    public finalObservable<T> skipWhile(Predicate<? super T> predicate)
    作用：可以设置条件，当某个数据满足条件时不发送该数据，反之则发送。
    用法：

     */
    private void testSkipWhile() {
        Observable.just(1, 2, 3, 4)
                .skipWhile(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 3;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "integer:" + integer);
            }
        });
    }

    /*
    6.4 takeUntil
    方法预览：
    public final Observable<T> takeUntil(Predicate<? super T> stopPredicate)
    作用：可以设置条件，当事件满足此条件时，下一次的事件就不会被发送了。
    用法：
     */
    private void takeUntil() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .takeUntil(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 3;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "integer:" + integer);
            }
        });
    }

    /*
    6.5 skipUntil
    方法预览：
    public final <U> Observable<T> skipUntil(ObserbableSource<U> other)
    作用：当skipUntil()中的Observable 发送事件了，原来的Observable 才会发送事件给观察者。
    用法：从结果看，skipUntil()里的Observable并不会发送事件给观察者。
     */
    private void testSkipUntil() {
        Observable.intervalRange(1, 5, 0, 1, TimeUnit.SECONDS)
                .skipUntil(Observable.intervalRange(6, 5, 3, 1, TimeUnit.SECONDS))
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "----->onSubscribe");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "----->onNext:" + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "----->onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "----->onComplete");
                    }
                });
    }

    /*
    6.6 sequenceEqual
       方法预览：
       public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> source1,ObservableSource<? extends T>
       source2)
       作用：判断两个Observable发送的事件是否相同。
     */
    private void testSequenceEqual() {
        Observable.sequenceEqual(Observable.just(1, 2, 3), Observable.just(1, 2, 3))
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.d(TAG, "--------------------------onNext:" + aBoolean);
                    }
                });
    }

    /*
    6.7 contains
       方法预览：
       public final Single<Boolean> contains(final Object element)
       作用:判断事件序列中是否含有某个元素，如果有则返回true,如果没有则返回false.
     */
    private void testContains() {
        Observable.just(1, 2, 3, 4)
                .contains(3)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.d(TAG, "----accept:" + aBoolean);
                    }
                });
        Log.d(TAG, "--------------------false---------------------------------");
        Observable.just(1, 2, 3, 4)
                .contains(6)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.d(TAG, "----accept:" + aBoolean);
                    }
                });
    }

    /*
    6.8 isEmpty
    方法预览：
    public fial Single<Boolean> isEmpty()
    作用：判断事件序列是否为空
    用法：
     */
    private void testIsEmpty() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onComplete();
            }
        })
                .isEmpty()
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.d(TAG, "-----accept:" + aBoolean);
                    }
                });
    }

    /*
    6.9 amb
    方法预览：
    public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> sources)
    作用：amb()要传入一个Observable集合，但是只会发送事件的Observable的事件，其余Observable将要被丢弃。
     */
    private void testAmb() {
        ArrayList<Observable<Long>> list = new ArrayList<>();
        list.add(Observable.intervalRange(1, 5, 2, 1, TimeUnit.SECONDS));
        list.add(Observable.intervalRange(6, 5, 0, 1, TimeUnit.SECONDS));
        Observable.amb(list)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d(TAG, "-----accept:" + aLong);
                    }
                });
    }

    /*
    6.10 defaultIfEmpty
    方法预览：
    public final Observable<t> defaultIfEmpty(T defaultItem)
    作用：如果观察者只发送一个onCompleteJ()事件，则可以利用这个方法发送一个值。
    用法：
     */
    private void testDefaultIfEmpty() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onComplete();
            }
        }).defaultIfEmpty(666)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "--------------------------------accept:" + integer);
                    }
                });
    }
    /*
       Log.d(TAG,"----->onSubscribe");
       Log.d(TAG,"----->onNext:"+s);
       Log.d(TAG,"----->onError");
       Log.d(TAG,"----->onComplete");
     */
}
