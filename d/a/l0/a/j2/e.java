package d.a.l0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.v2.q0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43103a = d.a.l0.a.k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f43104b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f43105c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f43106d = false;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f43107e = false;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f43108f = false;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f43109g = false;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f43110h;

    /* renamed from: i  reason: collision with root package name */
    public static String f43111i;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f43112e;

        public a(Bundle bundle) {
            this.f43112e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43112e.remove("page_display_flag_for_statistic");
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.f f43113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43115g;

        public b(d.a.l0.a.j2.p.f fVar, String str, String str2) {
            this.f43113e = fVar;
            this.f43114f = str;
            this.f43115g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43113e.b(k.k(this.f43114f));
            this.f43113e.d(this.f43115g);
            k.onEvent(this.f43113e);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.f f43116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43117f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43118g;

        public c(d.a.l0.a.j2.p.f fVar, String str, String str2) {
            this.f43116e = fVar;
            this.f43117f = str;
            this.f43118g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43116e.d(this.f43117f);
            this.f43116e.b(k.k(this.f43118g));
            k.onEvent(this.f43116e);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.f f43119e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43120f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43121g;

        public d(d.a.l0.a.j2.p.f fVar, String str, String str2) {
            this.f43119e = fVar;
            this.f43120f = str;
            this.f43121g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43119e.b(k.k(this.f43120f));
            this.f43119e.d(this.f43121g);
            k.onEvent(this.f43119e);
        }
    }

    /* renamed from: d.a.l0.a.j2.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0723e implements d.a.l0.a.v2.e1.b<JSONObject> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.f f43122e;

        public C0723e(d.a.l0.a.j2.p.f fVar) {
            this.f43122e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            this.f43122e.a("deviceInfo", jSONObject);
            k.onEvent(this.f43122e);
            d.a.l0.a.e0.d.h("SwanAppLaunchUbc", jSONObject.toString());
            d.a.l0.a.c1.a.g0().c(false);
        }
    }

    public static synchronized void A(boolean z) {
        synchronized (e.class) {
            f43105c = z;
        }
    }

    public static synchronized void B(boolean z) {
        synchronized (e.class) {
            f43106d = z;
        }
    }

    public static synchronized void C(boolean z) {
        synchronized (e.class) {
            f43104b = z;
        }
    }

    public static void D(boolean z) {
        f43108f = z;
    }

    public static void E(boolean z) {
        f43107e = z;
    }

    public static void F(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (f43110h == null) {
            f43110h = new HashMap<>();
        }
        f43110h.put(str, str2);
    }

    public static void G() {
        d.a.l0.a.p.e.b b3;
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        if (W == null) {
            return;
        }
        d.a.l0.a.h0.g.d m = W.m();
        if (!(m instanceof d.a.l0.a.h0.g.f) || (b3 = ((d.a.l0.a.h0.g.f) m).b3()) == null) {
            return;
        }
        f43111i = b3.b();
    }

    public static void H() {
        HybridUbcFlow d2 = d.a.l0.a.r1.h.d("startup");
        if (d2 == null) {
            return;
        }
        if (d2.t() || d2.r()) {
            return;
        }
        d2.B("value", "fe_success");
    }

    public static void a(d.a.l0.a.p.e.j.d dVar) {
        d.a.l0.a.a2.e i2;
        b.a L;
        if (f() || g() || dVar == null || (i2 = d.a.l0.a.a2.e.i()) == null || (L = i2.L()) == null) {
            return;
        }
        if (f43103a) {
            Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
        }
        A(true);
        B(true);
        c(L, dVar.f44001b, "0", dVar.f44002c, b(dVar.f44006g), false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(String str) {
        char c2;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 49:
                if (str.equals("1")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        return c2 != 1 ? c2 != 2 ? c2 != 3 ? "0" : "4" : "3" : "2";
    }

    public static void c(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        A(true);
        if (z || j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("valuetype", str);
            } catch (JSONException e2) {
                if (f43103a) {
                    e2.printStackTrace();
                }
            }
            l(aVar, "arrivesuccess", j, jSONObject);
        }
        if (z || j2 > 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("valuetype", str2);
            } catch (JSONException e3) {
                if (f43103a) {
                    e3.printStackTrace();
                }
            }
            l(aVar, "fmparrsuccess", j2, jSONObject2);
        }
    }

    public static void d(@NonNull b.a aVar) {
        E(true);
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43185a = k.m(0);
        fVar.f43186b = "launch";
        fVar.f43189e = "narendersuccess";
        fVar.h(aVar);
        d.a.l0.a.r1.k.i.c.f().e(new d(fVar, aVar.W(), aVar.r0().getString(UBCCloudControlProcessor.UBC_KEY)), "handleNaRenderSuccess");
    }

    public static synchronized boolean e() {
        boolean z;
        synchronized (e.class) {
            z = f43104b;
        }
        return z;
    }

    public static boolean f() {
        return f43105c;
    }

    public static boolean g() {
        return f43106d;
    }

    public static boolean h() {
        return f43108f;
    }

    public static boolean i() {
        return f43107e;
    }

    public static boolean j() {
        return f43109g;
    }

    public static void k(b.a aVar, String str) {
        l(aVar, str, System.currentTimeMillis(), null);
    }

    public static void l(b.a aVar, String str, long j, JSONObject jSONObject) {
        String H = aVar.H();
        if (H == null || aVar == null) {
            return;
        }
        long j2 = 0;
        if (j != -1) {
            long l = aVar.l("launch_time", 0L);
            if (j <= 0) {
                j = System.currentTimeMillis();
            }
            j2 = j - l;
        }
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43185a = k.m(aVar.G());
        fVar.f43190f = H;
        if (d.a.l0.a.e0.f.e.e.d()) {
            fVar.f43187c = "remote-debug";
        } else if (d.a.l0.a.u1.a.a.C()) {
            fVar.f43187c = "local-debug";
        } else {
            fVar.f43187c = aVar.T();
        }
        fVar.f43186b = "launch";
        fVar.f43189e = str;
        fVar.a("arrivetime", String.valueOf(j2));
        if (jSONObject != null) {
            fVar.e(jSONObject);
        }
        Bundle P = aVar.P();
        if (P != null) {
            fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        fVar.b(k.k(aVar.W()));
        if (f43103a) {
            StringBuilder sb = new StringBuilder();
            sb.append("handle record arrival event, arrivalValue ");
            sb.append(str);
            sb.append(" arrive time : ");
            sb.append(j2);
            sb.append(" extJson :");
            sb.append(jSONObject == null ? "" : jSONObject.toString());
            Log.d("SwanAppLaunchUbc", sb.toString());
        }
        k.onEvent(fVar);
    }

    public static void m(@NonNull d.a.l0.a.f1.e.b bVar, int i2, @NonNull d.a.l0.a.q2.a aVar) {
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43185a = k.m(i2);
        fVar.f43186b = "launch";
        fVar.f43189e = "fail";
        fVar.a("errcode", String.valueOf(aVar.a()));
        fVar.a("msg", aVar.f().toString());
        fVar.h(bVar);
        fVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.b(k.k(bVar.W()));
        d.a.l0.a.v2.m.d(bVar, new C0723e(fVar));
    }

    public static void n(d.a.l0.a.j2.p.f fVar, String str, String str2) {
        d.a.l0.a.r1.k.i.c.f().e(new c(fVar, str2, str), "onLaunchSuccessUBC");
    }

    public static void o(b.a aVar) {
        if (aVar == null || f43108f) {
            return;
        }
        D(true);
        k(aVar, "naarrsuccess");
    }

    public static void p(b.a aVar) {
        if (f43103a) {
            Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
        }
        d.a.l0.a.m1.f.e(f43111i);
        if (!i()) {
            d(aVar);
        }
        if (f() || g()) {
            return;
        }
        c(aVar, -1L, "1", -1L, "1", true);
    }

    public static void q(b.a aVar) {
        if (aVar == null || g()) {
            return;
        }
        B(true);
        k(aVar, "arrivecancel");
    }

    public static void r() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null) {
            return;
        }
        s(i2.L());
    }

    public static void s(d.a.l0.a.f1.e.b bVar) {
        Bundle P;
        if (bVar == null || !e() || (P = bVar.P()) == null) {
            return;
        }
        long j = P.getLong("page_display_flag_for_statistic");
        long l = bVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j > 0) {
            d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
            fVar.f43185a = k.m(bVar.G());
            fVar.f43190f = bVar.H();
            fVar.f43187c = bVar.T();
            fVar.f43186b = "launch";
            fVar.f43189e = "realsuccess";
            fVar.r = String.valueOf(currentTimeMillis - l);
            fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            k.onEvent(fVar);
            q0.b0(new a(P));
            H();
        }
    }

    public static void t(String str) {
        if (f43109g) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            d.a.l0.a.m1.f.e(str);
            f43109g = false;
        }
    }

    public static void u(String str, b.a aVar) {
        HashMap<String, String> hashMap = f43110h;
        String str2 = hashMap != null ? hashMap.get(f43111i) : "";
        if (f43103a) {
            StringBuilder sb = new StringBuilder();
            sb.append("handle relaunch , launchPage : ");
            sb.append(str);
            sb.append(" lastSlavePath ：");
            sb.append(str2 != null ? str2 : "");
            Log.d("SwanAppLaunchUbc", sb.toString());
        }
        if (TextUtils.equals(str, str2)) {
            p(aVar);
            return;
        }
        x();
        f43109g = true;
    }

    public static void v(@NonNull d.a.l0.a.f1.e.b bVar) {
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43185a = k.m(0);
        fVar.f43190f = bVar.H();
        fVar.f43187c = bVar.T();
        fVar.f43186b = "show";
        d.a.l0.a.r1.k.i.c.f().e(new b(fVar, bVar.W(), bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY)), "onShow606");
    }

    public static void w() {
        B(false);
    }

    public static void x() {
        A(false);
    }

    public static void y() {
        C(false);
    }

    public static void z() {
        y();
        D(false);
        x();
        w();
        E(false);
    }
}
