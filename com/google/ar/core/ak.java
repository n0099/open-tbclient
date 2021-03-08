package com.google.ar.core;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes14.dex */
final class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicBoolean f5262a;
    private final /* synthetic */ aj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, AtomicBoolean atomicBoolean) {
        this.b = ajVar;
        this.f5262a = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f5262a.getAndSet(true)) {
            Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
            w wVar = this.b.pTf;
            w.b(this.b.f5261a, this.b.pST);
        }
    }
}
