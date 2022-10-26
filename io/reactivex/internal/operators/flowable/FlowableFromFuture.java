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
/* loaded from: classes8.dex */
public final class FlowableFromFuture extends Flowable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Future future;
    public final long timeout;
    public final TimeUnit unit;

    public FlowableFromFuture(Future future, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {future, Long.valueOf(j), timeUnit};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public void subscribeActual(Subscriber subscriber) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subscriber) == null) {
            DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
            subscriber.onSubscribe(deferredScalarSubscription);
            try {
                if (this.unit != null) {
                    obj = this.future.get(this.timeout, this.unit);
                } else {
                    obj = this.future.get();
                }
                if (obj == null) {
                    subscriber.onError(new NullPointerException("The future returned null"));
                } else {
                    deferredScalarSubscription.complete(obj);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!deferredScalarSubscription.isCancelled()) {
                    subscriber.onError(th);
                }
            }
        }
    }
}
