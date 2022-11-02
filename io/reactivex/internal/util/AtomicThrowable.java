package io.reactivex.internal.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3949248817947090603L;
    public transient /* synthetic */ FieldHolder $fh;

    public AtomicThrowable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean isTerminated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (get() == ExceptionHelper.TERMINATED) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Throwable terminate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ExceptionHelper.terminate(this);
        }
        return (Throwable) invokeV.objValue;
    }

    public boolean addThrowable(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, th)) == null) {
            return ExceptionHelper.addThrowable(this, th);
        }
        return invokeL.booleanValue;
    }
}
