package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class FlowableTakeUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Publisher<? extends U> other;

    /* loaded from: classes8.dex */
    public static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4945480365982832967L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Subscriber<? super T> actual;
        public final AtomicThrowable error;
        public final TakeUntilMainSubscriber<T>.OtherSubscriber other;
        public final AtomicLong requested;
        public final AtomicReference<Subscription> s;

        /* loaded from: classes8.dex */
        public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -3592821756711087922L;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TakeUntilMainSubscriber this$0;

            public OtherSubscriber(TakeUntilMainSubscriber takeUntilMainSubscriber) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {takeUntilMainSubscriber};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = takeUntilMainSubscriber;
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    SubscriptionHelper.cancel(this.this$0.s);
                    TakeUntilMainSubscriber takeUntilMainSubscriber = this.this$0;
                    HalfSerializer.onError(takeUntilMainSubscriber.actual, th, takeUntilMainSubscriber, takeUntilMainSubscriber.error);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    SubscriptionHelper.cancel(this);
                    onComplete();
                }
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, subscription) == null) {
                    SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SubscriptionHelper.cancel(this.this$0.s);
                    TakeUntilMainSubscriber takeUntilMainSubscriber = this.this$0;
                    HalfSerializer.onComplete(takeUntilMainSubscriber.actual, takeUntilMainSubscriber, takeUntilMainSubscriber.error);
                }
            }
        }

        public TakeUntilMainSubscriber(Subscriber<? super T> subscriber) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscriber};
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
            this.requested = new AtomicLong();
            this.s = new AtomicReference<>();
            this.other = new OtherSubscriber(this);
            this.error = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this.s);
                SubscriptionHelper.cancel(this.other);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SubscriptionHelper.cancel(this.other);
                HalfSerializer.onComplete(this.actual, this, this.error);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                SubscriptionHelper.cancel(this.other);
                HalfSerializer.onError(this.actual, th, this, this.error);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                HalfSerializer.onNext(this.actual, t, this, this.error);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) {
                SubscriptionHelper.deferredSetOnce(this.s, this.requested, subscription);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                SubscriptionHelper.deferredRequest(this.s, this.requested, j);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowableTakeUntil(Flowable<T> flowable, Publisher<? extends U> publisher) {
        super(flowable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, publisher};
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
        this.other = publisher;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(subscriber);
            subscriber.onSubscribe(takeUntilMainSubscriber);
            this.other.subscribe(takeUntilMainSubscriber.other);
            this.source.subscribe((FlowableSubscriber) takeUntilMainSubscriber);
        }
    }
}
