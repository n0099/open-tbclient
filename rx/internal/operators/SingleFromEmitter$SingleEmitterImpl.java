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
import com.repackage.zr9;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes8.dex */
public final class SingleFromEmitter$SingleEmitterImpl<T> extends AtomicBoolean implements Object<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 8082834163465882809L;
    public transient /* synthetic */ FieldHolder $fh;
    public final zr9<? super T> actual;
    public final SequentialSubscription resource;

    public SingleFromEmitter$SingleEmitterImpl(zr9<? super T> zr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zr9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = zr9Var;
        this.resource = new SequentialSubscription();
    }

    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? get() : invokeV.booleanValue;
    }

    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            if (th == null) {
                th = new NullPointerException();
            }
            if (compareAndSet(false, true)) {
                try {
                    this.actual.b(th);
                    return;
                } finally {
                    this.resource.unsubscribe();
                }
            }
            bw9.j(th);
        }
    }

    public void onSuccess(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) && compareAndSet(false, true)) {
            try {
                this.actual.c(t);
            } finally {
                this.resource.unsubscribe();
            }
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

    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
