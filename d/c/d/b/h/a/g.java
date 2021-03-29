package d.c.d.b.h.a;

import android.content.Context;
import d.c.d.b.l;
import d.c.d.b.m;
/* loaded from: classes6.dex */
public class g extends c {
    public g(Context context, b bVar, d dVar) {
        super(com.bytedance.tea.crash.c.JAVA, context, bVar, dVar);
    }

    @Override // d.c.d.b.h.a.c
    public d.c.d.b.e.a a(d.c.d.b.e.a aVar) {
        d.c.d.b.e.a a2 = super.a(aVar);
        a2.k("app_count", 1);
        a2.k("magic_tag", "ss_app_log");
        e(a2);
        d.c.d.b.e.b a3 = d.c.d.b.e.b.a(this.f65838b);
        a3.d(m.a().a());
        a3.c(m.d().a());
        a3.g(this.f65839c.c());
        a2.d(a3);
        l.C1803l.b(a2, a3, this.f65837a);
        return a2;
    }
}
