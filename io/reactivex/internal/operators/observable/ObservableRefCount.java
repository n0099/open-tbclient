package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public final class ObservableRefCount<T> extends AbstractObservableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile CompositeDisposable baseDisposable;
    public final ReentrantLock lock;
    public final ConnectableObservable<? extends T> source;
    public final AtomicInteger subscriptionCount;

    /* loaded from: classes3.dex */
    public final class ConnectionObserver extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3813126992133394324L;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompositeDisposable currentBase;
        public final Disposable resource;
        public final Observer<? super T> subscriber;
        public final /* synthetic */ ObservableRefCount this$0;

        public ConnectionObserver(ObservableRefCount observableRefCount, Observer<? super T> observer, CompositeDisposable compositeDisposable, Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observableRefCount, observer, compositeDisposable, disposable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = observableRefCount;
            this.subscriber = observer;
            this.currentBase = compositeDisposable;
            this.resource = disposable;
        }

        public void cleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.lock.lock();
                try {
                    if (this.this$0.baseDisposable == this.currentBase) {
                        if (this.this$0.source instanceof Disposable) {
                            ((Disposable) this.this$0.source).dispose();
                        }
                        this.this$0.baseDisposable.dispose();
                        this.this$0.baseDisposable = new CompositeDisposable();
                        this.this$0.subscriptionCount.set(0);
                    }
                } finally {
                    this.this$0.lock.unlock();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                DisposableHelper.dispose(this);
                this.resource.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? DisposableHelper.isDisposed(get()) : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                cleanup();
                this.subscriber.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                cleanup();
                this.subscriber.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                this.subscriber.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class DisposeConsumer implements Consumer<Disposable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> observer;
        public final /* synthetic */ ObservableRefCount this$0;
        public final AtomicBoolean writeLocked;

        public DisposeConsumer(ObservableRefCount observableRefCount, Observer<? super T> observer, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observableRefCount, observer, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = observableRefCount;
            this.observer = observer;
            this.writeLocked = atomicBoolean;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, disposable) == null) {
                try {
                    this.this$0.baseDisposable.add(disposable);
                    this.this$0.doSubscribe(this.observer, this.this$0.baseDisposable);
                } finally {
                    this.this$0.lock.unlock();
                    this.writeLocked.set(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class DisposeTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompositeDisposable current;
        public final /* synthetic */ ObservableRefCount this$0;

        public DisposeTask(ObservableRefCount observableRefCount, CompositeDisposable compositeDisposable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observableRefCount, compositeDisposable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = observableRefCount;
            this.current = compositeDisposable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.lock.lock();
                try {
                    if (this.this$0.baseDisposable == this.current && this.this$0.subscriptionCount.decrementAndGet() == 0) {
                        if (this.this$0.source instanceof Disposable) {
                            ((Disposable) this.this$0.source).dispose();
                        }
                        this.this$0.baseDisposable.dispose();
                        this.this$0.baseDisposable = new CompositeDisposable();
                    }
                } finally {
                    this.this$0.lock.unlock();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        super(connectableObservable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {connectableObservable};
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
        this.baseDisposable = new CompositeDisposable();
        this.subscriptionCount = new AtomicInteger();
        this.lock = new ReentrantLock();
        this.source = connectableObservable;
    }

    private Disposable disconnect(CompositeDisposable compositeDisposable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, compositeDisposable)) == null) ? Disposables.fromRunnable(new DisposeTask(this, compositeDisposable)) : (Disposable) invokeL.objValue;
    }

    private Consumer<Disposable> onSubscribe(Observer<? super T> observer, AtomicBoolean atomicBoolean) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, observer, atomicBoolean)) == null) ? new DisposeConsumer(this, observer, atomicBoolean) : (Consumer) invokeLL.objValue;
    }

    public void doSubscribe(Observer<? super T> observer, CompositeDisposable compositeDisposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, observer, compositeDisposable) == null) {
            ConnectionObserver connectionObserver = new ConnectionObserver(this, observer, compositeDisposable, disconnect(compositeDisposable));
            observer.onSubscribe(connectionObserver);
            this.source.subscribe(connectionObserver);
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, observer) == null) {
            this.lock.lock();
            if (this.subscriptionCount.incrementAndGet() == 1) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                try {
                    this.source.connect(onSubscribe(observer, atomicBoolean));
                    if (z) {
                        return;
                    }
                    return;
                } finally {
                    if (atomicBoolean.get()) {
                    }
                }
            }
            try {
                doSubscribe(observer, this.baseDisposable);
            } finally {
                this.lock.unlock();
            }
        }
    }
}
