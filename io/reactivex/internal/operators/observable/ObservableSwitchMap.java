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
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class ObservableSwitchMap extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final boolean delayErrors;
    public final Function mapper;

    /* loaded from: classes8.dex */
    public final class SwitchMapInnerObserver extends AtomicReference implements Observer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3837284832786408377L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public volatile boolean done;
        public final long index;
        public final SwitchMapObserver parent;
        public volatile SimpleQueue queue;

        public SwitchMapInnerObserver(SwitchMapObserver switchMapObserver, long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {switchMapObserver, Long.valueOf(j), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = switchMapObserver;
            this.index = j;
            this.bufferSize = i;
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.parent.innerError(this, th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && this.index == this.parent.unique) {
                if (obj != null) {
                    this.queue.offer(obj);
                }
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) && DisposableHelper.setOnce(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.queue = queueDisposable;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.queue = queueDisposable;
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class SwitchMapObserver extends AtomicInteger implements Observer, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final SwitchMapInnerObserver CANCELLED;
        public static final long serialVersionUID = -3491074160481096299L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference active;
        public final Observer actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final AtomicThrowable errors;
        public final Function mapper;
        public Disposable s;
        public volatile long unique;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(4412451, "Lio/reactivex/internal/operators/observable/ObservableSwitchMap$SwitchMapObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(4412451, "Lio/reactivex/internal/operators/observable/ObservableSwitchMap$SwitchMapObserver;");
                    return;
                }
            }
            SwitchMapInnerObserver switchMapInnerObserver = new SwitchMapInnerObserver(null, -1L, 1);
            CANCELLED = switchMapInnerObserver;
            switchMapInnerObserver.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.s.dispose();
                disposeInner();
            }
        }

        public void disposeInner() {
            SwitchMapInnerObserver switchMapInnerObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) this.active.get();
                SwitchMapInnerObserver switchMapInnerObserver3 = CANCELLED;
                if (switchMapInnerObserver2 != switchMapInnerObserver3 && (switchMapInnerObserver = (SwitchMapInnerObserver) this.active.getAndSet(switchMapInnerObserver3)) != CANCELLED && switchMapInnerObserver != null) {
                    switchMapInnerObserver.cancel();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.cancelled;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.done) {
                this.done = true;
                drain();
            }
        }

        public SwitchMapObserver(Observer observer, Function function, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.active = new AtomicReference();
            this.actual = observer;
            this.mapper = function;
            this.bufferSize = i;
            this.delayErrors = z;
            this.errors = new AtomicThrowable();
        }

        /* JADX WARN: Removed duplicated region for block: B:106:0x0013 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x00ed A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            SimpleQueue simpleQueue;
            Object obj;
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Observer observer = this.actual;
            AtomicReference atomicReference = this.active;
            boolean z3 = this.delayErrors;
            int i = 1;
            while (!this.cancelled) {
                if (this.done) {
                    if (atomicReference.get() == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z3) {
                        if (z2) {
                            Throwable th = (Throwable) this.errors.get();
                            if (th != null) {
                                observer.onError(th);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    } else if (((Throwable) this.errors.get()) != null) {
                        observer.onError(this.errors.terminate());
                        return;
                    } else if (z2) {
                        observer.onComplete();
                        return;
                    }
                }
                SwitchMapInnerObserver switchMapInnerObserver = (SwitchMapInnerObserver) atomicReference.get();
                if (switchMapInnerObserver != null && (simpleQueue = switchMapInnerObserver.queue) != null) {
                    if (switchMapInnerObserver.done) {
                        boolean isEmpty = simpleQueue.isEmpty();
                        if (z3) {
                            if (isEmpty) {
                                atomicReference.compareAndSet(switchMapInnerObserver, null);
                            }
                        } else if (((Throwable) this.errors.get()) != null) {
                            observer.onError(this.errors.terminate());
                            return;
                        } else if (isEmpty) {
                            atomicReference.compareAndSet(switchMapInnerObserver, null);
                        }
                    }
                    boolean z4 = false;
                    while (!this.cancelled) {
                        if (switchMapInnerObserver == atomicReference.get()) {
                            if (!z3 && ((Throwable) this.errors.get()) != null) {
                                observer.onError(this.errors.terminate());
                                return;
                            }
                            boolean z5 = switchMapInnerObserver.done;
                            try {
                                obj = simpleQueue.poll();
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.errors.addThrowable(th2);
                                atomicReference.compareAndSet(switchMapInnerObserver, null);
                                if (!z3) {
                                    disposeInner();
                                    this.s.dispose();
                                    this.done = true;
                                } else {
                                    switchMapInnerObserver.cancel();
                                }
                                obj = null;
                                z4 = true;
                            }
                            if (obj == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z5 && z) {
                                atomicReference.compareAndSet(switchMapInnerObserver, null);
                            } else if (z) {
                                if (!z4) {
                                    continue;
                                }
                            } else {
                                observer.onNext(obj);
                            }
                        }
                        z4 = true;
                        if (!z4) {
                        }
                    }
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        public void innerError(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, switchMapInnerObserver, th) == null) {
                if (switchMapInnerObserver.index == this.unique && this.errors.addThrowable(th)) {
                    if (!this.delayErrors) {
                        this.s.dispose();
                    }
                    switchMapInnerObserver.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
                if (!this.done && this.errors.addThrowable(th)) {
                    if (!this.delayErrors) {
                        disposeInner();
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
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            SwitchMapInnerObserver switchMapInnerObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
                long j = this.unique + 1;
                this.unique = j;
                SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) this.active.get();
                if (switchMapInnerObserver2 != null) {
                    switchMapInnerObserver2.cancel();
                }
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The ObservableSource returned is null");
                    SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j, this.bufferSize);
                    do {
                        switchMapInnerObserver = (SwitchMapInnerObserver) this.active.get();
                        if (switchMapInnerObserver == CANCELLED) {
                            return;
                        }
                    } while (!this.active.compareAndSet(switchMapInnerObserver, switchMapInnerObserver3));
                    observableSource.subscribe(switchMapInnerObserver3);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.s.dispose();
                    onError(th);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableSwitchMap(ObservableSource observableSource, Function function, int i, boolean z) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, function, Integer.valueOf(i), Boolean.valueOf(z)};
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
        this.bufferSize = i;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, observer) != null) || ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.mapper)) {
            return;
        }
        this.source.subscribe(new SwitchMapObserver(observer, this.mapper, this.bufferSize, this.delayErrors));
    }
}
