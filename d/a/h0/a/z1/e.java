package d.a.h0.a.z1;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.h0.a.k;
import d.a.h0.a.y0.e.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45356a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f45357b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f45358c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f45359d = false;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f45360e = false;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f45361f = false;

    /* renamed from: g  reason: collision with root package name */
    public static HashMap<String, String> f45362g;

    /* renamed from: h  reason: collision with root package name */
    public static String f45363h;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.f f45364e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45365f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45366g;

        public a(d.a.h0.a.z1.k.f fVar, String str, String str2) {
            this.f45364e = fVar;
            this.f45365f = str;
            this.f45366g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45364e.b(h.l(this.f45365f));
            this.f45364e.d(this.f45366g);
            h.onEvent(this.f45364e);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.f f45367e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45368f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45369g;

        public b(d.a.h0.a.z1.k.f fVar, String str, String str2) {
            this.f45367e = fVar;
            this.f45368f = str;
            this.f45369g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45367e.d(this.f45368f);
            this.f45367e.b(h.l(this.f45369g));
            h.onEvent(this.f45367e);
        }
    }

    public static void A(boolean z) {
        f45360e = z;
    }

    public static void B(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (f45362g == null) {
            f45362g = new HashMap<>();
        }
        f45362g.put(str, str2);
    }

    public static void C() {
        d.a.h0.a.p.d.b S2;
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            return;
        }
        d.a.h0.a.e0.l.c m = W.m();
        if (!(m instanceof d.a.h0.a.e0.l.e) || (S2 = ((d.a.h0.a.e0.l.e) m).S2()) == null) {
            return;
        }
        f45363h = S2.c();
    }

    public static void D() {
        HybridUbcFlow d2 = d.a.h0.a.j1.i.d("startup");
        if (d2 == null) {
            return;
        }
        if (d2.s() || d2.q()) {
            return;
        }
        d2.z("value", "fe_success");
    }

    public static void a(d.a.h0.a.p.d.j.d dVar) {
        d.a.h0.a.r1.e h2;
        b.a J;
        if (e() || f() || dVar == null || (h2 = d.a.h0.a.r1.e.h()) == null || (J = h2.J()) == null) {
            return;
        }
        if (f45356a) {
            Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
        }
        x(true);
        y(true);
        c(J, dVar.f43521b, "0", dVar.f43522c, b(dVar.f43526g), false);
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
        x(true);
        if (z || j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("valuetype", str);
            } catch (JSONException e2) {
                if (f45356a) {
                    e2.printStackTrace();
                }
            }
            j(aVar, "arrivesuccess", j, jSONObject);
        }
        if (z || j2 > 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("valuetype", str2);
            } catch (JSONException e3) {
                if (f45356a) {
                    e3.printStackTrace();
                }
            }
            j(aVar, "fmparrsuccess", j2, jSONObject2);
        }
    }

    public static synchronized boolean d() {
        boolean z;
        synchronized (e.class) {
            z = f45357b;
        }
        return z;
    }

    public static boolean e() {
        return f45358c;
    }

    public static boolean f() {
        return f45359d;
    }

    public static boolean g() {
        return f45360e;
    }

    public static boolean h() {
        return f45361f;
    }

    public static void i(b.a aVar, String str) {
        j(aVar, str, System.currentTimeMillis(), null);
    }

    public static void j(b.a aVar, String str, long j, JSONObject jSONObject) {
        String G = aVar.G();
        if (G == null || aVar == null) {
            return;
        }
        long j2 = 0;
        if (j != -1) {
            long k = aVar.k("launch_time", 0L);
            if (j <= 0) {
                j = System.currentTimeMillis();
            }
            j2 = j - k;
        }
        d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
        fVar.f45411a = h.n(aVar.F());
        fVar.f45415e = G;
        if (d.a.h0.a.c0.d.d.e.d()) {
            fVar.f45413c = "remote-debug";
        } else {
            fVar.f45413c = aVar.S();
        }
        fVar.f45412b = "launch";
        fVar.f45414d = str;
        fVar.a("arrivetime", String.valueOf(j2));
        if (jSONObject != null) {
            fVar.e(jSONObject);
        }
        Bundle O = aVar.O();
        if (O != null) {
            fVar.d(O.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        if (f45356a) {
            StringBuilder sb = new StringBuilder();
            sb.append("handle record arrival event, arrivalValue ");
            sb.append(str);
            sb.append(" arrive time : ");
            sb.append(j2);
            sb.append(" extJson :");
            sb.append(jSONObject == null ? "" : jSONObject.toString());
            Log.d("SwanAppLaunchUbc", sb.toString());
        }
        h.onEvent(fVar);
    }

    public static void k(d.a.h0.a.z1.k.f fVar, String str, String str2) {
        ExecutorUtilsExt.postOnElastic(new b(fVar, str2, str), "onLaunchSuccessUBC", 2);
    }

    public static void l(b.a aVar) {
        if (aVar == null || f45360e) {
            return;
        }
        A(true);
        i(aVar, "naarrsuccess");
    }

    public static void m(b.a aVar) {
        if (f45356a) {
            Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
        }
        d.a.h0.a.f1.e.e(f45363h);
        if (e() || f()) {
            return;
        }
        c(aVar, -1L, "1", -1L, "1", true);
    }

    public static void n(b.a aVar) {
        if (aVar == null || f()) {
            return;
        }
        y(true);
        i(aVar, "arrivecancel");
    }

    public static void o() {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            return;
        }
        p(h2.J());
    }

    public static void p(d.a.h0.a.y0.e.b bVar) {
        Bundle O;
        if (bVar == null || !d() || (O = bVar.O()) == null || O.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
        fVar.f45411a = h.n(bVar.F());
        fVar.f45415e = bVar.G();
        fVar.f45413c = bVar.S();
        fVar.f45412b = "launch";
        fVar.f45414d = "realsuccess";
        fVar.d(O.getString(UBCCloudControlProcessor.UBC_KEY));
        h.onEvent(fVar);
        O.remove("page_display_flag_for_statistic");
        D();
    }

    public static void q(String str) {
        if (f45361f) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            d.a.h0.a.f1.e.e(str);
            f45361f = false;
        }
    }

    public static void r(String str, b.a aVar) {
        HashMap<String, String> hashMap = f45362g;
        String str2 = hashMap != null ? hashMap.get(f45363h) : "";
        if (f45356a) {
            StringBuilder sb = new StringBuilder();
            sb.append("handle relaunch , launchPage : ");
            sb.append(str);
            sb.append(" lastSlavePath ：");
            sb.append(str2 != null ? str2 : "");
            Log.d("SwanAppLaunchUbc", sb.toString());
        }
        if (TextUtils.equals(str, str2)) {
            m(aVar);
            return;
        }
        u();
        f45361f = true;
    }

    public static void s(@NonNull d.a.h0.a.y0.e.b bVar) {
        d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
        fVar.f45411a = h.n(0);
        fVar.f45415e = bVar.G();
        fVar.f45413c = bVar.S();
        fVar.f45412b = "show";
        ExecutorUtilsExt.postOnElastic(new a(fVar, bVar.V(), bVar.n0().getString(UBCCloudControlProcessor.UBC_KEY)), "onShow606", 2);
    }

    public static void t() {
        y(false);
    }

    public static void u() {
        x(false);
    }

    public static void v() {
        z(false);
    }

    public static void w() {
        v();
        A(false);
        u();
        t();
    }

    public static synchronized void x(boolean z) {
        synchronized (e.class) {
            f45358c = z;
        }
    }

    public static synchronized void y(boolean z) {
        synchronized (e.class) {
            f45359d = z;
        }
    }

    public static synchronized void z(boolean z) {
        synchronized (e.class) {
            f45357b = z;
        }
    }
}
