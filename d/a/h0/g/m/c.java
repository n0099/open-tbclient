package d.a.h0.g.m;

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
import d.a.h0.a.j1.i;
import d.a.h0.a.k;
import d.a.h0.g.i.g;
import d.a.h0.g.i.h;
import d.a.h0.g.p.a;
import d.a.h0.g.q.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46715h = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.i.a f46716a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f46717b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.g.e.a f46718c = new d.a.h0.g.e.a();

    /* renamed from: d  reason: collision with root package name */
    public e f46719d;

    /* renamed from: e  reason: collision with root package name */
    public String f46720e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46721f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46722g;

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
        public final /* synthetic */ a.c f46724e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f46725f;

        public b(a.c cVar, Runnable runnable) {
            this.f46724e = cVar;
            this.f46725f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.f46715h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
            }
            d.a.h0.g.z.a.a aVar = this.f46724e.f46762c;
            d.a.h0.g.p.a aVar2 = aVar == null ? null : aVar.f46920f;
            a.C0958a f2 = d.a.h0.g.p.a.f(aVar2);
            if (f2.b()) {
                SwanInspectorEndpoint.v().r(aVar2, c.this.f46716a, f2, this.f46725f);
                return;
            }
            SwanInspectorEndpoint.v().w(f2);
            this.f46725f.run();
        }
    }

    /* renamed from: d.a.h0.g.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0956c implements V8ThreadDelegatePolicy {

        /* renamed from: a  reason: collision with root package name */
        public DuMixGameSurfaceView f46727a;

        /* renamed from: d.a.h0.g.m.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f46728e;

            public a(C0956c c0956c, V8Engine v8Engine) {
                this.f46728e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.f46715h) {
                    Log.d("SwanGameV8Master", "startEngineInternal");
                }
                this.f46728e.startEngineInternal();
            }
        }

        public C0956c(c cVar, DuMixGameSurfaceView duMixGameSurfaceView) {
            this.f46727a = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.f46727a.t(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.f46727a.w(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.f46727a.getThread();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.f46727a.l();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            if (c.f46715h) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.f46727a.w(new a(this, v8Engine));
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.f46727a.u(runnable, j);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.a.h0.g.i.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f46729a;

        /* renamed from: b  reason: collision with root package name */
        public String f46730b;

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
            this.f46729a = str;
            this.f46730b = str2;
        }

        @Override // d.a.h0.g.i.n.b
        public String a() {
            return this.f46730b;
        }

        @Override // d.a.h0.g.i.n.a, d.a.h0.g.i.n.b
        public V8EngineConfiguration.CodeCacheSetting b() {
            if (d.a.h0.a.w0.a.N().u(1)) {
                return d.a.h0.a.e0.i.a.a("gameframe", getInitBasePath());
            }
            return null;
        }

        @Override // d.a.h0.g.i.n.a, d.a.h0.g.i.n.b
        public void c(d.a.h0.g.i.a aVar) {
            c.this.f46718c.b(aVar, d.a.h0.a.w0.a.c());
            new d.a.h0.g.e.b().a(aVar, d.a.h0.a.w0.a.c());
            aVar.w0(new a());
            i.o("preload").A(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // d.a.h0.g.i.n.a, d.a.h0.g.i.n.b
        public void d(d.a.h0.g.i.a aVar) {
            i.o("preload").A(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.f46719d != null) {
                c.this.f46719d.a(aVar);
            }
        }

        public final void f(V8EngineConfiguration.CacheInfo cacheInfo) {
            if (cacheInfo == null) {
                return;
            }
            if (c.f46715h) {
                Log.d("SwanGameV8Master", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(c.this.f46720e) && file.getCanonicalPath().startsWith(new File(c.this.f46720e).getCanonicalPath())) {
                        c.this.f46722g = true;
                    }
                } else {
                    c.this.f46721f = true;
                }
            } catch (IOException e2) {
                if (c.f46715h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.a.h0.g.i.n.b
        public String getInitBasePath() {
            return this.f46729a;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(d.a.h0.g.i.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        q(str, str2);
    }

    public void k(Activity activity) {
        this.f46718c.a(activity);
    }

    public final h l() {
        h.b bVar = new h.b();
        bVar.c(2);
        bVar.b("master");
        return bVar.a();
    }

    public void m() {
        if (f46715h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.f46716a.h0();
        if (this.f46717b.isAttachedToWindow()) {
            return;
        }
        if (f46715h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
        }
        this.f46717b.p();
    }

    public int n() {
        return d.a.h0.a.e0.i.a.b(this.f46721f, this.f46722g);
    }

    public d.a.h0.g.i.a o() {
        return this.f46716a;
    }

    public DuMixGameSurfaceView p() {
        return this.f46717b;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        DuMixGameSurfaceView a2 = d.a.h0.g.o.b.b().a(AppRuntime.getAppContext());
        this.f46717b = a2;
        a2.setRenderMode(1);
        d.a.h0.g.i.a c2 = g.c(l(), new d(str, str2), new C0956c(this, this.f46717b));
        this.f46716a = c2;
        c2.y0(d.a.h0.a.w0.a.c());
        this.f46717b.setV8Engine(this.f46716a);
    }

    public final void r() {
        this.f46717b.x();
        this.f46716a.A0(new d.a.h0.g.i.m.d());
        this.f46716a.C0();
        this.f46716a.z0();
        if (d.a.h0.a.w0.a.N().u(1)) {
            this.f46716a.x0(d.a.h0.a.e0.i.a.a("gamejs", this.f46720e));
        }
    }

    public final void s() {
        if (f46715h && d.a.h0.a.m1.a.a.f() && new File(d.a.h0.g.h.b.b(), d.a.h0.g.h.b.d()).exists()) {
            this.f46716a.U(d.a.h0.g.h.b.b().getAbsolutePath(), d.a.h0.g.h.b.d());
        }
    }

    public void t(a.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.f46760a)) {
            return;
        }
        this.f46720e = cVar.f46760a;
        a aVar = new a();
        if (f46715h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
        }
        this.f46716a.runOnJSThread(new b(cVar, aVar));
    }

    public final void u() {
        if (f46715h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        HybridUbcFlow o = i.o("startup");
        o.D(HybridUbcFlow.SubmitStrategy.NA_ONLY);
        o.A(new UbcFlowEvent("na_load_index_js_start"));
        this.f46716a.Q(new d.a.h0.g.u.c());
        this.f46716a.U(this.f46720e, "index.js");
        this.f46716a.Q(new d.a.h0.g.u.d());
        i.o("startup").A(new UbcFlowEvent("na_load_index_js_end"));
        if (f46715h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.f46716a.u0();
        this.f46717b.o();
    }

    public void v(e eVar) {
        this.f46719d = eVar;
    }
}
