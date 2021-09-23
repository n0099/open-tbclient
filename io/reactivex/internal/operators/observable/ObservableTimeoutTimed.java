package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ObservableSource<? extends T> other;
    public final Scheduler scheduler;
    public final long timeout;
    public final TimeUnit unit;

    /* loaded from: classes10.dex */
    public static final class FallbackObserver<T> implements Observer<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public final AtomicReference<Disposable> arbiter;

        public FallbackObserver(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, atomicReference};
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
            this.arbiter = atomicReference;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                this.actual.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
                DisposableHelper.replace(this.arbiter, disposable);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3764492702657003550L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public ObservableSource<? extends T> fallback;
        public final AtomicLong index;
        public final SequentialDisposable task;
        public final long timeout;
        public final TimeUnit unit;
        public final AtomicReference<Disposable> upstream;
        public final Scheduler.Worker worker;

        public TimeoutFallbackObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Long.valueOf(j2), timeUnit, worker, observableSource};
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
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = worker;
            this.fallback = observableSource;
            this.task = new SequentialDisposable();
            this.index = new AtomicLong();
            this.upstream = new AtomicReference<>();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this.upstream);
                DisposableHelper.dispose(this);
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? DisposableHelper.isDisposed(get()) : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                return;
            }
            this.task.dispose();
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                    this.task.dispose();
                    this.actual.onError(th);
                    this.worker.dispose();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                long j2 = this.index.get();
                if (j2 != Long.MAX_VALUE) {
                    long j3 = 1 + j2;
                    if (this.index.compareAndSet(j2, j3)) {
                        this.task.get().dispose();
                        this.actual.onNext(t);
                        startTimeout(j3);
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) {
                DisposableHelper.setOnce(this.upstream, disposable);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) && this.index.compareAndSet(j2, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                ObservableSource<? extends T> observableSource = this.fallback;
                this.fallback = null;
                observableSource.subscribe(new FallbackObserver(this.actual, this));
                this.worker.dispose();
            }
        }

        public void startTimeout(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
                this.task.replace(this.worker.schedule(new TimeoutTask(j2, this), this.timeout, this.unit));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3764492702657003550L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public final SequentialDisposable task;
        public final long timeout;
        public final TimeUnit unit;
        public final AtomicReference<Disposable> upstream;
        public final Scheduler.Worker worker;

        public TimeoutObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Long.valueOf(j2), timeUnit, worker};
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
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = worker;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference<>();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this.upstream);
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? DisposableHelper.isDisposed(this.upstream.get()) : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                return;
            }
            this.task.dispose();
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                    this.task.dispose();
                    this.actual.onError(th);
                    this.worker.dispose();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                long j2 = get();
                if (j2 != Long.MAX_VALUE) {
                    long j3 = 1 + j2;
                    if (compareAndSet(j2, j3)) {
                        this.task.get().dispose();
                        this.actual.onNext(t);
                        startTimeout(j3);
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) {
                DisposableHelper.setOnce(this.upstream, disposable);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) && compareAndSet(j2, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.actual.onError(new TimeoutException());
                this.worker.dispose();
            }
        }

        public void startTimeout(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
                this.task.replace(this.worker.schedule(new TimeoutTask(j2, this), this.timeout, this.unit));
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface TimeoutSupport {
        void onTimeout(long j2);
    }

    /* loaded from: classes10.dex */
    public static final class TimeoutTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long idx;
        public final TimeoutSupport parent;

        public TimeoutTask(long j2, TimeoutSupport timeoutSupport) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), timeoutSupport};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.idx = j2;
            this.parent = timeoutSupport;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.parent.onTimeout(this.idx);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableTimeoutTimed(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observable, Long.valueOf(j2), timeUnit, scheduler, observableSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ObservableSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.timeout = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = observableSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            if (this.other == null) {
                TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.timeout, this.unit, this.scheduler.createWorker());
                observer.onSubscribe(timeoutObserver);
                timeoutObserver.startTimeout(0L);
                this.source.subscribe(timeoutObserver);
                return;
            }
            TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.timeout, this.unit, this.scheduler.createWorker(), this.other);
            observer.onSubscribe(timeoutFallbackObserver);
            timeoutFallbackObserver.startTimeout(0L);
            this.source.subscribe(timeoutFallbackObserver);
        }
    }
}
