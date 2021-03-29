package d.c.c.a.b.a.c;

import d.c.c.a.b.a.e;
import d.c.c.a.b.a0;
import d.c.c.a.b.w;
import d.c.c.a.b.y;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class a implements w {

    /* renamed from: a  reason: collision with root package name */
    public final y f65185a;

    public a(y yVar) {
        this.f65185a = yVar;
    }

    @Override // d.c.c.a.b.w
    public d.c.c.a.b.c a(w.a aVar) throws IOException {
        e.i iVar = (e.i) aVar;
        a0 a2 = iVar.a();
        f f2 = iVar.f();
        return iVar.b(a2, f2, f2.d(this.f65185a, aVar, !a2.c().equals("GET")), f2.j());
    }
}
