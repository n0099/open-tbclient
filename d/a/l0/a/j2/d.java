package d.a.l0.a.j2;

import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.l0.a.v2.q;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43101a = d.a.l0.a.k.f43199a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.j2.p.e f43102e;

        public a(d.a.l0.a.j2.p.e eVar) {
            this.f43102e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.k("934", this.f43102e.f());
        }
    }

    public static void a(d.a.l0.a.j2.p.e eVar, d.a.l0.a.f1.e.b bVar) {
        if (eVar == null || bVar == null) {
            return;
        }
        eVar.f43185a = k.m(bVar.G());
        eVar.f43190f = bVar.H();
        eVar.f43187c = bVar.T();
        eVar.a("swan", d.a.l0.a.m2.b.h(bVar.G()));
        eVar.a("appversion", bVar.u1());
        eVar.a("thirdversion", bVar.v1());
        eVar.b(k.k(bVar.W()));
        eVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(d.a.l0.a.j2.p.f fVar) {
        if (fVar == null) {
            if (f43101a) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f43190f = fVar.f43190f;
        eVar.f43185a = fVar.f43185a;
        eVar.f43191g = fVar.f43191g;
        eVar.f43187c = fVar.f43187c;
        eVar.f43186b = fVar.f43186b;
        eVar.f43189e = fVar.f43189e;
        eVar.e(fVar.c());
        c(eVar);
    }

    public static void c(d.a.l0.a.j2.p.e eVar) {
        q.i(new a(eVar), "SwanAppFuncClickUBC");
    }
}
