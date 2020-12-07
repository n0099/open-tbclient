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
/* loaded from: classes17.dex */
public final class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f4042a;
    final /* synthetic */ w ptC;
    final /* synthetic */ y ptn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar, Activity activity, y yVar) {
        this.ptC = wVar;
        this.f4042a = activity;
        this.ptn = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b;
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            aVar = this.ptC.ptw;
            String str = this.f4042a.getApplicationInfo().packageName;
            w wVar = this.ptC;
            b = w.b();
            aVar.a(str, Collections.singletonList(b), new Bundle(), new x(this, atomicBoolean));
            new Handler().postDelayed(new ak(this, atomicBoolean), IMConnection.RETRY_DELAY_TIMES);
        } catch (RemoteException e) {
            Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e);
            w wVar2 = this.ptC;
            w.b(this.f4042a, this.ptn);
        }
    }
}
