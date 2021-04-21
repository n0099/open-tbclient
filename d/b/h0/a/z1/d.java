package d.b.h0.a.z1;

import android.util.Log;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47918a = k.f45772a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.z1.k.e f47919e;

        public a(d.b.h0.a.z1.k.e eVar) {
            this.f47919e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.j("934", this.f47919e.f());
        }
    }

    public static void a(d.b.h0.a.z1.k.f fVar) {
        if (fVar == null) {
            if (f47918a) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        d.b.h0.a.z1.k.e eVar = new d.b.h0.a.z1.k.e();
        eVar.f47976e = fVar.f47976e;
        eVar.f47972a = fVar.f47972a;
        eVar.f47977f = fVar.f47977f;
        eVar.f47974c = fVar.f47974c;
        eVar.f47973b = fVar.f47973b;
        eVar.f47975d = fVar.f47975d;
        eVar.e(fVar.c());
        p.j(new a(eVar), "SwanAppFuncClickUBC");
    }
}
