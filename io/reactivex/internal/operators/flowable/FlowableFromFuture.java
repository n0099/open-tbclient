package io.reactivex.internal.operators.flowable;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
/* loaded from: classes9.dex */
public final class FlowableFromFuture<T> extends Flowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Future<? extends T> future;
    public final long timeout;
    public final TimeUnit unit;

    public FlowableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {future, Long.valueOf(j), timeUnit};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.future = future;
        this.timeout = j;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
            subscriber.onSubscribe(deferredScalarSubscription);
            try {
                T t = this.unit != null ? this.future.get(this.timeout, this.unit) : this.future.get();
                if (t == null) {
                    subscriber.onError(new NullPointerException("The future returned null"));
                } else {
                    deferredScalarSubscription.complete(t);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (deferredScalarSubscription.isCancelled()) {
                    return;
                }
                subscriber.onError(th);
            }
        }
    }
}
