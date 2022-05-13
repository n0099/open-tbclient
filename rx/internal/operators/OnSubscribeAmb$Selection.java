package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ty9;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<ty9<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Collection<ty9<T>> ambSubscribers;

    public OnSubscribeAmb$Selection() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ambSubscribers = new ConcurrentLinkedQueue();
    }

    public void unsubscribeLosers() {
        ty9<T> ty9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ty9Var = get()) == null) {
            return;
        }
        unsubscribeOthers(ty9Var);
    }

    public void unsubscribeOthers(ty9<T> ty9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ty9Var) == null) {
            for (ty9<T> ty9Var2 : this.ambSubscribers) {
                if (ty9Var2 != ty9Var) {
                    ty9Var2.unsubscribe();
                }
            }
            this.ambSubscribers.clear();
        }
    }
}
