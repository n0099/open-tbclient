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
/* loaded from: classes6.dex */
public final class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f8155a;
    final /* synthetic */ y pLZ;
    final /* synthetic */ w pMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar, Activity activity, y yVar) {
        this.pMl = wVar;
        this.f8155a = activity;
        this.pLZ = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.a.b.a.a.a.a aVar;
        Bundle b2;
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            aVar = this.pMl.pMg;
            String str = this.f8155a.getApplicationInfo().packageName;
            w wVar = this.pMl;
            b2 = w.b();
            aVar.a(str, Collections.singletonList(b2), new Bundle(), new x(this, atomicBoolean));
            new Handler().postDelayed(new ak(this, atomicBoolean), IMConnection.RETRY_DELAY_TIMES);
        } catch (RemoteException e) {
            Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e);
            w wVar2 = this.pMl;
            w.b(this.f8155a, this.pLZ);
        }
    }
}
