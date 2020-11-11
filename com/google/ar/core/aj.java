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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f4039a;
    final /* synthetic */ y pcC;
    final /* synthetic */ w pcQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar, Activity activity, y yVar) {
        this.pcQ = wVar;
        this.f4039a = activity;
        this.pcC = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b;
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            aVar = this.pcQ.pcK;
            String str = this.f4039a.getApplicationInfo().packageName;
            w wVar = this.pcQ;
            b = w.b();
            aVar.a(str, Collections.singletonList(b), new Bundle(), new x(this, atomicBoolean));
            new Handler().postDelayed(new ak(this, atomicBoolean), IMConnection.RETRY_DELAY_TIMES);
        } catch (RemoteException e) {
            Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e);
            w wVar2 = this.pcQ;
            w.b(this.f4039a, this.pcC);
        }
    }
}
