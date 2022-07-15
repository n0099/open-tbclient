package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bs9;
import com.repackage.bw9;
import com.repackage.ks9;
import com.repackage.tr9;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes8.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements bs9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5539301318568668881L;
    public transient /* synthetic */ FieldHolder $fh;
    public final tr9 actual;
    public final SequentialSubscription resource;

    public CompletableFromEmitter$FromEmitter(tr9 tr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tr9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = tr9Var;
        this.resource = new SequentialSubscription();
    }

    @Override // com.repackage.bs9
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
            bw9.j(th);
        }
    }

    public void setCancellation(ks9 ks9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ks9Var) == null) {
            setSubscription(new CancellableSubscription(ks9Var));
        }
    }

    public void setSubscription(bs9 bs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bs9Var) == null) {
            this.resource.update(bs9Var);
        }
    }

    @Override // com.repackage.bs9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
