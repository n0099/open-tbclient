package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g72;
import com.repackage.qj2;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ an1 a;

        public a(an1 an1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = an1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f72.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755754992, "Lcom/repackage/f72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755754992, "Lcom/repackage/f72;");
                return;
            }
        }
        a = eh1.a;
        bk2.g0().getSwitch("swan_next_page_res_load", 0);
        b = false;
        ux1.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + b);
        l();
    }

    public static boolean a(@NonNull an1<?> an1Var, @NonNull uq2 uq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, an1Var, uq2Var)) == null) {
            j13 f = hm2.U().f(uq2Var.d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + uq2Var.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + uq2Var.d);
            }
            return oe3.S(an1Var, f.r);
        }
        return invokeLL.booleanValue;
    }

    public static g72.a b(@NonNull u03 u03Var, @NonNull an1<?> an1Var, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, u03Var, an1Var, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = qj2.e.i(str, valueOf).getPath() + File.separator;
                    g72 g72Var = new g72();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            uq2 d = uq2.d(me3.g(str3), str2);
                            if (oe3.b(u03Var.P(), d, true) && a(an1Var, d)) {
                                g72Var.a(f(an1Var, d));
                            }
                        }
                    }
                    return g72Var.b();
                }
            }
            return null;
        }
        return (g72.a) invokeLLL.objValue;
    }

    public static uq2 c() {
        InterceptResult invokeV;
        SwanAppActivity x;
        c02 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            u03 a0 = u03.a0();
            if (a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed() || (H = hm2.U().H()) == null) {
                return null;
            }
            return H.l3();
        }
        return (uq2) invokeV.objValue;
    }

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable g72.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static g72.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (g72.a) invokeL.objValue;
    }

    public static va2 f(an1<?> an1Var, uq2 uq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, an1Var, uq2Var)) == null) ? l72.a(d43.a(an1Var, uq2Var, "")) : (va2) invokeLL.objValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) ? zq2.g().k(pMSAppInfo) : (JSONObject) invokeL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? qj2.C(str, str2) : invokeLL.booleanValue;
    }

    public static void i(an1<?> an1Var) {
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, an1Var) == null) && b && an1Var != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            u03 a0 = u03.a0();
            if (a0 == null || (f0 = a0.V().f0()) == null) {
                return;
            }
            g72.a e = e(f0);
            if (e == null) {
                e = b(a0, an1Var, f0);
                d(f0, e);
            }
            if (e != null) {
                o72.U().V0(an1Var.c(), e);
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static void j(an1<?> an1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, an1Var) == null) && b && an1Var != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            ExecutorUtilsExt.postOnElastic(new a(an1Var), "SwanAppSlaveTopPages", 2);
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg async cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static Set<String> k(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONObject)) == null) {
            if (jSONObject.length() <= 0) {
                return null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    linkedHashSet.add(next);
                }
            }
            if (a) {
                Log.d("SwanAppSlaveTopPages", "get top pages - " + linkedHashSet);
            }
            return linkedHashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
        }
    }

    public static Set<String> m(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, pMSAppInfo)) == null) {
            if (a) {
                uq2 c = c();
                Log.d("SwanAppSlaveTopPages", "current page - " + c);
            }
            JSONObject g = g(pMSAppInfo);
            if (g == null || g.length() <= 0) {
                return null;
            }
            if (a) {
                Log.d("SwanAppSlaveTopPages", "pages info - " + g);
            }
            return k(g);
        }
        return (Set) invokeL.objValue;
    }
}
