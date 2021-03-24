package d.b.g0.a.z0.j;

import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class d implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.a f47185a;

    public final void a() {
        d.b.g0.a.e0.o.a N;
        d.b.g0.g.i.a aVar = this.f47185a;
        if ((aVar == null || aVar.isDestroyed()) && (N = d.b.g0.a.e0.w.d.L().N()) != null && (N.g() instanceof d.b.g0.g.i.a)) {
            this.f47185a = (d.b.g0.g.i.a) N.g();
        }
    }

    @Override // d.b.g0.a.z0.j.a
    public void onPause() {
        a();
        d.b.g0.g.i.a aVar = this.f47185a;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // d.b.g0.a.z0.j.a
    public void onResume() {
        a();
        d.b.g0.g.i.a aVar = this.f47185a;
        if (aVar != null) {
            aVar.onResume();
        }
    }
}
