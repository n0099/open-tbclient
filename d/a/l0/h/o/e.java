package d.a.l0.h.o;

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
import d.a.l0.a.k;
import d.a.l0.a.l0.f;
import d.a.l0.a.l0.g;
import d.a.l0.a.r1.h;
import d.a.l0.h.r.a;
import d.a.l0.h.s.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f51198h = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l0.a f51199a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f51200b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.a.y.a f51201c = new d.a.l0.a.y.a();

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC1093e f51202d;

    /* renamed from: e  reason: collision with root package name */
    public String f51203e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51204f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51205g;

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
        public final /* synthetic */ a.c f51207e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f51208f;

        public b(a.c cVar, Runnable runnable) {
            this.f51207e = cVar;
            this.f51208f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.f51198h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
            }
            d.a.l0.h.c0.a.a aVar = this.f51207e.f51350c;
            d.a.l0.h.r.a aVar2 = aVar == null ? null : aVar.f50935f;
            a.C1105a f2 = d.a.l0.h.r.a.f(aVar2);
            if (f2.b()) {
                SwanInspectorEndpoint.v().r(aVar2, e.this.f51199a, f2, this.f51208f);
                return;
            }
            SwanInspectorEndpoint.v().w(f2);
            this.f51208f.run();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements V8ThreadDelegatePolicy {

        /* renamed from: b  reason: collision with root package name */
        public DuMixGameSurfaceView f51210b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f51211e;

            public a(c cVar, V8Engine v8Engine) {
                this.f51211e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.f51198h) {
                    Log.d("SwanGameV8Master", "startEngineInternal");
                }
                this.f51211e.startEngineInternal();
            }
        }

        public c(e eVar, DuMixGameSurfaceView duMixGameSurfaceView) {
            this.f51210b = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.f51210b.t(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.f51210b.w(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.f51210b.getThread();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.f51210b.l();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            if (e.f51198h) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.f51210b.w(new a(this, v8Engine));
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.f51210b.u(runnable, j);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.l0.a.l0.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f51212a;

        /* renamed from: b  reason: collision with root package name */
        public String f51213b;

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
            this.f51212a = str;
            this.f51213b = str2;
        }

        @Override // d.a.l0.a.l0.n.b
        public String a() {
            return this.f51213b;
        }

        @Override // d.a.l0.a.l0.n.a, d.a.l0.a.l0.n.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            return d.a.l0.h.e.c.a("gameframe", getInitBasePath());
        }

        @Override // d.a.l0.a.l0.n.a, d.a.l0.a.l0.n.b
        public void c(d.a.l0.a.l0.a aVar) {
            h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (e.this.f51202d != null) {
                e.this.f51202d.a(aVar);
            }
        }

        @Override // d.a.l0.a.l0.n.a, d.a.l0.a.l0.n.b
        public void d(d.a.l0.a.l0.a aVar) {
            e.this.f51201c.b(aVar, d.a.l0.a.c1.a.b());
            new d.a.l0.h.d.a().a(aVar, d.a.l0.a.c1.a.b());
            aVar.B0(new a());
            h.p("preload").C(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        public final void f(V8EngineConfiguration.CacheInfo cacheInfo) {
            if (cacheInfo == null) {
                return;
            }
            if (e.f51198h) {
                Log.d("SwanGameV8Master", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(e.this.f51203e) && file.getCanonicalPath().startsWith(new File(e.this.f51203e).getCanonicalPath())) {
                        e.this.f51205g = true;
                    }
                } else {
                    e.this.f51204f = true;
                }
            } catch (IOException e2) {
                if (e.f51198h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.a.l0.a.l0.n.b
        public String getInitBasePath() {
            return this.f51212a;
        }
    }

    /* renamed from: d.a.l0.h.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1093e {
        void a(d.a.l0.a.l0.a aVar);
    }

    public e(@NonNull String str, @NonNull String str2) {
        q(str, str2);
    }

    public void k(Activity activity) {
        this.f51201c.a(activity);
    }

    public final g l() {
        g.b bVar = new g.b();
        bVar.c(2);
        bVar.b("master");
        return bVar.a();
    }

    public void m() {
        if (f51198h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.f51199a.k0();
        if (this.f51200b.isAttachedToWindow()) {
            return;
        }
        if (f51198h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
        }
        this.f51200b.p();
    }

    public int n() {
        return d.a.l0.h.e.c.b(this.f51204f, this.f51205g);
    }

    public d.a.l0.a.l0.a o() {
        return this.f51199a;
    }

    public DuMixGameSurfaceView p() {
        return this.f51200b;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        DuMixGameSurfaceView a2 = d.a.l0.h.q.b.b().a(AppRuntime.getAppContext());
        this.f51200b = a2;
        a2.setRenderMode(1);
        d.a.l0.a.l0.a c2 = f.c(l(), new d(str, str2), new c(this, this.f51200b));
        this.f51199a = c2;
        c2.D0(d.a.l0.a.c1.a.b());
        this.f51200b.setV8Engine(this.f51199a);
    }

    public final void r() {
        this.f51200b.x();
        this.f51199a.F0(new d.a.l0.a.l0.m.d());
        this.f51199a.H0();
        this.f51199a.E0();
        this.f51199a.C0(d.a.l0.h.e.c.a("gamejs", this.f51203e));
    }

    public final void s() {
        if (f51198h && d.a.l0.a.u1.a.a.f() && new File(d.a.l0.h.h.b.b(), d.a.l0.h.h.b.d()).exists()) {
            this.f51199a.b0(d.a.l0.h.h.b.b().getAbsolutePath(), d.a.l0.h.h.b.d());
        }
    }

    public void t(a.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.f51348a)) {
            return;
        }
        this.f51203e = cVar.f51348a;
        a aVar = new a();
        if (f51198h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
        }
        this.f51199a.runOnJSThread(new b(cVar, aVar));
    }

    public final void u() {
        if (f51198h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        HybridUbcFlow p = h.p("startup");
        p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
        p.C(new UbcFlowEvent("na_load_index_js_start"));
        this.f51199a.F(new d.a.l0.h.w.c());
        this.f51199a.b0(this.f51203e, "index.js");
        this.f51199a.F(new d.a.l0.h.w.d());
        h.p("startup").C(new UbcFlowEvent("na_load_index_js_end"));
        if (f51198h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.f51199a.y0();
        this.f51200b.o();
    }

    public void v(InterfaceC1093e interfaceC1093e) {
        this.f51202d = interfaceC1093e;
    }
}
