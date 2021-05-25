package d.g.b.a;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class r implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f66221e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q f66222f;

    public r(q qVar, AtomicBoolean atomicBoolean) {
        this.f66222f = qVar;
        this.f66221e = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f66221e.getAndSet(true)) {
            return;
        }
        Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
        q qVar = this.f66222f;
        l lVar = qVar.f66220g;
        l.n(qVar.f66218e, qVar.f66219f);
    }
}
