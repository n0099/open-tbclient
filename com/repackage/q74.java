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
public class q74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755427229, "Lcom/repackage/q74;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755427229, "Lcom/repackage/q74;");
        }
    }

    public q74() {
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

    public static boolean b(mb4 mb4Var, b84 b84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, mb4Var, b84Var)) == null) {
            if (b84Var == null) {
                return true;
            }
            if (mb4Var == null) {
                b84Var.C(new a94(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(ib4 ib4Var, b84 b84Var) {
        p94 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ib4Var, b84Var) == null) {
            synchronized (q74.class) {
                if (b(ib4Var, b84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ib4Var.g())) {
                    b84Var.C(new a94(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = k94.i(ib4Var);
                if (b84Var.B() != null) {
                    i.putAll(b84Var.B());
                }
                b84Var.D();
                if (ib4Var.n() == 1 && ib4Var.h() == 2101) {
                    M = r74.b().n();
                } else {
                    M = r74.b().M();
                }
                M.z(o94.e(), i, b84Var.t(), new va4(ib4Var.g(), b84Var, ib4Var));
            }
        }
    }

    public static synchronized void d(fb4 fb4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, fb4Var, b84Var) == null) {
            synchronized (q74.class) {
                if (b(fb4Var, b84Var)) {
                    return;
                }
                if (fb4Var.f() != null && !fb4Var.f().isEmpty()) {
                    HashMap<String, String> f = k94.f(fb4Var);
                    if (b84Var.B() != null && f != null) {
                        f.putAll(b84Var.B());
                    }
                    JSONObject d = k94.d(fb4Var);
                    if (d == null) {
                        b84Var.C(new a94(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, b84Var.y());
                    b84Var.D();
                    r74.b().M().b(o94.d(), f, b84Var.t(), d, new ta4(b84Var, fb4Var));
                    return;
                }
                b84Var.C(new a94(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable v74 v74Var) {
        p74 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, v74Var) == null) || (b = r74.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            vc4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(o94.c(), hashMap, null, jSONObject, new w74(v74Var));
    }

    public static synchronized void f(hb4 hb4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, hb4Var, b84Var) == null) {
            synchronized (q74.class) {
                if (b(hb4Var, b84Var)) {
                    return;
                }
                if (hb4Var.f() != null && !hb4Var.f().isEmpty()) {
                    HashMap<String, String> f = k94.f(hb4Var);
                    if (b84Var.B() != null && f != null) {
                        f.putAll(b84Var.B());
                    }
                    JSONObject e = k94.e(hb4Var);
                    if (e == null) {
                        b84Var.C(new a94(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(r74.b())) {
                        vc4.e().f();
                    }
                    a(e, b84Var.y());
                    b84Var.D();
                    r74.b().M().b(o94.d(), f, b84Var.t(), e, new ua4(b84Var, hb4Var));
                    return;
                }
                b84Var.C(new a94(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(jb4 jb4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, jb4Var, b84Var) == null) {
            synchronized (q74.class) {
                if (b(jb4Var, b84Var)) {
                    return;
                }
                HashMap<String, String> j = k94.j(jb4Var);
                if (b84Var.B() != null) {
                    j.putAll(b84Var.B());
                }
                b84Var.D();
                r74.b().M().z(o94.f(), j, b84Var.t(), new wa4(b84Var, jb4Var));
            }
        }
    }

    public static synchronized void h(lb4 lb4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, lb4Var, b84Var) == null) {
            synchronized (q74.class) {
                if (b(lb4Var, b84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(lb4Var.f())) {
                    b84Var.C(new a94(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(lb4Var.k())) {
                    b84Var.C(new a94(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = k94.k(lb4Var);
                    if (b84Var.B() != null) {
                        k.putAll(b84Var.B());
                    }
                    b84Var.D();
                    r74.b().M().z(o94.e(), k, b84Var.t(), new xa4(lb4Var.f(), b84Var, lb4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable qb4<JSONArray> qb4Var, @Nullable qb4<JSONObject> qb4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, qb4Var, qb4Var2)) == null) ? tb4.a(qb4Var, qb4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (q74.class) {
                c = ga4.b().c(str);
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
            synchronized (q74.class) {
                d = ga4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(nb4 nb4Var, b84 b84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, nb4Var, b84Var) == null) {
            synchronized (q74.class) {
                m(nb4Var, b84Var, null);
            }
        }
    }

    public static synchronized void m(nb4 nb4Var, b84 b84Var, b84 b84Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, nb4Var, b84Var, b84Var2) == null) {
            synchronized (q74.class) {
                n(nb4Var, b84Var, b84Var2, null);
            }
        }
    }

    public static synchronized void n(nb4 nb4Var, b84 b84Var, b84 b84Var2, @Nullable dd4 dd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, nb4Var, b84Var, b84Var2, dd4Var) == null) {
            synchronized (q74.class) {
                if (b(nb4Var, b84Var)) {
                    return;
                }
                if (PMSConstants.a(r74.b())) {
                    vc4.e().f();
                }
                qb4<JSONArray> g = dd4Var == null ? null : dd4Var.g();
                b84 callback = dd4Var == null ? null : dd4Var.getCallback();
                HashMap hashMap = new HashMap();
                if (b84Var.B() != null) {
                    hashMap.putAll(b84Var.B());
                }
                b84Var.D();
                r74.b().M().b(o94.g(), hashMap, b84Var.t(), i(g, null), new ya4(b84Var, nb4Var, b84Var2, callback));
            }
        }
    }

    public static synchronized void o(dd4 dd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, dd4Var) == null) {
            synchronized (q74.class) {
                if (dd4Var == null) {
                    return;
                }
                b84 callback = dd4Var.getCallback();
                if (callback == null) {
                    return;
                }
                mb4 request = dd4Var.getRequest();
                if (request == null) {
                    callback.C(new a94(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                r74.b().M().b(o94.g(), B, callback.t(), i(dd4Var.g(), null), new ya4(callback, request, null, callback));
            }
        }
    }
}
