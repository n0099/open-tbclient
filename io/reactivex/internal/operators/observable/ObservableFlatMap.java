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
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class ObservableFlatMap extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final boolean delayErrors;
    public final Function mapper;
    public final int maxConcurrency;

    /* loaded from: classes8.dex */
    public final class InnerObserver extends AtomicReference implements Observer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4606175640614850599L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public int fusionMode;
        public final long id;
        public final MergeObserver parent;
        public volatile SimpleQueue queue;

        public InnerObserver(MergeObserver mergeObserver, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mergeObserver, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = j;
            this.parent = mergeObserver;
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
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.parent.errors.addThrowable(th)) {
                    MergeObserver mergeObserver = this.parent;
                    if (!mergeObserver.delayErrors) {
                        mergeObserver.disposeAll();
                    }
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                if (this.fusionMode == 0) {
                    this.parent.tryEmit(obj, this);
                } else {
                    this.parent.drain();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) && DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                    this.done = true;
                    this.parent.drain();
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class MergeObserver extends AtomicInteger implements Disposable, Observer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final InnerObserver[] CANCELLED;
        public static final InnerObserver[] EMPTY;
        public static final long serialVersionUID = -2117620485640801370L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final AtomicThrowable errors;
        public long lastId;
        public int lastIndex;
        public final Function mapper;
        public final int maxConcurrency;
        public final AtomicReference observers;
        public volatile SimplePlainQueue queue;
        public Disposable s;
        public Queue sources;
        public long uniqueId;
        public int wip;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865368584, "Lio/reactivex/internal/operators/observable/ObservableFlatMap$MergeObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-865368584, "Lio/reactivex/internal/operators/observable/ObservableFlatMap$MergeObserver;");
                    return;
                }
            }
            EMPTY = new InnerObserver[0];
            CANCELLED = new InnerObserver[0];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Throwable terminate;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.cancelled) {
                this.cancelled = true;
                if (disposeAll() && (terminate = this.errors.terminate()) != null && terminate != ExceptionHelper.TERMINATED) {
                    RxJavaPlugins.onError(terminate);
                }
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getAndIncrement() == 0) {
                drainLoop();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.cancelled;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        public MergeObserver(Observer observer, Function function, boolean z, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.errors = new AtomicThrowable();
            this.actual = observer;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            if (i != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i);
            }
            this.observers = new AtomicReference(EMPTY);
        }

        public boolean addInner(InnerObserver innerObserver) {
            InnerObserver[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, innerObserver)) == null) {
                do {
                    innerObserverArr = (InnerObserver[]) this.observers.get();
                    if (innerObserverArr == CANCELLED) {
                        innerObserver.dispose();
                        return false;
                    }
                    int length = innerObserverArr.length;
                    innerObserverArr2 = new InnerObserver[length + 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                    innerObserverArr2[length] = innerObserver;
                } while (!this.observers.compareAndSet(innerObserverArr, innerObserverArr2));
                return true;
            }
            return invokeL.booleanValue;
        }

        public boolean checkTerminate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.cancelled) {
                    return true;
                }
                Throwable th = (Throwable) this.errors.get();
                if (!this.delayErrors && th != null) {
                    disposeAll();
                    Throwable terminate = this.errors.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        this.actual.onError(terminate);
                    }
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean disposeAll() {
            InterceptResult invokeV;
            InnerObserver[] innerObserverArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.s.dispose();
                InnerObserver[] innerObserverArr2 = (InnerObserver[]) this.observers.get();
                InnerObserver[] innerObserverArr3 = CANCELLED;
                if (innerObserverArr2 == innerObserverArr3 || (innerObserverArr = (InnerObserver[]) this.observers.getAndSet(innerObserverArr3)) == CANCELLED) {
                    return false;
                }
                for (InnerObserver innerObserver : innerObserverArr) {
                    innerObserver.dispose();
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:71:0x00b9, code lost:
            if (r12 != null) goto L55;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                Observer observer = this.actual;
                int i2 = 1;
                while (!checkTerminate()) {
                    SimplePlainQueue simplePlainQueue = this.queue;
                    if (simplePlainQueue != null) {
                        while (!checkTerminate()) {
                            Object poll = simplePlainQueue.poll();
                            if (poll == null) {
                                if (poll == null) {
                                }
                            } else {
                                observer.onNext(poll);
                            }
                        }
                        return;
                    }
                    boolean z = this.done;
                    SimplePlainQueue simplePlainQueue2 = this.queue;
                    InnerObserver[] innerObserverArr = (InnerObserver[]) this.observers.get();
                    int length = innerObserverArr.length;
                    boolean z2 = false;
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i = this.sources.size();
                        }
                    } else {
                        i = 0;
                    }
                    if (z && ((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i == 0)) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != ExceptionHelper.TERMINATED) {
                            if (terminate == null) {
                                observer.onComplete();
                                return;
                            } else {
                                observer.onError(terminate);
                                return;
                            }
                        }
                        return;
                    }
                    if (length != 0) {
                        long j = this.lastId;
                        int i3 = this.lastIndex;
                        if (length <= i3 || innerObserverArr[i3].id != j) {
                            if (length <= i3) {
                                i3 = 0;
                            }
                            for (int i4 = 0; i4 < length && innerObserverArr[i3].id != j; i4++) {
                                i3++;
                                if (i3 == length) {
                                    i3 = 0;
                                }
                            }
                            this.lastIndex = i3;
                            this.lastId = innerObserverArr[i3].id;
                        }
                        int i5 = 0;
                        boolean z3 = false;
                        while (i5 < length) {
                            if (checkTerminate()) {
                                return;
                            }
                            InnerObserver innerObserver = innerObserverArr[i3];
                            while (!checkTerminate()) {
                                SimpleQueue simpleQueue = innerObserver.queue;
                                if (simpleQueue != null) {
                                    while (true) {
                                        try {
                                            Object poll2 = simpleQueue.poll();
                                            if (poll2 == null) {
                                                break;
                                            }
                                            observer.onNext(poll2);
                                            if (checkTerminate()) {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            innerObserver.dispose();
                                            this.errors.addThrowable(th);
                                            if (checkTerminate()) {
                                                return;
                                            }
                                            removeInner(innerObserver);
                                            i5++;
                                            z3 = true;
                                        }
                                    }
                                }
                                boolean z4 = innerObserver.done;
                                SimpleQueue simpleQueue2 = innerObserver.queue;
                                if (z4 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                    removeInner(innerObserver);
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    z3 = true;
                                }
                                i3++;
                                if (i3 == length) {
                                    i3 = 0;
                                }
                                i5++;
                            }
                            return;
                        }
                        this.lastIndex = i3;
                        this.lastId = innerObserverArr[i3].id;
                        z2 = z3;
                    }
                    if (z2) {
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            synchronized (this) {
                                ObservableSource observableSource = (ObservableSource) this.sources.poll();
                                if (observableSource == null) {
                                    this.wip--;
                                } else {
                                    subscribeInner(observableSource);
                                }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                } else if (this.errors.addThrowable(th)) {
                    this.done = true;
                    drain();
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048585, this, obj) != null) || this.done) {
                return;
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null ObservableSource");
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        if (this.wip == this.maxConcurrency) {
                            this.sources.offer(observableSource);
                            return;
                        }
                        this.wip++;
                    }
                }
                subscribeInner(observableSource);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.s.dispose();
                onError(th);
            }
        }

        public void removeInner(InnerObserver innerObserver) {
            InnerObserver[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, innerObserver) == null) {
                do {
                    innerObserverArr = (InnerObserver[]) this.observers.get();
                    int length = innerObserverArr.length;
                    if (length == 0) {
                        return;
                    }
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerObserverArr[i2] == innerObserver) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i < 0) {
                        return;
                    }
                    if (length == 1) {
                        innerObserverArr2 = EMPTY;
                    } else {
                        InnerObserver[] innerObserverArr3 = new InnerObserver[length - 1];
                        System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i);
                        System.arraycopy(innerObserverArr, i + 1, innerObserverArr3, i, (length - i) - 1);
                        innerObserverArr2 = innerObserverArr3;
                    }
                } while (!this.observers.compareAndSet(innerObserverArr, innerObserverArr2));
            }
        }

        public void subscribeInner(ObservableSource observableSource) {
            ObservableSource observableSource2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, observableSource) == null) {
                while (observableSource instanceof Callable) {
                    if (tryEmitScalar((Callable) observableSource) && this.maxConcurrency != Integer.MAX_VALUE) {
                        boolean z = false;
                        synchronized (this) {
                            observableSource2 = (ObservableSource) this.sources.poll();
                            if (observableSource2 == null) {
                                this.wip--;
                                z = true;
                            }
                        }
                        if (z) {
                            drain();
                            return;
                        }
                        observableSource = observableSource2;
                    } else {
                        return;
                    }
                }
                long j = this.uniqueId;
                this.uniqueId = 1 + j;
                InnerObserver innerObserver = new InnerObserver(this, j);
                if (addInner(innerObserver)) {
                    observableSource.subscribe(innerObserver);
                }
            }
        }

        public void tryEmit(Object obj, InnerObserver innerObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, obj, innerObserver) == null) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.actual.onNext(obj);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    SimpleQueue simpleQueue = innerObserver.queue;
                    if (simpleQueue == null) {
                        simpleQueue = new SpscLinkedArrayQueue(this.bufferSize);
                        innerObserver.queue = simpleQueue;
                    }
                    simpleQueue.offer(obj);
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        public boolean tryEmitScalar(Callable callable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, callable)) == null) {
                try {
                    Object call = callable.call();
                    if (call == null) {
                        return true;
                    }
                    if (get() == 0 && compareAndSet(0, 1)) {
                        this.actual.onNext(call);
                        if (decrementAndGet() == 0) {
                            return true;
                        }
                    } else {
                        SimplePlainQueue simplePlainQueue = this.queue;
                        if (simplePlainQueue == null) {
                            if (this.maxConcurrency == Integer.MAX_VALUE) {
                                simplePlainQueue = new SpscLinkedArrayQueue(this.bufferSize);
                            } else {
                                simplePlainQueue = new SpscArrayQueue(this.maxConcurrency);
                            }
                            this.queue = simplePlainQueue;
                        }
                        if (!simplePlainQueue.offer(call)) {
                            onError(new IllegalStateException("Scalar queue full?!"));
                            return true;
                        } else if (getAndIncrement() != 0) {
                            return false;
                        }
                    }
                    drainLoop();
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.errors.addThrowable(th);
                    drain();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableFlatMap(ObservableSource observableSource, Function function, boolean z, int i, int i2) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, function, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)};
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
        this.delayErrors = z;
        this.maxConcurrency = i;
        this.bufferSize = i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, observer) != null) || ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.mapper)) {
            return;
        }
        this.source.subscribe(new MergeObserver(observer, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }
}
