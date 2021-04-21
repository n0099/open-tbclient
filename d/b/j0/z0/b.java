package d.b.j0.z0;

import com.squareup.wire.Message;
import d.b.j0.a1.c.c;
import d.b.j0.j1.p.e;
/* loaded from: classes4.dex */
public class b implements d.b.j0.j1.s.b {

    /* renamed from: a  reason: collision with root package name */
    public c.d f64643a;

    public b(c.d dVar) {
        this.f64643a = dVar;
    }

    @Override // d.b.j0.j1.s.b
    public void a(long j, String str, String str2, int i) {
        c.d dVar = this.f64643a;
        if (dVar != null) {
            dVar.c(str, str2, i, true, 1);
        }
    }

    @Override // d.b.j0.j1.s.b
    public void b(long j, String str, Message message, boolean z) {
    }

    @Override // d.b.j0.j1.s.b
    public void c(boolean z, Message message, boolean z2, long j, String str, int i) {
        d.b.j0.z0.c.a aVar = new d.b.j0.z0.c.a();
        e eVar = new e();
        eVar.f57899a = j;
        eVar.f57900b = str;
        d.b.j0.j1.p.a b2 = d.b.j0.j1.r.b.d().b(eVar);
        if (b2 != null) {
            b2.d(z, message, z2, i);
        }
        aVar.c(b2);
        c.d dVar = this.f64643a;
        if (dVar != null) {
            dVar.e(z, aVar, z2, "", str, true);
        }
    }
}
