package d.a.h0.a.z1;

import android.util.Log;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45370a = k.f43101a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.d f45371e;

        public a(d.a.h0.a.z1.k.d dVar) {
            this.f45371e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.n.e.l("671", this.f45371e.f());
        }
    }

    public static void a(d.a.h0.l.h.d dVar, int i2, boolean z) {
        if (dVar == null) {
            if (f45370a) {
                Log.d("SwanStabilityUbc", "pms callback is null");
                return;
            }
            return;
        }
        d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
        aVar.j(11L);
        aVar.h(2331L);
        aVar.e("Retry=" + z + ", Scene=" + dVar.getClass().getName());
        d.a.h0.a.z1.k.d dVar2 = new d.a.h0.a.z1.k.d();
        dVar2.q(h.n(i2));
        dVar2.p(aVar);
        if (dVar instanceof d.a.h0.a.e0.p.g) {
            dVar2.r(((d.a.h0.a.e0.p.g) dVar).F0());
        }
        b(dVar2);
        if (f45370a) {
            Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + dVar.getClass().getSimpleName());
        }
    }

    public static void b(d.a.h0.a.z1.k.d dVar) {
        if (dVar == null) {
            if (f45370a) {
                Log.d("SwanStabilityUbc", "event is null");
                return;
            }
            return;
        }
        p.k(new a(dVar), "SwanStabilityUBC");
    }
}
