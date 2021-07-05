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
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacityHint;
    public final ObservableSource<B> other;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete();
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
        public void onNext(B b2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2) == null) || this.done) {
                return;
            }
            this.parent.innerNext();
        }
    }

    /* loaded from: classes10.dex */
    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Object NEXT_WINDOW;
        public static final long serialVersionUID = 2233020065421370272L;
        public transient /* synthetic */ FieldHolder $fh;
        public final WindowBoundaryInnerObserver<T, B> boundaryObserver;
        public final int capacityHint;
        public volatile boolean done;
        public final Observer<? super Observable<T>> downstream;
        public final AtomicThrowable errors;
        public final MpscLinkedQueue<Object> queue;
        public final AtomicBoolean stopWindows;
        public final AtomicReference<Disposable> upstream;
        public UnicastSubject<T> window;
        public final AtomicInteger windows;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1428331826, "Lio/reactivex/internal/operators/observable/ObservableWindowBoundary$WindowBoundaryMainObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1428331826, "Lio/reactivex/internal/operators/observable/ObservableWindowBoundary$WindowBoundaryMainObserver;");
                    return;
                }
            }
            NEXT_WINDOW = new Object();
        }

        public WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.downstream = observer;
            this.capacityHint = i2;
            this.boundaryObserver = new WindowBoundaryInnerObserver<>(this);
            this.upstream = new AtomicReference<>();
            this.windows = new AtomicInteger(1);
            this.queue = new MpscLinkedQueue<>();
            this.errors = new AtomicThrowable();
            this.stopWindows = new AtomicBoolean();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.stopWindows.compareAndSet(false, true)) {
                this.boundaryObserver.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.upstream);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: io.reactivex.subjects.UnicastSubject<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.downstream;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                int i2 = 1;
                while (this.windows.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.window;
                    boolean z = this.done;
                    if (z && atomicThrowable.get() != null) {
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
                    boolean z2 = poll == null;
                    if (z && z2) {
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
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
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
                            observer.onNext(create);
                        }
                    }
                }
                mpscLinkedQueue.clear();
                this.window = null;
            }
        }

        public void innerComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                DisposableHelper.dispose(this.upstream);
                this.done = true;
                drain();
            }
        }

        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                DisposableHelper.dispose(this.upstream);
                if (this.errors.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void innerNext() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.queue.offer(NEXT_WINDOW);
                drain();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.stopWindows.get() : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.boundaryObserver.dispose();
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
                this.boundaryObserver.dispose();
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
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
                this.queue.offer(t);
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, disposable) == null) && DisposableHelper.setOnce(this.upstream, disposable)) {
                innerNext();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i2) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, observableSource2, Integer.valueOf(i2)};
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
        this.other = observableSource2;
        this.capacityHint = i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.capacityHint);
            observer.onSubscribe(windowBoundaryMainObserver);
            this.other.subscribe(windowBoundaryMainObserver.boundaryObserver);
            this.source.subscribe(windowBoundaryMainObserver);
        }
    }
}
