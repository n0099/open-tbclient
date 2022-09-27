package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.m1a;
import com.baidu.tieba.mx9;
import com.baidu.tieba.rx9;
import com.baidu.tieba.vx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class CancellableSubscription extends AtomicReference<vx9> implements mx9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5718521705281392066L;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CancellableSubscription(vx9 vx9Var) {
        super(vx9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vx9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.mx9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? get() == null : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mx9
    public void unsubscribe() {
        vx9 andSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e) {
            rx9.e(e);
            m1a.j(e);
        }
    }
}
