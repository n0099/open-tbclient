package d.a.h0.a.z0.j;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class d implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.i.a f45343a;

    public final void a() {
        d.a.h0.a.e0.o.a N;
        d.a.h0.g.i.a aVar = this.f45343a;
        if ((aVar == null || aVar.isDestroyed()) && (N = d.a.h0.a.e0.w.d.L().N()) != null && (N.g() instanceof d.a.h0.g.i.a)) {
            this.f45343a = (d.a.h0.g.i.a) N.g();
        }
    }

    @Override // d.a.h0.a.z0.j.a
    public void onPause() {
        a();
        d.a.h0.g.i.a aVar = this.f45343a;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // d.a.h0.a.z0.j.a
    public void onResume() {
        a();
        d.a.h0.g.i.a aVar = this.f45343a;
        if (aVar != null) {
            aVar.onResume();
        }
    }
}
