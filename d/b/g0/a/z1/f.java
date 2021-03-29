package d.b.g0.a.z1;

import android.util.Log;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47213a = k.f45051a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.d f47214e;

        public a(d.b.g0.a.z1.k.d dVar) {
            this.f47214e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.n.e.l("671", this.f47214e.f());
        }
    }

    public static void a(d.b.g0.l.h.d dVar, int i, boolean z) {
        if (dVar == null) {
            if (f47213a) {
                Log.d("SwanStabilityUbc", "pms callback is null");
                return;
            }
            return;
        }
        d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
        aVar.j(11L);
        aVar.h(2331L);
        aVar.e("Retry=" + z + ", Scene=" + dVar.getClass().getName());
        d.b.g0.a.z1.k.d dVar2 = new d.b.g0.a.z1.k.d();
        dVar2.q(h.n(i));
        dVar2.p(aVar);
        if (dVar instanceof d.b.g0.a.e0.p.g) {
            dVar2.r(((d.b.g0.a.e0.p.g) dVar).G0());
        }
        b(dVar2);
        if (f47213a) {
            Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + dVar.getClass().getSimpleName());
        }
    }

    public static void b(d.b.g0.a.z1.k.d dVar) {
        if (dVar == null) {
            if (f47213a) {
                Log.d("SwanStabilityUbc", "event is null");
                return;
            }
            return;
        }
        p.k(new a(dVar), "SwanStabilityUBC");
    }
}
