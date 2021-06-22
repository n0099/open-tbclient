package d.a.m0.a.g1.j;

import androidx.annotation.Nullable;
import d.a.m0.a.h0.u.g;
/* loaded from: classes3.dex */
public class d implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.l0.a f45723a;

    public final void a() {
        d.a.m0.a.h0.l.a P;
        d.a.m0.a.l0.a aVar = this.f45723a;
        if ((aVar == null || aVar.isDestroyed()) && (P = g.N().P()) != null && (P.g() instanceof d.a.m0.a.l0.a)) {
            this.f45723a = (d.a.m0.a.l0.a) P.g();
        }
    }

    @Override // d.a.m0.a.g1.j.a
    public void onPause() {
        a();
        d.a.m0.a.l0.a aVar = this.f45723a;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // d.a.m0.a.g1.j.a
    public void onResume() {
        a();
        d.a.m0.a.l0.a aVar = this.f45723a;
        if (aVar != null) {
            aVar.onResume();
        }
    }
}
