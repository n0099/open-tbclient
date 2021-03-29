package d.b.g0.a.z1;

import android.util.Log;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47197a = k.f45051a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.z1.k.e f47198e;

        public a(d.b.g0.a.z1.k.e eVar) {
            this.f47198e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.j("934", this.f47198e.f());
        }
    }

    public static void a(d.b.g0.a.z1.k.f fVar) {
        if (fVar == null) {
            if (f47197a) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47255e = fVar.f47255e;
        eVar.f47251a = fVar.f47251a;
        eVar.f47256f = fVar.f47256f;
        eVar.f47253c = fVar.f47253c;
        eVar.f47252b = fVar.f47252b;
        eVar.f47254d = fVar.f47254d;
        eVar.e(fVar.c());
        p.j(new a(eVar), "SwanAppFuncClickUBC");
    }
}
