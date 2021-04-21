package d.b.h0.a.z1;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.b.h0.a.k;
import d.b.h0.a.y0.e.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47920a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f47921b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f47922c = false;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f47923d = false;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f47924e = false;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f47925f = false;

    /* renamed from: g  reason: collision with root package name */
    public static HashMap<String, String> f47926g;

    /* renamed from: h  reason: collision with root package name */
    public static String f47927h;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.z1.k.f f47928e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47929f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47930g;

        public a(d.b.h0.a.z1.k.f fVar, String str, String str2) {
            this.f47928e = fVar;
            this.f47929f = str;
            this.f47930g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47928e.b(h.l(this.f47929f));
            this.f47928e.d(this.f47930g);
            h.onEvent(this.f47928e);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.z1.k.f f47931e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47932f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47933g;

        public b(d.b.h0.a.z1.k.f fVar, String str, String str2) {
            this.f47931e = fVar;
            this.f47932f = str;
            this.f47933g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47931e.d(this.f47932f);
            this.f47931e.b(h.l(this.f47933g));
            h.onEvent(this.f47931e);
        }
    }

    public static void A(boolean z) {
        f47924e = z;
    }

    public static void B(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (f47926g == null) {
            f47926g = new HashMap<>();
        }
        f47926g.put(str, str2);
    }

    public static void C() {
        d.b.h0.a.p.d.b T2;
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            return;
        }
        d.b.h0.a.e0.l.c m = W.m();
        if (!(m instanceof d.b.h0.a.e0.l.e) || (T2 = ((d.b.h0.a.e0.l.e) m).T2()) == null) {
            return;
        }
        f47927h = T2.c();
    }

    public static void D() {
        HybridUbcFlow d2 = d.b.h0.a.j1.i.d("startup");
        if (d2 == null) {
            return;
        }
        if (d2.s() || d2.q()) {
            return;
        }
        d2.z("value", "fe_success");
    }

    public static void a(d.b.h0.a.p.d.j.d dVar) {
        d.b.h0.a.r1.e y;
        b.a J;
        if (e() || f() || dVar == null || (y = d.b.h0.a.r1.e.y()) == null || (J = y.J()) == null) {
            return;
        }
        if (f47920a) {
            Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
        }
        x(true);
        y(true);
        c(J, dVar.f46174b, "0", dVar.f46175c, b(dVar.f46179g), false);
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
                if (f47920a) {
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
                if (f47920a) {
                    e3.printStackTrace();
                }
            }
            j(aVar, "fmparrsuccess", j2, jSONObject2);
        }
    }

    public static synchronized boolean d() {
        boolean z;
        synchronized (e.class) {
            z = f47921b;
        }
        return z;
    }

    public static boolean e() {
        return f47922c;
    }

    public static boolean f() {
        return f47923d;
    }

    public static boolean g() {
        return f47924e;
    }

    public static boolean h() {
        return f47925f;
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
        d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
        fVar.f47972a = h.n(aVar.F());
        fVar.f47976e = G;
        if (d.b.h0.a.c0.d.d.e.d()) {
            fVar.f47974c = "remote-debug";
        } else {
            fVar.f47974c = aVar.S();
        }
        fVar.f47973b = Config.LAUNCH;
        fVar.f47975d = str;
        fVar.a("arrivetime", String.valueOf(j2));
        if (jSONObject != null) {
            fVar.e(jSONObject);
        }
        Bundle O = aVar.O();
        if (O != null) {
            fVar.d(O.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        if (f47920a) {
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

    public static void k(d.b.h0.a.z1.k.f fVar, String str, String str2) {
        ExecutorUtilsExt.postOnElastic(new b(fVar, str2, str), "onLaunchSuccessUBC", 2);
    }

    public static void l(b.a aVar) {
        if (aVar == null || f47924e) {
            return;
        }
        A(true);
        i(aVar, "naarrsuccess");
    }

    public static void m(b.a aVar) {
        if (f47920a) {
            Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
        }
        d.b.h0.a.f1.e.e(f47927h);
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
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null) {
            return;
        }
        p(y.J());
    }

    public static void p(d.b.h0.a.y0.e.b bVar) {
        Bundle O;
        if (bVar == null || !d() || (O = bVar.O()) == null || O.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
        fVar.f47972a = h.n(bVar.F());
        fVar.f47976e = bVar.G();
        fVar.f47974c = bVar.S();
        fVar.f47973b = Config.LAUNCH;
        fVar.f47975d = "realsuccess";
        fVar.d(O.getString(UBCCloudControlProcessor.UBC_KEY));
        h.onEvent(fVar);
        O.remove("page_display_flag_for_statistic");
        D();
    }

    public static void q(String str) {
        if (f47925f) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            d.b.h0.a.f1.e.e(str);
            f47925f = false;
        }
    }

    public static void r(String str, b.a aVar) {
        HashMap<String, String> hashMap = f47926g;
        String str2 = hashMap != null ? hashMap.get(f47927h) : "";
        if (f47920a) {
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
        f47925f = true;
    }

    public static void s(@NonNull d.b.h0.a.y0.e.b bVar) {
        d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
        fVar.f47972a = h.n(0);
        fVar.f47976e = bVar.G();
        fVar.f47974c = bVar.S();
        fVar.f47973b = "show";
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
            f47922c = z;
        }
    }

    public static synchronized void y(boolean z) {
        synchronized (e.class) {
            f47923d = z;
        }
    }

    public static synchronized void z(boolean z) {
        synchronized (e.class) {
            f47921b = z;
        }
    }
}
