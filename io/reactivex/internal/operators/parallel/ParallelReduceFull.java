package io.reactivex.internal.operators.parallel;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class ParallelReduceFull extends Flowable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BiFunction reducer;
    public final ParallelFlowable source;

    /* loaded from: classes8.dex */
    public final class ParallelReduceFullInnerSubscriber extends AtomicReference implements FlowableSubscriber {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7954444275102466525L;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean done;
        public final ParallelReduceFullMainSubscriber parent;
        public final BiFunction reducer;
        public Object value;

        public ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber, BiFunction biFunction) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parallelReduceFullMainSubscriber, biFunction};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = parallelReduceFullMainSubscriber;
            this.reducer = biFunction;
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.done) {
                this.done = true;
                this.parent.innerComplete(this.value);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && !this.done) {
                Object obj2 = this.value;
                if (obj2 == null) {
                    this.value = obj;
                    return;
                }
                try {
                    this.value = ObjectHelper.requireNonNull(this.reducer.apply(obj2, obj), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    ((Subscription) get()).cancel();
                    onError(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class ParallelReduceFullMainSubscriber extends DeferredScalarSubscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5370107872170712765L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference current;
        public final AtomicReference error;
        public final BiFunction reducer;
        public final AtomicInteger remaining;
        public final ParallelReduceFullInnerSubscriber[] subscribers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParallelReduceFullMainSubscriber(Subscriber subscriber, int i, BiFunction biFunction) {
            super(subscriber);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, Integer.valueOf(i), biFunction};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Subscriber) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.current = new AtomicReference();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference();
            ParallelReduceFullInnerSubscriber[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i];
            for (int i4 = 0; i4 < i; i4++) {
                parallelReduceFullInnerSubscriberArr[i4] = new ParallelReduceFullInnerSubscriber(this, biFunction);
            }
            this.subscribers = parallelReduceFullInnerSubscriberArr;
            this.reducer = biFunction;
            this.remaining.lazySet(i);
        }

        public SlotPair addValue(Object obj) {
            SlotPair slotPair;
            int tryAcquireSlot;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                while (true) {
                    slotPair = (SlotPair) this.current.get();
                    if (slotPair == null) {
                        slotPair = new SlotPair();
                        if (!this.current.compareAndSet(null, slotPair)) {
                            continue;
                        }
                    }
                    tryAcquireSlot = slotPair.tryAcquireSlot();
                    if (tryAcquireSlot >= 0) {
                        break;
                    }
                    this.current.compareAndSet(slotPair, null);
                }
                if (tryAcquireSlot == 0) {
                    slotPair.first = obj;
                } else {
                    slotPair.second = obj;
                }
                if (!slotPair.releaseSlot()) {
                    return null;
                }
                this.current.compareAndSet(slotPair, null);
                return slotPair;
            }
            return (SlotPair) invokeL.objValue;
        }

        public void innerComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                if (obj != null) {
                    while (true) {
                        SlotPair addValue = addValue(obj);
                        if (addValue == null) {
                            break;
                        }
                        try {
                            obj = ObjectHelper.requireNonNull(this.reducer.apply(addValue.first, addValue.second), "The reducer returned a null value");
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            innerError(th);
                            return;
                        }
                    }
                }
                if (this.remaining.decrementAndGet() == 0) {
                    SlotPair slotPair = (SlotPair) this.current.get();
                    this.current.lazySet(null);
                    if (slotPair != null) {
                        complete(slotPair.first);
                    } else {
                        this.actual.onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (ParallelReduceFullInnerSubscriber parallelReduceFullInnerSubscriber : this.subscribers) {
                    parallelReduceFullInnerSubscriber.cancel();
                }
            }
        }

        public void innerError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (this.error.compareAndSet(null, th)) {
                    cancel();
                    this.actual.onError(th);
                } else if (th != this.error.get()) {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class SlotPair extends AtomicInteger {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 473971317683868662L;
        public transient /* synthetic */ FieldHolder $fh;
        public Object first;
        public final AtomicInteger releaseIndex;
        public Object second;

        public SlotPair() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.releaseIndex = new AtomicInteger();
        }

        public boolean releaseSlot() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.releaseIndex.incrementAndGet() == 2) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public int tryAcquireSlot() {
            int i;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                do {
                    i = get();
                    if (i >= 2) {
                        return -1;
                    }
                } while (!compareAndSet(i, i + 1));
                return i;
            }
            return invokeV.intValue;
        }
    }

    public ParallelReduceFull(ParallelFlowable parallelFlowable, BiFunction biFunction) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parallelFlowable, biFunction};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = parallelFlowable;
        this.reducer = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(subscriber, this.source.parallelism(), this.reducer);
            subscriber.onSubscribe(parallelReduceFullMainSubscriber);
            this.source.subscribe(parallelReduceFullMainSubscriber.subscribers);
        }
    }
}
