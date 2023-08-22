package com.huawei.hms.hatool;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes10.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        k h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) || (h = h(str, str2)) == null) {
            return;
        }
        h.a(j);
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            k h = h(str, str2);
            if (h != null) {
                return h.a();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static int b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            k h = h(str, str2);
            if (h != null) {
                return h.d();
            }
            return 7;
        }
        return invokeLL.intValue;
    }

    public static boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            k h = h(str, str2);
            if (h != null) {
                return h.g();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            k h = h(str, str2);
            return h != null ? h.f() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            k h = h(str, str2);
            if (h != null) {
                return h.i();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            k h = h(str, str2);
            return h != null ? h.h() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static String g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            k h = h(str, str2);
            return h != null ? h.n() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static k h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            m a = i.c().a(str);
            if (a != null) {
                if ("alltype".equals(str2)) {
                    k a2 = a.a("oper");
                    return a2 == null ? a.a("maint") : a2;
                }
                return a.a(str2);
            }
            return null;
        }
        return (k) invokeLL.objValue;
    }

    public static Map<String, String> i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            k h = h(str, str2);
            if (h != null) {
                return h.k();
            }
            return null;
        }
        return (Map) invokeLL.objValue;
    }

    public static long j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            k h = h(str, str2);
            if (h != null) {
                return h.l();
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    public static int k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            k h = h(str, str2);
            if (h != null) {
                return h.b();
            }
            return 10;
        }
        return invokeLL.intValue;
    }

    public static String l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            k h = h(str, str2);
            return h != null ? h.o() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static String m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            k h = h(str, str2);
            return h != null ? h.q() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static String n(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            k h = h(str, str2);
            return h != null ? h.m() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static String o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) {
            k h = h(str, str2);
            return h != null ? h.p() : "";
        }
        return (String) invokeLL.objValue;
    }
}
