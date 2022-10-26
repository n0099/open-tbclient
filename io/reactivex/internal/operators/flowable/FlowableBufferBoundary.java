package io.reactivex.internal.operators.flowable;

import androidx.core.view.InputDeviceCompat;
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
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableBufferBoundary extends AbstractFlowableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function bufferClose;
    public final Publisher bufferOpen;
    public final Callable bufferSupplier;

    /* loaded from: classes8.dex */
    public final class BufferBoundarySubscriber extends AtomicInteger implements FlowableSubscriber, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8466418554264089604L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;
        public final Function bufferClose;
        public final Publisher bufferOpen;
        public final Callable bufferSupplier;
        public Map buffers;
        public volatile boolean cancelled;
        public volatile boolean done;
        public long emitted;
        public final AtomicThrowable errors;
        public long index;
        public final SpscLinkedArrayQueue queue;
        public final AtomicLong requested;
        public final CompositeDisposable subscribers;
        public final AtomicReference upstream;

        /* loaded from: classes8.dex */
        public final class BufferOpenSubscriber extends AtomicReference implements FlowableSubscriber, Disposable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -8498650778633225126L;
            public transient /* synthetic */ FieldHolder $fh;
            public final BufferBoundarySubscriber parent;

            public BufferOpenSubscriber(BufferBoundarySubscriber bufferBoundarySubscriber) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bufferBoundarySubscriber};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.parent = bufferBoundarySubscriber;
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    lazySet(SubscriptionHelper.CANCELLED);
                    this.parent.boundaryError(this, th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                    this.parent.open(obj);
                }
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) {
                    SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SubscriptionHelper.cancel(this);
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (get() == SubscriptionHelper.CANCELLED) {
                        return true;
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    lazySet(SubscriptionHelper.CANCELLED);
                    this.parent.openComplete(this);
                }
            }
        }

        public BufferBoundarySubscriber(Subscriber subscriber, Publisher publisher, Function function, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, publisher, function, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.bufferSupplier = callable;
            this.bufferOpen = publisher;
            this.bufferClose = function;
            this.queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
            this.subscribers = new CompositeDisposable();
            this.requested = new AtomicLong();
            this.upstream = new AtomicReference();
            this.buffers = new LinkedHashMap();
            this.errors = new AtomicThrowable();
        }

        public void boundaryError(Disposable disposable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, disposable, th) == null) {
                SubscriptionHelper.cancel(this.upstream);
                this.subscribers.delete(disposable);
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && SubscriptionHelper.cancel(this.upstream)) {
                this.cancelled = true;
                this.subscribers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.subscribers.dispose();
                synchronized (this) {
                    Map map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    for (Collection collection : map.values()) {
                        this.queue.offer(collection);
                    }
                    this.buffers = null;
                    this.done = true;
                    drain();
                }
            }
        }

        public void close(BufferCloseSubscriber bufferCloseSubscriber, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, bufferCloseSubscriber, j) == null) {
                this.subscribers.delete(bufferCloseSubscriber);
                if (this.subscribers.size() == 0) {
                    SubscriptionHelper.cancel(this.upstream);
                    z = true;
                } else {
                    z = false;
                }
                synchronized (this) {
                    if (this.buffers == null) {
                        return;
                    }
                    this.queue.offer(this.buffers.remove(Long.valueOf(j)));
                    if (z) {
                        this.done = true;
                    }
                    drain();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
            if (r8 != 0) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
            if (r12.cancelled == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
            r3.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0064, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0067, code lost:
            if (r12.done == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x006f, code lost:
            if (r12.errors.get() == null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0071, code lost:
            r3.clear();
            r2.onError(r12.errors.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0082, code lost:
            if (r3.isEmpty() == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0084, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0087, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0088, code lost:
            r12.emitted = r0;
            r5 = addAndGet(-r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || getAndIncrement() != 0) {
                return;
            }
            long j = this.emitted;
            Subscriber subscriber = this.actual;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
            int i = 1;
            do {
                long j2 = this.requested.get();
                while (true) {
                    int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.cancelled) {
                        spscLinkedArrayQueue.clear();
                        return;
                    } else {
                        boolean z2 = this.done;
                        if (z2 && this.errors.get() != null) {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(this.errors.terminate());
                            return;
                        }
                        Collection collection = (Collection) spscLinkedArrayQueue.poll();
                        if (collection == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && z) {
                            subscriber.onComplete();
                            return;
                        } else if (z) {
                            break;
                        } else {
                            subscriber.onNext(collection);
                            j++;
                        }
                    }
                }
            } while (i != 0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    this.subscribers.dispose();
                    synchronized (this) {
                        this.buffers = null;
                    }
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, subscription) == null) && SubscriptionHelper.setOnce(this.upstream, subscription)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.subscribers.add(bufferOpenSubscriber);
                this.bufferOpen.subscribe(bufferOpenSubscriber);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void openComplete(BufferOpenSubscriber bufferOpenSubscriber) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bufferOpenSubscriber) == null) {
                this.subscribers.delete(bufferOpenSubscriber);
                if (this.subscribers.size() == 0) {
                    SubscriptionHelper.cancel(this.upstream);
                    this.done = true;
                    drain();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
                synchronized (this) {
                    Map map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    for (Collection collection : map.values()) {
                        collection.add(obj);
                    }
                }
            }
        }

        public void open(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj) == null) {
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.bufferClose.apply(obj), "The bufferClose returned a null Publisher");
                    long j = this.index;
                    this.index = 1 + j;
                    synchronized (this) {
                        Map map = this.buffers;
                        if (map == null) {
                            return;
                        }
                        map.put(Long.valueOf(j), collection);
                        BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j);
                        this.subscribers.add(bufferCloseSubscriber);
                        publisher.subscribe(bufferCloseSubscriber);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    SubscriptionHelper.cancel(this.upstream);
                    onError(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class BufferCloseSubscriber extends AtomicReference implements FlowableSubscriber, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8498650778633225126L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long index;
        public final BufferBoundarySubscriber parent;

        public BufferCloseSubscriber(BufferBoundarySubscriber bufferBoundarySubscriber, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bufferBoundarySubscriber, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = bufferBoundarySubscriber;
            this.index = j;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (get() == SubscriptionHelper.CANCELLED) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Object obj = get();
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (obj != subscriptionHelper) {
                    lazySet(subscriptionHelper);
                    this.parent.close(this, this.index);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                Object obj = get();
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (obj != subscriptionHelper) {
                    lazySet(subscriptionHelper);
                    this.parent.boundaryError(this, th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Subscription subscription;
            SubscriptionHelper subscriptionHelper;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, obj) == null) && (subscription = (Subscription) get()) != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableBufferBoundary(Flowable flowable, Publisher publisher, Function function, Callable callable) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, publisher, function, callable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bufferOpen = publisher;
        this.bufferClose = function;
        this.bufferSupplier = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.bufferOpen, this.bufferClose, this.bufferSupplier);
            subscriber.onSubscribe(bufferBoundarySubscriber);
            this.source.subscribe((FlowableSubscriber) bufferBoundarySubscriber);
        }
    }
}
