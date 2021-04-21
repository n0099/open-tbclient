package d.b.h0.g.m;

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
import d.b.h0.a.j1.i;
import d.b.h0.a.k;
import d.b.h0.g.i.g;
import d.b.h0.g.i.h;
import d.b.h0.g.p.a;
import d.b.h0.g.q.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f49221h = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.i.a f49222a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f49223b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.g.e.a f49224c = new d.b.h0.g.e.a();

    /* renamed from: d  reason: collision with root package name */
    public e f49225d;

    /* renamed from: e  reason: collision with root package name */
    public String f49226e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49227f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49228g;

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
        public final /* synthetic */ a.c f49230e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f49231f;

        public b(a.c cVar, Runnable runnable) {
            this.f49230e = cVar;
            this.f49231f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.f49221h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
            }
            d.b.h0.g.z.a.a aVar = this.f49230e.f49268c;
            d.b.h0.g.p.a aVar2 = aVar == null ? null : aVar.f49420f;
            a.C1019a f2 = d.b.h0.g.p.a.f(aVar2);
            if (f2.b()) {
                SwanInspectorEndpoint.v().r(aVar2, c.this.f49222a, f2, this.f49231f);
                return;
            }
            SwanInspectorEndpoint.v().w(f2);
            this.f49231f.run();
        }
    }

    /* renamed from: d.b.h0.g.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1017c implements V8ThreadDelegatePolicy {

        /* renamed from: a  reason: collision with root package name */
        public DuMixGameSurfaceView f49233a;

        /* renamed from: d.b.h0.g.m.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f49234e;

            public a(C1017c c1017c, V8Engine v8Engine) {
                this.f49234e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.f49221h) {
                    Log.d("SwanGameV8Master", "startEngineInternal");
                }
                this.f49234e.startEngineInternal();
            }
        }

        public C1017c(c cVar, DuMixGameSurfaceView duMixGameSurfaceView) {
            this.f49233a = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.f49233a.t(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.f49233a.w(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.f49233a.getThread();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.f49233a.l();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            if (c.f49221h) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.f49233a.w(new a(this, v8Engine));
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.f49233a.u(runnable, j);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.h0.g.i.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f49235a;

        /* renamed from: b  reason: collision with root package name */
        public String f49236b;

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
            this.f49235a = str;
            this.f49236b = str2;
        }

        @Override // d.b.h0.g.i.n.b
        public String a() {
            return this.f49236b;
        }

        @Override // d.b.h0.g.i.n.a, d.b.h0.g.i.n.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            if (d.b.h0.a.w0.a.N().G(1)) {
                return d.b.h0.a.e0.i.a.a("gameframe", getInitBasePath());
            }
            return null;
        }

        @Override // d.b.h0.g.i.n.a, d.b.h0.g.i.n.b
        public void c(d.b.h0.g.i.a aVar) {
            i.o("preload").A(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.f49225d != null) {
                c.this.f49225d.a(aVar);
            }
        }

        @Override // d.b.h0.g.i.n.a, d.b.h0.g.i.n.b
        public void d(d.b.h0.g.i.a aVar) {
            c.this.f49224c.b(aVar, d.b.h0.a.w0.a.c());
            new d.b.h0.g.e.b().a(aVar, d.b.h0.a.w0.a.c());
            aVar.w0(new a());
            i.o("preload").A(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        public final void f(V8EngineConfiguration.CacheInfo cacheInfo) {
            if (cacheInfo == null) {
                return;
            }
            if (c.f49221h) {
                Log.d("SwanGameV8Master", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(c.this.f49226e) && file.getCanonicalPath().startsWith(new File(c.this.f49226e).getCanonicalPath())) {
                        c.this.f49228g = true;
                    }
                } else {
                    c.this.f49227f = true;
                }
            } catch (IOException e2) {
                if (c.f49221h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.b.h0.g.i.n.b
        public String getInitBasePath() {
            return this.f49235a;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(d.b.h0.g.i.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        q(str, str2);
    }

    public void k(Activity activity) {
        this.f49224c.a(activity);
    }

    public final h l() {
        h.b bVar = new h.b();
        bVar.c(2);
        bVar.b("master");
        return bVar.a();
    }

    public void m() {
        if (f49221h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.f49222a.h0();
        if (this.f49223b.isAttachedToWindow()) {
            return;
        }
        if (f49221h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
        }
        this.f49223b.p();
    }

    public int n() {
        return d.b.h0.a.e0.i.a.b(this.f49227f, this.f49228g);
    }

    public d.b.h0.g.i.a o() {
        return this.f49222a;
    }

    public DuMixGameSurfaceView p() {
        return this.f49223b;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        DuMixGameSurfaceView a2 = d.b.h0.g.o.b.b().a(AppRuntime.getAppContext());
        this.f49223b = a2;
        a2.setRenderMode(1);
        d.b.h0.g.i.a c2 = g.c(l(), new d(str, str2), new C1017c(this, this.f49223b));
        this.f49222a = c2;
        c2.y0(d.b.h0.a.w0.a.c());
        this.f49223b.setV8Engine(this.f49222a);
    }

    public final void r() {
        this.f49223b.x();
        this.f49222a.A0(new d.b.h0.g.i.m.d());
        this.f49222a.C0();
        this.f49222a.z0();
        if (d.b.h0.a.w0.a.N().G(1)) {
            this.f49222a.x0(d.b.h0.a.e0.i.a.a("gamejs", this.f49226e));
        }
    }

    public final void s() {
        if (f49221h && d.b.h0.a.m1.a.a.f() && new File(d.b.h0.g.h.b.b(), d.b.h0.g.h.b.d()).exists()) {
            this.f49222a.S(d.b.h0.g.h.b.b().getAbsolutePath(), d.b.h0.g.h.b.d());
        }
    }

    public void t(a.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.f49266a)) {
            return;
        }
        this.f49226e = cVar.f49266a;
        a aVar = new a();
        if (f49221h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
        }
        this.f49222a.runOnJSThread(new b(cVar, aVar));
    }

    public final void u() {
        if (f49221h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        HybridUbcFlow o = i.o("startup");
        o.D(HybridUbcFlow.SubmitStrategy.NA_ONLY);
        o.A(new UbcFlowEvent("na_load_index_js_start"));
        this.f49222a.d0(new d.b.h0.g.u.c());
        this.f49222a.S(this.f49226e, "index.js");
        this.f49222a.d0(new d.b.h0.g.u.d());
        i.o("startup").A(new UbcFlowEvent("na_load_index_js_end"));
        if (f49221h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.f49222a.u0();
        this.f49223b.o();
    }

    public void v(e eVar) {
        this.f49225d = eVar;
    }
}
