package com.yxcorp.kuaishou.addfp.a.b.g;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements ServiceConnection {
    private /* synthetic */ d qmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.qmR = dVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.qmR.qmQ = b.a(iBinder);
            countDownLatch = this.qmR.e;
            if (countDownLatch != null) {
                countDownLatch2 = this.qmR.e;
                countDownLatch2.countDown();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.qmR.qmQ = null;
    }
}
