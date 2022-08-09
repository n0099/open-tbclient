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
public class h84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755694387, "Lcom/repackage/h84;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755694387, "Lcom/repackage/h84;");
        }
    }

    public h84() {
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

    public static boolean b(dc4 dc4Var, s84 s84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dc4Var, s84Var)) == null) {
            if (s84Var == null) {
                return true;
            }
            if (dc4Var == null) {
                s84Var.C(new r94(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(zb4 zb4Var, s84 s84Var) {
        ga4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zb4Var, s84Var) == null) {
            synchronized (h84.class) {
                if (b(zb4Var, s84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(zb4Var.g())) {
                    s84Var.C(new r94(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = ba4.i(zb4Var);
                if (s84Var.B() != null) {
                    i.putAll(s84Var.B());
                }
                s84Var.D();
                if (zb4Var.n() == 1 && zb4Var.h() == 2101) {
                    M = i84.b().n();
                } else {
                    M = i84.b().M();
                }
                M.z(fa4.e(), i, s84Var.t(), new mb4(zb4Var.g(), s84Var, zb4Var));
            }
        }
    }

    public static synchronized void d(wb4 wb4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, wb4Var, s84Var) == null) {
            synchronized (h84.class) {
                if (b(wb4Var, s84Var)) {
                    return;
                }
                if (wb4Var.f() != null && !wb4Var.f().isEmpty()) {
                    HashMap<String, String> f = ba4.f(wb4Var);
                    if (s84Var.B() != null && f != null) {
                        f.putAll(s84Var.B());
                    }
                    JSONObject d = ba4.d(wb4Var);
                    if (d == null) {
                        s84Var.C(new r94(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, s84Var.y());
                    s84Var.D();
                    i84.b().M().b(fa4.d(), f, s84Var.t(), d, new kb4(s84Var, wb4Var));
                    return;
                }
                s84Var.C(new r94(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable m84 m84Var) {
        g84 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, m84Var) == null) || (b = i84.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            md4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(fa4.c(), hashMap, null, jSONObject, new n84(m84Var));
    }

    public static synchronized void f(yb4 yb4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, yb4Var, s84Var) == null) {
            synchronized (h84.class) {
                if (b(yb4Var, s84Var)) {
                    return;
                }
                if (yb4Var.f() != null && !yb4Var.f().isEmpty()) {
                    HashMap<String, String> f = ba4.f(yb4Var);
                    if (s84Var.B() != null && f != null) {
                        f.putAll(s84Var.B());
                    }
                    JSONObject e = ba4.e(yb4Var);
                    if (e == null) {
                        s84Var.C(new r94(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(i84.b())) {
                        md4.e().f();
                    }
                    a(e, s84Var.y());
                    s84Var.D();
                    i84.b().M().b(fa4.d(), f, s84Var.t(), e, new lb4(s84Var, yb4Var));
                    return;
                }
                s84Var.C(new r94(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(ac4 ac4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, ac4Var, s84Var) == null) {
            synchronized (h84.class) {
                if (b(ac4Var, s84Var)) {
                    return;
                }
                HashMap<String, String> j = ba4.j(ac4Var);
                if (s84Var.B() != null) {
                    j.putAll(s84Var.B());
                }
                s84Var.D();
                i84.b().M().z(fa4.f(), j, s84Var.t(), new nb4(s84Var, ac4Var));
            }
        }
    }

    public static synchronized void h(cc4 cc4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, cc4Var, s84Var) == null) {
            synchronized (h84.class) {
                if (b(cc4Var, s84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(cc4Var.f())) {
                    s84Var.C(new r94(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(cc4Var.k())) {
                    s84Var.C(new r94(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = ba4.k(cc4Var);
                    if (s84Var.B() != null) {
                        k.putAll(s84Var.B());
                    }
                    s84Var.D();
                    i84.b().M().z(fa4.e(), k, s84Var.t(), new ob4(cc4Var.f(), s84Var, cc4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable hc4<JSONArray> hc4Var, @Nullable hc4<JSONObject> hc4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, hc4Var, hc4Var2)) == null) ? kc4.a(hc4Var, hc4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (h84.class) {
                c = xa4.b().c(str);
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
            synchronized (h84.class) {
                d = xa4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(ec4 ec4Var, s84 s84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, ec4Var, s84Var) == null) {
            synchronized (h84.class) {
                m(ec4Var, s84Var, null);
            }
        }
    }

    public static synchronized void m(ec4 ec4Var, s84 s84Var, s84 s84Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, ec4Var, s84Var, s84Var2) == null) {
            synchronized (h84.class) {
                n(ec4Var, s84Var, s84Var2, null);
            }
        }
    }

    public static synchronized void n(ec4 ec4Var, s84 s84Var, s84 s84Var2, @Nullable ud4 ud4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, ec4Var, s84Var, s84Var2, ud4Var) == null) {
            synchronized (h84.class) {
                if (b(ec4Var, s84Var)) {
                    return;
                }
                if (PMSConstants.a(i84.b())) {
                    md4.e().f();
                }
                hc4<JSONArray> g = ud4Var == null ? null : ud4Var.g();
                s84 callback = ud4Var == null ? null : ud4Var.getCallback();
                HashMap hashMap = new HashMap();
                if (s84Var.B() != null) {
                    hashMap.putAll(s84Var.B());
                }
                s84Var.D();
                i84.b().M().b(fa4.g(), hashMap, s84Var.t(), i(g, null), new pb4(s84Var, ec4Var, s84Var2, callback));
            }
        }
    }

    public static synchronized void o(ud4 ud4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, ud4Var) == null) {
            synchronized (h84.class) {
                if (ud4Var == null) {
                    return;
                }
                s84 callback = ud4Var.getCallback();
                if (callback == null) {
                    return;
                }
                dc4 request = ud4Var.getRequest();
                if (request == null) {
                    callback.C(new r94(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                i84.b().M().b(fa4.g(), B, callback.t(), i(ud4Var.g(), null), new pb4(callback, request, null, callback));
            }
        }
    }
}
