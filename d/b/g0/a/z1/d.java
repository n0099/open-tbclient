package d.b.g0.a.z1;

import android.util.Log;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47589a = k.f45443a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.e f47590e;

        public a(d.b.g0.a.z1.k.e eVar) {
            this.f47590e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.j("934", this.f47590e.f());
        }
    }

    public static void a(d.b.g0.a.z1.k.f fVar) {
        if (fVar == null) {
            if (f47589a) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47647e = fVar.f47647e;
        eVar.f47643a = fVar.f47643a;
        eVar.f47648f = fVar.f47648f;
        eVar.f47645c = fVar.f47645c;
        eVar.f47644b = fVar.f47644b;
        eVar.f47646d = fVar.f47646d;
        eVar.e(fVar.c());
        p.j(new a(eVar), "SwanAppFuncClickUBC");
    }
}
