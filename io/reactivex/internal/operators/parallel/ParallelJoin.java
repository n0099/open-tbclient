package io.reactivex.internal.operators.parallel;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class ParallelJoin<T> extends Flowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayErrors;
    public final int prefetch;
    public final ParallelFlowable<? extends T> source;

    /* loaded from: classes10.dex */
    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8410034718427740355L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;
        public final JoinSubscriptionBase<T> parent;
        public final int prefetch;
        public long produced;
        public volatile SimplePlainQueue<T> queue;

        public JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {joinSubscriptionBase, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = joinSubscriptionBase;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        public boolean cancel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SubscriptionHelper.cancel(this) : invokeV.booleanValue;
        }

        public SimplePlainQueue<T> getQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                if (simplePlainQueue == null) {
                    SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
                    this.queue = spscArrayQueue;
                    return spscArrayQueue;
                }
                return simplePlainQueue;
            }
            return (SimplePlainQueue) invokeV.objValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.parent.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.parent.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                this.parent.onNext(this, t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) {
                SubscriptionHelper.setOnce(this, subscription, this.prefetch);
            }
        }

        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
                long j3 = this.produced + j2;
                if (j3 >= this.limit) {
                    this.produced = 0L;
                    get().request(j3);
                    return;
                }
                this.produced = j3;
            }
        }

        public void requestOne() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                long j2 = this.produced + 1;
                if (j2 == this.limit) {
                    this.produced = 0L;
                    get().request(j2);
                    return;
                }
                this.produced = j2;
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6312374661811000451L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JoinSubscription(Subscriber<? super T> subscriber, int i2, int i3) {
            super(subscriber, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Subscriber) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
            if (r13 == false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
            if (r15 == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
            if (r15 == false) goto L5;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            boolean z;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber<? super T> subscriber = this.actual;
            int i2 = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th = this.errors.get();
                    if (th != null) {
                        cleanup();
                        subscriber.onError(th);
                        return;
                    }
                    boolean z2 = this.done.get() == 0;
                    int i3 = 0;
                    boolean z3 = true;
                    while (true) {
                        if (i3 >= joinInnerSubscriberArr.length) {
                            break;
                        }
                        JoinInnerSubscriber<T> joinInnerSubscriber = joinInnerSubscriberArr[i3];
                        SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                        if (simplePlainQueue != null && (obj = (T) simplePlainQueue.poll()) != null) {
                            subscriber.onNext(obj);
                            joinInnerSubscriber.requestOne();
                            j3++;
                            if (j3 == j2) {
                                break;
                            }
                            z3 = false;
                        }
                        i3++;
                    }
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th2 = this.errors.get();
                    if (th2 != null) {
                        cleanup();
                        subscriber.onError(th2);
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            SimplePlainQueue<T> simplePlainQueue2 = joinInnerSubscriberArr[i4].queue;
                            if (simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) {
                                z = false;
                                break;
                            }
                            i4++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z4 && z) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j3 != 0 && j2 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j3);
                }
                int i5 = get();
                if (i5 == i2 && (i5 = addAndGet(-i2)) == 0) {
                    return;
                }
                i2 = i5;
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.done.decrementAndGet();
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (this.errors.compareAndSet(null, th)) {
                    cancelAll();
                    drain();
                } else if (th != this.errors.get()) {
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, joinInnerSubscriber, t) == null) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    if (this.requested.get() != 0) {
                        this.actual.onNext(t);
                        if (this.requested.get() != Long.MAX_VALUE) {
                            this.requested.decrementAndGet();
                        }
                        joinInnerSubscriber.request(1L);
                    } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                        cancelAll();
                        MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                        if (this.errors.compareAndSet(null, missingBackpressureException)) {
                            this.actual.onError(missingBackpressureException);
                            return;
                        } else {
                            RxJavaPlugins.onError(missingBackpressureException);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    cancelAll();
                    onError(new MissingBackpressureException("Queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
                drainLoop();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3100232009247827843L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public volatile boolean cancelled;
        public final AtomicInteger done;
        public final AtomicThrowable errors;
        public final AtomicLong requested;
        public final JoinInnerSubscriber<T>[] subscribers;

        public JoinSubscriptionBase(Subscriber<? super T> subscriber, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.errors = new AtomicThrowable();
            this.requested = new AtomicLong();
            this.done = new AtomicInteger();
            this.actual = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i2];
            for (int i6 = 0; i6 < i2; i6++) {
                joinInnerSubscriberArr[i6] = new JoinInnerSubscriber<>(this, i3);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(i2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                cleanup();
            }
        }

        public void cancelAll() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            int i2 = 0;
            while (true) {
                JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
                if (i2 >= joinInnerSubscriberArr.length) {
                    return;
                }
                joinInnerSubscriberArr[i2].cancel();
                i2++;
            }
        }

        public void cleanup() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            int i2 = 0;
            while (true) {
                JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
                if (i2 >= joinInnerSubscriberArr.length) {
                    return;
                }
                joinInnerSubscriberArr[i2].queue = null;
                i2++;
            }
        }

        public abstract void drain();

        public abstract void onComplete();

        public abstract void onError(Throwable th);

        public abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.requested, j2);
                drain();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5737965195918321883L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i2, int i3) {
            super(subscriber, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Subscriber) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
            if (r13 == false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
            if (r15 == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
            if (r18.errors.get() == null) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
            r3.onError(r18.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
            if (r15 == false) goto L5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            boolean z;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber<? super T> subscriber = this.actual;
            int i2 = 1;
            while (true) {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z2 = this.done.get() == 0;
                    int i3 = 0;
                    boolean z3 = true;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        JoinInnerSubscriber<T> joinInnerSubscriber = joinInnerSubscriberArr[i3];
                        SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                        if (simplePlainQueue != null && (obj = (T) simplePlainQueue.poll()) != null) {
                            subscriber.onNext(obj);
                            joinInnerSubscriber.requestOne();
                            j3++;
                            if (j3 == j2) {
                                break;
                            }
                            z3 = false;
                        }
                        i3++;
                    }
                }
                if (j3 == j2) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            SimplePlainQueue<T> simplePlainQueue2 = joinInnerSubscriberArr[i4].queue;
                            if (simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) {
                                z = false;
                                break;
                            }
                            i4++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z4 && z) {
                        if (this.errors.get() != null) {
                            subscriber.onError(this.errors.terminate());
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if (j3 != 0 && j2 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j3);
                }
                int i5 = get();
                if (i5 == i2 && (i5 = addAndGet(-i2)) == 0) {
                    return;
                }
                i2 = i5;
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.done.decrementAndGet();
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.errors.addThrowable(th);
                this.done.decrementAndGet();
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, joinInnerSubscriber, t) == null) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    if (this.requested.get() != 0) {
                        this.actual.onNext(t);
                        if (this.requested.get() != Long.MAX_VALUE) {
                            this.requested.decrementAndGet();
                        }
                        joinInnerSubscriber.request(1L);
                    } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                        joinInnerSubscriber.cancel();
                        this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                        this.done.decrementAndGet();
                        drainLoop();
                        return;
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    if (!joinInnerSubscriber.getQueue().offer(t) && joinInnerSubscriber.cancel()) {
                        this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                        this.done.decrementAndGet();
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parallelFlowable, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = parallelFlowable;
        this.prefetch = i2;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscription;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            if (this.delayErrors) {
                joinSubscription = new JoinSubscriptionDelayError(subscriber, this.source.parallelism(), this.prefetch);
            } else {
                joinSubscription = new JoinSubscription(subscriber, this.source.parallelism(), this.prefetch);
            }
            subscriber.onSubscribe(joinSubscription);
            this.source.subscribe(joinSubscription.subscribers);
        }
    }
}
