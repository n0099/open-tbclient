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
import com.repackage.ej2;
import com.repackage.u62;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om1 a;

        public a(om1 om1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = om1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t62.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755338879, "Lcom/repackage/t62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755338879, "Lcom/repackage/t62;");
                return;
            }
        }
        a = sg1.a;
        pj2.g0().getSwitch("swan_next_page_res_load", 0);
        b = false;
        ix1.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + b);
        l();
    }

    public static boolean a(@NonNull om1<?> om1Var, @NonNull iq2 iq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, om1Var, iq2Var)) == null) {
            x03 f = vl2.U().f(iq2Var.d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + iq2Var.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + iq2Var.d);
            }
            return ce3.S(om1Var, f.r);
        }
        return invokeLL.booleanValue;
    }

    public static u62.a b(@NonNull i03 i03Var, @NonNull om1<?> om1Var, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, i03Var, om1Var, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = ej2.e.i(str, valueOf).getPath() + File.separator;
                    u62 u62Var = new u62();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            iq2 d = iq2.d(ae3.g(str3), str2);
                            if (ce3.b(i03Var.Q(), d, true) && a(om1Var, d)) {
                                u62Var.a(f(om1Var, d));
                            }
                        }
                    }
                    return u62Var.b();
                }
            }
            return null;
        }
        return (u62.a) invokeLLL.objValue;
    }

    public static iq2 c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        qz1 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            i03 b0 = i03.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed() || (H = vl2.U().H()) == null) {
                return null;
            }
            return H.m3();
        }
        return (iq2) invokeV.objValue;
    }

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable u62.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static u62.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (u62.a) invokeL.objValue;
    }

    public static ja2 f(om1<?> om1Var, iq2 iq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, om1Var, iq2Var)) == null) ? z62.a(r33.a(om1Var, iq2Var, "")) : (ja2) invokeLL.objValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) ? nq2.g().k(pMSAppInfo) : (JSONObject) invokeL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? ej2.C(str, str2) : invokeLL.booleanValue;
    }

    public static void i(om1<?> om1Var) {
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, om1Var) == null) && b && om1Var != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            i03 b0 = i03.b0();
            if (b0 == null || (f0 = b0.W().f0()) == null) {
                return;
            }
            u62.a e = e(f0);
            if (e == null) {
                e = b(b0, om1Var, f0);
                d(f0, e);
            }
            if (e != null) {
                c72.U().V0(om1Var.b(), e);
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static void j(om1<?> om1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, om1Var) == null) && b && om1Var != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            ExecutorUtilsExt.postOnElastic(new a(om1Var), "SwanAppSlaveTopPages", 2);
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
                iq2 c = c();
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
