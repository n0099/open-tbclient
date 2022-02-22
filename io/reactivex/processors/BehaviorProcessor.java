package io.reactivex.processors;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes5.dex */
public final class BehaviorProcessor<T> extends FlowableProcessor<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final BehaviorSubscription[] EMPTY;
    public static final Object[] EMPTY_ARRAY;
    public static final BehaviorSubscription[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public long index;
    public final ReadWriteLock lock;
    public final Lock readLock;
    public final AtomicReference<BehaviorSubscription<T>[]> subscribers;
    public final AtomicReference<Throwable> terminalEvent;
    public final AtomicReference<Object> value;
    public final Lock writeLock;

    /* loaded from: classes5.dex */
    public static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3293175281126227086L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public volatile boolean cancelled;
        public boolean emitting;
        public boolean fastPath;
        public long index;
        public boolean next;
        public AppendOnlyLinkedArrayList<Object> queue;
        public final BehaviorProcessor<T> state;

        public BehaviorSubscription(Subscriber<? super T> subscriber, BehaviorProcessor<T> behaviorProcessor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, behaviorProcessor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.state = behaviorProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.remove(this);
        }

        public void emitFirst() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                BehaviorProcessor<T> behaviorProcessor = this.state;
                Lock lock = behaviorProcessor.readLock;
                lock.lock();
                this.index = behaviorProcessor.index;
                Object obj = behaviorProcessor.value.get();
                lock.unlock();
                this.emitting = obj != null;
                this.next = true;
                if (obj == null || test(obj)) {
                    return;
                }
                emitLoop();
            }
        }

        public void emitLoop() {
            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                while (!this.cancelled) {
                    synchronized (this) {
                        appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            this.emitting = false;
                            return;
                        }
                        this.queue = null;
                    }
                    appendOnlyLinkedArrayList.forEachWhile(this);
                }
            }
        }

        public void emitNext(Object obj, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(1048579, this, obj, j2) == null) || this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j2) {
                        return;
                    }
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(obj);
        }

        public boolean isFull() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? get() == 0 : invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this, j2);
            }
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (this.cancelled) {
                    return true;
                }
                if (NotificationLite.isComplete(obj)) {
                    this.actual.onComplete();
                    return true;
                } else if (NotificationLite.isError(obj)) {
                    this.actual.onError(NotificationLite.getError(obj));
                    return true;
                } else {
                    long j2 = get();
                    if (j2 != 0) {
                        this.actual.onNext((Object) NotificationLite.getValue(obj));
                        if (j2 != Long.MAX_VALUE) {
                            decrementAndGet();
                            return false;
                        }
                        return false;
                    }
                    cancel();
                    this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1504497820, "Lio/reactivex/processors/BehaviorProcessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1504497820, "Lio/reactivex/processors/BehaviorProcessor;");
                return;
            }
        }
        EMPTY_ARRAY = new Object[0];
        EMPTY = new BehaviorSubscription[0];
        TERMINATED = new BehaviorSubscription[0];
    }

    public BehaviorProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = new AtomicReference<>();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = this.lock.writeLock();
        this.subscribers = new AtomicReference<>(EMPTY);
        this.terminalEvent = new AtomicReference<>();
    }

    @CheckReturnValue
    public static <T> BehaviorProcessor<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new BehaviorProcessor<>() : (BehaviorProcessor) invokeV.objValue;
    }

    @CheckReturnValue
    public static <T> BehaviorProcessor<T> createDefault(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            ObjectHelper.requireNonNull(t, "defaultValue is null");
            return new BehaviorProcessor<>(t);
        }
        return (BehaviorProcessor) invokeL.objValue;
    }

    public boolean add(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription<T>[] behaviorSubscriptionArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, behaviorSubscription)) == null) {
            do {
                behaviorSubscriptionArr = this.subscribers.get();
                if (behaviorSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = behaviorSubscriptionArr.length;
                behaviorSubscriptionArr2 = new BehaviorSubscription[length + 1];
                System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
                behaviorSubscriptionArr2[length] = behaviorSubscription;
            } while (!this.subscribers.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = this.value.get();
            if (NotificationLite.isError(obj)) {
                return NotificationLite.getError(obj);
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    public T getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object obj = this.value.get();
            if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
                return null;
            }
            return (T) NotificationLite.getValue(obj);
        }
        return (T) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.processors.BehaviorProcessor<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object[] values = getValues(EMPTY_ARRAY);
            return values == EMPTY_ARRAY ? new Object[0] : values;
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? NotificationLite.isComplete(this.value.get()) : invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.subscribers.get().length != 0 : invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? NotificationLite.isError(this.value.get()) : invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Object obj = this.value.get();
            return (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Experimental
    public boolean offer(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return true;
            }
            BehaviorSubscription<T>[] behaviorSubscriptionArr = this.subscribers.get();
            for (BehaviorSubscription<T> behaviorSubscription : behaviorSubscriptionArr) {
                if (behaviorSubscription.isFull()) {
                    return false;
                }
            }
            Object next = NotificationLite.next(t);
            setCurrent(next);
            for (BehaviorSubscription<T> behaviorSubscription2 : behaviorSubscriptionArr) {
                behaviorSubscription2.emitNext(next, this.index);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.terminalEvent.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorSubscription<T> behaviorSubscription : terminate(complete)) {
                behaviorSubscription.emitNext(complete, this.index);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.terminalEvent.compareAndSet(null, th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            Object error = NotificationLite.error(th);
            for (BehaviorSubscription<T> behaviorSubscription : terminate(error)) {
                behaviorSubscription.emitNext(error, this.index);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, t) == null) {
            ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.terminalEvent.get() != null) {
                return;
            }
            Object next = NotificationLite.next(t);
            setCurrent(next);
            for (BehaviorSubscription<T> behaviorSubscription : this.subscribers.get()) {
                behaviorSubscription.emitNext(next, this.index);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, subscription) == null) {
            if (this.terminalEvent.get() != null) {
                subscription.cancel();
            } else {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.processors.BehaviorProcessor$BehaviorSubscription<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, behaviorSubscription) == null) {
            do {
                behaviorSubscriptionArr = this.subscribers.get();
                int length = behaviorSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (behaviorSubscriptionArr[i3] == behaviorSubscription) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    behaviorSubscriptionArr2 = EMPTY;
                } else {
                    BehaviorSubscription[] behaviorSubscriptionArr3 = new BehaviorSubscription[length - 1];
                    System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i2);
                    System.arraycopy(behaviorSubscriptionArr, i2 + 1, behaviorSubscriptionArr3, i2, (length - i2) - 1);
                    behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
        }
    }

    public void setCurrent(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, obj) == null) {
            Lock lock = this.writeLock;
            lock.lock();
            this.index++;
            this.value.lazySet(obj);
            lock.unlock();
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, subscriber) == null) {
            BehaviorSubscription<T> behaviorSubscription = new BehaviorSubscription<>(subscriber, this);
            subscriber.onSubscribe(behaviorSubscription);
            if (add(behaviorSubscription)) {
                if (behaviorSubscription.cancelled) {
                    remove(behaviorSubscription);
                    return;
                } else {
                    behaviorSubscription.emitFirst();
                    return;
                }
            }
            Throwable th = this.terminalEvent.get();
            if (th == ExceptionHelper.TERMINATED) {
                subscriber.onComplete();
            } else {
                subscriber.onError(th);
            }
        }
    }

    public int subscriberCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.subscribers.get().length : invokeV.intValue;
    }

    public BehaviorSubscription<T>[] terminate(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            BehaviorSubscription<T>[] behaviorSubscriptionArr = this.subscribers.get();
            BehaviorSubscription<T>[] behaviorSubscriptionArr2 = TERMINATED;
            if (behaviorSubscriptionArr != behaviorSubscriptionArr2 && (behaviorSubscriptionArr = this.subscribers.getAndSet(behaviorSubscriptionArr2)) != TERMINATED) {
                setCurrent(obj);
            }
            return behaviorSubscriptionArr;
        }
        return (BehaviorSubscription[]) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public T[] getValues(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) {
            Object obj = this.value.get();
            if (obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                Object value = NotificationLite.getValue(obj);
                if (tArr.length != 0) {
                    tArr[0] = value;
                    if (tArr.length != 1) {
                        tArr[1] = 0;
                        return tArr;
                    }
                    return tArr;
                }
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = value;
                return tArr2;
            }
            if (tArr.length != 0) {
                tArr[0] = 0;
            }
            return tArr;
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BehaviorProcessor(T t) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.value.lazySet(ObjectHelper.requireNonNull(t, "defaultValue is null"));
    }
}
