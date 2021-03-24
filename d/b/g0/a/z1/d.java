package d.b.g0.a.z1;

import android.util.Log;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47196a = k.f45050a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.e f47197e;

        public a(d.b.g0.a.z1.k.e eVar) {
            this.f47197e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.j("934", this.f47197e.f());
        }
    }

    public static void a(d.b.g0.a.z1.k.f fVar) {
        if (fVar == null) {
            if (f47196a) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47254e = fVar.f47254e;
        eVar.f47250a = fVar.f47250a;
        eVar.f47255f = fVar.f47255f;
        eVar.f47252c = fVar.f47252c;
        eVar.f47251b = fVar.f47251b;
        eVar.f47253d = fVar.f47253d;
        eVar.e(fVar.c());
        p.j(new a(eVar), "SwanAppFuncClickUBC");
    }
}
