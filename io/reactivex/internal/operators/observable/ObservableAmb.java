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
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class ObservableAmb<T> extends Observable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ObservableSource<? extends T>[] sources;
    public final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;

    /* loaded from: classes9.dex */
    public static final class AmbCoordinator<T> implements Disposable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public final AmbInnerObserver<T>[] observers;
        public final AtomicInteger winner;

        public AmbCoordinator(Observer<? super T> observer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.winner = new AtomicInteger();
            this.actual = observer;
            this.observers = new AmbInnerObserver[i];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.winner.get() != -1) {
                this.winner.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.observers) {
                    ambInnerObserver.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.winner.get() == -1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, observableSourceArr) == null) {
                AmbInnerObserver<T>[] ambInnerObserverArr = this.observers;
                int length = ambInnerObserverArr.length;
                int i = 0;
                while (i < length) {
                    int i2 = i + 1;
                    ambInnerObserverArr[i] = new AmbInnerObserver<>(this, i2, this.actual);
                    i = i2;
                }
                this.winner.lazySet(0);
                this.actual.onSubscribe(this);
                for (int i3 = 0; i3 < length && this.winner.get() == 0; i3++) {
                    observableSourceArr[i3].subscribe(ambInnerObserverArr[i3]);
                }
            }
        }

        public boolean win(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                int i2 = this.winner.get();
                int i3 = 0;
                if (i2 == 0) {
                    if (!this.winner.compareAndSet(0, i)) {
                        return false;
                    }
                    AmbInnerObserver<T>[] ambInnerObserverArr = this.observers;
                    int length = ambInnerObserverArr.length;
                    while (i3 < length) {
                        int i4 = i3 + 1;
                        if (i4 != i) {
                            ambInnerObserverArr[i3].dispose();
                        }
                        i3 = i4;
                    }
                    return true;
                } else if (i2 == i) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1185974347409665484L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public final int index;
        public final AmbCoordinator<T> parent;
        public boolean won;

        public AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int i, Observer<? super T> observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ambCoordinator, Integer.valueOf(i), observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = ambCoordinator;
            this.index = i;
            this.actual = observer;
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
                if (this.won) {
                    this.actual.onComplete();
                } else if (this.parent.win(this.index)) {
                    this.won = true;
                    this.actual.onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.won) {
                    this.actual.onError(th);
                } else if (this.parent.win(this.index)) {
                    this.won = true;
                    this.actual.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                if (this.won) {
                    this.actual.onNext(t);
                } else if (this.parent.win(this.index)) {
                    this.won = true;
                    this.actual.onNext(t);
                } else {
                    get().dispose();
                }
            }
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSourceArr, iterable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            ObservableSource<? extends T>[] observableSourceArr = this.sources;
            if (observableSourceArr == null) {
                observableSourceArr = new Observable[8];
                try {
                    length = 0;
                    for (ObservableSource<? extends T> observableSource : this.sourcesIterable) {
                        if (observableSource == null) {
                            EmptyDisposable.error(new NullPointerException("One of the sources is null"), observer);
                            return;
                        }
                        if (length == observableSourceArr.length) {
                            ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                            System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                            observableSourceArr = observableSourceArr2;
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
                EmptyDisposable.complete(observer);
            } else if (length == 1) {
                observableSourceArr[0].subscribe(observer);
            } else {
                new AmbCoordinator(observer, length).subscribe(observableSourceArr);
            }
        }
    }
}
