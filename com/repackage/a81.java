package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.HttpSigner;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a81 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static List<x71> i;
    public static Object j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a81.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends r61 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t61 a;
        public final /* synthetic */ s61 b;

        public b(t61 t61Var, s61 s61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t61Var, s61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t61Var;
            this.b = s61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                a81.l(this.a.b(), this.b.b());
                z71.g().h();
            }
        }

        @Override // com.repackage.r61
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends r61 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ JSONArray b;

        public c(JSONObject jSONObject, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
            this.b = jSONArray;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.put(this.a);
                j81.g("localObject" + this.a);
            }
        }

        @Override // com.repackage.r61
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                j81.g("localObject success" + this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755903017, "Lcom/repackage/a81;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755903017, "Lcom/repackage/a81;");
                return;
            }
        }
        j = new Object();
    }

    public static void c() {
        List<x71> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (list = i) == null) {
            return;
        }
        list.clear();
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (a81.class) {
                List<x71> list = i;
                if (list != null && !list.isEmpty()) {
                    s61 g2 = g();
                    synchronized (j) {
                        JSONArray jSONArray = new JSONArray();
                        for (x71 x71Var : i) {
                            JSONObject d2 = x71Var.d();
                            if (d2 != null) {
                                jSONArray.put(d2);
                            }
                        }
                        g2.d("data", jSONArray.toString());
                        g2.d("s", HttpSigner.a(g2, "key", y61.a()));
                        c();
                    }
                    t61 h2 = h();
                    if (l81.d()) {
                        n();
                        new y71().a(h2, g2, new b(h2, g2));
                    } else {
                        l(h2.b(), g2.b());
                        z71.g().h();
                    }
                }
            }
        }
    }

    public static void e(x71 x71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, x71Var) == null) {
            if (i == null) {
                i = new ArrayList();
            }
            if (x71Var != null) {
                synchronized (j) {
                    i.add(x71Var);
                }
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            b81.a(new a());
        }
    }

    public static s61 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            s61 s61Var = new s61();
            s61Var.d(com.kuaishou.weapon.un.x.B, "cashier");
            s61Var.d("os", "android");
            s61Var.d("v", "2.8.7.9");
            if (!TextUtils.isEmpty(g)) {
                s61Var.d("n", g);
            }
            String b2 = a71.b();
            if (!TextUtils.isEmpty(b2)) {
                s61Var.d("nv", b2);
            }
            if (!TextUtils.isEmpty(h)) {
                s61Var.d("ss", h);
            }
            if (!TextUtils.isEmpty(b)) {
                s61Var.d("d", b);
            }
            if (!TextUtils.isEmpty(e)) {
                s61Var.d("dt", e);
            }
            if (!TextUtils.isEmpty(f)) {
                s61Var.d(com.kuaishou.weapon.un.x.w, f);
            }
            if (!TextUtils.isEmpty(c)) {
                s61Var.d(ContentUtil.RESULT_KEY_AK, c);
            }
            if (!TextUtils.isEmpty(d)) {
                s61Var.d(Config.DEVICE_ID_SEC, d);
            }
            return s61Var;
        }
        return (s61) invokeV.objValue;
    }

    public static t61 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            t61 t61Var = new t61();
            if (!TextUtils.isEmpty(a)) {
                t61Var.d("Cookie", "BDUSS=" + a);
            }
            return t61Var;
        }
        return (t61) invokeV.objValue;
    }

    public static JSONArray i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File file = new File(n81.a().getFilesDir(), "poly_cashier_statistics.json");
            if (file.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(h81.b(file));
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

    public static void j(int i2, String str, String str2) {
        x71 x71Var;
        x71 x71Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, null, i2, str, str2) == null) {
            if (i2 != 0) {
                if (i2 == 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("selects", v71.a);
                        v71.a = 0;
                        jSONObject.put("hbit", v71.b);
                        v71.b = "0";
                    } catch (JSONException unused) {
                    }
                    x71Var2 = new x71("4");
                    x71Var2.c(jSONObject);
                } else if (i2 != 3) {
                    x71Var = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("exceptionType", str2);
                        jSONObject2.put("msg", str);
                    } catch (JSONException unused2) {
                    }
                    x71Var2 = new x71("3");
                    x71Var2.c(jSONObject2);
                }
                x71Var = x71Var2;
            } else {
                x71Var = new x71("2");
            }
            if (x71Var != null) {
                e(x71Var);
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            a = null;
            b = null;
            e = null;
            f = null;
            g = null;
            h = null;
        }
    }

    public static void l(Map map, Map map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, map, map2) == null) {
            try {
                JSONArray i2 = i();
                if (i2 != null) {
                    if (i2.length() >= 20) {
                        i2.remove(0);
                    }
                } else {
                    i2 = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject b2 = k81.b(map);
                JSONObject b3 = k81.b(map2);
                jSONObject.put("header", b2);
                jSONObject.put(TtmlNode.TAG_BODY, b3);
                i2.put(jSONObject);
                m(i2);
            } catch (Exception unused) {
            }
        }
    }

    public static void m(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        j81.g("localArray" + jSONArray.length() + jSONArray.toString());
        h81.d(jSONArray.toString(), new File(n81.a().getFilesDir(), "poly_cashier_statistics.json"));
    }

    public static boolean n() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            JSONArray i2 = i();
            if (i2 == null || i2.length() == 0) {
                return true;
            }
            try {
                jSONArray = new JSONArray();
                for (int i3 = 0; i3 < i2.length(); i3++) {
                    JSONObject jSONObject = i2.getJSONObject(i3);
                    t61 t61Var = new t61();
                    t61Var.e(k81.d(jSONObject.optJSONObject("header")));
                    s61 s61Var = new s61();
                    s61Var.e(k81.d(jSONObject.optJSONObject(TtmlNode.TAG_BODY)));
                    new y71().a(t61Var, s61Var, new c(jSONObject, jSONArray));
                }
            } catch (Exception unused) {
            }
            if (jSONArray.length() == 0) {
                return true;
            }
            m(jSONArray);
            return false;
        }
        return invokeV.booleanValue;
    }
}
