package d.q.a.a;

import android.content.Context;
import d.q.a.a.c.a.a;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ b f66910e;

    public e(b bVar) {
        this.f66910e = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        String str;
        d dVar;
        d dVar2;
        try {
            context = this.f66910e.f66882a;
            if (context == null) {
                dVar2 = this.f66910e.f66887f;
                dVar2.a(-3, "parameter error");
                return;
            }
            b bVar = this.f66910e;
            context2 = this.f66910e.f66882a;
            bVar.f66883b = context2.getPackageName();
            a a2 = a.a();
            str = this.f66910e.f66883b;
            a2.d(str);
            b bVar2 = this.f66910e;
            dVar = this.f66910e.f66887f;
            bVar2.h(dVar);
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
