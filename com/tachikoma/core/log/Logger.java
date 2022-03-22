package com.tachikoma.core.log;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.Tachikoma;
/* loaded from: classes7.dex */
public class Logger {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "tachikoma";
    public static boolean enableLog;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-380180630, "Lcom/tachikoma/core/log/Logger;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-380180630, "Lcom/tachikoma/core/log/Logger;");
        }
    }

    public Logger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || enableLog) {
            return;
        }
        if (Tachikoma.getInstance().logger() != null) {
            Tachikoma.getInstance().logger().d(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static String getStackTraceString(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) ? Tachikoma.getInstance().logger() != null ? Tachikoma.getInstance().logger().getStackTraceString(th) : Log.getStackTraceString(th) : (String) invokeL.objValue;
    }

    public static void logE(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, th) == null) && enableLog) {
            if (Tachikoma.getInstance().logger() != null) {
                Tachikoma.getInstance().logger().e(TAG, str, th);
            } else {
                Log.e(TAG, str, th);
            }
        }
    }

    public static void setShowLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            enableLog = enableLog || z;
        }
    }
}
