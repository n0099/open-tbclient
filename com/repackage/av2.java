package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.di2;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class av2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755843404, "Lcom/repackage/av2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755843404, "Lcom/repackage/av2;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = di2.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                g84 g84Var = new g84();
                g84Var.g = str;
                g84Var.i = -1L;
                c74.i().f(g84Var);
            }
        }
        di2.e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = di2.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<g84> q = ou2.q(str);
        for (String str2 : list) {
            long j = -1;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e) {
                if (a) {
                    zu2.b(Log.getStackTraceString(e));
                }
            }
            if (!c(j, q)) {
                kf4.L(di2.t(str, str2));
                zu2.b("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        g84 g84Var = null;
        if (q != null) {
            if (q.size() == 1) {
                g84Var = q.get(0);
            } else if (q.size() >= 2) {
                g84Var = q.get(1);
            }
        }
        if (g84Var != null) {
            c74.i().f(g84Var);
        }
    }

    public static boolean c(long j, List<g84> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    g84 g84Var = list.get(i);
                    if (g84Var != null && (j == g84Var.i || j == wc3.c(g84Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
