package com.tencent.mm.opensdk.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class Log {
    public static /* synthetic */ Interceptable $ic;
    public static ILog logImpl;
    public transient /* synthetic */ FieldHolder $fh;

    public Log() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            ILog iLog = logImpl;
            if (iLog == null) {
                android.util.Log.d(str, str2);
            } else {
                iLog.d(str, str2);
            }
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            ILog iLog = logImpl;
            if (iLog == null) {
                android.util.Log.e(str, str2);
            } else {
                iLog.e(str, str2);
            }
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            ILog iLog = logImpl;
            if (iLog == null) {
                android.util.Log.i(str, str2);
            } else {
                iLog.i(str, str2);
            }
        }
    }

    public static void setLogImpl(ILog iLog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iLog) == null) {
            logImpl = iLog;
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            ILog iLog = logImpl;
            if (iLog == null) {
                android.util.Log.v(str, str2);
            } else {
                iLog.v(str, str2);
            }
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            ILog iLog = logImpl;
            if (iLog == null) {
                android.util.Log.w(str, str2);
            } else {
                iLog.w(str, str2);
            }
        }
    }
}
