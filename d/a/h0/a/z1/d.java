package d.a.h0.a.z1;

import android.util.Log;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45354a = k.f43101a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.z1.k.e f45355e;

        public a(d.a.h0.a.z1.k.e eVar) {
            this.f45355e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.j("934", this.f45355e.f());
        }
    }

    public static void a(d.a.h0.a.z1.k.f fVar) {
        if (fVar == null) {
            if (f45354a) {
                Log.w("SwanAppFuncUbc", "event is null");
                return;
            }
            return;
        }
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45415e = fVar.f45415e;
        eVar.f45411a = fVar.f45411a;
        eVar.f45416f = fVar.f45416f;
        eVar.f45413c = fVar.f45413c;
        eVar.f45412b = fVar.f45412b;
        eVar.f45414d = fVar.f45414d;
        eVar.e(fVar.c());
        p.j(new a(eVar), "SwanAppFuncClickUBC");
    }
}
