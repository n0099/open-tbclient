package d.a.l0.a.g1.j;

import androidx.annotation.Nullable;
import d.a.l0.a.h0.u.g;
/* loaded from: classes3.dex */
public class d implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l0.a f41939a;

    public final void a() {
        d.a.l0.a.h0.l.a P;
        d.a.l0.a.l0.a aVar = this.f41939a;
        if ((aVar == null || aVar.isDestroyed()) && (P = g.N().P()) != null && (P.g() instanceof d.a.l0.a.l0.a)) {
            this.f41939a = (d.a.l0.a.l0.a) P.g();
        }
    }

    @Override // d.a.l0.a.g1.j.a
    public void onPause() {
        a();
        d.a.l0.a.l0.a aVar = this.f41939a;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // d.a.l0.a.g1.j.a
    public void onResume() {
        a();
        d.a.l0.a.l0.a aVar = this.f41939a;
        if (aVar != null) {
            aVar.onResume();
        }
    }
}
