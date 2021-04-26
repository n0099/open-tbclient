package d.q.a.a.a.b.f;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class b implements d.q.a.a.a.b.b {

    /* renamed from: e  reason: collision with root package name */
    public Context f66838e;

    public b(Context context) {
        this.f66838e = context;
    }

    @Override // d.q.a.a.a.b.b
    public final void a(d.q.a.a.a.a.a aVar) {
        if (aVar != null) {
            try {
                aVar.a(c(), this);
            } catch (Throwable th) {
                d.q.a.a.c.b.b.c(th);
            }
        }
    }

    @Override // d.q.a.a.a.b.b
    public final boolean a() {
        return false;
    }

    @Override // d.q.a.a.a.b.b
    public final String b() {
        String d2 = a.a(this.f66838e).d();
        return TextUtils.isEmpty(d2) ? "" : d2;
    }

    @Override // d.q.a.a.a.b.b
    public final boolean c() {
        return a.a(this.f66838e).c();
    }

    @Override // d.q.a.a.a.b.b
    public final void d() {
    }
}
