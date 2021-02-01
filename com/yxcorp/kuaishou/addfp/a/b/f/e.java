package com.yxcorp.kuaishou.addfp.a.b.f;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements ServiceConnection {
    private /* synthetic */ d qlN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.qlN = dVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.qlN.qlL = b.a(iBinder);
            countDownLatch = this.qlN.f;
            if (countDownLatch != null) {
                countDownLatch2 = this.qlN.f;
                countDownLatch2.countDown();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.qlN.qlL = null;
    }
}
