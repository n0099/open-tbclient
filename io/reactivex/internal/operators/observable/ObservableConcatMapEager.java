package io.reactivex.internal.operators.observable;

import androidx.core.view.InputDeviceCompat;
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
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class ObservableConcatMapEager extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ErrorMode errorMode;
    public final Function mapper;
    public final int maxConcurrency;
    public final int prefetch;

    /* loaded from: classes8.dex */
    public final class ConcatMapEagerMainObserver extends AtomicInteger implements Observer, Disposable, InnerQueuedObserverSupport {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8080567949447303262L;
        public transient /* synthetic */ FieldHolder $fh;
        public int activeCount;
        public final Observer actual;
        public volatile boolean cancelled;
        public InnerQueuedObserver current;
        public Disposable d;
        public volatile boolean done;
        public final AtomicThrowable error;
        public final ErrorMode errorMode;
        public final Function mapper;
        public final int maxConcurrency;
        public final ArrayDeque observers;
        public final int prefetch;
        public SimpleQueue queue;
        public int sourceMode;

        public ConcatMapEagerMainObserver(Observer observer, Function function, int i, int i2, ErrorMode errorMode) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, Integer.valueOf(i), Integer.valueOf(i2), errorMode};
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
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode;
            this.error = new AtomicThrowable();
            this.observers = new ArrayDeque();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                    disposeAll();
                }
            }
        }

        public void disposeAll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                InnerQueuedObserver innerQueuedObserver = this.current;
                if (innerQueuedObserver != null) {
                    innerQueuedObserver.dispose();
                }
                while (true) {
                    InnerQueuedObserver innerQueuedObserver2 = (InnerQueuedObserver) this.observers.poll();
                    if (innerQueuedObserver2 == null) {
                        return;
                    }
                    innerQueuedObserver2.dispose();
                }
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
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void drain() {
            Object poll;
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            SimpleQueue simpleQueue = this.queue;
            ArrayDeque arrayDeque = this.observers;
            Observer observer = this.actual;
            ErrorMode errorMode = this.errorMode;
            int i = 1;
            while (true) {
                int i2 = this.activeCount;
                while (i2 != this.maxConcurrency) {
                    if (this.cancelled) {
                        simpleQueue.clear();
                        disposeAll();
                        return;
                    } else if (errorMode == ErrorMode.IMMEDIATE && ((Throwable) this.error.get()) != null) {
                        simpleQueue.clear();
                        disposeAll();
                        observer.onError(this.error.terminate());
                        return;
                    } else {
                        try {
                            Object poll2 = simpleQueue.poll();
                            if (poll2 == null) {
                                break;
                            }
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(poll2), "The mapper returned a null ObservableSource");
                            InnerQueuedObserver innerQueuedObserver = new InnerQueuedObserver(this, this.prefetch);
                            arrayDeque.offer(innerQueuedObserver);
                            observableSource.subscribe(innerQueuedObserver);
                            i2++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.d.dispose();
                            simpleQueue.clear();
                            disposeAll();
                            this.error.addThrowable(th);
                            observer.onError(this.error.terminate());
                            return;
                        }
                    }
                }
                this.activeCount = i2;
                if (this.cancelled) {
                    simpleQueue.clear();
                    disposeAll();
                    return;
                } else if (errorMode == ErrorMode.IMMEDIATE && ((Throwable) this.error.get()) != null) {
                    simpleQueue.clear();
                    disposeAll();
                    observer.onError(this.error.terminate());
                    return;
                } else {
                    InnerQueuedObserver innerQueuedObserver2 = this.current;
                    if (innerQueuedObserver2 == null) {
                        if (errorMode == ErrorMode.BOUNDARY && ((Throwable) this.error.get()) != null) {
                            simpleQueue.clear();
                            disposeAll();
                            observer.onError(this.error.terminate());
                            return;
                        }
                        boolean z3 = this.done;
                        InnerQueuedObserver innerQueuedObserver3 = (InnerQueuedObserver) arrayDeque.poll();
                        if (innerQueuedObserver3 == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z3 && z2) {
                            if (((Throwable) this.error.get()) != null) {
                                simpleQueue.clear();
                                disposeAll();
                                observer.onError(this.error.terminate());
                                return;
                            }
                            observer.onComplete();
                            return;
                        }
                        if (!z2) {
                            this.current = innerQueuedObserver3;
                        }
                        innerQueuedObserver2 = innerQueuedObserver3;
                    }
                    if (innerQueuedObserver2 != null) {
                        SimpleQueue queue = innerQueuedObserver2.queue();
                        while (!this.cancelled) {
                            boolean isDone = innerQueuedObserver2.isDone();
                            if (errorMode == ErrorMode.IMMEDIATE && ((Throwable) this.error.get()) != null) {
                                simpleQueue.clear();
                                disposeAll();
                                observer.onError(this.error.terminate());
                                return;
                            }
                            try {
                                poll = queue.poll();
                                if (poll == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.error.addThrowable(th2);
                                this.current = null;
                                this.activeCount--;
                            }
                            if (isDone && z) {
                                this.current = null;
                                this.activeCount--;
                            } else if (!z) {
                                observer.onNext(poll);
                            }
                        }
                        simpleQueue.clear();
                        disposeAll();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerComplete(InnerQueuedObserver innerQueuedObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, innerQueuedObserver) == null) {
                innerQueuedObserver.setDone();
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
                if (this.error.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
                if (this.sourceMode == 0) {
                    this.queue.offer(obj);
                }
                drain();
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerError(InnerQueuedObserver innerQueuedObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, innerQueuedObserver, th) == null) {
                if (this.error.addThrowable(th)) {
                    if (this.errorMode == ErrorMode.IMMEDIATE) {
                        this.d.dispose();
                    }
                    innerQueuedObserver.setDone();
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerNext(InnerQueuedObserver innerQueuedObserver, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, innerQueuedObserver, obj) == null) {
                innerQueuedObserver.queue().offer(obj);
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, disposable) == null) && DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
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
                this.queue = new SpscLinkedArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableConcatMapEager(ObservableSource observableSource, Function function, ErrorMode errorMode, int i, int i2) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, function, errorMode, Integer.valueOf(i), Integer.valueOf(i2)};
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
        this.errorMode = errorMode;
        this.maxConcurrency = i;
        this.prefetch = i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            this.source.subscribe(new ConcatMapEagerMainObserver(observer, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
        }
    }
}
