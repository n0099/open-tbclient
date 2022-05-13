package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.qj2;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class nw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755455160, "Lcom/repackage/nw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755455160, "Lcom/repackage/nw2;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = qj2.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                t94 t94Var = new t94();
                t94Var.g = str;
                t94Var.i = -1L;
                p84.i().f(t94Var);
            }
        }
        qj2.e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = qj2.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<t94> q = bw2.q(str);
        for (String str2 : list) {
            long j = -1;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e) {
                if (a) {
                    mw2.b(Log.getStackTraceString(e));
                }
            }
            if (!c(j, q)) {
                xg4.L(qj2.t(str, str2));
                mw2.b("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        t94 t94Var = null;
        if (q != null) {
            if (q.size() == 1) {
                t94Var = q.get(0);
            } else if (q.size() >= 2) {
                t94Var = q.get(1);
            }
        }
        if (t94Var != null) {
            p84.i().f(t94Var);
        }
    }

    public static boolean c(long j, List<t94> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    t94 t94Var = list.get(i);
                    if (t94Var != null && (j == t94Var.i || j == je3.c(t94Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
