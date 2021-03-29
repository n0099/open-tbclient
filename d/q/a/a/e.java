package d.q.a.a;

import android.content.Context;
import android.os.Process;
import d.q.a.a.c.a.a;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ b f67393e;

    public e(b bVar) {
        this.f67393e = bVar;
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
            context = this.f67393e.f67363a;
            if (context == null) {
                dVar3 = this.f67393e.f67368f;
                dVar3.a(-3, "parameter error");
                return;
            }
            i = b.f67361g;
            if (i == -1) {
                context3 = this.f67393e.f67363a;
                if (context3.getPackageName().equals(d.q.a.a.c.b.e.a(Process.myPid()))) {
                    int unused = b.f67361g = 1;
                } else {
                    int unused2 = b.f67361g = 0;
                }
            }
            i2 = b.f67361g;
            if (i2 == 0) {
                dVar2 = this.f67393e.f67368f;
                dVar2.a(-4, "need main process");
                return;
            }
            b bVar = this.f67393e;
            context2 = this.f67393e.f67363a;
            bVar.f67364b = context2.getPackageName();
            a a2 = a.a();
            str = this.f67393e.f67364b;
            a2.d(str);
            b bVar2 = this.f67393e;
            dVar = this.f67393e.f67368f;
            bVar2.i(dVar);
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
