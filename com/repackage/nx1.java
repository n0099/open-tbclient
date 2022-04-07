package com.repackage;

import android.os.Environment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.fj2;
import java.io.File;
/* loaded from: classes6.dex */
public class nx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fj2.g a(gl2 gl2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gl2Var)) == null) {
            File file = new File(Environment.getExternalStorageDirectory() + "/" + ox1.d());
            fj2.M(file, b(), gl2Var);
            ng4.j(file);
            fj2.g gVar = new fj2.g();
            File file2 = new File(b(), "app.json");
            SwanAppConfigData c = SwanAppConfigData.c(ng4.E(file2), b());
            gVar.a = b().getPath() + File.separator;
            gVar.b = c;
            jx1.k("ADBDebugBundleHelper", "configFile path: " + file2.getPath() + " exist: " + file2.exists() + " info.mAppBundlePath path: " + gVar.a);
            return gVar;
        }
        return (fj2.g) invokeL.objValue;
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
