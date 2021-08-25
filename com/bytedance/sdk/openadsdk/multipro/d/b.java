package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> f67949a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str : (String) invokeL.objValue;
    }

    public static void b(String str) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference;
        Map<String, Object> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, str) == null) || (softReference = f67949a) == null || softReference.get() == null || (map = f67949a.get().get(a(str))) == null) {
            return;
        }
        map.clear();
    }

    public static SharedPreferences c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            return context.getSharedPreferences(a(str), 0);
        }
        return (SharedPreferences) invokeLL.objValue;
    }

    public static Object a(String str, String str2) {
        InterceptResult invokeLL;
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f67949a;
            if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(a(str))) == null) {
                return null;
            }
            return map.get(str2);
        }
        return invokeLL.objValue;
    }

    public static String c(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, null, context, str, str2, str3)) == null) {
            SharedPreferences c2 = c(context, str);
            return c2 == null ? str3 : c2.getString(str2, str3);
        }
        return (String) invokeLLLL.objValue;
    }

    public static Object b(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, context, str, str2, str3)) == null) {
            String a2 = a(str);
            if (a(context, a2, str2)) {
                if (str3.equalsIgnoreCase("string")) {
                    return c(context, a2, str2, null);
                }
                if (str3.equalsIgnoreCase("boolean")) {
                    return Boolean.valueOf(a(context, a2, str2, false));
                }
                if (str3.equalsIgnoreCase("int")) {
                    return Integer.valueOf(a(context, a2, str2, 0));
                }
                if (str3.equalsIgnoreCase("long")) {
                    return Long.valueOf(a(context, a2, str2, 0L));
                }
                if (str3.equalsIgnoreCase(ShaderParams.VALUE_TYPE_FLOAT)) {
                    return Float.valueOf(a(context, a2, str2, 0.0f));
                }
                if (str3.equalsIgnoreCase("string_set")) {
                    return c(context, a2, str2, null);
                }
                return null;
            }
            return null;
        }
        return invokeLLLL.objValue;
    }

    public static void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, obj) == null) {
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = f67949a;
            if (softReference == null || softReference.get() == null) {
                f67949a = new SoftReference<>(new ConcurrentHashMap());
            }
            String a2 = a(str);
            ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = f67949a.get();
            if (concurrentHashMap.get(a2) == null) {
                concurrentHashMap.put(a2, new HashMap());
            }
            concurrentHashMap.get(a2).put(str2, obj);
        }
    }

    public static synchronized <T> void a(Context context, String str, String str2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, context, str, str2, t) == null) {
            synchronized (b.class) {
                SharedPreferences c2 = c(context, str);
                if (c2 == null) {
                    return;
                }
                if (t.equals(a(str, str2))) {
                    return;
                }
                SharedPreferences.Editor edit = c2.edit();
                if (t instanceof Boolean) {
                    edit.putBoolean(str2, ((Boolean) t).booleanValue());
                }
                if (t instanceof String) {
                    edit.putString(str2, (String) t);
                }
                if (t instanceof Integer) {
                    edit.putInt(str2, ((Integer) t).intValue());
                }
                if (t instanceof Long) {
                    edit.putLong(str2, ((Long) t).longValue());
                }
                if (t instanceof Float) {
                    edit.putFloat(str2, ((Float) t).floatValue());
                }
                edit.apply();
                a(str, str2, t);
            }
        }
    }

    public static void b(Context context, String str, String str2) {
        Map<String, Object> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, str, str2) == null) {
            try {
                SharedPreferences c2 = c(context, str);
                if (c2 == null) {
                    return;
                }
                SharedPreferences.Editor edit = c2.edit();
                edit.remove(str2);
                edit.apply();
                if (f67949a == null || f67949a.get() == null) {
                    return;
                }
                String a2 = a(str);
                if (!TextUtils.isEmpty(a2) && (map = f67949a.get().get(a2)) != null && map.size() != 0) {
                    map.remove(str2);
                    if (f67949a == null || f67949a.get() == null) {
                        return;
                    }
                    f67949a.get().put(a2, map);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, ?> b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) ? c(context, str).getAll() : (Map) invokeLL.objValue;
    }

    public static String a(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, str3)) == null) {
            Object a2 = a(str, str2);
            if (a2 != null) {
                return a2 + "";
            }
            Object b2 = b(context, str, str2, str3);
            a(str, str2, b2);
            return b2 + "";
        }
        return (String) invokeLLLL.objValue;
    }

    public static int a(Context context, String str, String str2, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65537, null, context, str, str2, i2)) == null) {
            SharedPreferences c2 = c(context, str);
            return c2 == null ? i2 : c2.getInt(str2, i2);
        }
        return invokeLLLI.intValue;
    }

    public static float a(Context context, String str, String str2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, str, str2, Float.valueOf(f2)})) == null) {
            SharedPreferences c2 = c(context, str);
            return c2 == null ? f2 : c2.getFloat(str2, f2);
        }
        return invokeCommon.floatValue;
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) {
            SharedPreferences c2 = c(context, str);
            return c2 == null ? z : c2.getBoolean(str2, z);
        }
        return invokeCommon.booleanValue;
    }

    public static long a(Context context, String str, String str2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, str2, Long.valueOf(j2)})) == null) {
            SharedPreferences c2 = c(context, str);
            return c2 == null ? j2 : c2.getLong(str2, j2);
        }
        return invokeCommon.longValue;
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, str, str2)) == null) {
            SharedPreferences c2 = c(context, str);
            return c2 != null && c2.contains(str2);
        }
        return invokeLLL.booleanValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str) == null) {
            SharedPreferences.Editor edit = c(context, str).edit();
            edit.clear();
            edit.apply();
            b(str);
        }
    }
}
