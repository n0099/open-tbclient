package d.a.i0.h.o;

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
import d.a.i0.a.k;
import d.a.i0.a.l0.f;
import d.a.i0.a.l0.g;
import d.a.i0.a.r1.h;
import d.a.i0.h.r.a;
import d.a.i0.h.s.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f47348h = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l0.a f47349a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f47350b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.a.y.a f47351c = new d.a.i0.a.y.a();

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC1026e f47352d;

    /* renamed from: e  reason: collision with root package name */
    public String f47353e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47354f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47355g;

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
        public final /* synthetic */ a.c f47357e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f47358f;

        public b(a.c cVar, Runnable runnable) {
            this.f47357e = cVar;
            this.f47358f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.f47348h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
            }
            d.a.i0.h.c0.a.a aVar = this.f47357e.f47500c;
            d.a.i0.h.r.a aVar2 = aVar == null ? null : aVar.f47085f;
            a.C1038a f2 = d.a.i0.h.r.a.f(aVar2);
            if (f2.b()) {
                SwanInspectorEndpoint.v().r(aVar2, e.this.f47349a, f2, this.f47358f);
                return;
            }
            SwanInspectorEndpoint.v().w(f2);
            this.f47358f.run();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements V8ThreadDelegatePolicy {

        /* renamed from: b  reason: collision with root package name */
        public DuMixGameSurfaceView f47360b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f47361e;

            public a(c cVar, V8Engine v8Engine) {
                this.f47361e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.f47348h) {
                    Log.d("SwanGameV8Master", "startEngineInternal");
                }
                this.f47361e.startEngineInternal();
            }
        }

        public c(e eVar, DuMixGameSurfaceView duMixGameSurfaceView) {
            this.f47360b = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.f47360b.t(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.f47360b.w(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.f47360b.getThread();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.f47360b.l();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            if (e.f47348h) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.f47360b.w(new a(this, v8Engine));
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.f47360b.u(runnable, j);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.i0.a.l0.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f47362a;

        /* renamed from: b  reason: collision with root package name */
        public String f47363b;

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
            this.f47362a = str;
            this.f47363b = str2;
        }

        @Override // d.a.i0.a.l0.n.b
        public String a() {
            return this.f47363b;
        }

        @Override // d.a.i0.a.l0.n.a, d.a.i0.a.l0.n.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            return d.a.i0.h.e.c.a("gameframe", getInitBasePath());
        }

        @Override // d.a.i0.a.l0.n.a, d.a.i0.a.l0.n.b
        public void c(d.a.i0.a.l0.a aVar) {
            h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (e.this.f47352d != null) {
                e.this.f47352d.a(aVar);
            }
        }

        @Override // d.a.i0.a.l0.n.a, d.a.i0.a.l0.n.b
        public void d(d.a.i0.a.l0.a aVar) {
            e.this.f47351c.b(aVar, d.a.i0.a.c1.a.b());
            new d.a.i0.h.d.a().a(aVar, d.a.i0.a.c1.a.b());
            aVar.B0(new a());
            h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        public final void f(V8EngineConfiguration.CacheInfo cacheInfo) {
            if (cacheInfo == null) {
                return;
            }
            if (e.f47348h) {
                Log.d("SwanGameV8Master", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(e.this.f47353e) && file.getCanonicalPath().startsWith(new File(e.this.f47353e).getCanonicalPath())) {
                        e.this.f47355g = true;
                    }
                } else {
                    e.this.f47354f = true;
                }
            } catch (IOException e2) {
                if (e.f47348h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.a.i0.a.l0.n.b
        public String getInitBasePath() {
            return this.f47362a;
        }
    }

    /* renamed from: d.a.i0.h.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1026e {
        void a(d.a.i0.a.l0.a aVar);
    }

    public e(@NonNull String str, @NonNull String str2) {
        q(str, str2);
    }

    public void k(Activity activity) {
        this.f47351c.a(activity);
    }

    public final g l() {
        g.b bVar = new g.b();
        bVar.c(2);
        bVar.b("master");
        return bVar.a();
    }

    public void m() {
        if (f47348h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.f47349a.k0();
        if (this.f47350b.isAttachedToWindow()) {
            return;
        }
        if (f47348h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
        }
        this.f47350b.p();
    }

    public int n() {
        return d.a.i0.h.e.c.b(this.f47354f, this.f47355g);
    }

    public d.a.i0.a.l0.a o() {
        return this.f47349a;
    }

    public DuMixGameSurfaceView p() {
        return this.f47350b;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        DuMixGameSurfaceView a2 = d.a.i0.h.q.b.b().a(AppRuntime.getAppContext());
        this.f47350b = a2;
        a2.setRenderMode(1);
        d.a.i0.a.l0.a c2 = f.c(l(), new d(str, str2), new c(this, this.f47350b));
        this.f47349a = c2;
        c2.D0(d.a.i0.a.c1.a.b());
        this.f47350b.setV8Engine(this.f47349a);
    }

    public final void r() {
        this.f47350b.x();
        this.f47349a.F0(new d.a.i0.a.l0.m.d());
        this.f47349a.H0();
        this.f47349a.E0();
        this.f47349a.C0(d.a.i0.h.e.c.a("gamejs", this.f47353e));
    }

    public final void s() {
        if (f47348h && d.a.i0.a.u1.a.a.f() && new File(d.a.i0.h.h.b.b(), d.a.i0.h.h.b.d()).exists()) {
            this.f47349a.b0(d.a.i0.h.h.b.b().getAbsolutePath(), d.a.i0.h.h.b.d());
        }
    }

    public void t(a.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.f47498a)) {
            return;
        }
        this.f47353e = cVar.f47498a;
        a aVar = new a();
        if (f47348h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
        }
        this.f47349a.runOnJSThread(new b(cVar, aVar));
    }

    public final void u() {
        if (f47348h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        HybridUbcFlow p = h.p("startup");
        p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
        p.C(new UbcFlowEvent("na_load_index_js_start"));
        this.f47349a.F(new d.a.i0.h.w.c());
        this.f47349a.b0(this.f47353e, "index.js");
        this.f47349a.F(new d.a.i0.h.w.d());
        h.p("startup").C(new UbcFlowEvent("na_load_index_js_end"));
        if (f47348h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.f47349a.y0();
        this.f47350b.o();
    }

    public void v(InterfaceC1026e interfaceC1026e) {
        this.f47352d = interfaceC1026e;
    }
}
