package d.q.a.a;

import android.content.Context;
import android.os.Process;
import d.q.a.a.c.a.a;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ b f71532e;

    public e(b bVar) {
        this.f71532e = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        int i2;
        int i3;
        Context context2;
        String str;
        d dVar;
        d dVar2;
        Context context3;
        d dVar3;
        try {
            context = this.f71532e.f71502a;
            if (context == null) {
                dVar3 = this.f71532e.f71507f;
                dVar3.a(-3, "parameter error");
                return;
            }
            i2 = b.f71500g;
            if (i2 == -1) {
                context3 = this.f71532e.f71502a;
                if (context3.getPackageName().equals(d.q.a.a.c.b.e.a(Process.myPid()))) {
                    int unused = b.f71500g = 1;
                } else {
                    int unused2 = b.f71500g = 0;
                }
            }
            i3 = b.f71500g;
            if (i3 == 0) {
                dVar2 = this.f71532e.f71507f;
                dVar2.a(-4, "need main process");
                return;
            }
            b bVar = this.f71532e;
            context2 = this.f71532e.f71502a;
            bVar.f71503b = context2.getPackageName();
            a a2 = a.a();
            str = this.f71532e.f71503b;
            a2.d(str);
            b bVar2 = this.f71532e;
            dVar = this.f71532e.f71507f;
            bVar2.i(dVar);
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
