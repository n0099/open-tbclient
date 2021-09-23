package io.reactivex.internal.operators.observable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ObservableSource<U> firstTimeoutIndicator;
    public final Function<? super T, ? extends ObservableSource<V>> itemTimeoutIndicator;
    public final ObservableSource<? extends T> other;

    /* loaded from: classes10.dex */
    public static final class TimeoutConsumer extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8708641127342403073L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long idx;
        public final TimeoutSelectorSupport parent;

        public TimeoutConsumer(long j2, TimeoutSelectorSupport timeoutSelectorSupport) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), timeoutSelectorSupport};
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
            this.parent = timeoutSelectorSupport;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? DisposableHelper.isDisposed(get()) : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Object obj = get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (obj != disposableHelper) {
                    lazySet(disposableHelper);
                    this.parent.onTimeout(this.idx);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                Object obj = get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (obj != disposableHelper) {
                    lazySet(disposableHelper);
                    this.parent.onTimeoutError(this.idx, th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Disposable disposable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, obj) == null) || (disposable = (Disposable) get()) == DisposableHelper.DISPOSED) {
                return;
            }
            disposable.dispose();
            lazySet(DisposableHelper.DISPOSED);
            this.parent.onTimeout(this.idx);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSelectorSupport {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7508389464265974549L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public ObservableSource<? extends T> fallback;
        public final AtomicLong index;
        public final Function<? super T, ? extends ObservableSource<?>> itemTimeoutIndicator;
        public final SequentialDisposable task;
        public final AtomicReference<Disposable> upstream;

        public TimeoutFallbackObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function, ObservableSource<? extends T> observableSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, observableSource};
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
            this.itemTimeoutIndicator = function;
            this.task = new SequentialDisposable();
            this.fallback = observableSource;
            this.index = new AtomicLong();
            this.upstream = new AtomicReference<>();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this.upstream);
                DisposableHelper.dispose(this);
                this.task.dispose();
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
            this.task.dispose();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                    this.task.dispose();
                    this.actual.onError(th);
                    this.task.dispose();
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
                        Disposable disposable = this.task.get();
                        if (disposable != null) {
                            disposable.dispose();
                        }
                        this.actual.onNext(t);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null ObservableSource.");
                            TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j3, this);
                            if (this.task.replace(timeoutConsumer)) {
                                observableSource.subscribe(timeoutConsumer);
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.upstream.get().dispose();
                            this.index.getAndSet(Long.MAX_VALUE);
                            this.actual.onError(th);
                        }
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
                observableSource.subscribe(new ObservableTimeoutTimed.FallbackObserver(this.actual, this));
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.TimeoutSelectorSupport
        public void onTimeoutError(long j2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048583, this, j2, th) == null) {
                if (this.index.compareAndSet(j2, Long.MAX_VALUE)) {
                    DisposableHelper.dispose(this);
                    this.actual.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void startFirstTimeout(ObservableSource<?> observableSource) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, observableSource) == null) || observableSource == null) {
                return;
            }
            TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
            if (this.task.replace(timeoutConsumer)) {
                observableSource.subscribe(timeoutConsumer);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSelectorSupport {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3764492702657003550L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public final Function<? super T, ? extends ObservableSource<?>> itemTimeoutIndicator;
        public final SequentialDisposable task;
        public final AtomicReference<Disposable> upstream;

        public TimeoutObserver(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<?>> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function};
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
            this.itemTimeoutIndicator = function;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference<>();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this.upstream);
                this.task.dispose();
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
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                    this.task.dispose();
                    this.actual.onError(th);
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
                        Disposable disposable = this.task.get();
                        if (disposable != null) {
                            disposable.dispose();
                        }
                        this.actual.onNext(t);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null ObservableSource.");
                            TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j3, this);
                            if (this.task.replace(timeoutConsumer)) {
                                observableSource.subscribe(timeoutConsumer);
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.upstream.get().dispose();
                            getAndSet(Long.MAX_VALUE);
                            this.actual.onError(th);
                        }
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
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.TimeoutSelectorSupport
        public void onTimeoutError(long j2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048583, this, j2, th) == null) {
                if (compareAndSet(j2, Long.MAX_VALUE)) {
                    DisposableHelper.dispose(this.upstream);
                    this.actual.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void startFirstTimeout(ObservableSource<?> observableSource) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, observableSource) == null) || observableSource == null) {
                return;
            }
            TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
            if (this.task.replace(timeoutConsumer)) {
                observableSource.subscribe(timeoutConsumer);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface TimeoutSelectorSupport extends ObservableTimeoutTimed.TimeoutSupport {
        void onTimeoutError(long j2, Throwable th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableTimeout(Observable<T> observable, ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        super(observable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observable, observableSource, function, observableSource2};
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
        this.firstTimeoutIndicator = observableSource;
        this.itemTimeoutIndicator = function;
        this.other = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            if (this.other == null) {
                TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.itemTimeoutIndicator);
                observer.onSubscribe(timeoutObserver);
                timeoutObserver.startFirstTimeout(this.firstTimeoutIndicator);
                this.source.subscribe(timeoutObserver);
                return;
            }
            TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.itemTimeoutIndicator, this.other);
            observer.onSubscribe(timeoutFallbackObserver);
            timeoutFallbackObserver.startFirstTimeout(this.firstTimeoutIndicator);
            this.source.subscribe(timeoutFallbackObserver);
        }
    }
}
