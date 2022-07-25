package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ej2;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class bw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755812652, "Lcom/repackage/bw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755812652, "Lcom/repackage/bw2;");
                return;
            }
        }
        a = sg1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = ej2.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                h94 h94Var = new h94();
                h94Var.g = str;
                h94Var.i = -1L;
                d84.i().f(h94Var);
            }
        }
        ej2.e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = ej2.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<h94> q = pv2.q(str);
        for (String str2 : list) {
            long j = -1;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e) {
                if (a) {
                    aw2.b(Log.getStackTraceString(e));
                }
            }
            if (!c(j, q)) {
                kg4.L(ej2.t(str, str2));
                aw2.b("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        h94 h94Var = null;
        if (q != null) {
            if (q.size() == 1) {
                h94Var = q.get(0);
            } else if (q.size() >= 2) {
                h94Var = q.get(1);
            }
        }
        if (h94Var != null) {
            d84.i().f(h94Var);
        }
    }

    public static boolean c(long j, List<h94> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    h94 h94Var = list.get(i);
                    if (h94Var != null && (j == h94Var.i || j == xd3.c(h94Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
