package d.g.b.a;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class r implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f66178e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f66179f;

    public r(q qVar, AtomicBoolean atomicBoolean) {
        this.f66179f = qVar;
        this.f66178e = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f66178e.getAndSet(true)) {
            return;
        }
        Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
        q qVar = this.f66179f;
        l lVar = qVar.f66177g;
        l.n(qVar.f66175e, qVar.f66176f);
    }
}
