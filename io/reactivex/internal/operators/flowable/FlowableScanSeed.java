package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BiFunction<R, ? super T, R> accumulator;
    public final Callable<R> seedSupplier;

    /* loaded from: classes3.dex */
    public static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1776795561228106469L;
        public transient /* synthetic */ FieldHolder $fh;
        public final BiFunction<R, ? super T, R> accumulator;
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public final int prefetch;
        public final SimplePlainQueue<R> queue;
        public final AtomicLong requested;
        public Subscription s;
        public R value;

        public ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, biFunction, r, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.accumulator = biFunction;
            this.value = r;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i2);
            this.queue = spscArrayQueue;
            spscArrayQueue.offer(r);
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
            if (r13 != 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
            if (r18.done == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
            r7 = r18.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
            if (r7 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
            r2.clear();
            r1.onError(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007a, code lost:
            if (r2.isEmpty() == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007c, code lost:
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x007f, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0082, code lost:
            if (r11 == 0) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0084, code lost:
            io.reactivex.internal.util.BackpressureHelper.produced(r18.requested, r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
            r18.consumed = r4;
            r6 = addAndGet(-r6);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            Throwable th;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.actual;
                SimplePlainQueue<R> simplePlainQueue = this.queue;
                int i2 = this.limit;
                int i3 = this.consumed;
                int i4 = 1;
                do {
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (true) {
                        int i5 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i5 == 0) {
                            break;
                        } else if (this.cancelled) {
                            simplePlainQueue.clear();
                            return;
                        } else {
                            boolean z = this.done;
                            if (z && (th = this.error) != null) {
                                simplePlainQueue.clear();
                                subscriber.onError(th);
                                return;
                            }
                            Object obj = (R) simplePlainQueue.poll();
                            boolean z2 = obj == null;
                            if (z && z2) {
                                subscriber.onComplete();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(obj);
                                j3++;
                                i3++;
                                if (i3 == i2) {
                                    this.s.request(i2);
                                    i3 = 0;
                                }
                            }
                        }
                    }
                } while (i4 != 0);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.error = th;
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || this.done) {
                return;
            }
            try {
                R r = (R) ObjectHelper.requireNonNull(this.accumulator.apply(this.value, t), "The accumulator returned a null value");
                this.value = r;
                this.queue.offer(r);
                drain();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch - 1);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.requested, j2);
                drain();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableScanSeed(Flowable<T> flowable, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, callable, biFunction};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.accumulator = biFunction;
        this.seedSupplier = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            try {
                this.source.subscribe((FlowableSubscriber) new ScanSeedSubscriber(subscriber, this.accumulator, ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seed supplied is null"), Flowable.bufferSize()));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        }
    }
}
