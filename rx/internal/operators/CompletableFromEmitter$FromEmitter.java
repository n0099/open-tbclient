package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.c;
import h.k;
import h.n.d;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes10.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5539301318568668881L;
    public transient /* synthetic */ FieldHolder $fh;
    public final c actual;
    public final SequentialSubscription resource;

    public CompletableFromEmitter$FromEmitter(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = cVar;
        this.resource = new SequentialSubscription();
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? get() : invokeV.booleanValue;
    }

    public void onCompleted() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && compareAndSet(false, true)) {
            try {
                this.actual.onCompleted();
            } finally {
                this.resource.unsubscribe();
            }
        }
    }

    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onError(th);
                    return;
                } finally {
                    this.resource.unsubscribe();
                }
            }
            h.r.c.j(th);
        }
    }

    public void setCancellation(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            setSubscription(new CancellableSubscription(dVar));
        }
    }

    public void setSubscription(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) {
            this.resource.update(kVar);
        }
    }

    @Override // h.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
