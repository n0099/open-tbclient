package d.a.m0.a.j2;

import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.m0.a.v2.q;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46885a = d.a.m0.a.k.f46983a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.j2.p.e f46886e;

        public a(d.a.m0.a.j2.p.e eVar) {
            this.f46886e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.k("934", this.f46886e.f());
        }
    }

    public static void a(d.a.m0.a.j2.p.e eVar, d.a.m0.a.f1.e.b bVar) {
        if (eVar == null || bVar == null) {
            return;
        }
        eVar.f46969a = k.m(bVar.G());
        eVar.f46974f = bVar.H();
        eVar.f46971c = bVar.T();
        eVar.a("swan", d.a.m0.a.m2.b.h(bVar.G()));
        eVar.a("appversion", bVar.u1());
        eVar.a("thirdversion", bVar.v1());
        eVar.b(k.k(bVar.W()));
        eVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(d.a.m0.a.j2.p.f fVar) {
        if (fVar == null) {
            if (f46885a) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        eVar.f46974f = fVar.f46974f;
        eVar.f46969a = fVar.f46969a;
        eVar.f46975g = fVar.f46975g;
        eVar.f46971c = fVar.f46971c;
        eVar.f46970b = fVar.f46970b;
        eVar.f46973e = fVar.f46973e;
        eVar.e(fVar.c());
        c(eVar);
    }

    public static void c(d.a.m0.a.j2.p.e eVar) {
        q.i(new a(eVar), "SwanAppFuncClickUBC");
    }
}
