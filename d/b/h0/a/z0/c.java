package d.b.h0.a.z0;

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
import d.b.h0.a.i2.i0;
import d.b.h0.a.i2.j0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.p;
import d.b.h0.a.i2.p0;
import d.b.h0.a.k;
import d.b.h0.a.t.c.m.j;
import d.b.h0.a.t1.k.p0.g;
import d.b.h0.a.u0.d;
import d.b.h0.a.y0.e.b;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c extends d.b.h0.a.z0.b {
    public static final boolean l = k.f45772a;
    public Runnable k;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f47869e;

        public a(c cVar, long j) {
            this.f47869e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.g(this.f47869e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.u0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y0.e.b f47870a;

        /* loaded from: classes2.dex */
        public class a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f47872a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.g f47873b;

            public a(int i, d.g gVar) {
                this.f47872a = i;
                this.f47873b = gVar;
            }

            @Override // d.b.h0.a.t1.k.p0.g.d
            public void a(String str) {
                d.b.h0.a.c0.c.g("SwanApp", "download subpackage success");
                b bVar = b.this;
                c.this.Y(this.f47872a, bVar.f47870a, this.f47873b);
            }

            @Override // d.b.h0.a.t1.k.p0.g.d
            public void b(int i) {
                d.b.h0.a.c0.c.l("SwanApp", "download subpackage fail: " + i);
                b.this.f47870a.J0(null);
                b bVar = b.this;
                c.this.Y(this.f47872a, bVar.f47870a, this.f47873b);
                d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
                aVar.j(5L);
                aVar.h(38L);
                aVar.e("download subpackage fail, errcode=" + i);
                d.b.h0.a.z1.k.d dVar = new d.b.h0.a.z1.k.d();
                dVar.q(d.b.h0.a.z1.h.n(b.this.f47870a.F()));
                dVar.p(aVar);
                dVar.r(b.this.f47870a);
                d.b.h0.a.z1.h.H(dVar);
            }
        }

        public b(d.b.h0.a.y0.e.b bVar) {
            this.f47870a = bVar;
        }

        @Override // d.b.h0.a.u0.b
        public void a(int i, d.b.h0.a.u0.a aVar) {
            d.g gVar = (d.g) aVar;
            if (d.b.h0.a.t1.k.p0.g.d(this.f47870a, gVar)) {
                if (d.b.h0.a.r1.e.y() != null && !TextUtils.isEmpty(gVar.f47321a)) {
                    String d2 = i0.d(this.f47870a.b0());
                    if (!TextUtils.isEmpty(d2) && d2.startsWith(File.separator)) {
                        d2 = d2.substring(1);
                    }
                    String str = gVar.f47322b.f12283b.f12304c.get(d2);
                    d.b.h0.a.t1.k.p0.g.c(this.f47870a.G(), this.f47870a.n1(), str, gVar.f47322b.f12284c.f12306a.get(str), c.this.p(), new a(i, gVar));
                    return;
                }
                d.b.h0.a.c0.c.l("SwanApp", "subpackage is invalid");
            }
            c.this.Y(i, this.f47870a, gVar);
        }
    }

    /* renamed from: d.b.h0.a.z0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0923c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y0.e.b f47875e;

        public RunnableC0923c(c cVar, d.b.h0.a.y0.e.b bVar) {
            this.f47875e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.e.c(this.f47875e.G(), this.f47875e.n1());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y0.e.b f47876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.g f47877f;

        public d(d.b.h0.a.y0.e.b bVar, d.g gVar) {
            this.f47876e = bVar;
            this.f47877f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.Z(this.f47876e, this.f47877f);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y0.e.b f47879e;

        public e(c cVar, d.b.h0.a.y0.e.b bVar) {
            this.f47879e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String m = this.f47879e.m("fromHost");
            String m2 = this.f47879e.m("spuId");
            String m3 = this.f47879e.m("contentId");
            if (TextUtils.isEmpty(m) || TextUtils.isEmpty(m2) || TextUtils.isEmpty(m3) || !d.b.h0.a.w0.a.W().b(m, m2, m3)) {
                return;
            }
            this.f47879e.w("fromHost", null);
            this.f47879e.w("spuId", null);
            this.f47879e.w("contentId", null);
        }
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public SwanCoreVersion L() {
        return d.b.h0.a.e0.w.d.L().T();
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public void P() {
        super.P();
        d.b.h0.a.e0.v.b.b();
        d.b.h0.a.e0.w.d.t0(false);
        if (this.f47858a != null) {
            this.f47858a = null;
        }
        d.b.h0.a.i2.i.k();
        d.b.h0.a.b1.b.b();
        d.b.h0.a.b1.f.e.a.y();
        d.b.h0.a.c2.e.a.n();
        d.b.h0.a.c2.a.a.j();
        d.b.h0.a.c2.g.a.k();
        d.b.h0.a.q0.a.d();
        d.b.h0.a.f1.f.e().l();
        d.b.h0.a.t1.k.i0.a.h();
        d.b.h0.a.c2.b.d.i();
        d.b.h0.a.f1.e.k();
        if (d.b.h0.a.w0.a.w() != null) {
            d.b.h0.a.w0.a.w().c();
        }
        j.c().j();
        d.b.h0.a.x.a.b().f();
        d.b.h0.a.t1.k.g0.a.c().j();
        d.b.h0.a.s0.g.e.d();
    }

    public final void Y(int i, d.b.h0.a.y0.e.b bVar, d.g gVar) {
        if (i != 0 || bVar == null || gVar == null) {
            return;
        }
        d.b.h0.a.j1.i.n().A(new UbcFlowEvent("na_post_to_main_start"));
        k0.W(this.k);
        d dVar = new d(bVar, gVar);
        this.k = dVar;
        k0.Z(dVar);
    }

    public final void Z(d.b.h0.a.y0.e.b bVar, d.g gVar) {
        d.b.h0.a.j1.i.n().A(new UbcFlowEvent("na_post_to_main_end"));
        d.b.h0.a.y1.a.d().i("na_post_to_main_end");
        if (l) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.i) {
            if (l) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.f47321a + ", baseUrl:" + f.V().h())));
                return;
            }
            return;
        }
        this.f47860c = gVar.f47321a;
        b0(gVar.f47322b);
        if (bVar.i0()) {
            B(this.f47861d).setVisibility(0);
            d.b.h0.a.c0.a.b(true);
            d.b.h0.a.c0.c.g("AppsControllerImpl", "init sConsole for devHook");
        }
        d.b.h0.a.e0.w.d.L().F0(bVar, gVar);
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public void a() {
        super.a();
        d.b.h0.a.c0.c.g("SwanApp", "onAppForeground");
        String T = d.b.h0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onAppShow");
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, T);
        SwanAppActivity swanAppActivity = this.f47861d;
        if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
            hashMap.put("clkid", this.f47861d.getLaunchInfo().K());
            hashMap.put("scene", this.f47861d.getLaunchInfo().S());
            b.a launchInfo = this.f47861d.getLaunchInfo();
            d.b.h0.a.z1.e.s(launchInfo);
            a0(launchInfo);
        }
        N(new d.b.h0.a.k0.b.c(hashMap));
        d.b.h0.a.c0.c.g("SwanApp", "onAppShow");
        d.b.h0.a.x.a.b().g(false);
        d.b.h0.a.b1.b.h(true);
        d.b.h0.a.b1.f.e.a.r(false);
        d.b.h0.a.f1.f.e().h(false);
        j.c().f();
        d.b.h0.a.f1.e.i();
        if (d.b.h0.a.w0.a.w() != null) {
            d.b.h0.a.w0.a.w().a();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (d.b.h0.a.j1.m.c.e()) {
            p.k(new a(this, currentTimeMillis), "saveSwanAppForeGroundTime");
        } else {
            j0.g(currentTimeMillis);
        }
    }

    public final void a0(d.b.h0.a.y0.e.b bVar) {
        if (TextUtils.isEmpty(bVar.m("fromHost")) || TextUtils.isEmpty(bVar.m("spuId")) || TextUtils.isEmpty(bVar.m("contentId"))) {
            return;
        }
        k0.U(new e(this, bVar), 2000L);
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public void b() {
        super.b();
        d.b.h0.a.c0.c.g("SwanApp", "onAppBackground");
        String T = d.b.h0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("lcType", "onAppHide");
        contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, T);
        contentValues.put("hiddenType", Integer.valueOf(p0.b().a()));
        N(new d.b.h0.a.k0.b.c(contentValues));
        d.b.h0.a.c0.c.g("SwanApp", "onAppHide");
        p0.b().d();
        d.b.h0.a.x.a.b().g(true);
        d.b.h0.a.b1.b.h(false);
        d.b.h0.a.b1.f.e.a.r(true);
        d.b.h0.a.f1.f.e().h(true);
        d.b.h0.a.f1.e.j(false);
        if (d.b.h0.a.w0.a.w() != null) {
            d.b.h0.a.w0.a.w().g();
            d.b.h0.a.w0.a.w().b(false);
        }
        j0.h();
        d.b.h0.a.d1.a.h();
    }

    public final void b0(SwanAppConfigData swanAppConfigData) {
        d.b.h0.a.r1.d e2 = d.b.h0.a.r1.d.e();
        if (e2.x()) {
            e2.s().o0(swanAppConfigData);
        }
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public void g(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2) {
        super.g(bVar, bVar2);
        if (l) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.f0());
        }
        d.b.h0.a.e0.w.d.L().H0(bVar);
        d.b.h0.a.e0.w.d.L().o0(null);
        SwanAppConfigData D = d.b.h0.a.r1.d.e().s().D();
        if (D != null) {
            d.g gVar = new d.g();
            ExecutorUtilsExt.postOnElastic(new RunnableC0923c(this, bVar), "deleteLowerVersionFolder", 3);
            gVar.f47322b = D;
            gVar.f47321a = d.e.h(bVar.G(), bVar.n1()).getPath() + File.separator;
            d.b.h0.a.j1.i.n().A(new UbcFlowEvent("na_post_to_main_start"));
            d.b.h0.a.y1.a.d().i("na_post_to_main_start");
            Z(bVar, gVar);
        }
    }

    @Override // d.b.h0.a.z0.d
    public boolean s() {
        long T = f.V().T();
        if (l) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + T);
        }
        return this.f47865h && T <= 0;
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    @Nullable
    public d.b.h0.a.r1.e t() {
        return d.b.h0.a.r1.e.y();
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public void u(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2) {
        super.u(bVar, bVar2);
        if (l) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.f0());
        }
        d.b.h0.a.u0.d.c(bVar, new b(bVar));
        d.b.h0.a.e0.w.d.L().H0(bVar);
        d.b.h0.a.e0.w.d.L().G0(bVar);
        d.b.h0.a.e0.w.d.L().o0(null);
    }
}
