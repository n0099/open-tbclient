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
import com.repackage.di2;
import com.repackage.t52;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class s52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl1 a;

        public a(nl1 nl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s52.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755369631, "Lcom/repackage/s52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755369631, "Lcom/repackage/s52;");
                return;
            }
        }
        a = rf1.a;
        oi2.g0().getSwitch("swan_next_page_res_load", 0);
        b = false;
        hw1.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + b);
        l();
    }

    public static boolean a(@NonNull nl1<?> nl1Var, @NonNull hp2 hp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, nl1Var, hp2Var)) == null) {
            wz2 f = uk2.U().f(hp2Var.d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + hp2Var.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + hp2Var.d);
            }
            return bd3.S(nl1Var, f.r);
        }
        return invokeLL.booleanValue;
    }

    public static t52.a b(@NonNull hz2 hz2Var, @NonNull nl1<?> nl1Var, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, hz2Var, nl1Var, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = di2.e.i(str, valueOf).getPath() + File.separator;
                    t52 t52Var = new t52();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            hp2 d = hp2.d(zc3.g(str3), str2);
                            if (bd3.b(hz2Var.P(), d, true) && a(nl1Var, d)) {
                                t52Var.a(f(nl1Var, d));
                            }
                        }
                    }
                    return t52Var.b();
                }
            }
            return null;
        }
        return (t52.a) invokeLLL.objValue;
    }

    public static hp2 c() {
        InterceptResult invokeV;
        SwanAppActivity x;
        py1 H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            hz2 a0 = hz2.a0();
            if (a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed() || (H = uk2.U().H()) == null) {
                return null;
            }
            return H.l3();
        }
        return (hp2) invokeV.objValue;
    }

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable t52.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static t52.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (t52.a) invokeL.objValue;
    }

    public static i92 f(nl1<?> nl1Var, hp2 hp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, nl1Var, hp2Var)) == null) ? y52.a(q23.a(nl1Var, hp2Var, "")) : (i92) invokeLL.objValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) ? mp2.g().k(pMSAppInfo) : (JSONObject) invokeL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? di2.C(str, str2) : invokeLL.booleanValue;
    }

    public static void i(nl1<?> nl1Var) {
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, nl1Var) == null) && b && nl1Var != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            hz2 a0 = hz2.a0();
            if (a0 == null || (f0 = a0.V().f0()) == null) {
                return;
            }
            t52.a e = e(f0);
            if (e == null) {
                e = b(a0, nl1Var, f0);
                d(f0, e);
            }
            if (e != null) {
                b62.U().V0(nl1Var.c(), e);
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static void j(nl1<?> nl1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, nl1Var) == null) && b && nl1Var != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            ExecutorUtilsExt.postOnElastic(new a(nl1Var), "SwanAppSlaveTopPages", 2);
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
                hp2 c = c();
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
