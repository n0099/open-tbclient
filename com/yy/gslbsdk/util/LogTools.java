package com.yy.gslbsdk.util;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.GslbEvent;
import java.util.Locale;
/* loaded from: classes4.dex */
public class LogTools {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1825928579, "Lcom/yy/gslbsdk/util/LogTools;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1825928579, "Lcom/yy/gslbsdk/util/LogTools;");
                return;
            }
        }
        TAG = GlobalTools.LOG_TAG + "-2.2.18-lianyun";
    }

    public LogTools() {
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

    public static void printDebug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (GlobalTools.LOG_IS_OPEN) {
            String.format(Locale.US, "[%s] %s", str, str2);
        }
        printMsgEvent("debug", str, str2);
    }

    public static void printError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (GlobalTools.LOG_IS_OPEN) {
            String.format(Locale.US, "[%s] %s", str, str2);
        }
        printMsgEvent("error", str, str2);
    }

    public static void printInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (GlobalTools.LOG_IS_OPEN) {
            String.format(Locale.US, "[%s] %s", str, str2);
        }
        printMsgEvent("info", str, str2);
    }

    public static void printMsgEvent(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, str2, str3) == null) {
            GslbEvent.INSTANCE.onMessage(String.format(Locale.US, " [%s][%s][%s] %s", str, TAG, str2, str3));
        }
    }

    public static void printWarning(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, str, exc) == null) || exc == null) {
            return;
        }
        if (GlobalTools.LOG_IS_OPEN) {
            String.format(Locale.US, "[%s] %s", str, exc);
        }
        printMsgEvent("warn", str, exc.getLocalizedMessage());
    }

    public static void printWarning(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (GlobalTools.LOG_IS_OPEN) {
            String.format(Locale.US, "[%s] %s", str, str2);
        }
        printMsgEvent("warn", str, str2);
    }
}
