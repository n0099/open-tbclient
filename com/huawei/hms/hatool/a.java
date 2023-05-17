package com.huawei.hms.hatool;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            j c = c(str, str2);
            return c != null ? c.a() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            j c = c(str, str2);
            return c != null && c.e();
        }
        return invokeLL.booleanValue;
    }

    public static j c(String str, String str2) {
        InterceptResult invokeLL;
        k a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            m a2 = i.c().a(str);
            if (a2 == null || (a = a2.a(str2)) == null) {
                return null;
            }
            return a.j();
        }
        return (j) invokeLL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            j c = c(str, str2);
            return c != null ? c.b() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            j c = c(str, str2);
            return c != null && c.f();
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(String str, String str2) {
        InterceptResult invokeLL;
        k a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            m a2 = i.c().a(str);
            if (a2 == null || (a = a2.a(str2)) == null) {
                return false;
            }
            return a.c();
        }
        return invokeLL.booleanValue;
    }

    public static String g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            j c = c(str, str2);
            return c != null ? c.d() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            j c = c(str, str2);
            return c != null && c.g();
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(String str, String str2) {
        InterceptResult invokeLL;
        k a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            m a2 = i.c().a(str);
            if (a2 == null || (a = a2.a(str2)) == null) {
                return false;
            }
            return a.e();
        }
        return invokeLL.booleanValue;
    }

    public static String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            j c = c(str, str2);
            return c != null ? c.c() : "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            j c = c(str, str2);
            return c != null && c.h();
        }
        return invokeLL.booleanValue;
    }
}
