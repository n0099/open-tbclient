package com.yxcorp.kuaishou.addfp.a.b.f;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class e implements ServiceConnection {
    private /* synthetic */ d qgj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.qgj = dVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.qgj.qgh = b.a(iBinder);
            countDownLatch = this.qgj.f;
            if (countDownLatch != null) {
                countDownLatch2 = this.qgj.f;
                countDownLatch2.countDown();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.qgj.qgh = null;
    }
}
