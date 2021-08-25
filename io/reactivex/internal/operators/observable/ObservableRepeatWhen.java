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
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class ObservableRepeatWhen<T> extends AbstractObservableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function<? super Observable<Object>, ? extends ObservableSource<?>> handler;

    /* loaded from: classes2.dex */
    public static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 802743776666017014L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean active;
        public final Observer<? super T> actual;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Disposable> f78764d;
        public final AtomicThrowable error;
        public final RepeatWhenObserver<T>.InnerRepeatObserver inner;
        public final Subject<Object> signaller;
        public final ObservableSource<T> source;
        public final AtomicInteger wip;

        /* loaded from: classes2.dex */
        public final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 3254781284376480842L;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RepeatWhenObserver this$0;

            public InnerRepeatObserver(RepeatWhenObserver repeatWhenObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {repeatWhenObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = repeatWhenObserver;
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.this$0.innerComplete();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.this$0.innerError(th);
                }
            }

            @Override // io.reactivex.Observer
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    this.this$0.innerNext();
                }
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }
        }

        public RepeatWhenObserver(Observer<? super T> observer, Subject<Object> subject, ObservableSource<T> observableSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, subject, observableSource};
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
            this.signaller = subject;
            this.source = observableSource;
            this.wip = new AtomicInteger();
            this.error = new AtomicThrowable();
            this.inner = new InnerRepeatObserver(this);
            this.f78764d = new AtomicReference<>();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this.f78764d);
                DisposableHelper.dispose(this.inner);
            }
        }

        public void innerComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                DisposableHelper.dispose(this.f78764d);
                HalfSerializer.onComplete(this.actual, this, this.error);
            }
        }

        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                DisposableHelper.dispose(this.f78764d);
                HalfSerializer.onError(this.actual, th, this, this.error);
            }
        }

        public void innerNext() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                subscribeNext();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? DisposableHelper.isDisposed(this.f78764d.get()) : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.active = false;
                this.signaller.onNext(0);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
                DisposableHelper.dispose(this.inner);
                HalfSerializer.onError(this.actual, th, this, this.error);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
                HalfSerializer.onNext(this.actual, t, this, this.error);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) {
                DisposableHelper.replace(this.f78764d, disposable);
            }
        }

        public void subscribeNext() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableRepeatWhen(ObservableSource<T> observableSource, Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, function};
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
        this.handler = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            Subject<T> serialized = PublishSubject.create().toSerialized();
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.handler.apply(serialized), "The handler returned a null ObservableSource");
                RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, serialized, this.source);
                observer.onSubscribe(repeatWhenObserver);
                observableSource.subscribe(repeatWhenObserver.inner);
                repeatWhenObserver.subscribeNext();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
            }
        }
    }
}
