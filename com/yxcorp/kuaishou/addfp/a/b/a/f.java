package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f implements ServiceConnection {
    private /* synthetic */ e qmE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.qmE = eVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.qmE.qmC = c.a(iBinder);
            countDownLatch = this.qmE.d;
            if (countDownLatch != null) {
                countDownLatch2 = this.qmE.d;
                countDownLatch2.countDown();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.qmE.qmC = null;
    }
}
