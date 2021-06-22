package d.a.m0.a.g1;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.m0.a.a1.e;
import d.a.m0.a.c2.f.p0.g;
import d.a.m0.a.c2.f.p0.j;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.k;
import d.a.m0.a.v2.o0;
import d.a.m0.a.v2.p0;
import d.a.m0.a.v2.q;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.x0;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class c extends d.a.m0.a.g1.b {
    public static final boolean l = k.f46983a;
    public Runnable k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f45685e;

        public a(c cVar, long j) {
            this.f45685e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.g(this.f45685e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.a1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f45686a;

        /* loaded from: classes3.dex */
        public class a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f45688a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e.g f45689b;

            public a(int i2, e.g gVar) {
                this.f45688a = i2;
                this.f45689b = gVar;
            }

            @Override // d.a.m0.a.c2.f.p0.g.d
            public void a(String str) {
                d.a.m0.a.e0.d.g("SwanApp", "download subpackage success");
                b bVar = b.this;
                c.this.Y(this.f45688a, bVar.f45686a, this.f45689b);
            }

            @Override // d.a.m0.a.c2.f.p0.g.d
            public void b(int i2) {
                d.a.m0.a.e0.d.l("SwanApp", "download subpackage fail: " + i2);
                b.this.f45686a.Q0(null);
                b bVar = b.this;
                c.this.Y(this.f45688a, bVar.f45686a, this.f45689b);
                d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
                aVar.j(5L);
                aVar.h(38L);
                aVar.e("download subpackage fail, errcode=" + i2);
                d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
                dVar.q(d.a.m0.a.j2.k.m(b.this.f45686a.G()));
                dVar.p(aVar);
                dVar.r(b.this.f45686a);
                d.a.m0.a.j2.k.L(dVar);
            }
        }

        public b(d.a.m0.a.f1.e.b bVar) {
            this.f45686a = bVar;
        }

        @Override // d.a.m0.a.a1.b
        public void a(int i2, d.a.m0.a.a1.a aVar) {
            e.g gVar = (e.g) aVar;
            if (d.a.m0.a.c2.f.p0.g.o(this.f45686a, gVar)) {
                if (d.a.m0.a.a2.e.i() != null && !TextUtils.isEmpty(gVar.f44475a)) {
                    String f2 = o0.f(this.f45686a.e0());
                    if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                        f2 = f2.substring(1);
                    }
                    String str = gVar.f44476b.f11391c.f11426c.get(j.b(f2));
                    d.a.m0.a.c2.f.p0.g.l(this.f45686a.H(), this.f45686a.u1(), "3", str, gVar.f44476b.f11392d.f11430a.get(str), c.this.D(), new a(i2, gVar));
                    return;
                }
                d.a.m0.a.e0.d.l("SwanApp", "subpackage is invalid");
            }
            c.this.Y(i2, this.f45686a, gVar);
        }
    }

    /* renamed from: d.a.m0.a.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0699c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f45691e;

        public RunnableC0699c(c cVar, d.a.m0.a.f1.e.b bVar) {
            this.f45691e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.C0620e.c(this.f45691e.H(), this.f45691e.u1());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f45692e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.g f45693f;

        public d(d.a.m0.a.f1.e.b bVar, e.g gVar) {
            this.f45692e = bVar;
            this.f45693f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.Z(this.f45692e, this.f45693f);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f45695e;

        public e(c cVar, d.a.m0.a.f1.e.b bVar) {
            this.f45695e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String n = this.f45695e.n("fromHost");
            String n2 = this.f45695e.n("spuId");
            String n3 = this.f45695e.n("contentId");
            if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !d.a.m0.a.c1.a.j0().a(n, n2, n3)) {
                return;
            }
            this.f45695e.y("fromHost", null);
            this.f45695e.y("spuId", null);
            this.f45695e.y("contentId", null);
        }
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    @Nullable
    public d.a.m0.a.a2.e F() {
        return d.a.m0.a.a2.e.i();
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public void G(d.a.m0.a.f1.e.b bVar, d.a.m0.a.a1.b bVar2) {
        super.G(bVar, bVar2);
        if (l) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.i0());
        }
        d.a.m0.a.a1.e.c(bVar, new b(bVar));
        d.a.m0.a.h0.u.g.N().O0(bVar);
        d.a.m0.a.h0.u.g.N().N0(bVar);
        d.a.m0.a.h0.u.g.N().v0(null);
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public SwanCoreVersion N() {
        return d.a.m0.a.h0.u.g.N().V();
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public void P() {
        super.P();
        d.a.m0.a.h0.t.a.d();
        d.a.m0.a.h0.u.g.A0(false);
        if (this.f45673a != null) {
            this.f45673a = null;
        }
        d.a.m0.a.v2.j.h();
        d.a.m0.a.i1.b.b();
        d.a.m0.a.i1.f.e.a.y();
        d.a.m0.a.n2.d.a.a.b();
        d.a.m0.a.n2.f.a.n();
        d.a.m0.a.n2.a.a.d();
        d.a.m0.a.n2.i.a.k();
        d.a.m0.a.v0.a.d();
        d.a.m0.a.m1.g.f().q();
        d.a.m0.a.c2.f.i0.a.h();
        d.a.m0.a.n2.b.d.i();
        d.a.m0.a.m1.f.k();
        if (d.a.m0.a.c1.a.E() != null) {
            d.a.m0.a.c1.a.E().e();
        }
        d.a.m0.a.u.e.o.k.e().m();
        d.a.m0.a.z.a.b().f();
        d.a.m0.a.c2.f.g0.d.b().k();
        d.a.m0.a.y0.g.e.d();
        d.a.m0.a.u.f.a.d().h();
        d.a.m0.a.l1.d.d.f().e();
        d.a.m0.a.l0.o.a.m();
        d.a.m0.a.h0.u.b.b();
        if (d.a.m0.a.r1.l.e.g()) {
            d.a.m0.a.f1.c.b.c().a();
            d.a.m0.a.r1.r.a.f().b();
        }
        SwanPrefetchImageRes.b().e();
    }

    public final void Y(int i2, d.a.m0.a.f1.e.b bVar, e.g gVar) {
        if (i2 != 0 || bVar == null || gVar == null) {
            return;
        }
        d.a.m0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_start"));
        q0.a0(this.k);
        d dVar = new d(bVar, gVar);
        this.k = dVar;
        q0.d0(dVar);
    }

    public final void Z(d.a.m0.a.f1.e.b bVar, e.g gVar) {
        d.a.m0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_end"));
        d.a.m0.a.i2.a.d().i("na_post_to_main_end");
        if (l) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.f45681i) {
            if (l) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.f44475a + ", baseUrl:" + f.V().A())));
                return;
            }
            return;
        }
        this.f45675c = gVar.f44475a;
        b0(gVar.f44476b);
        if (bVar.l0()) {
            n(this.f45676d).setVisibility(0);
            d.a.m0.a.e0.a.b(true);
            d.a.m0.a.e0.d.g("AppsControllerImpl", "init sConsole for devHook");
        }
        d.a.m0.a.h0.u.g.N().M0(bVar, gVar);
    }

    public final void a0(d.a.m0.a.f1.e.b bVar) {
        if (TextUtils.isEmpty(bVar.n("fromHost")) || TextUtils.isEmpty(bVar.n("spuId")) || TextUtils.isEmpty(bVar.n("contentId"))) {
            return;
        }
        q0.Y(new e(this, bVar), 2000L);
    }

    public final void b0(SwanAppConfigData swanAppConfigData) {
        d.a.m0.a.a2.d g2 = d.a.m0.a.a2.d.g();
        if (g2.C()) {
            g2.r().t0(swanAppConfigData);
        }
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public void c(d.a.m0.a.f1.e.b bVar, d.a.m0.a.a1.b bVar2) {
        super.c(bVar, bVar2);
        if (l) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.i0());
        }
        d.a.m0.a.h0.u.g.N().O0(bVar);
        d.a.m0.a.h0.u.g.N().v0(null);
        SwanAppConfigData F = d.a.m0.a.a2.d.g().r().F();
        if (F != null) {
            e.g gVar = new e.g();
            d.a.m0.a.r1.k.i.c.f().e(new RunnableC0699c(this, bVar), "deleteLowerVersionFolder");
            gVar.f44476b = F;
            gVar.f44475a = e.C0620e.i(bVar.H(), bVar.u1()).getPath() + File.separator;
            d.a.m0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_start"));
            d.a.m0.a.i2.a.d().i("na_post_to_main_start");
            Z(bVar, gVar);
        }
    }

    @Override // d.a.m0.a.g1.d
    public boolean j() {
        long T = f.V().T();
        if (l) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + T);
        }
        return this.f45680h && T <= 0;
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public void w() {
        super.w();
        d.a.m0.a.e0.d.g("SwanApp", "onAppForeground");
        String V = d.a.m0.a.a2.e.V();
        if (TextUtils.isEmpty(V)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onAppShow");
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, V);
        SwanAppActivity swanAppActivity = this.f45676d;
        if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
            hashMap.put("clkid", this.f45676d.getLaunchInfo().L());
            hashMap.put("scene", this.f45676d.getLaunchInfo().T());
            b.a launchInfo = this.f45676d.getLaunchInfo();
            d.a.m0.a.j2.e.v(launchInfo);
            a0(launchInfo);
        }
        v(new d.a.m0.a.o0.d.c(hashMap));
        d.a.m0.a.e0.d.g("SwanApp", "onAppShow");
        d.a.m0.a.z.a.b().g(false);
        d.a.m0.a.i1.b.h(true);
        d.a.m0.a.i1.f.e.a.r(false);
        d.a.m0.a.m1.g.f().j(false);
        d.a.m0.a.u.e.o.k.e().i();
        d.a.m0.a.m1.f.i();
        if (d.a.m0.a.c1.a.E() != null) {
            d.a.m0.a.c1.a.E().a();
        }
        a aVar = new a(this, System.currentTimeMillis());
        if (d.a.m0.a.r1.l.e.l()) {
            d.a.m0.a.r1.k.i.b.e().f(aVar, "saveSwanAppForeGroundTime");
        } else {
            q.j(aVar, "saveSwanAppForeGroundTime");
        }
        d.a.m0.a.l0.o.a.l();
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public void x() {
        super.x();
        d.a.m0.a.e0.d.g("SwanApp", "onAppBackground");
        String V = d.a.m0.a.a2.e.V();
        if (TextUtils.isEmpty(V)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("lcType", "onAppHide");
        contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, V);
        contentValues.put("hiddenType", Integer.valueOf(x0.b().a()));
        v(new d.a.m0.a.o0.d.c(contentValues));
        d.a.m0.a.e0.d.g("SwanApp", "onAppHide");
        x0.b().d();
        d.a.m0.a.z.a.b().g(true);
        d.a.m0.a.i1.b.h(false);
        d.a.m0.a.i1.f.e.a.r(true);
        d.a.m0.a.m1.g.f().j(true);
        d.a.m0.a.m1.f.j(false);
        if (d.a.m0.a.c1.a.E() != null) {
            d.a.m0.a.c1.a.E().c();
        }
        p0.h();
        d.a.m0.a.k1.a.i();
        d.a.m0.a.l0.o.a.k();
    }
}
