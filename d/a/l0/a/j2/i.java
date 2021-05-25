package d.a.l0.a.j2;

import android.util.Log;
import d.a.l0.a.v2.q;
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43130a = d.a.l0.a.k.f43199a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.d f43131e;

        public a(d.a.l0.a.j2.p.d dVar) {
            this.f43131e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.k("671", this.f43131e.f());
        }
    }

    public static void a(d.a.l0.n.f.d dVar, int i2, boolean z) {
        if (dVar == null) {
            if (f43130a) {
                Log.d("SwanStabilityUbc", "pms callback is null");
                return;
            }
            return;
        }
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(11L);
        aVar.h(2331L);
        aVar.e("Retry=" + z + ", Scene=" + dVar.getClass().getName());
        d.a.l0.a.j2.p.d dVar2 = new d.a.l0.a.j2.p.d();
        dVar2.q(k.m(i2));
        dVar2.p(aVar);
        if (dVar instanceof d.a.l0.a.h0.m.g) {
            dVar2.r(((d.a.l0.a.h0.m.g) dVar).G0());
        }
        b(dVar2);
        if (f43130a) {
            Log.d("SwanStabilityUbc", "Statis: Retry=" + z + ", Scene=" + dVar.getClass().getSimpleName());
        }
    }

    public static void b(d.a.l0.a.j2.p.d dVar) {
        if (dVar == null) {
            if (f43130a) {
                Log.d("SwanStabilityUbc", "event is null");
                return;
            }
            return;
        }
        q.j(new a(dVar), "SwanStabilityUBC");
    }
}
