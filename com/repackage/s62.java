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
import com.repackage.dj2;
import com.repackage.t62;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm1 a;

        public a(nm1 nm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s62.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755368670, "Lcom/repackage/s62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755368670, "Lcom/repackage/s62;");
                return;
            }
        }
        a = rg1.a;
        oj2.g0().getSwitch("swan_next_page_res_load", 0);
        b = false;
        hx1.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + b);
        l();
    }

    public static boolean a(@NonNull nm1<?> nm1Var, @NonNull hq2 hq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, nm1Var, hq2Var)) == null) {
            w03 f = ul2.U().f(hq2Var.d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + hq2Var.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + hq2Var.d);
            }
            return be3.S(nm1Var, f.r);
        }
        return invokeLL.booleanValue;
    }

    public static t62.a b(@NonNull h03 h03Var, @NonNull nm1<?> nm1Var, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, h03Var, nm1Var, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = dj2.e.i(str, valueOf).getPath() + File.separator;
                    t62 t62Var = new t62();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            hq2 d = hq2.d(zd3.g(str3), str2);
                            if (be3.b(h03Var.Q(), d, true) && a(nm1Var, d)) {
                                t62Var.a(f(nm1Var, d));
                            }
                        }
                    }
                    return t62Var.b();
                }
            }
            return null;
        }
        return (t62.a) invokeLLL.objValue;
    }

    public static hq2 c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        pz1 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed() || (H = ul2.U().H()) == null) {
                return null;
            }
            return H.m3();
        }
        return (hq2) invokeV.objValue;
    }

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable t62.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static t62.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (t62.a) invokeL.objValue;
    }

    public static ia2 f(nm1<?> nm1Var, hq2 hq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, nm1Var, hq2Var)) == null) ? y62.a(q33.a(nm1Var, hq2Var, "")) : (ia2) invokeLL.objValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) ? mq2.g().k(pMSAppInfo) : (JSONObject) invokeL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? dj2.C(str, str2) : invokeLL.booleanValue;
    }

    public static void i(nm1<?> nm1Var) {
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, nm1Var) == null) && b && nm1Var != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            h03 b0 = h03.b0();
            if (b0 == null || (f0 = b0.W().f0()) == null) {
                return;
            }
            t62.a e = e(f0);
            if (e == null) {
                e = b(b0, nm1Var, f0);
                d(f0, e);
            }
            if (e != null) {
                b72.U().V0(nm1Var.b(), e);
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static void j(nm1<?> nm1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, nm1Var) == null) && b && nm1Var != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            ExecutorUtilsExt.postOnElastic(new a(nm1Var), "SwanAppSlaveTopPages", 2);
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
                hq2 c = c();
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
