package d.a.i0.a.g1;

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
import d.a.i0.a.a1.e;
import d.a.i0.a.c2.f.p0.g;
import d.a.i0.a.c2.f.p0.j;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.k;
import d.a.i0.a.v2.o0;
import d.a.i0.a.v2.p0;
import d.a.i0.a.v2.q;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.x0;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class c extends d.a.i0.a.g1.b {
    public static final boolean l = k.f43025a;
    public Runnable k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f41727e;

        public a(c cVar, long j) {
            this.f41727e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.g(this.f41727e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.a1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f41728a;

        /* loaded from: classes3.dex */
        public class a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f41730a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e.g f41731b;

            public a(int i2, e.g gVar) {
                this.f41730a = i2;
                this.f41731b = gVar;
            }

            @Override // d.a.i0.a.c2.f.p0.g.d
            public void a(String str) {
                d.a.i0.a.e0.d.g("SwanApp", "download subpackage success");
                b bVar = b.this;
                c.this.Y(this.f41730a, bVar.f41728a, this.f41731b);
            }

            @Override // d.a.i0.a.c2.f.p0.g.d
            public void b(int i2) {
                d.a.i0.a.e0.d.l("SwanApp", "download subpackage fail: " + i2);
                b.this.f41728a.Q0(null);
                b bVar = b.this;
                c.this.Y(this.f41730a, bVar.f41728a, this.f41731b);
                d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
                aVar.j(5L);
                aVar.h(38L);
                aVar.e("download subpackage fail, errcode=" + i2);
                d.a.i0.a.j2.p.d dVar = new d.a.i0.a.j2.p.d();
                dVar.q(d.a.i0.a.j2.k.m(b.this.f41728a.G()));
                dVar.p(aVar);
                dVar.r(b.this.f41728a);
                d.a.i0.a.j2.k.L(dVar);
            }
        }

        public b(d.a.i0.a.f1.e.b bVar) {
            this.f41728a = bVar;
        }

        @Override // d.a.i0.a.a1.b
        public void a(int i2, d.a.i0.a.a1.a aVar) {
            e.g gVar = (e.g) aVar;
            if (d.a.i0.a.c2.f.p0.g.o(this.f41728a, gVar)) {
                if (d.a.i0.a.a2.e.i() != null && !TextUtils.isEmpty(gVar.f40517a)) {
                    String f2 = o0.f(this.f41728a.e0());
                    if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                        f2 = f2.substring(1);
                    }
                    String str = gVar.f40518b.f11346c.f11381c.get(j.b(f2));
                    d.a.i0.a.c2.f.p0.g.l(this.f41728a.H(), this.f41728a.u1(), "3", str, gVar.f40518b.f11347d.f11385a.get(str), c.this.D(), new a(i2, gVar));
                    return;
                }
                d.a.i0.a.e0.d.l("SwanApp", "subpackage is invalid");
            }
            c.this.Y(i2, this.f41728a, gVar);
        }
    }

    /* renamed from: d.a.i0.a.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0629c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f41733e;

        public RunnableC0629c(c cVar, d.a.i0.a.f1.e.b bVar) {
            this.f41733e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.C0550e.c(this.f41733e.H(), this.f41733e.u1());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f41734e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e.g f41735f;

        public d(d.a.i0.a.f1.e.b bVar, e.g gVar) {
            this.f41734e = bVar;
            this.f41735f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.Z(this.f41734e, this.f41735f);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f41737e;

        public e(c cVar, d.a.i0.a.f1.e.b bVar) {
            this.f41737e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String n = this.f41737e.n("fromHost");
            String n2 = this.f41737e.n("spuId");
            String n3 = this.f41737e.n("contentId");
            if (TextUtils.isEmpty(n) || TextUtils.isEmpty(n2) || TextUtils.isEmpty(n3) || !d.a.i0.a.c1.a.j0().a(n, n2, n3)) {
                return;
            }
            this.f41737e.y("fromHost", null);
            this.f41737e.y("spuId", null);
            this.f41737e.y("contentId", null);
        }
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    @Nullable
    public d.a.i0.a.a2.e F() {
        return d.a.i0.a.a2.e.i();
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public void G(d.a.i0.a.f1.e.b bVar, d.a.i0.a.a1.b bVar2) {
        super.G(bVar, bVar2);
        if (l) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.i0());
        }
        d.a.i0.a.a1.e.c(bVar, new b(bVar));
        d.a.i0.a.h0.u.g.N().O0(bVar);
        d.a.i0.a.h0.u.g.N().N0(bVar);
        d.a.i0.a.h0.u.g.N().v0(null);
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public SwanCoreVersion N() {
        return d.a.i0.a.h0.u.g.N().V();
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public void P() {
        super.P();
        d.a.i0.a.h0.t.a.d();
        d.a.i0.a.h0.u.g.A0(false);
        if (this.f41715a != null) {
            this.f41715a = null;
        }
        d.a.i0.a.v2.j.h();
        d.a.i0.a.i1.b.b();
        d.a.i0.a.i1.f.e.a.y();
        d.a.i0.a.n2.d.a.a.b();
        d.a.i0.a.n2.f.a.n();
        d.a.i0.a.n2.a.a.d();
        d.a.i0.a.n2.i.a.k();
        d.a.i0.a.v0.a.d();
        d.a.i0.a.m1.g.f().q();
        d.a.i0.a.c2.f.i0.a.h();
        d.a.i0.a.n2.b.d.i();
        d.a.i0.a.m1.f.k();
        if (d.a.i0.a.c1.a.E() != null) {
            d.a.i0.a.c1.a.E().e();
        }
        d.a.i0.a.u.e.o.k.e().m();
        d.a.i0.a.z.a.b().f();
        d.a.i0.a.c2.f.g0.d.b().k();
        d.a.i0.a.y0.g.e.d();
        d.a.i0.a.u.f.a.d().h();
        d.a.i0.a.l1.d.d.f().e();
        d.a.i0.a.l0.o.a.m();
        d.a.i0.a.h0.u.b.b();
        if (d.a.i0.a.r1.l.e.g()) {
            d.a.i0.a.f1.c.b.c().a();
            d.a.i0.a.r1.r.a.f().b();
        }
        SwanPrefetchImageRes.b().e();
    }

    public final void Y(int i2, d.a.i0.a.f1.e.b bVar, e.g gVar) {
        if (i2 != 0 || bVar == null || gVar == null) {
            return;
        }
        d.a.i0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_start"));
        q0.a0(this.k);
        d dVar = new d(bVar, gVar);
        this.k = dVar;
        q0.d0(dVar);
    }

    public final void Z(d.a.i0.a.f1.e.b bVar, e.g gVar) {
        d.a.i0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_end"));
        d.a.i0.a.i2.a.d().i("na_post_to_main_end");
        if (l) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.f41723i) {
            if (l) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.f40517a + ", baseUrl:" + f.V().A())));
                return;
            }
            return;
        }
        this.f41717c = gVar.f40517a;
        b0(gVar.f40518b);
        if (bVar.l0()) {
            n(this.f41718d).setVisibility(0);
            d.a.i0.a.e0.a.b(true);
            d.a.i0.a.e0.d.g("AppsControllerImpl", "init sConsole for devHook");
        }
        d.a.i0.a.h0.u.g.N().M0(bVar, gVar);
    }

    public final void a0(d.a.i0.a.f1.e.b bVar) {
        if (TextUtils.isEmpty(bVar.n("fromHost")) || TextUtils.isEmpty(bVar.n("spuId")) || TextUtils.isEmpty(bVar.n("contentId"))) {
            return;
        }
        q0.Y(new e(this, bVar), 2000L);
    }

    public final void b0(SwanAppConfigData swanAppConfigData) {
        d.a.i0.a.a2.d g2 = d.a.i0.a.a2.d.g();
        if (g2.C()) {
            g2.r().t0(swanAppConfigData);
        }
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public void c(d.a.i0.a.f1.e.b bVar, d.a.i0.a.a1.b bVar2) {
        super.c(bVar, bVar2);
        if (l) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.i0());
        }
        d.a.i0.a.h0.u.g.N().O0(bVar);
        d.a.i0.a.h0.u.g.N().v0(null);
        SwanAppConfigData F = d.a.i0.a.a2.d.g().r().F();
        if (F != null) {
            e.g gVar = new e.g();
            d.a.i0.a.r1.k.i.c.f().e(new RunnableC0629c(this, bVar), "deleteLowerVersionFolder");
            gVar.f40518b = F;
            gVar.f40517a = e.C0550e.i(bVar.H(), bVar.u1()).getPath() + File.separator;
            d.a.i0.a.r1.h.o().C(new UbcFlowEvent("na_post_to_main_start"));
            d.a.i0.a.i2.a.d().i("na_post_to_main_start");
            Z(bVar, gVar);
        }
    }

    @Override // d.a.i0.a.g1.d
    public boolean j() {
        long T = f.V().T();
        if (l) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + T);
        }
        return this.f41722h && T <= 0;
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public void w() {
        super.w();
        d.a.i0.a.e0.d.g("SwanApp", "onAppForeground");
        String V = d.a.i0.a.a2.e.V();
        if (TextUtils.isEmpty(V)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onAppShow");
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, V);
        SwanAppActivity swanAppActivity = this.f41718d;
        if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
            hashMap.put("clkid", this.f41718d.getLaunchInfo().L());
            hashMap.put("scene", this.f41718d.getLaunchInfo().T());
            b.a launchInfo = this.f41718d.getLaunchInfo();
            d.a.i0.a.j2.e.v(launchInfo);
            a0(launchInfo);
        }
        v(new d.a.i0.a.o0.d.c(hashMap));
        d.a.i0.a.e0.d.g("SwanApp", "onAppShow");
        d.a.i0.a.z.a.b().g(false);
        d.a.i0.a.i1.b.h(true);
        d.a.i0.a.i1.f.e.a.r(false);
        d.a.i0.a.m1.g.f().j(false);
        d.a.i0.a.u.e.o.k.e().i();
        d.a.i0.a.m1.f.i();
        if (d.a.i0.a.c1.a.E() != null) {
            d.a.i0.a.c1.a.E().a();
        }
        a aVar = new a(this, System.currentTimeMillis());
        if (d.a.i0.a.r1.l.e.l()) {
            d.a.i0.a.r1.k.i.b.e().f(aVar, "saveSwanAppForeGroundTime");
        } else {
            q.j(aVar, "saveSwanAppForeGroundTime");
        }
        d.a.i0.a.l0.o.a.l();
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public void x() {
        super.x();
        d.a.i0.a.e0.d.g("SwanApp", "onAppBackground");
        String V = d.a.i0.a.a2.e.V();
        if (TextUtils.isEmpty(V)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("lcType", "onAppHide");
        contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, V);
        contentValues.put("hiddenType", Integer.valueOf(x0.b().a()));
        v(new d.a.i0.a.o0.d.c(contentValues));
        d.a.i0.a.e0.d.g("SwanApp", "onAppHide");
        x0.b().d();
        d.a.i0.a.z.a.b().g(true);
        d.a.i0.a.i1.b.h(false);
        d.a.i0.a.i1.f.e.a.r(true);
        d.a.i0.a.m1.g.f().j(true);
        d.a.i0.a.m1.f.j(false);
        if (d.a.i0.a.c1.a.E() != null) {
            d.a.i0.a.c1.a.E().c();
        }
        p0.h();
        d.a.i0.a.k1.a.i();
        d.a.i0.a.l0.o.a.k();
    }
}
