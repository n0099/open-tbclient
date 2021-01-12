package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class f implements ServiceConnection {
    private /* synthetic */ e qby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.qby = eVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.qby.qbw = c.a(iBinder);
            countDownLatch = this.qby.d;
            if (countDownLatch != null) {
                countDownLatch2 = this.qby.d;
                countDownLatch2.countDown();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.qby.qbw = null;
    }
}
