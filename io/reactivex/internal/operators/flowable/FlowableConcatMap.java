package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes2.dex */
public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ErrorMode errorMode;
    public final Function<? super T, ? extends Publisher<? extends R>> mapper;
    public final int prefetch;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$reactivex$internal$util$ErrorMode;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(281188528, "Lio/reactivex/internal/operators/flowable/FlowableConcatMap$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(281188528, "Lio/reactivex/internal/operators/flowable/FlowableConcatMap$1;");
                    return;
                }
            }
            int[] iArr = new int[ErrorMode.values().length];
            $SwitchMap$io$reactivex$internal$util$ErrorMode = iArr;
            try {
                iArr[ErrorMode.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$internal$util$ErrorMode[ErrorMode.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3511336836796789179L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean active;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public final AtomicThrowable errors;
        public final ConcatMapInner<R> inner;
        public final int limit;
        public final Function<? super T, ? extends Publisher<? extends R>> mapper;
        public final int prefetch;
        public SimpleQueue<T> queue;
        public Subscription s;
        public int sourceMode;

        public BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mapper = function;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            this.inner = new ConcatMapInner<>(this);
            this.errors = new AtomicThrowable();
        }

        public abstract void drain();

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public final void innerComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.active = false;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                if (this.sourceMode != 2 && !this.queue.offer(t)) {
                    this.s.cancel();
                    onError(new IllegalStateException("Queue full?!"));
                    return;
                }
                drain();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        subscribeActual();
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscribeActual();
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscribeActual();
                subscription.request(this.prefetch);
            }
        }

        public abstract void subscribeActual();
    }

    /* loaded from: classes2.dex */
    public static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2945777694260521066L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super R> actual;
        public final boolean veryEnd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
            super(function, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Function) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.veryEnd = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.s.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        if (z && !this.veryEnd && this.errors.get() != null) {
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable terminate = this.errors.terminate();
                                if (terminate != null) {
                                    this.actual.onError(terminate);
                                    return;
                                } else {
                                    this.actual.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i2 = this.consumed + 1;
                                        if (i2 == this.limit) {
                                            this.consumed = 0;
                                            this.s.request(i2);
                                        } else {
                                            this.consumed = i2;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.inner.isUnbounded()) {
                                                this.actual.onNext(call);
                                            } else {
                                                this.active = true;
                                                ConcatMapInner<R> concatMapInner = this.inner;
                                                concatMapInner.setSubscription(new WeakScalarSubscription(call, concatMapInner));
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            this.s.cancel();
                                            this.errors.addThrowable(th);
                                            this.actual.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        publisher.subscribe(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.s.cancel();
                                    this.errors.addThrowable(th2);
                                    this.actual.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.s.cancel();
                            this.errors.addThrowable(th3);
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    if (!this.veryEnd) {
                        this.s.cancel();
                        this.done = true;
                    }
                    this.active = false;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerNext(R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r) == null) {
                this.actual.onNext(r);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
                this.inner.request(j2);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        public void subscribeActual() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.actual.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7898995095634264146L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super R> actual;
        public final AtomicInteger wip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
            super(function, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Function) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.wip = new AtomicInteger();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.s.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.wip.getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.actual.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i2 = this.consumed + 1;
                                        if (i2 == this.limit) {
                                            this.consumed = 0;
                                            this.s.request(i2);
                                        } else {
                                            this.consumed = i2;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.inner.isUnbounded()) {
                                                if (get() == 0 && compareAndSet(0, 1)) {
                                                    this.actual.onNext(call);
                                                    if (!compareAndSet(1, 0)) {
                                                        this.actual.onError(this.errors.terminate());
                                                        return;
                                                    }
                                                }
                                            } else {
                                                this.active = true;
                                                ConcatMapInner<R> concatMapInner = this.inner;
                                                concatMapInner.setSubscription(new WeakScalarSubscription(call, concatMapInner));
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            this.s.cancel();
                                            this.errors.addThrowable(th);
                                            this.actual.onError(this.errors.terminate());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        publisher.subscribe(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.s.cancel();
                                    this.errors.addThrowable(th2);
                                    this.actual.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.s.cancel();
                            this.errors.addThrowable(th3);
                            this.actual.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    this.s.cancel();
                    if (getAndIncrement() == 0) {
                        this.actual.onError(this.errors.terminate());
                        return;
                    }
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerNext(R r) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, r) == null) && get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(r);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    this.inner.cancel();
                    if (getAndIncrement() == 0) {
                        this.actual.onError(this.errors.terminate());
                        return;
                    }
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
                this.inner.request(j2);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        public void subscribeActual() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.actual.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 897683679971470653L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConcatMapSupport<R> parent;
        public long produced;

        public ConcatMapInner(ConcatMapSupport<R> concatMapSupport) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concatMapSupport};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = concatMapSupport;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j2 = this.produced;
                if (j2 != 0) {
                    this.produced = 0L;
                    produced(j2);
                }
                this.parent.innerComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                long j2 = this.produced;
                if (j2 != 0) {
                    this.produced = 0L;
                    produced(j2);
                }
                this.parent.innerError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r) == null) {
                this.produced++;
                this.parent.innerNext(r);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, subscription) == null) {
                setSubscription(subscription);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ConcatMapSupport<T> {
        void innerComplete();

        void innerError(Throwable th);

        void innerNext(T t);
    }

    /* loaded from: classes2.dex */
    public static final class WeakScalarSubscription<T> implements Subscription {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public boolean once;
        public final T value;

        public WeakScalarSubscription(T t, Subscriber<? super T> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = t;
            this.actual = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* JADX DEBUG: Type inference failed for r6v0. Raw type applied. Possible types: T, ? super T */
        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || j2 <= 0 || this.once) {
                return;
            }
            this.once = true;
            Subscriber<? super T> subscriber = this.actual;
            subscriber.onNext((T) this.value);
            subscriber.onComplete();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i2, ErrorMode errorMode) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, Integer.valueOf(i2), errorMode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Flowable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mapper = function;
        this.prefetch = i2;
        this.errorMode = errorMode;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, ErrorMode errorMode) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65537, null, subscriber, function, i2, errorMode)) == null) {
            int i3 = AnonymousClass1.$SwitchMap$io$reactivex$internal$util$ErrorMode[errorMode.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    return new ConcatMapImmediate(subscriber, function, i2);
                }
                return new ConcatMapDelayed(subscriber, function, i2, true);
            }
            return new ConcatMapDelayed(subscriber, function, i2, false);
        }
        return (Subscriber) invokeLLIL.objValue;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) || FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            return;
        }
        this.source.subscribe(subscribe(subscriber, this.mapper, this.prefetch, this.errorMode));
    }
}
