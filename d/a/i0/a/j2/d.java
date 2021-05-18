package d.a.i0.a.j2;

import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.i0.a.v2.q;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42927a = d.a.i0.a.k.f43025a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.j2.p.e f42928e;

        public a(d.a.i0.a.j2.p.e eVar) {
            this.f42928e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.k("934", this.f42928e.f());
        }
    }

    public static void a(d.a.i0.a.j2.p.e eVar, d.a.i0.a.f1.e.b bVar) {
        if (eVar == null || bVar == null) {
            return;
        }
        eVar.f43011a = k.m(bVar.G());
        eVar.f43016f = bVar.H();
        eVar.f43013c = bVar.T();
        eVar.a("swan", d.a.i0.a.m2.b.h(bVar.G()));
        eVar.a("appversion", bVar.u1());
        eVar.a("thirdversion", bVar.v1());
        eVar.b(k.k(bVar.W()));
        eVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(d.a.i0.a.j2.p.f fVar) {
        if (fVar == null) {
            if (f42927a) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43016f = fVar.f43016f;
        eVar.f43011a = fVar.f43011a;
        eVar.f43017g = fVar.f43017g;
        eVar.f43013c = fVar.f43013c;
        eVar.f43012b = fVar.f43012b;
        eVar.f43015e = fVar.f43015e;
        eVar.e(fVar.c());
        c(eVar);
    }

    public static void c(d.a.i0.a.j2.p.e eVar) {
        q.i(new a(eVar), "SwanAppFuncClickUBC");
    }
}
