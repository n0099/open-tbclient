package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public final class FlowableFromIterable extends Flowable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable source;

    /* loaded from: classes8.dex */
    public abstract class BaseRangeSubscription extends BasicQueueSubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2252972430506210021L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public Iterator it;
        public boolean once;

        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i & 1 : invokeI.intValue;
        }

        public abstract void slowPath(long j);

        public BaseRangeSubscription(Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.it = it;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048581, this, j) == null) && SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.it = null;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Iterator it = this.it;
                if (it != null && it.hasNext()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Iterator it = this.it;
                if (it == null) {
                    return null;
                }
                if (!this.once) {
                    this.once = true;
                } else if (!it.hasNext()) {
                    return null;
                }
                return ObjectHelper.requireNonNull(this.it.next(), "Iterator.next() returned a null value");
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class IteratorConditionalSubscription extends BaseRangeSubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6022804456014692607L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConditionalSubscriber actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IteratorConditionalSubscription(ConditionalSubscriber conditionalSubscriber, Iterator it) {
            super(it);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {conditionalSubscriber, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Iterator) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.it;
                ConditionalSubscriber conditionalSubscriber = this.actual;
                while (!this.cancelled) {
                    try {
                        Object next = it.next();
                        if (this.cancelled) {
                            return;
                        }
                        if (next == null) {
                            conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        conditionalSubscriber.tryOnNext(next);
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (!this.cancelled) {
                                    conditionalSubscriber.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            conditionalSubscriber.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        conditionalSubscriber.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Iterator it = this.it;
                ConditionalSubscriber conditionalSubscriber = this.actual;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (this.cancelled) {
                                return;
                            }
                            try {
                                Object next = it.next();
                                if (this.cancelled) {
                                    return;
                                }
                                if (next == null) {
                                    conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                boolean tryOnNext = conditionalSubscriber.tryOnNext(next);
                                if (this.cancelled) {
                                    return;
                                }
                                try {
                                    if (!it.hasNext()) {
                                        if (!this.cancelled) {
                                            conditionalSubscriber.onComplete();
                                            return;
                                        }
                                        return;
                                    } else if (tryOnNext) {
                                        j2++;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    conditionalSubscriber.onError(th);
                                    return;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                conditionalSubscriber.onError(th2);
                                return;
                            }
                        } else {
                            j = get();
                            if (j2 == j) {
                                j = addAndGet(-j2);
                            }
                        }
                    }
                } while (j != 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class IteratorSubscription extends BaseRangeSubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6022804456014692607L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IteratorSubscription(Subscriber subscriber, Iterator it) {
            super(it);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Iterator) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = this.it;
                Subscriber subscriber = this.actual;
                while (!this.cancelled) {
                    try {
                        Object next = it.next();
                        if (this.cancelled) {
                            return;
                        }
                        if (next == null) {
                            subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        subscriber.onNext(next);
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (!this.cancelled) {
                                    subscriber.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            subscriber.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        subscriber.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Iterator it = this.it;
                Subscriber subscriber = this.actual;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (this.cancelled) {
                                return;
                            }
                            try {
                                Object next = it.next();
                                if (this.cancelled) {
                                    return;
                                }
                                if (next == null) {
                                    subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                subscriber.onNext(next);
                                if (this.cancelled) {
                                    return;
                                }
                                try {
                                    if (!it.hasNext()) {
                                        if (!this.cancelled) {
                                            subscriber.onComplete();
                                            return;
                                        }
                                        return;
                                    }
                                    j2++;
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    subscriber.onError(th);
                                    return;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                subscriber.onError(th2);
                                return;
                            }
                        } else {
                            j = get();
                            if (j2 == j) {
                                j = addAndGet(-j2);
                            }
                        }
                    }
                } while (j != 0);
            }
        }
    }

    public FlowableFromIterable(Iterable iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iterable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = iterable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            try {
                subscribe(subscriber, this.source.iterator());
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        }
    }

    public static void subscribe(Subscriber subscriber, Iterator it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, subscriber, it) == null) {
            try {
                if (!it.hasNext()) {
                    EmptySubscription.complete(subscriber);
                } else if (subscriber instanceof ConditionalSubscriber) {
                    subscriber.onSubscribe(new IteratorConditionalSubscription((ConditionalSubscriber) subscriber, it));
                } else {
                    subscriber.onSubscribe(new IteratorSubscription(subscriber, it));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        }
    }
}
