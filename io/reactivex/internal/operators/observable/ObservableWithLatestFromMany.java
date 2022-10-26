package io.reactivex.internal.operators.observable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes8.dex */
public final class ObservableWithLatestFromMany extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function combiner;
    public final ObservableSource[] otherArray;
    public final Iterable otherIterable;

    /* loaded from: classes8.dex */
    public final class SingletonArrayFunc implements Function {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ObservableWithLatestFromMany this$0;

        public SingletonArrayFunc(ObservableWithLatestFromMany observableWithLatestFromMany) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observableWithLatestFromMany};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = observableWithLatestFromMany;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return ObjectHelper.requireNonNull(this.this$0.combiner.apply(new Object[]{obj}), "The combiner returned a null value");
            }
            return invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class WithLatestFromObserver extends AtomicInteger implements Observer, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1577321883966341961L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer actual;
        public final Function combiner;
        public final AtomicReference d;
        public volatile boolean done;
        public final AtomicThrowable error;
        public final WithLatestInnerObserver[] observers;
        public final AtomicReferenceArray values;

        public WithLatestFromObserver(Observer observer, Function function, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, Integer.valueOf(i)};
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
            this.combiner = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i];
            for (int i4 = 0; i4 < i; i4++) {
                withLatestInnerObserverArr[i4] = new WithLatestInnerObserver(this, i4);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new AtomicReferenceArray(i);
            this.d = new AtomicReference();
            this.error = new AtomicThrowable();
        }

        public void cancelAllBut(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
                for (int i2 = 0; i2 < withLatestInnerObserverArr.length; i2++) {
                    if (i2 != i) {
                        withLatestInnerObserverArr[i2].dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.done = true;
                cancelAllBut(-1);
                HalfSerializer.onError(this.actual, th, this, this.error);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, disposable) == null) {
                DisposableHelper.setOnce(this.d, disposable);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                DisposableHelper.dispose(this.d);
                for (WithLatestInnerObserver withLatestInnerObserver : this.observers) {
                    withLatestInnerObserver.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return DisposableHelper.isDisposed((Disposable) this.d.get());
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.done) {
                this.done = true;
                cancelAllBut(-1);
                HalfSerializer.onComplete(this.actual, this, this.error);
            }
        }

        public void innerComplete(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && !z) {
                this.done = true;
                cancelAllBut(i);
                HalfSerializer.onComplete(this.actual, this, this.error);
            }
        }

        public void innerError(int i, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, th) == null) {
                this.done = true;
                DisposableHelper.dispose(this.d);
                cancelAllBut(i);
                HalfSerializer.onError(this.actual, th, this, this.error);
            }
        }

        public void innerNext(int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, obj) == null) {
                this.values.set(i, obj);
            }
        }

        public void subscribe(ObservableSource[] observableSourceArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048586, this, observableSourceArr, i) == null) {
                WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
                AtomicReference atomicReference = this.d;
                for (int i2 = 0; i2 < i && !DisposableHelper.isDisposed((Disposable) atomicReference.get()) && !this.done; i2++) {
                    observableSourceArr[i2].subscribe(withLatestInnerObserverArr[i2]);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj) != null) || this.done) {
                return;
            }
            AtomicReferenceArray atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i = 0;
            objArr[0] = obj;
            while (i < length) {
                Object obj2 = atomicReferenceArray.get(i);
                if (obj2 == null) {
                    return;
                }
                i++;
                objArr[i] = obj2;
            }
            try {
                HalfSerializer.onNext(this.actual, ObjectHelper.requireNonNull(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                onError(th);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class WithLatestInnerObserver extends AtomicReference implements Observer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3256684027868224024L;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean hasValue;
        public final int index;
        public final WithLatestFromObserver parent;

        public WithLatestInnerObserver(WithLatestFromObserver withLatestFromObserver, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {withLatestFromObserver, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = withLatestFromObserver;
            this.index = i;
        }

        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.parent.innerComplete(this.index, this.hasValue);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.parent.innerError(this.index, th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                if (!this.hasValue) {
                    this.hasValue = true;
                }
                this.parent.innerNext(this.index, obj);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableWithLatestFromMany(ObservableSource observableSource, Iterable iterable, Function function) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, iterable, function};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ObservableSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.otherArray = null;
        this.otherIterable = iterable;
        this.combiner = function;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableWithLatestFromMany(ObservableSource observableSource, ObservableSource[] observableSourceArr, Function function) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, observableSourceArr, function};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ObservableSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.otherArray = observableSourceArr;
        this.otherIterable = null;
        this.combiner = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            ObservableSource[] observableSourceArr = this.otherArray;
            if (observableSourceArr == null) {
                observableSourceArr = new ObservableSource[8];
                try {
                    length = 0;
                    for (ObservableSource observableSource : this.otherIterable) {
                        if (length == observableSourceArr.length) {
                            observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (length >> 1) + length);
                        }
                        int i = length + 1;
                        observableSourceArr[length] = observableSource;
                        length = i;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptyDisposable.error(th, observer);
                    return;
                }
            } else {
                length = observableSourceArr.length;
            }
            if (length == 0) {
                new ObservableMap(this.source, new SingletonArrayFunc(this)).subscribeActual(observer);
                return;
            }
            WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.combiner, length);
            observer.onSubscribe(withLatestFromObserver);
            withLatestFromObserver.subscribe(observableSourceArr, length);
            this.source.subscribe(withLatestFromObserver);
        }
    }
}
