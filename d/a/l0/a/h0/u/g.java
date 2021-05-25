package d.a.l0.a.h0.u;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.webkit.sdk.WebView;
import d.a.l0.a.a1.e;
import d.a.l0.a.h0.o.i.a;
import d.a.l0.a.h0.p.a;
import d.a.l0.a.j2.c;
import d.a.l0.a.p.d.l1;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class g implements d.a.l0.a.g1.h {
    public static volatile g w;

    /* renamed from: a  reason: collision with root package name */
    public SwanCoreVersion f42627a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public ExtensionCore f42628b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.h0.f.d.b f42629c;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.h0.l.g.b<d.a.l0.a.h0.l.g.a> f42631e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.h0.l.a f42632f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42633g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.a.p.e.b f42634h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42635i;
    public boolean j;
    public boolean k;
    public final HashMap<String, d.a.l0.a.p.e.d> l;
    public String p;
    public q q;
    public l1 r;
    public d.a.l0.a.p.e.h s;
    public static final boolean v = d.a.l0.a.k.f43199a;
    public static int x = 10150;
    public static boolean y = false;
    public static PreloadState z = PreloadState.UNKNOWN;
    public static boolean A = false;
    public static final boolean B = d.a.l0.a.h0.o.e.a.f();
    public static int C = -1;

    /* renamed from: d  reason: collision with root package name */
    public List<q> f42630d = new CopyOnWriteArrayList();
    public LinkedList<d.a.l0.a.o0.d.a> m = new LinkedList<>();
    public final Object n = new Object();
    public final String o = UUID.randomUUID().toString();
    public volatile boolean t = false;
    public boolean u = false;

    /* loaded from: classes2.dex */
    public static class a extends q {

        /* renamed from: d.a.l0.a.h0.u.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0700a implements Runnable {
            public RunnableC0700a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.A0(false);
            }
        }

        @Override // d.a.l0.a.h0.u.g.q
        public void b(g gVar) {
            boolean z = !TextUtils.isEmpty(d.a.l0.a.a2.d.g().getAppId());
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
            if (z) {
                return;
            }
            d.a.l0.a.a2.d.g().z().M(15);
            q0.b0(new RunnableC0700a(this));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.l0.a.h0.l.g.d<d.a.l0.a.h0.l.g.a> {
        public b(g gVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.h0.l.g.d
        /* renamed from: b */
        public void a(boolean z, d.a.l0.a.h0.l.g.a aVar) {
            if (z) {
                d.a.l0.a.r1.h.p("startup").A("prefetch_env", "1");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.l0.a.h0.l.g.j {
        public c() {
        }

        @Override // d.a.l0.a.h0.l.g.j
        public void onReady() {
            d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_ok"));
            synchronized (g.this.n) {
                g.this.f42633g = true;
                g.this.I();
                g.this.l0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.l0.a.h0.b {
        public d() {
        }

        @Override // d.a.l0.a.h0.b
        public void a(String str) {
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
            d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_ok"));
            synchronized (g.this.n) {
                g.this.f42633g = true;
                g.this.I();
                g.this.l0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.a.l0.a.h0.b {
        public e() {
        }

        @Override // d.a.l0.a.h0.b
        public void a(String str) {
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
            d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_ok"));
            g.this.f42635i = true;
            g.this.l0();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a.l0.a.v2.e1.b<Boolean> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            g.this.G0(s.h(bool));
        }
    }

    /* renamed from: d.a.l0.a.h0.u.g$g  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0701g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f42640e;

        public RunnableC0701g(g gVar, d.a.l0.a.v2.e1.b bVar) {
            this.f42640e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean a2 = d.a.l0.a.c1.a.l0().a();
            if (g.v) {
                Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + a2);
            }
            d.a.l0.a.v2.e1.b bVar = this.f42640e;
            if (bVar != null) {
                bVar.onCallback(Boolean.FALSE);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
        public h(g gVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.v2.j.i();
        }
    }

    /* loaded from: classes2.dex */
    public class i extends q {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f42641e;

            public a(i iVar, g gVar) {
                this.f42641e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f42641e.P0();
            }
        }

        public i(g gVar) {
        }

        @Override // d.a.l0.a.h0.u.g.q
        public void b(g gVar) {
            if (g.v) {
                d.a.l0.q.d.b().e();
                d.a.l0.a.z1.b.f.e f2 = d.a.l0.a.z1.b.f.e.f(g.K(), d.a.l0.a.h.aiapps_preloadCoreRuntime_end);
                f2.l(1);
                f2.F();
                Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
            }
            q0.X(new a(this, gVar));
            if (g.v) {
                Log.i("SwanAppCoreRuntime", "onReady: successfully.");
            }
            d.a.l0.a.v1.c.e.a.E().M(14);
        }

        @NonNull
        public String toString() {
            return "prepare " + super.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class j extends q {
        public j(g gVar) {
        }

        @Override // d.a.l0.a.h0.u.g.q
        public void b(g gVar) {
            if (g.v) {
                Log.i("SwanAppCoreRuntime", "onReady: retry successfully.");
            }
        }

        @NonNull
        public String toString() {
            return HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + super.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class k extends q {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f42642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.g f42643f;

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f42645e;

            public a(g gVar) {
                this.f42645e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f42645e.j) {
                    return;
                }
                d.a.l0.a.r1.h.p("startup").C(new UbcFlowEvent("na_pre_load_ok"));
                d.a.l0.a.i2.a.d().i("na_pre_load_ok");
                d.a.l0.a.r1.h.h("preload", "startup");
                k kVar = k.this;
                g.this.j0(this.f42645e, kVar.f42642e, kVar.f42643f);
                d.a.l0.a.r1.h.j(k.this.f42642e, false);
            }
        }

        public k(d.a.l0.a.f1.e.b bVar, e.g gVar) {
            this.f42642e = bVar;
            this.f42643f = gVar;
        }

        @Override // d.a.l0.a.h0.u.g.q
        public void b(g gVar) {
            q0.b0(new a(gVar));
        }

        @NonNull
        public String toString() {
            return "startFirstPage " + super.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f42647e;

        public l(d.a.l0.a.a2.e eVar) {
            this.f42647e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (g.this.f42634h == null) {
                d.a.l0.a.h0.u.b.c(11);
                return;
            }
            if (a.C0694a.b()) {
                z = true;
            } else {
                String c2 = d.a.l0.a.c2.f.p0.c.c(d.a.l0.a.g1.f.V(), this.f42647e.N(), this.f42647e.F());
                SwanAppConfigData F = this.f42647e.F();
                String g2 = F != null ? F.g(c2) : null;
                boolean equals = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT.equals(g2);
                int i2 = 0;
                if (g2 == null) {
                    i2 = 12;
                } else if (!equals) {
                    i2 = 13;
                }
                if (i2 != 0) {
                    d.a.l0.a.h0.u.b.c(i2);
                }
                z = equals;
            }
            if (z && this.f42647e.F() != null) {
                d.a.l0.a.h0.p.b.c().b(g.B ? ((d.a.l0.a.h0.l.g.a) g.this.f42631e.e(this.f42647e.L().f0())).i() : g.this.f42632f, g.this.f42634h, this.f42647e.N(), this.f42647e.F(), null, true);
            } else if (this.f42647e.F() == null) {
                d.a.l0.a.h0.u.b.c(15);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements Runnable {
        public m(g gVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow p = d.a.l0.a.r1.h.p("preload");
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "getMemoryInfo scene=preload_start_mem");
            p.A("preload_start_mem", d.a.l0.a.e0.g.d.b().c(g.C));
        }
    }

    /* loaded from: classes2.dex */
    public class n implements d.a.l0.a.h0.f.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f42649a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (g.v) {
                    Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + g.this.j);
                }
                if (g.this.j) {
                    if (g.v) {
                        Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                        return;
                    }
                    return;
                }
                g.this.R0();
                g.this.Q0();
                if (g.this.f42627a == null) {
                    PreloadState unused = g.z = PreloadState.LOAD_FAILED;
                    g.this.Z();
                    return;
                }
                n nVar = n.this;
                g.this.u0(nVar.f42649a);
                g.this.z0();
            }
        }

        public n(boolean z) {
            this.f42649a = z;
        }

        @Override // d.a.l0.a.h0.f.d.b
        public void a() {
            if (g.v) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
            }
            d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_blink_init_ok"));
            q0.b0(new a());
        }
    }

    /* loaded from: classes2.dex */
    public class o implements Runnable {
        public o(g gVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow p = d.a.l0.a.r1.h.p("preload");
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "getMemoryInfo scene=preload_end_mem");
            p.A("preload_end_mem", d.a.l0.a.e0.g.d.b().c(g.C));
        }
    }

    /* loaded from: classes2.dex */
    public static class p {

        /* renamed from: a  reason: collision with root package name */
        public static int f42652a = -1;

        public static int a() {
            d.a.l0.a.c1.a.Z().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (g.v) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: 6000");
            }
            return 6000;
        }

        public static int b() {
            d.a.l0.a.c1.a.Z().getSwitch("swan_core_runtime_low_end_timeout", 8000);
            if (g.v) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs 8000");
            }
            return 8000;
        }

        public static int c() {
            if (f42652a < 0) {
                d.a.l0.a.c1.a.Z().getSwitch("swan_core_runtime_delayed_retry_switch", 0);
                f42652a = 0;
            }
            return f42652a;
        }

        public static int d() {
            d.a.l0.a.c1.a.Z().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
            if (g.v) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: 8000");
            }
            return 8000;
        }

        public static boolean e() {
            boolean z = c() > 0;
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "isEnable: " + z);
            return z;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class q implements d.a.l0.a.v2.e1.b<g> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(g gVar) {
            b(gVar);
        }

        public abstract void b(g gVar);
    }

    /* loaded from: classes2.dex */
    public static class r extends Handler {
        public r(Looper looper) {
            super(looper);
        }

        public boolean a() {
            return hasMessages(1002);
        }

        public boolean b() {
            return hasMessages(1001);
        }

        public void c() {
            removeCallbacksAndMessages(null);
            removeCallbacks(s.f42658f);
            removeCallbacks(s.f42659g);
        }

        public void d(int i2) {
            sendEmptyMessageDelayed(1001, i2);
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 1001) {
                s.f42658f.run();
            } else if (i2 == 1002) {
                s.f42659g.run();
            }
        }

        public void e(int i2) {
            sendEmptyMessageDelayed(1002, i2);
        }
    }

    /* loaded from: classes2.dex */
    public static class s {

        /* renamed from: e  reason: collision with root package name */
        public static r f42657e;

        /* renamed from: a  reason: collision with root package name */
        public static final int f42653a = p.b();

        /* renamed from: b  reason: collision with root package name */
        public static final int f42654b = p.a();

        /* renamed from: c  reason: collision with root package name */
        public static int f42655c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f42656d = 0;

        /* renamed from: f  reason: collision with root package name */
        public static final Runnable f42658f = new a();

        /* renamed from: g  reason: collision with root package name */
        public static final Runnable f42659g = new b();

        /* loaded from: classes2.dex */
        public static class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (!g.w.c0()) {
                    boolean z = true;
                    if (s.f42656d < 1) {
                        if (!((s.f42657e == null || !s.f42657e.a()) ? false : false)) {
                            if (s.f42657e == null) {
                                r unused = s.f42657e = new r(d.a.l0.a.a2.d.g().getMainLooper());
                            }
                            s.f42657e.e(p.d());
                        }
                        d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "start retry runtime.");
                        g.C0();
                        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
                        aVar.j(5L);
                        aVar.h(49L);
                        aVar.e("start retry");
                        s.j(aVar);
                        return;
                    }
                    d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    return;
                }
                d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
            }
        }

        /* loaded from: classes2.dex */
        public static class b implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (!g.w.c0()) {
                    if (s.f42656d >= 1) {
                        d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "isMasterReady:" + g.w.b0() + ",isSlaveReady:" + g.w.d0());
                        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
                        aVar.j(5L);
                        aVar.h(49L);
                        aVar.e("retry timeout");
                        s.j(aVar);
                        if (d.a.l0.a.g1.g.a().b()) {
                            d.a.l0.a.f1.d.a.d(g.K(), aVar, 0, d.a.l0.a.a2.d.g().getAppId());
                            d.a.l0.a.j2.e.m(d.a.l0.a.a2.d.g().r().L(), 0, aVar);
                            d.a.l0.a.c1.a.g0().c(false);
                        }
                        d.a.l0.a.v2.f.j(d.a.l0.a.a2.d.g().x());
                        return;
                    }
                    return;
                }
                d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "Retry: successfully.");
            }
        }

        public static CopyOnWriteArrayList<q> g() {
            return new CopyOnWriteArrayList<>(g.w.f42630d);
        }

        public static int h(Boolean bool) {
            return bool.booleanValue() ? f42653a : f42654b;
        }

        public static void i() {
            f42656d++;
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + f42656d);
        }

        public static void j(d.a.l0.a.q2.a aVar) {
            int l;
            d.a.l0.a.a2.e r = d.a.l0.a.a2.d.g().r();
            if (r != null && (l = r.l()) == 0) {
                d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
                dVar.p(aVar);
                dVar.r(r.N());
                dVar.q(d.a.l0.a.j2.k.m(l));
                dVar.m(d.a.l0.a.a2.e.V());
                d.a.l0.a.j2.k.L(dVar);
            }
        }

        public static void k() {
            f42656d = f42655c;
        }
    }

    /* loaded from: classes2.dex */
    public static class t {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f42660a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f42661b;

        static {
            boolean A = d.a.l0.a.c1.a.Z().A();
            f42660a = A;
            f42661b = A;
        }

        public static String a() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static String b(int i2) {
            return i2 == 1 ? "V8" : i2 == 0 ? WebView.LOGTAG : "AB";
        }

        public static boolean c() {
            if (g.v) {
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
            return f42661b;
        }

        public static boolean d() {
            String a2 = a();
            if (a2.equals("V8")) {
                return true;
            }
            if (a2.equals("AB")) {
                return d.a.l0.a.c1.a.Z().A();
            }
            return false;
        }

        public static void e(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static void f() {
            f42661b = f42660a;
        }

        public static void g(Intent intent) {
            if (intent == null || !intent.hasExtra("bundle_key_v8_ab")) {
                return;
            }
            f42660a = intent.getBooleanExtra("bundle_key_v8_ab", f42660a);
        }
    }

    public g() {
        d.a.l0.a.g1.i.e(this);
        this.l = new HashMap<>();
        this.r = new d.a.l0.a.p.e.j.b();
        this.s = d.a.l0.a.p.e.j.c.a().b().a();
        if (B) {
            this.f42631e = new d.a.l0.a.h0.l.g.m();
        }
    }

    public static synchronized void A0(boolean z2) {
        synchronized (g.class) {
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "release");
            B0(z2, false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: d.a.l0.a.h0.u.g */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized void B0(boolean z2, boolean z3) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (g.class) {
            if (v) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (w == null) {
                return;
            }
            z = PreloadState.UNKNOWN;
            w.j = true;
            w.q = null;
            y = false;
            if (z3) {
                s.i();
                copyOnWriteArrayList = s.g();
            } else {
                copyOnWriteArrayList = null;
            }
            if (w.f42629c != null) {
                w.s.a(w.f42629c);
            }
            d.a.l0.a.u.e.p.g.e();
            d.a.l0.a.m2.c.a.c();
            F0();
            d.a.l0.a.g1.i.f(w);
            w = null;
            d.a.l0.a.h0.p.b.c().d();
            A = z2;
            N().q0(null, copyOnWriteArrayList);
        }
    }

    public static synchronized void C0() {
        synchronized (g.class) {
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "releaseAndRetry");
            B0(false, true);
        }
    }

    public static synchronized void D0() {
        synchronized (g.class) {
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (v) {
                Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
            }
            if (w != null && !w.b0()) {
                if (w.q == null) {
                    w.q = new a();
                }
                w.v0(w.q);
                return;
            }
            d.a.l0.a.a2.d.g().z().M(15);
            A0(false);
        }
    }

    public static void E0() {
        if (B) {
            if (w.f42631e != null) {
                w.f42631e.reset();
            }
        } else if (w.f42632f != null) {
            if (w.f42632f instanceof d.a.l0.a.h0.l.e) {
                w.f42632f.destroy();
            }
            w.f42632f = null;
        }
    }

    public static void F0() {
        if (w.l != null) {
            for (d.a.l0.a.p.e.d dVar : ((HashMap) w.l.clone()).values()) {
                if (dVar != null) {
                    dVar.destroy();
                }
            }
        }
        E0();
        if (w.f42634h != null) {
            w.f42634h = null;
        }
    }

    public static Context K() {
        return AppRuntime.getAppContext();
    }

    public static g N() {
        if (w == null) {
            synchronized (g.class) {
                if (w == null) {
                    w = new g();
                }
            }
        }
        return w;
    }

    public static int r0() {
        return s0().statsCode(A);
    }

    public static PreloadState s0() {
        return z;
    }

    public final String E(String str, boolean z2) {
        String str2 = z2 ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            d.a.l0.a.h0.a.b(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public final void F() {
        d.a.l0.a.h0.l.g.b<d.a.l0.a.h0.l.g.a> bVar = this.f42631e;
        if (bVar == null || z == PreloadState.LOADED) {
            return;
        }
        bVar.b(new b(this));
    }

    public final boolean G() {
        if (d.a.l0.a.e0.f.e.e.d() || d.a.l0.a.c1.a.n().K() || d.a.l0.a.n0.k.c.f43645d.w() || !i0()) {
            return false;
        }
        return t.c() && new File(R()).exists();
    }

    public final void G0(int i2) {
        d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "resetAndPostRunnable");
        if (s.f42657e == null) {
            r unused = s.f42657e = new r(d.a.l0.a.a2.d.g().getMainLooper());
        }
        s.f42657e.c();
        s.f42657e.d(i2);
    }

    public void H(boolean z2) {
        if (p.e()) {
            if (!d.a.l0.a.a2.d.g().r().m0()) {
                boolean z3 = s.f42657e != null && s.f42657e.b();
                if (!z2 && z3) {
                    if (v) {
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isReuse " + z2 + ", return.");
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isRunning " + z3 + ", return.");
                    }
                } else if (c0()) {
                    if (v) {
                        Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                    }
                } else {
                    L(new f());
                }
            } else if (v) {
                Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: is game frame, return.");
            }
        }
    }

    public void H0(d.a.l0.a.o0.d.a aVar) {
        d.a.l0.a.h0.f.a g2;
        if (aVar == null) {
            if (v) {
                throw new IllegalArgumentException("message must be non-null.");
            }
            return;
        }
        synchronized (this.n) {
            if (!this.f42633g) {
                if (v) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.f43905a)));
                }
                this.m.add(aVar);
                return;
            }
            if (B) {
                if (!this.f42631e.g()) {
                    this.f42631e.d(aVar);
                    return;
                } else if (this.f42631e.a() == 0) {
                    return;
                } else {
                    g2 = ((d.a.l0.a.h0.l.g.a) this.f42631e.a()).i().g();
                }
            } else {
                d.a.l0.a.h0.l.a aVar2 = this.f42632f;
                if (aVar2 == null) {
                    return;
                }
                g2 = aVar2.g();
            }
            if (v) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.f43905a);
            }
            d.a.l0.a.o0.a.a(g2, aVar);
        }
    }

    public final void I() {
        if (this.m.isEmpty()) {
            return;
        }
        Iterator<d.a.l0.a.o0.d.a> it = this.m.iterator();
        while (it.hasNext()) {
            d.a.l0.a.o0.d.a next = it.next();
            if (v) {
                Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.f43905a);
            }
            H0(next);
        }
        this.m.clear();
    }

    public void I0(String str, d.a.l0.a.o0.d.a aVar) {
        if (d.a.l0.a.h0.l.g.e.a(str)) {
            H0(aVar);
        } else if (d.a.l0.a.h0.k.a.a(str)) {
            d.a.l0.a.o0.a.a(d.a.l0.a.e0.f.d.f.k().l(), aVar);
        } else {
            d.a.l0.a.p.e.d dVar = this.l.get(str);
            if (dVar == null) {
                if (v) {
                    Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                    return;
                }
                return;
            }
            d.a.l0.a.o0.a.a(dVar.u(), aVar);
        }
    }

    public final void J(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", z.statsCode(A));
        d.a.l0.a.a2.d.g().w(str, bundle);
    }

    public void J0(@NonNull d.a.l0.a.a2.e eVar) {
        q0.b0(new l(eVar));
    }

    public void K0(ExtensionCore extensionCore) {
        if (extensionCore != null && extensionCore.a()) {
            if (v) {
                Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.f42628b);
            }
            this.f42628b = extensionCore;
            if (v) {
                Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.f42628b);
            }
        } else if (v) {
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

    public final void L(d.a.l0.a.v2.e1.b<Boolean> bVar) {
        d.a.l0.a.v2.q.j(new RunnableC0701g(this, bVar), "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    public void L0(SwanCoreVersion swanCoreVersion) {
        if (swanCoreVersion != null && swanCoreVersion.a()) {
            if (v) {
                Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.f42627a);
            }
            this.f42627a = swanCoreVersion;
            if (v) {
                Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.f42627a);
            }
        } else if (v) {
            Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("setSwanCoreVersion failed.")));
            Log.e("SwanAppCoreRuntime", "setSwanCoreVersion swanCoreVersion is invalid: " + swanCoreVersion);
        }
    }

    @Nullable
    public ExtensionCore M() {
        return this.f42628b;
    }

    public void M0(d.a.l0.a.f1.e.b bVar, e.g gVar) {
        if (v) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.f42627a);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.i0());
        }
        O0(bVar);
        N0(bVar);
        d.a.l0.a.r1.h.o().C(new UbcFlowEvent("na_pre_load_check"));
        d.a.l0.a.i2.a.d().i("na_pre_load_check");
        v0(new k(bVar, gVar));
    }

    public void N0(d.a.l0.a.f1.e.b bVar) {
        ExtensionCore extensionCore = this.f42628b;
        if (extensionCore != null) {
            bVar.B0(extensionCore);
        } else {
            this.f42628b = bVar.O();
        }
    }

    @NonNull
    public HashMap<String, d.a.l0.a.p.e.d> O() {
        return this.l;
    }

    public void O0(d.a.l0.a.f1.e.b bVar) {
        SwanCoreVersion swanCoreVersion = this.f42627a;
        if (swanCoreVersion != null) {
            bVar.X0(swanCoreVersion);
        } else {
            this.f42627a = bVar.i0();
        }
    }

    public d.a.l0.a.h0.l.a P() {
        if (B) {
            if (this.f42631e.g()) {
                return ((d.a.l0.a.h0.l.g.a) this.f42631e.a()).i();
            }
            return null;
        }
        return this.f42632f;
    }

    public final void P0() {
        if (this.t) {
            if (v) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        boolean z2 = true;
        this.t = true;
        d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
        z2 = (g2 == null || !g2.C()) ? false : false;
        boolean y2 = d.a.l0.a.c1.a.Z().y();
        if (!z2 && y2) {
            if (v) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            d.a.l0.a.h0.t.a.l(K());
        } else if (v) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z2 + ", ab: " + y2);
        }
    }

    public String Q() {
        String str;
        R0();
        if (h0()) {
            str = R();
        } else {
            str = this.f42627a.swanCorePath + File.separator + "master/master.html";
        }
        if (d.a.l0.a.h0.a.d()) {
            E(str, false);
        } else if (d.a.l0.a.e0.f.e.e.d()) {
            d.a.l0.a.e0.f.e.d.k();
            d.a.l0.a.e0.f.e.d.g().h("loadmaster");
            return d.a.l0.a.e0.f.e.e.a();
        } else {
            d.a.l0.a.h0.a.g(str);
        }
        return o0.w(str);
    }

    public final void Q0() {
        ExtensionCore extensionCore = this.f42628b;
        if (extensionCore == null || !extensionCore.a()) {
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            K0(d.a.l0.a.p0.b.c(0));
        }
    }

    public String R() {
        if (TextUtils.isEmpty(U())) {
            return "";
        }
        return U() + "runtime/index.js";
    }

    public final void R0() {
        SwanCoreVersion swanCoreVersion = this.f42627a;
        if (swanCoreVersion == null || !swanCoreVersion.a()) {
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid:" + this.f42627a)));
            L0(d.a.l0.a.m2.b.g(0));
        }
    }

    public String S() {
        return this.o;
    }

    public void S0(boolean z2) {
        this.k = z2;
    }

    @Nullable
    public String T() {
        R0();
        if (this.f42627a == null) {
            return null;
        }
        String str = this.f42627a.swanCorePath + File.separator + "slaves/slaves.html";
        if (d.a.l0.a.h0.a.d()) {
            E(str, true);
        } else if (d.a.l0.a.e0.f.e.e.d()) {
            return d.a.l0.a.e0.f.e.e.b();
        } else {
            d.a.l0.a.h0.a.g(str);
        }
        return o0.w(str);
    }

    public String U() {
        if (this.f42627a == null) {
            return "";
        }
        return this.f42627a.swanCorePath + File.separator;
    }

    public SwanCoreVersion V() {
        return this.f42627a;
    }

    public d.a.l0.a.p.e.d W(String str) {
        if (this.l.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.l.get(str);
    }

    public l1 X() {
        return this.r;
    }

    @Nullable
    public String Y() {
        a0();
        return this.p;
    }

    public final void Z() {
        synchronized (this.n) {
            this.f42633g = false;
            if (B) {
                this.f42631e.reset();
            } else {
                this.f42632f = null;
            }
        }
        this.f42635i = false;
        this.f42634h = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", d.a.l0.a.m2.f.a.e(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", h0());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion g2 = d.a.l0.a.m2.b.g(0);
            jSONObject.put("swan app core", g2 == null ? StringUtil.NULL_STRING : Long.valueOf(g2.swanCoreVersionCode));
            SwanCoreVersion g3 = d.a.l0.a.m2.b.g(1);
            jSONObject.put("swan game core", g3 == null ? StringUtil.NULL_STRING : Long.valueOf(g3.swanCoreVersionCode));
        } catch (JSONException e2) {
            if (v) {
                e2.printStackTrace();
            }
        }
        c.b bVar = new c.b(10001);
        bVar.h(d.a.l0.a.a2.e.i() == null ? "null appKey" : d.a.l0.a.a2.e.i().D());
        bVar.i(jSONObject.toString());
        bVar.m();
    }

    @Override // d.a.l0.a.g1.h
    public void a(d.a.l0.a.p.e.d dVar) {
    }

    public final void a0() {
        if (TextUtils.isEmpty(this.p)) {
            d.a.l0.a.p.e.b bVar = this.f42634h;
            this.p = bVar != null ? bVar.a() : "";
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "initWebViewUa ua: " + this.p);
        }
    }

    @Override // d.a.l0.a.g1.h
    public void b(d.a.l0.a.p.e.d dVar) {
        String b2 = dVar.b();
        this.l.remove(b2);
        if (dVar instanceof d.a.l0.a.p.e.b) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, b2);
            H0(new d.a.l0.a.o0.d.c(hashMap));
            d.a.l0.a.e0.d.g("SwanApp", "onUnload");
        }
        d.a.l0.a.z1.b.d.a.a();
    }

    public boolean b0() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.f42633g;
        }
        return z2;
    }

    @Override // d.a.l0.a.g1.h
    public void c(d.a.l0.a.p.e.d dVar) {
    }

    public boolean c0() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.f42633g && this.f42635i;
        }
        return z2;
    }

    @Override // d.a.l0.a.g1.h
    public void d(d.a.l0.a.p.e.d dVar) {
        this.l.put(dVar.b(), dVar);
    }

    public boolean d0() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.f42635i;
        }
        return z2;
    }

    public final boolean e0() {
        long currentTimeMillis = v ? System.currentTimeMillis() : 0L;
        SwanCoreVersion swanCoreVersion = this.f42627a;
        boolean z2 = swanCoreVersion != null && swanCoreVersion.a();
        ExtensionCore extensionCore = this.f42628b;
        if (extensionCore != null && extensionCore.extensionCoreVersionCode != 0) {
            z2 &= extensionCore.a();
        }
        if (v) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanAppCoreRuntime", "isSwanAvailable cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return z2;
    }

    public boolean f0() {
        return this.k;
    }

    public boolean g0() {
        return this.u;
    }

    public boolean h0() {
        if (B) {
            return this.f42631e.i();
        }
        return this.f42632f instanceof d.a.l0.a.h0.l.e;
    }

    public boolean i0() {
        if (d.a.l0.a.c1.a.n0().d() || d.a.l0.a.h2.d.a() == null) {
            return true;
        }
        boolean exists = new File(d.a.l0.a.h2.d.a()).exists();
        if (v) {
            Log.d("V8LoadChecker", "is v8 load success: " + exists);
        }
        return exists;
    }

    public final void j0(g gVar, d.a.l0.a.f1.e.b bVar, e.g gVar2) {
        d.a.l0.a.h0.l.a aVar;
        d.a.l0.a.p.e.b bVar2;
        if (B) {
            d.a.l0.a.h0.l.g.b<d.a.l0.a.h0.l.g.a> bVar3 = gVar.f42631e;
            aVar = bVar3.h() ? ((d.a.l0.a.h0.l.g.a) bVar3.e(bVar.f0())).i() : null;
        } else {
            aVar = gVar.f42632f;
        }
        if (aVar != null && (bVar2 = gVar.f42634h) != null) {
            d.a.l0.a.c2.f.p0.c.e(aVar, bVar2, bVar, gVar2);
            gVar.f42634h = null;
        } else if (v) {
            StringBuilder sb = new StringBuilder();
            sb.append("startFirstPage mMasterManager ");
            sb.append(gVar.f42632f != null);
            sb.append(" startFirstPage mSlaveManager ");
            sb.append(gVar.f42634h != null);
            Log.e("SwanAppCoreRuntime", sb.toString());
        }
    }

    public final void k0() {
        if (this.f42630d.isEmpty()) {
            return;
        }
        F();
        z = PreloadState.LOADED;
        s.k();
        J("event_preload_finish");
        d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_end"));
        d.a.l0.a.h0.l.g.n.a.i().q();
        for (q qVar : this.f42630d) {
            if (qVar != null) {
                if (v) {
                    Log.i("SwanAppCoreRuntime", "onReady result: " + qVar.toString());
                }
                qVar.onCallback(this);
            }
        }
        this.f42630d.clear();
    }

    public final void l0() {
        if (!this.f42630d.isEmpty() && c0()) {
            k0();
            if (d.a.l0.a.a2.d.g().r().c0()) {
                return;
            }
            d.a.l0.a.v2.q.j(new o(this), "SwanMemory");
        }
    }

    public void m0(boolean z2) {
        boolean f2 = B ? this.f42631e.f() : this.f42632f != null;
        if (z2 && !this.f42633g && f2) {
            if (v) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.n) {
                this.f42633g = true;
                I();
                l0();
            }
        } else if (z2 || this.f42634h == null || this.f42635i) {
        } else {
            if (v) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.f42635i = true;
            l0();
        }
    }

    public void n0(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
        if (B) {
            if (pMSAppInfo != null && TextUtils.equals(prefetchEvent.appId, pMSAppInfo.appId)) {
                if (c0() && e0()) {
                    d.a.l0.a.p.e.b bVar = this.f42634h;
                    if (bVar != null) {
                        prefetchEvent.isT7Available = bVar.L();
                    } else {
                        prefetchEvent.isT7Available = f0();
                    }
                    PrefetchEvent.c c2 = PrefetchEvent.c(prefetchEvent, pMSAppInfo);
                    String str = prefetchEvent.pageUrl;
                    Map<String, String> h2 = c2.h();
                    String str2 = h2 != null ? h2.get("pageRoutePath") : null;
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                    if (!d.a.l0.a.a1.e.C(prefetchEvent.appPath, str)) {
                        if (v) {
                            Log.w("SwanAppCoreRuntime", "page path - " + str + " not exit");
                            return;
                        }
                        return;
                    }
                    if (c2.i()) {
                        d.a.l0.a.e0.c.d();
                        d.a.l0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch");
                    }
                    this.f42631e.c(c2, pMSAppInfo);
                    o0(prefetchEvent);
                    if (v) {
                        String str3 = this.f42627a.swanCoreVersionName;
                        Log.i("SwanAppCoreRuntime", "swan-core version - " + str3);
                        Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
                    }
                }
            } else if (v) {
                Log.w("SwanAppCoreRuntime", "prefetch appId not equals current app info's appId");
            }
        }
    }

    public final void o0(PrefetchEvent prefetchEvent) {
        if (d.a.l0.a.h0.o.e.a.l()) {
            d.a.l0.a.p.e.b bVar = this.f42634h;
            if (bVar != null && d0()) {
                d.a.l0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch slave");
                long j2 = 0;
                if (v) {
                    j2 = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prefetch slave start");
                }
                d.a.l0.a.a2.e r2 = d.a.l0.a.a2.d.g().r();
                if (r2 == null) {
                    return;
                }
                a.C0693a b2 = d.a.l0.a.h0.o.i.a.a(bVar, prefetchEvent, r2).b();
                I0(bVar.b(), b2);
                if (v) {
                    Log.d("SwanAppCoreRuntime", "prefetch slave end");
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d("SwanAppCoreRuntime", "prefetch slave cost - " + (currentTimeMillis - j2) + "ms");
                }
                d.a.l0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch slave finish:" + b2.toString());
            } else if (v) {
                Log.d("SwanAppCoreRuntime", "slave is not ready can not prefetch");
            }
        }
    }

    public void p0(Intent intent) {
        q0(intent, null);
    }

    public final void q0(Intent intent, CopyOnWriteArrayList<q> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        d.a.l0.a.r1.k.g.a.c().f();
        d.a.l0.a.r1.k.i.b.e().g();
        if (c0()) {
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        boolean z2 = true;
        y = true;
        d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        J("event_preload_start");
        if (intent == null) {
            swanCoreVersion = d.a.l0.a.m2.b.g(0);
            extensionCore = d.a.l0.a.p0.b.c(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            d.a.l0.a.c1.a.f().g(intent.getIntExtra("bundle_key_preload_switch", x));
            C = intent.getIntExtra("bundle_key_main_pid", C);
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
        }
        if (swanCoreVersion == null) {
            J("event_preload_error");
            d.a.l0.a.e0.d.i("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        L0(swanCoreVersion);
        if (extensionCore == null) {
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        K0(extensionCore);
        t.f();
        d.a.l0.a.v2.q.j(new h(this), "prepare ab description");
        if (G()) {
            d.a.l0.a.h2.f c2 = d.a.l0.a.h2.d.c();
            if (!c2.b() && !c2.a()) {
                J("event_preload_error");
                return;
            }
        }
        if (!((copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? false : false)) {
            w0();
        } else {
            x0(copyOnWriteArrayList);
        }
        d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    public d.a.l0.a.h0.l.a t0(boolean z2, d.a.l0.a.h0.b bVar) {
        d.a.l0.a.h0.l.a e2 = this.r.e(K(), z2 ? 1 : 0);
        d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_created"));
        e2.loadUrl(Q());
        e2.c(bVar);
        return e2;
    }

    public final void u0(boolean z2) {
        synchronized (this.n) {
            boolean f2 = B ? this.f42631e.f() : this.f42632f != null;
            if (!this.f42633g && !f2) {
                d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "prepareMaster start.");
                d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_start"));
                if (B) {
                    this.f42631e.j(z2, new c());
                    return;
                }
                this.f42632f = this.r.e(K(), z2 ? 1 : 0);
                d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_master_created"));
                this.f42632f.loadUrl(Q());
                this.f42632f.c(new d());
            }
        }
    }

    public void v0(q qVar) {
        d.a.l0.a.r1.k.g.a.c().f();
        d.a.l0.a.r1.k.i.b.e().g();
        if (qVar != null && !this.f42630d.contains(qVar)) {
            this.f42630d.add(qVar);
        }
        boolean c0 = c0();
        d.a.l0.a.r1.h.o().A("preload", c0 ? "1" : "0");
        d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "prepareRuntime preload = " + c0);
        if (c0) {
            k0();
            return;
        }
        z = PreloadState.LOADING;
        d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_start"));
        if (!d.a.l0.a.a2.d.g().r().c0()) {
            d.a.l0.a.v2.q.j(new m(this), "SwanMemory");
        }
        R0();
        boolean G = G();
        this.u = G;
        if (G) {
            d.a.l0.a.h2.f c2 = d.a.l0.a.h2.d.c();
            if (!c2.b() && c2.a()) {
                this.u = false;
            }
        }
        boolean z2 = this.u;
        d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "mIsUseV8Master:" + this.u);
        if (this.u) {
            u0(true);
        }
        if (this.f42629c == null) {
            this.f42629c = new n(z2);
            if (v) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.s.b(this.f42629c);
        }
    }

    public final void w0() {
        v0(new i(this));
    }

    public final void x0(CopyOnWriteArrayList<q> copyOnWriteArrayList) {
        if (this.f42630d == null) {
            this.f42630d = new CopyOnWriteArrayList();
        }
        Iterator<q> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (!this.f42630d.contains(next)) {
                this.f42630d.add(next);
            }
        }
        v0(new j(this));
    }

    public d.a.l0.a.p.e.b y0(Context context, d.a.l0.a.h0.b bVar) {
        try {
            d.a.l0.a.p.e.b f2 = this.r.f(context);
            d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_created"));
            String T = T();
            if (T != null) {
                d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
                if (Q != null && !TextUtils.isEmpty(Q.D())) {
                    T = Uri.parse(T).buildUpon().appendQueryParameter(PrefetchEvent.EVENT_KEY_APP_PATH, d.a.l0.a.a1.e.v(Q.D(), Q.Z(), false, null, null).getAbsolutePath()).toString();
                    if (!T.endsWith(File.separator)) {
                        T = T + File.separator;
                    }
                }
                f2.loadUrl(T);
            }
            d.a.l0.a.e0.d.h("SwanAppCoreRuntime", "prepareSlave loadUrl " + T);
            f2.c(bVar);
            return f2;
        } catch (NullPointerException e2) {
            d.a.l0.a.h0.a.e(context);
            throw e2;
        }
    }

    public final void z0() {
        if (this.f42635i || this.f42634h != null) {
            return;
        }
        if (v) {
            Log.d("SwanAppCoreRuntime", "prepareSlave start.");
        }
        d.a.l0.a.r1.h.p("preload").C(new UbcFlowEvent("na_pre_load_slave_start"));
        this.f42634h = y0(K(), new e());
        a0();
    }
}
