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
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes4.dex */
public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function<? super T, ? extends Iterable<? extends R>> mapper;
    public final int prefetch;

    /* loaded from: classes4.dex */
    public static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3096000382929934955L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public int consumed;
        public Iterator<? extends R> current;
        public volatile boolean done;
        public final AtomicReference<Throwable> error;
        public int fusionMode;
        public final int limit;
        public final Function<? super T, ? extends Iterable<? extends R>> mapper;
        public final int prefetch;
        public SimpleQueue<T> queue;
        public final AtomicLong requested;
        public Subscription s;

        public FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, function, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
            this.mapper = function;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            this.error = new AtomicReference<>();
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), subscriber, simpleQueue})) == null) {
                if (this.cancelled) {
                    this.current = null;
                    simpleQueue.clear();
                    return true;
                } else if (z) {
                    if (this.error.get() == null) {
                        if (z2) {
                            subscriber.onComplete();
                            return true;
                        }
                        return false;
                    }
                    Throwable terminate = ExceptionHelper.terminate(this.error);
                    this.current = null;
                    simpleQueue.clear();
                    subscriber.onError(terminate);
                    return true;
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.current = null;
                this.queue.clear();
            }
        }

        public void consumedOne(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
                int i2 = this.consumed + 1;
                if (i2 == this.limit) {
                    this.consumed = 0;
                    this.s.request(i2);
                    return;
                }
                this.consumed = i2;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0125, code lost:
            if (r6 == null) goto L59;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Subscriber<?> subscriber = this.actual;
            SimpleQueue<T> simpleQueue = this.queue;
            boolean z = this.fusionMode != 1;
            Iterator<? extends R> it = this.current;
            int i2 = 1;
            while (true) {
                if (it == null) {
                    boolean z2 = this.done;
                    try {
                        T poll = simpleQueue.poll();
                        if (checkTerminated(z2, poll == null, subscriber, simpleQueue)) {
                            return;
                        }
                        if (poll != null) {
                            try {
                                it = this.mapper.apply(poll).iterator();
                                if (!it.hasNext()) {
                                    consumedOne(z);
                                    it = null;
                                } else {
                                    this.current = it;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.s.cancel();
                                ExceptionHelper.addThrowable(this.error, th);
                                subscriber.onError(ExceptionHelper.terminate(this.error));
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.s.cancel();
                        ExceptionHelper.addThrowable(this.error, th2);
                        Throwable terminate = ExceptionHelper.terminate(this.error);
                        this.current = null;
                        simpleQueue.clear();
                        subscriber.onError(terminate);
                        return;
                    }
                }
                if (it != null) {
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (true) {
                        if (j3 == j2) {
                            break;
                        } else if (checkTerminated(this.done, false, subscriber, simpleQueue)) {
                            return;
                        } else {
                            try {
                                subscriber.onNext((Object) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value"));
                                if (checkTerminated(this.done, false, subscriber, simpleQueue)) {
                                    return;
                                }
                                j3++;
                                try {
                                    if (!it.hasNext()) {
                                        consumedOne(z);
                                        this.current = null;
                                        it = null;
                                        break;
                                    }
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    this.current = null;
                                    this.s.cancel();
                                    ExceptionHelper.addThrowable(this.error, th3);
                                    subscriber.onError(ExceptionHelper.terminate(this.error));
                                    return;
                                }
                            } catch (Throwable th4) {
                                Exceptions.throwIfFatal(th4);
                                this.current = null;
                                this.s.cancel();
                                ExceptionHelper.addThrowable(this.error, th4);
                                subscriber.onError(ExceptionHelper.terminate(this.error));
                                return;
                            }
                        }
                    }
                    if (j3 == j2) {
                        if (checkTerminated(this.done, simpleQueue.isEmpty() && it == null, subscriber, simpleQueue)) {
                            return;
                        }
                    }
                    if (j3 != 0 && j2 != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j3);
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.current == null && this.queue.isEmpty() : invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
                if (!this.done && ExceptionHelper.addThrowable(this.error, th)) {
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
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) || this.done) {
                return;
            }
            if (this.fusionMode == 0 && !this.queue.offer(t)) {
                onError(new MissingBackpressureException("Queue is full?!"));
            } else {
                drain();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.actual.onSubscribe(this);
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.actual.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
            r2 = (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(r0.next(), "The iterator returned a null value");
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
            if (r0.hasNext() != false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
            r4.current = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
            return r2;
         */
        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public R poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048586, this)) != null) {
                return (R) invokeV.objValue;
            }
            Iterator<? extends R> it = this.current;
            while (true) {
                if (it == null) {
                    T poll = this.queue.poll();
                    if (poll != null) {
                        it = this.mapper.apply(poll).iterator();
                        if (it.hasNext()) {
                            this.current = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) && SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.requested, j2);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? ((i2 & 1) == 0 || this.fusionMode != 1) ? 0 : 1 : invokeI.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i2) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, Integer.valueOf(i2)};
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
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            Flowable<T> flowable = this.source;
            if (flowable instanceof Callable) {
                try {
                    Object call = ((Callable) flowable).call();
                    if (call == null) {
                        EmptySubscription.complete(subscriber);
                        return;
                    }
                    try {
                        FlowableFromIterable.subscribe(subscriber, this.mapper.apply(call).iterator());
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, subscriber);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(th2, subscriber);
                    return;
                }
            }
            flowable.subscribe((FlowableSubscriber) new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch));
        }
    }
}
