package d.a.h0.a.t.c.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.r1.e;
import d.a.h0.a.t.b.d;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d {

    /* loaded from: classes2.dex */
    public static class a implements d.a.h0.a.i2.u0.b<h<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f44029e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44030f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44031g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f44032h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44033i;

        public a(c cVar, CallbackHandler callbackHandler, String str, e eVar, JSONObject jSONObject) {
            this.f44029e = cVar;
            this.f44030f = callbackHandler;
            this.f44031g = str;
            this.f44032h = eVar;
            this.f44033i = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<f.d> hVar) {
            if (!hVar.c()) {
                int b2 = hVar.b();
                d.a.h0.a.c0.c.l("Api-Login", b2 + " " + this.f44029e.toString());
                String f2 = d.a.h0.a.v1.c.c.f(b2);
                this.f44030f.handleSchemeDispatchCallback(this.f44031g, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                d.a.h0.g.c0.c.g(this.f44030f, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                b.x(this.f44032h, 43, b2, f2);
            } else if (TextUtils.isEmpty(hVar.f44952a.f44970a)) {
                this.f44030f.handleSchemeDispatchCallback(this.f44031g, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                d.a.h0.g.c0.c.g(this.f44030f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                b.x(this.f44032h, 43, 1001, "empty code");
            } else {
                String optString = this.f44033i.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    b.t(optString, this.f44032h, this.f44030f, this.f44031g, hVar);
                } else {
                    b.u(this.f44032h, this.f44030f, this.f44031g, hVar);
                }
            }
        }
    }

    /* renamed from: d.a.h0.a.t.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0767b implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44034e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44035f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f44036g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h f44037h;

        public C0767b(CallbackHandler callbackHandler, String str, e eVar, h hVar) {
            this.f44034e = callbackHandler;
            this.f44035f = str;
            this.f44036g = eVar;
            this.f44037h = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.d.a aVar) {
            if (aVar != null && aVar.x()) {
                b.u(this.f44036g, this.f44034e, this.f44035f, this.f44037h);
            } else {
                this.f44034e.handleSchemeDispatchCallback(this.f44035f, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f44038a;

        /* renamed from: b  reason: collision with root package name */
        public final long f44039b;

        public c(@NonNull JSONObject jSONObject) {
            this.f44038a = jSONObject.has("timeout");
            long optLong = jSONObject.optLong("timeout", 0L);
            this.f44039b = optLong;
            if (optLong < 0) {
                d.a.h0.a.c0.c.l("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.f44038a + ", timeoutMills=" + this.f44039b + '}';
        }
    }

    public b(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void s(e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        c cVar = new c(jSONObject);
        eVar.R().q(activity, cVar, null, new a(cVar, callbackHandler, str, eVar, jSONObject));
    }

    public static void t(String str, e eVar, CallbackHandler callbackHandler, String str2, h<f.d> hVar) {
        SwanAppActivity v = eVar.v();
        if (v == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "the activity is null").toString());
        } else {
            d.a.h0.a.v1.d.a.v(v, "snsapi_userinfo", d.a.h0.a.l1.g.b.e(str), false, new C0767b(callbackHandler, str2, eVar, hVar));
        }
    }

    public static void u(e eVar, CallbackHandler callbackHandler, String str, h<f.d> hVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", hVar.f44952a.f44970a);
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.b()).toString());
        } catch (JSONException e2) {
            if (d.f44021c) {
                e2.printStackTrace();
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
            d.a.h0.g.c0.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
            x(eVar, 43, 1001, e2.getMessage());
        }
    }

    public static void x(e eVar, int i2, int i3, String str) {
        int j;
        if (eVar != null && (j = eVar.j()) == 0) {
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(5L);
            aVar.h(i2);
            d.a.h0.a.z1.k.d dVar = new d.a.h0.a.z1.k.d();
            dVar.p(aVar);
            dVar.r(eVar.L());
            dVar.q(d.a.h0.a.z1.h.n(j));
            dVar.m(e.T());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i3);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e2) {
                if (d.f44021c) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            d.a.h0.a.z1.h.H(dVar);
        }
    }

    public d.a.h0.a.t.e.b v() {
        if (d.f44021c) {
            Log.d("Api-Login", "start is login action");
        }
        e O = e.O();
        if (O == null) {
            d.a.h0.a.c0.c.b("Api-Login", "swan app is null");
            return new d.a.h0.a.t.e.b(202, "swan app is null");
        }
        boolean e2 = O.i().e(h());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLogin", e2);
            return new d.a.h0.a.t.e.b(0, jSONObject);
        } catch (JSONException unused) {
            d.a.h0.a.c0.c.b("Api-Login", "json parse fail");
            return new d.a.h0.a.t.e.b(1001);
        }
    }

    public d.a.h0.a.t.e.b w(String str) {
        if (d.f44021c) {
            Log.d("Api-Login", "start login");
        }
        e O = e.O();
        CallbackHandler h2 = a().h();
        if (O == null) {
            d.a.h0.g.c0.c.g(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new d.a.h0.a.t.e.b(1001, "empty swanApp");
        }
        JSONObject l = d.l(str);
        if (l == null) {
            d.a.h0.g.c0.c.g(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            x(O, 1, 201, "empty joParams");
            return new d.a.h0.a.t.e.b(201, "empty joParams");
        }
        String optString = l.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.g.c0.c.g(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            x(O, 1, 201, "empty cb");
            return new d.a.h0.a.t.e.b(201, "empty cb");
        } else if (!l.optBoolean("force", true) && !O.i().e(h())) {
            h2.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            d.a.h0.g.c0.c.g(h2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            x(O, 43, 10004, "user not logged in");
            return new d.a.h0.a.t.e.b(0);
        } else {
            Context h3 = h();
            if (!(h3 instanceof Activity) && (h3 = O.v()) == null) {
                return new d.a.h0.a.t.e.b(1001, "the context is not an activity");
            }
            s(O, (Activity) h3, l, h2, optString);
            return new d.a.h0.a.t.e.b(0);
        }
    }
}
