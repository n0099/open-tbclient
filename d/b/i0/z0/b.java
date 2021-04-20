package d.b.i0.z0;

import com.squareup.wire.Message;
import d.b.i0.a1.c.c;
import d.b.i0.j1.p.e;
/* loaded from: classes4.dex */
public class b implements d.b.i0.j1.s.b {

    /* renamed from: a  reason: collision with root package name */
    public c.d f64222a;

    public b(c.d dVar) {
        this.f64222a = dVar;
    }

    @Override // d.b.i0.j1.s.b
    public void a(long j, String str, String str2, int i) {
        c.d dVar = this.f64222a;
        if (dVar != null) {
            dVar.c(str, str2, i, true, 1);
        }
    }

    @Override // d.b.i0.j1.s.b
    public void b(long j, String str, Message message, boolean z) {
    }

    @Override // d.b.i0.j1.s.b
    public void c(boolean z, Message message, boolean z2, long j, String str, int i) {
        d.b.i0.z0.c.a aVar = new d.b.i0.z0.c.a();
        e eVar = new e();
        eVar.f57478a = j;
        eVar.f57479b = str;
        d.b.i0.j1.p.a b2 = d.b.i0.j1.r.b.d().b(eVar);
        if (b2 != null) {
            b2.d(z, message, z2, i);
        }
        aVar.c(b2);
        c.d dVar = this.f64222a;
        if (dVar != null) {
            dVar.e(z, aVar, z2, "", str, true);
        }
    }
}
