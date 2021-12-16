package io.reactivex.internal.subscribers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes4.dex */
public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4945028590049415624L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Subscriber<? super T> actual;
    public volatile boolean done;
    public final AtomicThrowable error;
    public final AtomicBoolean once;
    public final AtomicLong requested;
    public final AtomicReference<Subscription> s;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {subscriber};
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
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.s = new AtomicReference<>();
        this.once = new AtomicBoolean();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.done) {
            return;
        }
        SubscriptionHelper.cancel(this.s);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.done = true;
            HalfSerializer.onComplete(this.actual, this, this.error);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            this.done = true;
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
            if (this.once.compareAndSet(false, true)) {
                this.actual.onSubscribe(this);
                SubscriptionHelper.deferredSetOnce(this.s, this.requested, subscription);
                return;
            }
            subscription.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            if (j2 <= 0) {
                cancel();
                onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j2));
                return;
            }
            SubscriptionHelper.deferredRequest(this.s, this.requested, j2);
        }
    }
}
