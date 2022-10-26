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
/* loaded from: classes8.dex */
public final class BehaviorProcessor extends FlowableProcessor {
    public static /* synthetic */ Interceptable $ic;
    public static final BehaviorSubscription[] EMPTY;
    public static final Object[] EMPTY_ARRAY;
    public static final BehaviorSubscription[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public long index;
    public final ReadWriteLock lock;
    public final Lock readLock;
    public final AtomicReference subscribers;
    public final AtomicReference terminalEvent;
    public final AtomicReference value;
    public final Lock writeLock;

    /* loaded from: classes8.dex */
    public final class BehaviorSubscription extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3293175281126227086L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;
        public volatile boolean cancelled;
        public boolean emitting;
        public boolean fastPath;
        public long index;
        public boolean next;
        public AppendOnlyLinkedArrayList queue;
        public final BehaviorProcessor state;

        public BehaviorSubscription(Subscriber subscriber, BehaviorProcessor behaviorProcessor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, behaviorProcessor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }

        public void emitLoop() {
            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
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

        public boolean isFull() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (get() == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void emitFirst() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                BehaviorProcessor behaviorProcessor = this.state;
                Lock lock = behaviorProcessor.readLock;
                lock.lock();
                this.index = behaviorProcessor.index;
                Object obj = behaviorProcessor.value.get();
                lock.unlock();
                if (obj != null) {
                    z = true;
                } else {
                    z = false;
                }
                this.emitting = z;
                this.next = true;
                if (obj == null || test(obj)) {
                    return;
                }
                emitLoop();
            }
        }

        public void emitNext(Object obj, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLJ(1048579, this, obj, j) != null) || this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j) {
                        return;
                    }
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
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

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048581, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
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
                    long j = get();
                    if (j != 0) {
                        this.actual.onNext(NotificationLite.getValue(obj));
                        if (j != Long.MAX_VALUE) {
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

    @CheckReturnValue
    public static BehaviorProcessor create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new BehaviorProcessor();
        }
        return (BehaviorProcessor) invokeV.objValue;
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

    public Object getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object obj = this.value.get();
            if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                return NotificationLite.getValue(obj);
            }
            return null;
        }
        return invokeV.objValue;
    }

    public Object[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object[] values = getValues(EMPTY_ARRAY);
            if (values == EMPTY_ARRAY) {
                return new Object[0];
            }
            return values;
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return NotificationLite.isComplete(this.value.get());
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (((BehaviorSubscription[]) this.subscribers.get()).length != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return NotificationLite.isError(this.value.get());
        }
        return invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Object obj = this.value.get();
            if (obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || !this.terminalEvent.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            return;
        }
        Object complete = NotificationLite.complete();
        for (BehaviorSubscription behaviorSubscription : terminate(complete)) {
            behaviorSubscription.emitNext(complete, this.index);
        }
    }

    public int subscriberCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return ((BehaviorSubscription[]) this.subscribers.get()).length;
        }
        return invokeV.intValue;
    }

    public BehaviorProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = new AtomicReference();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = this.lock.writeLock();
        this.subscribers = new AtomicReference(EMPTY);
        this.terminalEvent = new AtomicReference();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BehaviorProcessor(Object obj) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.value.lazySet(ObjectHelper.requireNonNull(obj, "defaultValue is null"));
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
            for (BehaviorSubscription behaviorSubscription : terminate(error)) {
                behaviorSubscription.emitNext(error, this.index);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, obj) == null) {
            ObjectHelper.requireNonNull(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.terminalEvent.get() != null) {
                return;
            }
            Object next = NotificationLite.next(obj);
            setCurrent(next);
            for (BehaviorSubscription behaviorSubscription : (BehaviorSubscription[]) this.subscribers.get()) {
                behaviorSubscription.emitNext(next, this.index);
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, subscriber) == null) {
            BehaviorSubscription behaviorSubscription = new BehaviorSubscription(subscriber, this);
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
            Throwable th = (Throwable) this.terminalEvent.get();
            if (th == ExceptionHelper.TERMINATED) {
                subscriber.onComplete();
            } else {
                subscriber.onError(th);
            }
        }
    }

    @CheckReturnValue
    public static BehaviorProcessor createDefault(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            ObjectHelper.requireNonNull(obj, "defaultValue is null");
            return new BehaviorProcessor(obj);
        }
        return (BehaviorProcessor) invokeL.objValue;
    }

    public boolean add(BehaviorSubscription behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, behaviorSubscription)) == null) {
            do {
                behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
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

    public BehaviorSubscription[] terminate(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            BehaviorSubscription[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
            BehaviorSubscription[] behaviorSubscriptionArr2 = TERMINATED;
            if (behaviorSubscriptionArr != behaviorSubscriptionArr2 && (behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.getAndSet(behaviorSubscriptionArr2)) != TERMINATED) {
                setCurrent(obj);
            }
            return behaviorSubscriptionArr;
        }
        return (BehaviorSubscription[]) invokeL.objValue;
    }

    public Object[] getValues(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) {
            Object obj = this.value.get();
            if (obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                Object value = NotificationLite.getValue(obj);
                if (objArr.length != 0) {
                    objArr[0] = value;
                    if (objArr.length != 1) {
                        objArr[1] = null;
                        return objArr;
                    }
                    return objArr;
                }
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 1);
                objArr2[0] = value;
                return objArr2;
            }
            if (objArr.length != 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        return (Object[]) invokeL.objValue;
    }

    public boolean offer(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (obj == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return true;
            }
            BehaviorSubscription[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
            for (BehaviorSubscription behaviorSubscription : behaviorSubscriptionArr) {
                if (behaviorSubscription.isFull()) {
                    return false;
                }
            }
            Object next = NotificationLite.next(obj);
            setCurrent(next);
            for (BehaviorSubscription behaviorSubscription2 : behaviorSubscriptionArr) {
                behaviorSubscription2.emitNext(next, this.index);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void remove(BehaviorSubscription behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, behaviorSubscription) == null) {
            do {
                behaviorSubscriptionArr = (BehaviorSubscription[]) this.subscribers.get();
                int length = behaviorSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (behaviorSubscriptionArr[i2] == behaviorSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    behaviorSubscriptionArr2 = EMPTY;
                } else {
                    BehaviorSubscription[] behaviorSubscriptionArr3 = new BehaviorSubscription[length - 1];
                    System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i);
                    System.arraycopy(behaviorSubscriptionArr, i + 1, behaviorSubscriptionArr3, i, (length - i) - 1);
                    behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
        }
    }
}
