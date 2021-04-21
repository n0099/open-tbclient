package d.b.h0.a.t.c.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.h0.a.r1.e;
import d.b.h0.a.t.b.d;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d {

    /* loaded from: classes2.dex */
    public static class a implements d.b.h0.a.i2.u0.b<h<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f46658e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46659f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46660g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f46661h;
        public final /* synthetic */ JSONObject i;

        public a(c cVar, CallbackHandler callbackHandler, String str, e eVar, JSONObject jSONObject) {
            this.f46658e = cVar;
            this.f46659f = callbackHandler;
            this.f46660g = str;
            this.f46661h = eVar;
            this.i = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<f.d> hVar) {
            if (!hVar.c()) {
                int b2 = hVar.b();
                d.b.h0.a.c0.c.l("Api-Login", b2 + " " + this.f46658e.toString());
                String f2 = d.b.h0.a.v1.c.c.f(b2);
                this.f46659f.handleSchemeDispatchCallback(this.f46660g, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                d.b.h0.g.c0.c.g(this.f46659f, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                b.x(this.f46661h, 43, b2, f2);
            } else if (TextUtils.isEmpty(hVar.f47529a.f47547a)) {
                this.f46659f.handleSchemeDispatchCallback(this.f46660g, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                d.b.h0.g.c0.c.g(this.f46659f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                b.x(this.f46661h, 43, 1001, "empty code");
            } else {
                String optString = this.i.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    b.t(optString, this.f46661h, this.f46659f, this.f46660g, hVar);
                } else {
                    b.u(this.f46661h, this.f46659f, this.f46660g, hVar);
                }
            }
        }
    }

    /* renamed from: d.b.h0.a.t.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0828b implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46663f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f46664g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h f46665h;

        public C0828b(CallbackHandler callbackHandler, String str, e eVar, h hVar) {
            this.f46662e = callbackHandler;
            this.f46663f = str;
            this.f46664g = eVar;
            this.f46665h = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.d.a aVar) {
            if (aVar != null && aVar.x()) {
                b.u(this.f46664g, this.f46662e, this.f46663f, this.f46665h);
            } else {
                this.f46662e.handleSchemeDispatchCallback(this.f46663f, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f46666a;

        /* renamed from: b  reason: collision with root package name */
        public final long f46667b;

        public c(@NonNull JSONObject jSONObject) {
            this.f46666a = jSONObject.has("timeout");
            long optLong = jSONObject.optLong("timeout", 0L);
            this.f46667b = optLong;
            if (optLong < 0) {
                d.b.h0.a.c0.c.l("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.f46666a + ", timeoutMills=" + this.f46667b + '}';
        }
    }

    public b(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void s(e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
        c cVar = new c(jSONObject);
        eVar.R().q(activity, cVar, null, new a(cVar, callbackHandler, str, eVar, jSONObject));
    }

    public static void t(String str, e eVar, CallbackHandler callbackHandler, String str2, h<f.d> hVar) {
        SwanAppActivity n = eVar.n();
        if (n == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "the activity is null").toString());
        } else {
            d.b.h0.a.v1.d.a.v(n, "snsapi_userinfo", d.b.h0.a.l1.g.b.e(str), false, new C0828b(callbackHandler, str2, eVar, hVar));
        }
    }

    public static void u(e eVar, CallbackHandler callbackHandler, String str, h<f.d> hVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", hVar.f47529a.f47547a);
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.b()).toString());
        } catch (JSONException e2) {
            if (d.f46650c) {
                e2.printStackTrace();
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
            d.b.h0.g.c0.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
            x(eVar, 43, 1001, e2.getMessage());
        }
    }

    public static void x(e eVar, int i, int i2, String str) {
        int h2;
        if (eVar != null && (h2 = eVar.h()) == 0) {
            d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
            aVar.j(5L);
            aVar.h(i);
            d.b.h0.a.z1.k.d dVar = new d.b.h0.a.z1.k.d();
            dVar.p(aVar);
            dVar.r(eVar.L());
            dVar.q(d.b.h0.a.z1.h.n(h2));
            dVar.m(e.T());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e2) {
                if (d.f46650c) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            d.b.h0.a.z1.h.H(dVar);
        }
    }

    public d.b.h0.a.t.e.b v() {
        if (d.f46650c) {
            Log.d("Api-Login", "start is login action");
        }
        e O = e.O();
        if (O == null) {
            d.b.h0.a.c0.c.b("Api-Login", "swan app is null");
            return new d.b.h0.a.t.e.b(202, "swan app is null");
        }
        boolean e2 = O.z().e(h());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isLogin", e2);
            return new d.b.h0.a.t.e.b(0, jSONObject);
        } catch (JSONException unused) {
            d.b.h0.a.c0.c.b("Api-Login", "json parse fail");
            return new d.b.h0.a.t.e.b(1001);
        }
    }

    public d.b.h0.a.t.e.b w(String str) {
        if (d.f46650c) {
            Log.d("Api-Login", "start login");
        }
        e O = e.O();
        CallbackHandler h2 = a().h();
        if (O == null) {
            d.b.h0.g.c0.c.g(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new d.b.h0.a.t.e.b(1001, "empty swanApp");
        }
        JSONObject l = d.l(str);
        if (l == null) {
            d.b.h0.g.c0.c.g(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            x(O, 1, 201, "empty joParams");
            return new d.b.h0.a.t.e.b(201, "empty joParams");
        }
        String optString = l.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.g.c0.c.g(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            x(O, 1, 201, "empty cb");
            return new d.b.h0.a.t.e.b(201, "empty cb");
        } else if (!l.optBoolean("force", true) && !O.z().e(h())) {
            h2.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            d.b.h0.g.c0.c.g(h2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            x(O, 43, 10004, "user not logged in");
            return new d.b.h0.a.t.e.b(0);
        } else {
            Context h3 = h();
            if (!(h3 instanceof Activity) && (h3 = O.n()) == null) {
                return new d.b.h0.a.t.e.b(1001, "the context is not an activity");
            }
            s(O, (Activity) h3, l, h2, optString);
            return new d.b.h0.a.t.e.b(0);
        }
    }
}
