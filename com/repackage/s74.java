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
/* loaded from: classes7.dex */
public class s74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755367647, "Lcom/repackage/s74;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755367647, "Lcom/repackage/s74;");
        }
    }

    public s74() {
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

    public static boolean b(ob4 ob4Var, d84 d84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ob4Var, d84Var)) == null) {
            if (d84Var == null) {
                return true;
            }
            if (ob4Var == null) {
                d84Var.D(new c94(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(kb4 kb4Var, d84 d84Var) {
        r94 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, kb4Var, d84Var) == null) {
            synchronized (s74.class) {
                if (b(kb4Var, d84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(kb4Var.g())) {
                    d84Var.D(new c94(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = m94.i(kb4Var);
                if (d84Var.C() != null) {
                    i.putAll(d84Var.C());
                }
                d84Var.E();
                if (kb4Var.n() == 1 && kb4Var.h() == 2101) {
                    M = t74.b().n();
                } else {
                    M = t74.b().M();
                }
                M.j(q94.e(), i, d84Var.u(), new xa4(kb4Var.g(), d84Var, kb4Var));
            }
        }
    }

    public static synchronized void d(hb4 hb4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, hb4Var, d84Var) == null) {
            synchronized (s74.class) {
                if (b(hb4Var, d84Var)) {
                    return;
                }
                if (hb4Var.f() != null && !hb4Var.f().isEmpty()) {
                    HashMap<String, String> f = m94.f(hb4Var);
                    if (d84Var.C() != null && f != null) {
                        f.putAll(d84Var.C());
                    }
                    JSONObject d = m94.d(hb4Var);
                    if (d == null) {
                        d84Var.D(new c94(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, d84Var.z());
                    d84Var.E();
                    t74.b().M().a(q94.d(), f, d84Var.u(), d, new va4(d84Var, hb4Var));
                    return;
                }
                d84Var.D(new c94(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable x74 x74Var) {
        r74 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, x74Var) == null) || (b = t74.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            xc4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().a(q94.c(), hashMap, null, jSONObject, new y74(x74Var));
    }

    public static synchronized void f(jb4 jb4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, jb4Var, d84Var) == null) {
            synchronized (s74.class) {
                if (b(jb4Var, d84Var)) {
                    return;
                }
                if (jb4Var.f() != null && !jb4Var.f().isEmpty()) {
                    HashMap<String, String> f = m94.f(jb4Var);
                    if (d84Var.C() != null && f != null) {
                        f.putAll(d84Var.C());
                    }
                    JSONObject e = m94.e(jb4Var);
                    if (e == null) {
                        d84Var.D(new c94(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(t74.b())) {
                        xc4.e().f();
                    }
                    a(e, d84Var.z());
                    d84Var.E();
                    t74.b().M().a(q94.d(), f, d84Var.u(), e, new wa4(d84Var, jb4Var));
                    return;
                }
                d84Var.D(new c94(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(lb4 lb4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, lb4Var, d84Var) == null) {
            synchronized (s74.class) {
                if (b(lb4Var, d84Var)) {
                    return;
                }
                HashMap<String, String> j = m94.j(lb4Var);
                if (d84Var.C() != null) {
                    j.putAll(d84Var.C());
                }
                d84Var.E();
                t74.b().M().j(q94.f(), j, d84Var.u(), new ya4(d84Var, lb4Var));
            }
        }
    }

    public static synchronized void h(nb4 nb4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, nb4Var, d84Var) == null) {
            synchronized (s74.class) {
                if (b(nb4Var, d84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(nb4Var.f())) {
                    d84Var.D(new c94(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(nb4Var.k())) {
                    d84Var.D(new c94(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = m94.k(nb4Var);
                    if (d84Var.C() != null) {
                        k.putAll(d84Var.C());
                    }
                    d84Var.E();
                    t74.b().M().j(q94.e(), k, d84Var.u(), new za4(nb4Var.f(), d84Var, nb4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable sb4<JSONArray> sb4Var, @Nullable sb4<JSONObject> sb4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, sb4Var, sb4Var2)) == null) ? vb4.a(sb4Var, sb4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (s74.class) {
                c = ia4.b().c(str);
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
            synchronized (s74.class) {
                d = ia4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(pb4 pb4Var, d84 d84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, pb4Var, d84Var) == null) {
            synchronized (s74.class) {
                m(pb4Var, d84Var, null);
            }
        }
    }

    public static synchronized void m(pb4 pb4Var, d84 d84Var, d84 d84Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, pb4Var, d84Var, d84Var2) == null) {
            synchronized (s74.class) {
                n(pb4Var, d84Var, d84Var2, null);
            }
        }
    }

    public static synchronized void n(pb4 pb4Var, d84 d84Var, d84 d84Var2, @Nullable fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, pb4Var, d84Var, d84Var2, fd4Var) == null) {
            synchronized (s74.class) {
                if (b(pb4Var, d84Var)) {
                    return;
                }
                if (PMSConstants.a(t74.b())) {
                    xc4.e().f();
                }
                sb4<JSONArray> g = fd4Var == null ? null : fd4Var.g();
                d84 o = fd4Var == null ? null : fd4Var.o();
                HashMap hashMap = new HashMap();
                if (d84Var.C() != null) {
                    hashMap.putAll(d84Var.C());
                }
                d84Var.E();
                t74.b().M().a(q94.g(), hashMap, d84Var.u(), i(g, null), new ab4(d84Var, pb4Var, d84Var2, o));
            }
        }
    }

    public static synchronized void o(fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, fd4Var) == null) {
            synchronized (s74.class) {
                if (fd4Var == null) {
                    return;
                }
                d84 o = fd4Var.o();
                if (o == null) {
                    return;
                }
                ob4 request = fd4Var.getRequest();
                if (request == null) {
                    o.D(new c94(2100, "request对象为空"));
                    return;
                }
                Map<String, String> C = o.C();
                if (o.C() != null) {
                    C = new HashMap(C);
                }
                o.E();
                t74.b().M().a(q94.g(), C, o.u(), i(fd4Var.g(), null), new ab4(o, request, null, o));
            }
        }
    }
}
