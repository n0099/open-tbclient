package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class f implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ e f14351a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f14351a = eVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f14351a.qbC = b.a(iBinder);
            countDownLatch = this.f14351a.d;
            if (countDownLatch != null) {
                countDownLatch2 = this.f14351a.d;
                countDownLatch2.countDown();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f14351a.qbC = null;
    }
}
