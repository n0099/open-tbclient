package com.google.ar.core;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
final class ak implements Runnable {
    private final /* synthetic */ AtomicBoolean a;
    private final /* synthetic */ aj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, AtomicBoolean atomicBoolean) {
        this.b = ajVar;
        this.a = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.a.getAndSet(true)) {
            Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
            w wVar = this.b.niG;
            w.b(this.b.a, this.b.nir);
        }
    }
}
