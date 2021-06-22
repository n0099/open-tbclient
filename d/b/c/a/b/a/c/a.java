package d.b.c.a.b.a.c;

import d.b.c.a.b.a.e;
import d.b.c.a.b.a0;
import d.b.c.a.b.w;
import d.b.c.a.b.y;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class a implements w {

    /* renamed from: a  reason: collision with root package name */
    public final y f69054a;

    public a(y yVar) {
        this.f69054a = yVar;
    }

    @Override // d.b.c.a.b.w
    public d.b.c.a.b.c a(w.a aVar) throws IOException {
        e.i iVar = (e.i) aVar;
        a0 a2 = iVar.a();
        f f2 = iVar.f();
        return iVar.b(a2, f2, f2.d(this.f69054a, aVar, !a2.c().equals("GET")), f2.j());
    }
}
