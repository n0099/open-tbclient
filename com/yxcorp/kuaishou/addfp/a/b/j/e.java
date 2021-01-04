package com.yxcorp.kuaishou.addfp.a.b.j;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class e implements ServiceConnection {
    private /* synthetic */ d qeK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.qeK = dVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.qeK.qeJ = b.a(iBinder);
            countDownLatch = this.qeK.f;
            if (countDownLatch != null) {
                countDownLatch2 = this.qeK.f;
                countDownLatch2.countDown();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.qeK.qeJ = null;
    }
}
