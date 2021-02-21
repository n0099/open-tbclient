package com.google.ar.core;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class aa implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Context f7854b;
    final /* synthetic */ ArCoreApk.a pSp;
    private final /* synthetic */ w pSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, Context context, ArCoreApk.a aVar) {
        this.pSq = wVar;
        this.f7854b = context;
        this.pSp = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b2;
        try {
            aVar = this.pSq.pSl;
            String str = this.f7854b.getApplicationInfo().packageName;
            w wVar = this.pSq;
            b2 = w.b();
            aVar.a(str, b2, new u(this));
        } catch (RemoteException e) {
            Log.e("ARCore-InstallService", "requestInfo threw", e);
            this.pSp.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }
}
