package d.g.b.a;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class r implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f66930e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f66931f;

    public r(q qVar, AtomicBoolean atomicBoolean) {
        this.f66931f = qVar;
        this.f66930e = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f66930e.getAndSet(true)) {
            return;
        }
        Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
        q qVar = this.f66931f;
        l lVar = qVar.f66929g;
        l.n(qVar.f66927e, qVar.f66928f);
    }
}
