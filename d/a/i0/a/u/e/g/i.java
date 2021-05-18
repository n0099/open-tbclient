package d.a.i0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends d.a.i0.a.u.c.d {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44824g = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppWebPopWindow f44825d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.h0.g.l.a f44826e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.a.h0.g.d f44827f;

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44828e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f44829f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44830g;

        public a(String str, d.a.i0.a.a2.e eVar, String str2) {
            this.f44828e = str;
            this.f44829f = eVar;
            this.f44830g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                i.this.C(this.f44829f, this.f44830g, this.f44828e);
            } else {
                i.this.d(this.f44828e, new d.a.i0.a.u.h.b(10005, "system deny"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44832e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f44833f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44834g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44835h;

        /* loaded from: classes2.dex */
        public class a extends d.a.i0.a.h0.g.l.a {
            public a() {
            }

            @Override // d.a.i0.a.h0.g.l.a, d.a.i0.a.h0.g.l.b
            public void a() {
                super.a();
                d.a.i0.a.e0.d.g("Api-WebPopWindow", "swanId=" + b.this.f44833f.f40575f + ", nowId=" + d.a.i0.a.a2.e.V());
                if (TextUtils.equals(b.this.f44833f.f40575f, d.a.i0.a.a2.e.V())) {
                    return;
                }
                i.this.B();
            }

            @Override // d.a.i0.a.h0.g.l.b
            public void b() {
                d.a.i0.a.e0.d.g("Api-WebPopWindow", "call onFragmentDestroyed");
                i.this.B();
                if (i.this.f44827f == null || i.this.f44826e == null) {
                    return;
                }
                i.this.f44827f.F2(i.this.f44826e);
            }
        }

        public b(String str, d.a.i0.a.a2.e eVar, String str2, String str3) {
            this.f44832e = str;
            this.f44833f = eVar;
            this.f44834g = str2;
            this.f44835h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity = d.a.i0.a.g1.f.V().getActivity();
            if (activity == null) {
                return;
            }
            if (i.this.f44825d != null && i.this.f44825d.x()) {
                i.this.d(this.f44832e, new d.a.i0.a.u.h.b(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            d.a.i0.a.h0.g.g W = d.a.i0.a.g1.f.V().W();
            if (W == null) {
                return;
            }
            i.this.f44827f = W.m();
            if (i.this.f44827f == null) {
                return;
            }
            if (i.this.f44826e != null) {
                i.this.f44827f.F2(i.this.f44826e);
            }
            i.this.f44826e = new a();
            i.this.f44827f.h2(i.this.f44826e);
            i iVar = i.this;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.f44834g);
            swanAppWebPopWindow.B0(d.a.i0.a.h.swan_app_baidu_guarantee_title);
            iVar.f44825d = swanAppWebPopWindow;
            if (TextUtils.equals(this.f44835h, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = i.this.f44825d;
                swanAppWebPopWindow2.x0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.y0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = i.this.f44825d;
            swanAppWebPopWindow3.w0();
            swanAppWebPopWindow3.D0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e2) {
                if (i.f44824g) {
                    e2.printStackTrace();
                }
            }
            i.this.d(this.f44832e, new d.a.i0.a.u.h.b(0, "show halfScreenWebview success", jSONObject));
        }
    }

    public i(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void A(d.a.i0.a.a2.e eVar, String str, String str2) {
        if (TextUtils.equals(str, "protect")) {
            eVar.T().g(i(), "scope_web_window_pay_protected", new a(str2, eVar, str));
        } else {
            d(str2, new d.a.i0.a.u.h.b(202, "type is invalid"));
        }
    }

    public final void B() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        if (!this.f44827f.W() || (swanAppWebPopWindow = this.f44825d) == null) {
            return;
        }
        swanAppWebPopWindow.r();
    }

    public final void C(d.a.i0.a.a2.e eVar, String str, String str2) {
        String D = D(eVar, str);
        if (D == null) {
            d(str2, new d.a.i0.a.u.h.b(202, "type is invalid"));
        } else {
            q0.b0(new b(str2, eVar, D, str));
        }
    }

    public final String D(d.a.i0.a.a2.e eVar, String str) {
        if (!TextUtils.equals(str, "protect") || eVar == null) {
            return null;
        }
        return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + eVar.D();
    }

    public d.a.i0.a.u.h.b E(String str) {
        if (f44824g) {
            Log.d("Api-WebPopWindow", "start show web pop window action, params =" + str);
        }
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            return new d.a.i0.a.u.h.b(202, "swanApp is null");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> a2 = d.a.i0.a.u.i.b.a(str);
        JSONObject jSONObject = (JSONObject) a2.second;
        if (((d.a.i0.a.u.h.b) a2.first).a() && jSONObject != null) {
            String optString = jSONObject.optString("type");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.i0.a.u.h.b(202, "type is invalid");
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.i0.a.u.h.b(202, "cb is invalid");
            }
            A(Q, optString, optString2);
            return new d.a.i0.a.u.h.b(0);
        }
        return new d.a.i0.a.u.h.b(202);
    }
}
