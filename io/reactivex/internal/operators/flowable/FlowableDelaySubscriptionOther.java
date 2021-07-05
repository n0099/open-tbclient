package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes10.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Publisher<? extends T> main;
    public final Publisher<U> other;

    /* loaded from: classes10.dex */
    public final class DelaySubscriber implements FlowableSubscriber<U> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> child;
        public boolean done;
        public final SubscriptionArbiter serial;
        public final /* synthetic */ FlowableDelaySubscriptionOther this$0;

        /* loaded from: classes10.dex */
        public final class DelaySubscription implements Subscription {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Subscription s;
            public final /* synthetic */ DelaySubscriber this$1;

            public DelaySubscription(DelaySubscriber delaySubscriber, Subscription subscription) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {delaySubscriber, subscription};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = delaySubscriber;
                this.s = subscription;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.s.cancel();
                }
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                }
            }
        }

        /* loaded from: classes10.dex */
        public final class OnCompleteSubscriber implements FlowableSubscriber<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DelaySubscriber this$1;

            public OnCompleteSubscriber(DelaySubscriber delaySubscriber) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {delaySubscriber};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = delaySubscriber;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.this$1.child.onComplete();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.this$1.child.onError(th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                    this.this$1.child.onNext(t);
                }
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, subscription) == null) {
                    this.this$1.serial.setSubscription(subscription);
                }
            }
        }

        public DelaySubscriber(FlowableDelaySubscriptionOther flowableDelaySubscriptionOther, SubscriptionArbiter subscriptionArbiter, Subscriber<? super T> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flowableDelaySubscriptionOther, subscriptionArbiter, subscriber};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flowableDelaySubscriptionOther;
            this.serial = subscriptionArbiter;
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.done) {
                return;
            }
            this.done = true;
            this.this$0.main.subscribe(new OnCompleteSubscriber(this));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.done = true;
                this.child.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u) == null) {
                onComplete();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, subscription) == null) {
                this.serial.setSubscription(new DelaySubscription(this, subscription));
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableDelaySubscriptionOther(Publisher<? extends T> publisher, Publisher<U> publisher2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {publisher, publisher2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.main = publisher;
        this.other = publisher2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
            subscriber.onSubscribe(subscriptionArbiter);
            this.other.subscribe(new DelaySubscriber(this, subscriptionArbiter, subscriber));
        }
    }
}
