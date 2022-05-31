package com.repackage;

import android.os.Environment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.di2;
import java.io.File;
/* loaded from: classes6.dex */
public class lw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static di2.g a(ek2 ek2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ek2Var)) == null) {
            File file = new File(Environment.getExternalStorageDirectory() + "/" + mw1.d());
            di2.M(file, b(), ek2Var);
            kf4.j(file);
            di2.g gVar = new di2.g();
            File file2 = new File(b(), "app.json");
            SwanAppConfigData c = SwanAppConfigData.c(kf4.E(file2), b());
            gVar.a = b().getPath() + File.separator;
            gVar.b = c;
            hw1.k("ADBDebugBundleHelper", "configFile path: " + file2.getPath() + " exist: " + file2.exists() + " info.mAppBundlePath path: " + gVar.a);
            return gVar;
        }
        return (di2.g) invokeL.objValue;
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_adb_debug";
        }
        return (String) invokeV.objValue;
    }
}
