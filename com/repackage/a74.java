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
public class a74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755903885, "Lcom/repackage/a74;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755903885, "Lcom/repackage/a74;");
        }
    }

    public a74() {
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

    public static boolean b(wa4 wa4Var, l74 l74Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, wa4Var, l74Var)) == null) {
            if (l74Var == null) {
                return true;
            }
            if (wa4Var == null) {
                l74Var.C(new k84(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(sa4 sa4Var, l74 l74Var) {
        z84 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, sa4Var, l74Var) == null) {
            synchronized (a74.class) {
                if (b(sa4Var, l74Var)) {
                    return;
                }
                if (TextUtils.isEmpty(sa4Var.g())) {
                    l74Var.C(new k84(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = u84.i(sa4Var);
                if (l74Var.B() != null) {
                    i.putAll(l74Var.B());
                }
                l74Var.D();
                if (sa4Var.n() == 1 && sa4Var.h() == 2101) {
                    M = b74.b().n();
                } else {
                    M = b74.b().M();
                }
                M.k(y84.e(), i, l74Var.t(), new fa4(sa4Var.g(), l74Var, sa4Var));
            }
        }
    }

    public static synchronized void d(pa4 pa4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, pa4Var, l74Var) == null) {
            synchronized (a74.class) {
                if (b(pa4Var, l74Var)) {
                    return;
                }
                if (pa4Var.f() != null && !pa4Var.f().isEmpty()) {
                    HashMap<String, String> f = u84.f(pa4Var);
                    if (l74Var.B() != null && f != null) {
                        f.putAll(l74Var.B());
                    }
                    JSONObject d = u84.d(pa4Var);
                    if (d == null) {
                        l74Var.C(new k84(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, l74Var.y());
                    l74Var.D();
                    b74.b().M().b(y84.d(), f, l74Var.t(), d, new da4(l74Var, pa4Var));
                    return;
                }
                l74Var.C(new k84(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable f74 f74Var) {
        z64 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, f74Var) == null) || (b = b74.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            fc4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(y84.c(), hashMap, null, jSONObject, new g74(f74Var));
    }

    public static synchronized void f(ra4 ra4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ra4Var, l74Var) == null) {
            synchronized (a74.class) {
                if (b(ra4Var, l74Var)) {
                    return;
                }
                if (ra4Var.f() != null && !ra4Var.f().isEmpty()) {
                    HashMap<String, String> f = u84.f(ra4Var);
                    if (l74Var.B() != null && f != null) {
                        f.putAll(l74Var.B());
                    }
                    JSONObject e = u84.e(ra4Var);
                    if (e == null) {
                        l74Var.C(new k84(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(b74.b())) {
                        fc4.e().f();
                    }
                    a(e, l74Var.y());
                    l74Var.D();
                    b74.b().M().b(y84.d(), f, l74Var.t(), e, new ea4(l74Var, ra4Var));
                    return;
                }
                l74Var.C(new k84(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(ta4 ta4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, ta4Var, l74Var) == null) {
            synchronized (a74.class) {
                if (b(ta4Var, l74Var)) {
                    return;
                }
                HashMap<String, String> j = u84.j(ta4Var);
                if (l74Var.B() != null) {
                    j.putAll(l74Var.B());
                }
                l74Var.D();
                b74.b().M().k(y84.f(), j, l74Var.t(), new ga4(l74Var, ta4Var));
            }
        }
    }

    public static synchronized void h(va4 va4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, va4Var, l74Var) == null) {
            synchronized (a74.class) {
                if (b(va4Var, l74Var)) {
                    return;
                }
                if (TextUtils.isEmpty(va4Var.f())) {
                    l74Var.C(new k84(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(va4Var.k())) {
                    l74Var.C(new k84(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = u84.k(va4Var);
                    if (l74Var.B() != null) {
                        k.putAll(l74Var.B());
                    }
                    l74Var.D();
                    b74.b().M().k(y84.e(), k, l74Var.t(), new ha4(va4Var.f(), l74Var, va4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable ab4<JSONArray> ab4Var, @Nullable ab4<JSONObject> ab4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, ab4Var, ab4Var2)) == null) ? db4.a(ab4Var, ab4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (a74.class) {
                c = q94.b().c(str);
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
            synchronized (a74.class) {
                d = q94.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(xa4 xa4Var, l74 l74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, xa4Var, l74Var) == null) {
            synchronized (a74.class) {
                m(xa4Var, l74Var, null);
            }
        }
    }

    public static synchronized void m(xa4 xa4Var, l74 l74Var, l74 l74Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, xa4Var, l74Var, l74Var2) == null) {
            synchronized (a74.class) {
                n(xa4Var, l74Var, l74Var2, null);
            }
        }
    }

    public static synchronized void n(xa4 xa4Var, l74 l74Var, l74 l74Var2, @Nullable nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, xa4Var, l74Var, l74Var2, nc4Var) == null) {
            synchronized (a74.class) {
                if (b(xa4Var, l74Var)) {
                    return;
                }
                if (PMSConstants.a(b74.b())) {
                    fc4.e().f();
                }
                ab4<JSONArray> g = nc4Var == null ? null : nc4Var.g();
                l74 callback = nc4Var == null ? null : nc4Var.getCallback();
                HashMap hashMap = new HashMap();
                if (l74Var.B() != null) {
                    hashMap.putAll(l74Var.B());
                }
                l74Var.D();
                b74.b().M().b(y84.g(), hashMap, l74Var.t(), i(g, null), new ia4(l74Var, xa4Var, l74Var2, callback));
            }
        }
    }

    public static synchronized void o(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, nc4Var) == null) {
            synchronized (a74.class) {
                if (nc4Var == null) {
                    return;
                }
                l74 callback = nc4Var.getCallback();
                if (callback == null) {
                    return;
                }
                wa4 request = nc4Var.getRequest();
                if (request == null) {
                    callback.C(new k84(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                b74.b().M().b(y84.g(), B, callback.t(), i(nc4Var.g(), null), new ia4(callback, request, null, callback));
            }
        }
    }
}
