package d.q.a.a.a.b.i;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import d.q.a.a.a.a.a;
import d.q.a.a.c.b.c;
/* loaded from: classes7.dex */
public final class b implements d.q.a.a.a.b.b {

    /* renamed from: e  reason: collision with root package name */
    public Context f71488e;

    public b(Context context) {
        this.f71488e = context;
    }

    @Override // d.q.a.a.a.b.b
    public final void a(a aVar) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                aVar.a(false, new c());
            }
            if (aVar != null) {
                aVar.a(c(), this);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    @Override // d.q.a.a.a.b.b
    public final boolean a() {
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public final String b() {
        String g2 = d.q.a.a.a.b.i.a.b.a(this.f71488e).g();
        return TextUtils.isEmpty(g2) ? "" : g2;
    }

    public final void b(String str) {
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return d.q.a.a.a.b.i.a.b.a(this.f71488e).f();
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
    }
}
