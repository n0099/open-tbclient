package d.b.d.b.h.a;

import android.content.Context;
import d.b.d.b.l;
import d.b.d.b.m;
/* loaded from: classes6.dex */
public class g extends c {
    public g(Context context, b bVar, d dVar) {
        super(com.bytedance.tea.crash.c.JAVA, context, bVar, dVar);
    }

    @Override // d.b.d.b.h.a.c
    public d.b.d.b.e.a a(d.b.d.b.e.a aVar) {
        d.b.d.b.e.a a2 = super.a(aVar);
        a2.k("app_count", 1);
        a2.k("magic_tag", "ss_app_log");
        e(a2);
        d.b.d.b.e.b a3 = d.b.d.b.e.b.a(this.f65869b);
        a3.d(m.a().a());
        a3.c(m.d().a());
        a3.g(this.f65870c.c());
        a2.d(a3);
        l.C1838l.b(a2, a3, this.f65868a);
        return a2;
    }
}
