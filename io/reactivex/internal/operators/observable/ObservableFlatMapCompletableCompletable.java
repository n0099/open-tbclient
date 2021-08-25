package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayErrors;
    public final Function<? super T, ? extends CompletableSource> mapper;
    public final ObservableSource<T> source;

    /* loaded from: classes2.dex */
    public static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements Disposable, Observer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8443155186132538303L;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompletableObserver actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f78754d;
        public final boolean delayErrors;
        public volatile boolean disposed;
        public final AtomicThrowable errors;
        public final Function<? super T, ? extends CompletableSource> mapper;
        public final CompositeDisposable set;

        /* loaded from: classes2.dex */
        public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 8606673141535671828L;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlatMapCompletableMainObserver this$0;

            public InnerObserver(FlatMapCompletableMainObserver flatMapCompletableMainObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {flatMapCompletableMainObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = flatMapCompletableMainObserver;
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

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.this$0.innerComplete(this);
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.this$0.innerError(this, th);
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }
        }

        public FlatMapCompletableMainObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {completableObserver, function, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = completableObserver;
            this.mapper = function;
            this.delayErrors = z;
            this.errors = new AtomicThrowable();
            this.set = new CompositeDisposable();
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.disposed = true;
                this.f78754d.dispose();
                this.set.dispose();
            }
        }

        public void innerComplete(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, innerObserver) == null) {
                this.set.delete(innerObserver);
                onComplete();
            }
        }

        public void innerError(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, innerObserver, th) == null) {
                this.set.delete(innerObserver);
                onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f78754d.isDisposed() : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && decrementAndGet() == 0) {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.actual.onError(terminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    if (this.delayErrors) {
                        if (decrementAndGet() == 0) {
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                        return;
                    }
                    dispose();
                    if (getAndSet(0) > 0) {
                        this.actual.onError(this.errors.terminate());
                        return;
                    }
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                try {
                    CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                    getAndIncrement();
                    InnerObserver innerObserver = new InnerObserver(this);
                    if (this.disposed || !this.set.add(innerObserver)) {
                        return;
                    }
                    completableSource.subscribe(innerObserver);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f78754d.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, disposable) == null) && DisposableHelper.validate(this.f78754d, disposable)) {
                this.f78754d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, function, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = observableSource;
        this.mapper = function;
        this.delayErrors = z;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<T> fuseToObservable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? RxJavaPlugins.onAssembly(new ObservableFlatMapCompletable(this.source, this.mapper, this.delayErrors)) : (Observable) invokeV.objValue;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, completableObserver) == null) {
            this.source.subscribe(new FlatMapCompletableMainObserver(completableObserver, this.mapper, this.delayErrors));
        }
    }
}
