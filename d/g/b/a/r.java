package d.g.b.a;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class r implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f66085e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f66086f;

    public r(q qVar, AtomicBoolean atomicBoolean) {
        this.f66086f = qVar;
        this.f66085e = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f66085e.getAndSet(true)) {
            return;
        }
        Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
        q qVar = this.f66086f;
        l lVar = qVar.f66084g;
        l.n(qVar.f66082e, qVar.f66083f);
    }
}
