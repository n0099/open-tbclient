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
    public static final boolean f48674g = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppWebPopWindow f48675d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.h0.g.l.a f48676e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.h0.g.d f48677f;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f48679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48680g;

        public a(String str, d.a.l0.a.a2.e eVar, String str2) {
            this.f48678e = str;
            this.f48679f = eVar;
            this.f48680g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                i.this.C(this.f48679f, this.f48680g, this.f48678e);
            } else {
                i.this.d(this.f48678e, new d.a.l0.a.u.h.b(10005, "system deny"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48682e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f48683f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48684g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48685h;

        /* loaded from: classes2.dex */
        public class a extends d.a.l0.a.h0.g.l.a {
            public a() {
            }

            @Override // d.a.l0.a.h0.g.l.a, d.a.l0.a.h0.g.l.b
            public void a() {
                super.a();
                d.a.l0.a.e0.d.g("Api-WebPopWindow", "swanId=" + b.this.f48683f.f44425f + ", nowId=" + d.a.l0.a.a2.e.V());
                if (TextUtils.equals(b.this.f48683f.f44425f, d.a.l0.a.a2.e.V())) {
                    return;
                }
                i.this.B();
            }

            @Override // d.a.l0.a.h0.g.l.b
            public void b() {
                d.a.l0.a.e0.d.g("Api-WebPopWindow", "call onFragmentDestroyed");
                i.this.B();
                if (i.this.f48677f == null || i.this.f48676e == null) {
                    return;
                }
                i.this.f48677f.F2(i.this.f48676e);
            }
        }

        public b(String str, d.a.l0.a.a2.e eVar, String str2, String str3) {
            this.f48682e = str;
            this.f48683f = eVar;
            this.f48684g = str2;
            this.f48685h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
            if (activity == null) {
                return;
            }
            if (i.this.f48675d != null && i.this.f48675d.x()) {
                i.this.d(this.f48682e, new d.a.l0.a.u.h.b(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
            if (W == null) {
                return;
            }
            i.this.f48677f = W.m();
            if (i.this.f48677f == null) {
                return;
            }
            if (i.this.f48676e != null) {
                i.this.f48677f.F2(i.this.f48676e);
            }
            i.this.f48676e = new a();
            i.this.f48677f.h2(i.this.f48676e);
            i iVar = i.this;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.f48684g);
            swanAppWebPopWindow.B0(d.a.l0.a.h.swan_app_baidu_guarantee_title);
            iVar.f48675d = swanAppWebPopWindow;
            if (TextUtils.equals(this.f48685h, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = i.this.f48675d;
                swanAppWebPopWindow2.x0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.y0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = i.this.f48675d;
            swanAppWebPopWindow3.w0();
            swanAppWebPopWindow3.D0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e2) {
                if (i.f48674g) {
                    e2.printStackTrace();
                }
            }
            i.this.d(this.f48682e, new d.a.l0.a.u.h.b(0, "show halfScreenWebview success", jSONObject));
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
        if (!this.f48677f.V() || (swanAppWebPopWindow = this.f48675d) == null) {
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
        if (f48674g) {
            Log.d("Api-WebPopWindow", "start show web pop window action, params =" + str);
        }
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return new d.a.l0.a.u.h.b(202, "swanApp is null");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> a2 = d.a.l0.a.u.i.b.a(str);
        JSONObject jSONObject = (JSONObject) a2.second;
        if (((d.a.l0.a.u.h.b) a2.first).isSuccess() && jSONObject != null) {
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
