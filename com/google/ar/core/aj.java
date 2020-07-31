package com.google.ar.core;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class aj implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ w niG;
    final /* synthetic */ y nir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar, Activity activity, y yVar) {
        this.niG = wVar;
        this.a = activity;
        this.nir = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b;
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            aVar = this.niG.niz;
            String str = this.a.getApplicationInfo().packageName;
            w wVar = this.niG;
            b = w.b();
            aVar.a(str, Collections.singletonList(b), new Bundle(), new x(this, atomicBoolean));
            new Handler().postDelayed(new ak(this, atomicBoolean), 3000L);
        } catch (RemoteException e) {
            Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e);
            w wVar2 = this.niG;
            w.b(this.a, this.nir);
        }
    }
}
