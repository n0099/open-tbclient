package d.a.h0.a.z0;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.j0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.i2.p0;
import d.a.h0.a.k;
import d.a.h0.a.t.c.m.j;
import d.a.h0.a.t1.k.p0.g;
import d.a.h0.a.u0.d;
import d.a.h0.a.y0.e.b;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c extends d.a.h0.a.z0.b {
    public static final boolean l = k.f43101a;
    public Runnable k;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f45305e;

        public a(c cVar, long j) {
            this.f45305e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.g(this.f45305e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.u0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f45306a;

        /* loaded from: classes2.dex */
        public class a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f45308a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.g f45309b;

            public a(int i2, d.g gVar) {
                this.f45308a = i2;
                this.f45309b = gVar;
            }

            @Override // d.a.h0.a.t1.k.p0.g.d
            public void a(String str) {
                d.a.h0.a.c0.c.g("SwanApp", "download subpackage success");
                b bVar = b.this;
                c.this.Y(this.f45308a, bVar.f45306a, this.f45309b);
            }

            @Override // d.a.h0.a.t1.k.p0.g.d
            public void b(int i2) {
                d.a.h0.a.c0.c.l("SwanApp", "download subpackage fail: " + i2);
                b.this.f45306a.J0(null);
                b bVar = b.this;
                c.this.Y(this.f45308a, bVar.f45306a, this.f45309b);
                d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
                aVar.j(5L);
                aVar.h(38L);
                aVar.e("download subpackage fail, errcode=" + i2);
                d.a.h0.a.z1.k.d dVar = new d.a.h0.a.z1.k.d();
                dVar.q(d.a.h0.a.z1.h.n(b.this.f45306a.F()));
                dVar.p(aVar);
                dVar.r(b.this.f45306a);
                d.a.h0.a.z1.h.H(dVar);
            }
        }

        public b(d.a.h0.a.y0.e.b bVar) {
            this.f45306a = bVar;
        }

        @Override // d.a.h0.a.u0.b
        public void a(int i2, d.a.h0.a.u0.a aVar) {
            d.g gVar = (d.g) aVar;
            if (d.a.h0.a.t1.k.p0.g.d(this.f45306a, gVar)) {
                if (d.a.h0.a.r1.e.h() != null && !TextUtils.isEmpty(gVar.f44732a)) {
                    String d2 = i0.d(this.f45306a.b0());
                    if (!TextUtils.isEmpty(d2) && d2.startsWith(File.separator)) {
                        d2 = d2.substring(1);
                    }
                    String str = gVar.f44733b.f12153b.f12175c.get(d2);
                    d.a.h0.a.t1.k.p0.g.c(this.f45306a.G(), this.f45306a.n1(), str, gVar.f44733b.f12154c.f12177a.get(str), c.this.D(), new a(i2, gVar));
                    return;
                }
                d.a.h0.a.c0.c.l("SwanApp", "subpackage is invalid");
            }
            c.this.Y(i2, this.f45306a, gVar);
        }
    }

    /* renamed from: d.a.h0.a.z0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0862c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f45311e;

        public RunnableC0862c(c cVar, d.a.h0.a.y0.e.b bVar) {
            this.f45311e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.e.c(this.f45311e.G(), this.f45311e.n1());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f45312e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.g f45313f;

        public d(d.a.h0.a.y0.e.b bVar, d.g gVar) {
            this.f45312e = bVar;
            this.f45313f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.Z(this.f45312e, this.f45313f);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f45315e;

        public e(c cVar, d.a.h0.a.y0.e.b bVar) {
            this.f45315e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String m = this.f45315e.m("fromHost");
            String m2 = this.f45315e.m("spuId");
            String m3 = this.f45315e.m("contentId");
            if (TextUtils.isEmpty(m) || TextUtils.isEmpty(m2) || TextUtils.isEmpty(m3) || !d.a.h0.a.w0.a.W().a(m, m2, m3)) {
                return;
            }
            this.f45315e.w("fromHost", null);
            this.f45315e.w("spuId", null);
            this.f45315e.w("contentId", null);
        }
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    @Nullable
    public d.a.h0.a.r1.e F() {
        return d.a.h0.a.r1.e.h();
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public void G(d.a.h0.a.y0.e.b bVar, d.a.h0.a.u0.b bVar2) {
        super.G(bVar, bVar2);
        if (l) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.f0());
        }
        d.a.h0.a.u0.d.c(bVar, new b(bVar));
        d.a.h0.a.e0.w.d.L().H0(bVar);
        d.a.h0.a.e0.w.d.L().G0(bVar);
        d.a.h0.a.e0.w.d.L().o0(null);
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public SwanCoreVersion N() {
        return d.a.h0.a.e0.w.d.L().T();
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public void P() {
        super.P();
        d.a.h0.a.e0.v.b.b();
        d.a.h0.a.e0.w.d.t0(false);
        if (this.f45293a != null) {
            this.f45293a = null;
        }
        d.a.h0.a.i2.i.k();
        d.a.h0.a.b1.b.b();
        d.a.h0.a.b1.f.e.a.y();
        d.a.h0.a.c2.e.a.n();
        d.a.h0.a.c2.a.a.j();
        d.a.h0.a.c2.g.a.k();
        d.a.h0.a.q0.a.d();
        d.a.h0.a.f1.f.e().l();
        d.a.h0.a.t1.k.i0.a.h();
        d.a.h0.a.c2.b.d.i();
        d.a.h0.a.f1.e.k();
        if (d.a.h0.a.w0.a.w() != null) {
            d.a.h0.a.w0.a.w().f();
        }
        j.c().j();
        d.a.h0.a.x.a.b().f();
        d.a.h0.a.t1.k.g0.a.c().j();
        d.a.h0.a.s0.g.e.d();
    }

    public final void Y(int i2, d.a.h0.a.y0.e.b bVar, d.g gVar) {
        if (i2 != 0 || bVar == null || gVar == null) {
            return;
        }
        d.a.h0.a.j1.i.n().A(new UbcFlowEvent("na_post_to_main_start"));
        k0.W(this.k);
        d dVar = new d(bVar, gVar);
        this.k = dVar;
        k0.Z(dVar);
    }

    public final void Z(d.a.h0.a.y0.e.b bVar, d.g gVar) {
        d.a.h0.a.j1.i.n().A(new UbcFlowEvent("na_post_to_main_end"));
        d.a.h0.a.y1.a.d().i("na_post_to_main_end");
        if (l) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.f45301i) {
            if (l) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.f44732a + ", baseUrl:" + f.V().A())));
                return;
            }
            return;
        }
        this.f45295c = gVar.f44732a;
        b0(gVar.f44733b);
        if (bVar.i0()) {
            p(this.f45296d).setVisibility(0);
            d.a.h0.a.c0.a.b(true);
            d.a.h0.a.c0.c.g("AppsControllerImpl", "init sConsole for devHook");
        }
        d.a.h0.a.e0.w.d.L().F0(bVar, gVar);
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public void a() {
        super.a();
        d.a.h0.a.c0.c.g("SwanApp", "onAppForeground");
        String T = d.a.h0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onAppShow");
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, T);
        SwanAppActivity swanAppActivity = this.f45296d;
        if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
            hashMap.put("clkid", this.f45296d.getLaunchInfo().K());
            hashMap.put("scene", this.f45296d.getLaunchInfo().S());
            b.a launchInfo = this.f45296d.getLaunchInfo();
            d.a.h0.a.z1.e.s(launchInfo);
            a0(launchInfo);
        }
        x(new d.a.h0.a.k0.b.c(hashMap));
        d.a.h0.a.c0.c.g("SwanApp", "onAppShow");
        d.a.h0.a.x.a.b().g(false);
        d.a.h0.a.b1.b.h(true);
        d.a.h0.a.b1.f.e.a.r(false);
        d.a.h0.a.f1.f.e().h(false);
        j.c().f();
        d.a.h0.a.f1.e.i();
        if (d.a.h0.a.w0.a.w() != null) {
            d.a.h0.a.w0.a.w().a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (d.a.h0.a.j1.m.c.e()) {
            p.k(new a(this, currentTimeMillis), "saveSwanAppForeGroundTime");
        } else {
            j0.g(currentTimeMillis);
        }
    }

    public final void a0(d.a.h0.a.y0.e.b bVar) {
        if (TextUtils.isEmpty(bVar.m("fromHost")) || TextUtils.isEmpty(bVar.m("spuId")) || TextUtils.isEmpty(bVar.m("contentId"))) {
            return;
        }
        k0.U(new e(this, bVar), 2000L);
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public void b() {
        super.b();
        d.a.h0.a.c0.c.g("SwanApp", "onAppBackground");
        String T = d.a.h0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("lcType", "onAppHide");
        contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, T);
        contentValues.put("hiddenType", Integer.valueOf(p0.b().a()));
        x(new d.a.h0.a.k0.b.c(contentValues));
        d.a.h0.a.c0.c.g("SwanApp", "onAppHide");
        p0.b().d();
        d.a.h0.a.x.a.b().g(true);
        d.a.h0.a.b1.b.h(false);
        d.a.h0.a.b1.f.e.a.r(true);
        d.a.h0.a.f1.f.e().h(true);
        d.a.h0.a.f1.e.j(false);
        if (d.a.h0.a.w0.a.w() != null) {
            d.a.h0.a.w0.a.w().c();
            d.a.h0.a.w0.a.w().e(false);
        }
        j0.h();
        d.a.h0.a.d1.a.h();
    }

    public final void b0(SwanAppConfigData swanAppConfigData) {
        d.a.h0.a.r1.d e2 = d.a.h0.a.r1.d.e();
        if (e2.z()) {
            e2.p().o0(swanAppConfigData);
        }
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public void e(d.a.h0.a.y0.e.b bVar, d.a.h0.a.u0.b bVar2) {
        super.e(bVar, bVar2);
        if (l) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.f0());
        }
        d.a.h0.a.e0.w.d.L().H0(bVar);
        d.a.h0.a.e0.w.d.L().o0(null);
        SwanAppConfigData D = d.a.h0.a.r1.d.e().p().D();
        if (D != null) {
            d.g gVar = new d.g();
            ExecutorUtilsExt.postOnElastic(new RunnableC0862c(this, bVar), "deleteLowerVersionFolder", 3);
            gVar.f44733b = D;
            gVar.f44732a = d.e.h(bVar.G(), bVar.n1()).getPath() + File.separator;
            d.a.h0.a.j1.i.n().A(new UbcFlowEvent("na_post_to_main_start"));
            d.a.h0.a.y1.a.d().i("na_post_to_main_start");
            Z(bVar, gVar);
        }
    }

    @Override // d.a.h0.a.z0.d
    public boolean l() {
        long T = f.V().T();
        if (l) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + T);
        }
        return this.f45300h && T <= 0;
    }
}
