package d.h.b.a;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class r implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f67077e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f67078f;

    public r(q qVar, AtomicBoolean atomicBoolean) {
        this.f67078f = qVar;
        this.f67077e = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f67077e.getAndSet(true)) {
            return;
        }
        Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
        q qVar = this.f67078f;
        l lVar = qVar.f67076g;
        l.n(qVar.f67074e, qVar.f67075f);
    }
}
