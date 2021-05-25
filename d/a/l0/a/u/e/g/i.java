package d.a.l0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends d.a.l0.a.u.c.d {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45000g = k.f43199a;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppWebPopWindow f45001d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.h0.g.l.a f45002e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.h0.g.d f45003f;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45004e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45005f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45006g;

        public a(String str, d.a.l0.a.a2.e eVar, String str2) {
            this.f45004e = str;
            this.f45005f = eVar;
            this.f45006g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                i.this.C(this.f45005f, this.f45006g, this.f45004e);
            } else {
                i.this.d(this.f45004e, new d.a.l0.a.u.h.b(10005, "system deny"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45009f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45010g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45011h;

        /* loaded from: classes2.dex */
        public class a extends d.a.l0.a.h0.g.l.a {
            public a() {
            }

            @Override // d.a.l0.a.h0.g.l.a, d.a.l0.a.h0.g.l.b
            public void a() {
                super.a();
                d.a.l0.a.e0.d.g("Api-WebPopWindow", "swanId=" + b.this.f45009f.f40749f + ", nowId=" + d.a.l0.a.a2.e.V());
                if (TextUtils.equals(b.this.f45009f.f40749f, d.a.l0.a.a2.e.V())) {
                    return;
                }
                i.this.B();
            }

            @Override // d.a.l0.a.h0.g.l.b
            public void b() {
                d.a.l0.a.e0.d.g("Api-WebPopWindow", "call onFragmentDestroyed");
                i.this.B();
                if (i.this.f45003f == null || i.this.f45002e == null) {
                    return;
                }
                i.this.f45003f.F2(i.this.f45002e);
            }
        }

        public b(String str, d.a.l0.a.a2.e eVar, String str2, String str3) {
            this.f45008e = str;
            this.f45009f = eVar;
            this.f45010g = str2;
            this.f45011h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
            if (activity == null) {
                return;
            }
            if (i.this.f45001d != null && i.this.f45001d.x()) {
                i.this.d(this.f45008e, new d.a.l0.a.u.h.b(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
            if (W == null) {
                return;
            }
            i.this.f45003f = W.m();
            if (i.this.f45003f == null) {
                return;
            }
            if (i.this.f45002e != null) {
                i.this.f45003f.F2(i.this.f45002e);
            }
            i.this.f45002e = new a();
            i.this.f45003f.h2(i.this.f45002e);
            i iVar = i.this;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.f45010g);
            swanAppWebPopWindow.B0(d.a.l0.a.h.swan_app_baidu_guarantee_title);
            iVar.f45001d = swanAppWebPopWindow;
            if (TextUtils.equals(this.f45011h, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = i.this.f45001d;
                swanAppWebPopWindow2.x0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.y0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = i.this.f45001d;
            swanAppWebPopWindow3.w0();
            swanAppWebPopWindow3.D0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e2) {
                if (i.f45000g) {
                    e2.printStackTrace();
                }
            }
            i.this.d(this.f45008e, new d.a.l0.a.u.h.b(0, "show halfScreenWebview success", jSONObject));
        }
    }

    public i(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void A(d.a.l0.a.a2.e eVar, String str, String str2) {
        if (TextUtils.equals(str, "protect")) {
            eVar.T().g(i(), "scope_web_window_pay_protected", new a(str2, eVar, str));
        } else {
            d(str2, new d.a.l0.a.u.h.b(202, "type is invalid"));
        }
    }

    public final void B() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        if (!this.f45003f.W() || (swanAppWebPopWindow = this.f45001d) == null) {
            return;
        }
        swanAppWebPopWindow.r();
    }

    public final void C(d.a.l0.a.a2.e eVar, String str, String str2) {
        String D = D(eVar, str);
        if (D == null) {
            d(str2, new d.a.l0.a.u.h.b(202, "type is invalid"));
        } else {
            q0.b0(new b(str2, eVar, D, str));
        }
    }

    public final String D(d.a.l0.a.a2.e eVar, String str) {
        if (!TextUtils.equals(str, "protect") || eVar == null) {
            return null;
        }
        return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + eVar.D();
    }

    public d.a.l0.a.u.h.b E(String str) {
        if (f45000g) {
            Log.d("Api-WebPopWindow", "start show web pop window action, params =" + str);
        }
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return new d.a.l0.a.u.h.b(202, "swanApp is null");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> a2 = d.a.l0.a.u.i.b.a(str);
        JSONObject jSONObject = (JSONObject) a2.second;
        if (((d.a.l0.a.u.h.b) a2.first).a() && jSONObject != null) {
            String optString = jSONObject.optString("type");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.l0.a.u.h.b(202, "type is invalid");
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.l0.a.u.h.b(202, "cb is invalid");
            }
            A(Q, optString, optString2);
            return new d.a.l0.a.u.h.b(0);
        }
        return new d.a.l0.a.u.h.b(202);
    }
}
