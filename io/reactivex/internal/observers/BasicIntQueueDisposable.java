package io.reactivex.internal.observers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements QueueDisposable<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1001730202384742097L;
    public transient /* synthetic */ FieldHolder $fh;

    public BasicIntQueueDisposable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            throw new UnsupportedOperationException("Should not be called");
        }
        return invokeL.booleanValue;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, t2)) == null) {
            throw new UnsupportedOperationException("Should not be called");
        }
        return invokeLL.booleanValue;
    }
}
