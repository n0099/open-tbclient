package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class FlowableIntervalRange extends Flowable<Long> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long end;
    public final long initialDelay;
    public final long period;
    public final Scheduler scheduler;
    public final long start;
    public final TimeUnit unit;

    /* loaded from: classes10.dex */
    public static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2809475196591179431L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super Long> actual;
        public long count;
        public final long end;
        public final AtomicReference<Disposable> resource;

        public IntervalRangeSubscriber(Subscriber<? super Long> subscriber, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.resource = new AtomicReference<>();
            this.actual = subscriber;
            this.count = j2;
            this.end = j3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this.resource);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.resource.get() == DisposableHelper.DISPOSED) {
                return;
            }
            long j2 = get();
            if (j2 != 0) {
                long j3 = this.count;
                this.actual.onNext(Long.valueOf(j3));
                if (j3 == this.end) {
                    if (this.resource.get() != DisposableHelper.DISPOSED) {
                        this.actual.onComplete();
                    }
                    DisposableHelper.dispose(this.resource);
                    return;
                }
                this.count = j3 + 1;
                if (j2 != Long.MAX_VALUE) {
                    decrementAndGet();
                    return;
                }
                return;
            }
            Subscriber<? super Long> subscriber = this.actual;
            subscriber.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
            DisposableHelper.dispose(this.resource);
        }

        public void setResource(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
                DisposableHelper.setOnce(this.resource, disposable);
            }
        }
    }

    public FlowableIntervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit, Scheduler scheduler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), timeUnit, scheduler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.initialDelay = j4;
        this.period = j5;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.start = j2;
        this.end = j3;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(subscriber, this.start, this.end);
            subscriber.onSubscribe(intervalRangeSubscriber);
            Scheduler scheduler = this.scheduler;
            if (scheduler instanceof TrampolineScheduler) {
                Scheduler.Worker createWorker = scheduler.createWorker();
                intervalRangeSubscriber.setResource(createWorker);
                createWorker.schedulePeriodically(intervalRangeSubscriber, this.initialDelay, this.period, this.unit);
                return;
            }
            intervalRangeSubscriber.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeSubscriber, this.initialDelay, this.period, this.unit));
        }
    }
}
