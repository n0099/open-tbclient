package com.google.ar.core;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes17.dex */
final class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicBoolean f4043a;
    private final /* synthetic */ aj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, AtomicBoolean atomicBoolean) {
        this.b = ajVar;
        this.f4043a = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f4043a.getAndSet(true)) {
            Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
            w wVar = this.b.ptE;
            w.b(this.b.f4042a, this.b.ptp);
        }
    }
}
