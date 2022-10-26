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
/* loaded from: classes8.dex */
public final class ObservableBufferBoundary extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function bufferClose;
    public final ObservableSource bufferOpen;
    public final Callable bufferSupplier;

    /* loaded from: classes8.dex */
    public final class BufferBoundaryObserver extends AtomicInteger implements Observer, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8466418554264089604L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer actual;
        public final Function bufferClose;
        public final ObservableSource bufferOpen;
        public final Callable bufferSupplier;
        public Map buffers;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final AtomicThrowable errors;
        public long index;
        public final CompositeDisposable observers;
        public final SpscLinkedArrayQueue queue;
        public final AtomicReference upstream;

        /* loaded from: classes8.dex */
        public final class BufferOpenObserver extends AtomicReference implements Observer, Disposable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -8498650778633225126L;
            public transient /* synthetic */ FieldHolder $fh;
            public final BufferBoundaryObserver parent;

            public BufferOpenObserver(BufferBoundaryObserver bufferBoundaryObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bufferBoundaryObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.parent = bufferBoundaryObserver;
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
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                    this.parent.open(obj);
                }
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
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
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (get() == DisposableHelper.DISPOSED) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    lazySet(DisposableHelper.DISPOSED);
                    this.parent.openComplete(this);
                }
            }
        }

        public BufferBoundaryObserver(Observer observer, ObservableSource observableSource, Function function, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, observableSource, function, callable};
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
            this.bufferSupplier = callable;
            this.bufferOpen = observableSource;
            this.bufferClose = function;
            this.queue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.observers = new CompositeDisposable();
            this.upstream = new AtomicReference();
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

        public void close(BufferCloseObserver bufferCloseObserver, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bufferCloseObserver, j) == null) {
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
                    this.queue.offer(this.buffers.remove(Long.valueOf(j)));
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

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.observers.dispose();
                synchronized (this) {
                    Map map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    for (Collection collection : map.values()) {
                        this.queue.offer(collection);
                    }
                    this.buffers = null;
                    this.done = true;
                    drain();
                }
            }
        }

        public void drain() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Observer observer = this.actual;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
            int i = 1;
            while (!this.cancelled) {
                boolean z2 = this.done;
                if (z2 && this.errors.get() != null) {
                    spscLinkedArrayQueue.clear();
                    observer.onError(this.errors.terminate());
                    return;
                }
                Collection collection = (Collection) spscLinkedArrayQueue.poll();
                if (collection == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    observer.onComplete();
                    return;
                } else if (z) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    observer.onNext(collection);
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return DisposableHelper.isDisposed((Disposable) this.upstream.get());
            }
            return invokeV.booleanValue;
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
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) && DisposableHelper.setOnce(this.upstream, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.observers.add(bufferOpenObserver);
                this.bufferOpen.subscribe(bufferOpenObserver);
            }
        }

        public void openComplete(BufferOpenObserver bufferOpenObserver) {
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

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
                synchronized (this) {
                    Map map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    for (Collection collection : map.values()) {
                        collection.add(obj);
                    }
                }
            }
        }

        public void open(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.bufferClose.apply(obj), "The bufferClose returned a null ObservableSource");
                    long j = this.index;
                    this.index = 1 + j;
                    synchronized (this) {
                        Map map = this.buffers;
                        if (map == null) {
                            return;
                        }
                        map.put(Long.valueOf(j), collection);
                        BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j);
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
    }

    /* loaded from: classes8.dex */
    public final class BufferCloseObserver extends AtomicReference implements Observer, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8498650778633225126L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long index;
        public final BufferBoundaryObserver parent;

        public BufferCloseObserver(BufferBoundaryObserver bufferBoundaryObserver, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bufferBoundaryObserver, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = bufferBoundaryObserver;
            this.index = j;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (get() == DisposableHelper.DISPOSED) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Object obj = get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (obj != disposableHelper) {
                    lazySet(disposableHelper);
                    this.parent.close(this, this.index);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                Object obj = get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (obj != disposableHelper) {
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
            if ((interceptable == null || interceptable.invokeL(1048580, this, obj) == null) && (disposable = (Disposable) get()) != (disposableHelper = DisposableHelper.DISPOSED)) {
                lazySet(disposableHelper);
                disposable.dispose();
                this.parent.close(this, this.index);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableBufferBoundary(ObservableSource observableSource, ObservableSource observableSource2, Function function, Callable callable) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, observableSource2, function, callable};
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
        this.bufferOpen = observableSource2;
        this.bufferClose = function;
        this.bufferSupplier = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.bufferOpen, this.bufferClose, this.bufferSupplier);
            observer.onSubscribe(bufferBoundaryObserver);
            this.source.subscribe(bufferBoundaryObserver);
        }
    }
}
