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
/* loaded from: classes5.dex */
public class c84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755843342, "Lcom/repackage/c84;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755843342, "Lcom/repackage/c84;");
        }
    }

    public c84() {
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

    public static boolean b(yb4 yb4Var, n84 n84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, yb4Var, n84Var)) == null) {
            if (n84Var == null) {
                return true;
            }
            if (yb4Var == null) {
                n84Var.D(new m94(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(ub4 ub4Var, n84 n84Var) {
        ba4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ub4Var, n84Var) == null) {
            synchronized (c84.class) {
                if (b(ub4Var, n84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ub4Var.g())) {
                    n84Var.D(new m94(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = w94.i(ub4Var);
                if (n84Var.C() != null) {
                    i.putAll(n84Var.C());
                }
                n84Var.E();
                if (ub4Var.n() == 1 && ub4Var.h() == 2101) {
                    M = d84.b().n();
                } else {
                    M = d84.b().M();
                }
                M.j(aa4.e(), i, n84Var.u(), new hb4(ub4Var.g(), n84Var, ub4Var));
            }
        }
    }

    public static synchronized void d(rb4 rb4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, rb4Var, n84Var) == null) {
            synchronized (c84.class) {
                if (b(rb4Var, n84Var)) {
                    return;
                }
                if (rb4Var.f() != null && !rb4Var.f().isEmpty()) {
                    HashMap<String, String> f = w94.f(rb4Var);
                    if (n84Var.C() != null && f != null) {
                        f.putAll(n84Var.C());
                    }
                    JSONObject d = w94.d(rb4Var);
                    if (d == null) {
                        n84Var.D(new m94(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, n84Var.z());
                    n84Var.E();
                    d84.b().M().a(aa4.d(), f, n84Var.u(), d, new fb4(n84Var, rb4Var));
                    return;
                }
                n84Var.D(new m94(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable h84 h84Var) {
        b84 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, h84Var) == null) || (b = d84.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            hd4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().a(aa4.c(), hashMap, null, jSONObject, new i84(h84Var));
    }

    public static synchronized void f(tb4 tb4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, tb4Var, n84Var) == null) {
            synchronized (c84.class) {
                if (b(tb4Var, n84Var)) {
                    return;
                }
                if (tb4Var.f() != null && !tb4Var.f().isEmpty()) {
                    HashMap<String, String> f = w94.f(tb4Var);
                    if (n84Var.C() != null && f != null) {
                        f.putAll(n84Var.C());
                    }
                    JSONObject e = w94.e(tb4Var);
                    if (e == null) {
                        n84Var.D(new m94(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(d84.b())) {
                        hd4.e().f();
                    }
                    a(e, n84Var.z());
                    n84Var.E();
                    d84.b().M().a(aa4.d(), f, n84Var.u(), e, new gb4(n84Var, tb4Var));
                    return;
                }
                n84Var.D(new m94(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(vb4 vb4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, vb4Var, n84Var) == null) {
            synchronized (c84.class) {
                if (b(vb4Var, n84Var)) {
                    return;
                }
                HashMap<String, String> j = w94.j(vb4Var);
                if (n84Var.C() != null) {
                    j.putAll(n84Var.C());
                }
                n84Var.E();
                d84.b().M().j(aa4.f(), j, n84Var.u(), new ib4(n84Var, vb4Var));
            }
        }
    }

    public static synchronized void h(xb4 xb4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, xb4Var, n84Var) == null) {
            synchronized (c84.class) {
                if (b(xb4Var, n84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(xb4Var.f())) {
                    n84Var.D(new m94(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(xb4Var.k())) {
                    n84Var.D(new m94(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = w94.k(xb4Var);
                    if (n84Var.C() != null) {
                        k.putAll(n84Var.C());
                    }
                    n84Var.E();
                    d84.b().M().j(aa4.e(), k, n84Var.u(), new jb4(xb4Var.f(), n84Var, xb4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable cc4<JSONArray> cc4Var, @Nullable cc4<JSONObject> cc4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cc4Var, cc4Var2)) == null) ? fc4.a(cc4Var, cc4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (c84.class) {
                c = sa4.b().c(str);
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
            synchronized (c84.class) {
                d = sa4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(zb4 zb4Var, n84 n84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, zb4Var, n84Var) == null) {
            synchronized (c84.class) {
                m(zb4Var, n84Var, null);
            }
        }
    }

    public static synchronized void m(zb4 zb4Var, n84 n84Var, n84 n84Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, zb4Var, n84Var, n84Var2) == null) {
            synchronized (c84.class) {
                n(zb4Var, n84Var, n84Var2, null);
            }
        }
    }

    public static synchronized void n(zb4 zb4Var, n84 n84Var, n84 n84Var2, @Nullable pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, zb4Var, n84Var, n84Var2, pd4Var) == null) {
            synchronized (c84.class) {
                if (b(zb4Var, n84Var)) {
                    return;
                }
                if (PMSConstants.a(d84.b())) {
                    hd4.e().f();
                }
                cc4<JSONArray> g = pd4Var == null ? null : pd4Var.g();
                n84 o = pd4Var == null ? null : pd4Var.o();
                HashMap hashMap = new HashMap();
                if (n84Var.C() != null) {
                    hashMap.putAll(n84Var.C());
                }
                n84Var.E();
                d84.b().M().a(aa4.g(), hashMap, n84Var.u(), i(g, null), new kb4(n84Var, zb4Var, n84Var2, o));
            }
        }
    }

    public static synchronized void o(pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, pd4Var) == null) {
            synchronized (c84.class) {
                if (pd4Var == null) {
                    return;
                }
                n84 o = pd4Var.o();
                if (o == null) {
                    return;
                }
                yb4 request = pd4Var.getRequest();
                if (request == null) {
                    o.D(new m94(2100, "request对象为空"));
                    return;
                }
                Map<String, String> C = o.C();
                if (o.C() != null) {
                    C = new HashMap(C);
                }
                o.E();
                d84.b().M().a(aa4.g(), C, o.u(), i(pd4Var.g(), null), new kb4(o, request, null, o));
            }
        }
    }
}
