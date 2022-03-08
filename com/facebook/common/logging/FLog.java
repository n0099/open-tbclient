package com.facebook.common.logging;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static LoggingDelegate sHandler;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-167157800, "Lcom/facebook/common/logging/FLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-167157800, "Lcom/facebook/common/logging/FLog;");
                return;
            }
        }
        sHandler = FLogDefaultLoggingDelegate.getInstance();
    }

    public FLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) && sHandler.isLoggable(3)) {
            sHandler.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65558, null, str, str2) == null) && sHandler.isLoggable(6)) {
            sHandler.e(str, str2);
        }
    }

    public static String formatString(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, str, objArr)) == null) ? String.format(null, str, objArr) : (String) invokeLL.objValue;
    }

    public static int getMinimumLoggingLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? sHandler.getMinimumLoggingLevel() : invokeV.intValue;
    }

    public static String getTag(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, cls)) == null) ? cls.getSimpleName() : (String) invokeL.objValue;
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65573, null, str, str2) == null) && sHandler.isLoggable(4)) {
            sHandler.i(str, str2);
        }
    }

    public static boolean isLoggable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65581, null, i2)) == null) ? sHandler.isLoggable(i2) : invokeI.booleanValue;
    }

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65582, null, loggingDelegate) == null) {
            if (loggingDelegate != null) {
                sHandler = loggingDelegate;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public static void setMinimumLoggingLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65583, null, i2) == null) {
            sHandler.setMinimumLoggingLevel(i2);
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65592, null, str, str2) == null) && sHandler.isLoggable(2)) {
            sHandler.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65604, null, str, str2) == null) && sHandler.isLoggable(5)) {
            sHandler.w(str, str2);
        }
    }

    public static void wtf(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65612, null, str, str2) == null) && sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void d(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65547, null, str, str2, obj) == null) && sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj));
        }
    }

    public static void e(Class<?> cls, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65554, null, cls, str) == null) && sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), str);
        }
    }

    public static void i(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65574, null, str, str2, obj) == null) && sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj));
        }
    }

    public static void v(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65593, null, str, str2, obj) == null) && sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj));
        }
    }

    public static void w(Class<?> cls, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65600, null, cls, str) == null) && sHandler.isLoggable(5)) {
            sHandler.w(getTag(cls), str);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65608, null, cls, str) == null) && sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65548, null, str, str2, obj, obj2) == null) && sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj, obj2));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65560, null, str, str2, objArr) == null) && sHandler.isLoggable(6)) {
            sHandler.e(str, formatString(str2, objArr));
        }
    }

    public static void i(String str, String str2, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65575, null, str, str2, obj, obj2) == null) && sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj, obj2));
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65594, null, str, str2, obj, obj2) == null) && sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj, obj2));
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65606, null, str, str2, objArr) == null) && sHandler.isLoggable(5)) {
            sHandler.w(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65614, null, str, str2, objArr) == null) && sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65549, null, str, str2, obj, obj2, obj3) == null) && sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65561, null, str, th, str2, objArr) == null) && sHandler.isLoggable(6)) {
            sHandler.e(str, formatString(str2, objArr), th);
        }
    }

    public static void i(String str, String str2, Object obj, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65576, null, str, str2, obj, obj2, obj3) == null) && sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65595, null, str, str2, obj, obj2, obj3) == null) && sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65607, null, str, th, str2, objArr) == null) && sHandler.isLoggable(5)) {
            sHandler.w(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65615, null, str, th, str2, objArr) == null) && sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{str, str2, obj, obj2, obj3, obj4}) == null) && sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65556, null, cls, str, objArr) == null) && sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), formatString(str, objArr));
        }
    }

    public static void i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65577, null, new Object[]{str, str2, obj, obj2, obj3, obj4}) == null) && sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65596, null, new Object[]{str, str2, obj, obj2, obj3, obj4}) == null) && sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void w(Class<?> cls, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65602, null, cls, str, objArr) == null) && sHandler.isLoggable(5)) {
            sHandler.w(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65610, null, cls, str, objArr) == null) && sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void d(Class<?> cls, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, cls, str) == null) && sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), str);
        }
    }

    public static void e(Class<?> cls, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65557, null, cls, th, str, objArr) == null) && sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void i(Class<?> cls, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65565, null, cls, str) == null) && sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), str);
        }
    }

    public static void v(Class<?> cls, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65584, null, cls, str) == null) && sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), str);
        }
    }

    public static void w(Class<?> cls, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65603, null, cls, th, str, objArr) == null) && isLoggable(5)) {
            w(cls, formatString(str, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65611, null, cls, th, str, objArr) == null) && sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, cls, str, obj) == null) && sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65559, null, str, str2, th) == null) && sHandler.isLoggable(6)) {
            sHandler.e(str, str2, th);
        }
    }

    public static void i(Class<?> cls, String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65566, null, cls, str, obj) == null) && sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj));
        }
    }

    public static void v(Class<?> cls, String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65585, null, cls, str, obj) == null) && sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, obj));
        }
    }

    public static void w(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65605, null, str, str2, th) == null) && sHandler.isLoggable(5)) {
            sHandler.w(str, str2, th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65613, null, str, str2, th) == null) && sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void d(Class<?> cls, String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str, obj, obj2) == null) && sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    public static void e(Class<?> cls, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65555, null, cls, str, th) == null) && sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), str, th);
        }
    }

    public static void i(Class<?> cls, String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65567, null, cls, str, obj, obj2) == null) && sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65586, null, cls, str, obj, obj2) == null) && sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    public static void w(Class<?> cls, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65601, null, cls, str, th) == null) && sHandler.isLoggable(5)) {
            sHandler.w(getTag(cls), str, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65609, null, cls, str, th) == null) && sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    public static void d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65541, null, cls, str, obj, obj2, obj3) == null) && sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    public static void i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65568, null, cls, str, obj, obj2, obj3) == null) && sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65587, null, cls, str, obj, obj2, obj3) == null) && isLoggable(2)) {
            v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    public static void d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{cls, str, obj, obj2, obj3, obj4}) == null) && sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    public static void i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{cls, str, obj, obj2, obj3, obj4}) == null) && sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65588, null, new Object[]{cls, str, obj, obj2, obj3, obj4}) == null) && sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65552, null, str, str2, objArr) == null) && sHandler.isLoggable(3)) {
            d(str, formatString(str2, objArr));
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65579, null, str, str2, objArr) == null) && sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, objArr));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65598, null, str, str2, objArr) == null) && sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, objArr));
        }
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65553, null, str, th, str2, objArr) == null) && sHandler.isLoggable(3)) {
            d(str, formatString(str2, objArr), th);
        }
    }

    public static void i(String str, Throwable th, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65580, null, str, th, str2, objArr) == null) && sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, objArr), th);
        }
    }

    public static void v(String str, Throwable th, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65599, null, str, th, str2, objArr) == null) && sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65544, null, cls, str, objArr) == null) && sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, objArr));
        }
    }

    public static void i(Class<?> cls, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65571, null, cls, str, objArr) == null) && sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, objArr));
        }
    }

    public static void v(Class<?> cls, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65590, null, cls, str, objArr) == null) && sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, objArr));
        }
    }

    public static void d(Class<?> cls, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, cls, th, str, objArr) == null) && sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void i(Class<?> cls, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65572, null, cls, th, str, objArr) == null) && isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void v(Class<?> cls, Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65591, null, cls, th, str, objArr) == null) && sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65551, null, str, str2, th) == null) && sHandler.isLoggable(3)) {
            sHandler.d(str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65578, null, str, str2, th) == null) && sHandler.isLoggable(4)) {
            sHandler.i(str, str2, th);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65597, null, str, str2, th) == null) && sHandler.isLoggable(2)) {
            sHandler.v(str, str2, th);
        }
    }

    public static void d(Class<?> cls, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65543, null, cls, str, th) == null) && sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), str, th);
        }
    }

    public static void i(Class<?> cls, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65570, null, cls, str, th) == null) && sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), str, th);
        }
    }

    public static void v(Class<?> cls, String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65589, null, cls, str, th) == null) && sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), str, th);
        }
    }
}
