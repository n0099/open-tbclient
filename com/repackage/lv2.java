package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.oi2;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class lv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755515703, "Lcom/repackage/lv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755515703, "Lcom/repackage/lv2;");
                return;
            }
        }
        a = cg1.a;
    }

    public static void a() {
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (list = oi2.q().list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                r84 r84Var = new r84();
                r84Var.g = str;
                r84Var.i = -1L;
                n74.i().f(r84Var);
            }
        }
        oi2.e.d();
    }

    public static void b(String str) {
        File s;
        String[] list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str) || (s = oi2.s(str)) == null || (list = s.list()) == null || list.length <= 1) {
            return;
        }
        List<r84> q = zu2.q(str);
        for (String str2 : list) {
            long j = -1;
            try {
                j = Long.parseLong(str2);
            } catch (NumberFormatException e) {
                if (a) {
                    kv2.b(Log.getStackTraceString(e));
                }
            }
            if (!c(j, q)) {
                uf4.L(oi2.t(str, str2));
                kv2.b("delete plugin name = " + str + " ; version = " + str2);
            }
        }
        r84 r84Var = null;
        if (q != null) {
            if (q.size() == 1) {
                r84Var = q.get(0);
            } else if (q.size() >= 2) {
                r84Var = q.get(1);
            }
        }
        if (r84Var != null) {
            n74.i().f(r84Var);
        }
    }

    public static boolean c(long j, List<r84> list) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, list)) == null) {
            if (j >= 0 && list != null && list.size() != 0) {
                int min = Math.min(list.size(), 2);
                for (int i = 0; i < min; i++) {
                    r84 r84Var = list.get(i);
                    if (r84Var != null && (j == r84Var.i || j == hd3.c(r84Var.j))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
