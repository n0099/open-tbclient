package com.google.ar.core;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
final class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicBoolean f8156a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ aj f8157b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar, AtomicBoolean atomicBoolean) {
        this.f8157b = ajVar;
        this.f8156a = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f8156a.getAndSet(true)) {
            Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
            w wVar = this.f8157b.pMl;
            w.b(this.f8157b.f8155a, this.f8157b.pLZ);
        }
    }
}
