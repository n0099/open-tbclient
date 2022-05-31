package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755457981, "Lcom/repackage/p64;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755457981, "Lcom/repackage/p64;");
        }
    }

    public p64() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(@NonNull JSONObject jSONObject, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, jSONObject, map) == null) || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean b(la4 la4Var, a74 a74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, la4Var, a74Var)) == null) {
            if (a74Var == null) {
                return true;
            }
            if (la4Var == null) {
                a74Var.D(new z74(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(ha4 ha4Var, a74 a74Var) {
        o84 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ha4Var, a74Var) == null) {
            synchronized (p64.class) {
                if (b(ha4Var, a74Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ha4Var.g())) {
                    a74Var.D(new z74(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = j84.i(ha4Var);
                if (a74Var.C() != null) {
                    i.putAll(a74Var.C());
                }
                a74Var.E();
                if (ha4Var.n() == 1 && ha4Var.h() == 2101) {
                    M = q64.b().n();
                } else {
                    M = q64.b().M();
                }
                M.j(n84.e(), i, a74Var.u(), new u94(ha4Var.g(), a74Var, ha4Var));
            }
        }
    }

    public static synchronized void d(ea4 ea4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ea4Var, a74Var) == null) {
            synchronized (p64.class) {
                if (b(ea4Var, a74Var)) {
                    return;
                }
                if (ea4Var.f() != null && !ea4Var.f().isEmpty()) {
                    HashMap<String, String> f = j84.f(ea4Var);
                    if (a74Var.C() != null && f != null) {
                        f.putAll(a74Var.C());
                    }
                    JSONObject d = j84.d(ea4Var);
                    if (d == null) {
                        a74Var.D(new z74(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, a74Var.z());
                    a74Var.E();
                    q64.b().M().a(n84.d(), f, a74Var.u(), d, new s94(a74Var, ea4Var));
                    return;
                }
                a74Var.D(new z74(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable u64 u64Var) {
        o64 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, u64Var) == null) || (b = q64.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            ub4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().a(n84.c(), hashMap, null, jSONObject, new v64(u64Var));
    }

    public static synchronized void f(ga4 ga4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ga4Var, a74Var) == null) {
            synchronized (p64.class) {
                if (b(ga4Var, a74Var)) {
                    return;
                }
                if (ga4Var.f() != null && !ga4Var.f().isEmpty()) {
                    HashMap<String, String> f = j84.f(ga4Var);
                    if (a74Var.C() != null && f != null) {
                        f.putAll(a74Var.C());
                    }
                    JSONObject e = j84.e(ga4Var);
                    if (e == null) {
                        a74Var.D(new z74(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(q64.b())) {
                        ub4.e().f();
                    }
                    a(e, a74Var.z());
                    a74Var.E();
                    q64.b().M().a(n84.d(), f, a74Var.u(), e, new t94(a74Var, ga4Var));
                    return;
                }
                a74Var.D(new z74(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(ia4 ia4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, ia4Var, a74Var) == null) {
            synchronized (p64.class) {
                if (b(ia4Var, a74Var)) {
                    return;
                }
                HashMap<String, String> j = j84.j(ia4Var);
                if (a74Var.C() != null) {
                    j.putAll(a74Var.C());
                }
                a74Var.E();
                q64.b().M().j(n84.f(), j, a74Var.u(), new v94(a74Var, ia4Var));
            }
        }
    }

    public static synchronized void h(ka4 ka4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, ka4Var, a74Var) == null) {
            synchronized (p64.class) {
                if (b(ka4Var, a74Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ka4Var.f())) {
                    a74Var.D(new z74(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(ka4Var.k())) {
                    a74Var.D(new z74(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = j84.k(ka4Var);
                    if (a74Var.C() != null) {
                        k.putAll(a74Var.C());
                    }
                    a74Var.E();
                    q64.b().M().j(n84.e(), k, a74Var.u(), new w94(ka4Var.f(), a74Var, ka4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable pa4<JSONArray> pa4Var, @Nullable pa4<JSONObject> pa4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, pa4Var, pa4Var2)) == null) ? sa4.a(pa4Var, pa4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (p64.class) {
                c = f94.b().c(str);
            }
            return c;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean k(String str) {
        InterceptResult invokeL;
        boolean d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (p64.class) {
                d = f94.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(ma4 ma4Var, a74 a74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, ma4Var, a74Var) == null) {
            synchronized (p64.class) {
                m(ma4Var, a74Var, null);
            }
        }
    }

    public static synchronized void m(ma4 ma4Var, a74 a74Var, a74 a74Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, ma4Var, a74Var, a74Var2) == null) {
            synchronized (p64.class) {
                n(ma4Var, a74Var, a74Var2, null);
            }
        }
    }

    public static synchronized void n(ma4 ma4Var, a74 a74Var, a74 a74Var2, @Nullable cc4 cc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, ma4Var, a74Var, a74Var2, cc4Var) == null) {
            synchronized (p64.class) {
                if (b(ma4Var, a74Var)) {
                    return;
                }
                if (PMSConstants.a(q64.b())) {
                    ub4.e().f();
                }
                pa4<JSONArray> g = cc4Var == null ? null : cc4Var.g();
                a74 o = cc4Var == null ? null : cc4Var.o();
                HashMap hashMap = new HashMap();
                if (a74Var.C() != null) {
                    hashMap.putAll(a74Var.C());
                }
                a74Var.E();
                q64.b().M().a(n84.g(), hashMap, a74Var.u(), i(g, null), new x94(a74Var, ma4Var, a74Var2, o));
            }
        }
    }

    public static synchronized void o(cc4 cc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, cc4Var) == null) {
            synchronized (p64.class) {
                if (cc4Var == null) {
                    return;
                }
                a74 o = cc4Var.o();
                if (o == null) {
                    return;
                }
                la4 request = cc4Var.getRequest();
                if (request == null) {
                    o.D(new z74(2100, "request对象为空"));
                    return;
                }
                Map<String, String> C = o.C();
                if (o.C() != null) {
                    C = new HashMap(C);
                }
                o.E();
                q64.b().M().a(n84.g(), C, o.u(), i(cc4Var.g(), null), new x94(o, request, null, o));
            }
        }
    }
}
