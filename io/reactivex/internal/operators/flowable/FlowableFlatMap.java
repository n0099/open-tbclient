package io.reactivex.internal.operators.flowable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final boolean delayErrors;
    public final Function<? super T, ? extends Publisher<? extends U>> mapper;
    public final int maxConcurrency;

    /* loaded from: classes8.dex */
    public static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4606175640614850599L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public volatile boolean done;
        public int fusionMode;
        public final long id;
        public final int limit;
        public final MergeSubscriber<T, U> parent;
        public long produced;
        public volatile SimpleQueue<U> queue;

        public InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mergeSubscriber, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = j;
            this.parent = mergeSubscriber;
            int i3 = mergeSubscriber.bufferSize;
            this.bufferSize = i3;
            this.limit = i3 >> 2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (get() == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.innerError(this, th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, u) == null) {
                if (this.fusionMode != 2) {
                    this.parent.tryEmit(u, this);
                } else {
                    this.parent.drain();
                }
            }
        }

        public void requestMore(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && this.fusionMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= this.limit) {
                    this.produced = 0L;
                    get().request(j2);
                    return;
                }
                this.produced = j2;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) && SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                    }
                }
                subscription.request(this.bufferSize);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final InnerSubscriber<?, ?>[] CANCELLED;
        public static final InnerSubscriber<?, ?>[] EMPTY;
        public static final long serialVersionUID = -2117620485640801370L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super U> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final AtomicThrowable errs;
        public long lastId;
        public int lastIndex;
        public final Function<? super T, ? extends Publisher<? extends U>> mapper;
        public final int maxConcurrency;
        public volatile SimplePlainQueue<U> queue;
        public final AtomicLong requested;
        public int scalarEmitted;
        public final int scalarLimit;
        public final AtomicReference<InnerSubscriber<?, ?>[]> subscribers;
        public long uniqueId;
        public Subscription upstream;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(368468998, "Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(368468998, "Lio/reactivex/internal/operators/flowable/FlowableFlatMap$MergeSubscriber;");
                    return;
                }
            }
            EMPTY = new InnerSubscriber[0];
            CANCELLED = new InnerSubscriber[0];
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SimplePlainQueue<U> simplePlainQueue;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeAll();
                if (getAndIncrement() == 0 && (simplePlainQueue = this.queue) != null) {
                    simplePlainQueue.clear();
                }
            }
        }

        public void clearScalarQueue() {
            SimplePlainQueue<U> simplePlainQueue;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (simplePlainQueue = this.queue) != null) {
                simplePlainQueue.clear();
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public SimpleQueue<U> getMainQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                SimplePlainQueue<U> simplePlainQueue = this.queue;
                if (simplePlainQueue == null) {
                    if (this.maxConcurrency == Integer.MAX_VALUE) {
                        simplePlainQueue = new SpscLinkedArrayQueue<>(this.bufferSize);
                    } else {
                        simplePlainQueue = new SpscArrayQueue<>(this.maxConcurrency);
                    }
                    this.queue = simplePlainQueue;
                }
                return simplePlainQueue;
            }
            return (SimpleQueue) invokeV.objValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        public MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.errs = new AtomicThrowable();
            this.subscribers = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.actual = subscriber;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            this.scalarLimit = Math.max(1, i >> 1);
            this.subscribers.lazySet(EMPTY);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber<?, ?>[]> */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean addInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, innerSubscriber)) == null) {
                do {
                    innerSubscriberArr = this.subscribers.get();
                    if (innerSubscriberArr == CANCELLED) {
                        innerSubscriber.dispose();
                        return false;
                    }
                    int length = innerSubscriberArr.length;
                    innerSubscriberArr2 = new InnerSubscriber[length + 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                    innerSubscriberArr2[length] = innerSubscriber;
                } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, subscription) == null) && SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.actual.onSubscribe(this);
                if (!this.cancelled) {
                    int i = this.maxConcurrency;
                    if (i == Integer.MAX_VALUE) {
                        subscription.request(Long.MAX_VALUE);
                    } else {
                        subscription.request(i);
                    }
                }
            }
        }

        public boolean checkTerminate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.cancelled) {
                    clearScalarQueue();
                    return true;
                } else if (!this.delayErrors && this.errs.get() != null) {
                    clearScalarQueue();
                    Throwable terminate = this.errs.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        this.actual.onError(terminate);
                    }
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public void disposeAll() {
            InnerSubscriber<?, ?>[] andSet;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
                InnerSubscriber<?, ?>[] innerSubscriberArr2 = CANCELLED;
                if (innerSubscriberArr != innerSubscriberArr2 && (andSet = this.subscribers.getAndSet(innerSubscriberArr2)) != CANCELLED) {
                    for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                        innerSubscriber.dispose();
                    }
                    Throwable terminate = this.errs.terminate();
                    if (terminate != null && terminate != ExceptionHelper.TERMINATED) {
                        RxJavaPlugins.onError(terminate);
                    }
                }
            }
        }

        public void drainLoop() {
            boolean z;
            long j;
            long j2;
            boolean z2;
            InnerSubscriber<T, U>[] innerSubscriberArr;
            int i;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                Subscriber<? super U> subscriber = this.actual;
                int i2 = 1;
                while (!checkTerminate()) {
                    SimplePlainQueue<U> simplePlainQueue = this.queue;
                    long j4 = this.requested.get();
                    if (j4 == Long.MAX_VALUE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    long j5 = 0;
                    long j6 = 0;
                    if (simplePlainQueue != null) {
                        while (true) {
                            long j7 = 0;
                            Object obj = null;
                            while (true) {
                                if (j4 == 0) {
                                    break;
                                }
                                U poll = simplePlainQueue.poll();
                                if (checkTerminate()) {
                                    return;
                                }
                                if (poll == null) {
                                    obj = poll;
                                    break;
                                }
                                subscriber.onNext(poll);
                                j6++;
                                j7++;
                                j4--;
                                obj = poll;
                            }
                            if (j7 != 0) {
                                if (z) {
                                    j4 = Long.MAX_VALUE;
                                } else {
                                    j4 = this.requested.addAndGet(-j7);
                                }
                            }
                            if (j4 == 0 || obj == null) {
                                break;
                            }
                        }
                    }
                    boolean z3 = this.done;
                    SimplePlainQueue<U> simplePlainQueue2 = this.queue;
                    InnerSubscriber<?, ?>[] innerSubscriberArr2 = this.subscribers.get();
                    int length = innerSubscriberArr2.length;
                    if (z3 && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0)) {
                        Throwable terminate = this.errs.terminate();
                        if (terminate != ExceptionHelper.TERMINATED) {
                            if (terminate == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(terminate);
                                return;
                            }
                        }
                        return;
                    }
                    int i3 = i2;
                    if (length != 0) {
                        long j8 = this.lastId;
                        int i4 = this.lastIndex;
                        if (length <= i4 || innerSubscriberArr2[i4].id != j8) {
                            if (length <= i4) {
                                i4 = 0;
                            }
                            for (int i5 = 0; i5 < length && innerSubscriberArr2[i4].id != j8; i5++) {
                                i4++;
                                if (i4 == length) {
                                    i4 = 0;
                                }
                            }
                            this.lastIndex = i4;
                            this.lastId = innerSubscriberArr2[i4].id;
                        }
                        int i6 = i4;
                        boolean z4 = false;
                        int i7 = 0;
                        while (true) {
                            if (i7 < length) {
                                if (checkTerminate()) {
                                    return;
                                }
                                InnerSubscriber<T, U> innerSubscriber = innerSubscriberArr2[i6];
                                U u = null;
                                while (!checkTerminate()) {
                                    SimpleQueue<U> simpleQueue = innerSubscriber.queue;
                                    if (simpleQueue == null) {
                                        innerSubscriberArr = innerSubscriberArr2;
                                        i = length;
                                    } else {
                                        innerSubscriberArr = innerSubscriberArr2;
                                        i = length;
                                        long j9 = j5;
                                        while (j4 != j5) {
                                            try {
                                                u = simpleQueue.poll();
                                                if (u == null) {
                                                    break;
                                                }
                                                subscriber.onNext(u);
                                                if (checkTerminate()) {
                                                    return;
                                                }
                                                j4--;
                                                j9++;
                                            } catch (Throwable th) {
                                                Exceptions.throwIfFatal(th);
                                                innerSubscriber.dispose();
                                                this.errs.addThrowable(th);
                                                if (!this.delayErrors) {
                                                    this.upstream.cancel();
                                                }
                                                if (checkTerminate()) {
                                                    return;
                                                }
                                                removeInner(innerSubscriber);
                                                i7++;
                                                length = i;
                                                z4 = true;
                                            }
                                        }
                                        if (j9 != j5) {
                                            if (!z) {
                                                j4 = this.requested.addAndGet(-j9);
                                            } else {
                                                j4 = Long.MAX_VALUE;
                                            }
                                            innerSubscriber.requestMore(j9);
                                            j3 = 0;
                                        } else {
                                            j3 = j5;
                                        }
                                        if (j4 != j3 && u != null) {
                                            innerSubscriberArr2 = innerSubscriberArr;
                                            length = i;
                                            j5 = 0;
                                        }
                                    }
                                    boolean z5 = innerSubscriber.done;
                                    SimpleQueue<U> simpleQueue2 = innerSubscriber.queue;
                                    if (z5 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                        removeInner(innerSubscriber);
                                        if (checkTerminate()) {
                                            return;
                                        }
                                        j6++;
                                        z4 = true;
                                    }
                                    if (j4 == 0) {
                                        z2 = z4;
                                        break;
                                    }
                                    i6++;
                                    length = i;
                                    if (i6 == length) {
                                        i6 = 0;
                                    }
                                    i7++;
                                    innerSubscriberArr2 = innerSubscriberArr;
                                    j5 = 0;
                                }
                                return;
                            }
                            innerSubscriberArr = innerSubscriberArr2;
                            z2 = z4;
                            break;
                        }
                        this.lastIndex = i6;
                        this.lastId = innerSubscriberArr[i6].id;
                        j2 = j6;
                        j = 0;
                    } else {
                        j = 0;
                        j2 = j6;
                        z2 = false;
                    }
                    if (j2 != j && !this.cancelled) {
                        this.upstream.request(j2);
                    }
                    if (z2) {
                        i2 = i3;
                    } else {
                        i2 = addAndGet(-i3);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
            }
        }

        public SimpleQueue<U> getInnerQueue(InnerSubscriber<T, U> innerSubscriber) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, innerSubscriber)) == null) {
                SimpleQueue<U> simpleQueue = innerSubscriber.queue;
                if (simpleQueue == null) {
                    SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
                    innerSubscriber.queue = spscArrayQueue;
                    return spscArrayQueue;
                }
                return simpleQueue;
            }
            return (SimpleQueue) invokeL.objValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                } else if (this.errs.addThrowable(th)) {
                    this.done = true;
                    drain();
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048591, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void innerError(InnerSubscriber<T, U> innerSubscriber, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, innerSubscriber, th) == null) {
                if (this.errs.addThrowable(th)) {
                    innerSubscriber.done = true;
                    if (!this.delayErrors) {
                        this.upstream.cancel();
                        for (InnerSubscriber<?, ?> innerSubscriber2 : this.subscribers.getAndSet(CANCELLED)) {
                            innerSubscriber2.dispose();
                        }
                    }
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.reactivex.internal.operators.flowable.FlowableFlatMap$MergeSubscriber<T, U> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, t) != null) || this.done) {
                return;
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call != null) {
                            tryEmitScalar(call);
                            return;
                        } else if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                            int i = this.scalarEmitted + 1;
                            this.scalarEmitted = i;
                            int i2 = this.scalarLimit;
                            if (i == i2) {
                                this.scalarEmitted = 0;
                                this.upstream.request(i2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.errs.addThrowable(th);
                        drain();
                        return;
                    }
                }
                long j = this.uniqueId;
                this.uniqueId = 1 + j;
                InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                if (addInner(innerSubscriber)) {
                    publisher.subscribe(innerSubscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        public void removeInner(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, innerSubscriber) == null) {
                do {
                    innerSubscriberArr = this.subscribers.get();
                    int length = innerSubscriberArr.length;
                    if (length == 0) {
                        return;
                    }
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerSubscriberArr[i2] == innerSubscriber) {
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
                        innerSubscriberArr2 = EMPTY;
                    } else {
                        InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                        System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                        System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                        innerSubscriberArr2 = innerSubscriberArr3;
                    }
                } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            }
        }

        public void tryEmit(U u, InnerSubscriber<T, U> innerSubscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048592, this, u, innerSubscriber) == null) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    long j = this.requested.get();
                    SimpleQueue<U> simpleQueue = innerSubscriber.queue;
                    if (j != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                        this.actual.onNext(u);
                        if (j != Long.MAX_VALUE) {
                            this.requested.decrementAndGet();
                        }
                        innerSubscriber.requestMore(1L);
                    } else {
                        if (simpleQueue == null) {
                            simpleQueue = getInnerQueue(innerSubscriber);
                        }
                        if (!simpleQueue.offer(u)) {
                            onError(new MissingBackpressureException("Inner queue full?!"));
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    SimpleQueue simpleQueue2 = innerSubscriber.queue;
                    if (simpleQueue2 == null) {
                        simpleQueue2 = new SpscArrayQueue(this.bufferSize);
                        innerSubscriber.queue = simpleQueue2;
                    }
                    if (!simpleQueue2.offer(u)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    } else if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        public void tryEmitScalar(U u) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, u) == null) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    long j = this.requested.get();
                    SimpleQueue<U> simpleQueue = this.queue;
                    if (j != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                        this.actual.onNext(u);
                        if (j != Long.MAX_VALUE) {
                            this.requested.decrementAndGet();
                        }
                        if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                            int i = this.scalarEmitted + 1;
                            this.scalarEmitted = i;
                            int i2 = this.scalarLimit;
                            if (i == i2) {
                                this.scalarEmitted = 0;
                                this.upstream.request(i2);
                            }
                        }
                    } else {
                        if (simpleQueue == null) {
                            simpleQueue = getMainQueue();
                        }
                        if (!simpleQueue.offer(u)) {
                            onError(new IllegalStateException("Scalar queue full?!"));
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else if (!getMainQueue().offer(u)) {
                    onError(new IllegalStateException("Scalar queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
                drainLoop();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i;
        this.bufferSize = i2;
    }

    public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{subscriber, function, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            return new MergeSubscriber(subscriber, function, z, i, i2);
        }
        return (FlowableSubscriber) invokeCommon.objValue;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, subscriber) != null) || FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe((FlowableSubscriber) subscribe(subscriber, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }
}
