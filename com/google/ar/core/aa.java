package com.google.ar.core;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class aa implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Context f8151b;
    final /* synthetic */ ArCoreApk.a pKC;
    private final /* synthetic */ w pKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, Context context, ArCoreApk.a aVar) {
        this.pKD = wVar;
        this.f8151b = context;
        this.pKC = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b2;
        try {
            aVar = this.pKD.pKy;
            String str = this.f8151b.getApplicationInfo().packageName;
            w wVar = this.pKD;
            b2 = w.b();
            aVar.a(str, b2, new u(this));
        } catch (RemoteException e) {
            Log.e("ARCore-InstallService", "requestInfo threw", e);
            this.pKC.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }
}
