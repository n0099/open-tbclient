package d.a.g0.k.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.poly.util.HttpSigner;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.g0.n.e;
import d.a.g0.n.f;
import d.a.g0.n.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f45439a;

    /* renamed from: b  reason: collision with root package name */
    public static String f45440b;

    /* renamed from: c  reason: collision with root package name */
    public static String f45441c;

    /* renamed from: d  reason: collision with root package name */
    public static String f45442d;

    /* renamed from: e  reason: collision with root package name */
    public static String f45443e;

    /* renamed from: f  reason: collision with root package name */
    public static List<d.a.g0.k.h.b> f45444f;

    /* renamed from: g  reason: collision with root package name */
    public static Object f45445g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.i();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends d.a.g0.k.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.g0.k.a.c f45446a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.g0.k.a.b f45447b;

        public b(d.a.g0.k.a.c cVar, d.a.g0.k.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45446a = cVar;
            this.f45447b = bVar;
        }

        @Override // d.a.g0.k.a.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            }
        }

        @Override // d.a.g0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                d.f(this.f45446a.c(), this.f45447b.c());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends d.a.g0.k.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONArray f45448a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f45449b;

        public c(JSONArray jSONArray, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONArray, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45448a = jSONArray;
            this.f45449b = jSONObject;
        }

        @Override // d.a.g0.k.a.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            }
        }

        @Override // d.a.g0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                this.f45448a.put(this.f45449b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2016023683, "Ld/a/g0/k/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2016023683, "Ld/a/g0/k/h/d;");
                return;
            }
        }
        f45445g = new Object();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f45439a = null;
            f45440b = null;
            f45441c = null;
            f45442d = null;
            f45443e = null;
        }
    }

    public static void b(d.a.g0.k.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            if (f45444f == null) {
                f45444f = new ArrayList();
            }
            if (bVar != null) {
                synchronized (f45445g) {
                    f45444f.add(bVar);
                }
            }
        }
    }

    public static void e(int i2, String str) {
        d.a.g0.k.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, str) == null) {
            if (i2 == 0) {
                bVar = new d.a.g0.k.h.b("2");
            } else if (i2 != 2) {
                bVar = i2 != 3 ? null : new d.a.g0.k.h.b("3");
            } else {
                bVar = new d.a.g0.k.h.b("4");
            }
            if (bVar != null) {
                bVar.c(str);
                b(bVar);
            }
        }
    }

    public static void f(Map map, Map map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, map, map2) == null) {
            try {
                JSONArray l = l();
                if (l != null) {
                    if (l.length() >= 20) {
                        l.remove(0);
                    }
                } else {
                    l = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject c2 = e.c(map);
                JSONObject c3 = e.c(map2);
                jSONObject.put("header", c2);
                jSONObject.put("body", c3);
                l.put(jSONObject);
                g(l);
            } catch (Exception unused) {
            }
        }
    }

    public static void g(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        d.a.g0.n.c.b(jSONArray.toString(), new File(g.a().getFilesDir(), "poly_cashier_statistics.json"));
    }

    public static void h() {
        List<d.a.g0.k.h.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || (list = f45444f) == null) {
            return;
        }
        list.clear();
    }

    public static synchronized void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            synchronized (d.class) {
                List<d.a.g0.k.h.b> list = f45444f;
                if (list != null && !list.isEmpty()) {
                    d.a.g0.k.a.b m = m();
                    synchronized (f45445g) {
                        JSONArray jSONArray = new JSONArray();
                        for (d.a.g0.k.h.b bVar : f45444f) {
                            JSONObject a2 = bVar.a();
                            if (a2 != null) {
                                jSONArray.put(a2);
                            }
                        }
                        m.e("data", jSONArray.toString());
                        m.e("s", HttpSigner.a(m, "key", d.a.g0.k.b.a.d()));
                        h();
                    }
                    d.a.g0.k.a.c k = k();
                    if (f.a()) {
                        n();
                        new d.a.g0.k.h.c().a(k, m, new b(k, m));
                    } else {
                        f(k.c(), m.c());
                    }
                }
            }
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            d.a.g0.m.a.a(new a());
        }
    }

    public static d.a.g0.k.a.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            d.a.g0.k.a.c cVar = new d.a.g0.k.a.c();
            if (!TextUtils.isEmpty(f45439a)) {
                cVar.e("Cookie", "BDUSS=" + f45439a);
            }
            return cVar;
        }
        return (d.a.g0.k.a.c) invokeV.objValue;
    }

    public static JSONArray l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            File file = new File(g.a().getFilesDir(), "poly_cashier_statistics.json");
            if (file.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(d.a.g0.n.c.d(file));
                    try {
                        file.delete();
                    } catch (Exception unused) {
                    }
                    return jSONArray;
                } catch (Exception unused2) {
                    return null;
                }
            }
            return null;
        }
        return (JSONArray) invokeV.objValue;
    }

    public static d.a.g0.k.a.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            d.a.g0.k.a.b bVar = new d.a.g0.k.a.b();
            bVar.e("dm", "cashier");
            bVar.e(IAdRequestParam.OS, "android");
            bVar.e("v", "2.7.7");
            if (!TextUtils.isEmpty(f45443e)) {
                bVar.e("n", f45443e);
            }
            if (!TextUtils.isEmpty(f45440b)) {
                bVar.e("d", f45440b);
            }
            if (!TextUtils.isEmpty(f45441c)) {
                bVar.e("dt", f45441c);
            }
            if (!TextUtils.isEmpty(f45442d)) {
                bVar.e("dp", f45442d);
            }
            return bVar;
        }
        return (d.a.g0.k.a.b) invokeV.objValue;
    }

    public static void n() {
        JSONArray l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, null) == null) && (l = l()) != null && l.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < l.length(); i2++) {
                    JSONObject jSONObject = l.getJSONObject(i2);
                    d.a.g0.k.a.c cVar = new d.a.g0.k.a.c();
                    cVar.a(e.d(jSONObject.optJSONObject("header")));
                    d.a.g0.k.a.b bVar = new d.a.g0.k.a.b();
                    bVar.a(e.d(jSONObject.optJSONObject("body")));
                    new d.a.g0.k.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                g(jSONArray);
            } catch (Exception unused) {
            }
        }
    }
}
