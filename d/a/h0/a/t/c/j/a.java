package d.a.h0.a.t.c.j;

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
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.a.i2.i;
import d.a.h0.a.i2.v;
import d.a.h0.a.t.b.c;
import d.a.h0.a.t.b.d;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.y0.e.b;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.h0.a.t.b.d {

    /* renamed from: d.a.h0.a.t.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0794a extends d.a.h0.a.t.b.c {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44257d;

        /* renamed from: d.a.h0.a.t.c.j.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0795a implements d.a.h0.a.i2.u0.b<h<JSONObject>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f44259e;

            public C0795a(C0794a c0794a, c.b bVar) {
                this.f44259e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(h<JSONObject> hVar) {
                if (hVar.c() && hVar.f44952a != null) {
                    this.f44259e.a(new d.a.h0.a.t.e.b(0, hVar.f44952a));
                    d.a.h0.a.r1.e p = d.a.h0.a.r1.d.e().p();
                    p.R().A(f.a(p), hVar.f44952a.toString());
                    d.a.h0.a.c0.c.g("Api-Setting", "getSwanId success");
                    return;
                }
                this.f44259e.a(new d.a.h0.a.t.e.b(10001, "getSwanId failed: internal_error"));
                d.a.h0.a.c0.c.b("Api-Setting", "getSwanId failed: internal_error");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0794a(String str, JSONObject jSONObject) {
            super(str);
            this.f44257d = jSONObject;
        }

        @Override // d.a.h0.a.t.b.c
        @NonNull
        public d.a.h0.a.t.e.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            if (d.a.h0.a.j1.m.c.b() && a.this.u(this.f44257d)) {
                bVar.a(new d.a.h0.a.t.e.b(0, this.f44257d));
                return new d.a.h0.a.t.e.b(0);
            }
            d.a.h0.a.c0.c.g("Api-Setting", "getSwanId start");
            if (SwanAppNetworkUtils.h(a.this.h())) {
                d.a.h0.a.v1.c.i.e e2 = d.a.h0.a.r1.d.e().w().a().b().e(a.this.h());
                e2.p(new C0795a(this, bVar));
                e2.a();
                return new d.a.h0.a.t.e.b(0);
            }
            d.a.h0.a.c0.c.b("Api-Setting", "network_error");
            return new d.a.h0.a.t.e.b(10002, "network_error");
        }

        @Override // d.a.h0.a.t.b.c
        @NonNull
        public d.a.h0.a.t.e.b e(@NonNull JSONObject jSONObject) {
            return new d.a.h0.a.t.e.b(0, this.f44257d);
        }

        @Override // d.a.h0.a.t.b.c
        public boolean i() {
            if (d.a.h0.a.j1.m.c.b() && !i.e()) {
                return a.this.u(this.f44257d);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b {
        public b() {
        }

        @Override // d.a.h0.a.t.b.d.b
        public d.a.h0.a.t.e.b a(d.a.h0.a.r1.e eVar, JSONObject jSONObject, @Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            a.C(a.this.a().h(), str);
            return new d.a.h0.a.t.e.b(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements d.a.h0.a.i2.u0.b<Map<String, d.a.h0.a.v1.c.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44262f;

        public c(CallbackHandler callbackHandler, String str) {
            this.f44261e = callbackHandler;
            this.f44262f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Map<String, d.a.h0.a.v1.c.e> map) {
            if (map == null) {
                this.f44261e.handleSchemeDispatchCallback(this.f44262f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, d.a.h0.a.v1.c.e> entry : map.entrySet()) {
                    String key = entry.getKey();
                    d.a.h0.a.v1.c.e value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null && value.b() && !value.f44913d && TextUtils.equals("2", value.f44914e)) {
                        jSONObject.put(key, value.a() ? "1" : "0");
                    }
                }
                this.f44261e.handleSchemeDispatchCallback(this.f44262f, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } catch (JSONException unused) {
                this.f44261e.handleSchemeDispatchCallback(this.f44262f, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44263e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44264f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f44265g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44266h;

        public d(boolean z, String str, Activity activity, String str2) {
            this.f44263e = z;
            this.f44264f = str;
            this.f44265g = activity;
            this.f44266h = str2;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                a.this.c(this.f44264f, new d.a.h0.a.t.e.b(10004, "user not logged in"));
            } else {
                a.this.B(this.f44263e, this.f44264f, this.f44265g, this.f44266h, "snsapi_userinfo");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44268e;

        public e(String str) {
            this.f44268e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.d.a aVar) {
            d.a.h0.a.t.e.b bVar;
            d.a.h0.a.c0.c.a("OpenData", "onOpenDataCallback:: ", aVar);
            if (aVar.y()) {
                bVar = new d.a.h0.a.t.e.b(0, aVar.f44984g);
            } else {
                int a2 = (int) aVar.j.a();
                bVar = new d.a.h0.a.t.e.b(a2, d.a.h0.a.v1.c.c.f(a2));
                d.a.h0.g.c0.c.e(a.this.a().h(), bVar.b());
            }
            a.this.c(this.f44268e, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        public static String a(d.a.h0.a.r1.e eVar) {
            String B;
            if (eVar == null) {
                B = d.a.h0.a.r1.d.e().p().B();
            } else {
                B = eVar.B();
            }
            return "aiapp_" + B + "getSwanId";
        }
    }

    public a(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void C(CallbackHandler callbackHandler, String str) {
        d.a.h0.a.g1.o.c.a.h(new c(callbackHandler, str));
    }

    public static JSONObject v(d.a.h0.a.r1.e eVar, Context context) throws JSONException {
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
        String f2 = d.a.h0.a.w0.a.O().f(context);
        jSONObject.put("cuid", f2);
        jSONObject.put("mtjCuid", f2);
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
                S = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            String string2 = O.getString(UBCCloudControlProcessor.UBC_KEY);
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("rootSource", d.a.h0.p.c.a(new JSONObject(string2), "pre_source", S));
            }
            SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
            String showBy = activity != null ? activity.getShowBy() : "sys";
            String str2 = TextUtils.isEmpty(showBy) ? "sys" : showBy;
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-Setting", "showBy: " + str2);
            }
            jSONObject.put("showBy", str2);
        }
        return jSONObject;
    }

    public d.a.h0.a.t.e.b A(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-Setting", "start get user info");
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        CallbackHandler h2 = a().h();
        if (O == null) {
            d.a.h0.g.c0.c.e(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new d.a.h0.a.t.e.b(1001, "empty swanApp");
        } else if (TextUtils.isEmpty(O.B())) {
            d.a.h0.g.c0.c.e(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return new d.a.h0.a.t.e.b(1001, "empty clientId");
        } else {
            JSONObject l = d.a.h0.a.t.b.d.l(str);
            if (l == null) {
                d.a.h0.g.c0.c.e(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return new d.a.h0.a.t.e.b(201, "empty joParams");
            }
            String optString = l.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.h0.g.c0.c.e(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return new d.a.h0.a.t.e.b(201, "empty cb");
            }
            Activity v = h() instanceof Activity ? (Activity) h() : O.v();
            if (v == null) {
                d.a.h0.g.c0.c.e(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return new d.a.h0.a.t.e.b(1001, "the context is not an activity");
            }
            String e2 = d.a.h0.a.l1.g.b.e(l.optString("__plugin__", null));
            d.a.h0.a.m.b i2 = O.i();
            boolean i3 = d.a.h0.a.v1.c.c.i(l);
            if (!i2.e(v) && i3) {
                i2.f(v, null, new d(i3, optString, v, e2));
            } else {
                B(i3, optString, v, e2, "snsapi_userinfo");
            }
            return new d.a.h0.a.t.e.b(0);
        }
    }

    public final void B(boolean z, String str, Activity activity, String str2, String str3) {
        d.a.h0.a.v1.d.a.v(activity, str3, str2, z, new e(str));
    }

    public final boolean u(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return false;
        }
        String optString = optJSONObject.optString("swanid");
        return (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) ? false : true;
    }

    public d.a.h0.a.t.e.b w() {
        d.a.h0.a.c0.c.a("Api-Setting", "start get app info sync");
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            d.a.h0.a.c0.c.a("Api-Setting", "illegal swanApp");
            return new d.a.h0.a.t.e.b(1001, "illegal swanApp");
        }
        try {
            JSONObject v = v(O, h());
            if (d.a.h0.a.t.b.d.f44021c && v != null) {
                Log.d("Api-Setting", "data: " + v.toString());
            }
            return new d.a.h0.a.t.e.b(0, v);
        } catch (JSONException e2) {
            d.a.h0.a.c0.c.b("Api-Setting", Log.getStackTraceString(e2));
            return new d.a.h0.a.t.e.b(1001);
        }
    }

    public d.a.h0.a.t.e.b x(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-Setting", "start request");
        }
        return i(str, true, new b());
    }

    public d.a.h0.a.t.e.b y() {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-Setting", "start get slave id sync");
        }
        String containerId = a().g().getContainerId();
        if (TextUtils.isEmpty(containerId)) {
            return new d.a.h0.a.t.e.b(1001);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("slaveId", containerId);
            return new d.a.h0.a.t.e.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.a.h0.a.t.b.d.f44021c) {
                Log.d("Api-Setting", Log.getStackTraceString(e2));
            }
            return new d.a.h0.a.t.e.b(1001);
        }
    }

    public d.a.h0.a.t.e.b z(String str) {
        d.a.h0.a.r1.e p = d.a.h0.a.r1.d.e().p();
        return j(str, new C0794a("getSwanId", v.b(p.R().p(f.a(p), null))));
    }
}
