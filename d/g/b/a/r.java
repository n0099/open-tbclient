package d.g.b.a;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class r implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f69952e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f69953f;

    public r(q qVar, AtomicBoolean atomicBoolean) {
        this.f69953f = qVar;
        this.f69952e = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f69952e.getAndSet(true)) {
            return;
        }
        Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
        q qVar = this.f69953f;
        l lVar = qVar.f69951g;
        l.n(qVar.f69949e, qVar.f69950f);
    }
}
