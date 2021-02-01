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
/* loaded from: classes15.dex */
public final class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f7857a;
    final /* synthetic */ y pRE;
    final /* synthetic */ w pRQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar, Activity activity, y yVar) {
        this.pRQ = wVar;
        this.f7857a = activity;
        this.pRE = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b2;
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            aVar = this.pRQ.pRL;
            String str = this.f7857a.getApplicationInfo().packageName;
            w wVar = this.pRQ;
            b2 = w.b();
            aVar.a(str, Collections.singletonList(b2), new Bundle(), new x(this, atomicBoolean));
            new Handler().postDelayed(new ak(this, atomicBoolean), IMConnection.RETRY_DELAY_TIMES);
        } catch (RemoteException e) {
            Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e);
            w wVar2 = this.pRQ;
            w.b(this.f7857a, this.pRE);
        }
    }
}
