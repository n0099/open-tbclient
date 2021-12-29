package io.reactivex.internal.operators.parallel;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes4.dex */
public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int parallelism;
    public final int prefetch;
    public final Publisher<? extends T> source;

    /* loaded from: classes4.dex */
    public static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4470634016609963609L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final long[] emissions;
        public Throwable error;
        public int index;
        public final int limit;
        public final int prefetch;
        public int produced;
        public SimpleQueue<T> queue;
        public final AtomicLongArray requests;
        public Subscription s;
        public int sourceMode;
        public final AtomicInteger subscriberCount;
        public final Subscriber<? super T>[] subscribers;

        /* loaded from: classes4.dex */
        public final class RailSubscription implements Subscription {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: j  reason: collision with root package name */
            public final int f64600j;
            public final int m;
            public final /* synthetic */ ParallelDispatcher this$0;

            public RailSubscription(ParallelDispatcher parallelDispatcher, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {parallelDispatcher, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = parallelDispatcher;
                this.f64600j = i2;
                this.m = i3;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.this$0.requests.compareAndSet(this.f64600j + this.m, 0L, 1L)) {
                        ParallelDispatcher parallelDispatcher = this.this$0;
                        int i2 = this.m;
                        parallelDispatcher.cancel(i2 + i2);
                    }
                }
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j2) {
                long j3;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                    AtomicLongArray atomicLongArray = this.this$0.requests;
                    do {
                        j3 = atomicLongArray.get(this.f64600j);
                        if (j3 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.f64600j, j3, BackpressureHelper.addCap(j3, j2)));
                    if (this.this$0.subscriberCount.get() == this.m) {
                        this.this$0.drain();
                    }
                }
            }
        }

        public ParallelDispatcher(Subscriber<? super T>[] subscriberArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriberArr, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.subscriberCount = new AtomicInteger();
            this.subscribers = subscriberArr;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            int length = subscriberArr.length;
            int i5 = length + length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(i5 + 1);
            this.requests = atomicLongArray;
            atomicLongArray.lazySet(i5, length);
            this.emissions = new long[length];
        }

        public void cancel(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.requests.decrementAndGet(i2) == 0) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndIncrement() == 0) {
                if (this.sourceMode == 1) {
                    drainSync();
                } else {
                    drainAsync();
                }
            }
        }

        public void drainAsync() {
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                SimpleQueue<T> simpleQueue = this.queue;
                Subscriber<? super T>[] subscriberArr = this.subscribers;
                AtomicLongArray atomicLongArray = this.requests;
                long[] jArr = this.emissions;
                int length = jArr.length;
                int i2 = this.index;
                int i3 = this.produced;
                int i4 = 1;
                while (true) {
                    int i5 = 0;
                    int i6 = 0;
                    while (!this.cancelled) {
                        boolean z = this.done;
                        if (z && (th = this.error) != null) {
                            simpleQueue.clear();
                            int length2 = subscriberArr.length;
                            while (i5 < length2) {
                                subscriberArr[i5].onError(th);
                                i5++;
                            }
                            return;
                        }
                        boolean isEmpty = simpleQueue.isEmpty();
                        if (z && isEmpty) {
                            int length3 = subscriberArr.length;
                            while (i5 < length3) {
                                subscriberArr[i5].onComplete();
                                i5++;
                            }
                            return;
                        }
                        if (!isEmpty) {
                            long j2 = atomicLongArray.get(i2);
                            long j3 = jArr[i2];
                            if (j2 == j3 || atomicLongArray.get(length + i2) != 0) {
                                i6++;
                            } else {
                                try {
                                    T poll = simpleQueue.poll();
                                    if (poll != null) {
                                        subscriberArr[i2].onNext(poll);
                                        jArr[i2] = j3 + 1;
                                        i3++;
                                        if (i3 == this.limit) {
                                            this.s.request(i3);
                                            i3 = 0;
                                        }
                                        i6 = 0;
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.s.cancel();
                                    int length4 = subscriberArr.length;
                                    while (i5 < length4) {
                                        subscriberArr[i5].onError(th2);
                                        i5++;
                                    }
                                    return;
                                }
                            }
                            i2++;
                            if (i2 == length) {
                                i2 = 0;
                                continue;
                            }
                            if (i6 == length) {
                            }
                        }
                        int i7 = get();
                        if (i7 == i4) {
                            this.index = i2;
                            this.produced = i3;
                            i4 = addAndGet(-i4);
                            if (i4 == 0) {
                                return;
                            }
                        } else {
                            i4 = i7;
                        }
                    }
                    simpleQueue.clear();
                    return;
                }
            }
        }

        public void drainSync() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SimpleQueue<T> simpleQueue = this.queue;
                Subscriber<? super T>[] subscriberArr = this.subscribers;
                AtomicLongArray atomicLongArray = this.requests;
                long[] jArr = this.emissions;
                int length = jArr.length;
                int i2 = this.index;
                int i3 = 1;
                while (true) {
                    int i4 = 0;
                    int i5 = 0;
                    while (!this.cancelled) {
                        if (simpleQueue.isEmpty()) {
                            int length2 = subscriberArr.length;
                            while (i4 < length2) {
                                subscriberArr[i4].onComplete();
                                i4++;
                            }
                            return;
                        }
                        long j2 = atomicLongArray.get(i2);
                        long j3 = jArr[i2];
                        if (j2 == j3 || atomicLongArray.get(length + i2) != 0) {
                            i5++;
                        } else {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    int length3 = subscriberArr.length;
                                    while (i4 < length3) {
                                        subscriberArr[i4].onComplete();
                                        i4++;
                                    }
                                    return;
                                }
                                subscriberArr[i2].onNext(poll);
                                jArr[i2] = j3 + 1;
                                i5 = 0;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.s.cancel();
                                int length4 = subscriberArr.length;
                                while (i4 < length4) {
                                    subscriberArr[i4].onError(th);
                                    i4++;
                                }
                                return;
                            }
                        }
                        i2++;
                        if (i2 == length) {
                            i2 = 0;
                            continue;
                        }
                        if (i5 == length) {
                            int i6 = get();
                            if (i6 == i3) {
                                this.index = i2;
                                i3 = addAndGet(-i3);
                                if (i3 == 0) {
                                    return;
                                }
                            } else {
                                i3 = i6;
                            }
                        }
                    }
                    simpleQueue.clear();
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                this.error = th;
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                if (this.sourceMode == 0 && !this.queue.offer(t)) {
                    this.s.cancel();
                    onError(new MissingBackpressureException("Queue is full?"));
                    return;
                }
                drain();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        setupSubscribers();
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        setupSubscribers();
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                setupSubscribers();
                subscription.request(this.prefetch);
            }
        }

        public void setupSubscribers() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                Subscriber<? super T>[] subscriberArr = this.subscribers;
                int length = subscriberArr.length;
                int i2 = 0;
                while (i2 < length && !this.cancelled) {
                    int i3 = i2 + 1;
                    this.subscriberCount.lazySet(i3);
                    subscriberArr[i2].onSubscribe(new RailSubscription(this, i2, length));
                    i2 = i3;
                }
            }
        }
    }

    public ParallelFromPublisher(Publisher<? extends T> publisher, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {publisher, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = publisher;
        this.parallelism = i2;
        this.prefetch = i3;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.parallelism : invokeV.intValue;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subscriberArr) == null) && validate(subscriberArr)) {
            this.source.subscribe(new ParallelDispatcher(subscriberArr, this.prefetch));
        }
    }
}
