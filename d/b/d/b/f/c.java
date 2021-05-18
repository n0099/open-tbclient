package d.b.d.b.f;

import android.content.Context;
import d.b.d.b.h.a.e;
import d.b.d.b.l;
/* loaded from: classes6.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public Context f65857a;

    public c(Context context) {
        this.f65857a = context;
    }

    @Override // d.b.d.b.f.b
    public void a(long j, Thread thread, Throwable th) {
        d.b.d.b.e.a c2 = d.b.d.b.e.a.c(j, this.f65857a, thread, th);
        l.e.d(this.f65857a, com.bytedance.tea.crash.c.JAVA.a(), Thread.currentThread().getName());
        d.b.d.b.n.a.a().b(e.c().a(com.bytedance.tea.crash.c.JAVA, c2).j());
    }

    @Override // d.b.d.b.f.b
    public boolean a(Throwable th) {
        return true;
    }
}
