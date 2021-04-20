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
    public static final boolean f48892h = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.a f48893a;

    /* renamed from: b  reason: collision with root package name */
    public DuMixGameSurfaceView f48894b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.g.e.a f48895c = new d.b.g0.g.e.a();

    /* renamed from: d  reason: collision with root package name */
    public e f48896d;

    /* renamed from: e  reason: collision with root package name */
    public String f48897e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48898f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48899g;

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
        public final /* synthetic */ a.c f48901e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Runnable f48902f;

        public b(a.c cVar, Runnable runnable) {
            this.f48901e = cVar;
            this.f48902f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.f48892h) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
            }
            d.b.g0.g.z.a.a aVar = this.f48901e.f48939c;
            d.b.g0.g.p.a aVar2 = aVar == null ? null : aVar.f49091f;
            a.C0999a f2 = d.b.g0.g.p.a.f(aVar2);
            if (f2.b()) {
                SwanInspectorEndpoint.v().r(aVar2, c.this.f48893a, f2, this.f48902f);
                return;
            }
            SwanInspectorEndpoint.v().w(f2);
            this.f48902f.run();
        }
    }

    /* renamed from: d.b.g0.g.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0997c implements V8ThreadDelegatePolicy {

        /* renamed from: a  reason: collision with root package name */
        public DuMixGameSurfaceView f48904a;

        /* renamed from: d.b.g0.g.m.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ V8Engine f48905e;

            public a(C0997c c0997c, V8Engine v8Engine) {
                this.f48905e = v8Engine;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.f48892h) {
                    Log.d("SwanGameV8Master", "startEngineInternal");
                }
                this.f48905e.startEngineInternal();
            }
        }

        public C0997c(c cVar, DuMixGameSurfaceView duMixGameSurfaceView) {
            this.f48904a = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.f48904a.t(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.f48904a.w(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.f48904a.getThread();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.f48904a.l();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(V8Engine v8Engine) {
            if (c.f48892h) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.f48904a.w(new a(this, v8Engine));
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.f48904a.u(runnable, j);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.g0.g.i.n.a {

        /* renamed from: a  reason: collision with root package name */
        public String f48906a;

        /* renamed from: b  reason: collision with root package name */
        public String f48907b;

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
            this.f48906a = str;
            this.f48907b = str2;
        }

        @Override // d.b.g0.g.i.n.b
        public String a() {
            return this.f48907b;
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
            if (c.this.f48896d != null) {
                c.this.f48896d.a(aVar);
            }
        }

        @Override // d.b.g0.g.i.n.a, d.b.g0.g.i.n.b
        public void d(d.b.g0.g.i.a aVar) {
            c.this.f48895c.b(aVar, d.b.g0.a.w0.a.c());
            new d.b.g0.g.e.b().a(aVar, d.b.g0.a.w0.a.c());
            aVar.w0(new a());
            i.o("preload").A(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        public final void f(V8EngineConfiguration.CacheInfo cacheInfo) {
            if (cacheInfo == null) {
                return;
            }
            if (c.f48892h) {
                Log.d("SwanGameV8Master", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
            }
            if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                return;
            }
            File file = new File(cacheInfo.jsPath);
            try {
                if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                    if (!TextUtils.isEmpty(c.this.f48897e) && file.getCanonicalPath().startsWith(new File(c.this.f48897e).getCanonicalPath())) {
                        c.this.f48899g = true;
                    }
                } else {
                    c.this.f48898f = true;
                }
            } catch (IOException e2) {
                if (c.f48892h) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.b.g0.g.i.n.b
        public String getInitBasePath() {
            return this.f48906a;
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
        this.f48895c.a(activity);
    }

    public final h l() {
        h.b bVar = new h.b();
        bVar.c(2);
        bVar.b("master");
        return bVar.a();
    }

    public void m() {
        if (f48892h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.f48893a.h0();
        if (this.f48894b.isAttachedToWindow()) {
            return;
        }
        if (f48892h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
        }
        this.f48894b.p();
    }

    public int n() {
        return d.b.g0.a.e0.i.a.b(this.f48898f, this.f48899g);
    }

    public d.b.g0.g.i.a o() {
        return this.f48893a;
    }

    public DuMixGameSurfaceView p() {
        return this.f48894b;
    }

    public final void q(@NonNull String str, @NonNull String str2) {
        DuMixGameSurfaceView a2 = d.b.g0.g.o.b.b().a(AppRuntime.getAppContext());
        this.f48894b = a2;
        a2.setRenderMode(1);
        d.b.g0.g.i.a c2 = g.c(l(), new d(str, str2), new C0997c(this, this.f48894b));
        this.f48893a = c2;
        c2.y0(d.b.g0.a.w0.a.c());
        this.f48894b.setV8Engine(this.f48893a);
    }

    public final void r() {
        this.f48894b.x();
        this.f48893a.A0(new d.b.g0.g.i.m.d());
        this.f48893a.C0();
        this.f48893a.z0();
        if (d.b.g0.a.w0.a.N().G(1)) {
            this.f48893a.x0(d.b.g0.a.e0.i.a.a("gamejs", this.f48897e));
        }
    }

    public final void s() {
        if (f48892h && d.b.g0.a.m1.a.a.f() && new File(d.b.g0.g.h.b.b(), d.b.g0.g.h.b.d()).exists()) {
            this.f48893a.S(d.b.g0.g.h.b.b().getAbsolutePath(), d.b.g0.g.h.b.d());
        }
    }

    public void t(a.c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.f48937a)) {
            return;
        }
        this.f48897e = cVar.f48937a;
        a aVar = new a();
        if (f48892h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
        }
        this.f48893a.runOnJSThread(new b(cVar, aVar));
    }

    public final void u() {
        if (f48892h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        HybridUbcFlow o = i.o("startup");
        o.D(HybridUbcFlow.SubmitStrategy.NA_ONLY);
        o.A(new UbcFlowEvent("na_load_index_js_start"));
        this.f48893a.d0(new d.b.g0.g.u.c());
        this.f48893a.S(this.f48897e, "index.js");
        this.f48893a.d0(new d.b.g0.g.u.d());
        i.o("startup").A(new UbcFlowEvent("na_load_index_js_end"));
        if (f48892h) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.f48893a.u0();
        this.f48894b.o();
    }

    public void v(e eVar) {
        this.f48896d = eVar;
    }
}
