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
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class ObservableMergeWithSingle extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SingleSource other;

    /* loaded from: classes8.dex */
    public final class MergeWithObserver extends AtomicInteger implements Observer, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        public static final int OTHER_STATE_HAS_VALUE = 1;
        public static final long serialVersionUID = -4592979584110982903L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer actual;
        public volatile boolean disposed;
        public final AtomicThrowable error;
        public final AtomicReference mainDisposable;
        public volatile boolean mainDone;
        public final OtherObserver otherObserver;
        public volatile int otherState;
        public volatile SimplePlainQueue queue;
        public Object singleItem;

        /* loaded from: classes8.dex */
        public final class OtherObserver extends AtomicReference implements SingleObserver {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -2935427570954647017L;
            public transient /* synthetic */ FieldHolder $fh;
            public final MergeWithObserver parent;

            public OtherObserver(MergeWithObserver mergeWithObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mergeWithObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                    this.parent.otherError(th);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    this.parent.otherSuccess(obj);
                }
            }
        }

        public MergeWithObserver(Observer observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
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
            this.mainDisposable = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
                if (compareAndSet(0, 1)) {
                    this.actual.onNext(obj);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    getOrCreateQueue().offer(obj);
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.disposed = true;
                DisposableHelper.dispose(this.mainDisposable);
                DisposableHelper.dispose(this.otherObserver);
                if (getAndIncrement() == 0) {
                    this.queue = null;
                    this.singleItem = null;
                }
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public SimplePlainQueue getOrCreateQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                SimplePlainQueue simplePlainQueue = this.queue;
                if (simplePlainQueue == null) {
                    SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                    this.queue = spscLinkedArrayQueue;
                    return spscLinkedArrayQueue;
                }
                return simplePlainQueue;
            }
            return (SimplePlainQueue) invokeV.objValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return DisposableHelper.isDisposed((Disposable) this.mainDisposable.get());
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.mainDone = true;
                drain();
            }
        }

        public void drainLoop() {
            Object obj;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Observer observer = this.actual;
                int i = 1;
                while (!this.disposed) {
                    if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        observer.onError(this.error.terminate());
                        return;
                    }
                    int i2 = this.otherState;
                    if (i2 == 1) {
                        Object obj2 = this.singleItem;
                        this.singleItem = null;
                        this.otherState = 2;
                        observer.onNext(obj2);
                        i2 = 2;
                    }
                    boolean z2 = this.mainDone;
                    SimplePlainQueue simplePlainQueue = this.queue;
                    if (simplePlainQueue != null) {
                        obj = simplePlainQueue.poll();
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 && z && i2 == 2) {
                        this.queue = null;
                        observer.onComplete();
                        return;
                    } else if (z) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(obj);
                    }
                }
                this.singleItem = null;
                this.queue = null;
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
                if (this.error.addThrowable(th)) {
                    DisposableHelper.dispose(this.mainDisposable);
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) {
                DisposableHelper.setOnce(this.mainDisposable, disposable);
            }
        }

        public void otherError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, th) == null) {
                if (this.error.addThrowable(th)) {
                    DisposableHelper.dispose(this.mainDisposable);
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void otherSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, obj) == null) {
                if (compareAndSet(0, 1)) {
                    this.actual.onNext(obj);
                    this.otherState = 2;
                } else {
                    this.singleItem = obj;
                    this.otherState = 1;
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableMergeWithSingle(Observable observable, SingleSource singleSource) {
        super(observable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observable, singleSource};
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
        this.other = singleSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
            observer.onSubscribe(mergeWithObserver);
            this.source.subscribe(mergeWithObserver);
            this.other.subscribe(mergeWithObserver.otherObserver);
        }
    }
}
