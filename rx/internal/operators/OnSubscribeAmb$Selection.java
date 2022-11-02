package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d0a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class OnSubscribeAmb$Selection<T> extends AtomicReference<d0a<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Collection<d0a<T>> ambSubscribers;

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
        d0a<T> d0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (d0aVar = get()) != null) {
            unsubscribeOthers(d0aVar);
        }
    }

    public void unsubscribeOthers(d0a<T> d0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d0aVar) == null) {
            for (d0a<T> d0aVar2 : this.ambSubscribers) {
                if (d0aVar2 != d0aVar) {
                    d0aVar2.unsubscribe();
                }
            }
            this.ambSubscribers.clear();
        }
    }
}
