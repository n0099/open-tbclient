package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.fj2;
import java.io.File;
/* loaded from: classes5.dex */
public class cy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fj2.g a(gl2 gl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gl2Var)) == null) {
            File e = e();
            fj2.M(b(), e, gl2Var);
            fj2.g gVar = new fj2.g();
            File file = new File(e, "app.json");
            SwanAppConfigData b = v03.b(e.getAbsolutePath());
            gVar.a = e.getPath() + File.separator;
            gVar.b = b;
            jx1.k("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + gVar.a);
            return gVar;
        }
        return (fj2.g) invokeL.objValue;
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new File(c(), "wireless_debug.aiapps") : (File) invokeV.objValue;
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_wireless_debug_zip";
        }
        return (String) invokeV.objValue;
    }

    public static File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_wireless_debug";
        }
        return (String) invokeV.objValue;
    }
}
