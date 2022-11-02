package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lz9;
import com.baidu.tieba.n3a;
import com.baidu.tieba.nz9;
import com.baidu.tieba.wz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class SingleFromEmitter$SingleEmitterImpl<T> extends AtomicBoolean implements Object<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 8082834163465882809L;
    public transient /* synthetic */ FieldHolder $fh;
    public final lz9<? super T> actual;
    public final SequentialSubscription resource;

    public SingleFromEmitter$SingleEmitterImpl(lz9<? super T> lz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lz9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = lz9Var;
        this.resource = new SequentialSubscription();
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
            n3a.j(th);
        }
    }

    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return get();
        }
        return invokeV.booleanValue;
    }

    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && compareAndSet(false, true)) {
            this.resource.unsubscribe();
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

    public void setCancellation(wz9 wz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wz9Var) == null) {
            setSubscription(new CancellableSubscription(wz9Var));
        }
    }

    public void setSubscription(nz9 nz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nz9Var) == null) {
            this.resource.update(nz9Var);
        }
    }
}
