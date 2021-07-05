package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class FlowableRefCount<T> extends AbstractFlowableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile CompositeDisposable baseDisposable;
    public final ReentrantLock lock;
    public final ConnectableFlowable<T> source;
    public final AtomicInteger subscriptionCount;

    /* loaded from: classes10.dex */
    public final class ConnectionSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 152064694420235350L;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompositeDisposable currentBase;
        public final AtomicLong requested;
        public final Disposable resource;
        public final Subscriber<? super T> subscriber;
        public final /* synthetic */ FlowableRefCount this$0;

        public ConnectionSubscriber(FlowableRefCount flowableRefCount, Subscriber<? super T> subscriber, CompositeDisposable compositeDisposable, Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowableRefCount, subscriber, compositeDisposable, disposable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flowableRefCount;
            this.subscriber = subscriber;
            this.currentBase = compositeDisposable;
            this.resource = disposable;
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
                this.resource.dispose();
            }
        }

        public void cleanup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                cleanup();
                this.subscriber.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                cleanup();
                this.subscriber.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                this.subscriber.onNext(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) {
                SubscriptionHelper.deferredSetOnce(this, this.requested, subscription);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                SubscriptionHelper.deferredRequest(this, this.requested, j);
            }
        }
    }

    /* loaded from: classes10.dex */
    public final class DisposeConsumer implements Consumer<Disposable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> subscriber;
        public final /* synthetic */ FlowableRefCount this$0;
        public final AtomicBoolean writeLocked;

        public DisposeConsumer(FlowableRefCount flowableRefCount, Subscriber<? super T> subscriber, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowableRefCount, subscriber, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flowableRefCount;
            this.subscriber = subscriber;
            this.writeLocked = atomicBoolean;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, disposable) == null) {
                try {
                    this.this$0.baseDisposable.add(disposable);
                    this.this$0.doSubscribe(this.subscriber, this.this$0.baseDisposable);
                } finally {
                    this.this$0.lock.unlock();
                    this.writeLocked.set(false);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public final class DisposeTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompositeDisposable current;
        public final /* synthetic */ FlowableRefCount this$0;

        public DisposeTask(FlowableRefCount flowableRefCount, CompositeDisposable compositeDisposable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowableRefCount, compositeDisposable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flowableRefCount;
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
    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable) {
        super(connectableFlowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {connectableFlowable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.baseDisposable = new CompositeDisposable();
        this.subscriptionCount = new AtomicInteger();
        this.lock = new ReentrantLock();
        this.source = connectableFlowable;
    }

    private Disposable disconnect(CompositeDisposable compositeDisposable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, compositeDisposable)) == null) ? Disposables.fromRunnable(new DisposeTask(this, compositeDisposable)) : (Disposable) invokeL.objValue;
    }

    private Consumer<Disposable> onSubscribe(Subscriber<? super T> subscriber, AtomicBoolean atomicBoolean) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, subscriber, atomicBoolean)) == null) ? new DisposeConsumer(this, subscriber, atomicBoolean) : (Consumer) invokeLL.objValue;
    }

    public void doSubscribe(Subscriber<? super T> subscriber, CompositeDisposable compositeDisposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, subscriber, compositeDisposable) == null) {
            ConnectionSubscriber connectionSubscriber = new ConnectionSubscriber(this, subscriber, compositeDisposable, disconnect(compositeDisposable));
            subscriber.onSubscribe(connectionSubscriber);
            this.source.subscribe((FlowableSubscriber) connectionSubscriber);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subscriber) == null) {
            this.lock.lock();
            if (this.subscriptionCount.incrementAndGet() == 1) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                try {
                    this.source.connect(onSubscribe(subscriber, atomicBoolean));
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
                doSubscribe(subscriber, this.baseDisposable);
            } finally {
                this.lock.unlock();
            }
        }
    }
}
