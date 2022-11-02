package io.reactivex.internal.operators.flowable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayError;
    public final int prefetch;
    public final Scheduler scheduler;

    /* loaded from: classes8.dex */
    public static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8241002408341274697L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public boolean outputFused;
        public final int prefetch;
        public long produced;
        public SimpleQueue<T> queue;
        public final AtomicLong requested;
        public Subscription s;
        public int sourceMode;
        public final Scheduler.Worker worker;

        public abstract void runAsync();

        public abstract void runBackfused();

        public abstract void runSync();

        public BaseObserveOnSubscriber(Scheduler.Worker worker, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {worker, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.worker = worker;
            this.delayError = z;
            this.prefetch = i;
            this.requested = new AtomicLong();
            this.limit = i - (i >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.queue.isEmpty();
            }
            return invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.done) {
                this.done = true;
                trySchedule();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                if (this.outputFused) {
                    runBackfused();
                } else if (this.sourceMode == 1) {
                    runSync();
                } else {
                    runAsync();
                }
            }
        }

        public final void trySchedule() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || getAndIncrement() != 0) {
                return;
            }
            this.worker.schedule(this);
        }

        public final boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), subscriber})) == null) {
                if (this.cancelled) {
                    clear();
                    return true;
                } else if (z) {
                    if (this.delayError) {
                        if (z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                subscriber.onError(th);
                            } else {
                                subscriber.onComplete();
                            }
                            this.worker.dispose();
                            return true;
                        }
                        return false;
                    }
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        clear();
                        subscriber.onError(th2);
                        this.worker.dispose();
                        return true;
                    } else if (z2) {
                        subscriber.onComplete();
                        this.worker.dispose();
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.error = th;
                this.done = true;
                trySchedule();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048583, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                trySchedule();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                if ((i & 2) != 0) {
                    this.outputFused = true;
                    return 2;
                }
                return 0;
            }
            return invokeI.intValue;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048582, this, t) != null) || this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                trySchedule();
                return;
            }
            if (!this.queue.offer(t)) {
                this.s.cancel();
                this.error = new MissingBackpressureException("Queue is full?!");
                this.done = true;
            }
            trySchedule();
        }
    }

    /* loaded from: classes8.dex */
    public static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 644624475404284533L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConditionalSubscriber<? super T> actual;
        public long consumed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler.Worker worker, boolean z, int i) {
            super(worker, z, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {conditionalSubscriber, worker, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Scheduler.Worker) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                T poll = this.queue.poll();
                if (poll != null && this.sourceMode != 1) {
                    long j = this.consumed + 1;
                    if (j == this.limit) {
                        this.consumed = 0L;
                        this.s.request(j);
                    } else {
                        this.consumed = j;
                    }
                }
                return poll;
            }
            return (T) invokeV.objValue;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void runBackfused() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int i = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    this.actual.onNext(null);
                    if (z) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.actual.onError(th);
                        } else {
                            this.actual.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void runAsync() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
                SimpleQueue<T> simpleQueue = this.queue;
                long j = this.produced;
                long j2 = this.consumed;
                int i2 = 1;
                while (true) {
                    long j3 = this.requested.get();
                    while (true) {
                        i = (j > j3 ? 1 : (j == j3 ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z2 = this.done;
                        try {
                            Object obj = (T) simpleQueue.poll();
                            if (obj == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (checkTerminated(z2, z, conditionalSubscriber)) {
                                return;
                            }
                            if (z) {
                                break;
                            }
                            if (conditionalSubscriber.tryOnNext(obj)) {
                                j++;
                            }
                            j2++;
                            if (j2 == this.limit) {
                                this.s.request(j2);
                                j2 = 0;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.s.cancel();
                            simpleQueue.clear();
                            conditionalSubscriber.onError(th);
                            this.worker.dispose();
                            return;
                        }
                    }
                    if (i == 0 && checkTerminated(this.done, simpleQueue.isEmpty(), conditionalSubscriber)) {
                        return;
                    }
                    int i3 = get();
                    if (i2 == i3) {
                        this.produced = j;
                        this.consumed = j2;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        i2 = i3;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void runSync() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
                SimpleQueue<T> simpleQueue = this.queue;
                long j = this.produced;
                int i = 1;
                while (true) {
                    long j2 = this.requested.get();
                    while (j != j2) {
                        try {
                            Object obj = (T) simpleQueue.poll();
                            if (this.cancelled) {
                                return;
                            }
                            if (obj == null) {
                                conditionalSubscriber.onComplete();
                                this.worker.dispose();
                                return;
                            } else if (conditionalSubscriber.tryOnNext(obj)) {
                                j++;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.s.cancel();
                            conditionalSubscriber.onError(th);
                            this.worker.dispose();
                            return;
                        }
                    }
                    if (this.cancelled) {
                        return;
                    }
                    if (simpleQueue.isEmpty()) {
                        conditionalSubscriber.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements FlowableSubscriber<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4547113800637756442L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ObserveOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean z, int i) {
            super(worker, z, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, worker, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Scheduler.Worker) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                T poll = this.queue.poll();
                if (poll != null && this.sourceMode != 1) {
                    long j = this.produced + 1;
                    if (j == this.limit) {
                        this.produced = 0L;
                        this.s.request(j);
                    } else {
                        this.produced = j;
                    }
                }
                return poll;
            }
            return (T) invokeV.objValue;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void runBackfused() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int i = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    this.actual.onNext(null);
                    if (z) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.actual.onError(th);
                        } else {
                            this.actual.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void runAsync() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Subscriber<? super T> subscriber = this.actual;
                SimpleQueue<T> simpleQueue = this.queue;
                long j = this.produced;
                int i2 = 1;
                while (true) {
                    long j2 = this.requested.get();
                    while (true) {
                        i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z2 = this.done;
                        try {
                            Object obj = (T) simpleQueue.poll();
                            if (obj == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (checkTerminated(z2, z, subscriber)) {
                                return;
                            }
                            if (z) {
                                break;
                            }
                            subscriber.onNext(obj);
                            j++;
                            if (j == this.limit) {
                                if (j2 != Long.MAX_VALUE) {
                                    j2 = this.requested.addAndGet(-j);
                                }
                                this.s.request(j);
                                j = 0;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.s.cancel();
                            simpleQueue.clear();
                            subscriber.onError(th);
                            this.worker.dispose();
                            return;
                        }
                    }
                    if (i == 0 && checkTerminated(this.done, simpleQueue.isEmpty(), subscriber)) {
                        return;
                    }
                    int i3 = get();
                    if (i2 == i3) {
                        this.produced = j;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        i2 = i3;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void runSync() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Subscriber<? super T> subscriber = this.actual;
                SimpleQueue<T> simpleQueue = this.queue;
                long j = this.produced;
                int i = 1;
                while (true) {
                    long j2 = this.requested.get();
                    while (j != j2) {
                        try {
                            Object obj = (T) simpleQueue.poll();
                            if (this.cancelled) {
                                return;
                            }
                            if (obj == null) {
                                subscriber.onComplete();
                                this.worker.dispose();
                                return;
                            }
                            subscriber.onNext(obj);
                            j++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.s.cancel();
                            subscriber.onError(th);
                            this.worker.dispose();
                            return;
                        }
                    }
                    if (this.cancelled) {
                        return;
                    }
                    if (simpleQueue.isEmpty()) {
                        subscriber.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    int i2 = get();
                    if (i == i2) {
                        this.produced = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z, int i) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, scheduler, Boolean.valueOf(z), Integer.valueOf(i)};
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
        this.scheduler = scheduler;
        this.delayError = z;
        this.prefetch = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            Scheduler.Worker createWorker = this.scheduler.createWorker();
            if (subscriber instanceof ConditionalSubscriber) {
                this.source.subscribe((FlowableSubscriber) new ObserveOnConditionalSubscriber((ConditionalSubscriber) subscriber, createWorker, this.delayError, this.prefetch));
            } else {
                this.source.subscribe((FlowableSubscriber) new ObserveOnSubscriber(subscriber, createWorker, this.delayError, this.prefetch));
            }
        }
    }
}
