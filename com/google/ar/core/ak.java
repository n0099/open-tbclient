package com.google.ar.core;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
final class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicBoolean f7858a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ aj f7859b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, AtomicBoolean atomicBoolean) {
        this.f7859b = ajVar;
        this.f7858a = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f7858a.getAndSet(true)) {
            Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
            w wVar = this.f7859b.pRQ;
            w.b(this.f7859b.f7857a, this.f7859b.pRE);
        }
    }
}
