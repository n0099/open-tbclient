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
/* loaded from: classes6.dex */
public class n91 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static List<k91> i;
    public static Object j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                n91.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends e81 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g81 a;
        public final /* synthetic */ f81 b;

        public b(g81 g81Var, f81 f81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g81Var, f81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g81Var;
            this.b = f81Var;
        }

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                n91.l(this.a.b(), this.b.b());
                m91.g().h();
            }
        }

        @Override // com.repackage.e81
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends e81 {
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

        @Override // com.repackage.e81
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.put(this.a);
                w91.g("localObject" + this.a);
            }
        }

        @Override // com.repackage.e81
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                w91.g("localObject success" + this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755514773, "Lcom/repackage/n91;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755514773, "Lcom/repackage/n91;");
                return;
            }
        }
        j = new Object();
    }

    public static void c() {
        List<k91> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (list = i) == null) {
            return;
        }
        list.clear();
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (n91.class) {
                List<k91> list = i;
                if (list != null && !list.isEmpty()) {
                    f81 g2 = g();
                    synchronized (j) {
                        JSONArray jSONArray = new JSONArray();
                        for (k91 k91Var : i) {
                            JSONObject d2 = k91Var.d();
                            if (d2 != null) {
                                jSONArray.put(d2);
                            }
                        }
                        g2.d("data", jSONArray.toString());
                        g2.d("s", HttpSigner.a(g2, "key", l81.a()));
                        c();
                    }
                    g81 h2 = h();
                    if (y91.d()) {
                        n();
                        new l91().a(h2, g2, new b(h2, g2));
                    } else {
                        l(h2.b(), g2.b());
                        m91.g().h();
                    }
                }
            }
        }
    }

    public static void e(k91 k91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, k91Var) == null) {
            if (i == null) {
                i = new ArrayList();
            }
            if (k91Var != null) {
                synchronized (j) {
                    i.add(k91Var);
                }
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            o91.a(new a());
        }
    }

    public static f81 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            f81 f81Var = new f81();
            f81Var.d(com.kuaishou.weapon.un.x.B, "cashier");
            f81Var.d("os", "android");
            f81Var.d("v", "2.8.7.9");
            if (!TextUtils.isEmpty(g)) {
                f81Var.d("n", g);
            }
            String b2 = n81.b();
            if (!TextUtils.isEmpty(b2)) {
                f81Var.d("nv", b2);
            }
            if (!TextUtils.isEmpty(h)) {
                f81Var.d("ss", h);
            }
            if (!TextUtils.isEmpty(b)) {
                f81Var.d("d", b);
            }
            if (!TextUtils.isEmpty(e)) {
                f81Var.d("dt", e);
            }
            if (!TextUtils.isEmpty(f)) {
                f81Var.d(com.kuaishou.weapon.un.x.w, f);
            }
            if (!TextUtils.isEmpty(c)) {
                f81Var.d(ContentUtil.RESULT_KEY_AK, c);
            }
            if (!TextUtils.isEmpty(d)) {
                f81Var.d(Config.DEVICE_ID_SEC, d);
            }
            return f81Var;
        }
        return (f81) invokeV.objValue;
    }

    public static g81 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            g81 g81Var = new g81();
            if (!TextUtils.isEmpty(a)) {
                g81Var.d("Cookie", "BDUSS=" + a);
            }
            return g81Var;
        }
        return (g81) invokeV.objValue;
    }

    public static JSONArray i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File file = new File(aa1.a().getFilesDir(), "poly_cashier_statistics.json");
            if (file.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(u91.b(file));
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
        k91 k91Var;
        k91 k91Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, null, i2, str, str2) == null) {
            if (i2 != 0) {
                if (i2 == 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("selects", i91.a);
                        i91.a = 0;
                        jSONObject.put("hbit", i91.b);
                        i91.b = "0";
                    } catch (JSONException unused) {
                    }
                    k91Var2 = new k91("4");
                    k91Var2.c(jSONObject);
                } else if (i2 != 3) {
                    k91Var = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("exceptionType", str2);
                        jSONObject2.put("msg", str);
                    } catch (JSONException unused2) {
                    }
                    k91Var2 = new k91("3");
                    k91Var2.c(jSONObject2);
                }
                k91Var = k91Var2;
            } else {
                k91Var = new k91("2");
            }
            if (k91Var != null) {
                e(k91Var);
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
                JSONObject b2 = x91.b(map);
                JSONObject b3 = x91.b(map2);
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
        w91.g("localArray" + jSONArray.length() + jSONArray.toString());
        u91.d(jSONArray.toString(), new File(aa1.a().getFilesDir(), "poly_cashier_statistics.json"));
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
                    g81 g81Var = new g81();
                    g81Var.e(x91.d(jSONObject.optJSONObject("header")));
                    f81 f81Var = new f81();
                    f81Var.e(x91.d(jSONObject.optJSONObject(TtmlNode.TAG_BODY)));
                    new l91().a(g81Var, f81Var, new c(jSONObject, jSONArray));
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
