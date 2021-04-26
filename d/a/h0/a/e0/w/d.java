package d.a.h0.a.e0.w;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.turbo.PreloadState;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.webkit.sdk.WebView;
import d.a.h0.a.e0.r.a;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.p.c.a1;
import d.a.h0.a.u0.d;
import d.a.h0.a.z1.c;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d implements d.a.h0.a.z0.h {
    public static volatile d v;

    /* renamed from: a  reason: collision with root package name */
    public SwanCoreVersion f42357a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public ExtensionCore f42358b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.e0.k.d.b f42359c;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.a.e0.o.f.e f42361e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.a.e0.o.a f42362f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42363g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.h0.a.p.d.b f42364h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42365i;
    public boolean j;
    public boolean k;
    public final HashMap<String, d.a.h0.a.p.d.d> l;
    public String p;
    public n q;
    public a1 r;
    public d.a.h0.a.p.d.h s;
    public static final boolean u = d.a.h0.a.k.f43101a;
    public static int w = 10150;
    public static boolean x = false;
    public static PreloadState y = PreloadState.UNKNOWN;
    public static boolean z = false;
    public static final boolean A = d.a.h0.a.e0.q.e.a.c();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f42360d = new CopyOnWriteArrayList();
    public LinkedList<d.a.h0.a.k0.b.a> m = new LinkedList<>();
    public final Object n = new Object();
    public final String o = UUID.randomUUID().toString();
    public volatile boolean t = false;

    /* loaded from: classes2.dex */
    public class a extends d.a.h0.a.e0.g {
        public a() {
        }

        @Override // d.a.h0.a.e0.g
        public void a(String str) {
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
            d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_slave_ok"));
            d.this.f42365i = true;
            d.this.f0();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.i2.u0.b<Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            d.this.z0(o.f(bool));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f42368e;

        public c(d dVar, d.a.h0.a.i2.u0.b bVar) {
            this.f42368e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean a2 = d.a.h0.a.w0.a.Y().a();
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + a2);
            }
            d.a.h0.a.i2.u0.b bVar = this.f42368e;
            if (bVar != null) {
                bVar.onCallback(Boolean.FALSE);
            }
        }
    }

    /* renamed from: d.a.h0.a.e0.w.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0656d extends n {
        @Override // d.a.h0.a.e0.w.d.n
        public void b(d dVar) {
            boolean z = !TextUtils.isEmpty(d.a.h0.a.r1.d.e().getAppId());
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
            if (z) {
                return;
            }
            d.a.h0.a.r1.d.e().x().K(15);
            d.t0(false);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.i2.i.l();
        }
    }

    /* loaded from: classes2.dex */
    public class f extends n {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f42369e;

            public a(f fVar, d dVar) {
                this.f42369e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f42369e.I0();
            }
        }

        public f(d dVar) {
        }

        @Override // d.a.h0.a.e0.w.d.n
        public void b(d dVar) {
            if (d.u) {
                d.a.h0.a.q1.b.f.d e2 = d.a.h0.a.q1.b.f.d.e(d.I(), d.a.h0.a.h.aiapps_preloadCoreRuntime_end);
                e2.k(1);
                e2.C();
                Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
            }
            k0.T(new a(this, dVar));
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "onReady: successfully.");
            }
            d.a.h0.a.n1.c.e.a.C().K(14);
        }

        @NonNull
        public String toString() {
            return "prepare " + super.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class g extends n {
        public g(d dVar) {
        }

        @Override // d.a.h0.a.e0.w.d.n
        public void b(d dVar) {
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "onReady: retry successfully.");
            }
        }

        @NonNull
        public String toString() {
            return HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + super.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class h extends n {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f42370e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.g f42371f;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f42373e;

            public a(d dVar) {
                this.f42373e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f42373e.j) {
                    return;
                }
                d.a.h0.a.j1.i.o("startup").A(new UbcFlowEvent("na_pre_load_ok"));
                d.a.h0.a.y1.a.d().i("na_pre_load_ok");
                d.a.h0.a.j1.i.g("preload", "startup");
                h hVar = h.this;
                d.this.e0(this.f42373e, hVar.f42370e, hVar.f42371f);
                d.a.h0.a.j1.i.i(h.this.f42370e, false);
            }
        }

        public h(d.a.h0.a.y0.e.b bVar, d.g gVar) {
            this.f42370e = bVar;
            this.f42371f = gVar;
        }

        @Override // d.a.h0.a.e0.w.d.n
        public void b(d dVar) {
            k0.X(new a(dVar));
        }

        @NonNull
        public String toString() {
            return "startFirstPage " + super.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f42375e;

        public i(d.a.h0.a.r1.e eVar) {
            this.f42375e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean equals;
            if (d.this.f42364h == null) {
                return;
            }
            if (a.C0651a.b()) {
                equals = true;
            } else {
                String d2 = d.a.h0.a.t1.k.p0.c.d(d.a.h0.a.z0.f.V(), this.f42375e.L(), this.f42375e.D());
                SwanAppConfigData D = this.f42375e.D();
                equals = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT.equals(D != null ? D.g(d2) : null);
            }
            if (!equals || this.f42375e.D() == null) {
                return;
            }
            d.a.h0.a.e0.r.b.c().b(d.A ? d.this.f42361e.l(this.f42375e.getAppId()).j() : d.this.f42362f, d.this.f42364h, this.f42375e.L(), this.f42375e.D(), null);
        }
    }

    /* loaded from: classes2.dex */
    public class j implements d.a.h0.a.e0.k.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f42377a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.u) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.j);
                }
                if (d.this.j) {
                    if (d.u) {
                        Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                        return;
                    }
                    return;
                }
                d.this.K0();
                d.this.J0();
                if (d.this.f42357a == null) {
                    PreloadState unused = d.y = PreloadState.LOAD_FAILED;
                    d.this.X();
                    return;
                }
                j jVar = j.this;
                d.this.n0(jVar.f42377a);
                d.this.s0();
            }
        }

        public j(boolean z) {
            this.f42377a = z;
        }

        @Override // d.a.h0.a.e0.k.d.b
        public void a() {
            if (d.u) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
            }
            d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_blink_init_ok"));
            k0.X(new a());
        }
    }

    /* loaded from: classes2.dex */
    public class k implements d.a.h0.a.e0.o.f.c {
        public k() {
        }

        @Override // d.a.h0.a.e0.o.f.c
        public void onReady() {
            d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_ok"));
            synchronized (d.this.n) {
                d.this.f42363g = true;
                d.this.G();
                d.this.f0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l extends d.a.h0.a.e0.g {
        public l() {
        }

        @Override // d.a.h0.a.e0.g
        public void a(String str) {
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
            d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_ok"));
            synchronized (d.this.n) {
                d.this.f42363g = true;
                d.this.G();
                d.this.f0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class m {

        /* renamed from: a  reason: collision with root package name */
        public static int f42382a = -1;

        public static int a() {
            d.a.h0.a.w0.a.N().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: 6000");
            }
            return 6000;
        }

        public static int b() {
            d.a.h0.a.w0.a.N().getSwitch("swan_core_runtime_low_end_timeout", 8000);
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs 8000");
            }
            return 8000;
        }

        public static int c() {
            if (f42382a < 0) {
                d.a.h0.a.w0.a.N().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
                f42382a = 1;
            }
            return f42382a;
        }

        public static int d() {
            d.a.h0.a.w0.a.N().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: 8000");
            }
            return 8000;
        }

        public static boolean e() {
            boolean z = c() > 0;
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class n implements d.a.h0.a.i2.u0.b<d> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d dVar) {
            b(dVar);
        }

        public abstract void b(d dVar);
    }

    /* loaded from: classes2.dex */
    public static class o {

        /* renamed from: a  reason: collision with root package name */
        public static final int f42383a = m.b();

        /* renamed from: b  reason: collision with root package name */
        public static final int f42384b = m.a();

        /* renamed from: c  reason: collision with root package name */
        public static int f42385c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f42386d = 0;

        /* renamed from: e  reason: collision with root package name */
        public static final Runnable f42387e = new a();

        /* renamed from: f  reason: collision with root package name */
        public static final Runnable f42388f = new b();

        /* loaded from: classes2.dex */
        public static class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (d.v.a0()) {
                    if (d.u) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (o.f42386d >= 1) {
                    if (d.u) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!d.a.h0.a.r1.d.g().hasCallbacks(o.f42388f)) {
                        d.a.h0.a.r1.d.g().postDelayed(o.f42388f, m.d());
                    }
                    if (d.u) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.v0();
                    d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(49L);
                    aVar.e("start retry");
                    o.h(aVar);
                }
            }
        }

        /* loaded from: classes2.dex */
        public static class b implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (d.v.a0()) {
                    if (d.u) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (o.f42386d >= 1) {
                    d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(49L);
                    aVar.e("retry timeout");
                    o.h(aVar);
                    d.a.h0.a.y0.d.a.d(d.I(), aVar, 0, d.a.h0.a.r1.d.e().getAppId());
                    d.a.h0.a.i2.e.i(d.a.h0.a.r1.d.e().v());
                }
            }
        }

        public static CopyOnWriteArrayList<n> e() {
            return new CopyOnWriteArrayList<>(d.v.f42360d);
        }

        public static int f(Boolean bool) {
            return bool.booleanValue() ? f42383a : f42384b;
        }

        public static void g() {
            f42386d++;
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + f42386d);
            }
        }

        public static void h(d.a.h0.a.f2.a aVar) {
            int j;
            d.a.h0.a.r1.e p = d.a.h0.a.r1.d.e().p();
            if (p != null && (j = p.j()) == 0) {
                d.a.h0.a.z1.k.d dVar = new d.a.h0.a.z1.k.d();
                dVar.p(aVar);
                dVar.r(p.L());
                dVar.q(d.a.h0.a.z1.h.n(j));
                dVar.m(d.a.h0.a.r1.e.T());
                d.a.h0.a.z1.h.H(dVar);
            }
        }

        public static void i() {
            f42386d = f42385c;
        }
    }

    /* loaded from: classes2.dex */
    public static class p {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f42389a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f42390b;

        /* renamed from: c  reason: collision with root package name */
        public static boolean f42391c;

        static {
            boolean c2 = ProcessUtils.isMainProcess() ? d.a.h0.a.j1.m.c.c() : d.a.h0.a.w0.a.N().p();
            f42389a = c2;
            boolean D = c2 ? true : d.a.h0.a.w0.a.N().D();
            f42390b = D;
            f42391c = D;
        }

        public static String a() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static String b(int i2) {
            return i2 == 1 ? "V8" : i2 == 0 ? WebView.LOGTAG : "AB";
        }

        public static boolean c() {
            if (d.u) {
                String a2 = a();
                char c2 = 65535;
                int hashCode = a2.hashCode();
                if (hashCode != -1406842887) {
                    if (hashCode != 2081) {
                        if (hashCode == 2722 && a2.equals("V8")) {
                            c2 = 0;
                        }
                    } else if (a2.equals("AB")) {
                        c2 = 2;
                    }
                } else if (a2.equals(WebView.LOGTAG)) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    return true;
                }
                if (c2 == 1) {
                    return false;
                }
            }
            return f42391c;
        }

        public static boolean d() {
            String a2 = a();
            if (a2.equals("V8")) {
                return true;
            }
            if (a2.equals("AB")) {
                if (f42389a) {
                    return true;
                }
                return d.a.h0.a.w0.a.N().D();
            }
            return false;
        }

        public static void e(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static void f() {
            f42391c = f42390b;
        }

        public static void g(Intent intent) {
            if (intent == null || !intent.hasExtra("bundle_key_v8_ab")) {
                return;
            }
            f42390b = intent.getBooleanExtra("bundle_key_v8_ab", f42390b);
        }
    }

    public d() {
        d.a.h0.a.z0.i.e(this);
        this.l = new HashMap<>();
        this.r = new d.a.h0.a.p.d.j.b();
        this.s = d.a.h0.a.p.d.j.c.a().b().a();
        if (A) {
            this.f42361e = new d.a.h0.a.e0.o.f.e();
        }
    }

    public static Context I() {
        return AppRuntime.getAppContext();
    }

    public static d L() {
        if (v == null) {
            synchronized (d.class) {
                if (v == null) {
                    v = new d();
                }
            }
        }
        return v;
    }

    public static int k0() {
        return l0().statsCode(z);
    }

    public static PreloadState l0() {
        return y;
    }

    public static synchronized void t0(boolean z2) {
        synchronized (d.class) {
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "release");
            u0(z2, false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: d.a.h0.a.e0.w.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void u0(boolean z2, boolean z3) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (d.class) {
            if (u) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (v == null) {
                return;
            }
            y = PreloadState.UNKNOWN;
            v.j = true;
            v.q = null;
            x = false;
            if (z3) {
                o.g();
                copyOnWriteArrayList = o.e();
            } else {
                copyOnWriteArrayList = null;
            }
            if (v.f42359c != null) {
                v.s.a(v.f42359c);
            }
            d.a.h0.a.t.c.n.e.e();
            d.a.h0.a.b2.c.a.c();
            y0();
            d.a.h0.a.z0.i.f(v);
            v = null;
            d.a.h0.a.e0.r.b.c().d();
            z = z2;
            L().j0(null, copyOnWriteArrayList);
        }
    }

    public static synchronized void v0() {
        synchronized (d.class) {
            u0(false, true);
        }
    }

    public static synchronized void w0() {
        synchronized (d.class) {
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!d.a.h0.a.j1.m.c.g()) {
                d.a.h0.a.r1.d.e().x().K(15);
                t0(false);
                return;
            }
            if (u) {
                Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
            }
            if (v != null && !v.Z()) {
                if (v.q == null) {
                    v.q = new C0656d();
                }
                v.o0(v.q);
                return;
            }
            d.a.h0.a.r1.d.e().x().K(15);
            t0(false);
        }
    }

    public static void x0() {
        if (A) {
            if (v.f42361e != null) {
                v.f42361e.k();
            }
        } else if (v.f42362f != null) {
            if (v.f42362f instanceof d.a.h0.a.e0.o.e) {
                v.f42362f.destroy();
            }
            v.f42362f = null;
        }
    }

    public static void y0() {
        if (v.l != null) {
            for (d.a.h0.a.p.d.d dVar : ((HashMap) v.l.clone()).values()) {
                if (dVar != null) {
                    dVar.destroy();
                }
            }
        }
        x0();
        if (v.f42364h != null) {
            v.f42364h = null;
        }
    }

    public void A0(d.a.h0.a.k0.b.a aVar) {
        d.a.h0.a.e0.k.a g2;
        if (aVar != null) {
            synchronized (this.n) {
                if (!this.f42363g) {
                    if (u) {
                        Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.f43106a)));
                    }
                    this.m.add(aVar);
                    return;
                }
                if (A) {
                    if (!this.f42361e.f()) {
                        this.f42361e.e(aVar);
                        return;
                    } else if (this.f42361e.c() == null) {
                        return;
                    } else {
                        g2 = this.f42361e.c().j().g();
                    }
                } else {
                    d.a.h0.a.e0.o.a aVar2 = this.f42362f;
                    if (aVar2 == null) {
                        return;
                    }
                    g2 = aVar2.g();
                }
                if (u) {
                    Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.f43106a);
                }
                d.a.h0.a.k0.a.b(g2, aVar);
                return;
            }
        }
        throw new IllegalArgumentException("message must be non-null.");
    }

    public void B0(String str, d.a.h0.a.k0.b.a aVar) {
        if (d.a.h0.a.e0.o.f.a.a(str)) {
            A0(aVar);
            return;
        }
        d.a.h0.a.p.d.d dVar = this.l.get(str);
        if (dVar == null) {
            if (u) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        d.a.h0.a.k0.a.b(dVar.s(), aVar);
    }

    public void C0(@NonNull d.a.h0.a.r1.e eVar) {
        k0.X(new i(eVar));
    }

    public final String D(String str, boolean z2) {
        String str2 = z2 ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            d.a.h0.a.e0.e.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public void D0(ExtensionCore extensionCore) {
        if (extensionCore != null && extensionCore.a()) {
            if (u) {
                Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.f42358b);
            }
            this.f42358b = extensionCore;
            if (u) {
                Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.f42358b);
            }
        } else if (u) {
            StringBuilder sb = new StringBuilder();
            sb.append("setExtensionCore extensionCore is invalid: ");
            Object obj = extensionCore;
            if (extensionCore == null) {
                obj = " null";
            }
            sb.append(obj);
            Log.w("SwanAppCoreRuntime", sb.toString());
        }
    }

    public final boolean E() {
        if (d.a.h0.a.c0.d.d.e.d() || d.a.h0.a.w0.a.l().Q()) {
            return false;
        }
        if (d.a.h0.g.i0.f.d.e() != null) {
            boolean exists = new File(d.a.h0.g.i0.f.d.e()).exists();
            if (u) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return p.c() && new File(P()).exists();
    }

    public void E0(SwanCoreVersion swanCoreVersion) {
        if (swanCoreVersion != null && swanCoreVersion.a()) {
            if (u) {
                Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.f42357a);
            }
            this.f42357a = swanCoreVersion;
            if (u) {
                Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.f42357a);
            }
        } else if (u) {
            Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("setSwanCoreVersion failed.")));
            Log.e("SwanAppCoreRuntime", "setSwanCoreVersion swanCoreVersion is invalid: " + swanCoreVersion);
        }
    }

    public void F(boolean z2) {
        if (m.e()) {
            if (!d.a.h0.a.r1.d.e().p().i0()) {
                boolean hasCallbacks = d.a.h0.a.r1.d.g().hasCallbacks(o.f42387e);
                if (!z2 && hasCallbacks) {
                    if (u) {
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isReuse " + z2 + ", return.");
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isRunning " + hasCallbacks + ", return.");
                    }
                } else if (a0()) {
                    if (u) {
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                    }
                } else {
                    J(new b());
                }
            } else if (u) {
                Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: is game frame, return.");
            }
        }
    }

    public void F0(d.a.h0.a.y0.e.b bVar, d.g gVar) {
        if (u) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.f42357a);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.f0());
        }
        H0(bVar);
        G0(bVar);
        d.a.h0.a.j1.i.n().A(new UbcFlowEvent("na_pre_load_check"));
        d.a.h0.a.y1.a.d().i("na_pre_load_check");
        o0(new h(bVar, gVar));
    }

    public final void G() {
        if (this.m.isEmpty()) {
            return;
        }
        Iterator<d.a.h0.a.k0.b.a> it = this.m.iterator();
        while (it.hasNext()) {
            d.a.h0.a.k0.b.a next = it.next();
            if (u) {
                Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.f43106a);
            }
            A0(next);
        }
        this.m.clear();
    }

    public void G0(d.a.h0.a.y0.e.b bVar) {
        ExtensionCore extensionCore = this.f42358b;
        if (extensionCore != null) {
            bVar.x0(extensionCore);
        } else {
            this.f42358b = bVar.N();
        }
    }

    public final void H(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", y.statsCode(z));
        d.a.h0.a.r1.d.e().u(str, bundle);
    }

    public void H0(d.a.h0.a.y0.e.b bVar) {
        SwanCoreVersion swanCoreVersion = this.f42357a;
        if (swanCoreVersion != null) {
            bVar.Q0(swanCoreVersion);
        } else {
            this.f42357a = bVar.f0();
        }
    }

    public final void I0() {
        if (this.t) {
            if (u) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        boolean z2 = true;
        this.t = true;
        d.a.h0.a.r1.d e2 = d.a.h0.a.r1.d.e();
        z2 = (e2 == null || !e2.z()) ? false : false;
        boolean B = d.a.h0.a.w0.a.N().B();
        if (!z2 && B) {
            if (u) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            d.a.h0.a.e0.v.b.h(I());
        } else if (u) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z2 + ", ab: " + B);
        }
    }

    public final void J(d.a.h0.a.i2.u0.b<Boolean> bVar) {
        d.a.h0.a.i2.p.k(new c(this, bVar), "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    public final void J0() {
        ExtensionCore extensionCore = this.f42358b;
        if (extensionCore == null || !extensionCore.a()) {
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            D0(d.a.h0.a.l0.b.b(0));
        }
    }

    @Nullable
    public ExtensionCore K() {
        return this.f42358b;
    }

    public final void K0() {
        SwanCoreVersion swanCoreVersion = this.f42357a;
        if (swanCoreVersion == null || !swanCoreVersion.a()) {
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            E0(d.a.h0.a.b2.b.e(0));
        }
    }

    public void L0(boolean z2) {
        this.k = z2;
    }

    @NonNull
    public HashMap<String, d.a.h0.a.p.d.d> M() {
        return this.l;
    }

    public d.a.h0.a.e0.o.a N() {
        if (A) {
            if (this.f42361e.f()) {
                return this.f42361e.c().j();
            }
            return null;
        }
        return this.f42362f;
    }

    public String O() {
        String str;
        K0();
        if (d0()) {
            str = P();
        } else {
            str = this.f42357a.swanCorePath + File.separator + "master/master.html";
        }
        if (d.a.h0.a.e0.e.d()) {
            D(str, false);
        } else if (d.a.h0.a.c0.d.d.e.d()) {
            d.a.h0.a.c0.d.d.d.k();
            d.a.h0.a.c0.d.d.d.g().h("loadmaster");
            return d.a.h0.a.c0.d.d.e.a();
        } else {
            d.a.h0.a.e0.e.g(str);
        }
        return i0.u(str);
    }

    public String P() {
        if (TextUtils.isEmpty(S())) {
            return "";
        }
        return S() + "runtime/index.js";
    }

    public String Q() {
        return this.o;
    }

    @Nullable
    public String R() {
        K0();
        if (this.f42357a == null) {
            return null;
        }
        String str = this.f42357a.swanCorePath + File.separator + "slaves/slaves.html";
        if (d.a.h0.a.e0.e.d()) {
            D(str, true);
        } else if (d.a.h0.a.c0.d.d.e.d()) {
            return d.a.h0.a.c0.d.d.e.b();
        } else {
            d.a.h0.a.e0.e.g(str);
        }
        return i0.u(str);
    }

    public String S() {
        if (this.f42357a == null) {
            return "";
        }
        return this.f42357a.swanCorePath + File.separator;
    }

    public SwanCoreVersion T() {
        return this.f42357a;
    }

    public d.a.h0.a.p.d.d U(String str) {
        if (this.l.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.l.get(str);
    }

    public a1 V() {
        return this.r;
    }

    @Nullable
    public String W() {
        Y();
        return this.p;
    }

    public final void X() {
        synchronized (this.n) {
            this.f42363g = false;
            if (A) {
                this.f42361e.k();
            } else {
                this.f42362f = null;
            }
        }
        this.f42365i = false;
        this.f42364h = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", d.a.h0.a.b2.f.a.d(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", d0());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion e2 = d.a.h0.a.b2.b.e(0);
            jSONObject.put("swan app core", e2 == null ? StringUtil.NULL_STRING : Long.valueOf(e2.swanCoreVersion));
            SwanCoreVersion e3 = d.a.h0.a.b2.b.e(1);
            jSONObject.put("swan game core", e3 == null ? StringUtil.NULL_STRING : Long.valueOf(e3.swanCoreVersion));
        } catch (JSONException e4) {
            if (u) {
                e4.printStackTrace();
            }
        }
        c.b bVar = new c.b(10001);
        bVar.h(d.a.h0.a.r1.e.h() == null ? "null appKey" : d.a.h0.a.r1.e.h().B());
        bVar.i(jSONObject.toString());
        bVar.l();
    }

    public final void Y() {
        if (TextUtils.isEmpty(this.p)) {
            d.a.h0.a.p.d.b bVar = this.f42364h;
            this.p = bVar != null ? bVar.b() : "";
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "initWebViewUa ua: " + this.p);
        }
    }

    public boolean Z() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.f42363g;
        }
        return z2;
    }

    @Override // d.a.h0.a.z0.h
    public void a(d.a.h0.a.p.d.d dVar) {
    }

    public boolean a0() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.f42363g && this.f42365i;
        }
        return z2;
    }

    @Override // d.a.h0.a.z0.h
    public void b(d.a.h0.a.p.d.d dVar) {
        String c2 = dVar.c();
        this.l.remove(c2);
        if (dVar instanceof d.a.h0.a.p.d.b) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", c2);
            A0(new d.a.h0.a.k0.b.c(hashMap));
            d.a.h0.a.c0.c.g("SwanApp", "onUnload");
        }
        d.a.h0.a.q1.b.d.a.a();
    }

    public boolean b0() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.f42365i;
        }
        return z2;
    }

    @Override // d.a.h0.a.z0.h
    public void c(d.a.h0.a.p.d.d dVar) {
    }

    public boolean c0() {
        return this.k;
    }

    @Override // d.a.h0.a.z0.h
    public void d(d.a.h0.a.p.d.d dVar) {
        this.l.put(dVar.c(), dVar);
    }

    public boolean d0() {
        if (A) {
            return this.f42361e.h();
        }
        return this.f42362f instanceof d.a.h0.a.e0.o.e;
    }

    public final void e0(d dVar, d.a.h0.a.y0.e.b bVar, d.g gVar) {
        d.a.h0.a.e0.o.a aVar;
        d.a.h0.a.p.d.b bVar2;
        if (A) {
            d.a.h0.a.e0.o.f.e eVar = dVar.f42361e;
            aVar = eVar.g() ? eVar.l(bVar.G()).j() : null;
        } else {
            aVar = dVar.f42362f;
        }
        if (aVar != null && (bVar2 = dVar.f42364h) != null) {
            d.a.h0.a.t1.k.p0.c.f(aVar, bVar2, bVar, gVar);
            dVar.f42364h = null;
        } else if (u) {
            StringBuilder sb = new StringBuilder();
            sb.append("startFirstPage mMasterManager ");
            sb.append(dVar.f42362f != null);
            sb.append(" startFirstPage mSlaveManager ");
            sb.append(dVar.f42364h != null);
            Log.e("SwanAppCoreRuntime", sb.toString());
        }
    }

    public final void f0() {
        if (!this.f42360d.isEmpty() && a0()) {
            y = PreloadState.LOADED;
            o.i();
            H("event_preload_finish");
            d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_end"));
            for (n nVar : this.f42360d) {
                if (nVar != null) {
                    if (u) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + nVar.toString());
                    }
                    nVar.onCallback(this);
                }
            }
            this.f42360d.clear();
        }
    }

    public void g0(boolean z2) {
        boolean d2 = A ? this.f42361e.d() : this.f42362f != null;
        if (z2 && !this.f42363g && d2) {
            if (u) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.n) {
                this.f42363g = true;
                G();
                f0();
            }
        } else if (z2 || this.f42364h == null || this.f42365i) {
        } else {
            if (u) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.f42365i = true;
            f0();
        }
    }

    public void h0(String str, PrefetchEvent.c cVar) {
        if (A && d.a.h0.a.e0.q.e.a.d()) {
            this.f42361e.i(str, cVar);
            if (u) {
                String q = d.a.h0.a.b2.b.q(this.f42357a.swanCoreVersion);
                Log.i("SwanAppCoreRuntime", "swan-core version - " + q);
                Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
            }
        }
    }

    public void i0(Intent intent) {
        j0(intent, null);
    }

    public final void j0(Intent intent, CopyOnWriteArrayList<n> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (a0()) {
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        boolean z2 = true;
        x = true;
        d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        H("event_preload_start");
        if (intent == null) {
            swanCoreVersion = d.a.h0.a.b2.b.e(0);
            extensionCore = d.a.h0.a.l0.b.b(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            d.a.h0.a.w0.a.f().g(intent.getIntExtra("bundle_key_preload_switch", w));
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
        }
        if (swanCoreVersion == null) {
            d.a.h0.a.c0.c.i("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            H("event_preload_error");
            d.a.h0.a.c0.c.i("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        E0(swanCoreVersion);
        if (extensionCore == null) {
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        D0(extensionCore);
        p.f();
        d.a.h0.a.i2.p.k(new e(this), "prepare ab description");
        if (E()) {
            d.a.h0.g.i0.f.f i2 = d.a.h0.g.i0.f.d.i();
            if (!i2.b() && !i2.a()) {
                H("event_preload_error");
                return;
            }
        }
        if (!((copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? false : false)) {
            p0();
        } else {
            q0(copyOnWriteArrayList);
        }
        d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    public d.a.h0.a.e0.o.a m0(boolean z2, d.a.h0.a.e0.g gVar) {
        d.a.h0.a.e0.o.a f2 = this.r.f(I(), z2 ? 1 : 0);
        d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_created"));
        f2.loadUrl(O());
        f2.d(gVar);
        return f2;
    }

    public final void n0(boolean z2) {
        synchronized (this.n) {
            boolean d2 = A ? this.f42361e.d() : this.f42362f != null;
            if (!this.f42363g && !d2) {
                d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "prepareMaster start.");
                d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_start"));
                if (A) {
                    this.f42361e.j(z2, new k());
                    return;
                }
                this.f42362f = this.r.f(I(), z2 ? 1 : 0);
                d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_created"));
                this.f42362f.loadUrl(O());
                this.f42362f.d(new l());
            }
        }
    }

    public void o0(n nVar) {
        if (nVar != null && !this.f42360d.contains(nVar)) {
            this.f42360d.add(nVar);
        }
        boolean a0 = a0();
        d.a.h0.a.j1.i.n().y("preload", a0 ? "1" : "0");
        d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "prepareRuntime preload = " + a0);
        if (a0) {
            f0();
            return;
        }
        y = PreloadState.LOADING;
        d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_start"));
        K0();
        boolean E = E();
        if (E) {
            d.a.h0.g.i0.f.f i2 = d.a.h0.g.i0.f.d.i();
            if (!i2.b() && i2.a()) {
                E = false;
            }
        }
        d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "useV8Master:" + E);
        if (E) {
            n0(true);
        }
        if (this.f42359c == null) {
            this.f42359c = new j(E);
            if (u) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.s.b(this.f42359c);
        }
    }

    public final void p0() {
        o0(new f(this));
    }

    public final void q0(CopyOnWriteArrayList<n> copyOnWriteArrayList) {
        if (this.f42360d == null) {
            this.f42360d = new CopyOnWriteArrayList();
        }
        Iterator<n> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (!this.f42360d.contains(next)) {
                this.f42360d.add(next);
            }
        }
        o0(new g(this));
    }

    public d.a.h0.a.p.d.b r0(Context context, d.a.h0.a.e0.g gVar) {
        try {
            d.a.h0.a.p.d.b g2 = this.r.g(context);
            d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_slave_created"));
            String R = R();
            if (R != null) {
                d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
                if (O != null && !TextUtils.isEmpty(O.B())) {
                    R = Uri.parse(R).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, d.a.h0.a.u0.d.n(O.B(), O.W(), false, null, null).getAbsolutePath()).toString();
                    if (!R.endsWith(File.separator)) {
                        R = R + File.separator;
                    }
                }
                g2.loadUrl(R);
            }
            d.a.h0.a.c0.c.h("SwanAppCoreRuntime", "prepareSlave loadUrl " + R);
            g2.d(gVar);
            return g2;
        } catch (NullPointerException e2) {
            d.a.h0.a.e0.e.e(context);
            throw e2;
        }
    }

    public final void s0() {
        if (this.f42365i || this.f42364h != null) {
            return;
        }
        if (u) {
            Log.d("SwanAppCoreRuntime", "prepareSlave start.");
        }
        d.a.h0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_slave_start"));
        this.f42364h = r0(I(), new a());
        Y();
    }

    public final void z0(int i2) {
        Handler g2 = d.a.h0.a.r1.d.g();
        if (g2.hasCallbacks(o.f42387e)) {
            g2.removeCallbacks(o.f42387e);
        }
        g2.postDelayed(o.f42387e, i2);
    }
}
