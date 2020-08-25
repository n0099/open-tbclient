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
/* loaded from: classes11.dex */
public final class aj implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ y nCk;
    final /* synthetic */ w nCz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar, Activity activity, y yVar) {
        this.nCz = wVar;
        this.a = activity;
        this.nCk = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b;
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            aVar = this.nCz.nCs;
            String str = this.a.getApplicationInfo().packageName;
            w wVar = this.nCz;
            b = w.b();
            aVar.a(str, Collections.singletonList(b), new Bundle(), new x(this, atomicBoolean));
            new Handler().postDelayed(new ak(this, atomicBoolean), IMConnection.RETRY_DELAY_TIMES);
        } catch (RemoteException e) {
            Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e);
            w wVar2 = this.nCz;
            w.b(this.a, this.nCk);
        }
    }
}
