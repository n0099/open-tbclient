package d.r.a.a;

import android.content.Context;
import android.os.Process;
import d.r.a.a.c.a.a;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ b f68533e;

    public e(b bVar) {
        this.f68533e = bVar;
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
            context = this.f68533e.f68503a;
            if (context == null) {
                dVar3 = this.f68533e.f68508f;
                dVar3.a(-3, "parameter error");
                return;
            }
            i = b.f68501g;
            if (i == -1) {
                context3 = this.f68533e.f68503a;
                if (context3.getPackageName().equals(d.r.a.a.c.b.e.a(Process.myPid()))) {
                    int unused = b.f68501g = 1;
                } else {
                    int unused2 = b.f68501g = 0;
                }
            }
            i2 = b.f68501g;
            if (i2 == 0) {
                dVar2 = this.f68533e.f68508f;
                dVar2.a(-4, "need main process");
                return;
            }
            b bVar = this.f68533e;
            context2 = this.f68533e.f68503a;
            bVar.f68504b = context2.getPackageName();
            a a2 = a.a();
            str = this.f68533e.f68504b;
            a2.d(str);
            b bVar2 = this.f68533e;
            dVar = this.f68533e.f68508f;
            bVar2.i(dVar);
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
        }
    }
}
