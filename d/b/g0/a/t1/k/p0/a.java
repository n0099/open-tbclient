package d.b.g0.a.t1.k.p0;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.i2.b0;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46856a = d.b.g0.a.k.f45443a;

    /* renamed from: d.b.g0.a.t1.k.p0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0854a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46857e;

        public RunnableC0854a(String str) {
            this.f46857e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
            if (W != null) {
                f.b i = W.i(this.f46857e);
                i.f();
                i.b();
            }
        }
    }

    public static JSONObject a(@NonNull d.b.g0.a.r1.e eVar, String str, String str2, List<String> list) {
        String d2 = i0.d(str);
        String n = i0.n(str);
        String b2 = j.b(d2);
        String P = eVar.P(d2);
        String Q = eVar.Q(d2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str2);
            jSONObject.put("root", P);
            jSONObject.put("pageType", Q);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("pageUrl", str);
            }
            if (!TextUtils.equals(d2, b2)) {
                if (!TextUtils.isEmpty(n)) {
                    b2 = b2 + "?" + n;
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
            if (f46856a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject b(String str) {
        return c(str, "");
    }

    public static JSONObject c(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wvID", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("pageUrl", str2);
            }
        } catch (JSONException e2) {
            if (f46856a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [d.b.g0.a.p.d.c] */
    public static void d(d.b.g0.a.p.d.b bVar, d.b.g0.a.e1.b bVar2, String str) {
        d.b.g0.a.j1.h.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createAndLoadPage start.");
        String c2 = k0.c(bVar2.f44756c, bVar2.f44754a, bVar2.f44755b);
        d.b.g0.a.r1.n.c k = d.b.g0.a.z0.f.V().k(bVar2.f44757d);
        d.b.g0.a.e0.w.b bVar3 = new d.b.g0.a.e0.w.b();
        bVar3.i = bVar.w();
        bVar3.f44709a = bVar2.f44756c;
        if (d.b.g0.a.r1.e.y() != null) {
            bVar3.f44711c = d.b.g0.a.r1.e.y().Q(bVar2.f44757d);
        }
        bVar3.k = d.b.g0.a.e0.w.a.b(d.b.g0.a.r1.e.y(), bVar2.f44754a);
        bVar3.f44710b = d.b.g0.a.e1.b.a(bVar2);
        bVar3.f44712d = k.f46169g;
        bVar3.f44713e = String.valueOf(d.b.g0.a.c0.a.a());
        if (d.b.g0.a.r1.e.y() != null) {
            String K = d.b.g0.a.r1.e.y().K(bVar2.f44757d);
            if (!TextUtils.isEmpty(K)) {
                if (f46856a) {
                    Log.d("ActionUtils", "add initData: " + K);
                }
                bVar3.f44714f = K;
            }
        }
        bVar3.f44715g = f46856a || d.b.g0.a.z0.f.V().O();
        bVar3.f44716h = str;
        if (d.b.g0.a.m1.a.a.C()) {
            bVar3.j = d.b.g0.a.c0.d.b.d();
        }
        d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("slave_dispatch_start"));
        b0.d();
        bVar.F().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, bVar2.d());
        bVar.s(bVar3.f44710b);
        d.b.g0.a.z0.f.V().z(bVar.c(), d.b.g0.a.e0.w.b.a(bVar3));
        d.b.g0.a.z1.e.B(bVar.c(), bVar3.f44710b);
        d.b.g0.a.e0.v.b.i(c2, bVar);
        d.b.g0.a.j1.h.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createAndLoadPage end.");
    }

    public static void e(String str, String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("from", str2);
        }
        hashMap.put("url", str3);
        d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.b(str, hashMap));
    }

    public static List<String> f(d.b.g0.a.e0.l.f fVar) {
        d.b.g0.a.e0.l.c j;
        if (fVar != null && fVar.k() >= d.b.g0.a.t.c.i.b.f46504d && (j = fVar.j(0)) != null && (j instanceof d.b.g0.a.e0.l.e)) {
            return ((d.b.g0.a.e0.l.e) j).Y2();
        }
        return null;
    }

    public static String g() {
        d.b.g0.a.p.d.b T2;
        d.b.g0.a.e0.l.e A = d.b.g0.a.z0.f.V().A();
        if (A == null || (T2 = A.T2()) == null) {
            return null;
        }
        return T2.R();
    }

    public static boolean h(@NonNull String str) {
        String g2 = g();
        if (f46856a) {
            Log.i("ActionUtils", "lastPageUrl: " + g2 + "\ncurPageUrl: " + str);
        }
        if (g2 != null && str != null) {
            String p1 = d.b.g0.a.y0.e.b.p1(g2);
            String p12 = d.b.g0.a.y0.e.b.p1(str);
            return (TextUtils.equals(p1, p12) || TextUtils.equals(Uri.decode(p1), p12) || TextUtils.equals(p1, Uri.decode(p12))) ? false : true;
        }
        return false;
    }

    public static void i(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No Package").toString(), str);
    }

    public static void j(d.b.g0.a.t.b.a aVar, String str) {
        if (aVar == null) {
            return;
        }
        aVar.c(str, new d.b.g0.a.t.e.b(1001, "No Package"));
    }

    public static void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, String str, String str2, List<String> list, String str3) {
        if (eVar == null || TextUtils.isEmpty(str3)) {
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a(eVar, str2, str, list), 0).toString(), str3);
    }

    public static void l(d.b.g0.a.t.b.a aVar, d.b.g0.a.r1.e eVar, String str, String str2, List<String> list, String str3) {
        if (aVar == null || eVar == null || TextUtils.isEmpty(str3)) {
            return;
        }
        aVar.c(str3, new d.b.g0.a.t.e.b(0, a(eVar, str2, str, list)));
    }

    public static String m(UnitedSchemeEntity unitedSchemeEntity, String str, String str2) {
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
            if (f46856a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static String n(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return m(unitedSchemeEntity, str, "url");
    }

    @Nullable
    public static String o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString("url");
    }

    public static void p(String str) {
        k0.T(new RunnableC0854a(str));
    }
}
