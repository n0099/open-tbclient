package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ey9;
import com.baidu.tieba.ky9;
import com.baidu.tieba.ly9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class OnSubscribeUsing$DisposeAction extends AtomicBoolean implements ky9, ey9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4262875056400218316L;
    public transient /* synthetic */ FieldHolder $fh;
    public ly9 dispose;
    public Object resource;

    public OnSubscribeUsing$DisposeAction(ly9 ly9Var, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ly9Var, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dispose = ly9Var;
        this.resource = obj;
        lazySet(false);
    }

    @Override // com.baidu.tieba.ky9
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && compareAndSet(false, true)) {
            try {
                this.dispose.call(this.resource);
            } finally {
                this.resource = null;
                this.dispose = null;
            }
        }
    }

    @Override // com.baidu.tieba.ey9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return get();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ey9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            call();
        }
    }
}
