package d.g.b.a;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class r implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f66084e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f66085f;

    public r(q qVar, AtomicBoolean atomicBoolean) {
        this.f66085f = qVar;
        this.f66084e = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f66084e.getAndSet(true)) {
            return;
        }
        Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
        q qVar = this.f66085f;
        l lVar = qVar.f66083g;
        l.n(qVar.f66081e, qVar.f66082f);
    }
}
