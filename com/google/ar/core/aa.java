package com.google.ar.core;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class aa implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Context f7852b;
    final /* synthetic */ ArCoreApk.a pHK;
    private final /* synthetic */ w pHL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, Context context, ArCoreApk.a aVar) {
        this.pHL = wVar;
        this.f7852b = context;
        this.pHK = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b2;
        try {
            aVar = this.pHL.pHG;
            String str = this.f7852b.getApplicationInfo().packageName;
            w wVar = this.pHL;
            b2 = w.b();
            aVar.a(str, b2, new u(this));
        } catch (RemoteException e) {
            Log.e("ARCore-InstallService", "requestInfo threw", e);
            this.pHK.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }
}
