package io.reactivex.internal.operators.observable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class ObservableMergeWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MaybeSource<? extends T> other;

    /* loaded from: classes9.dex */
    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        public static final int OTHER_STATE_HAS_VALUE = 1;
        public static final long serialVersionUID = -4592979584110982903L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public volatile boolean disposed;
        public final AtomicThrowable error;
        public final AtomicReference<Disposable> mainDisposable;
        public volatile boolean mainDone;
        public final OtherObserver<T> otherObserver;
        public volatile int otherState;
        public volatile SimplePlainQueue<T> queue;
        public T singleItem;

        /* loaded from: classes9.dex */
        public static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -2935427570954647017L;
            public transient /* synthetic */ FieldHolder $fh;
            public final MergeWithObserver<T> parent;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mergeWithObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.parent.otherComplete();
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.parent.otherError(th);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.parent.otherSuccess(t);
                }
            }
        }

        public MergeWithObserver(Observer<? super T> observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
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
            this.mainDisposable = new AtomicReference<>();
            this.otherObserver = new OtherObserver<>(this);
            this.error = new AtomicThrowable();
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

        /* JADX DEBUG: Type inference failed for r3v5. Raw type applied. Possible types: T, ? super T */
        public void drainLoop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Observer<? super T> observer = this.actual;
                int i2 = 1;
                while (!this.disposed) {
                    if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        observer.onError(this.error.terminate());
                        return;
                    }
                    int i3 = this.otherState;
                    if (i3 == 1) {
                        this.singleItem = null;
                        this.otherState = 2;
                        observer.onNext((T) this.singleItem);
                        i3 = 2;
                    }
                    boolean z = this.mainDone;
                    SimplePlainQueue<T> simplePlainQueue = this.queue;
                    T poll = simplePlainQueue != null ? simplePlainQueue.poll() : (Object) null;
                    boolean z2 = poll == null;
                    if (z && z2 && i3 == 2) {
                        this.queue = null;
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
                this.singleItem = null;
                this.queue = null;
            }
        }

        public SimplePlainQueue<T> getOrCreateQueue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                SimplePlainQueue<T> simplePlainQueue = this.queue;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? DisposableHelper.isDisposed(this.mainDisposable.get()) : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.mainDone = true;
                drain();
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
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
                if (compareAndSet(0, 1)) {
                    this.actual.onNext(t);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    getOrCreateQueue().offer(t);
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) {
                DisposableHelper.setOnce(this.mainDisposable, disposable);
            }
        }

        public void otherComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.otherState = 2;
                drain();
            }
        }

        public void otherError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
                if (this.error.addThrowable(th)) {
                    DisposableHelper.dispose(this.mainDisposable);
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void otherSuccess(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, t) == null) {
                if (compareAndSet(0, 1)) {
                    this.actual.onNext(t);
                    this.otherState = 2;
                } else {
                    this.singleItem = t;
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
    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observable, maybeSource};
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
        this.other = maybeSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
            observer.onSubscribe(mergeWithObserver);
            this.source.subscribe(mergeWithObserver);
            this.other.subscribe(mergeWithObserver.otherObserver);
        }
    }
}
