package com.heytap.mcssdk.utils;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class LogUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "mcssdk---";
    public static boolean sD = true;
    public static boolean sE = true;
    public static boolean sI = false;
    public static boolean sIsDebug = true;
    public static String sSeparator = "-->";
    public static boolean sV = false;
    public static boolean sW = true;
    public static String special = "MCS";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1971801911, "Lcom/heytap/mcssdk/utils/LogUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1971801911, "Lcom/heytap/mcssdk/utils/LogUtil;");
        }
    }

    public LogUtil() {
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

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && sD && sIsDebug) {
            Log.d(TAG, special + sSeparator + str);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && sD && sIsDebug) {
            Log.d(str, special + sSeparator + str2);
        }
    }

    public static void e(Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, exc) == null) && sE) {
            exc.printStackTrace();
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, str) == null) && sE && sIsDebug) {
            Log.e(TAG, special + sSeparator + str);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) && sE && sIsDebug) {
            Log.e(str, special + sSeparator + str2);
        }
    }

    public static void e(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, str, th) == null) && sE) {
            Log.e(str, th.toString());
        }
    }

    public static String getSeprateor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? sSeparator : (String) invokeV.objValue;
    }

    public static String getSpecial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? special : (String) invokeV.objValue;
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, str) == null) && sI && sIsDebug) {
            Log.i(TAG, special + sSeparator + str);
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) && sI && sIsDebug) {
            Log.i(str, special + sSeparator + str2);
        }
    }

    public static boolean isD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? sD : invokeV.booleanValue;
    }

    public static boolean isDebugs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? sIsDebug : invokeV.booleanValue;
    }

    public static boolean isE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? sE : invokeV.booleanValue;
    }

    public static boolean isI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? sI : invokeV.booleanValue;
    }

    public static boolean isV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? sV : invokeV.booleanValue;
    }

    public static boolean isW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? sW : invokeV.booleanValue;
    }

    public static void setD(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            sD = z;
        }
    }

    public static void setDebugs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, null, z) == null) {
            sIsDebug = z;
            boolean z2 = z;
            sV = z2;
            sD = z2;
            sI = z2;
            sW = z2;
            sE = z2;
        }
    }

    public static void setE(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65556, null, z) == null) {
            sE = z;
        }
    }

    public static void setI(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
            sI = z;
        }
    }

    public static void setSeprateor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            sSeparator = str;
        }
    }

    public static void setSpecial(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            special = str;
        }
    }

    public static void setV(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
            sV = z;
        }
    }

    public static void setW(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, null, z) == null) {
            sW = z;
        }
    }

    public static void v(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65562, null, str) == null) && sV && sIsDebug) {
            Log.v(TAG, special + sSeparator + str);
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65563, null, str, str2) == null) && sV && sIsDebug) {
            Log.v(str, special + sSeparator + str2);
        }
    }

    public static void w(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, str) == null) && sW && sIsDebug) {
            Log.w(TAG, special + sSeparator + str);
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65565, null, str, str2) == null) && sW && sIsDebug) {
            Log.w(str, special + sSeparator + str2);
        }
    }
}
