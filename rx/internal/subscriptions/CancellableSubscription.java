package rx.internal.subscriptions;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i3a;
import com.baidu.tieba.i7a;
import com.baidu.tieba.n3a;
import com.baidu.tieba.r3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class CancellableSubscription extends AtomicReference<r3a> implements i3a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5718521705281392066L;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CancellableSubscription(r3a r3aVar) {
        super(r3aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r3aVar};
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

    @Override // com.baidu.tieba.i3a
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (get() == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.i3a
    public void unsubscribe() {
        r3a andSet;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                n3a.e(e);
                i7a.j(e);
            }
        }
    }
}
