package io.reactivex.internal.operators.observable;

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
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final ErrorMode delayErrors;
    public final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

    /* loaded from: classes10.dex */
    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6951100001833242599L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean active;
        public final Observer<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f79306d;
        public volatile boolean done;
        public final AtomicThrowable error;
        public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        public final DelayErrorInnerObserver<R> observer;
        public SimpleQueue<T> queue;
        public int sourceMode;
        public final boolean tillTheEnd;

        /* loaded from: classes10.dex */
        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 2620149119579502636L;
            public transient /* synthetic */ FieldHolder $fh;
            public final Observer<? super R> actual;
            public final ConcatMapDelayErrorObserver<?, R> parent;

            public DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {observer, concatMapDelayErrorObserver};
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
                this.parent = concatMapDelayErrorObserver;
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
                    ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                    concatMapDelayErrorObserver.active = false;
                    concatMapDelayErrorObserver.drain();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                    if (concatMapDelayErrorObserver.error.addThrowable(th)) {
                        if (!concatMapDelayErrorObserver.tillTheEnd) {
                            concatMapDelayErrorObserver.f79306d.dispose();
                        }
                        concatMapDelayErrorObserver.active = false;
                        concatMapDelayErrorObserver.drain();
                        return;
                    }
                    RxJavaPlugins.onError(th);
                }
            }

            @Override // io.reactivex.Observer
            public void onNext(R r) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, r) == null) {
                    this.actual.onNext(r);
                }
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
                    DisposableHelper.replace(this, disposable);
                }
            }
        }

        public ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.mapper = function;
            this.bufferSize = i2;
            this.tillTheEnd = z;
            this.error = new AtomicThrowable();
            this.observer = new DelayErrorInnerObserver<>(observer, this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
                this.f79306d.dispose();
                this.observer.dispose();
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.actual;
            SimpleQueue<T> simpleQueue = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        simpleQueue.clear();
                        return;
                    } else if (!this.tillTheEnd && atomicThrowable.get() != null) {
                        simpleQueue.clear();
                        this.cancelled = true;
                        observer.onError(atomicThrowable.terminate());
                        return;
                    } else {
                        boolean z = this.done;
                        try {
                            T poll = simpleQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.cancelled = true;
                                Throwable terminate = atomicThrowable.terminate();
                                if (terminate != null) {
                                    observer.onError(terminate);
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                    if (observableSource instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) observableSource).call();
                                            if (obj != 0 && !this.cancelled) {
                                                observer.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            atomicThrowable.addThrowable(th);
                                        }
                                    } else {
                                        this.active = true;
                                        observableSource.subscribe(this.observer);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.cancelled = true;
                                    this.f79306d.dispose();
                                    simpleQueue.clear();
                                    atomicThrowable.addThrowable(th2);
                                    observer.onError(atomicThrowable.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.cancelled = true;
                            this.f79306d.dispose();
                            atomicThrowable.addThrowable(th3);
                            observer.onError(atomicThrowable.terminate());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                if (this.error.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                if (this.sourceMode == 0) {
                    this.queue.offer(t);
                }
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, disposable) == null) && DisposableHelper.validate(this.f79306d, disposable)) {
                this.f79306d = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8828587559905699186L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean active;
        public final Observer<? super U> actual;
        public final int bufferSize;
        public volatile boolean disposed;
        public volatile boolean done;
        public int fusionMode;
        public final InnerObserver<U> inner;
        public final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        public SimpleQueue<T> queue;
        public Disposable s;

        /* loaded from: classes10.dex */
        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -7449079488798789337L;
            public transient /* synthetic */ FieldHolder $fh;
            public final Observer<? super U> actual;
            public final SourceObserver<?, ?> parent;

            public InnerObserver(Observer<? super U> observer, SourceObserver<?, ?> sourceObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {observer, sourceObserver};
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
                this.parent = sourceObserver;
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
                    this.parent.innerComplete();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.parent.dispose();
                    this.actual.onError(th);
                }
            }

            @Override // io.reactivex.Observer
            public void onNext(U u) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, u) == null) {
                    this.actual.onNext(u);
                }
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
                    DisposableHelper.set(this, disposable);
                }
            }
        }

        public SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2) {
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
            this.mapper = function;
            this.bufferSize = i2;
            this.inner = new InnerObserver<>(observer, this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.disposed = true;
                this.inner.dispose();
                this.s.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndIncrement() == 0) {
                while (!this.disposed) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.disposed = true;
                                this.actual.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                    this.active = true;
                                    observableSource.subscribe(this.inner);
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    dispose();
                                    this.queue.clear();
                                    this.actual.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            dispose();
                            this.queue.clear();
                            this.actual.onError(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        public void innerComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.active = false;
                drain();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.disposed : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.done = true;
                dispose();
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, t) == null) || this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueDisposable;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2, ErrorMode errorMode) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, function, Integer.valueOf(i2), errorMode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((ObservableSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mapper = function;
        this.delayErrors = errorMode;
        this.bufferSize = Math.max(8, i2);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, observer) == null) || ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.mapper)) {
            return;
        }
        if (this.delayErrors == ErrorMode.IMMEDIATE) {
            this.source.subscribe(new SourceObserver(new SerializedObserver(observer), this.mapper, this.bufferSize));
        } else {
            this.source.subscribe(new ConcatMapDelayErrorObserver(observer, this.mapper, this.bufferSize, this.delayErrors == ErrorMode.END));
        }
    }
}
