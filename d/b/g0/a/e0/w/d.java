package d.b.g0.a.e0.w;

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
import d.b.g0.a.e0.r.a;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.p.c.a1;
import d.b.g0.a.u0.d;
import d.b.g0.a.z1.c;
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
/* loaded from: classes3.dex */
public final class d implements d.b.g0.a.z0.h {
    public static volatile d v;

    /* renamed from: a  reason: collision with root package name */
    public SwanCoreVersion f44327a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public ExtensionCore f44328b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.e0.k.d.b f44329c;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.e0.o.f.e f44331e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.e0.o.a f44332f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44333g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.a.p.d.b f44334h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final HashMap<String, d.b.g0.a.p.d.d> l;
    public String p;
    public n q;
    public a1 r;
    public d.b.g0.a.p.d.h s;
    public static final boolean u = d.b.g0.a.k.f45050a;
    public static int w = 10150;
    public static boolean x = false;
    public static PreloadState y = PreloadState.UNKNOWN;
    public static boolean z = false;
    public static final boolean A = d.b.g0.a.e0.q.e.a.c();

    /* renamed from: d  reason: collision with root package name */
    public List<n> f44330d = new CopyOnWriteArrayList();
    public LinkedList<d.b.g0.a.k0.b.a> m = new LinkedList<>();
    public final Object n = new Object();
    public final String o = UUID.randomUUID().toString();
    public volatile boolean t = false;

    /* loaded from: classes3.dex */
    public class a extends d.b.g0.a.e0.g {
        public a() {
        }

        @Override // d.b.g0.a.e0.g
        public void a(String str) {
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
            d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_slave_ok"));
            d.this.i = true;
            d.this.f0();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.i2.u0.b<Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            d.this.z0(o.f(bool));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f44337e;

        public c(d dVar, d.b.g0.a.i2.u0.b bVar) {
            this.f44337e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean a2 = d.b.g0.a.w0.a.Y().a();
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + a2);
            }
            d.b.g0.a.i2.u0.b bVar = this.f44337e;
            if (bVar != null) {
                bVar.onCallback(Boolean.FALSE);
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.w.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0684d extends n {
        @Override // d.b.g0.a.e0.w.d.n
        public void b(d dVar) {
            boolean z = !TextUtils.isEmpty(d.b.g0.a.r1.d.e().getAppId());
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
            if (z) {
                return;
            }
            d.b.g0.a.r1.d.e().q().K(15);
            d.t0(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.i2.i.l();
        }
    }

    /* loaded from: classes3.dex */
    public class f extends n {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f44338e;

            public a(f fVar, d dVar) {
                this.f44338e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f44338e.I0();
            }
        }

        public f(d dVar) {
        }

        @Override // d.b.g0.a.e0.w.d.n
        public void b(d dVar) {
            if (d.u) {
                d.b.g0.a.q1.b.f.d e2 = d.b.g0.a.q1.b.f.d.e(d.I(), d.b.g0.a.h.aiapps_preloadCoreRuntime_end);
                e2.k(1);
                e2.C();
                Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
            }
            k0.T(new a(this, dVar));
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "onReady: successfully.");
            }
            d.b.g0.a.n1.c.e.a.C().K(14);
        }

        @NonNull
        public String toString() {
            return "prepare " + super.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends n {
        public g(d dVar) {
        }

        @Override // d.b.g0.a.e0.w.d.n
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

    /* loaded from: classes3.dex */
    public class h extends n {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f44339e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.g f44340f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f44342e;

            public a(d dVar) {
                this.f44342e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f44342e.j) {
                    return;
                }
                d.b.g0.a.j1.i.o("startup").A(new UbcFlowEvent("na_pre_load_ok"));
                d.b.g0.a.y1.a.d().i("na_pre_load_ok");
                d.b.g0.a.j1.i.g("preload", "startup");
                h hVar = h.this;
                d.this.e0(this.f44342e, hVar.f44339e, hVar.f44340f);
                d.b.g0.a.j1.i.i(h.this.f44339e, false);
            }
        }

        public h(d.b.g0.a.y0.e.b bVar, d.g gVar) {
            this.f44339e = bVar;
            this.f44340f = gVar;
        }

        @Override // d.b.g0.a.e0.w.d.n
        public void b(d dVar) {
            k0.X(new a(dVar));
        }

        @NonNull
        public String toString() {
            return "startFirstPage " + super.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f44344e;

        public i(d.b.g0.a.r1.e eVar) {
            this.f44344e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean equals;
            if (d.this.f44334h == null) {
                return;
            }
            if (a.C0679a.b()) {
                equals = true;
            } else {
                String d2 = d.b.g0.a.t1.k.p0.c.d(d.b.g0.a.z0.f.V(), this.f44344e.L(), this.f44344e.D());
                SwanAppConfigData D = this.f44344e.D();
                equals = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT.equals(D != null ? D.g(d2) : null);
            }
            if (!equals || this.f44344e.D() == null) {
                return;
            }
            d.b.g0.a.e0.r.b.c().b(d.A ? d.this.f44331e.l(this.f44344e.getAppId()).j() : d.this.f44332f, d.this.f44334h, this.f44344e.L(), this.f44344e.D(), null);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements d.b.g0.a.e0.k.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f44346a;

        /* loaded from: classes3.dex */
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
                if (d.this.f44327a == null) {
                    PreloadState unused = d.y = PreloadState.LOAD_FAILED;
                    d.this.X();
                    return;
                }
                j jVar = j.this;
                d.this.n0(jVar.f44346a);
                d.this.s0();
            }
        }

        public j(boolean z) {
            this.f44346a = z;
        }

        @Override // d.b.g0.a.e0.k.d.b
        public void a() {
            if (d.u) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
            }
            d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_blink_init_ok"));
            k0.X(new a());
        }
    }

    /* loaded from: classes3.dex */
    public class k implements d.b.g0.a.e0.o.f.c {
        public k() {
        }

        @Override // d.b.g0.a.e0.o.f.c
        public void onReady() {
            d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_ok"));
            synchronized (d.this.n) {
                d.this.f44333g = true;
                d.this.G();
                d.this.f0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends d.b.g0.a.e0.g {
        public l() {
        }

        @Override // d.b.g0.a.e0.g
        public void a(String str) {
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
            d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_ok"));
            synchronized (d.this.n) {
                d.this.f44333g = true;
                d.this.G();
                d.this.f0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class m {

        /* renamed from: a  reason: collision with root package name */
        public static int f44351a = -1;

        public static int a() {
            d.b.g0.a.w0.a.N().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: 6000");
            }
            return 6000;
        }

        public static int b() {
            d.b.g0.a.w0.a.N().getSwitch("swan_core_runtime_low_end_timeout", 8000);
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs 8000");
            }
            return 8000;
        }

        public static int c() {
            if (f44351a < 0) {
                d.b.g0.a.w0.a.N().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
                f44351a = 1;
            }
            return f44351a;
        }

        public static int d() {
            d.b.g0.a.w0.a.N().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
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

    /* loaded from: classes3.dex */
    public static abstract class n implements d.b.g0.a.i2.u0.b<d> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d dVar) {
            b(dVar);
        }

        public abstract void b(d dVar);
    }

    /* loaded from: classes3.dex */
    public static class o {

        /* renamed from: a  reason: collision with root package name */
        public static final int f44352a = m.b();

        /* renamed from: b  reason: collision with root package name */
        public static final int f44353b = m.a();

        /* renamed from: c  reason: collision with root package name */
        public static int f44354c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f44355d = 0;

        /* renamed from: e  reason: collision with root package name */
        public static final Runnable f44356e = new a();

        /* renamed from: f  reason: collision with root package name */
        public static final Runnable f44357f = new b();

        /* loaded from: classes3.dex */
        public static class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (d.v.a0()) {
                    if (d.u) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (o.f44355d >= 1) {
                    if (d.u) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!d.b.g0.a.r1.d.g().hasCallbacks(o.f44357f)) {
                        d.b.g0.a.r1.d.g().postDelayed(o.f44357f, m.d());
                    }
                    if (d.u) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.v0();
                    d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(49L);
                    aVar.e("start retry");
                    o.h(aVar);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (d.v.a0()) {
                    if (d.u) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (o.f44355d >= 1) {
                    d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(49L);
                    aVar.e("retry timeout");
                    o.h(aVar);
                    d.b.g0.a.y0.d.a.d(d.I(), aVar, 0, d.b.g0.a.r1.d.e().getAppId());
                    d.b.g0.a.i2.e.i(d.b.g0.a.r1.d.e().n());
                }
            }
        }

        public static CopyOnWriteArrayList<n> e() {
            return new CopyOnWriteArrayList<>(d.v.f44330d);
        }

        public static int f(Boolean bool) {
            return bool.booleanValue() ? f44352a : f44353b;
        }

        public static void g() {
            f44355d++;
            if (d.u) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + f44355d);
            }
        }

        public static void h(d.b.g0.a.f2.a aVar) {
            int h2;
            d.b.g0.a.r1.e s = d.b.g0.a.r1.d.e().s();
            if (s != null && (h2 = s.h()) == 0) {
                d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
                dVar.p(aVar);
                dVar.r(s.L());
                dVar.q(d.b.g0.a.z1.h.n(h2));
                dVar.m(d.b.g0.a.r1.e.T());
                d.b.g0.a.z1.h.H(dVar);
            }
        }

        public static void i() {
            f44355d = f44354c;
        }
    }

    /* loaded from: classes3.dex */
    public static class p {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f44358a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f44359b;

        /* renamed from: c  reason: collision with root package name */
        public static boolean f44360c;

        static {
            boolean c2 = ProcessUtils.isMainProcess() ? d.b.g0.a.j1.m.c.c() : d.b.g0.a.w0.a.N().A();
            f44358a = c2;
            boolean q = c2 ? true : d.b.g0.a.w0.a.N().q();
            f44359b = q;
            f44360c = q;
        }

        public static String a() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static String b(int i) {
            return i == 1 ? "V8" : i == 0 ? WebView.LOGTAG : "AB";
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
            return f44360c;
        }

        public static boolean d() {
            String a2 = a();
            if (a2.equals("V8")) {
                return true;
            }
            if (a2.equals("AB")) {
                if (f44358a) {
                    return true;
                }
                return d.b.g0.a.w0.a.N().q();
            }
            return false;
        }

        public static void e(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static void f() {
            f44360c = f44359b;
        }

        public static void g(Intent intent) {
            if (intent == null || !intent.hasExtra("bundle_key_v8_ab")) {
                return;
            }
            f44359b = intent.getBooleanExtra("bundle_key_v8_ab", f44359b);
        }
    }

    public d() {
        d.b.g0.a.z0.i.e(this);
        this.l = new HashMap<>();
        this.r = new d.b.g0.a.p.d.j.b();
        this.s = d.b.g0.a.p.d.j.c.a().b().b();
        if (A) {
            this.f44331e = new d.b.g0.a.e0.o.f.e();
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
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "release");
            u0(z2, false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: d.b.g0.a.e0.w.d */
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
            if (v.f44329c != null) {
                v.s.a(v.f44329c);
            }
            d.b.g0.a.t.c.n.e.e();
            d.b.g0.a.b2.c.a.c();
            y0();
            d.b.g0.a.z0.i.f(v);
            v = null;
            d.b.g0.a.e0.r.b.c().d();
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
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!d.b.g0.a.j1.m.c.g()) {
                d.b.g0.a.r1.d.e().q().K(15);
                t0(false);
                return;
            }
            if (u) {
                Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
            }
            if (v != null && !v.Z()) {
                if (v.q == null) {
                    v.q = new C0684d();
                }
                v.o0(v.q);
                return;
            }
            d.b.g0.a.r1.d.e().q().K(15);
            t0(false);
        }
    }

    public static void x0() {
        if (A) {
            if (v.f44331e != null) {
                v.f44331e.k();
            }
        } else if (v.f44332f != null) {
            if (v.f44332f instanceof d.b.g0.a.e0.o.e) {
                v.f44332f.destroy();
            }
            v.f44332f = null;
        }
    }

    public static void y0() {
        if (v.l != null) {
            for (d.b.g0.a.p.d.d dVar : ((HashMap) v.l.clone()).values()) {
                if (dVar != null) {
                    dVar.destroy();
                }
            }
        }
        x0();
        if (v.f44334h != null) {
            v.f44334h = null;
        }
    }

    public void A0(d.b.g0.a.k0.b.a aVar) {
        d.b.g0.a.e0.k.a g2;
        if (aVar != null) {
            synchronized (this.n) {
                if (!this.f44333g) {
                    if (u) {
                        Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.f45055a)));
                    }
                    this.m.add(aVar);
                    return;
                }
                if (A) {
                    if (!this.f44331e.f()) {
                        this.f44331e.e(aVar);
                        return;
                    } else if (this.f44331e.c() == null) {
                        return;
                    } else {
                        g2 = this.f44331e.c().j().g();
                    }
                } else {
                    d.b.g0.a.e0.o.a aVar2 = this.f44332f;
                    if (aVar2 == null) {
                        return;
                    }
                    g2 = aVar2.g();
                }
                if (u) {
                    Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.f45055a);
                }
                d.b.g0.a.k0.a.b(g2, aVar);
                return;
            }
        }
        throw new IllegalArgumentException("message must be non-null.");
    }

    public void B0(String str, d.b.g0.a.k0.b.a aVar) {
        if (d.b.g0.a.e0.o.f.a.a(str)) {
            A0(aVar);
            return;
        }
        d.b.g0.a.p.d.d dVar = this.l.get(str);
        if (dVar == null) {
            if (u) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        d.b.g0.a.k0.a.b(dVar.getWebView(), aVar);
    }

    public void C0(@NonNull d.b.g0.a.r1.e eVar) {
        k0.X(new i(eVar));
    }

    public final String D(String str, boolean z2) {
        String str2 = z2 ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            d.b.g0.a.e0.e.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public void D0(ExtensionCore extensionCore) {
        if (extensionCore != null && extensionCore.a()) {
            if (u) {
                Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.f44328b);
            }
            this.f44328b = extensionCore;
            if (u) {
                Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.f44328b);
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
        if (d.b.g0.a.c0.d.d.e.d() || d.b.g0.a.w0.a.l().O()) {
            return false;
        }
        if (d.b.g0.g.i0.f.d.e() != null) {
            boolean exists = new File(d.b.g0.g.i0.f.d.e()).exists();
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
                Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.f44327a);
            }
            this.f44327a = swanCoreVersion;
            if (u) {
                Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.f44327a);
            }
        } else if (u) {
            Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("setSwanCoreVersion failed.")));
            Log.e("SwanAppCoreRuntime", "setSwanCoreVersion swanCoreVersion is invalid: " + swanCoreVersion);
        }
    }

    public void F(boolean z2) {
        if (m.e()) {
            if (!d.b.g0.a.r1.d.e().s().i0()) {
                boolean hasCallbacks = d.b.g0.a.r1.d.g().hasCallbacks(o.f44356e);
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

    public void F0(d.b.g0.a.y0.e.b bVar, d.g gVar) {
        if (u) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.f44327a);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.f0());
        }
        H0(bVar);
        G0(bVar);
        d.b.g0.a.j1.i.n().A(new UbcFlowEvent("na_pre_load_check"));
        d.b.g0.a.y1.a.d().i("na_pre_load_check");
        o0(new h(bVar, gVar));
    }

    public final void G() {
        if (this.m.isEmpty()) {
            return;
        }
        Iterator<d.b.g0.a.k0.b.a> it = this.m.iterator();
        while (it.hasNext()) {
            d.b.g0.a.k0.b.a next = it.next();
            if (u) {
                Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.f45055a);
            }
            A0(next);
        }
        this.m.clear();
    }

    public void G0(d.b.g0.a.y0.e.b bVar) {
        ExtensionCore extensionCore = this.f44328b;
        if (extensionCore != null) {
            bVar.x0(extensionCore);
        } else {
            this.f44328b = bVar.N();
        }
    }

    public final void H(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", y.statsCode(z));
        d.b.g0.a.r1.d.e().l(str, bundle);
    }

    public void H0(d.b.g0.a.y0.e.b bVar) {
        SwanCoreVersion swanCoreVersion = this.f44327a;
        if (swanCoreVersion != null) {
            bVar.Q0(swanCoreVersion);
        } else {
            this.f44327a = bVar.f0();
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
        d.b.g0.a.r1.d e2 = d.b.g0.a.r1.d.e();
        z2 = (e2 == null || !e2.x()) ? false : false;
        boolean n2 = d.b.g0.a.w0.a.N().n();
        if (!z2 && n2) {
            if (u) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            d.b.g0.a.e0.v.b.h(I());
        } else if (u) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z2 + ", ab: " + n2);
        }
    }

    public final void J(d.b.g0.a.i2.u0.b<Boolean> bVar) {
        d.b.g0.a.i2.p.k(new c(this, bVar), "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    public final void J0() {
        ExtensionCore extensionCore = this.f44328b;
        if (extensionCore == null || !extensionCore.a()) {
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            D0(d.b.g0.a.l0.b.b(0));
        }
    }

    @Nullable
    public ExtensionCore K() {
        return this.f44328b;
    }

    public final void K0() {
        SwanCoreVersion swanCoreVersion = this.f44327a;
        if (swanCoreVersion == null || !swanCoreVersion.a()) {
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            E0(d.b.g0.a.b2.b.e(0));
        }
    }

    public void L0(boolean z2) {
        this.k = z2;
    }

    @NonNull
    public HashMap<String, d.b.g0.a.p.d.d> M() {
        return this.l;
    }

    public d.b.g0.a.e0.o.a N() {
        if (A) {
            if (this.f44331e.f()) {
                return this.f44331e.c().j();
            }
            return null;
        }
        return this.f44332f;
    }

    public String O() {
        String str;
        K0();
        if (d0()) {
            str = P();
        } else {
            str = this.f44327a.swanCorePath + File.separator + "master/master.html";
        }
        if (d.b.g0.a.e0.e.d()) {
            D(str, false);
        } else if (d.b.g0.a.c0.d.d.e.d()) {
            d.b.g0.a.c0.d.d.d.k();
            d.b.g0.a.c0.d.d.d.g().h("loadmaster");
            return d.b.g0.a.c0.d.d.e.a();
        } else {
            d.b.g0.a.e0.e.g(str);
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
        if (this.f44327a == null) {
            return null;
        }
        String str = this.f44327a.swanCorePath + File.separator + "slaves/slaves.html";
        if (d.b.g0.a.e0.e.d()) {
            D(str, true);
        } else if (d.b.g0.a.c0.d.d.e.d()) {
            return d.b.g0.a.c0.d.d.e.b();
        } else {
            d.b.g0.a.e0.e.g(str);
        }
        return i0.u(str);
    }

    public String S() {
        if (this.f44327a == null) {
            return "";
        }
        return this.f44327a.swanCorePath + File.separator;
    }

    public SwanCoreVersion T() {
        return this.f44327a;
    }

    public d.b.g0.a.p.d.d U(String str) {
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
            this.f44333g = false;
            if (A) {
                this.f44331e.k();
            } else {
                this.f44332f = null;
            }
        }
        this.i = false;
        this.f44334h = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", d.b.g0.a.b2.f.a.d(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", d0());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion e2 = d.b.g0.a.b2.b.e(0);
            jSONObject.put("swan app core", e2 == null ? StringUtil.NULL_STRING : Long.valueOf(e2.swanCoreVersion));
            SwanCoreVersion e3 = d.b.g0.a.b2.b.e(1);
            jSONObject.put("swan game core", e3 == null ? StringUtil.NULL_STRING : Long.valueOf(e3.swanCoreVersion));
        } catch (JSONException e4) {
            if (u) {
                e4.printStackTrace();
            }
        }
        c.b bVar = new c.b(10001);
        bVar.h(d.b.g0.a.r1.e.y() == null ? "null appKey" : d.b.g0.a.r1.e.y().B());
        bVar.i(jSONObject.toString());
        bVar.l();
    }

    public final void Y() {
        if (TextUtils.isEmpty(this.p)) {
            d.b.g0.a.p.d.b bVar = this.f44334h;
            this.p = bVar != null ? bVar.b() : "";
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "initWebViewUa ua: " + this.p);
        }
    }

    public boolean Z() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.f44333g;
        }
        return z2;
    }

    @Override // d.b.g0.a.z0.h
    public void a(d.b.g0.a.p.d.d dVar) {
        String c2 = dVar.c();
        this.l.remove(c2);
        if (dVar instanceof d.b.g0.a.p.d.b) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", c2);
            A0(new d.b.g0.a.k0.b.c(hashMap));
            d.b.g0.a.c0.c.g("SwanApp", "onUnload");
        }
        d.b.g0.a.q1.b.d.a.a();
    }

    public boolean a0() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.f44333g && this.i;
        }
        return z2;
    }

    @Override // d.b.g0.a.z0.h
    public void b(d.b.g0.a.p.d.d dVar) {
    }

    public boolean b0() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.i;
        }
        return z2;
    }

    @Override // d.b.g0.a.z0.h
    public void c(d.b.g0.a.p.d.d dVar) {
        this.l.put(dVar.c(), dVar);
    }

    public boolean c0() {
        return this.k;
    }

    @Override // d.b.g0.a.z0.h
    public void d(d.b.g0.a.p.d.d dVar) {
    }

    public boolean d0() {
        if (A) {
            return this.f44331e.h();
        }
        return this.f44332f instanceof d.b.g0.a.e0.o.e;
    }

    public final void e0(d dVar, d.b.g0.a.y0.e.b bVar, d.g gVar) {
        d.b.g0.a.e0.o.a aVar;
        d.b.g0.a.p.d.b bVar2;
        if (A) {
            d.b.g0.a.e0.o.f.e eVar = dVar.f44331e;
            aVar = eVar.g() ? eVar.l(bVar.G()).j() : null;
        } else {
            aVar = dVar.f44332f;
        }
        if (aVar != null && (bVar2 = dVar.f44334h) != null) {
            d.b.g0.a.t1.k.p0.c.f(aVar, bVar2, bVar, gVar);
            dVar.f44334h = null;
        } else if (u) {
            StringBuilder sb = new StringBuilder();
            sb.append("startFirstPage mMasterManager ");
            sb.append(dVar.f44332f != null);
            sb.append(" startFirstPage mSlaveManager ");
            sb.append(dVar.f44334h != null);
            Log.e("SwanAppCoreRuntime", sb.toString());
        }
    }

    public final void f0() {
        if (!this.f44330d.isEmpty() && a0()) {
            y = PreloadState.LOADED;
            o.i();
            H("event_preload_finish");
            d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_end"));
            for (n nVar : this.f44330d) {
                if (nVar != null) {
                    if (u) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + nVar.toString());
                    }
                    nVar.onCallback(this);
                }
            }
            this.f44330d.clear();
        }
    }

    public void g0(boolean z2) {
        boolean d2 = A ? this.f44331e.d() : this.f44332f != null;
        if (z2 && !this.f44333g && d2) {
            if (u) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.n) {
                this.f44333g = true;
                G();
                f0();
            }
        } else if (z2 || this.f44334h == null || this.i) {
        } else {
            if (u) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.i = true;
            f0();
        }
    }

    public void h0(String str, PrefetchEvent.c cVar) {
        if (A && d.b.g0.a.e0.q.e.a.d()) {
            this.f44331e.i(str, cVar);
            if (u) {
                String q = d.b.g0.a.b2.b.q(this.f44327a.swanCoreVersion);
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
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        boolean z2 = true;
        x = true;
        d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        H("event_preload_start");
        if (intent == null) {
            swanCoreVersion = d.b.g0.a.b2.b.e(0);
            extensionCore = d.b.g0.a.l0.b.b(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            d.b.g0.a.w0.a.f().g(intent.getIntExtra("bundle_key_preload_switch", w));
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
        }
        if (swanCoreVersion == null) {
            d.b.g0.a.c0.c.i("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            H("event_preload_error");
            d.b.g0.a.c0.c.i("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        E0(swanCoreVersion);
        if (extensionCore == null) {
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        D0(extensionCore);
        p.f();
        d.b.g0.a.i2.p.k(new e(this), "prepare ab description");
        if (E()) {
            d.b.g0.g.i0.f.f i2 = d.b.g0.g.i0.f.d.i();
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
        d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    public d.b.g0.a.e0.o.a m0(boolean z2, d.b.g0.a.e0.g gVar) {
        d.b.g0.a.e0.o.a f2 = this.r.f(I(), z2 ? 1 : 0);
        d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_created"));
        f2.loadUrl(O());
        f2.e(gVar);
        return f2;
    }

    public final void n0(boolean z2) {
        synchronized (this.n) {
            boolean d2 = A ? this.f44331e.d() : this.f44332f != null;
            if (!this.f44333g && !d2) {
                d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "prepareMaster start.");
                d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_start"));
                if (A) {
                    this.f44331e.j(z2, new k());
                    return;
                }
                this.f44332f = this.r.f(I(), z2 ? 1 : 0);
                d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_master_created"));
                this.f44332f.loadUrl(O());
                this.f44332f.e(new l());
            }
        }
    }

    public void o0(n nVar) {
        if (nVar != null && !this.f44330d.contains(nVar)) {
            this.f44330d.add(nVar);
        }
        boolean a0 = a0();
        d.b.g0.a.j1.i.n().y("preload", a0 ? "1" : "0");
        d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "prepareRuntime preload = " + a0);
        if (a0) {
            f0();
            return;
        }
        y = PreloadState.LOADING;
        d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_start"));
        K0();
        boolean E = E();
        if (E) {
            d.b.g0.g.i0.f.f i2 = d.b.g0.g.i0.f.d.i();
            if (!i2.b() && i2.a()) {
                E = false;
            }
        }
        d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "useV8Master:" + E);
        if (E) {
            n0(true);
        }
        if (this.f44329c == null) {
            this.f44329c = new j(E);
            if (u) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.s.b(this.f44329c);
        }
    }

    public final void p0() {
        o0(new f(this));
    }

    public final void q0(CopyOnWriteArrayList<n> copyOnWriteArrayList) {
        if (this.f44330d == null) {
            this.f44330d = new CopyOnWriteArrayList();
        }
        Iterator<n> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (!this.f44330d.contains(next)) {
                this.f44330d.add(next);
            }
        }
        o0(new g(this));
    }

    public d.b.g0.a.p.d.b r0(Context context, d.b.g0.a.e0.g gVar) {
        try {
            d.b.g0.a.p.d.b g2 = this.r.g(context);
            d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_slave_created"));
            String R = R();
            if (R != null) {
                d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
                if (O != null && !TextUtils.isEmpty(O.B())) {
                    R = Uri.parse(R).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, d.b.g0.a.u0.d.n(O.B(), O.W(), false, null, null).getAbsolutePath()).toString();
                    if (!R.endsWith(File.separator)) {
                        R = R + File.separator;
                    }
                }
                g2.loadUrl(R);
            }
            d.b.g0.a.c0.c.h("SwanAppCoreRuntime", "prepareSlave loadUrl " + R);
            g2.e(gVar);
            return g2;
        } catch (NullPointerException e2) {
            d.b.g0.a.e0.e.e(context);
            throw e2;
        }
    }

    public final void s0() {
        if (this.i || this.f44334h != null) {
            return;
        }
        if (u) {
            Log.d("SwanAppCoreRuntime", "prepareSlave start.");
        }
        d.b.g0.a.j1.i.o("preload").A(new UbcFlowEvent("na_pre_load_slave_start"));
        this.f44334h = r0(I(), new a());
        Y();
    }

    public final void z0(int i2) {
        Handler g2 = d.b.g0.a.r1.d.g();
        if (g2.hasCallbacks(o.f44356e)) {
            g2.removeCallbacks(o.f44356e);
        }
        g2.postDelayed(o.f44356e, i2);
    }
}
