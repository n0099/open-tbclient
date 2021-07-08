package com.qq.e.comm.util;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class GDTLogger {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG_ENABLE = false;
    public transient /* synthetic */ FieldHolder $fh;

    public GDTLogger() {
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

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            Log.e("gdt_ad_mob", str);
        }
    }

    public static void e(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, th) == null) {
            if (th == null) {
                Log.e("gdt_ad_mob", str);
            } else {
                Log.e("gdt_ad_mob", str, th);
            }
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            Log.i("gdt_ad_mob", str);
        }
    }

    public static void report(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            report(str, null);
        }
    }

    public static void report(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, th) == null) {
            e(str, th);
            com.qq.e.comm.services.a.a();
            com.qq.e.comm.services.a.a(str, th);
        }
    }

    public static void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            Log.e("gdt_ad_mob", str);
        }
    }

    public static void w(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, th) == null) {
            if (th == null) {
                Log.w("gdt_ad_mob", str);
            } else {
                Log.w("gdt_ad_mob", str, th);
            }
        }
    }
}
