package d.a.m0.h.o;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import d.a.m0.a.k;
import d.a.m0.a.l0.f;
import d.a.m0.a.l0.g;
import d.a.m0.a.r1.h;
import d.a.m0.h.r.a;
import d.a.m0.h.s.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f51306h = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.l0.a f51307a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f51308b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.a.y.a f51309c = new d.a.m0.a.y.a();

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC1096e f51310d;

    /* renamed from: e  reason: collision with root package name */
    public String f51311e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51312f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51313g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.r();
            e.this.s();
            e.this.u();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f51315e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f51316f;

        public b(a.c cVar, Runnable runnable) {
            this.f51315e = cVar;
            this.f51316f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.f51306h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
            }
            d.a.m0.h.c0.a.a aVar = this.f51315e.f51458c;
            d.a.m0.h.r.a aVar2 = aVar == null ? null : aVar.f51043f;
            a.C1108a f2 = d.a.m0.h.r.a.f(aVar2);
            if (f2.b()) {
                SwanInspectorEndpoint.v().r(aVar2, e.this.f51307a, f2, this.f51316f);
                return;
            }
            SwanInspectorEndpoint.v().w(f2);
            this.f51316f.run();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements V8ThreadDelegatePolicy {

        /* renamed from: b  reason: collision with root package name */
        public DuMixGameSurfaceView f51318b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f51319e;

            public a(c cVar, V8Engine v8Engine) {
                this.f51319e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.f51306h) {
                    Log.d("SwanGameV8Master", "startEngineInternal");
                }
                this.f51319e.startEngineInternal();
            }
        }

        public c(e eVar, DuMixGameSurfaceView duMixGameSurfaceView) {
            this.f51318b = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.f51318b.t(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.f51318b.w(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.f51318b.getThread();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.f51318b.l();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            if (e.f51306h) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.f51318b.w(new a(this, v8Engine));
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.f51318b.u(runnable, j);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.m0.a.l0.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f51320a;

        /* renamed from: b  reason: collision with root package name */
        public String f51321b;

        /* loaded from: classes3.dex */
        public class a implements V8EngineConfiguration.JSCacheCallback {
            public a() {
            }

            @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
            public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                d.this.f(cacheInfo);
            }
        }

        public d(@NonNull String str, @NonNull String str2) {
            this.f51320a = str;
            this.f51321b = str2;
        }

        @Override // d.a.m0.a.l0.n.b
        public String a() {
            return this.f51321b;
        }

        @Override // d.a.m0.a.l0.n.a, d.a.m0.a.l0.n.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            return d.a.m0.h.e.c.a("gameframe", getInitBasePath());
        }

        @Override // d.a.m0.a.l0.n.a, d.a.m0.a.l0.n.b
        public void c(d.a.m0.a.l0.a aVar) {
            h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (e.this.f51310d != null) {
                e.this.f51310d.a(aVar);
            }
        }

        @Override // d.a.m0.a.l0.n.a, d.a.m0.a.l0.n.b
        public void d(d.a.m0.a.l0.a aVar) {
            e.this.f51309c.b(aVar, d.a.m0.a.c1.a.b());
            new d.a.m0.h.d.a().a(aVar, d.a.m0.a.c1.a.b());
            aVar.B0(new a());
            h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        public final void f(V8EngineConfiguration.CacheInfo cacheInfo) {
            if (cacheInfo == null) {
                return;
            }
            if (e.f51306h) {
                Log.d("SwanGameV8Master", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(e.this.f51311e) && file.getCanonicalPath().startsWith(new File(e.this.f51311e).getCanonicalPath())) {
                        e.this.f51313g = true;
                    }
                } else {
                    e.this.f51312f = true;
                }
            } catch (IOException e2) {
                if (e.f51306h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.a.m0.a.l0.n.b
        public String getInitBasePath() {
            return this.f51320a;
        }
    }

    /* renamed from: d.a.m0.h.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1096e {
        void a(d.a.m0.a.l0.a aVar);
    }

    public e(@NonNull String str, @NonNull String str2) {
        q(str, str2);
    }

    public void k(Activity activity) {
        this.f51309c.a(activity);
    }

    public final g l() {
        g.b bVar = new g.b();
        bVar.c(2);
        bVar.b("master");
        return bVar.a();
    }

    public void m() {
        if (f51306h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.f51307a.k0();
        if (this.f51308b.isAttachedToWindow()) {
            return;
        }
        if (f51306h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
        }
        this.f51308b.p();
    }

    public int n() {
        return d.a.m0.h.e.c.b(this.f51312f, this.f51313g);
    }

    public d.a.m0.a.l0.a o() {
        return this.f51307a;
    }

    public DuMixGameSurfaceView p() {
        return this.f51308b;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        DuMixGameSurfaceView a2 = d.a.m0.h.q.b.b().a(AppRuntime.getAppContext());
        this.f51308b = a2;
        a2.setRenderMode(1);
        d.a.m0.a.l0.a c2 = f.c(l(), new d(str, str2), new c(this, this.f51308b));
        this.f51307a = c2;
        c2.D0(d.a.m0.a.c1.a.b());
        this.f51308b.setV8Engine(this.f51307a);
    }

    public final void r() {
        this.f51308b.x();
        this.f51307a.F0(new d.a.m0.a.l0.m.d());
        this.f51307a.H0();
        this.f51307a.E0();
        this.f51307a.C0(d.a.m0.h.e.c.a("gamejs", this.f51311e));
    }

    public final void s() {
        if (f51306h && d.a.m0.a.u1.a.a.f() && new File(d.a.m0.h.h.b.b(), d.a.m0.h.h.b.d()).exists()) {
            this.f51307a.b0(d.a.m0.h.h.b.b().getAbsolutePath(), d.a.m0.h.h.b.d());
        }
    }

    public void t(a.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.f51456a)) {
            return;
        }
        this.f51311e = cVar.f51456a;
        a aVar = new a();
        if (f51306h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
        }
        this.f51307a.runOnJSThread(new b(cVar, aVar));
    }

    public final void u() {
        if (f51306h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        HybridUbcFlow p = h.p("startup");
        p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
        p.C(new UbcFlowEvent("na_load_index_js_start"));
        this.f51307a.F(new d.a.m0.h.w.c());
        this.f51307a.b0(this.f51311e, "index.js");
        this.f51307a.F(new d.a.m0.h.w.d());
        h.p("startup").C(new UbcFlowEvent("na_load_index_js_end"));
        if (f51306h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.f51307a.y0();
        this.f51308b.o();
    }

    public void v(InterfaceC1096e interfaceC1096e) {
        this.f51310d = interfaceC1096e;
    }
}
