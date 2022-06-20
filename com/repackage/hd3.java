package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class hd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755652134, "Lcom/repackage/hd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755652134, "Lcom/repackage/hd3;");
                return;
            }
        }
        a = cg1.a;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? b(str) > b(str2) : invokeLL.booleanValue;
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String[] g = g(str);
            if (g == null) {
                return 0L;
            }
            long j = 0;
            for (int i = 0; i < g.length; i++) {
                try {
                    j += Integer.parseInt(g[i]) * ((long) Math.pow(1000.0d, (g.length - i) - 1));
                } catch (NumberFormatException e) {
                    sw1.l("SwanAppSwanCoreUtils", "getVersionCode exception", e);
                    return 0L;
                }
            }
            sw1.b("SwanAppSwanCoreUtils", "getVersion version: ", str, " ,versionCode: ", Long.valueOf(j));
            return j;
        }
        return invokeL.longValue;
    }

    public static long c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String[] g = g(str);
            if (g == null) {
                return 0L;
            }
            int i = 0;
            long j = 0;
            while (i < 3) {
                try {
                    j = (j << 16) | (i < g.length ? Integer.parseInt(g[i]) : 0L);
                    i++;
                } catch (NumberFormatException e) {
                    if (a) {
                        throw e;
                    }
                    return 0L;
                }
            }
            if (a) {
                Log.d("SwanAppSwanCoreUtils", "getVersion version: " + str + " ,versionCode: " + j);
            }
            return j;
        }
        return invokeL.longValue;
    }

    public static String d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j)) == null) {
            if (j < 0) {
                sw1.k("SwanAppSwanCoreUtils", "versionCode < 0, versionCode = " + j);
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            long j2 = j;
            for (int i = 2; i >= 0; i--) {
                if (i > 0) {
                    long pow = (long) Math.pow(1000.0d, i);
                    sb.append(j2 / pow);
                    sb.append(".");
                    j2 %= pow;
                } else {
                    sb.append(j2);
                }
            }
            String sb2 = sb.toString();
            sw1.b("SwanAppSwanCoreUtils", "getVersionName version code: ", Long.valueOf(j), " ,version name: ", sb2);
            return sb2;
        }
        return (String) invokeJ.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            return file.isDirectory() && (list = file.list()) != null && list.length > 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            long b = b(str);
            SwanCoreVersion d0 = m62.U().d0();
            return (d0 != null ? b(d0.swanCoreVersionName) : 0L) < b;
        }
        return invokeL.booleanValue;
    }

    public static String[] g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            if (split.length != 3) {
                return null;
            }
            return split;
        }
        return (String[]) invokeL.objValue;
    }
}
