package com.facebook.common.logging;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes7.dex */
public class FLogDefaultLoggingDelegate implements LoggingDelegate {
    public static /* synthetic */ Interceptable $ic;
    public static final FLogDefaultLoggingDelegate sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public String mApplicationTag;
    public int mMinimumLoggingLevel;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1569976021, "Lcom/facebook/common/logging/FLogDefaultLoggingDelegate;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1569976021, "Lcom/facebook/common/logging/FLogDefaultLoggingDelegate;");
                return;
            }
        }
        sInstance = new FLogDefaultLoggingDelegate();
    }

    public FLogDefaultLoggingDelegate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mApplicationTag = "unknown";
        this.mMinimumLoggingLevel = 5;
    }

    public static FLogDefaultLoggingDelegate getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return sInstance;
        }
        return (FLogDefaultLoggingDelegate) invokeV.objValue;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public int getMinimumLoggingLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mMinimumLoggingLevel;
        }
        return invokeV.intValue;
    }

    public static String getMsg(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, th)) == null) {
            return str + '\n' + getStackTraceString(th);
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            println(3, str, str2);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            println(6, str, str2);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            println(4, str, str2);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            println(2, str, str2);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            println(5, str, str2);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            println(6, str, str2);
        }
    }

    public static String getStackTraceString(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            if (th == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    private String prefixTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            if (this.mApplicationTag != null) {
                return this.mApplicationTag + ":" + str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public boolean isLoggable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.mMinimumLoggingLevel <= i) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void setApplicationTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mApplicationTag = str;
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void setMinimumLoggingLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.mMinimumLoggingLevel = i;
        }
    }

    private void println(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65542, this, i, str, str2) == null) {
            Log.println(i, prefixTag(str), str2);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, th) == null) {
            println(3, str, str2, th);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, th) == null) {
            println(6, str, str2, th);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            println(4, str, str2, th);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void log(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str, str2) == null) {
            println(i, str, str2);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, str2, th) == null) {
            println(2, str, str2, th);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, str2, th) == null) {
            println(5, str, str2, th);
        }
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, th) == null) {
            println(6, str, str2, th);
        }
    }

    private void println(int i, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), str, str2, th}) == null) {
            Log.println(i, prefixTag(str), getMsg(str2, th));
        }
    }
}
