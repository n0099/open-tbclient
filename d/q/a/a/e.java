package d.q.a.a;

import android.content.Context;
import d.q.a.a.c.a.a;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ b f67639e;

    public e(b bVar) {
        this.f67639e = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        String str;
        d dVar;
        d dVar2;
        try {
            context = this.f67639e.f67611a;
            if (context == null) {
                dVar2 = this.f67639e.f67616f;
                dVar2.a(-3, "parameter error");
                return;
            }
            b bVar = this.f67639e;
            context2 = this.f67639e.f67611a;
            bVar.f67612b = context2.getPackageName();
            a a2 = a.a();
            str = this.f67639e.f67612b;
            a2.d(str);
            b bVar2 = this.f67639e;
            dVar = this.f67639e.f67616f;
            bVar2.h(dVar);
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
