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
import com.repackage.fj2;
import com.repackage.v62;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pm1 a;

        public a(pm1 pm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pm1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u62.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755309088, "Lcom/repackage/u62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755309088, "Lcom/repackage/u62;");
                return;
            }
        }
        a = tg1.a;
        qj2.g0().getSwitch("swan_next_page_res_load", 0);
        b = false;
        jx1.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + b);
        l();
    }

    public static boolean a(@NonNull pm1<?> pm1Var, @NonNull jq2 jq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pm1Var, jq2Var)) == null) {
            y03 f = wl2.U().f(jq2Var.d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + jq2Var.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + jq2Var.d);
            }
            return de3.S(pm1Var, f.r);
        }
        return invokeLL.booleanValue;
    }

    public static v62.a b(@NonNull j03 j03Var, @NonNull pm1<?> pm1Var, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, j03Var, pm1Var, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = fj2.e.i(str, valueOf).getPath() + File.separator;
                    v62 v62Var = new v62();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            jq2 d = jq2.d(be3.g(str3), str2);
                            if (de3.b(j03Var.P(), d, true) && a(pm1Var, d)) {
                                v62Var.a(f(pm1Var, d));
                            }
                        }
                    }
                    return v62Var.b();
                }
            }
            return null;
        }
        return (v62.a) invokeLLL.objValue;
    }

    public static jq2 c() {
        InterceptResult invokeV;
        SwanAppActivity x;
        rz1 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            j03 a0 = j03.a0();
            if (a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed() || (H = wl2.U().H()) == null) {
                return null;
            }
            return H.l3();
        }
        return (jq2) invokeV.objValue;
    }

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable v62.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static v62.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (v62.a) invokeL.objValue;
    }

    public static ka2 f(pm1<?> pm1Var, jq2 jq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, pm1Var, jq2Var)) == null) ? a72.a(s33.a(pm1Var, jq2Var, "")) : (ka2) invokeLL.objValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) ? oq2.g().k(pMSAppInfo) : (JSONObject) invokeL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? fj2.C(str, str2) : invokeLL.booleanValue;
    }

    public static void i(pm1<?> pm1Var) {
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, pm1Var) == null) && b && pm1Var != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            j03 a0 = j03.a0();
            if (a0 == null || (f0 = a0.V().f0()) == null) {
                return;
            }
            v62.a e = e(f0);
            if (e == null) {
                e = b(a0, pm1Var, f0);
                d(f0, e);
            }
            if (e != null) {
                d72.U().V0(pm1Var.c(), e);
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static void j(pm1<?> pm1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, pm1Var) == null) && b && pm1Var != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            ExecutorUtilsExt.postOnElastic(new a(pm1Var), "SwanAppSlaveTopPages", 2);
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
                jq2 c = c();
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
