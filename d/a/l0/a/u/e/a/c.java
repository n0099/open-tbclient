package d.a.l0.a.u.e.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.a2.e;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.f;
import d.a.l0.a.k;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.l0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48497d = k.f46875a;

    /* loaded from: classes2.dex */
    public static class a implements d.a.l0.a.v2.e1.b<i<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f48499f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f48500g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ C0888c f48501h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48502i;
        public final /* synthetic */ String j;
        public final /* synthetic */ e k;
        public final /* synthetic */ String l;

        public a(boolean z, boolean z2, JSONObject jSONObject, C0888c c0888c, CallbackHandler callbackHandler, String str, e eVar, String str2) {
            this.f48498e = z;
            this.f48499f = z2;
            this.f48500g = jSONObject;
            this.f48501h = c0888c;
            this.f48502i = callbackHandler;
            this.j = str;
            this.k = eVar;
            this.l = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            d.a.l0.a.e0.d.h("Api-Login", "Info: login request error code is  " + iVar.b() + " error info is " + iVar.a());
            if (!iVar.c()) {
                if (!this.f48498e && this.f48499f) {
                    d.a.l0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.b.g0, 1, this.f48500g.optString("invokeFrom"));
                    d.a.l0.a.e0.d.h("Api-Login", "Error: login failed from api-invoking.");
                }
                int b2 = iVar.b();
                d.a.l0.a.e0.d.l("Api-Login", b2 + " " + this.f48501h.toString());
                String f2 = d.a.l0.a.e2.c.d.f(b2);
                this.f48502i.handleSchemeDispatchCallback(this.j, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                d.a.l0.a.c1.b.j().f(this.f48502i, UnitedSchemeUtility.wrapCallbackParams(b2, f2).toString());
                c.B(this.k, 43, b2, f2);
                String str = "Error: login failed error code = " + b2 + " error msg = " + f2;
                d.a.l0.a.e0.d.h("Api-Login", str);
                d.a.l0.a.j2.k.O(this.l, com.baidu.pass.biometrics.face.liveness.b.b.g0, str);
                return;
            }
            if (!this.f48498e && this.f48499f) {
                d.a.l0.a.j2.k.M("success", 1, this.f48500g.optString("invokeFrom"));
                d.a.l0.a.e0.d.h("Api-Login", "Success: login success from api-invoking.");
            }
            if (c.y(this.f48500g)) {
                this.f48502i.handleSchemeDispatchCallback(this.j, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                d.a.l0.a.e0.d.h("Api-Login", "Success: login success from component-invoking.");
                d.a.l0.a.j2.k.O(this.l, "success", "Success: login success from component-invoking.");
                return;
            }
            d.a.l0.a.j2.k.N(this.l, "getLoginCodeStart");
            if (TextUtils.isEmpty(iVar.f45412a.f45430a)) {
                this.f48502i.handleSchemeDispatchCallback(this.j, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                d.a.l0.a.c1.b.j().f(this.f48502i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                c.B(this.k, 43, 1001, "empty code");
                d.a.l0.a.j2.k.O(this.l, com.baidu.pass.biometrics.face.liveness.b.b.g0, "empty code");
                return;
            }
            String optString = this.f48500g.optString("__plugin__");
            if (!TextUtils.isEmpty(optString)) {
                c.w(optString, this.k, this.f48502i, this.j, iVar, this.l);
            } else {
                c.x(this.k, this.f48502i, this.j, iVar, this.l);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.d.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48503e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48504f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48505g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48506h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f48507i;
        public final /* synthetic */ i j;

        public b(CallbackHandler callbackHandler, String str, String str2, String str3, e eVar, i iVar) {
            this.f48503e = callbackHandler;
            this.f48504f = str;
            this.f48505g = str2;
            this.f48506h = str3;
            this.f48507i = eVar;
            this.j = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.d.a aVar) {
            if (aVar != null && aVar.E()) {
                c.x(this.f48507i, this.f48503e, this.f48504f, this.j, this.f48506h);
                return;
            }
            this.f48503e.handleSchemeDispatchCallback(this.f48504f, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
            String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.f48505g + " from plugin-invoking.";
            d.a.l0.a.e0.d.h("Api-Login", str);
            d.a.l0.a.j2.k.O(this.f48506h, com.baidu.pass.biometrics.face.liveness.b.b.g0, str);
        }
    }

    /* renamed from: d.a.l0.a.u.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0888c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f48508a;

        /* renamed from: b  reason: collision with root package name */
        public final long f48509b;

        public C0888c(@NonNull JSONObject jSONObject) {
            this.f48508a = jSONObject.has("timeout");
            long optLong = jSONObject.optLong("timeout", 0L);
            this.f48509b = optLong;
            if (optLong < 0) {
                d.a.l0.a.e0.d.l("Api-Login", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            return "LoginTimeoutConfig{enableTimeout=" + this.f48508a + ", timeoutMills=" + this.f48509b + '}';
        }
    }

    public c(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public static void B(e eVar, int i2, int i3, String str) {
        int l;
        if (eVar != null && (l = eVar.l()) == 0) {
            d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
            aVar.j(5L);
            aVar.h(i2);
            d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
            dVar.p(aVar);
            dVar.r(eVar.N());
            dVar.q(d.a.l0.a.j2.k.m(l));
            dVar.m(e.V());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i3);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e2) {
                if (f48497d) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            d.a.l0.a.j2.k.L(dVar);
        }
    }

    public static void v(e eVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        boolean e2 = eVar.j().e(activity);
        C0888c c0888c = new C0888c(jSONObject);
        eVar.T().r(activity, c0888c, null, new a(e2, z, jSONObject, c0888c, callbackHandler, str, eVar, str2), str2);
    }

    public static void w(String str, e eVar, CallbackHandler callbackHandler, String str2, i<f.d> iVar, String str3) {
        SwanAppActivity x = eVar.x();
        if (x == null) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "the activity is null").toString());
            d.a.l0.a.e0.d.h("Api-Login", "Error: activity is null from plugin-invoking.");
            d.a.l0.a.j2.k.O(str3, com.baidu.pass.biometrics.face.liveness.b.b.g0, "the activity is null");
            return;
        }
        String f2 = d.a.l0.a.t1.g.b.f(str);
        d.a.l0.a.e2.d.a.C(x, "snsapi_userinfo", f2, false, str3, new b(callbackHandler, str2, f2, str3, eVar, iVar));
    }

    public static void x(e eVar, CallbackHandler callbackHandler, String str, i<f.d> iVar, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", iVar.f45412a.f45430a);
            d.a.l0.a.e0.d.h("Api-Login", "Success: call back msg = " + jSONObject.toString());
            d.a.l0.a.x1.c.f49436c.e();
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
            d.a.l0.a.j2.k.N(str2, "success");
        } catch (JSONException e2) {
            if (f48497d) {
                e2.printStackTrace();
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
            d.a.l0.a.c1.b.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
            B(eVar, 43, 1001, e2.getMessage());
            String str3 = "Error: exception = " + e2.getMessage() + " stack trace = " + Arrays.toString(e2.getStackTrace());
            d.a.l0.a.e0.d.h("Api-Login", str3);
            d.a.l0.a.j2.k.O(str2, com.baidu.pass.biometrics.face.liveness.b.b.g0, str3);
        }
    }

    public static boolean y(JSONObject jSONObject) {
        return "component".equals(jSONObject.optString("invokeFrom"));
    }

    public d.a.l0.a.u.h.b A(String str) {
        d.a.l0.a.e0.d.h("Api-Login", "start login" + str);
        e Q = e.Q();
        CallbackHandler h2 = a().h();
        if (Q == null) {
            d.a.l0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            d.a.l0.a.e0.d.h("Api-Login", "Error: empty swanApp");
            return new d.a.l0.a.u.h.b(1001, "empty swanApp");
        }
        JSONObject m = d.a.l0.a.u.c.d.m(str);
        if (m == null) {
            d.a.l0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            B(Q, 1, 201, "empty joParams");
            d.a.l0.a.e0.d.h("Api-Login", "Error: empty joParams");
            return new d.a.l0.a.u.h.b(201, "empty joParams");
        }
        String optString = m.optString("invokeFrom");
        String str2 = optString.equals("component") ? "loginButton" : "loginApi";
        d.a.l0.a.j2.k.N(str2, "create");
        String optString2 = m.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            d.a.l0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            B(Q, 1, 201, "empty cb");
            d.a.l0.a.e0.d.h("Api-Login", "Error: empty cb");
            return new d.a.l0.a.u.h.b(201, "empty cb");
        } else if (!m.optBoolean("force", true) && !Q.j().e(i())) {
            h2.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            d.a.l0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
            B(Q, 43, 10004, "user not logged in");
            d.a.l0.a.e0.d.h("Api-Login", "Success: force login is false, will not force execute login.");
            return new d.a.l0.a.u.h.b(0);
        } else {
            Context i2 = i();
            if (!(i2 instanceof Activity) && (i2 = Q.x()) == null) {
                d.a.l0.a.e0.d.h("Api-Login", "Error: context is not an activity");
                return new d.a.l0.a.u.h.b(1001, "the context is not an activity");
            }
            Activity activity = (Activity) i2;
            if (!Q.j().e(i2)) {
                d.a.l0.a.j2.k.M("show", 1, optString);
            }
            if (!d.a.l0.a.a2.d.g().r().j().e(i2)) {
                d.a.l0.a.j2.k.N(str2, "passLogin");
            }
            v(Q, activity, m, h2, optString2, true, str2);
            return new d.a.l0.a.u.h.b(0);
        }
    }

    public d.a.l0.a.u.h.b u(String str) {
        if (f48497d) {
            Log.d("Api-Login", "start getLoginCode action, params = " + str);
        }
        d.a.l0.a.j2.k.N("getLoginCode", "create");
        CallbackHandler h2 = a().h();
        e Q = e.Q();
        if (Q == null) {
            d.a.l0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return new d.a.l0.a.u.h.b(1001, "empty swanApp");
        } else if (!Q.j().e(i())) {
            d.a.l0.a.j2.k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.b.g0);
            return new d.a.l0.a.u.h.b(10004, "user not logged in");
        } else {
            JSONObject m = d.a.l0.a.u.c.d.m(str);
            if (m == null) {
                d.a.l0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                B(Q, 1, 201, "empty joParams");
                d.a.l0.a.j2.k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.b.g0);
                return new d.a.l0.a.u.h.b(201, "empty joParams");
            }
            String optString = m.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.l0.a.c1.b.j().f(h2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                B(Q, 1, 201, "empty cb");
                d.a.l0.a.j2.k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.b.g0);
                return new d.a.l0.a.u.h.b(201, "empty cb");
            }
            Context i2 = i();
            if (!(i2 instanceof Activity) && (i2 = Q.x()) == null) {
                d.a.l0.a.j2.k.N("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.b.g0);
                return new d.a.l0.a.u.h.b(1001, "the context is not an activity");
            }
            Activity activity = (Activity) i2;
            if (!d.a.l0.a.a2.d.g().r().j().e(i2)) {
                d.a.l0.a.j2.k.N("getLoginCode", "passLogin");
            }
            v(Q, activity, m, h2, optString, false, "getLoginCode");
            return new d.a.l0.a.u.h.b(0);
        }
    }

    public d.a.l0.a.u.h.b z() {
        if (f48497d) {
            Log.d("Api-Login", "start is login action");
        }
        e Q = e.Q();
        if (Q == null) {
            d.a.l0.a.e0.d.b("Api-Login", "swan app is null");
            return new d.a.l0.a.u.h.b(202, "swan app is null");
        }
        JSONObject d2 = d.a.l0.a.r1.k.g.a.c().d("isLoginSync");
        if (d2 == null) {
            try {
                d2 = new JSONObject();
                d2.put("isLogin", Q.j().e(i()));
                d.a.l0.a.r1.k.g.a.c().h("isLoginSync", d2);
            } catch (JSONException unused) {
                d.a.l0.a.e0.d.b("Api-Login", "json parse fail");
                return new d.a.l0.a.u.h.b(1001);
            }
        }
        return new d.a.l0.a.u.h.b(0, d2);
    }
}
