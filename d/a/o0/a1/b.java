package d.a.o0.a1;

import com.squareup.wire.Message;
import d.a.o0.b1.d.c;
import d.a.o0.k1.p.e;
/* loaded from: classes4.dex */
public class b implements d.a.o0.k1.s.b {

    /* renamed from: a  reason: collision with root package name */
    public c.d f54943a;

    public b(c.d dVar) {
        this.f54943a = dVar;
    }

    @Override // d.a.o0.k1.s.b
    public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
        d.a.o0.a1.c.a aVar = new d.a.o0.a1.c.a();
        e eVar = new e();
        eVar.f60572a = j;
        eVar.f60573b = str;
        d.a.o0.k1.p.a a2 = d.a.o0.k1.r.b.d().a(eVar);
        if (a2 != null) {
            a2.d(z, message, z2, i2);
        }
        aVar.b(a2);
        c.d dVar = this.f54943a;
        if (dVar != null) {
            dVar.e(z, aVar, z2, "", str, true);
        }
    }

    @Override // d.a.o0.k1.s.b
    public void b(long j, String str, String str2, int i2) {
        c.d dVar = this.f54943a;
        if (dVar != null) {
            dVar.c(str, str2, i2, true, 1);
        }
    }

    @Override // d.a.o0.k1.s.b
    public void c(long j, String str, Message message, boolean z) {
    }
}
