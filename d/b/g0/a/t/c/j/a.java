package d.b.g0.a.t.c.j;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.a.i2.i;
import d.b.g0.a.i2.v;
import d.b.g0.a.t.b.c;
import d.b.g0.a.t.b.d;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.y0.e.b;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.g0.a.t.b.d {

    /* renamed from: d.b.g0.a.t.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0823a extends d.b.g0.a.t.b.c {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46150d;

        /* renamed from: d.b.g0.a.t.c.j.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0824a implements d.b.g0.a.i2.u0.b<h<JSONObject>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f46152e;

            public C0824a(C0823a c0823a, c.b bVar) {
                this.f46152e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(h<JSONObject> hVar) {
                if (hVar.c() && hVar.f46808a != null) {
                    this.f46152e.a(new d.b.g0.a.t.e.b(0, hVar.f46808a));
                    d.b.g0.a.r1.e s = d.b.g0.a.r1.d.e().s();
                    s.R().A(f.a(s), hVar.f46808a.toString());
                    d.b.g0.a.c0.c.g("Api-Setting", "getSwanId success");
                    return;
                }
                this.f46152e.a(new d.b.g0.a.t.e.b(10001, "getSwanId failed: internal_error"));
                d.b.g0.a.c0.c.b("Api-Setting", "getSwanId failed: internal_error");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0823a(String str, JSONObject jSONObject) {
            super(str);
            this.f46150d = jSONObject;
        }

        @Override // d.b.g0.a.t.b.c
        @NonNull
        public d.b.g0.a.t.e.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            if (d.b.g0.a.j1.m.c.b() && a.this.u(this.f46150d)) {
                bVar.a(new d.b.g0.a.t.e.b(0, this.f46150d));
                return new d.b.g0.a.t.e.b(0);
            }
            d.b.g0.a.c0.c.g("Api-Setting", "getSwanId start");
            if (SwanAppNetworkUtils.h(a.this.h())) {
                d.b.g0.a.v1.c.i.e d2 = d.b.g0.a.r1.d.e().o().a().a().d(a.this.h());
                d2.p(new C0824a(this, bVar));
                d2.a();
                return new d.b.g0.a.t.e.b(0);
            }
            d.b.g0.a.c0.c.b("Api-Setting", "network_error");
            return new d.b.g0.a.t.e.b(10002, "network_error");
        }

        @Override // d.b.g0.a.t.b.c
        @NonNull
        public d.b.g0.a.t.e.b e(@NonNull JSONObject jSONObject) {
            return new d.b.g0.a.t.e.b(0, this.f46150d);
        }

        @Override // d.b.g0.a.t.b.c
        public boolean i() {
            if (d.b.g0.a.j1.m.c.b() && !i.e()) {
                return a.this.u(this.f46150d);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b {
        public b() {
        }

        @Override // d.b.g0.a.t.b.d.b
        public d.b.g0.a.t.e.b a(d.b.g0.a.r1.e eVar, JSONObject jSONObject, @Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            a.C(a.this.a().h(), str);
            return new d.b.g0.a.t.e.b(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements d.b.g0.a.i2.u0.b<Map<String, d.b.g0.a.v1.c.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46155f;

        public c(CallbackHandler callbackHandler, String str) {
            this.f46154e = callbackHandler;
            this.f46155f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Map<String, d.b.g0.a.v1.c.e> map) {
            if (map == null) {
                this.f46154e.handleSchemeDispatchCallback(this.f46155f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, d.b.g0.a.v1.c.e> entry : map.entrySet()) {
                    String key = entry.getKey();
                    d.b.g0.a.v1.c.e value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null && value.b() && !value.f46771d && TextUtils.equals("2", value.f46772e)) {
                        jSONObject.put(key, value.a() ? "1" : "0");
                    }
                }
                this.f46154e.handleSchemeDispatchCallback(this.f46155f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } catch (JSONException unused) {
                this.f46154e.handleSchemeDispatchCallback(this.f46155f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.g0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46156e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46157f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f46158g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46159h;

        public d(boolean z, String str, Activity activity, String str2) {
            this.f46156e = z;
            this.f46157f = str;
            this.f46158g = activity;
            this.f46159h = str2;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i != 0) {
                a.this.c(this.f46157f, new d.b.g0.a.t.e.b(10004, "user not logged in"));
            } else {
                a.this.B(this.f46156e, this.f46157f, this.f46158g, this.f46159h, "snsapi_userinfo");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46160e;

        public e(String str) {
            this.f46160e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.d.a aVar) {
            d.b.g0.a.t.e.b bVar;
            d.b.g0.a.c0.c.a("OpenData", "onOpenDataCallback:: ", aVar);
            if (aVar.y()) {
                bVar = new d.b.g0.a.t.e.b(0, aVar.f46839g);
            } else {
                int a2 = (int) aVar.j.a();
                bVar = new d.b.g0.a.t.e.b(a2, d.b.g0.a.v1.c.c.f(a2));
                d.b.g0.g.c0.c.e(a.this.a().h(), bVar.a());
            }
            a.this.c(this.f46160e, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        public static String a(d.b.g0.a.r1.e eVar) {
            String B;
            if (eVar == null) {
                B = d.b.g0.a.r1.d.e().s().B();
            } else {
                B = eVar.B();
            }
            return "aiapp_" + B + "getSwanId";
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void C(CallbackHandler callbackHandler, String str) {
        d.b.g0.a.g1.o.c.a.h(new c(callbackHandler, str));
    }

    public static JSONObject v(d.b.g0.a.r1.e eVar, Context context) throws JSONException {
        b.a J = eVar.J();
        String S = J.S();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", J.G());
        jSONObject.put("appname", J.J());
        if (!TextUtils.isEmpty(J.P())) {
            jSONObject.put("iconUrl", J.P());
        }
        if (!TextUtils.isEmpty(J.V())) {
            jSONObject.put("appLaunchScheme", J.V());
        } else {
            jSONObject.put("appLaunchScheme", "");
        }
        PMSAppInfo c0 = J.c0();
        if (c0 != null) {
            String str = c0.description;
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("appDesc", str);
            }
        }
        String c2 = d.b.g0.a.w0.a.O().c(context);
        jSONObject.put("cuid", c2);
        jSONObject.put("mtjCuid", c2);
        jSONObject.put("clkid", J.K());
        jSONObject.put("scene", S);
        jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, J.G());
        Bundle O = J.O();
        if (O != null) {
            String string = O.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("extraData", new JSONObject(string));
            }
            if (!TextUtils.isEmpty(O.getString("srcAppId"))) {
                jSONObject.put("srcAppId", O.getString("srcAppId"));
            }
            if (!TextUtils.isEmpty(O.getString("srcAppPage"))) {
                jSONObject.put("srcAppPage", O.getString("srcAppPage"));
            }
            if (TextUtils.isEmpty(S)) {
                S = "NA";
            }
            String string2 = O.getString(UBCCloudControlProcessor.UBC_KEY);
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("rootSource", d.b.g0.p.c.a(new JSONObject(string2), "pre_source", S));
            }
            SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
            String showBy = activity != null ? activity.getShowBy() : "sys";
            String str2 = TextUtils.isEmpty(showBy) ? "sys" : showBy;
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-Setting", "showBy: " + str2);
            }
            jSONObject.put("showBy", str2);
        }
        return jSONObject;
    }

    public d.b.g0.a.t.e.b A(String str) {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-Setting", "start get user info");
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        CallbackHandler h2 = a().h();
        if (O == null) {
            d.b.g0.g.c0.c.e(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new d.b.g0.a.t.e.b(1001, "empty swanApp");
        } else if (TextUtils.isEmpty(O.B())) {
            d.b.g0.g.c0.c.e(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return new d.b.g0.a.t.e.b(1001, "empty clientId");
        } else {
            JSONObject l = d.b.g0.a.t.b.d.l(str);
            if (l == null) {
                d.b.g0.g.c0.c.e(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return new d.b.g0.a.t.e.b(201, "empty joParams");
            }
            String optString = l.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.b.g0.g.c0.c.e(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return new d.b.g0.a.t.e.b(201, "empty cb");
            }
            Activity n = h() instanceof Activity ? (Activity) h() : O.n();
            if (n == null) {
                d.b.g0.g.c0.c.e(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return new d.b.g0.a.t.e.b(1001, "the context is not an activity");
            }
            String e2 = d.b.g0.a.l1.g.b.e(l.optString("__plugin__", null));
            d.b.g0.a.m.b z = O.z();
            boolean i = d.b.g0.a.v1.c.c.i(l);
            if (!z.e(n) && i) {
                z.f(n, null, new d(i, optString, n, e2));
            } else {
                B(i, optString, n, e2, "snsapi_userinfo");
            }
            return new d.b.g0.a.t.e.b(0);
        }
    }

    public final void B(boolean z, String str, Activity activity, String str2, String str3) {
        d.b.g0.a.v1.d.a.v(activity, str3, str2, z, new e(str));
    }

    public final boolean u(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return false;
        }
        String optString = optJSONObject.optString("swanid");
        return (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) ? false : true;
    }

    public d.b.g0.a.t.e.b w() {
        d.b.g0.a.c0.c.a("Api-Setting", "start get app info sync");
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            d.b.g0.a.c0.c.a("Api-Setting", "illegal swanApp");
            return new d.b.g0.a.t.e.b(1001, "illegal swanApp");
        }
        try {
            JSONObject v = v(O, h());
            if (d.b.g0.a.t.b.d.f45929c && v != null) {
                Log.d("Api-Setting", "data: " + v.toString());
            }
            return new d.b.g0.a.t.e.b(0, v);
        } catch (JSONException e2) {
            d.b.g0.a.c0.c.b("Api-Setting", Log.getStackTraceString(e2));
            return new d.b.g0.a.t.e.b(1001);
        }
    }

    public d.b.g0.a.t.e.b x(String str) {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-Setting", "start request");
        }
        return i(str, true, new b());
    }

    public d.b.g0.a.t.e.b y() {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-Setting", "start get slave id sync");
        }
        String containerId = a().g().getContainerId();
        if (TextUtils.isEmpty(containerId)) {
            return new d.b.g0.a.t.e.b(1001);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slaveId", containerId);
            return new d.b.g0.a.t.e.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-Setting", Log.getStackTraceString(e2));
            }
            return new d.b.g0.a.t.e.b(1001);
        }
    }

    public d.b.g0.a.t.e.b z(String str) {
        d.b.g0.a.r1.e s = d.b.g0.a.r1.d.e().s();
        return j(str, new C0823a("getSwanId", v.b(s.R().p(f.a(s), null))));
    }
}
