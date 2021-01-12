package com.google.ar.core;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
final class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicBoolean f7856a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ aj f7857b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, AtomicBoolean atomicBoolean) {
        this.f7857b = ajVar;
        this.f7856a = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f7856a.getAndSet(true)) {
            Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
            w wVar = this.f7857b.pHK;
            w.b(this.f7857b.f7855a, this.f7857b.pHy);
        }
    }
}
