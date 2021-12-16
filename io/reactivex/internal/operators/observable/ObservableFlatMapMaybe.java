package io.reactivex.internal.operators.observable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class ObservableFlatMapMaybe<T, R> extends AbstractObservableWithUpstream<T, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayErrors;
    public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;

    /* loaded from: classes4.dex */
    public static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8600231336733376951L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger active;
        public final Observer<? super R> actual;
        public volatile boolean cancelled;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f64591d;
        public final boolean delayErrors;
        public final AtomicThrowable errors;
        public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        public final AtomicReference<SpscLinkedArrayQueue<R>> queue;
        public final CompositeDisposable set;

        /* loaded from: classes4.dex */
        public final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -502562646270949838L;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlatMapMaybeObserver this$0;

            public InnerObserver(FlatMapMaybeObserver flatMapMaybeObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {flatMapMaybeObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = flatMapMaybeObserver;
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

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.this$0.innerComplete(this);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.this$0.innerError(this, th);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048581, this, r) == null) {
                    this.this$0.innerSuccess(this, r);
                }
            }
        }

        public FlatMapMaybeObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, Boolean.valueOf(z)};
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
            this.mapper = function;
            this.delayErrors = z;
            this.set = new CompositeDisposable();
            this.errors = new AtomicThrowable();
            this.active = new AtomicInteger(1);
            this.queue = new AtomicReference<>();
        }

        public void clear() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (spscLinkedArrayQueue = this.queue.get()) == null) {
                return;
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.cancelled = true;
                this.f64591d.dispose();
                this.set.dispose();
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public void drainLoop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Observer<? super R> observer = this.actual;
                AtomicInteger atomicInteger = this.active;
                AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.queue;
                int i2 = 1;
                while (!this.cancelled) {
                    if (!this.delayErrors && this.errors.get() != null) {
                        Throwable terminate = this.errors.terminate();
                        clear();
                        observer.onError(terminate);
                        return;
                    }
                    boolean z = atomicInteger.get() == 0;
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue = atomicReference.get();
                    R poll = spscLinkedArrayQueue != null ? spscLinkedArrayQueue.poll() : (Object) null;
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable terminate2 = this.errors.terminate();
                        if (terminate2 != null) {
                            observer.onError(terminate2);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(poll);
                    }
                }
                clear();
            }
        }

        public SpscLinkedArrayQueue<R> getOrCreateQueue() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                do {
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.queue.get();
                    if (spscLinkedArrayQueue2 != null) {
                        return spscLinkedArrayQueue2;
                    }
                    spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
                } while (!this.queue.compareAndSet(null, spscLinkedArrayQueue));
                return spscLinkedArrayQueue;
            }
            return (SpscLinkedArrayQueue) invokeV.objValue;
        }

        public void innerComplete(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, innerObserver) == null) {
                this.set.delete(innerObserver);
                if (get() == 0) {
                    if (compareAndSet(0, 1)) {
                        boolean z = this.active.decrementAndGet() == 0;
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
                        if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                this.actual.onError(terminate);
                                return;
                            } else {
                                this.actual.onComplete();
                                return;
                            }
                        } else if (decrementAndGet() == 0) {
                            return;
                        } else {
                            drainLoop();
                            return;
                        }
                    }
                }
                this.active.decrementAndGet();
                drain();
            }
        }

        public void innerError(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, innerObserver, th) == null) {
                this.set.delete(innerObserver);
                if (this.errors.addThrowable(th)) {
                    if (!this.delayErrors) {
                        this.f64591d.dispose();
                        this.set.dispose();
                    }
                    this.active.decrementAndGet();
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void innerSuccess(FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, innerObserver, r) == null) {
                this.set.delete(innerObserver);
                if (get() == 0) {
                    if (compareAndSet(0, 1)) {
                        this.actual.onNext(r);
                        boolean z = this.active.decrementAndGet() == 0;
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
                        if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                this.actual.onError(terminate);
                                return;
                            } else {
                                this.actual.onComplete();
                                return;
                            }
                        }
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        drainLoop();
                    }
                }
                SpscLinkedArrayQueue<R> orCreateQueue = getOrCreateQueue();
                synchronized (orCreateQueue) {
                    orCreateQueue.offer(r);
                }
                this.active.decrementAndGet();
                if (getAndIncrement() != 0) {
                    return;
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
                this.active.decrementAndGet();
                if (this.errors.addThrowable(th)) {
                    if (!this.delayErrors) {
                        this.set.dispose();
                    }
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
                try {
                    MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                    this.active.getAndIncrement();
                    InnerObserver innerObserver = new InnerObserver(this);
                    if (this.cancelled || !this.set.add(innerObserver)) {
                        return;
                    }
                    maybeSource.subscribe(innerObserver);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f64591d.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048588, this, disposable) == null) && DisposableHelper.validate(this.f64591d, disposable)) {
                this.f64591d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, function, Boolean.valueOf(z)};
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
        this.mapper = function;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            this.source.subscribe(new FlatMapMaybeObserver(observer, this.mapper, this.delayErrors));
        }
    }
}
