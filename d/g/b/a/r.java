package d.g.b.a;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class r implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f70056e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f70057f;

    public r(q qVar, AtomicBoolean atomicBoolean) {
        this.f70057f = qVar;
        this.f70056e = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f70056e.getAndSet(true)) {
            return;
        }
        Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
        q qVar = this.f70057f;
        l lVar = qVar.f70055g;
        l.n(qVar.f70053e, qVar.f70054f);
    }
}
