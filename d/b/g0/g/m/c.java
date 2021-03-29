package d.b.g0.g.m;

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
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.g.i.g;
import d.b.g0.g.i.h;
import d.b.g0.g.p.a;
import d.b.g0.g.q.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f48500h = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.a f48501a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f48502b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.g.e.a f48503c = new d.b.g0.g.e.a();

    /* renamed from: d  reason: collision with root package name */
    public e f48504d;

    /* renamed from: e  reason: collision with root package name */
    public String f48505e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48506f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48507g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.r();
            c.this.s();
            c.this.u();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f48509e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f48510f;

        public b(a.c cVar, Runnable runnable) {
            this.f48509e = cVar;
            this.f48510f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.f48500h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
            }
            d.b.g0.g.z.a.a aVar = this.f48509e.f48547c;
            d.b.g0.g.p.a aVar2 = aVar == null ? null : aVar.f48699f;
            a.C0987a f2 = d.b.g0.g.p.a.f(aVar2);
            if (f2.b()) {
                SwanInspectorEndpoint.v().r(aVar2, c.this.f48501a, f2, this.f48510f);
                return;
            }
            SwanInspectorEndpoint.v().w(f2);
            this.f48510f.run();
        }
    }

    /* renamed from: d.b.g0.g.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0985c implements V8ThreadDelegatePolicy {

        /* renamed from: a  reason: collision with root package name */
        public DuMixGameSurfaceView f48512a;

        /* renamed from: d.b.g0.g.m.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f48513e;

            public a(C0985c c0985c, V8Engine v8Engine) {
                this.f48513e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.f48500h) {
                    Log.d("SwanGameV8Master", "startEngineInternal");
                }
                this.f48513e.startEngineInternal();
            }
        }

        public C0985c(c cVar, DuMixGameSurfaceView duMixGameSurfaceView) {
            this.f48512a = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.f48512a.t(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.f48512a.w(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.f48512a.getThread();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.f48512a.l();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            if (c.f48500h) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.f48512a.w(new a(this, v8Engine));
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.f48512a.u(runnable, j);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.g0.g.i.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f48514a;

        /* renamed from: b  reason: collision with root package name */
        public String f48515b;

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
            this.f48514a = str;
            this.f48515b = str2;
        }

        @Override // d.b.g0.g.i.n.b
        public String a() {
            return this.f48515b;
        }

        @Override // d.b.g0.g.i.n.a, d.b.g0.g.i.n.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            if (d.b.g0.a.w0.a.N().G(1)) {
                return d.b.g0.a.e0.i.a.a("gameframe", getInitBasePath());
            }
            return null;
        }

        @Override // d.b.g0.g.i.n.a, d.b.g0.g.i.n.b
        public void c(d.b.g0.g.i.a aVar) {
            i.o("preload").A(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.f48504d != null) {
                c.this.f48504d.a(aVar);
            }
        }

        @Override // d.b.g0.g.i.n.a, d.b.g0.g.i.n.b
        public void d(d.b.g0.g.i.a aVar) {
            c.this.f48503c.b(aVar, d.b.g0.a.w0.a.c());
            new d.b.g0.g.e.b().a(aVar, d.b.g0.a.w0.a.c());
            aVar.v0(new a());
            i.o("preload").A(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        public final void f(V8EngineConfiguration.CacheInfo cacheInfo) {
            if (cacheInfo == null) {
                return;
            }
            if (c.f48500h) {
                Log.d("SwanGameV8Master", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(c.this.f48505e) && file.getCanonicalPath().startsWith(new File(c.this.f48505e).getCanonicalPath())) {
                        c.this.f48507g = true;
                    }
                } else {
                    c.this.f48506f = true;
                }
            } catch (IOException e2) {
                if (c.f48500h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.b.g0.g.i.n.b
        public String getInitBasePath() {
            return this.f48514a;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(d.b.g0.g.i.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        q(str, str2);
    }

    public void k(Activity activity) {
        this.f48503c.a(activity);
    }

    public final h l() {
        h.b bVar = new h.b();
        bVar.c(2);
        bVar.b("master");
        return bVar.a();
    }

    public void m() {
        if (f48500h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.f48501a.g0();
        if (this.f48502b.isAttachedToWindow()) {
            return;
        }
        if (f48500h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
        }
        this.f48502b.p();
    }

    public int n() {
        return d.b.g0.a.e0.i.a.b(this.f48506f, this.f48507g);
    }

    public d.b.g0.g.i.a o() {
        return this.f48501a;
    }

    public DuMixGameSurfaceView p() {
        return this.f48502b;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        DuMixGameSurfaceView a2 = d.b.g0.g.o.b.b().a(AppRuntime.getAppContext());
        this.f48502b = a2;
        a2.setRenderMode(1);
        d.b.g0.g.i.a c2 = g.c(l(), new d(str, str2), new C0985c(this, this.f48502b));
        this.f48501a = c2;
        c2.x0(d.b.g0.a.w0.a.c());
        this.f48502b.setV8Engine(this.f48501a);
    }

    public final void r() {
        this.f48502b.x();
        this.f48501a.z0(new d.b.g0.g.i.m.d());
        this.f48501a.B0();
        this.f48501a.y0();
        if (d.b.g0.a.w0.a.N().G(1)) {
            this.f48501a.w0(d.b.g0.a.e0.i.a.a("gamejs", this.f48505e));
        }
    }

    public final void s() {
        if (f48500h && d.b.g0.a.m1.a.a.f() && new File(d.b.g0.g.h.b.b(), d.b.g0.g.h.b.d()).exists()) {
            this.f48501a.N(d.b.g0.g.h.b.b().getAbsolutePath(), d.b.g0.g.h.b.d());
        }
    }

    public void t(a.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.f48545a)) {
            return;
        }
        this.f48505e = cVar.f48545a;
        a aVar = new a();
        if (f48500h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
        }
        this.f48501a.runOnJSThread(new b(cVar, aVar));
    }

    public final void u() {
        if (f48500h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        HybridUbcFlow o = i.o("startup");
        o.D(HybridUbcFlow.SubmitStrategy.NA_ONLY);
        o.A(new UbcFlowEvent("na_load_index_js_start"));
        this.f48501a.c0(new d.b.g0.g.u.c());
        this.f48501a.N(this.f48505e, "index.js");
        this.f48501a.c0(new d.b.g0.g.u.d());
        i.o("startup").A(new UbcFlowEvent("na_load_index_js_end"));
        if (f48500h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.f48501a.t0();
        this.f48502b.o();
    }

    public void v(e eVar) {
        this.f48504d = eVar;
    }
}
