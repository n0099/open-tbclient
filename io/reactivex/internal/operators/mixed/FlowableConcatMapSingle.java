package io.reactivex.internal.operators.mixed;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@Experimental
/* loaded from: classes2.dex */
public final class FlowableConcatMapSingle<T, R> extends Flowable<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ErrorMode errorMode;
    public final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    public final int prefetch;
    public final Flowable<T> source;

    /* loaded from: classes2.dex */
    public static final class ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STATE_ACTIVE = 1;
        public static final int STATE_INACTIVE = 0;
        public static final int STATE_RESULT_VALUE = 2;
        public static final long serialVersionUID = -9140123220065488293L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public long emitted;
        public final ErrorMode errorMode;
        public final AtomicThrowable errors;
        public final ConcatMapSingleObserver<R> inner;
        public R item;
        public final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        public final int prefetch;
        public final SimplePlainQueue<T> queue;
        public final AtomicLong requested;
        public volatile int state;
        public Subscription upstream;

        /* loaded from: classes2.dex */
        public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -3051469169682093892L;
            public transient /* synthetic */ FieldHolder $fh;
            public final ConcatMapSingleSubscriber<?, R> parent;

            public ConcatMapSingleObserver(ConcatMapSingleSubscriber<?, R> concatMapSingleSubscriber) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {concatMapSingleSubscriber};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.parent = concatMapSingleSubscriber;
            }

            public void dispose() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DisposableHelper.dispose(this);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.parent.innerError(th);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
                    DisposableHelper.replace(this, disposable);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, r) == null) {
                    this.parent.innerSuccess(r);
                }
            }
        }

        public ConcatMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, int i2, ErrorMode errorMode) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Integer.valueOf(i2), errorMode};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.downstream = subscriber;
            this.mapper = function;
            this.prefetch = i2;
            this.errorMode = errorMode;
            this.requested = new AtomicLong();
            this.errors = new AtomicThrowable();
            this.inner = new ConcatMapSingleObserver<>(this);
            this.queue = new SpscArrayQueue(i2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
                this.upstream.cancel();
                this.inner.dispose();
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                    this.item = null;
                }
            }
        }

        /* JADX DEBUG: Type inference failed for r8v11. Raw type applied. Possible types: R, ? super R */
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.downstream;
                ErrorMode errorMode = this.errorMode;
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicLong atomicLong = this.requested;
                int i2 = this.prefetch;
                int i3 = i2 - (i2 >> 1);
                int i4 = 1;
                while (true) {
                    if (this.cancelled) {
                        simplePlainQueue.clear();
                        this.item = null;
                    }
                    int i5 = this.state;
                    if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i5 != 0))) {
                        if (i5 == 0) {
                            boolean z = this.done;
                            T poll = simplePlainQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable terminate = atomicThrowable.terminate();
                                if (terminate == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onError(terminate);
                                    return;
                                }
                            } else if (!z2) {
                                int i6 = this.consumed + 1;
                                if (i6 == i3) {
                                    this.consumed = 0;
                                    this.upstream.request(i3);
                                } else {
                                    this.consumed = i6;
                                }
                                try {
                                    SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null SingleSource");
                                    this.state = 1;
                                    singleSource.subscribe(this.inner);
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.upstream.cancel();
                                    simplePlainQueue.clear();
                                    atomicThrowable.addThrowable(th);
                                    subscriber.onError(atomicThrowable.terminate());
                                    return;
                                }
                            }
                        } else if (i5 == 2) {
                            long j = this.emitted;
                            if (j != atomicLong.get()) {
                                this.item = null;
                                subscriber.onNext((R) this.item);
                                this.emitted = j + 1;
                                this.state = 0;
                            }
                        }
                        i4 = addAndGet(-i4);
                        if (i4 == 0) {
                            return;
                        }
                    }
                }
                simplePlainQueue.clear();
                this.item = null;
                subscriber.onError(atomicThrowable.terminate());
            }
        }

        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    if (this.errorMode != ErrorMode.END) {
                        this.upstream.cancel();
                    }
                    this.state = 0;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void innerSuccess(R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r) == null) {
                this.item = r;
                this.state = 2;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    if (this.errorMode == ErrorMode.IMMEDIATE) {
                        this.inner.dispose();
                    }
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                if (!this.queue.offer(t)) {
                    this.upstream.cancel();
                    onError(new MissingBackpressureException("queue full?!"));
                    return;
                }
                drain();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, subscription) == null) && SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    public FlowableConcatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, errorMode, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = flowable;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = i2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            this.source.subscribe((FlowableSubscriber) new ConcatMapSingleSubscriber(subscriber, this.mapper, this.prefetch, this.errorMode));
        }
    }
}
