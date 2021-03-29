package d.c.d.b.f;

import android.content.Context;
import d.c.d.b.h.a.e;
import d.c.d.b.l;
/* loaded from: classes6.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public Context f65827a;

    public c(Context context) {
        this.f65827a = context;
    }

    @Override // d.c.d.b.f.b
    public void a(long j, Thread thread, Throwable th) {
        d.c.d.b.e.a c2 = d.c.d.b.e.a.c(j, this.f65827a, thread, th);
        l.e.d(this.f65827a, com.bytedance.tea.crash.c.JAVA.a(), Thread.currentThread().getName());
        d.c.d.b.n.a.a().b(e.c().a(com.bytedance.tea.crash.c.JAVA, c2).j());
    }

    @Override // d.c.d.b.f.b
    public boolean a(Throwable th) {
        return true;
    }
}
