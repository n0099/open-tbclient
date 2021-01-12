package com.google.ar.core;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.android.imsdk.internal.IMConnection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f7855a;
    final /* synthetic */ w pHK;
    final /* synthetic */ y pHy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar, Activity activity, y yVar) {
        this.pHK = wVar;
        this.f7855a = activity;
        this.pHy = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b2;
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            aVar = this.pHK.pHF;
            String str = this.f7855a.getApplicationInfo().packageName;
            w wVar = this.pHK;
            b2 = w.b();
            aVar.a(str, Collections.singletonList(b2), new Bundle(), new x(this, atomicBoolean));
            new Handler().postDelayed(new ak(this, atomicBoolean), IMConnection.RETRY_DELAY_TIMES);
        } catch (RemoteException e) {
            Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e);
            w wVar2 = this.pHK;
            w.b(this.f7855a, this.pHy);
        }
    }
}
