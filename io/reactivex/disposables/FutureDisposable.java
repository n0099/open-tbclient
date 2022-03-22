package io.reactivex.disposables;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6545242830671168775L;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean allowInterrupt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FutureDisposable(Future<?> future, boolean z) {
        super(future);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {future, Boolean.valueOf(z)};
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
        this.allowInterrupt = z;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Future<?> andSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (andSet = getAndSet(null)) == null) {
            return;
        }
        andSet.cancel(this.allowInterrupt);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Future<?> future = get();
            return future == null || future.isDone();
        }
        return invokeV.booleanValue;
    }
}
