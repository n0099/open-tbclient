package d.q.a.a;

import android.content.Context;
import android.os.Process;
import d.q.a.a.c.a.a;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ b f68386e;

    public e(b bVar) {
        this.f68386e = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        int i;
        int i2;
        Context context2;
        String str;
        d dVar;
        d dVar2;
        Context context3;
        d dVar3;
        try {
            context = this.f68386e.f68356a;
            if (context == null) {
                dVar3 = this.f68386e.f68361f;
                dVar3.a(-3, "parameter error");
                return;
            }
            i = b.f68354g;
            if (i == -1) {
                context3 = this.f68386e.f68356a;
                if (context3.getPackageName().equals(d.q.a.a.c.b.e.a(Process.myPid()))) {
                    int unused = b.f68354g = 1;
                } else {
                    int unused2 = b.f68354g = 0;
                }
            }
            i2 = b.f68354g;
            if (i2 == 0) {
                dVar2 = this.f68386e.f68361f;
                dVar2.a(-4, "need main process");
                return;
            }
            b bVar = this.f68386e;
            context2 = this.f68386e.f68356a;
            bVar.f68357b = context2.getPackageName();
            a a2 = a.a();
            str = this.f68386e.f68357b;
            a2.d(str);
            b bVar2 = this.f68386e;
            dVar = this.f68386e.f68361f;
            bVar2.i(dVar);
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
