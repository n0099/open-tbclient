package com.repackage;

import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.gd3;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class kk2 implements wk2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SwanAppConfigData a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            SwanAppConfigData b = e03.b(file.getAbsolutePath());
            if (wk2.a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("buildAppJsonConfig cost = ");
                sb.append(currentTimeMillis2 - currentTimeMillis);
                sb.append("ms ; current thread is main = ");
                sb.append(Looper.getMainLooper() == Looper.myLooper());
                sb.append(" ; path = ");
                sb.append(file);
                Log.d("SwanPerformance", sb.toString());
            }
            return b;
        }
        return (SwanAppConfigData) invokeL.objValue;
    }

    public static SwanAppConfigData b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) lk2.c().b(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                swanAppConfigData = vt2.e().j(file);
                if (swanAppConfigData == null) {
                    swanAppConfigData = a(file);
                }
                lk2.c().d(file.getAbsolutePath(), swanAppConfigData);
            } else if (wk2.a) {
                Log.d("SwanPerformance", "adopt cached app.json");
            }
            return swanAppConfigData;
        }
        return (SwanAppConfigData) invokeL.objValue;
    }

    public static Boolean c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            Boolean bool = (Boolean) lk2.c().b("getNightModeStateCache");
            if (bool == null) {
                return Boolean.valueOf(zi2.M().a());
            }
            if (z) {
                lk2.c().e("getNightModeStateCache");
            }
            return bool;
        }
        return (Boolean) invokeZ.objValue;
    }

    public static List<gd3.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            List<gd3.a> list = (List) lk2.c().b("getStorageListCache");
            if (list == null) {
                List<gd3.a> d = gd3.d();
                lk2.c().d("getStorageListCache", d);
                return d;
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public static void e(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bool) == null) {
            lk2.c().d("getNightModeStateCache", bool);
        }
    }
}
