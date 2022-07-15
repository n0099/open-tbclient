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
public class p74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755457020, "Lcom/repackage/p74;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755457020, "Lcom/repackage/p74;");
        }
    }

    public p74() {
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

    public static boolean b(lb4 lb4Var, a84 a84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, lb4Var, a84Var)) == null) {
            if (a84Var == null) {
                return true;
            }
            if (lb4Var == null) {
                a84Var.C(new z84(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(hb4 hb4Var, a84 a84Var) {
        o94 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hb4Var, a84Var) == null) {
            synchronized (p74.class) {
                if (b(hb4Var, a84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(hb4Var.g())) {
                    a84Var.C(new z84(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = j94.i(hb4Var);
                if (a84Var.B() != null) {
                    i.putAll(a84Var.B());
                }
                a84Var.D();
                if (hb4Var.n() == 1 && hb4Var.h() == 2101) {
                    M = q74.b().n();
                } else {
                    M = q74.b().M();
                }
                M.z(n94.e(), i, a84Var.t(), new ua4(hb4Var.g(), a84Var, hb4Var));
            }
        }
    }

    public static synchronized void d(eb4 eb4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eb4Var, a84Var) == null) {
            synchronized (p74.class) {
                if (b(eb4Var, a84Var)) {
                    return;
                }
                if (eb4Var.f() != null && !eb4Var.f().isEmpty()) {
                    HashMap<String, String> f = j94.f(eb4Var);
                    if (a84Var.B() != null && f != null) {
                        f.putAll(a84Var.B());
                    }
                    JSONObject d = j94.d(eb4Var);
                    if (d == null) {
                        a84Var.C(new z84(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, a84Var.y());
                    a84Var.D();
                    q74.b().M().b(n94.d(), f, a84Var.t(), d, new sa4(a84Var, eb4Var));
                    return;
                }
                a84Var.C(new z84(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable u74 u74Var) {
        o74 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, u74Var) == null) || (b = q74.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            uc4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(n94.c(), hashMap, null, jSONObject, new v74(u74Var));
    }

    public static synchronized void f(gb4 gb4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, gb4Var, a84Var) == null) {
            synchronized (p74.class) {
                if (b(gb4Var, a84Var)) {
                    return;
                }
                if (gb4Var.f() != null && !gb4Var.f().isEmpty()) {
                    HashMap<String, String> f = j94.f(gb4Var);
                    if (a84Var.B() != null && f != null) {
                        f.putAll(a84Var.B());
                    }
                    JSONObject e = j94.e(gb4Var);
                    if (e == null) {
                        a84Var.C(new z84(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(q74.b())) {
                        uc4.e().f();
                    }
                    a(e, a84Var.y());
                    a84Var.D();
                    q74.b().M().b(n94.d(), f, a84Var.t(), e, new ta4(a84Var, gb4Var));
                    return;
                }
                a84Var.C(new z84(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(ib4 ib4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, ib4Var, a84Var) == null) {
            synchronized (p74.class) {
                if (b(ib4Var, a84Var)) {
                    return;
                }
                HashMap<String, String> j = j94.j(ib4Var);
                if (a84Var.B() != null) {
                    j.putAll(a84Var.B());
                }
                a84Var.D();
                q74.b().M().z(n94.f(), j, a84Var.t(), new va4(a84Var, ib4Var));
            }
        }
    }

    public static synchronized void h(kb4 kb4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, kb4Var, a84Var) == null) {
            synchronized (p74.class) {
                if (b(kb4Var, a84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(kb4Var.f())) {
                    a84Var.C(new z84(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(kb4Var.k())) {
                    a84Var.C(new z84(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = j94.k(kb4Var);
                    if (a84Var.B() != null) {
                        k.putAll(a84Var.B());
                    }
                    a84Var.D();
                    q74.b().M().z(n94.e(), k, a84Var.t(), new wa4(kb4Var.f(), a84Var, kb4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable pb4<JSONArray> pb4Var, @Nullable pb4<JSONObject> pb4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, pb4Var, pb4Var2)) == null) ? sb4.a(pb4Var, pb4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (p74.class) {
                c = fa4.b().c(str);
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
            synchronized (p74.class) {
                d = fa4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(mb4 mb4Var, a84 a84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, mb4Var, a84Var) == null) {
            synchronized (p74.class) {
                m(mb4Var, a84Var, null);
            }
        }
    }

    public static synchronized void m(mb4 mb4Var, a84 a84Var, a84 a84Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, mb4Var, a84Var, a84Var2) == null) {
            synchronized (p74.class) {
                n(mb4Var, a84Var, a84Var2, null);
            }
        }
    }

    public static synchronized void n(mb4 mb4Var, a84 a84Var, a84 a84Var2, @Nullable cd4 cd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, mb4Var, a84Var, a84Var2, cd4Var) == null) {
            synchronized (p74.class) {
                if (b(mb4Var, a84Var)) {
                    return;
                }
                if (PMSConstants.a(q74.b())) {
                    uc4.e().f();
                }
                pb4<JSONArray> g = cd4Var == null ? null : cd4Var.g();
                a84 callback = cd4Var == null ? null : cd4Var.getCallback();
                HashMap hashMap = new HashMap();
                if (a84Var.B() != null) {
                    hashMap.putAll(a84Var.B());
                }
                a84Var.D();
                q74.b().M().b(n94.g(), hashMap, a84Var.t(), i(g, null), new xa4(a84Var, mb4Var, a84Var2, callback));
            }
        }
    }

    public static synchronized void o(cd4 cd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, cd4Var) == null) {
            synchronized (p74.class) {
                if (cd4Var == null) {
                    return;
                }
                a84 callback = cd4Var.getCallback();
                if (callback == null) {
                    return;
                }
                lb4 request = cd4Var.getRequest();
                if (request == null) {
                    callback.C(new z84(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                q74.b().M().b(n94.g(), B, callback.t(), i(cd4Var.g(), null), new xa4(callback, request, null, callback));
            }
        }
    }
}
