package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.dj2;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class aw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755842443, "Lcom/repackage/aw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755842443, "Lcom/repackage/aw2;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = dj2.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                g94 g94Var = new g94();
                g94Var.g = str;
                g94Var.i = -1L;
                c84.i().f(g94Var);
            }
        }
        dj2.e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = dj2.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<g94> q = ov2.q(str);
        for (String str2 : list) {
            long j = -1;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e) {
                if (a) {
                    zv2.b(Log.getStackTraceString(e));
                }
            }
            if (!c(j, q)) {
                jg4.L(dj2.t(str, str2));
                zv2.b("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        g94 g94Var = null;
        if (q != null) {
            if (q.size() == 1) {
                g94Var = q.get(0);
            } else if (q.size() >= 2) {
                g94Var = q.get(1);
            }
        }
        if (g94Var != null) {
            c84.i().f(g94Var);
        }
    }

    public static boolean c(long j, List<g94> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    g94 g94Var = list.get(i);
                    if (g94Var != null && (j == g94Var.i || j == wd3.c(g94Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
