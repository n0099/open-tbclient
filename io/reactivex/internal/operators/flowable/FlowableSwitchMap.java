package io.reactivex.internal.operators.flowable;

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
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final boolean delayErrors;
    public final Function<? super T, ? extends Publisher<? extends R>> mapper;

    /* loaded from: classes3.dex */
    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3837284832786408377L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public volatile boolean done;
        public int fusionMode;
        public final long index;
        public final SwitchMapSubscriber<T, R> parent;
        public volatile SimpleQueue<R> queue;

        public SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {switchMapSubscriber, Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = switchMapSubscriber;
            this.index = j2;
            this.bufferSize = i2;
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
                if (this.index == switchMapSubscriber.unique) {
                    this.done = true;
                    switchMapSubscriber.drain();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
                if (this.index == switchMapSubscriber.unique && switchMapSubscriber.error.addThrowable(th)) {
                    if (!switchMapSubscriber.delayErrors) {
                        switchMapSubscriber.s.cancel();
                    }
                    this.done = true;
                    switchMapSubscriber.drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r) == null) {
                SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
                if (this.index == switchMapSubscriber.unique) {
                    if (this.fusionMode == 0 && !this.queue.offer(r)) {
                        onError(new MissingBackpressureException("Queue full?!"));
                    } else {
                        switchMapSubscriber.drain();
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) && SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request(this.bufferSize);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final SwitchMapInnerSubscriber<Object, Object> CANCELLED;
        public static final long serialVersionUID = -3491074160481096299L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference<SwitchMapInnerSubscriber<T, R>> active;
        public final Subscriber<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final AtomicThrowable error;
        public final Function<? super T, ? extends Publisher<? extends R>> mapper;
        public final AtomicLong requested;
        public Subscription s;
        public volatile long unique;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(401095537, "Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(401095537, "Lio/reactivex/internal/operators/flowable/FlowableSwitchMap$SwitchMapSubscriber;");
                    return;
                }
            }
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = new SwitchMapInnerSubscriber<>(null, -1L, 1);
            CANCELLED = switchMapInnerSubscriber;
            switchMapInnerSubscriber.cancel();
        }

        public SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.active = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.actual = subscriber;
            this.mapper = function;
            this.bufferSize = i2;
            this.delayErrors = z;
            this.error = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            disposeInner();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void disposeInner() {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber2 = this.active.get();
                SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber3 = CANCELLED;
                if (switchMapInnerSubscriber2 == switchMapInnerSubscriber3 || (switchMapInnerSubscriber = (SwitchMapInnerSubscriber) this.active.getAndSet(switchMapInnerSubscriber3)) == CANCELLED || switchMapInnerSubscriber == null) {
                    return;
                }
                switchMapInnerSubscriber.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:66:0x00e9, code lost:
            r14 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            boolean z;
            R r;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.actual;
                int i2 = 1;
                while (!this.cancelled) {
                    if (this.done) {
                        if (this.delayErrors) {
                            if (this.active.get() == null) {
                                if (this.error.get() != null) {
                                    subscriber.onError(this.error.terminate());
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                        } else if (this.error.get() != null) {
                            disposeInner();
                            subscriber.onError(this.error.terminate());
                            return;
                        } else if (this.active.get() == null) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber = this.active.get();
                    SimpleQueue<R> simpleQueue = switchMapInnerSubscriber != null ? switchMapInnerSubscriber.queue : null;
                    if (simpleQueue != null) {
                        if (switchMapInnerSubscriber.done) {
                            if (!this.delayErrors) {
                                if (this.error.get() != null) {
                                    disposeInner();
                                    subscriber.onError(this.error.terminate());
                                    return;
                                } else if (simpleQueue.isEmpty()) {
                                    this.active.compareAndSet(switchMapInnerSubscriber, null);
                                }
                            } else if (simpleQueue.isEmpty()) {
                                this.active.compareAndSet(switchMapInnerSubscriber, null);
                            }
                        }
                        long j2 = this.requested.get();
                        long j3 = 0;
                        while (true) {
                            z = false;
                            if (j3 != j2) {
                                if (!this.cancelled) {
                                    boolean z2 = switchMapInnerSubscriber.done;
                                    try {
                                        r = simpleQueue.poll();
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        switchMapInnerSubscriber.cancel();
                                        this.error.addThrowable(th);
                                        r = (Object) null;
                                        z2 = true;
                                    }
                                    boolean z3 = r == null;
                                    if (switchMapInnerSubscriber != this.active.get()) {
                                        break;
                                    }
                                    if (z2) {
                                        if (!this.delayErrors) {
                                            if (this.error.get() == null) {
                                                if (z3) {
                                                    this.active.compareAndSet(switchMapInnerSubscriber, null);
                                                    break;
                                                }
                                            } else {
                                                subscriber.onError(this.error.terminate());
                                                return;
                                            }
                                        } else if (z3) {
                                            this.active.compareAndSet(switchMapInnerSubscriber, null);
                                            break;
                                        }
                                    }
                                    if (z3) {
                                        break;
                                    }
                                    subscriber.onNext(r);
                                    j3++;
                                } else {
                                    return;
                                }
                            } else {
                                break;
                            }
                        }
                        if (j3 != 0 && !this.cancelled) {
                            if (j2 != Long.MAX_VALUE) {
                                this.requested.addAndGet(-j3);
                            }
                            switchMapInnerSubscriber.get().request(j3);
                        }
                        if (z) {
                            continue;
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                this.active.lazySet(null);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                if (!this.done && this.error.addThrowable(th)) {
                    if (!this.delayErrors) {
                        disposeInner();
                    }
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, t) == null) || this.done) {
                return;
            }
            long j2 = this.unique + 1;
            this.unique = j2;
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber2 = this.active.get();
            if (switchMapInnerSubscriber2 != null) {
                switchMapInnerSubscriber2.cancel();
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The publisher returned is null");
                SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber<>(this, j2, this.bufferSize);
                do {
                    switchMapInnerSubscriber = this.active.get();
                    if (switchMapInnerSubscriber == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(switchMapInnerSubscriber, switchMapInnerSubscriber3));
                publisher.subscribe(switchMapInnerSubscriber3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.requested, j2);
                if (this.unique == 0) {
                    this.s.request(Long.MAX_VALUE);
                } else {
                    drain();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, Integer.valueOf(i2), Boolean.valueOf(z)};
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
        this.bufferSize = i2;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) || FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe((FlowableSubscriber) new SwitchMapSubscriber(subscriber, this.mapper, this.bufferSize, this.delayErrors));
    }
}
