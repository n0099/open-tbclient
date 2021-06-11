package d.a.l0.a.c2.f.p0;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.v2.d0;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44824a = d.a.l0.a.k.f46875a;

    /* renamed from: d.a.l0.a.c2.f.p0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0643a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44825e;

        public RunnableC0643a(String str) {
            this.f44825e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
            if (W != null) {
                g.b i2 = W.i(this.f44825e);
                i2.f();
                i2.b();
                d.a.l0.a.e0.d.h("ActionUtils", "popAllFragment: finish");
            }
        }
    }

    public static d.a.l0.a.h0.u.d a(d.a.l0.a.p.e.b<?> bVar, d.a.l0.a.l1.b bVar2, String str) {
        d.a.l0.a.a2.n.g e2 = d.a.l0.a.g1.f.V().e(bVar2.f47036h);
        d.a.l0.a.h0.u.d dVar = new d.a.l0.a.h0.u.d();
        dVar.f46296i = bVar.L();
        dVar.f46288a = bVar2.f47035g;
        if (d.a.l0.a.a2.e.i() != null) {
            dVar.f46290c = d.a.l0.a.a2.e.i().S(bVar2.f47036h);
        }
        dVar.k = d.a.l0.a.h0.u.a.c(d.a.l0.a.a2.e.i(), bVar2.f47033e);
        dVar.f46289b = d.a.l0.a.l1.b.c(bVar2);
        dVar.f46291d = e2.f44474g;
        dVar.f46292e = String.valueOf(d.a.l0.a.e0.a.a());
        if (d.a.l0.a.a2.e.i() != null) {
            String M = d.a.l0.a.a2.e.i().M(bVar2.f47036h);
            if (!TextUtils.isEmpty(M)) {
                if (f44824a) {
                    Log.d("ActionUtils", "add initData: " + M);
                }
                dVar.f46293f = M;
            }
        }
        dVar.f46294g = f44824a || d.a.l0.a.g1.f.V().O();
        dVar.f46295h = str;
        if (d.a.l0.a.u1.a.a.G()) {
            dVar.j = d.a.l0.a.e0.f.b.d();
        }
        if (f44824a) {
            Log.i("ActionUtils", "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace()));
        }
        d.a.l0.a.n2.g.a.b(dVar.f46288a, dVar.f46289b);
        return dVar;
    }

    public static JSONObject b(@NonNull d.a.l0.a.a2.e eVar, String str, String str2, List<String> list) {
        String f2 = o0.f(str);
        String o = o0.o(str);
        String b2 = j.b(f2);
        String R = eVar.R(f2);
        String S = eVar.S(f2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
            jSONObject.put(PrefetchEvent.EVENT_DATA_ROOT_PATH, R);
            jSONObject.put("pageType", S);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(f2, b2)) {
                if (!TextUtils.isEmpty(o)) {
                    b2 = b2 + "?" + o;
                }
                jSONObject.put("pageRoutePath", b2);
            }
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str3 : list) {
                    jSONArray.put(str3);
                }
                jSONObject.put("removedSlaveIDs", jSONArray);
            }
        } catch (JSONException e2) {
            if (f44824a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject c(String str) {
        return d(str, "");
    }

    public static JSONObject d(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("pageUrl", str2);
            }
        } catch (JSONException e2) {
            if (f44824a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [d.a.l0.a.p.e.c] */
    public static void e(d.a.l0.a.p.e.b<?> bVar, d.a.l0.a.l1.b bVar2, String str) {
        d.a.l0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createAndLoadPage start.");
        String a2 = q0.a(bVar2.f47035g, bVar2.f47033e, bVar2.f47034f);
        d.a.l0.a.h0.u.d a3 = a(bVar, bVar2, str);
        d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("slave_dispatch_start"));
        d0.d();
        bVar.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar2.f());
        bVar.S(a3.f46289b);
        d.a.l0.a.g1.f.V().m(bVar.b(), d.a.l0.a.h0.u.d.a(a3));
        if (d.a.l0.a.h0.u.e.b()) {
            d.a.l0.a.h0.u.e eVar = new d.a.l0.a.h0.u.e();
            eVar.f46299a = bVar.b();
            d.a.l0.a.g1.f.V().v(d.a.l0.a.h0.u.e.a(eVar));
        }
        d.a.l0.a.j2.e.F(bVar.b(), a3.f46289b);
        d.a.l0.a.h0.t.a.m(a2, bVar);
        d.a.l0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createAndLoadPage end.");
    }

    public static void f(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        d.a.l0.a.o0.d.b bVar = new d.a.l0.a.o0.d.b(str, hashMap);
        PrefetchEvent.c b2 = PrefetchEvent.b(str2);
        if (b2 == null) {
            d.a.l0.a.g1.f.V().v(bVar);
            return;
        }
        d.a.l0.a.h0.u.c cVar = new d.a.l0.a.h0.u.c();
        cVar.h(b2);
        cVar.h(bVar);
        d.a.l0.a.g1.f.V().v(cVar);
    }

    public static List<String> g(d.a.l0.a.h0.g.g gVar) {
        d.a.l0.a.h0.g.d j;
        if (gVar != null && gVar.k() >= d.a.l0.a.u.e.k.b.f48753d && (j = gVar.j(0)) != null && (j instanceof d.a.l0.a.h0.g.f)) {
            return ((d.a.l0.a.h0.g.f) j).h3();
        }
        return null;
    }

    public static String h() {
        d.a.l0.a.p.e.b b3;
        d.a.l0.a.h0.g.f J = d.a.l0.a.g1.f.V().J();
        if (J == null || (b3 = J.b3()) == null) {
            return null;
        }
        return b3.o();
    }

    public static boolean i(@NonNull String str) {
        String h2 = h();
        if (f44824a) {
            Log.i("ActionUtils", "lastPageUrl: " + h2 + "\ncurPageUrl: " + str);
        }
        if (h2 != null && str != null) {
            String w1 = d.a.l0.a.f1.e.b.w1(h2);
            String w12 = d.a.l0.a.f1.e.b.w1(str);
            return (TextUtils.equals(w1, w12) || TextUtils.equals(Uri.decode(w1), w12) || TextUtils.equals(w1, Uri.decode(w12))) ? false : true;
        }
        return false;
    }

    public static void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No Package").toString(), str);
    }

    public static void k(d.a.l0.a.u.c.a aVar, String str) {
        if (aVar == null) {
            return;
        }
        aVar.d(str, new d.a.l0.a.u.h.b(1001, "No Package"));
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, String str, String str2, List<String> list, String str3) {
        if (eVar == null || TextUtils.isEmpty(str3)) {
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(eVar, str2, str, list), 0).toString(), str3);
    }

    public static void m(d.a.l0.a.u.c.a aVar, d.a.l0.a.a2.e eVar, String str, String str2, List<String> list, String str3) {
        if (aVar == null || eVar == null || TextUtils.isEmpty(str3)) {
            return;
        }
        aVar.d(str3, new d.a.l0.a.u.h.b(0, b(eVar, str2, str, list)));
    }

    public static String n(UnitedSchemeEntity unitedSchemeEntity, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = unitedSchemeEntity.getParams().get(str);
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            return new JSONObject(str3).optString(str2);
        } catch (JSONException e2) {
            if (f44824a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static String o(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return n(unitedSchemeEntity, str, "url");
    }

    @Nullable
    public static String p(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString("url");
    }

    public static void q(String str) {
        d.a.l0.a.e0.d.h("ActionUtils", "popAllFragment: routeType=" + str);
        q0.b0(new RunnableC0643a(str));
    }
}
