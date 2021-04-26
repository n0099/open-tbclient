package d.g.b.a;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class r implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f65492e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f65493f;

    public r(q qVar, AtomicBoolean atomicBoolean) {
        this.f65493f = qVar;
        this.f65492e = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f65492e.getAndSet(true)) {
            return;
        }
        Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
        q qVar = this.f65493f;
        l lVar = qVar.f65491g;
        l.n(qVar.f65489e, qVar.f65490f);
    }
}
