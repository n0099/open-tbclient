package d.b.g0.g.m;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.e0.l.j;
import d.b.g0.a.h;
import d.b.g0.a.i2.k0;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.z0.f;
import d.b.g0.g.m.c;
import d.b.g0.g.q.a;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {
    public static final boolean j = k.f45051a;
    public static volatile a k;

    /* renamed from: c  reason: collision with root package name */
    public SwanCoreVersion f48487c;

    /* renamed from: d  reason: collision with root package name */
    public ExtensionCore f48488d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.g.m.c f48489e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48491g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48492h;
    public String i;

    /* renamed from: a  reason: collision with root package name */
    public int f48485a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final Object f48486b = new Object();

    /* renamed from: f  reason: collision with root package name */
    public List<e> f48490f = new CopyOnWriteArrayList();

    /* renamed from: d.b.g0.g.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0982a implements e {
        public C0982a(a aVar) {
        }

        @Override // d.b.g0.g.m.a.e
        public void onReady() {
            if (a.j) {
                d.b.g0.a.q1.b.f.d e2 = d.b.g0.a.q1.b.f.d.e(AppRuntime.getAppContext(), h.aiapps_game_preload_core_runtime_end);
                e2.k(1);
                e2.C();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f48493a;

        /* renamed from: d.b.g0.g.m.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0983a implements Runnable {
            public RunnableC0983a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                if (a.this.f48492h || a.this.f48489e == null || (activity = f.V().getActivity()) == null || activity.isFinishing() || activity.getSwanAppFragmentManager() == null) {
                    return;
                }
                if (a.j) {
                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.i);
                }
                a.this.f48489e.k(activity);
                a.this.f48489e.t(b.this.f48493a);
                if (a.this.v()) {
                    a.this.F(activity);
                }
            }
        }

        public b(a.c cVar) {
            this.f48493a = cVar;
        }

        @Override // d.b.g0.g.m.a.e
        public void onReady() {
            i.o("startup").A(new UbcFlowEvent("na_prepare_runtime_end"));
            k0.X(new RunnableC0983a());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.e {
        public c() {
        }

        @Override // d.b.g0.g.m.c.e
        public void a(d.b.g0.g.i.a aVar) {
            if (a.j) {
                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
            }
            synchronized (a.this.f48486b) {
                a.this.f48491g = true;
                a.this.w();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(AppRuntime.getAppContext(), h.debug_game_core_package_error, 1).show();
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onReady();
    }

    public static synchronized void C() {
        synchronized (a.class) {
            if (j) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (k == null) {
                return;
            }
            k.f48492h = true;
            if (k.f48489e != null) {
                k.f48489e.m();
            }
            k = null;
            m().y();
        }
    }

    public static a m() {
        if (k == null) {
            synchronized (a.class) {
                if (k == null) {
                    k = new a();
                }
            }
        }
        return k;
    }

    public final void A() {
        synchronized (this.f48486b) {
            if (!this.f48491g && this.f48489e == null) {
                K();
                J();
                String l = l();
                if (TextUtils.isEmpty(l) || this.f48492h) {
                    return;
                }
                if (j) {
                    Log.d("SwanGameCoreRuntime", "prepareMaster start: " + l);
                }
                d.b.g0.g.m.c cVar = new d.b.g0.g.m.c(l, "swan-game.js");
                this.f48489e = cVar;
                cVar.v(new c());
            }
        }
    }

    public void B(e eVar) {
        if (j) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (eVar != null && !this.f48490f.contains(eVar)) {
            this.f48490f.add(eVar);
        }
        if (u()) {
            w();
        } else {
            A();
        }
    }

    public void D(ExtensionCore extensionCore) {
        if (extensionCore != null && extensionCore.a()) {
            if (j) {
                Log.d("SwanGameCoreRuntime", "setExtensionCore: " + this.f48488d);
            }
            this.f48488d = extensionCore;
        } else if (j) {
            StringBuilder sb = new StringBuilder();
            sb.append("setExtensionCore invalid: ");
            Object obj = extensionCore;
            if (extensionCore == null) {
                obj = " null";
            }
            sb.append(obj);
            Log.w("SwanGameCoreRuntime", sb.toString());
        }
    }

    public final void E(SwanCoreVersion swanCoreVersion) {
        if (swanCoreVersion == null || !swanCoreVersion.a()) {
            return;
        }
        this.f48487c = swanCoreVersion;
        if (j) {
            Log.d("SwanGameCoreRuntime", "setSwanCoreVersion: " + this.f48487c);
        }
    }

    public void F(SwanAppActivity swanAppActivity) {
        d.b.g0.a.e0.l.f swanAppFragmentManager;
        if (swanAppActivity == null || swanAppActivity.isFinishing() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null) {
            return;
        }
        f.b h2 = swanAppFragmentManager.h();
        h2.n(0, 0);
        h2.f();
        h2.j(j.g3());
        h2.b();
    }

    public void G(d.b.g0.a.y0.e.b bVar) {
        ExtensionCore extensionCore = this.f48488d;
        if (extensionCore != null) {
            bVar.x0(extensionCore);
        } else {
            this.f48488d = bVar.N();
        }
    }

    public void H() {
        d.b.g0.g.m.c cVar = this.f48489e;
        if (cVar != null) {
            cVar.o().y0();
        }
    }

    public void I(d.b.g0.a.y0.e.b bVar) {
        K();
        SwanCoreVersion swanCoreVersion = this.f48487c;
        if (swanCoreVersion != null) {
            bVar.Q0(swanCoreVersion);
        }
        if (j) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.f48487c);
        }
    }

    public final void J() {
        ExtensionCore extensionCore = this.f48488d;
        if (extensionCore == null || !extensionCore.a()) {
            if (j) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            D(d.b.g0.a.l0.b.b(1));
        }
    }

    public final void K() {
        SwanCoreVersion swanCoreVersion = this.f48487c;
        if (swanCoreVersion == null || !swanCoreVersion.a()) {
            E(o());
        }
    }

    public void h(Activity activity) {
        d.b.g0.g.m.c cVar = this.f48489e;
        if (cVar != null) {
            cVar.k(activity);
        }
    }

    public void i(JSEvent jSEvent) {
        d.b.g0.g.m.c cVar = this.f48489e;
        if (cVar != null) {
            cVar.o().c0(jSEvent);
        }
    }

    public int j() {
        d.b.g0.g.m.c cVar = this.f48489e;
        if (cVar != null) {
            return cVar.n();
        }
        return 0;
    }

    @Nullable
    public ExtensionCore k() {
        return this.f48488d;
    }

    public final String l() {
        SwanCoreVersion swanCoreVersion = this.f48487c;
        return (swanCoreVersion == null || !swanCoreVersion.a()) ? "" : this.f48487c.swanCorePath;
    }

    public d.b.g0.g.i.a n() {
        d.b.g0.g.m.c cVar = this.f48489e;
        if (cVar != null) {
            return cVar.o();
        }
        return null;
    }

    public final SwanCoreVersion o() {
        if (d.b.g0.g.n.a.c.a("package")) {
            if (TextUtils.isEmpty(this.i)) {
                return null;
            }
            if (!new File(this.i, "swan-game.js").exists()) {
                k0.X(new d(this));
                return d.b.g0.a.b2.b.e(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.i;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (!d.b.g0.g.n.a.c.a("normal") && !d.b.g0.a.m1.a.a.h()) {
            return d.b.g0.a.b2.b.e(1);
        } else {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = d.b.g0.g.n.a.b.b().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        }
    }

    public final int p() {
        if (this.f48485a < 0) {
            d.b.g0.a.w0.a.N().getSwitch("swan_game_preload", 0);
            this.f48485a = 0;
        }
        if (j) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.f48485a);
        }
        return this.f48485a;
    }

    public boolean q() {
        d.b.g0.a.w0.a.N().getSwitch("swan_game_startup_improvement", false);
        if (j) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:false");
        }
        return false;
    }

    public DuMixGameSurfaceView r() {
        d.b.g0.g.m.c cVar = this.f48489e;
        if (cVar != null) {
            return cVar.p();
        }
        return null;
    }

    public SwanCoreVersion s() {
        return this.f48487c;
    }

    public final boolean t(Intent intent) {
        int p = p();
        if (p != 1) {
            return p == 2 && intent == null;
        }
        return true;
    }

    public boolean u() {
        boolean z;
        synchronized (this.f48486b) {
            z = this.f48491g && this.f48489e != null;
        }
        return z;
    }

    public boolean v() {
        DuMixGameSurfaceView r;
        return (this.f48492h || (r = r()) == null || r.getParent() != null) ? false : true;
    }

    public final void w() {
        if (this.f48492h || this.f48490f.isEmpty() || !u()) {
            return;
        }
        for (e eVar : this.f48490f) {
            if (eVar != null) {
                eVar.onReady();
            }
        }
        this.f48490f.clear();
    }

    public void x(a.c cVar) {
        if (j) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (cVar == null || TextUtils.isEmpty(cVar.f48545a)) {
            return;
        }
        this.i = cVar.f48545a;
        i.o("startup").y("preload", u() ? "1" : "0");
        i.o("startup").A(new UbcFlowEvent("na_prepare_runtime_start"));
        B(new b(cVar));
        if (this.f48489e != null) {
            d.b.g0.g.w.f.b.b().f(this.f48489e.o(), cVar);
        }
    }

    public final void y() {
        if (j) {
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime by release");
        }
        z(null);
    }

    public void z(Intent intent) {
        if (j) {
            String stringExtra = intent != null ? intent.getStringExtra("bundle_key_preload_preload_scene") : null;
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime preloadScene:" + stringExtra);
        }
        if (!u() && t(intent)) {
            boolean b2 = d.b.g0.g.i0.f.d.i().b();
            boolean h2 = d.b.g0.g.i0.f.d.h();
            if (b2 && h2) {
                B(new C0982a(this));
            }
        }
    }
}
