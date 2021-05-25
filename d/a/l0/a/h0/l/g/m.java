package d.a.l0.a.h0.l.g;

import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes2.dex */
public class m implements b<a> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42275c = d.a.l0.a.k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public volatile Boolean f42276a = null;

    /* renamed from: b  reason: collision with root package name */
    public volatile b<a> f42277b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: d.a.l0.a.h0.l.g.d<d.a.l0.a.h0.l.g.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.l0.a.h0.l.g.c
    public void b(d<a> dVar) {
        l().b(dVar);
    }

    @Override // d.a.l0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        l().c(cVar, pMSAppInfo);
    }

    @Override // d.a.l0.a.h0.l.g.b
    public void d(d.a.l0.a.o0.d.a aVar) {
        l().d(aVar);
    }

    @Override // d.a.l0.a.h0.l.g.c
    public boolean f() {
        return l().f();
    }

    @Override // d.a.l0.a.h0.l.g.c
    public boolean g() {
        return l().g();
    }

    @Override // d.a.l0.a.h0.l.g.c
    public boolean h() {
        return l().h();
    }

    @Override // d.a.l0.a.h0.l.g.b
    public boolean i() {
        return l().i();
    }

    @Override // d.a.l0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        l().j(z, jVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.h0.l.g.c
    /* renamed from: k */
    public a a() {
        return (a) l().a();
    }

    public final b<a> l() {
        if (this.f42277b == null) {
            synchronized (this) {
                if (this.f42277b == null) {
                    this.f42277b = m() ? new d.a.l0.a.h0.l.g.o.c() : new l();
                    if (f42275c) {
                        Log.d("SwanAppMasterProviderWrapper", "provider - " + this.f42277b.getClass().getSimpleName());
                    }
                }
            }
        }
        return this.f42277b;
    }

    public final boolean m() {
        if (this.f42276a == null) {
            this.f42276a = Boolean.valueOf(d.a.l0.a.h0.o.e.a.j() > 0 && d.a.l0.a.h0.o.e.a.g());
        }
        if (f42275c) {
            Log.d("SwanAppMasterProviderWrapper", "loaded swan core version - " + d.a.l0.a.h0.u.g.N().V());
            Log.d("SwanAppMasterProviderWrapper", "use multi preload - " + this.f42276a);
        }
        return this.f42276a.booleanValue();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.h0.l.g.c
    /* renamed from: n */
    public a e(PMSAppInfo pMSAppInfo) {
        return (a) l().e(pMSAppInfo);
    }

    @Override // d.a.l0.a.h0.l.g.c
    public void reset() {
        l().reset();
        synchronized (this) {
            this.f42276a = null;
            this.f42277b = null;
        }
    }
}
