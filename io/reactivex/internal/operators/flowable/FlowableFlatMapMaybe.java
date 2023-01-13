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
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes9.dex */
public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayErrors;
    public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    public final int maxConcurrency;

    /* loaded from: classes9.dex */
    public static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8600231336733376951L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger active;
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public final AtomicThrowable errors;
        public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        public final int maxConcurrency;
        public final AtomicReference<SpscLinkedArrayQueue<R>> queue;
        public final AtomicLong requested;
        public Subscription s;
        public final CompositeDisposable set;

        /* loaded from: classes8.dex */
        public final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -502562646270949838L;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlatMapMaybeSubscriber this$0;

            public InnerObserver(FlatMapMaybeSubscriber flatMapMaybeSubscriber) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {flatMapMaybeSubscriber};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = flatMapMaybeSubscriber;
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.this$0.innerError(this, th);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048581, this, r) == null) {
                    this.this$0.innerSuccess(this, r);
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
                    return DisposableHelper.isDisposed(get());
                }
                return invokeV.booleanValue;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.this$0.innerComplete(this);
                }
            }
        }

        public FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.requested = new AtomicLong();
            this.set = new CompositeDisposable();
            this.errors = new AtomicThrowable();
            this.active = new AtomicInteger(1);
            this.queue = new AtomicReference<>();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
                this.s.cancel();
                this.set.dispose();
            }
        }

        public void clear() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (spscLinkedArrayQueue = this.queue.get()) != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getAndIncrement() == 0) {
                drainLoop();
            }
        }

        public SpscLinkedArrayQueue<R> getOrCreateQueue() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                do {
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.queue.get();
                    if (spscLinkedArrayQueue2 != null) {
                        return spscLinkedArrayQueue2;
                    }
                    spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
                } while (!this.queue.compareAndSet(null, spscLinkedArrayQueue));
                return spscLinkedArrayQueue;
            }
            return (SpscLinkedArrayQueue) invokeV.objValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.active.decrementAndGet();
                drain();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
            if (r13 != 0) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
            if (r17.cancelled == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0081, code lost:
            clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0084, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:
            if (r17.delayErrors != false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0091, code lost:
            if (r17.errors.get() == null) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0093, code lost:
            r2 = r17.errors.terminate();
            clear();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
            if (r2.get() != 0) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a8, code lost:
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a9, code lost:
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
            if (r7 == null) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b5, code lost:
            if (r7.isEmpty() == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b7, code lost:
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
            if (r6 == false) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00ba, code lost:
            if (r12 == false) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00bc, code lost:
            r2 = r17.errors.terminate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c2, code lost:
            if (r2 == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c4, code lost:
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00c8, code lost:
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00cb, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ce, code lost:
            if (r10 == 0) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00d0, code lost:
            io.reactivex.internal.util.BackpressureHelper.produced(r17.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00da, code lost:
            if (r17.maxConcurrency == Integer.MAX_VALUE) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00dc, code lost:
            r17.s.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00e1, code lost:
            r5 = addAndGet(-r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            boolean z;
            R r;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Subscriber<? super R> subscriber = this.actual;
                AtomicInteger atomicInteger = this.active;
                AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.queue;
                int i = 1;
                do {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        boolean z3 = false;
                        int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.cancelled) {
                            clear();
                            return;
                        } else if (!this.delayErrors && this.errors.get() != null) {
                            Throwable terminate = this.errors.terminate();
                            clear();
                            subscriber.onError(terminate);
                            return;
                        } else {
                            if (atomicInteger.get() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = atomicReference.get();
                            if (spscLinkedArrayQueue != null) {
                                r = spscLinkedArrayQueue.poll();
                            } else {
                                r = (Object) null;
                            }
                            if (r == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z && z2) {
                                Throwable terminate2 = this.errors.terminate();
                                if (terminate2 != null) {
                                    subscriber.onError(terminate2);
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(r);
                                j2++;
                            }
                        }
                    }
                } while (i != 0);
            }
        }

        public void innerComplete(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, innerObserver) == null) {
                this.set.delete(innerObserver);
                if (get() == 0) {
                    boolean z = false;
                    if (compareAndSet(0, 1)) {
                        if (this.active.decrementAndGet() == 0) {
                            z = true;
                        }
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
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
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.s.request(1L);
                        }
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        drainLoop();
                        return;
                    }
                }
                this.active.decrementAndGet();
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                }
                drain();
            }
        }

        public void innerError(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, innerObserver, th) == null) {
                this.set.delete(innerObserver);
                if (this.errors.addThrowable(th)) {
                    if (!this.delayErrors) {
                        this.s.cancel();
                        this.set.dispose();
                    } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.s.request(1L);
                    }
                    this.active.decrementAndGet();
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void innerSuccess(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, innerObserver, r) == null) {
                this.set.delete(innerObserver);
                if (get() == 0) {
                    boolean z = false;
                    if (compareAndSet(0, 1)) {
                        if (this.active.decrementAndGet() == 0) {
                            z = true;
                        }
                        if (this.requested.get() != 0) {
                            this.actual.onNext(r);
                            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.queue.get();
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
                            BackpressureHelper.produced(this.requested, 1L);
                            if (this.maxConcurrency != Integer.MAX_VALUE) {
                                this.s.request(1L);
                            }
                        } else {
                            SpscLinkedArrayQueue<R> orCreateQueue = getOrCreateQueue();
                            synchronized (orCreateQueue) {
                                orCreateQueue.offer(r);
                            }
                        }
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        drainLoop();
                    }
                }
                SpscLinkedArrayQueue<R> orCreateQueue2 = getOrCreateQueue();
                synchronized (orCreateQueue2) {
                    orCreateQueue2.offer(r);
                }
                this.active.decrementAndGet();
                if (getAndIncrement() != 0) {
                    return;
                }
                drainLoop();
            }
        }

        @Override // org.reactivestreams.Subscriber
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

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048588, this, j) == null) && SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, t) == null) {
                try {
                    MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                    this.active.getAndIncrement();
                    InnerObserver innerObserver = new InnerObserver(this);
                    if (!this.cancelled && this.set.add(innerObserver)) {
                        maybeSource.subscribe(innerObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048587, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request(i);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, Boolean.valueOf(z), Integer.valueOf(i)};
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
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            this.source.subscribe((FlowableSubscriber) new FlatMapMaybeSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency));
        }
    }
}
