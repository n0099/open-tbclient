package com.bytedance.sdk.openadsdk.e.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.e.b.d;
import com.bytedance.sdk.openadsdk.e.b.e;
import com.bytedance.sdk.openadsdk.e.b.f;
import com.bytedance.sdk.openadsdk.e.b.g;
import com.bytedance.sdk.openadsdk.e.b.h;
import com.bytedance.sdk.openadsdk.e.b.i;
import com.bytedance.sdk.openadsdk.e.b.j;
import com.bytedance.sdk.openadsdk.e.b.l;
import com.bytedance.sdk.openadsdk.e.b.n;
import com.bytedance.sdk.openadsdk.e.b.o;
import com.bytedance.sdk.openadsdk.e.p;
import com.bytedance.sdk.openadsdk.n.f.b;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final WeakHashMap<p, o> f68031a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-549808217, "Lcom/bytedance/sdk/openadsdk/e/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-549808217, "Lcom/bytedance/sdk/openadsdk/e/a/a;");
                return;
            }
        }
        f68031a = new WeakHashMap<>();
    }

    public static JSONObject a(m mVar, String str, int i2) {
        InterceptResult invokeLLI;
        x V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, mVar, str, i2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("session_id", str);
                }
                if (i2 > 0) {
                    jSONObject.put("play_type", String.valueOf(i2));
                }
                if (mVar != null && (V = mVar.V()) != null) {
                    jSONObject.put("video_resolution", V.f());
                    jSONObject.put("video_size", Long.valueOf(V.d()));
                    jSONObject.put("video_url", V.i());
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLI.objValue;
    }

    public static void b(com.bytedance.sdk.openadsdk.e.b.a<l> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, aVar) == null) {
            a(aVar, "load_video_success");
        }
    }

    public static void c(com.bytedance.sdk.openadsdk.e.b.a<j> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, aVar) == null) {
            a(aVar, "load_video_error");
        }
    }

    public static void d(com.bytedance.sdk.openadsdk.e.b.a<i> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            a(aVar, "load_video_cancel");
        }
    }

    public static void e(Context context, p pVar, o.a aVar) {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65549, null, context, pVar, aVar) == null) || context == null || pVar == null || aVar == null || (oVar = f68031a.get(pVar)) == null) {
            return;
        }
        b d2 = oVar.d();
        m e2 = oVar.e();
        if (d2 == null || e2 == null) {
            return;
        }
        long a2 = aVar.a();
        long c2 = aVar.c();
        if (c2 <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.e.b.b bVar = new com.bytedance.sdk.openadsdk.e.b.b();
        bVar.a(aVar.b());
        bVar.b(c2);
        bVar.a(aVar.f());
        bVar.b(aVar.g());
        com.bytedance.sdk.openadsdk.e.b.a aVar2 = new com.bytedance.sdk.openadsdk.e.b.a(context, e2, q.a(e2), a(e2, oVar.b(), oVar.c()), bVar);
        aVar2.a(aVar.l());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", a2);
            jSONObject.put(SapiOptions.KEY_CACHE_PERCENT, aVar.h());
            a(aVar2, "endcard_skip", jSONObject);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static void f(Context context, p pVar, o.a aVar) {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65550, null, context, pVar, aVar) == null) || context == null || pVar == null || aVar == null || (oVar = f68031a.get(pVar)) == null) {
            return;
        }
        b d2 = oVar.d();
        m e2 = oVar.e();
        if (d2 == null || e2 == null) {
            return;
        }
        long a2 = aVar.a();
        long c2 = aVar.c();
        if (c2 <= 0) {
            return;
        }
        d dVar = new d();
        dVar.b(aVar.b());
        dVar.a(c2);
        dVar.a(aVar.i());
        dVar.b(aVar.j());
        com.bytedance.sdk.openadsdk.e.b.a aVar2 = new com.bytedance.sdk.openadsdk.e.b.a(context, e2, q.a(e2), a(e2, oVar.b(), oVar.c()), dVar);
        aVar2.a(aVar.l());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", a2);
            jSONObject.put(SapiOptions.KEY_CACHE_PERCENT, aVar.h());
            a(aVar2, "feed_break", jSONObject);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        f68031a.remove(pVar);
    }

    public static void g(Context context, p pVar, o.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65551, null, context, pVar, aVar) == null) || context == null || pVar == null || aVar == null) {
            return;
        }
        h(context, pVar, aVar);
        o oVar = f68031a.get(pVar);
        if (oVar == null) {
            return;
        }
        b d2 = oVar.d();
        m e2 = oVar.e();
        if (d2 == null || e2 == null) {
            return;
        }
        long a2 = aVar.a();
        long c2 = aVar.c();
        if (c2 <= 0) {
            return;
        }
        f fVar = new f();
        fVar.b(aVar.b());
        fVar.a(c2);
        fVar.a(aVar.j());
        com.bytedance.sdk.openadsdk.e.b.a aVar2 = new com.bytedance.sdk.openadsdk.e.b.a(context, e2, q.a(e2), a(e2, oVar.b(), oVar.c()), fVar);
        aVar2.a(aVar.l());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", a2);
            jSONObject.put(SapiOptions.KEY_CACHE_PERCENT, aVar.h());
            a(aVar2, "feed_over", jSONObject);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        f68031a.remove(pVar);
    }

    public static void h(Context context, p pVar, o.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65552, null, context, pVar, aVar) == null) || context == null || pVar == null || aVar == null) {
            return;
        }
        if (aVar.k() <= 0) {
            k.c("VideoEventManager", "Cancel log report when buffer count is 0");
            return;
        }
        o oVar = f68031a.get(pVar);
        if (oVar == null) {
            return;
        }
        b d2 = oVar.d();
        m e2 = oVar.e();
        if (d2 == null || e2 == null) {
            return;
        }
        long c2 = aVar.c();
        if (c2 <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.e.b.m mVar = new com.bytedance.sdk.openadsdk.e.b.m();
        mVar.a(aVar.b());
        mVar.b(c2);
        mVar.a(aVar.k());
        com.bytedance.sdk.openadsdk.e.b.a aVar2 = new com.bytedance.sdk.openadsdk.e.b.a(context, e2, q.a(e2), a(e2, oVar.b(), oVar.c()), mVar);
        aVar2.a(aVar.l());
        a(aVar2, "play_buffer");
    }

    public static void b(Context context, p pVar, o.a aVar) {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, context, pVar, aVar) == null) || context == null || pVar == null || aVar == null || (oVar = f68031a.get(pVar)) == null) {
            return;
        }
        b d2 = oVar.d();
        m e2 = oVar.e();
        if (d2 == null || e2 == null) {
            return;
        }
        long a2 = aVar.a();
        long c2 = aVar.c();
        if (c2 <= 0) {
            return;
        }
        g gVar = new g();
        gVar.a(aVar.b());
        gVar.b(c2);
        com.bytedance.sdk.openadsdk.e.b.a aVar2 = new com.bytedance.sdk.openadsdk.e.b.a(context, e2, q.a(e2), a(e2, oVar.b(), oVar.c()), gVar);
        aVar2.a(aVar.l());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", a2);
            jSONObject.put(SapiOptions.KEY_CACHE_PERCENT, aVar.h());
            a(aVar2, "feed_pause", jSONObject);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static void c(Context context, p pVar, o.a aVar) {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, context, pVar, aVar) == null) || context == null || pVar == null || aVar == null || (oVar = f68031a.get(pVar)) == null) {
            return;
        }
        b d2 = oVar.d();
        m e2 = oVar.e();
        if (d2 == null || e2 == null) {
            return;
        }
        long a2 = aVar.a();
        long c2 = aVar.c();
        if (c2 <= 0) {
            return;
        }
        e eVar = new e();
        eVar.a(aVar.b());
        eVar.b(c2);
        com.bytedance.sdk.openadsdk.e.b.a aVar2 = new com.bytedance.sdk.openadsdk.e.b.a(context, e2, q.a(e2), a(e2, oVar.b(), oVar.c()), eVar);
        aVar2.a(aVar.l());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", a2);
            jSONObject.put(SapiOptions.KEY_CACHE_PERCENT, aVar.h());
            a(aVar2, "feed_continue", jSONObject);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static void d(Context context, p pVar, o.a aVar) {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, context, pVar, aVar) == null) || context == null || pVar == null || aVar == null || (oVar = f68031a.get(pVar)) == null) {
            return;
        }
        b d2 = oVar.d();
        m e2 = oVar.e();
        if (d2 == null || e2 == null) {
            return;
        }
        long a2 = aVar.a();
        long c2 = aVar.c();
        if (c2 <= 0) {
            return;
        }
        n nVar = new n();
        nVar.a(aVar.b());
        nVar.b(c2);
        nVar.a(aVar.d());
        nVar.b(aVar.e());
        com.bytedance.sdk.openadsdk.e.b.a aVar2 = new com.bytedance.sdk.openadsdk.e.b.a(context, e2, q.a(e2), a(e2, oVar.b(), oVar.c()), nVar);
        aVar2.a(aVar.l());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", a2);
            jSONObject.put(SapiOptions.KEY_CACHE_PERCENT, aVar.h());
            a(aVar2, "play_error", jSONObject);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.e.b.a<com.bytedance.sdk.openadsdk.e.b.k> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) {
            a(aVar, "load_video_start");
        }
    }

    public static void a(Context context, m mVar, p pVar, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, context, mVar, pVar, bVar) == null) || mVar == null || pVar == null || bVar == null) {
            return;
        }
        String uuid = UUID.randomUUID().toString();
        int i2 = bVar.m() ? 1 : 2;
        f68031a.put(pVar, new o(SystemClock.elapsedRealtime(), uuid, i2, bVar, mVar));
        com.bytedance.sdk.openadsdk.e.b.a aVar = new com.bytedance.sdk.openadsdk.e.b.a(context, mVar, q.a(mVar), a(mVar, uuid, i2), null);
        aVar.a(bVar.o());
        a(aVar, "play_start");
    }

    public static void a(Context context, p pVar, o.a aVar) {
        o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, pVar, aVar) == null) || context == null || pVar == null || aVar == null || (oVar = f68031a.get(pVar)) == null) {
            return;
        }
        b d2 = oVar.d();
        m e2 = oVar.e();
        if (d2 == null || e2 == null) {
            return;
        }
        h hVar = new h();
        hVar.a(aVar.m() ? 1 : 0);
        hVar.b(d2.n());
        hVar.a(SystemClock.elapsedRealtime() - oVar.a());
        com.bytedance.sdk.openadsdk.e.b.a aVar2 = new com.bytedance.sdk.openadsdk.e.b.a(context, e2, q.a(e2), a(e2, oVar.b(), oVar.c()), hVar);
        aVar2.a(aVar.l());
        a(aVar2, "feed_play");
    }

    public static void a(com.bytedance.sdk.openadsdk.e.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, str) == null) {
            a(aVar, str, (JSONObject) null);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.e.b.a aVar, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, aVar, str, jSONObject) == null) || aVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            JSONObject d2 = aVar.d();
            if (aVar.e() != null) {
                aVar.e().a(d2);
            }
            jSONObject.put("ad_extra_data", d2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (aVar.f() && !TextUtils.isEmpty(aVar.c())) {
            String c2 = aVar.c();
            char c3 = 65535;
            int hashCode = c2.hashCode();
            if (hashCode != -891990144) {
                if (hashCode != -712491894) {
                    if (hashCode == 1912999166 && c2.equals("draw_ad")) {
                        c3 = 2;
                    }
                } else if (c2.equals("embeded_ad")) {
                    c3 = 0;
                }
            } else if (c2.equals("stream")) {
                c3 = 1;
            }
            if (c3 == 0 || c3 == 1 || c3 == 2) {
                str = "customer_" + str;
            }
        }
        k.b("VideoEventManager", "reportLog:  tag=", aVar.c(), "  label=", str, "  ad_extra_data=", jSONObject);
        com.bytedance.sdk.openadsdk.e.d.c(aVar.a(), aVar.b(), aVar.c(), str, jSONObject);
    }
}
