package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BiPredicate<? super T, ? super T> comparer;
    public final Publisher<? extends T> first;
    public final int prefetch;
    public final Publisher<? extends T> second;

    /* loaded from: classes10.dex */
    public static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements EqualCoordinatorHelper {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6178010334400373240L;
        public transient /* synthetic */ FieldHolder $fh;
        public final BiPredicate<? super T, ? super T> comparer;
        public final AtomicThrowable error;
        public final EqualSubscriber<T> first;
        public final EqualSubscriber<T> second;
        public T v1;
        public T v2;
        public final AtomicInteger wip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EqualCoordinator(Subscriber<? super Boolean> subscriber, int i2, BiPredicate<? super T, ? super T> biPredicate) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i2), biPredicate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.comparer = biPredicate;
            this.wip = new AtomicInteger();
            this.first = new EqualSubscriber<>(this, i2);
            this.second = new EqualSubscriber<>(this, i2);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel();
                this.first.cancel();
                this.second.cancel();
                if (this.wip.getAndIncrement() == 0) {
                    this.first.clear();
                    this.second.clear();
                }
            }
        }

        public void cancelAndClear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.first.cancel();
                this.first.clear();
                this.second.cancel();
                this.second.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.wip.getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    SimpleQueue<T> simpleQueue = this.first.queue;
                    SimpleQueue<T> simpleQueue2 = this.second.queue;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!isCancelled()) {
                            if (this.error.get() != null) {
                                cancelAndClear();
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                            boolean z = this.first.done;
                            T t = this.v1;
                            if (t == null) {
                                try {
                                    t = simpleQueue.poll();
                                    this.v1 = t;
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    cancelAndClear();
                                    this.error.addThrowable(th);
                                    this.actual.onError(this.error.terminate());
                                    return;
                                }
                            }
                            boolean z2 = t == null;
                            boolean z3 = this.second.done;
                            T t2 = this.v2;
                            if (t2 == null) {
                                try {
                                    t2 = simpleQueue2.poll();
                                    this.v2 = t2;
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    cancelAndClear();
                                    this.error.addThrowable(th2);
                                    this.actual.onError(this.error.terminate());
                                    return;
                                }
                            }
                            boolean z4 = t2 == null;
                            if (z && z3 && z2 && z4) {
                                complete(Boolean.TRUE);
                                return;
                            } else if (z && z3 && z2 != z4) {
                                cancelAndClear();
                                complete(Boolean.FALSE);
                                return;
                            } else if (!z2 && !z4) {
                                try {
                                    if (!this.comparer.test(t, t2)) {
                                        cancelAndClear();
                                        complete(Boolean.FALSE);
                                        return;
                                    }
                                    this.v1 = null;
                                    this.v2 = null;
                                    this.first.request();
                                    this.second.request();
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    cancelAndClear();
                                    this.error.addThrowable(th3);
                                    this.actual.onError(this.error.terminate());
                                    return;
                                }
                            }
                        }
                        this.first.clear();
                        this.second.clear();
                        return;
                    } else if (isCancelled()) {
                        this.first.clear();
                        this.second.clear();
                        return;
                    } else if (this.error.get() != null) {
                        cancelAndClear();
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    i2 = this.wip.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (this.error.addThrowable(th)) {
                    drain();
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }

        public void subscribe(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, publisher, publisher2) == null) {
                publisher.subscribe(this.first);
                publisher2.subscribe(this.second);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface EqualCoordinatorHelper {
        void drain();

        void innerError(Throwable th);
    }

    /* loaded from: classes10.dex */
    public static final class EqualSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4804128302091633067L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public final int limit;
        public final EqualCoordinatorHelper parent;
        public final int prefetch;
        public long produced;
        public volatile SimpleQueue<T> queue;
        public int sourceMode;

        public EqualSubscriber(EqualCoordinatorHelper equalCoordinatorHelper, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {equalCoordinatorHelper, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = equalCoordinatorHelper;
            this.limit = i2 - (i2 >> 2);
            this.prefetch = i2;
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        public void clear() {
            SimpleQueue<T> simpleQueue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (simpleQueue = this.queue) == null) {
                return;
            }
            simpleQueue.clear();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.parent.innerError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                if (this.sourceMode == 0 && !this.queue.offer(t)) {
                    onError(new MissingBackpressureException());
                } else {
                    this.parent.drain();
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, subscription) == null) && SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscription.request(this.prefetch);
            }
        }

        public void request() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.sourceMode == 1) {
                return;
            }
            long j = this.produced + 1;
            if (j >= this.limit) {
                this.produced = 0L;
                get().request(j);
                return;
            }
            this.produced = j;
        }
    }

    public FlowableSequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {publisher, publisher2, biPredicate, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.first = publisher;
        this.second = publisher2;
        this.comparer = biPredicate;
        this.prefetch = i2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            EqualCoordinator equalCoordinator = new EqualCoordinator(subscriber, this.prefetch, this.comparer);
            subscriber.onSubscribe(equalCoordinator);
            equalCoordinator.subscribe(this.first, this.second);
        }
    }
}
