package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.vj2;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class sw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755306205, "Lcom/repackage/sw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755306205, "Lcom/repackage/sw2;");
                return;
            }
        }
        a = jh1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = vj2.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                y94 y94Var = new y94();
                y94Var.g = str;
                y94Var.i = -1L;
                u84.i().f(y94Var);
            }
        }
        vj2.e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = vj2.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<y94> q = gw2.q(str);
        for (String str2 : list) {
            long j = -1;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e) {
                if (a) {
                    rw2.b(Log.getStackTraceString(e));
                }
            }
            if (!c(j, q)) {
                bh4.L(vj2.t(str, str2));
                rw2.b("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        y94 y94Var = null;
        if (q != null) {
            if (q.size() == 1) {
                y94Var = q.get(0);
            } else if (q.size() >= 2) {
                y94Var = q.get(1);
            }
        }
        if (y94Var != null) {
            u84.i().f(y94Var);
        }
    }

    public static boolean c(long j, List<y94> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    y94 y94Var = list.get(i);
                    if (y94Var != null && (j == y94Var.i || j == oe3.c(y94Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
