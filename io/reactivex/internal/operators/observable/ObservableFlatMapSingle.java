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
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
/* loaded from: classes8.dex */
public final class ObservableFlatMapSingle extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayErrors;
    public final Function mapper;

    /* loaded from: classes8.dex */
    public final class FlatMapSingleObserver extends AtomicInteger implements Observer, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8600231336733376951L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger active;
        public final Observer actual;
        public volatile boolean cancelled;
        public Disposable d;
        public final boolean delayErrors;
        public final AtomicThrowable errors;
        public final Function mapper;
        public final AtomicReference queue;
        public final CompositeDisposable set;

        /* loaded from: classes8.dex */
        public final class InnerObserver extends AtomicReference implements SingleObserver, Disposable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -502562646270949838L;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlatMapSingleObserver this$0;

            public InnerObserver(FlatMapSingleObserver flatMapSingleObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {flatMapSingleObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = flatMapSingleObserver;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.this$0.innerError(this, th);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                    this.this$0.innerSuccess(this, obj);
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
                    return DisposableHelper.isDisposed((Disposable) get());
                }
                return invokeV.booleanValue;
            }
        }

        public FlatMapSingleObserver(Observer observer, Function function, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, Boolean.valueOf(z)};
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
            this.mapper = function;
            this.delayErrors = z;
            this.set = new CompositeDisposable();
            this.errors = new AtomicThrowable();
            this.active = new AtomicInteger(1);
            this.queue = new AtomicReference();
        }

        public void clear() {
            SpscLinkedArrayQueue spscLinkedArrayQueue;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.queue.get()) != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.cancelled = true;
                this.d.dispose();
                this.set.dispose();
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public SpscLinkedArrayQueue getOrCreateQueue() {
            SpscLinkedArrayQueue spscLinkedArrayQueue;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                do {
                    SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) this.queue.get();
                    if (spscLinkedArrayQueue2 != null) {
                        return spscLinkedArrayQueue2;
                    }
                    spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                } while (!this.queue.compareAndSet(null, spscLinkedArrayQueue));
                return spscLinkedArrayQueue;
            }
            return (SpscLinkedArrayQueue) invokeV.objValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.cancelled;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.active.decrementAndGet();
                drain();
            }
        }

        public void drainLoop() {
            boolean z;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Observer observer = this.actual;
                AtomicInteger atomicInteger = this.active;
                AtomicReference atomicReference = this.queue;
                int i = 1;
                while (!this.cancelled) {
                    if (!this.delayErrors && ((Throwable) this.errors.get()) != null) {
                        Throwable terminate = this.errors.terminate();
                        clear();
                        observer.onError(terminate);
                        return;
                    }
                    boolean z2 = false;
                    if (atomicInteger.get() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                    if (spscLinkedArrayQueue != null) {
                        obj = spscLinkedArrayQueue.poll();
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        z2 = true;
                    }
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
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(obj);
                    }
                }
                clear();
            }
        }

        public void innerError(InnerObserver innerObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, innerObserver, th) == null) {
                this.set.delete(innerObserver);
                if (this.errors.addThrowable(th)) {
                    if (!this.delayErrors) {
                        this.d.dispose();
                        this.set.dispose();
                    }
                    this.active.decrementAndGet();
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void innerSuccess(InnerObserver innerObserver, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, innerObserver, obj) == null) {
                this.set.delete(innerObserver);
                if (get() == 0) {
                    boolean z = false;
                    if (compareAndSet(0, 1)) {
                        this.actual.onNext(obj);
                        if (this.active.decrementAndGet() == 0) {
                            z = true;
                        }
                        SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.queue.get();
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
                SpscLinkedArrayQueue orCreateQueue = getOrCreateQueue();
                synchronized (orCreateQueue) {
                    orCreateQueue.offer(obj);
                }
                this.active.decrementAndGet();
                if (getAndIncrement() != 0) {
                    return;
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, th) == null) {
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
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, disposable) == null) && DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, obj) == null) {
                try {
                    SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(obj), "The mapper returned a null SingleSource");
                    this.active.getAndIncrement();
                    InnerObserver innerObserver = new InnerObserver(this);
                    if (!this.cancelled && this.set.add(innerObserver)) {
                        singleSource.subscribe(innerObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.d.dispose();
                    onError(th);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableFlatMapSingle(ObservableSource observableSource, Function function, boolean z) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, function, Boolean.valueOf(z)};
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
        this.mapper = function;
        this.delayErrors = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            this.source.subscribe(new FlatMapSingleObserver(observer, this.mapper, this.delayErrors));
        }
    }
}
