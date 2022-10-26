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
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class ObservableScalarXMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public final class ScalarDisposable extends AtomicInteger implements QueueDisposable, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FUSED = 1;
        public static final int ON_COMPLETE = 3;
        public static final int ON_NEXT = 2;
        public static final int START = 0;
        public static final long serialVersionUID = 3880992722410194083L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer observer;
        public final Object value;

        public ScalarDisposable(Observer observer, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.observer = observer;
            this.value = obj;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (get() == 3) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (get() != 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (get() == 1) {
                    lazySet(3);
                    return this.value;
                }
                return null;
            }
            return invokeV.objValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                throw new UnsupportedOperationException("Should not be called!");
            }
            return invokeL.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                if ((i & 1) != 0) {
                    lazySet(1);
                    return 1;
                }
                return 0;
            }
            return invokeI.intValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, obj, obj2)) == null) {
                throw new UnsupportedOperationException("Should not be called!");
            }
            return invokeLL.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class ScalarXMapObservable extends Observable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function mapper;
        public final Object value;

        public ScalarXMapObservable(Object obj, Function function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = obj;
            this.mapper = function;
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer observer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null ObservableSource");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new IllegalStateException("No instances!");
    }

    public static Observable scalarXMap(Object obj, Function function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, function)) == null) {
            return RxJavaPlugins.onAssembly(new ScalarXMapObservable(obj, function));
        }
        return (Observable) invokeLL.objValue;
    }

    public static boolean tryScalarXMapSubscribe(ObservableSource observableSource, Observer observer, Function function) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, observableSource, observer, function)) == null) {
            if (observableSource instanceof Callable) {
                try {
                    Object call = ((Callable) observableSource).call();
                    if (call == null) {
                        EmptyDisposable.complete(observer);
                        return true;
                    }
                    try {
                        ObservableSource observableSource2 = (ObservableSource) ObjectHelper.requireNonNull(function.apply(call), "The mapper returned a null ObservableSource");
                        if (observableSource2 instanceof Callable) {
                            try {
                                Object call2 = ((Callable) observableSource2).call();
                                if (call2 == null) {
                                    EmptyDisposable.complete(observer);
                                    return true;
                                }
                                ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call2);
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
