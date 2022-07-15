package com.repackage;

import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.vd3;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class zk2 implements ll2 {
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
            SwanAppConfigData b = t03.b(file.getAbsolutePath());
            if (ll2.a) {
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
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) al2.c().b(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                swanAppConfigData = ku2.e().j(file);
                if (swanAppConfigData == null) {
                    swanAppConfigData = a(file);
                }
                al2.c().d(file.getAbsolutePath(), swanAppConfigData);
            } else if (ll2.a) {
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
            Boolean bool = (Boolean) al2.c().b("getNightModeStateCache");
            if (bool == null) {
                return Boolean.valueOf(oj2.M().a());
            }
            if (z) {
                al2.c().e("getNightModeStateCache");
            }
            return bool;
        }
        return (Boolean) invokeZ.objValue;
    }

    public static List<vd3.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            List<vd3.a> list = (List) al2.c().b("getStorageListCache");
            if (list == null) {
                List<vd3.a> d = vd3.d();
                al2.c().d("getStorageListCache", d);
                return d;
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public static void e(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bool) == null) {
            al2.c().d("getNightModeStateCache", bool);
        }
    }
}
