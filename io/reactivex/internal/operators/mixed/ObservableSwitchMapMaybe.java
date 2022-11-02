package io.reactivex.internal.operators.mixed;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
@Experimental
/* loaded from: classes8.dex */
public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayErrors;
    public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    public final Observable<T> source;

    /* loaded from: classes8.dex */
    public static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final SwitchMapMaybeObserver<Object> INNER_DISPOSED;
        public static final long serialVersionUID = -5402190102429853762L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Observer<? super R> downstream;
        public final AtomicThrowable errors;
        public final AtomicReference<SwitchMapMaybeObserver<R>> inner;
        public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        public Disposable upstream;

        /* loaded from: classes8.dex */
        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 8042919737683345351L;
            public transient /* synthetic */ FieldHolder $fh;
            public volatile R item;
            public final SwitchMapMaybeMainObserver<?, R> parent;

            public SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {switchMapMaybeMainObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.parent = switchMapMaybeMainObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.parent.innerError(this, th);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, r) == null) {
                    this.item = r;
                    this.parent.drain();
                }
            }

            public void dispose() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DisposableHelper.dispose(this);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.parent.innerComplete(this);
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(849584804, "Lio/reactivex/internal/operators/mixed/ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(849584804, "Lio/reactivex/internal/operators/mixed/ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver;");
                    return;
                }
            }
            INNER_DISPOSED = new SwitchMapMaybeObserver<>(null);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
                this.upstream.dispose();
                disposeInner();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver$SwitchMapMaybeObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void disposeInner() {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (switchMapMaybeObserver = (SwitchMapMaybeObserver) this.inner.getAndSet(INNER_DISPOSED)) != null && switchMapMaybeObserver != INNER_DISPOSED) {
                switchMapMaybeObserver.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.cancelled;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.done = true;
                drain();
            }
        }

        public SwitchMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.downstream = observer;
            this.mapper = function;
            this.delayErrors = z;
            this.errors = new AtomicThrowable();
            this.inner = new AtomicReference<>();
        }

        /* JADX DEBUG: Type inference failed for r5v5. Raw type applied. Possible types: R, ? super R */
        public void drain() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            int i = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    observer.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z2 = this.done;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                if (switchMapMaybeObserver == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    Throwable terminate = atomicThrowable.terminate();
                    if (terminate != null) {
                        observer.onError(terminate);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z && switchMapMaybeObserver.item != null) {
                    atomicReference.compareAndSet(switchMapMaybeObserver, null);
                    observer.onNext((R) switchMapMaybeObserver.item);
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        public void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, switchMapMaybeObserver) == null) && this.inner.compareAndSet(switchMapMaybeObserver, null)) {
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
                if (this.errors.addThrowable(th)) {
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

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, disposable) == null) && DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, switchMapMaybeObserver, th) == null) {
                if (this.inner.compareAndSet(switchMapMaybeObserver, null) && this.errors.addThrowable(th)) {
                    if (!this.delayErrors) {
                        this.upstream.dispose();
                        disposeInner();
                    }
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver$SwitchMapMaybeObserver<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
                SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.inner.get();
                if (switchMapMaybeObserver2 != null) {
                    switchMapMaybeObserver2.dispose();
                }
                try {
                    MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                    SwitchMapMaybeObserver<R> switchMapMaybeObserver3 = new SwitchMapMaybeObserver<>(this);
                    do {
                        switchMapMaybeObserver = this.inner.get();
                        if (switchMapMaybeObserver == INNER_DISPOSED) {
                            return;
                        }
                    } while (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
                    maybeSource.subscribe(switchMapMaybeObserver3);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.dispose();
                    this.inner.getAndSet(INNER_DISPOSED);
                    onError(th);
                }
            }
        }
    }

    public ObservableSwitchMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observable, function, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = observable;
        this.mapper = function;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, observer) == null) && !ScalarXMapZHelper.tryAsMaybe(this.source, this.mapper, observer)) {
            this.source.subscribe(new SwitchMapMaybeMainObserver(observer, this.mapper, this.delayErrors));
        }
    }
}
