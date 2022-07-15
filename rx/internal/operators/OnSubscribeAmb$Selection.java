package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rs9;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<rs9<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Collection<rs9<T>> ambSubscribers;

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
        rs9<T> rs9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (rs9Var = get()) == null) {
            return;
        }
        unsubscribeOthers(rs9Var);
    }

    public void unsubscribeOthers(rs9<T> rs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rs9Var) == null) {
            for (rs9<T> rs9Var2 : this.ambSubscribers) {
                if (rs9Var2 != rs9Var) {
                    rs9Var2.unsubscribe();
                }
            }
            this.ambSubscribers.clear();
        }
    }
}
