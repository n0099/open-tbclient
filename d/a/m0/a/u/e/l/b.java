package d.a.m0.a.u.e.l;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.j2.k;
import d.a.m0.a.u.c.c;
import d.a.m0.a.u.c.d;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.w;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a extends d.a.m0.a.u.c.c {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f48902d;

        /* renamed from: d.a.m0.a.u.e.l.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0919a implements d.a.m0.a.v2.e1.b<i<JSONObject>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f48904e;

            public C0919a(a aVar, c.b bVar) {
                this.f48904e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<JSONObject> iVar) {
                if (iVar.c() && iVar.f45520a != null) {
                    this.f48904e.a(new d.a.m0.a.u.h.b(0, iVar.f45520a));
                    d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
                    r.T().B(h.a(r), iVar.f45520a.toString());
                    d.a.m0.a.e0.d.g("Api-Setting", "getSwanId success");
                    return;
                }
                this.f48904e.a(new d.a.m0.a.u.h.b(10001, "getSwanId failed: internal_error"));
                d.a.m0.a.e0.d.b("Api-Setting", "getSwanId failed: internal_error");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, JSONObject jSONObject) {
            super(str);
            this.f48902d = jSONObject;
        }

        @Override // d.a.m0.a.u.c.c
        @NonNull
        public d.a.m0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            if (d.a.m0.a.r1.l.b.j() && b.this.w(this.f48902d)) {
                bVar.a(new d.a.m0.a.u.h.b(0, this.f48902d));
                return new d.a.m0.a.u.h.b(0);
            }
            d.a.m0.a.e0.d.g("Api-Setting", "getSwanId start");
            if (SwanAppNetworkUtils.i(b.this.i())) {
                d.a.m0.a.e2.c.j.e e2 = d.a.m0.a.a2.d.g().y().a().b().e(b.this.i());
                e2.p(new C0919a(this, bVar));
                e2.a();
                return new d.a.m0.a.u.h.b(0);
            }
            d.a.m0.a.e0.d.b("Api-Setting", "network_error");
            return new d.a.m0.a.u.h.b(10002, "network_error");
        }

        @Override // d.a.m0.a.u.c.c
        @NonNull
        public d.a.m0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            return new d.a.m0.a.u.h.b(0, this.f48902d);
        }

        @Override // d.a.m0.a.u.c.c
        public boolean i() {
            if (d.a.m0.a.r1.l.b.j()) {
                return b.this.w(this.f48902d);
            }
            return false;
        }
    }

    /* renamed from: d.a.m0.a.u.e.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0920b implements d.b {
        public C0920b() {
        }

        @Override // d.a.m0.a.u.c.d.b
        public d.a.m0.a.u.h.b a(d.a.m0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            b.F(b.this.a().h(), str);
            return new d.a.m0.a.u.h.b(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements d.a.m0.a.v2.e1.b<Map<String, d.a.m0.a.e2.c.f>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48906e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48907f;

        public c(CallbackHandler callbackHandler, String str) {
            this.f48906e = callbackHandler;
            this.f48907f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Map<String, d.a.m0.a.e2.c.f> map) {
            if (map == null) {
                this.f48906e.handleSchemeDispatchCallback(this.f48907f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, d.a.m0.a.e2.c.f> entry : map.entrySet()) {
                    String key = entry.getKey();
                    d.a.m0.a.e2.c.f value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null && value.b() && !value.f45481d && TextUtils.equals("2", value.f45482e)) {
                        jSONObject.put(key, value.a() ? "1" : "0");
                    }
                }
                this.f48906e.handleSchemeDispatchCallback(this.f48907f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } catch (JSONException unused) {
                this.f48906e.handleSchemeDispatchCallback(this.f48907f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48909f;

        public d(String str, String str2) {
            this.f48908e = str;
            this.f48909f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.d.a aVar) {
            d.a.m0.a.u.h.b bVar;
            d.a.m0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
            if (aVar.F()) {
                bVar = new d.a.m0.a.u.h.b(0, aVar.f45555g);
                k.N(this.f48908e, "success");
            } else {
                int a2 = (int) aVar.j.a();
                String f2 = d.a.m0.a.e2.c.d.f(a2);
                d.a.m0.a.u.h.b bVar2 = new d.a.m0.a.u.h.b(a2, f2);
                d.a.m0.a.c1.b.j().c(b.this.a().h(), bVar2.a());
                k.O(this.f48908e, com.baidu.pass.biometrics.face.liveness.b.a.g0, f2);
                bVar = bVar2;
            }
            b.this.d(this.f48909f, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48912f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48913g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48914h;

        public e(String str, String str2, String str3, String str4) {
            this.f48911e = str;
            this.f48912f = str2;
            this.f48913g = str3;
            this.f48914h = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                if (d.a.m0.a.u.c.d.f48594c) {
                    d.a.m0.a.e0.d.h("Api-Setting", "onCallback: has permission scope_userinfo_api");
                }
                b.this.y(this.f48911e, this.f48912f, this.f48913g, this.f48914h);
                return;
            }
            d.a.m0.a.e0.d.h("Api-Setting", "onCallback: no permission scope_userinfo_api");
            b.this.d(this.f48912f, new d.a.m0.a.u.h.b(402));
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a.m0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48916e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48917f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48918g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f48919h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f48920i;

        public f(String str, String str2, String str3, Activity activity, String str4) {
            this.f48916e = str;
            this.f48917f = str2;
            this.f48918g = str3;
            this.f48919h = activity;
            this.f48920i = str4;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f48916e);
                k.O(this.f48917f, com.baidu.pass.biometrics.face.liveness.b.a.g0, "login failed");
                b.this.d(this.f48918g, new d.a.m0.a.u.h.b(10004, "user not logged in"));
                return;
            }
            k.M("success", 3, this.f48916e);
            b.this.E(false, this.f48918g, this.f48919h, this.f48920i, "snsapi_userinfo", this.f48917f);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.a.m0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48922f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48923g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f48924h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Activity f48925i;
        public final /* synthetic */ String j;

        public g(String str, String str2, String str3, boolean z, Activity activity, String str4) {
            this.f48921e = str;
            this.f48922f = str2;
            this.f48923g = str3;
            this.f48924h = z;
            this.f48925i = activity;
            this.j = str4;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f48921e);
                k.O(this.f48922f, com.baidu.pass.biometrics.face.liveness.b.a.g0, "result code = " + i2);
                b.this.d(this.f48923g, new d.a.m0.a.u.h.b(10004, "user not logged in"));
                return;
            }
            k.M("success", 3, this.f48921e);
            b.this.E(this.f48924h, this.f48923g, this.f48925i, this.j, "snsapi_userinfo", this.f48922f);
        }
    }

    /* loaded from: classes2.dex */
    public static class h {
        public static String a(d.a.m0.a.a2.e eVar) {
            String D;
            if (eVar == null) {
                D = d.a.m0.a.a2.d.g().r().D();
            } else {
                D = eVar.D();
            }
            return "aiapp_" + D + "getSwanId";
        }
    }

    public b(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public static void F(CallbackHandler callbackHandler, String str) {
        d.a.m0.a.n1.q.c.a.h(new c(callbackHandler, str));
    }

    public static JSONObject x(d.a.m0.a.a2.e eVar, Context context) throws JSONException {
        b.a L = eVar.L();
        String T = L.T();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", L.H());
        jSONObject.put("appname", L.K());
        if (!TextUtils.isEmpty(L.Q())) {
            jSONObject.put("iconUrl", L.Q());
        }
        if (!TextUtils.isEmpty(L.W())) {
            jSONObject.put("appLaunchScheme", L.W());
        } else {
            jSONObject.put("appLaunchScheme", "");
        }
        PMSAppInfo f0 = L.f0();
        if (f0 != null) {
            String str = f0.description;
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("appDesc", str);
            }
            String str2 = f0.paNumber;
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(com.alipay.sdk.cons.b.k, str2);
            }
            jSONObject.put("isOpenCustomerService", q0.P());
        }
        String i2 = d.a.m0.a.c1.a.a0().i(context);
        jSONObject.put("cuid", i2);
        jSONObject.put("mtjCuid", i2);
        jSONObject.put("clkid", L.L());
        jSONObject.put("scene", T);
        jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, L.H());
        Bundle P = L.P();
        if (P != null) {
            String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, new JSONObject(string));
            }
            if (!TextUtils.isEmpty(P.getString("srcAppId"))) {
                jSONObject.put("srcAppId", P.getString("srcAppId"));
            }
            if (!TextUtils.isEmpty(P.getString("srcAppPage"))) {
                jSONObject.put("srcAppPage", P.getString("srcAppPage"));
            }
            if (TextUtils.isEmpty(T)) {
                T = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            String string2 = P.getString(UBCCloudControlProcessor.UBC_KEY);
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("rootSource", d.a.m0.t.c.a(new JSONObject(string2), "pre_source", T));
            }
            SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
            String showBy = activity != null ? activity.getShowBy() : "sys";
            String str3 = TextUtils.isEmpty(showBy) ? "sys" : showBy;
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-Setting", "showBy: " + str3);
            }
            jSONObject.put("showBy", str3);
        }
        return jSONObject;
    }

    public d.a.m0.a.u.h.b A(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Setting", "start request");
        }
        return j(str, true, new C0920b());
    }

    public d.a.m0.a.u.h.b B() {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Setting", "start get slave id sync");
        }
        String containerId = a().g().getContainerId();
        if (TextUtils.isEmpty(containerId)) {
            return new d.a.m0.a.u.h.b(1001);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slaveId", containerId);
            return new d.a.m0.a.u.h.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-Setting", Log.getStackTraceString(e2));
            }
            return new d.a.m0.a.u.h.b(1001);
        }
    }

    public d.a.m0.a.u.h.b C(String str) {
        d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
        return k(str, new a("getSwanId", w.d(r.T().q(h.a(r), null))));
    }

    public d.a.m0.a.u.h.b D(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Setting", "start get user info");
        }
        d.a.m0.a.p.b.a.h j = d.a.m0.a.c1.b.j();
        d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
        CallbackHandler h2 = a().h();
        if (r == null) {
            j.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new d.a.m0.a.u.h.b(1001, "empty swanApp");
        } else if (TextUtils.isEmpty(r.D())) {
            j.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return new d.a.m0.a.u.h.b(1001, "empty clientId");
        } else {
            JSONObject m = d.a.m0.a.u.c.d.m(str);
            if (m == null) {
                j.c(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return new d.a.m0.a.u.h.b(201, "empty joParams");
            }
            String f2 = d.a.m0.a.t1.g.b.f(m.optString("__plugin__", null));
            boolean z = !TextUtils.isEmpty(f2);
            boolean i2 = d.a.m0.a.e2.c.d.i(m);
            String str2 = (i2 || z) ? "getUserInfoButton" : "getUserInfoApi";
            k.N(str2, "create");
            String optString = m.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.c(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                k.O(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return new d.a.m0.a.u.h.b(201, "empty cb");
            }
            SwanAppActivity x = r.x();
            if (x == null) {
                j.c(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                k.O(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                return new d.a.m0.a.u.h.b(1001, "the context is not an activity");
            }
            String optString2 = m.optString("invokeFrom");
            if (!r.j().e(x)) {
                k.M("show", 3, optString2);
            }
            if (!i2 && !z) {
                G(f2, optString, optString2, str2);
            } else {
                H(f2, i2, optString, optString2, str2);
            }
            return new d.a.m0.a.u.h.b(0);
        }
    }

    public final void E(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        k.N(str4, "requestOpenData");
        k.N(str4, "checkScope");
        d.a.m0.a.e2.d.a.C(activity, str3, str2, z, str4, new d(str4, str));
    }

    public final void G(String str, String str2, String str3, String str4) {
        k.N(str4, "checkScope");
        d.a.m0.a.a2.d.g().r().T().g(i(), "scope_userinfo_api", new e(str, str2, str3, str4));
    }

    public final void H(String str, boolean z, String str2, String str3, String str4) {
        d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
        SwanAppActivity x = r.x();
        d.a.m0.a.m.b j = r.j();
        if (j.e(x)) {
            E(z, str2, x, str, "snsapi_userinfo", str4);
            return;
        }
        k.N(str4, "getUserInfoLogin");
        j.f(x, null, new g(str3, str4, str2, z, x, str));
    }

    public final boolean w(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return false;
        }
        String optString = optJSONObject.optString("swanid");
        return (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) ? false : true;
    }

    public final void y(String str, String str2, String str3, String str4) {
        d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
        SwanAppActivity x = r.x();
        d.a.m0.a.m.b j = r.j();
        if (j.e(x)) {
            E(false, str2, x, str, "snsapi_userinfo", str4);
            return;
        }
        k.N(str4, "getUserInfoLogin");
        j.f(x, null, new f(str3, str4, str2, x, str));
    }

    public d.a.m0.a.u.h.b z() {
        d.a.m0.a.e0.d.a("Api-Setting", "start get app info sync");
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            d.a.m0.a.e0.d.a("Api-Setting", "illegal swanApp");
            return new d.a.m0.a.u.h.b(1001, "illegal swanApp");
        }
        JSONObject d2 = d.a.m0.a.r1.k.g.a.c().d("getAppInfoSync");
        if (d2 == null) {
            try {
                d2 = x(Q, i());
                d.a.m0.a.r1.k.g.a.c().h("getAppInfoSync", d2);
            } catch (JSONException e2) {
                d.a.m0.a.e0.d.b("Api-Setting", Log.getStackTraceString(e2));
                return new d.a.m0.a.u.h.b(1001);
            }
        }
        if (d.a.m0.a.u.c.d.f48594c && d2 != null) {
            Log.d("Api-Setting", "data: " + d2.toString());
        }
        return new d.a.m0.a.u.h.b(0, d2);
    }
}
