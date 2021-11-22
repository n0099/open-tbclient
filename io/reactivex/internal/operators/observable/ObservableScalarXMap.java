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
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class ObservableScalarXMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FUSED = 1;
        public static final int ON_COMPLETE = 3;
        public static final int ON_NEXT = 2;
        public static final int START = 0;
        public static final long serialVersionUID = 3880992722410194083L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> observer;
        public final T value;

        public ScalarDisposable(Observer<? super T> observer, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.observer = observer;
            this.value = t;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lazySet(3);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                set(3);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? get() == 3 : invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? get() != 1 : invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t)) == null) {
                throw new UnsupportedOperationException("Should not be called!");
            }
            return invokeL.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (get() == 1) {
                    lazySet(3);
                    return this.value;
                }
                return null;
            }
            return (T) invokeV.objValue;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                if ((i2 & 1) != 0) {
                    lazySet(1);
                    return 1;
                }
                return 0;
            }
            return invokeI.intValue;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext((T) this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(T t, T t2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, t, t2)) == null) {
                throw new UnsupportedOperationException("Should not be called!");
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScalarXMapObservable<T, R> extends Observable<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        public final T value;

        public ScalarXMapObservable(T t, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = t;
            this.mapper = function;
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super R> observer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply((T) this.value), "The mapper returned a null ObservableSource");
                    if (observableSource instanceof Callable) {
                        try {
                            Object call = ((Callable) observableSource).call();
                            if (call == null) {
                                EmptyDisposable.complete(observer);
                                return;
                            }
                            ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call);
                            observer.onSubscribe(scalarDisposable);
                            scalarDisposable.run();
                            return;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            EmptyDisposable.error(th, observer);
                            return;
                        }
                    }
                    observableSource.subscribe(observer);
                } catch (Throwable th2) {
                    EmptyDisposable.error(th2, observer);
                }
            }
        }
    }

    public ObservableScalarXMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Observable<U> scalarXMap(T t, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, function)) == null) ? RxJavaPlugins.onAssembly(new ScalarXMapObservable(t, function)) : (Observable) invokeLL.objValue;
    }

    public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, observableSource, observer, function)) == null) {
            if (observableSource instanceof Callable) {
                try {
                    Object obj = (Object) ((Callable) observableSource).call();
                    if (obj == 0) {
                        EmptyDisposable.complete(observer);
                        return true;
                    }
                    try {
                        ObservableSource observableSource2 = (ObservableSource) ObjectHelper.requireNonNull(function.apply(obj), "The mapper returned a null ObservableSource");
                        if (observableSource2 instanceof Callable) {
                            try {
                                Object call = ((Callable) observableSource2).call();
                                if (call == null) {
                                    EmptyDisposable.complete(observer);
                                    return true;
                                }
                                ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call);
                                observer.onSubscribe(scalarDisposable);
                                scalarDisposable.run();
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                EmptyDisposable.error(th, observer);
                                return true;
                            }
                        } else {
                            observableSource2.subscribe(observer);
                        }
                        return true;
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptyDisposable.error(th2, observer);
                        return true;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    EmptyDisposable.error(th3, observer);
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
