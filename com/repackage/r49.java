package com.repackage;

import android.content.Context;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        g59 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65536, null) == null) || (c = m59.c()) == null) {
            return;
        }
        c.b();
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            e59 a = m59.a();
            if (a != null) {
                return a.getAppContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            e59 a = m59.a();
            return a != null ? a.c(str) : str;
        }
        return (String) invokeL.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            e59 a = m59.a();
            if (a != null) {
                return a.d();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static IBinder e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            g59 c = m59.c();
            if (c != null) {
                return c.a(str);
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    public static int f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i)) == null) {
            e59 a = m59.a();
            return a != null ? a.getInt(str, i) : i;
        }
        return invokeLI.intValue;
    }

    public static long g(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, str, j)) == null) {
            e59 a = m59.a();
            return a != null ? a.getLong(str, j) : j;
        }
        return invokeLJ.longValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            e59 a = m59.a();
            return a != null ? a.e(str) : str;
        }
        return (String) invokeL.objValue;
    }

    public static g49 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? m59.e() : (g49) invokeV.objValue;
    }

    public static k49 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? m59.f() : (k49) invokeV.objValue;
    }

    public static String k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) {
            e59 a = m59.a();
            return a != null ? a.b(z) : "";
        }
        return (String) invokeZ.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            f59 b = m59.b();
            if (b != null) {
                return b.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            e59 a = m59.a();
            if (a != null) {
                return a.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void n(String str, int i) {
        e59 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65549, null, str, i) == null) || (a = m59.a()) == null) {
            return;
        }
        a.putInt(str, i);
    }

    public static void o(String str, long j) {
        e59 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65550, null, str, j) == null) || (a = m59.a()) == null) {
            return;
        }
        a.putLong(str, j);
    }

    public static void p(String str, String str2) {
        e59 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) || (a = m59.a()) == null) {
            return;
        }
        a.putString(str, str2);
    }

    public static void q(int i) {
        e59 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65552, null, i) == null) || (a = m59.a()) == null) {
            return;
        }
        a.a(i);
    }
}
