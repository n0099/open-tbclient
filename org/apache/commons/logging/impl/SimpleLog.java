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
import java.text.DateFormat;
import java.util.Properties;
import org.apache.commons.logging.Log;
@Deprecated
/* loaded from: classes5.dex */
public class SimpleLog implements Log, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_FATAL = 6;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_OFF = 7;
    public static final int LOG_LEVEL_TRACE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    public static DateFormat dateFormatter = null;
    public static String dateTimeFormat = null;
    public static boolean showDateTime = false;
    public static boolean showLogName = false;
    public static boolean showShortName = false;
    public static final Properties simpleLogProps = null;
    public static final String systemPrefix = "org.apache.commons.logging.simplelog.";
    public transient /* synthetic */ FieldHolder $fh;
    public int currentLogLevel;
    public String logName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(370364407, "Lorg/apache/commons/logging/impl/SimpleLog;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(370364407, "Lorg/apache/commons/logging/impl/SimpleLog;");
        }
    }

    public SimpleLog(String str) {
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
    public final void debug(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void error(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void fatal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public int getLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.intValue;
    }

    @Override // org.apache.commons.logging.Log
    public final void info(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isDebugEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isErrorEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isFatalEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isInfoEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public boolean isLevelEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeI.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isTraceEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isWarnEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public void log(int i2, Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048592, this, i2, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void trace(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void warn(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, obj) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void write(StringBuffer stringBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, stringBuffer) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void debug(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void error(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void fatal(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void info(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void trace(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void warn(Object obj, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, obj, th) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
