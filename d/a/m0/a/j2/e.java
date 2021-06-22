package d.a.m0.a.j2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.v2.q0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46887a = d.a.m0.a.k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f46888b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f46889c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f46890d = false;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f46891e = false;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f46892f = false;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f46893g = false;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f46894h;

    /* renamed from: i  reason: collision with root package name */
    public static String f46895i;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f46896e;

        public a(Bundle bundle) {
            this.f46896e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46896e.remove("page_display_flag_for_statistic");
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.f f46897e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46898f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46899g;

        public b(d.a.m0.a.j2.p.f fVar, String str, String str2) {
            this.f46897e = fVar;
            this.f46898f = str;
            this.f46899g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46897e.b(k.k(this.f46898f));
            this.f46897e.d(this.f46899g);
            k.onEvent(this.f46897e);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.f f46900e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46901f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46902g;

        public c(d.a.m0.a.j2.p.f fVar, String str, String str2) {
            this.f46900e = fVar;
            this.f46901f = str;
            this.f46902g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46900e.d(this.f46901f);
            this.f46900e.b(k.k(this.f46902g));
            k.onEvent(this.f46900e);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.f f46903e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46904f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46905g;

        public d(d.a.m0.a.j2.p.f fVar, String str, String str2) {
            this.f46903e = fVar;
            this.f46904f = str;
            this.f46905g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46903e.b(k.k(this.f46904f));
            this.f46903e.d(this.f46905g);
            k.onEvent(this.f46903e);
        }
    }

    /* renamed from: d.a.m0.a.j2.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0782e implements d.a.m0.a.v2.e1.b<JSONObject> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.f f46906e;

        public C0782e(d.a.m0.a.j2.p.f fVar) {
            this.f46906e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(JSONObject jSONObject) {
            this.f46906e.a("deviceInfo", jSONObject);
            k.onEvent(this.f46906e);
            d.a.m0.a.e0.d.h("SwanAppLaunchUbc", jSONObject.toString());
            d.a.m0.a.c1.a.g0().c(false);
        }
    }

    public static synchronized void A(boolean z) {
        synchronized (e.class) {
            f46889c = z;
        }
    }

    public static synchronized void B(boolean z) {
        synchronized (e.class) {
            f46890d = z;
        }
    }

    public static synchronized void C(boolean z) {
        synchronized (e.class) {
            f46888b = z;
        }
    }

    public static void D(boolean z) {
        f46892f = z;
    }

    public static void E(boolean z) {
        f46891e = z;
    }

    public static void F(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (f46894h == null) {
            f46894h = new HashMap<>();
        }
        f46894h.put(str, str2);
    }

    public static void G() {
        d.a.m0.a.p.e.b b3;
        d.a.m0.a.h0.g.g W = d.a.m0.a.g1.f.V().W();
        if (W == null) {
            return;
        }
        d.a.m0.a.h0.g.d m = W.m();
        if (!(m instanceof d.a.m0.a.h0.g.f) || (b3 = ((d.a.m0.a.h0.g.f) m).b3()) == null) {
            return;
        }
        f46895i = b3.b();
    }

    public static void H() {
        HybridUbcFlow d2 = d.a.m0.a.r1.h.d("startup");
        if (d2 == null) {
            return;
        }
        if (d2.t() || d2.r()) {
            return;
        }
        d2.B("value", "fe_success");
    }

    public static void a(d.a.m0.a.p.e.j.d dVar) {
        d.a.m0.a.a2.e i2;
        b.a L;
        if (f() || g() || dVar == null || (i2 = d.a.m0.a.a2.e.i()) == null || (L = i2.L()) == null) {
            return;
        }
        if (f46887a) {
            Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
        }
        A(true);
        B(true);
        c(L, dVar.f47783b, "0", dVar.f47784c, b(dVar.f47788g), false);
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
                if (f46887a) {
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
                if (f46887a) {
                    e3.printStackTrace();
                }
            }
            l(aVar, "fmparrsuccess", j2, jSONObject2);
        }
    }

    public static void d(@NonNull b.a aVar) {
        E(true);
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46969a = k.m(0);
        fVar.f46970b = "launch";
        fVar.f46973e = "narendersuccess";
        fVar.h(aVar);
        d.a.m0.a.r1.k.i.c.f().e(new d(fVar, aVar.W(), aVar.r0().getString(UBCCloudControlProcessor.UBC_KEY)), "handleNaRenderSuccess");
    }

    public static synchronized boolean e() {
        boolean z;
        synchronized (e.class) {
            z = f46888b;
        }
        return z;
    }

    public static boolean f() {
        return f46889c;
    }

    public static boolean g() {
        return f46890d;
    }

    public static boolean h() {
        return f46892f;
    }

    public static boolean i() {
        return f46891e;
    }

    public static boolean j() {
        return f46893g;
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
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46969a = k.m(aVar.G());
        fVar.f46974f = H;
        if (d.a.m0.a.e0.f.e.e.d()) {
            fVar.f46971c = "remote-debug";
        } else if (d.a.m0.a.u1.a.a.C()) {
            fVar.f46971c = "local-debug";
        } else {
            fVar.f46971c = aVar.T();
        }
        fVar.f46970b = "launch";
        fVar.f46973e = str;
        fVar.a("arrivetime", String.valueOf(j2));
        if (jSONObject != null) {
            fVar.e(jSONObject);
        }
        Bundle P = aVar.P();
        if (P != null) {
            fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        fVar.b(k.k(aVar.W()));
        if (f46887a) {
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

    public static void m(@NonNull d.a.m0.a.f1.e.b bVar, int i2, @NonNull d.a.m0.a.q2.a aVar) {
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46969a = k.m(i2);
        fVar.f46970b = "launch";
        fVar.f46973e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
        fVar.a("errcode", String.valueOf(aVar.a()));
        fVar.a("msg", aVar.f().toString());
        fVar.h(bVar);
        fVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.b(k.k(bVar.W()));
        d.a.m0.a.v2.m.d(bVar, new C0782e(fVar));
    }

    public static void n(d.a.m0.a.j2.p.f fVar, String str, String str2) {
        d.a.m0.a.r1.k.i.c.f().e(new c(fVar, str2, str), "onLaunchSuccessUBC");
    }

    public static void o(b.a aVar) {
        if (aVar == null || f46892f) {
            return;
        }
        D(true);
        k(aVar, "naarrsuccess");
    }

    public static void p(b.a aVar) {
        if (f46887a) {
            Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
        }
        d.a.m0.a.m1.f.e(f46895i);
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
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null) {
            return;
        }
        s(i2.L());
    }

    public static void s(d.a.m0.a.f1.e.b bVar) {
        Bundle P;
        if (bVar == null || !e() || (P = bVar.P()) == null) {
            return;
        }
        long j = P.getLong("page_display_flag_for_statistic");
        long l = bVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j > 0) {
            d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
            fVar.f46969a = k.m(bVar.G());
            fVar.f46974f = bVar.H();
            fVar.f46971c = bVar.T();
            fVar.f46970b = "launch";
            fVar.f46973e = "realsuccess";
            fVar.r = String.valueOf(currentTimeMillis - l);
            fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            k.onEvent(fVar);
            q0.b0(new a(P));
            H();
        }
    }

    public static void t(String str) {
        if (f46893g) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            d.a.m0.a.m1.f.e(str);
            f46893g = false;
        }
    }

    public static void u(String str, b.a aVar) {
        HashMap<String, String> hashMap = f46894h;
        String str2 = hashMap != null ? hashMap.get(f46895i) : "";
        if (f46887a) {
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
        f46893g = true;
    }

    public static void v(@NonNull d.a.m0.a.f1.e.b bVar) {
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46969a = k.m(0);
        fVar.f46974f = bVar.H();
        fVar.f46971c = bVar.T();
        fVar.f46970b = "show";
        d.a.m0.a.r1.k.i.c.f().e(new b(fVar, bVar.W(), bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY)), "onShow606");
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
