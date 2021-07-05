package org.apache.commons.logging.impl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
@Deprecated
/* loaded from: classes10.dex */
public class Jdk14Logger implements Log, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final Level dummyLevel = null;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Logger logger;
    public String name;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1561681947, "Lorg/apache/commons/logging/impl/Jdk14Logger;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1561681947, "Lorg/apache/commons/logging/impl/Jdk14Logger;");
        }
    }

    public Jdk14Logger(String str) {
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

    public Logger getLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Logger) invokeV.objValue;
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public boolean isDebugEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public boolean isErrorEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public boolean isFatalEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public boolean isInfoEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public boolean isTraceEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public boolean isWarnEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
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
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
