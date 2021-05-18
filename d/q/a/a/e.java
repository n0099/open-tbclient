package d.q.a.a;

import android.content.Context;
import d.q.a.a.c.a.a;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ b f67596e;

    public e(b bVar) {
        this.f67596e = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        String str;
        d dVar;
        d dVar2;
        try {
            context = this.f67596e.f67568a;
            if (context == null) {
                dVar2 = this.f67596e.f67573f;
                dVar2.a(-3, "parameter error");
                return;
            }
            b bVar = this.f67596e;
            context2 = this.f67596e.f67568a;
            bVar.f67569b = context2.getPackageName();
            a a2 = a.a();
            str = this.f67596e.f67569b;
            a2.d(str);
            b bVar2 = this.f67596e;
            dVar = this.f67596e.f67573f;
            bVar2.h(dVar);
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
