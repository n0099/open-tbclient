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
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
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
/* loaded from: classes9.dex */
public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Function<? super Object[], R> combiner;
    @Nullable
    public final ObservableSource<?>[] otherArray;
    @Nullable
    public final Iterable<? extends ObservableSource<?>> otherIterable;

    /* loaded from: classes9.dex */
    public final class SingletonArrayFunc implements Function<T, R> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = observableWithLatestFromMany;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? (R) ObjectHelper.requireNonNull(this.this$0.combiner.apply(new Object[]{t}), "The combiner returned a null value") : (R) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1577321883966341961L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super R> actual;
        public final Function<? super Object[], R> combiner;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Disposable> f73508d;
        public volatile boolean done;
        public final AtomicThrowable error;
        public final WithLatestInnerObserver[] observers;
        public final AtomicReferenceArray<Object> values;

        public WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = observer;
            this.combiner = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                withLatestInnerObserverArr[i5] = new WithLatestInnerObserver(this, i5);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new AtomicReferenceArray<>(i2);
            this.f73508d = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }

        public void cancelAllBut(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
                for (int i3 = 0; i3 < withLatestInnerObserverArr.length; i3++) {
                    if (i3 != i2) {
                        withLatestInnerObserverArr[i3].dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                DisposableHelper.dispose(this.f73508d);
                for (WithLatestInnerObserver withLatestInnerObserver : this.observers) {
                    withLatestInnerObserver.dispose();
                }
            }
        }

        public void innerComplete(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || z) {
                return;
            }
            this.done = true;
            cancelAllBut(i2);
            HalfSerializer.onComplete(this.actual, this, this.error);
        }

        public void innerError(int i2, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i2, th) == null) {
                this.done = true;
                DisposableHelper.dispose(this.f73508d);
                cancelAllBut(i2);
                HalfSerializer.onError(this.actual, th, this, this.error);
            }
        }

        public void innerNext(int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, obj) == null) {
                this.values.set(i2, obj);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? DisposableHelper.isDisposed(this.f73508d.get()) : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onComplete(this.actual, this, this.error);
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
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) || this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i2 = 0;
            objArr[0] = t;
            while (i2 < length) {
                Object obj = atomicReferenceArray.get(i2);
                if (obj == null) {
                    return;
                }
                i2++;
                objArr[i2] = obj;
            }
            try {
                HalfSerializer.onNext(this.actual, ObjectHelper.requireNonNull(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, disposable) == null) {
                DisposableHelper.setOnce(this.f73508d, disposable);
            }
        }

        public void subscribe(ObservableSource<?>[] observableSourceArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048586, this, observableSourceArr, i2) == null) {
                WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
                AtomicReference<Disposable> atomicReference = this.f73508d;
                for (int i3 = 0; i3 < i2 && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i3++) {
                    observableSourceArr[i3].subscribe(withLatestInnerObserverArr[i3]);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3256684027868224024L;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean hasValue;
        public final int index;
        public final WithLatestFromObserver<?, ?> parent;

        public WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {withLatestFromObserver, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = withLatestFromObserver;
            this.index = i2;
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
    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull ObservableSource<?>[] observableSourceArr, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, observableSourceArr, function};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public void subscribeActual(Observer<? super R> observer) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            ObservableSource<?>[] observableSourceArr = this.otherArray;
            if (observableSourceArr == null) {
                observableSourceArr = new ObservableSource[8];
                try {
                    length = 0;
                    for (ObservableSource<?> observableSource : this.otherIterable) {
                        if (length == observableSourceArr.length) {
                            observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (length >> 1) + length);
                        }
                        int i2 = length + 1;
                        observableSourceArr[length] = observableSource;
                        length = i2;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull Iterable<? extends ObservableSource<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, iterable, function};
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
        this.otherArray = null;
        this.otherIterable = iterable;
        this.combiner = function;
    }
}
