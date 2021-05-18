package d.a.i0.a.g1.j;

import androidx.annotation.Nullable;
import d.a.i0.a.h0.u.g;
/* loaded from: classes3.dex */
public class d implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l0.a f41765a;

    public final void a() {
        d.a.i0.a.h0.l.a P;
        d.a.i0.a.l0.a aVar = this.f41765a;
        if ((aVar == null || aVar.isDestroyed()) && (P = g.N().P()) != null && (P.g() instanceof d.a.i0.a.l0.a)) {
            this.f41765a = (d.a.i0.a.l0.a) P.g();
        }
    }

    @Override // d.a.i0.a.g1.j.a
    public void onPause() {
        a();
        d.a.i0.a.l0.a aVar = this.f41765a;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // d.a.i0.a.g1.j.a
    public void onResume() {
        a();
        d.a.i0.a.l0.a aVar = this.f41765a;
        if (aVar != null) {
            aVar.onResume();
        }
    }
}
