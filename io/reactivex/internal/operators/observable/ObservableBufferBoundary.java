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
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function<? super Open, ? extends ObservableSource<? extends Close>> bufferClose;
    public final ObservableSource<? extends Open> bufferOpen;
    public final Callable<U> bufferSupplier;

    /* loaded from: classes4.dex */
    public static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8466418554264089604L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super C> actual;
        public final Function<? super Open, ? extends ObservableSource<? extends Close>> bufferClose;
        public final ObservableSource<? extends Open> bufferOpen;
        public final Callable<C> bufferSupplier;
        public Map<Long, C> buffers;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final AtomicThrowable errors;
        public long index;
        public final CompositeDisposable observers;
        public final SpscLinkedArrayQueue<C> queue;
        public final AtomicReference<Disposable> upstream;

        /* loaded from: classes4.dex */
        public static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -8498650778633225126L;
            public transient /* synthetic */ FieldHolder $fh;
            public final BufferBoundaryObserver<?, ?, Open, ?> parent;

            public BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bufferBoundaryObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.parent = bufferBoundaryObserver;
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == DisposableHelper.DISPOSED : invokeV.booleanValue;
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    lazySet(DisposableHelper.DISPOSED);
                    this.parent.openComplete(this);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    lazySet(DisposableHelper.DISPOSED);
                    this.parent.boundaryError(this, th);
                }
            }

            @Override // io.reactivex.Observer
            public void onNext(Open open) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, open) == null) {
                    this.parent.open(open);
                }
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }
        }

        public BufferBoundaryObserver(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<C> callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, observableSource, function, callable};
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
            this.bufferSupplier = callable;
            this.bufferOpen = observableSource;
            this.bufferClose = function;
            this.queue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            this.observers = new CompositeDisposable();
            this.upstream = new AtomicReference<>();
            this.buffers = new LinkedHashMap();
            this.errors = new AtomicThrowable();
        }

        public void boundaryError(Disposable disposable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, disposable, th) == null) {
                DisposableHelper.dispose(this.upstream);
                this.observers.delete(disposable);
                onError(th);
            }
        }

        public void close(BufferCloseObserver<T, C> bufferCloseObserver, long j2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bufferCloseObserver, j2) == null) {
                this.observers.delete(bufferCloseObserver);
                if (this.observers.size() == 0) {
                    DisposableHelper.dispose(this.upstream);
                    z = true;
                } else {
                    z = false;
                }
                synchronized (this) {
                    if (this.buffers == null) {
                        return;
                    }
                    this.queue.offer(this.buffers.remove(Long.valueOf(j2)));
                    if (z) {
                        this.done = true;
                    }
                    drain();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && DisposableHelper.dispose(this.upstream)) {
                this.cancelled = true;
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getAndIncrement() == 0) {
                Observer<? super C> observer = this.actual;
                SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.queue;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (z && this.errors.get() != null) {
                        spscLinkedArrayQueue.clear();
                        observer.onError(this.errors.terminate());
                        return;
                    }
                    C poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        observer.onComplete();
                        return;
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(poll);
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? DisposableHelper.isDisposed(this.upstream.get()) : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.observers.dispose();
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    for (C c2 : map.values()) {
                        this.queue.offer(c2);
                    }
                    this.buffers = null;
                    this.done = true;
                    drain();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    this.observers.dispose();
                    synchronized (this) {
                        this.buffers = null;
                    }
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
            if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    for (C c2 : map.values()) {
                        c2.add(t);
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) && DisposableHelper.setOnce(this.upstream, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.observers.add(bufferOpenObserver);
                this.bufferOpen.subscribe(bufferOpenObserver);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.util.Map<java.lang.Long, C extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void open(Open open) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, open) == null) {
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.bufferClose.apply(open), "The bufferClose returned a null ObservableSource");
                    long j2 = this.index;
                    this.index = 1 + j2;
                    synchronized (this) {
                        Map<Long, C> map = this.buffers;
                        if (map == 0) {
                            return;
                        }
                        map.put(Long.valueOf(j2), collection);
                        BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j2);
                        this.observers.add(bufferCloseObserver);
                        observableSource.subscribe(bufferCloseObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    DisposableHelper.dispose(this.upstream);
                    onError(th);
                }
            }
        }

        public void openComplete(BufferOpenObserver<Open> bufferOpenObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bufferOpenObserver) == null) {
                this.observers.delete(bufferOpenObserver);
                if (this.observers.size() == 0) {
                    DisposableHelper.dispose(this.upstream);
                    this.done = true;
                    drain();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8498650778633225126L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long index;
        public final BufferBoundaryObserver<T, C, ?, ?> parent;

        public BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bufferBoundaryObserver, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = bufferBoundaryObserver;
            this.index = j2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == DisposableHelper.DISPOSED : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Disposable disposable = get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable != disposableHelper) {
                    lazySet(disposableHelper);
                    this.parent.close(this, this.index);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                Disposable disposable = get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable != disposableHelper) {
                    lazySet(disposableHelper);
                    this.parent.boundaryError(this, th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Disposable disposable;
            DisposableHelper disposableHelper;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, obj) == null) || (disposable = get()) == (disposableHelper = DisposableHelper.DISPOSED)) {
                return;
            }
            lazySet(disposableHelper);
            disposable.dispose();
            this.parent.close(this, this.index);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<U> callable) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, observableSource2, function, callable};
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
        this.bufferOpen = observableSource2;
        this.bufferClose = function;
        this.bufferSupplier = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.bufferOpen, this.bufferClose, this.bufferSupplier);
            observer.onSubscribe(bufferBoundaryObserver);
            this.source.subscribe(bufferBoundaryObserver);
        }
    }
}
