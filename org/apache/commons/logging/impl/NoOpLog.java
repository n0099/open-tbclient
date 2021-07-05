package org.apache.commons.logging.impl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.apache.commons.logging.Log;
@Deprecated
/* loaded from: classes10.dex */
public class NoOpLog implements Log, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NoOpLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isDebugEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isErrorEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isFatalEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isInfoEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isTraceEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isWarnEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public NoOpLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
