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
public class r74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755397438, "Lcom/repackage/r74;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755397438, "Lcom/repackage/r74;");
        }
    }

    public r74() {
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

    public static boolean b(nb4 nb4Var, c84 c84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, nb4Var, c84Var)) == null) {
            if (c84Var == null) {
                return true;
            }
            if (nb4Var == null) {
                c84Var.D(new b94(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(jb4 jb4Var, c84 c84Var) {
        q94 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jb4Var, c84Var) == null) {
            synchronized (r74.class) {
                if (b(jb4Var, c84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(jb4Var.g())) {
                    c84Var.D(new b94(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = l94.i(jb4Var);
                if (c84Var.C() != null) {
                    i.putAll(c84Var.C());
                }
                c84Var.E();
                if (jb4Var.n() == 1 && jb4Var.h() == 2101) {
                    M = s74.b().n();
                } else {
                    M = s74.b().M();
                }
                M.j(p94.e(), i, c84Var.u(), new wa4(jb4Var.g(), c84Var, jb4Var));
            }
        }
    }

    public static synchronized void d(gb4 gb4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, gb4Var, c84Var) == null) {
            synchronized (r74.class) {
                if (b(gb4Var, c84Var)) {
                    return;
                }
                if (gb4Var.f() != null && !gb4Var.f().isEmpty()) {
                    HashMap<String, String> f = l94.f(gb4Var);
                    if (c84Var.C() != null && f != null) {
                        f.putAll(c84Var.C());
                    }
                    JSONObject d = l94.d(gb4Var);
                    if (d == null) {
                        c84Var.D(new b94(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, c84Var.z());
                    c84Var.E();
                    s74.b().M().a(p94.d(), f, c84Var.u(), d, new ua4(c84Var, gb4Var));
                    return;
                }
                c84Var.D(new b94(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable w74 w74Var) {
        q74 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, w74Var) == null) || (b = s74.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            wc4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().a(p94.c(), hashMap, null, jSONObject, new x74(w74Var));
    }

    public static synchronized void f(ib4 ib4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ib4Var, c84Var) == null) {
            synchronized (r74.class) {
                if (b(ib4Var, c84Var)) {
                    return;
                }
                if (ib4Var.f() != null && !ib4Var.f().isEmpty()) {
                    HashMap<String, String> f = l94.f(ib4Var);
                    if (c84Var.C() != null && f != null) {
                        f.putAll(c84Var.C());
                    }
                    JSONObject e = l94.e(ib4Var);
                    if (e == null) {
                        c84Var.D(new b94(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(s74.b())) {
                        wc4.e().f();
                    }
                    a(e, c84Var.z());
                    c84Var.E();
                    s74.b().M().a(p94.d(), f, c84Var.u(), e, new va4(c84Var, ib4Var));
                    return;
                }
                c84Var.D(new b94(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(kb4 kb4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, kb4Var, c84Var) == null) {
            synchronized (r74.class) {
                if (b(kb4Var, c84Var)) {
                    return;
                }
                HashMap<String, String> j = l94.j(kb4Var);
                if (c84Var.C() != null) {
                    j.putAll(c84Var.C());
                }
                c84Var.E();
                s74.b().M().j(p94.f(), j, c84Var.u(), new xa4(c84Var, kb4Var));
            }
        }
    }

    public static synchronized void h(mb4 mb4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, mb4Var, c84Var) == null) {
            synchronized (r74.class) {
                if (b(mb4Var, c84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(mb4Var.f())) {
                    c84Var.D(new b94(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(mb4Var.k())) {
                    c84Var.D(new b94(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = l94.k(mb4Var);
                    if (c84Var.C() != null) {
                        k.putAll(c84Var.C());
                    }
                    c84Var.E();
                    s74.b().M().j(p94.e(), k, c84Var.u(), new ya4(mb4Var.f(), c84Var, mb4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable rb4<JSONArray> rb4Var, @Nullable rb4<JSONObject> rb4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, rb4Var, rb4Var2)) == null) ? ub4.a(rb4Var, rb4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (r74.class) {
                c = ha4.b().c(str);
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
            synchronized (r74.class) {
                d = ha4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(ob4 ob4Var, c84 c84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, ob4Var, c84Var) == null) {
            synchronized (r74.class) {
                m(ob4Var, c84Var, null);
            }
        }
    }

    public static synchronized void m(ob4 ob4Var, c84 c84Var, c84 c84Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, ob4Var, c84Var, c84Var2) == null) {
            synchronized (r74.class) {
                n(ob4Var, c84Var, c84Var2, null);
            }
        }
    }

    public static synchronized void n(ob4 ob4Var, c84 c84Var, c84 c84Var2, @Nullable ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, ob4Var, c84Var, c84Var2, ed4Var) == null) {
            synchronized (r74.class) {
                if (b(ob4Var, c84Var)) {
                    return;
                }
                if (PMSConstants.a(s74.b())) {
                    wc4.e().f();
                }
                rb4<JSONArray> g = ed4Var == null ? null : ed4Var.g();
                c84 o = ed4Var == null ? null : ed4Var.o();
                HashMap hashMap = new HashMap();
                if (c84Var.C() != null) {
                    hashMap.putAll(c84Var.C());
                }
                c84Var.E();
                s74.b().M().a(p94.g(), hashMap, c84Var.u(), i(g, null), new za4(c84Var, ob4Var, c84Var2, o));
            }
        }
    }

    public static synchronized void o(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, ed4Var) == null) {
            synchronized (r74.class) {
                if (ed4Var == null) {
                    return;
                }
                c84 o = ed4Var.o();
                if (o == null) {
                    return;
                }
                nb4 request = ed4Var.getRequest();
                if (request == null) {
                    o.D(new b94(2100, "request对象为空"));
                    return;
                }
                Map<String, String> C = o.C();
                if (o.C() != null) {
                    C = new HashMap(C);
                }
                o.E();
                s74.b().M().a(p94.g(), C, o.u(), i(ed4Var.g(), null), new za4(o, request, null, o));
            }
        }
    }
}
