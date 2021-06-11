package d.a.l0.a.j2;

import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.l0.a.v2.q;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46777a = d.a.l0.a.k.f46875a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.e f46778e;

        public a(d.a.l0.a.j2.p.e eVar) {
            this.f46778e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.k("934", this.f46778e.f());
        }
    }

    public static void a(d.a.l0.a.j2.p.e eVar, d.a.l0.a.f1.e.b bVar) {
        if (eVar == null || bVar == null) {
            return;
        }
        eVar.f46861a = k.m(bVar.G());
        eVar.f46866f = bVar.H();
        eVar.f46863c = bVar.T();
        eVar.a("swan", d.a.l0.a.m2.b.h(bVar.G()));
        eVar.a("appversion", bVar.u1());
        eVar.a("thirdversion", bVar.v1());
        eVar.b(k.k(bVar.W()));
        eVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(d.a.l0.a.j2.p.f fVar) {
        if (fVar == null) {
            if (f46777a) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f46866f = fVar.f46866f;
        eVar.f46861a = fVar.f46861a;
        eVar.f46867g = fVar.f46867g;
        eVar.f46863c = fVar.f46863c;
        eVar.f46862b = fVar.f46862b;
        eVar.f46865e = fVar.f46865e;
        eVar.e(fVar.c());
        c(eVar);
    }

    public static void c(d.a.l0.a.j2.p.e eVar) {
        q.i(new a(eVar), "SwanAppFuncClickUBC");
    }
}
