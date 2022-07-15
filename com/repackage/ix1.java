package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class ix1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new File(dj2.q(), "sConsole-core") : (File) invokeV.objValue;
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? v83.a().getLong("get_app_console_core_code", -1L) : invokeV.longValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? v83.a().getString("get_app_console_core", "-1") : (String) invokeV.objValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            e("-1", -1L);
        }
    }

    public static void e(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j) == null) {
            v83.a().putString("get_app_console_core", str);
            v83.a().putLong("get_app_console_core_code", j);
        }
    }
}
