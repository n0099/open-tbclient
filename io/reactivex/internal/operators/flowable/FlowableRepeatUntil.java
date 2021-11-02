package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes3.dex */
public final class FlowableRepeatUntil<T> extends AbstractFlowableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BooleanSupplier until;

    /* loaded from: classes3.dex */
    public static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7098360935104053232L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public long produced;
        public final SubscriptionArbiter sa;
        public final Publisher<? extends T> source;
        public final BooleanSupplier stop;

        public RepeatSubscriber(Subscriber<? super T> subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber, booleanSupplier, subscriptionArbiter, publisher};
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
            this.sa = subscriptionArbiter;
            this.source = publisher;
            this.stop = booleanSupplier;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.stop.getAsBoolean()) {
                        this.actual.onComplete();
                    } else {
                        subscribeNext();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                this.produced++;
                this.actual.onNext(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, subscription) == null) {
                this.sa.setSubscription(subscription);
            }
        }

        public void subscribeNext() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.sa.isCancelled()) {
                    long j = this.produced;
                    if (j != 0) {
                        this.produced = 0L;
                        this.sa.produced(j);
                    }
                    this.source.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableRepeatUntil(Flowable<T> flowable, BooleanSupplier booleanSupplier) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, booleanSupplier};
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
        this.until = booleanSupplier;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
            subscriber.onSubscribe(subscriptionArbiter);
            new RepeatSubscriber(subscriber, this.until, subscriptionArbiter, this.source).subscribeNext();
        }
    }
}
