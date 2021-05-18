package d.a.i0.h.o;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.tieba.service.AsInstallService;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.k;
import d.a.i0.a.r1.h;
import d.a.i0.a.v2.q0;
import d.a.i0.f.g;
import d.a.i0.h.o.e;
import d.a.i0.h.s.a;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class c {
    public static final boolean j = k.f43025a;
    public static volatile c k;

    /* renamed from: c  reason: collision with root package name */
    public SwanCoreVersion f47334c;

    /* renamed from: d  reason: collision with root package name */
    public ExtensionCore f47335d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.h.o.e f47336e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47338g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47339h;

    /* renamed from: i  reason: collision with root package name */
    public String f47340i;

    /* renamed from: a  reason: collision with root package name */
    public int f47332a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final Object f47333b = new Object();

    /* renamed from: f  reason: collision with root package name */
    public List<f> f47337f = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public class a implements f {
        public a(c cVar) {
        }

        @Override // d.a.i0.h.o.c.f
        public void onReady() {
            if (c.j) {
                d.a.i0.a.z1.b.f.e f2 = d.a.i0.a.z1.b.f.e.f(AppRuntime.getAppContext(), g.aiapps_game_preload_core_runtime_end);
                f2.l(1);
                f2.F();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b(c cVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent addFlags = new Intent().putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, SwanAppErrorActivity.TYPE_LOAD_V8_FAILED).setComponent(new ComponentName(AppRuntime.getAppContext(), SwanAppErrorActivity.class)).addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            if (d.a.i0.a.a2.e.i() != null) {
                d.a.i0.a.v2.f.j(d.a.i0.a.a2.e.i().x());
            }
            AppRuntime.getAppContext().startActivity(addFlags);
        }
    }

    /* renamed from: d.a.i0.h.o.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1025c implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f47341a;

        /* renamed from: d.a.i0.h.o.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppActivity activity;
                if (c.this.f47339h || c.this.f47336e == null || (activity = d.a.i0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.getSwanAppFragmentManager() == null) {
                    return;
                }
                if (c.j) {
                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + c.this.f47340i);
                }
                c.this.f47336e.k(activity);
                c.this.f47336e.t(C1025c.this.f47341a);
                if (c.this.v()) {
                    c.this.F(activity);
                }
            }
        }

        public C1025c(a.c cVar) {
            this.f47341a = cVar;
        }

        @Override // d.a.i0.h.o.c.f
        public void onReady() {
            h.p("startup").C(new UbcFlowEvent("na_prepare_runtime_end"));
            q0.b0(new a());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements e.InterfaceC1026e {
        public d() {
        }

        @Override // d.a.i0.h.o.e.InterfaceC1026e
        public void a(d.a.i0.a.l0.a aVar) {
            if (c.j) {
                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
            }
            synchronized (c.this.f47333b) {
                c.this.f47338g = true;
                c.this.w();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e(c cVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(AppRuntime.getAppContext(), g.aiapps_debug_game_core_package_error, 1).show();
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void onReady();
    }

    public static synchronized void C() {
        synchronized (c.class) {
            if (j) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (k == null) {
                return;
            }
            k.f47339h = true;
            if (k.f47336e != null) {
                k.f47336e.m();
            }
            k = null;
            m().y();
        }
    }

    public static c m() {
        if (k == null) {
            synchronized (c.class) {
                if (k == null) {
                    k = new c();
                }
            }
        }
        return k;
    }

    public final void A() {
        synchronized (this.f47333b) {
            if (!this.f47338g && this.f47336e == null) {
                K();
                J();
                String l = l();
                if (TextUtils.isEmpty(l) || this.f47339h) {
                    return;
                }
                if (j) {
                    Log.d("SwanGameCoreRuntime", "prepareMaster start: " + l);
                }
                d.a.i0.h.o.e eVar = new d.a.i0.h.o.e(l, "swan-game.js");
                this.f47336e = eVar;
                eVar.v(new d());
            }
        }
    }

    public void B(f fVar) {
        if (j) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (fVar != null && !this.f47337f.contains(fVar)) {
            this.f47337f.add(fVar);
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
                Log.d("SwanGameCoreRuntime", "setExtensionCore: " + this.f47335d);
            }
            this.f47335d = extensionCore;
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
        this.f47334c = swanCoreVersion;
        if (j) {
            Log.d("SwanGameCoreRuntime", "setSwanCoreVersion: " + this.f47334c);
        }
    }

    public void F(SwanAppActivity swanAppActivity) {
        d.a.i0.a.h0.g.g swanAppFragmentManager;
        if (swanAppActivity == null || swanAppActivity.isFinishing() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null) {
            return;
        }
        g.b h2 = swanAppFragmentManager.h();
        h2.n(0, 0);
        h2.f();
        h2.j(d.a.i0.h.n.a.s3());
        h2.b();
    }

    public void G(d.a.i0.a.f1.e.b bVar) {
        ExtensionCore extensionCore = this.f47335d;
        if (extensionCore != null) {
            bVar.B0(extensionCore);
        } else {
            this.f47335d = bVar.O();
        }
    }

    public void H() {
        d.a.i0.h.o.e eVar = this.f47336e;
        if (eVar != null) {
            eVar.o().E0();
        }
    }

    public void I(d.a.i0.a.f1.e.b bVar) {
        K();
        SwanCoreVersion swanCoreVersion = this.f47334c;
        if (swanCoreVersion != null) {
            bVar.X0(swanCoreVersion);
        }
        if (j) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.f47334c);
        }
    }

    public final void J() {
        ExtensionCore extensionCore = this.f47335d;
        if (extensionCore == null || !extensionCore.a()) {
            if (j) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            D(d.a.i0.a.p0.b.c(1));
        }
    }

    public final void K() {
        SwanCoreVersion swanCoreVersion = this.f47334c;
        if (swanCoreVersion == null || !swanCoreVersion.a()) {
            E(o());
        }
    }

    public void h(Activity activity) {
        d.a.i0.h.o.e eVar = this.f47336e;
        if (eVar != null) {
            eVar.k(activity);
        }
    }

    public void i(JSEvent jSEvent) {
        d.a.i0.h.o.e eVar = this.f47336e;
        if (eVar != null) {
            eVar.o().F(jSEvent);
        }
    }

    public int j() {
        d.a.i0.h.o.e eVar = this.f47336e;
        if (eVar != null) {
            return eVar.n();
        }
        return 0;
    }

    @Nullable
    public ExtensionCore k() {
        return this.f47335d;
    }

    public final String l() {
        SwanCoreVersion swanCoreVersion = this.f47334c;
        return (swanCoreVersion == null || !swanCoreVersion.a()) ? "" : this.f47334c.swanCorePath;
    }

    public d.a.i0.a.l0.a n() {
        d.a.i0.h.o.e eVar = this.f47336e;
        if (eVar != null) {
            return eVar.o();
        }
        return null;
    }

    public final SwanCoreVersion o() {
        if (d.a.i0.h.p.a.c.a(AsInstallService.SCHEME_PACKAGE_ADDED)) {
            if (TextUtils.isEmpty(this.f47340i)) {
                return null;
            }
            if (!new File(this.f47340i, "swan-game.js").exists()) {
                q0.b0(new e(this));
                return d.a.i0.a.m2.b.g(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.f47340i;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (!d.a.i0.h.p.a.c.a("normal") && !d.a.i0.a.u1.a.a.h()) {
            return d.a.i0.a.m2.b.g(1);
        } else {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = d.a.i0.h.p.a.b.b().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            if (j) {
                Log.d("SwanGameCoreRuntime", "getPreGameCoreVersion DebugSwanGameCoreMode");
            }
            return swanCoreVersion2;
        }
    }

    public final int p() {
        if (this.f47332a < 0) {
            d.a.i0.a.c1.a.Z().getSwitch("swan_game_preload", 0);
            this.f47332a = 0;
        }
        if (j) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.f47332a);
        }
        return this.f47332a;
    }

    public boolean q() {
        d.a.i0.a.c1.a.Z().getSwitch("swan_game_startup_improvement", false);
        if (j) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:false");
        }
        return false;
    }

    public DuMixGameSurfaceView r() {
        d.a.i0.h.o.e eVar = this.f47336e;
        if (eVar != null) {
            return eVar.p();
        }
        return null;
    }

    public SwanCoreVersion s() {
        return this.f47334c;
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
        synchronized (this.f47333b) {
            z = this.f47338g && this.f47336e != null;
        }
        return z;
    }

    public boolean v() {
        DuMixGameSurfaceView r;
        return (this.f47339h || (r = r()) == null || r.getParent() != null) ? false : true;
    }

    public final void w() {
        if (this.f47339h || this.f47337f.isEmpty() || !u()) {
            return;
        }
        for (f fVar : this.f47337f) {
            if (fVar != null) {
                fVar.onReady();
            }
        }
        this.f47337f.clear();
    }

    public void x(a.c cVar) {
        if (j) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (cVar == null || TextUtils.isEmpty(cVar.f47498a)) {
            return;
        }
        this.f47340i = cVar.f47498a;
        h.p("startup").A("preload", u() ? "1" : "0");
        h.p("startup").C(new UbcFlowEvent("na_prepare_runtime_start"));
        boolean b2 = d.a.i0.a.h2.d.c().b();
        boolean b3 = d.a.i0.a.h2.d.b();
        if (b2 && b3) {
            B(new C1025c(cVar));
            if (this.f47336e != null) {
                d.a.i0.h.y.e.b.b().f(this.f47336e.o(), cVar);
                return;
            }
            return;
        }
        if (d.a.i0.a.a2.e.i() != null) {
            d.a.i0.a.j2.p.d dVar = new d.a.i0.a.j2.p.d();
            dVar.q(d.a.i0.a.j2.k.m(1));
            dVar.r(d.a.i0.a.a2.e.i().N());
            dVar.l("gameCoreRuntime", "loadv8Failed");
            d.a.i0.a.j2.k.L(dVar);
        }
        q0.b0(new b(this));
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
            boolean b2 = d.a.i0.a.h2.d.c().b();
            boolean b3 = d.a.i0.a.h2.d.b();
            if (b2 && b3) {
                B(new a(this));
            }
        }
    }
}
