package io.reactivex.exceptions;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.util.ExceptionHelper;
/* loaded from: classes8.dex */
public final class Exceptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Exceptions() {
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
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static RuntimeException propagate(@NonNull Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, th)) == null) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
        return (RuntimeException) invokeL.objValue;
    }

    public static void throwIfFatal(@NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, th) == null) {
            if (!(th instanceof VirtualMachineError)) {
                if (!(th instanceof ThreadDeath)) {
                    if (!(th instanceof LinkageError)) {
                        return;
                    }
                    throw ((LinkageError) th);
                }
                throw ((ThreadDeath) th);
            }
            throw ((VirtualMachineError) th);
        }
    }
}
