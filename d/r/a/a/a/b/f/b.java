package d.r.a.a.a.b.f;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class b implements d.r.a.a.a.b.b {

    /* renamed from: e  reason: collision with root package name */
    public Context f68459e;

    public b(Context context) {
        this.f68459e = context;
    }

    @Override // d.r.a.a.a.b.b
    public final void a(d.r.a.a.a.a.a aVar) {
        if (aVar != null) {
            try {
                aVar.a(c(), this);
            } catch (Throwable th) {
                d.r.a.a.c.b.b.c(th);
            }
        }
    }

    @Override // d.r.a.a.a.b.b
    public final boolean a() {
        return false;
    }

    @Override // d.r.a.a.a.b.b
    public final String b() {
        String d2 = a.a(this.f68459e).d();
        return TextUtils.isEmpty(d2) ? "" : d2;
    }

    @Override // d.r.a.a.a.b.b
    public final boolean c() {
        return a.a(this.f68459e).c();
    }

    @Override // d.r.a.a.a.b.b
    public final void d() {
    }
}
