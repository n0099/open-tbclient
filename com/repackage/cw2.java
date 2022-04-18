package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.fj2;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class cw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755782861, "Lcom/repackage/cw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755782861, "Lcom/repackage/cw2;");
                return;
            }
        }
        a = tg1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = fj2.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                i94 i94Var = new i94();
                i94Var.g = str;
                i94Var.i = -1L;
                e84.i().f(i94Var);
            }
        }
        fj2.e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = fj2.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<i94> q = qv2.q(str);
        for (String str2 : list) {
            long j = -1;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e) {
                if (a) {
                    bw2.b(Log.getStackTraceString(e));
                }
            }
            if (!c(j, q)) {
                mg4.L(fj2.t(str, str2));
                bw2.b("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        i94 i94Var = null;
        if (q != null) {
            if (q.size() == 1) {
                i94Var = q.get(0);
            } else if (q.size() >= 2) {
                i94Var = q.get(1);
            }
        }
        if (i94Var != null) {
            e84.i().f(i94Var);
        }
    }

    public static boolean c(long j, List<i94> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    i94 i94Var = list.get(i);
                    if (i94Var != null && (j == i94Var.i || j == yd3.c(i94Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
