package com.google.ar.core;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class aa implements Runnable {
    private final /* synthetic */ Context b;
    final /* synthetic */ ArCoreApk.a pcP;
    private final /* synthetic */ w pcQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, Context context, ArCoreApk.a aVar) {
        this.pcQ = wVar;
        this.b = context;
        this.pcP = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b;
        try {
            aVar = this.pcQ.pcK;
            String str = this.b.getApplicationInfo().packageName;
            w wVar = this.pcQ;
            b = w.b();
            aVar.a(str, b, new u(this));
        } catch (RemoteException e) {
            Log.e("ARCore-InstallService", "requestInfo threw", e);
            this.pcP.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }
}
