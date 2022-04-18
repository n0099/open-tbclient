package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.az9;
import com.repackage.iz9;
import com.repackage.j3a;
import com.repackage.rz9;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes8.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements iz9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5539301318568668881L;
    public transient /* synthetic */ FieldHolder $fh;
    public final az9 actual;
    public final SequentialSubscription resource;

    public CompletableFromEmitter$FromEmitter(az9 az9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {az9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = az9Var;
        this.resource = new SequentialSubscription();
    }

    @Override // com.repackage.iz9
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
            j3a.j(th);
        }
    }

    public void setCancellation(rz9 rz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rz9Var) == null) {
            setSubscription(new CancellableSubscription(rz9Var));
        }
    }

    public void setSubscription(iz9 iz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iz9Var) == null) {
            this.resource.update(iz9Var);
        }
    }

    @Override // com.repackage.iz9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
