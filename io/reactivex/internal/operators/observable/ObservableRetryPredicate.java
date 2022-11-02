package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long count;
    public final Predicate<? super Throwable> predicate;

    /* loaded from: classes8.dex */
    public static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7098360935104053232L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public final Predicate<? super Throwable> predicate;
        public long remaining;
        public final SequentialDisposable sa;
        public final ObservableSource<? extends T> source;

        public RepeatObserver(Observer<? super T> observer, long j, Predicate<? super Throwable> predicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Long.valueOf(j), predicate, sequentialDisposable, observableSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = observer;
            this.sa = sequentialDisposable;
            this.source = observableSource;
            this.predicate = predicate;
            this.remaining = j;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.actual.onComplete();
            }
        }

        public void subscribeNext() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getAndIncrement() == 0) {
                int i = 1;
                while (!this.sa.isDisposed()) {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                long j = this.remaining;
                if (j != Long.MAX_VALUE) {
                    this.remaining = j - 1;
                }
                if (j == 0) {
                    this.actual.onError(th);
                    return;
                }
                try {
                    if (!this.predicate.test(th)) {
                        this.actual.onError(th);
                    } else {
                        subscribeNext();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.actual.onError(new CompositeException(th, th2));
                }
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
                this.sa.update(disposable);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableRetryPredicate(Observable<T> observable, long j, Predicate<? super Throwable> predicate) {
        super(observable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observable, Long.valueOf(j), predicate};
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
        this.predicate = predicate;
        this.count = j;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            observer.onSubscribe(sequentialDisposable);
            new RepeatObserver(observer, this.count, this.predicate, sequentialDisposable, this.source).subscribeNext();
        }
    }
}
