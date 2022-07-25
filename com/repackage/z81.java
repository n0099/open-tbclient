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
/* loaded from: classes7.dex */
public class z81 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static List<w81> i;
    public static Object j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
                z81.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends q71 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s71 a;
        public final /* synthetic */ r71 b;

        public b(s71 s71Var, r71 r71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s71Var, r71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s71Var;
            this.b = r71Var;
        }

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                z81.l(this.a.b(), this.b.b());
                y81.g().h();
            }
        }

        @Override // com.repackage.q71
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends q71 {
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

        @Override // com.repackage.q71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.put(this.a);
                i91.g("localObject" + this.a);
            }
        }

        @Override // com.repackage.q71
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                i91.g("localObject success" + this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755158242, "Lcom/repackage/z81;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755158242, "Lcom/repackage/z81;");
                return;
            }
        }
        j = new Object();
    }

    public static void c() {
        List<w81> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (list = i) == null) {
            return;
        }
        list.clear();
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (z81.class) {
                List<w81> list = i;
                if (list != null && !list.isEmpty()) {
                    r71 g2 = g();
                    synchronized (j) {
                        JSONArray jSONArray = new JSONArray();
                        for (w81 w81Var : i) {
                            JSONObject d2 = w81Var.d();
                            if (d2 != null) {
                                jSONArray.put(d2);
                            }
                        }
                        g2.d("data", jSONArray.toString());
                        g2.d("s", HttpSigner.a(g2, "key", x71.a()));
                        c();
                    }
                    s71 h2 = h();
                    if (k91.d()) {
                        n();
                        new x81().a(h2, g2, new b(h2, g2));
                    } else {
                        l(h2.b(), g2.b());
                        y81.g().h();
                    }
                }
            }
        }
    }

    public static void e(w81 w81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, w81Var) == null) {
            if (i == null) {
                i = new ArrayList();
            }
            if (w81Var != null) {
                synchronized (j) {
                    i.add(w81Var);
                }
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            a91.a(new a());
        }
    }

    public static r71 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            r71 r71Var = new r71();
            r71Var.d(com.kuaishou.weapon.p0.u.A, "cashier");
            r71Var.d("os", "android");
            r71Var.d("v", "2.8.7.9");
            if (!TextUtils.isEmpty(g)) {
                r71Var.d("n", g);
            }
            String b2 = z71.b();
            if (!TextUtils.isEmpty(b2)) {
                r71Var.d("nv", b2);
            }
            if (!TextUtils.isEmpty(h)) {
                r71Var.d("ss", h);
            }
            if (!TextUtils.isEmpty(b)) {
                r71Var.d("d", b);
            }
            if (!TextUtils.isEmpty(e)) {
                r71Var.d("dt", e);
            }
            if (!TextUtils.isEmpty(f)) {
                r71Var.d(com.kuaishou.weapon.p0.u.v, f);
            }
            if (!TextUtils.isEmpty(c)) {
                r71Var.d(ContentUtil.RESULT_KEY_AK, c);
            }
            if (!TextUtils.isEmpty(d)) {
                r71Var.d(Config.DEVICE_ID_SEC, d);
            }
            return r71Var;
        }
        return (r71) invokeV.objValue;
    }

    public static s71 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            s71 s71Var = new s71();
            if (!TextUtils.isEmpty(a)) {
                s71Var.d("Cookie", "BDUSS=" + a);
            }
            return s71Var;
        }
        return (s71) invokeV.objValue;
    }

    public static JSONArray i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File file = new File(m91.a().getFilesDir(), "poly_cashier_statistics.json");
            if (file.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(g91.b(file));
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
        w81 w81Var;
        w81 w81Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, null, i2, str, str2) == null) {
            if (i2 != 0) {
                if (i2 == 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("selects", u81.a);
                        u81.a = 0;
                        jSONObject.put("hbit", u81.b);
                        u81.b = "0";
                    } catch (JSONException unused) {
                    }
                    w81Var2 = new w81("4");
                    w81Var2.c(jSONObject);
                } else if (i2 != 3) {
                    w81Var = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("exceptionType", str2);
                        jSONObject2.put("msg", str);
                    } catch (JSONException unused2) {
                    }
                    w81Var2 = new w81("3");
                    w81Var2.c(jSONObject2);
                }
                w81Var = w81Var2;
            } else {
                w81Var = new w81("2");
            }
            if (w81Var != null) {
                e(w81Var);
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
                JSONObject b2 = j91.b(map);
                JSONObject b3 = j91.b(map2);
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
        i91.g("localArray" + jSONArray.length() + jSONArray.toString());
        g91.d(jSONArray.toString(), new File(m91.a().getFilesDir(), "poly_cashier_statistics.json"));
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
                    s71 s71Var = new s71();
                    s71Var.e(j91.d(jSONObject.optJSONObject("header")));
                    r71 r71Var = new r71();
                    r71Var.e(j91.d(jSONObject.optJSONObject(TtmlNode.TAG_BODY)));
                    new x81().a(s71Var, r71Var, new c(jSONObject, jSONArray));
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
