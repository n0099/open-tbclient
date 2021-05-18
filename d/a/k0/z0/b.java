package d.a.k0.z0;

import com.squareup.wire.Message;
import d.a.k0.a1.c.c;
import d.a.k0.j1.p.e;
/* loaded from: classes4.dex */
public class b implements d.a.k0.j1.s.b {

    /* renamed from: a  reason: collision with root package name */
    public c.d f63650a;

    public b(c.d dVar) {
        this.f63650a = dVar;
    }

    @Override // d.a.k0.j1.s.b
    public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
        d.a.k0.z0.c.a aVar = new d.a.k0.z0.c.a();
        e eVar = new e();
        eVar.f56578a = j;
        eVar.f56579b = str;
        d.a.k0.j1.p.a a2 = d.a.k0.j1.r.b.d().a(eVar);
        if (a2 != null) {
            a2.d(z, message, z2, i2);
        }
        aVar.b(a2);
        c.d dVar = this.f63650a;
        if (dVar != null) {
            dVar.e(z, aVar, z2, "", str, true);
        }
    }

    @Override // d.a.k0.j1.s.b
    public void b(long j, String str, String str2, int i2) {
        c.d dVar = this.f63650a;
        if (dVar != null) {
            dVar.c(str, str2, i2, true, 1);
        }
    }

    @Override // d.a.k0.j1.s.b
    public void c(long j, String str, Message message, boolean z) {
    }
}
