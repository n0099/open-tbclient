package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class ObservableIntervalRange extends Observable<Long> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long end;
    public final long initialDelay;
    public final long period;
    public final Scheduler scheduler;
    public final long start;
    public final TimeUnit unit;

    /* loaded from: classes3.dex */
    public static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1891866368734007884L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super Long> actual;
        public long count;
        public final long end;

        public IntervalRangeObserver(Observer<? super Long> observer, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = observer;
            this.count = j2;
            this.end = j3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == DisposableHelper.DISPOSED : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || isDisposed()) {
                return;
            }
            long j2 = this.count;
            this.actual.onNext(Long.valueOf(j2));
            if (j2 == this.end) {
                DisposableHelper.dispose(this);
                this.actual.onComplete();
                return;
            }
            this.count = j2 + 1;
        }

        public void setResource(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }
    }

    public ObservableIntervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit, Scheduler scheduler) {
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

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.start, this.end);
            observer.onSubscribe(intervalRangeObserver);
            Scheduler scheduler = this.scheduler;
            if (scheduler instanceof TrampolineScheduler) {
                Scheduler.Worker createWorker = scheduler.createWorker();
                intervalRangeObserver.setResource(createWorker);
                createWorker.schedulePeriodically(intervalRangeObserver, this.initialDelay, this.period, this.unit);
                return;
            }
            intervalRangeObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeObserver, this.initialDelay, this.period, this.unit));
        }
    }
}
