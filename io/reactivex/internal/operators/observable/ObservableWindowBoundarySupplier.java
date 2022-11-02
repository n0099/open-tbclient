package io.reactivex.internal.operators.observable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacityHint;
    public final Callable<? extends ObservableSource<B>> other;

    /* loaded from: classes8.dex */
    public static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean done;
        public final WindowBoundaryMainObserver<T, B> parent;

        public WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowBoundaryMainObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b) != null) || this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.parent.innerNext(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete();
        }
    }

    /* loaded from: classes8.dex */
    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final WindowBoundaryInnerObserver<Object, Object> BOUNDARY_DISPOSED;
        public static final Object NEXT_WINDOW;
        public static final long serialVersionUID = 2233020065421370272L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference<WindowBoundaryInnerObserver<T, B>> boundaryObserver;
        public final int capacityHint;
        public volatile boolean done;
        public final Observer<? super Observable<T>> downstream;
        public final AtomicThrowable errors;
        public final Callable<? extends ObservableSource<B>> other;
        public final MpscLinkedQueue<Object> queue;
        public final AtomicBoolean stopWindows;
        public Disposable upstream;
        public UnicastSubject<T> window;
        public final AtomicInteger windows;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1814445342, "Lio/reactivex/internal/operators/observable/ObservableWindowBoundarySupplier$WindowBoundaryMainObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1814445342, "Lio/reactivex/internal/operators/observable/ObservableWindowBoundarySupplier$WindowBoundaryMainObserver;");
                    return;
                }
            }
            BOUNDARY_DISPOSED = new WindowBoundaryInnerObserver<>(null);
            NEXT_WINDOW = new Object();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.stopWindows.compareAndSet(false, true)) {
                disposeBoundary();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$WindowBoundaryInnerObserver<T, B>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void disposeBoundary() {
            Disposable disposable;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (disposable = (Disposable) this.boundaryObserver.getAndSet(BOUNDARY_DISPOSED)) != null && disposable != BOUNDARY_DISPOSED) {
                disposable.dispose();
            }
        }

        public void innerComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.upstream.dispose();
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.stopWindows.get();
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                disposeBoundary();
                this.done = true;
                drain();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        public WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i, Callable<? extends ObservableSource<B>> callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Integer.valueOf(i), callable};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.downstream = observer;
            this.capacityHint = i;
            this.boundaryObserver = new AtomicReference<>();
            this.windows = new AtomicInteger(1);
            this.queue = new MpscLinkedQueue<>();
            this.errors = new AtomicThrowable();
            this.stopWindows = new AtomicBoolean();
            this.other = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: io.reactivex.subjects.UnicastSubject<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void drain() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Observer<? super Observable<T>> observer = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int i = 1;
            while (this.windows.get() != 0) {
                UnicastSubject<T> unicastSubject = this.window;
                boolean z2 = this.done;
                if (z2 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable terminate = atomicThrowable.terminate();
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(terminate);
                    }
                    observer.onError(terminate);
                    return;
                }
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    Throwable terminate2 = atomicThrowable.terminate();
                    if (terminate2 == null) {
                        if (unicastSubject != 0) {
                            this.window = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(terminate2);
                    }
                    observer.onError(terminate2);
                    return;
                } else if (z) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll != NEXT_WINDOW) {
                    unicastSubject.onNext(poll);
                } else {
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        UnicastSubject<T> create = UnicastSubject.create(this.capacityHint, this);
                        this.window = create;
                        this.windows.getAndIncrement();
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.other.call(), "The other Callable returned a null ObservableSource");
                            WindowBoundaryInnerObserver<T, B> windowBoundaryInnerObserver = new WindowBoundaryInnerObserver<>(this);
                            if (this.boundaryObserver.compareAndSet(null, windowBoundaryInnerObserver)) {
                                observableSource.subscribe(windowBoundaryInnerObserver);
                                observer.onNext(create);
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            atomicThrowable.addThrowable(th);
                            this.done = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                this.upstream.dispose();
                if (this.errors.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void innerNext(WindowBoundaryInnerObserver<T, B> windowBoundaryInnerObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, windowBoundaryInnerObserver) == null) {
                this.boundaryObserver.compareAndSet(windowBoundaryInnerObserver, null);
                this.queue.offer(NEXT_WINDOW);
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
                disposeBoundary();
                if (this.errors.addThrowable(th)) {
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
            if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
                this.queue.offer(t);
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, disposable) == null) && DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                this.queue.offer(NEXT_WINDOW);
                drain();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int i) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, callable, Integer.valueOf(i)};
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
        this.other = callable;
        this.capacityHint = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            this.source.subscribe(new WindowBoundaryMainObserver(observer, this.capacityHint, this.other));
        }
    }
}
