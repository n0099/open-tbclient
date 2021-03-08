package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ e f8603a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f8603a = eVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f8603a.qmJ = b.a(iBinder);
            countDownLatch = this.f8603a.d;
            if (countDownLatch != null) {
                countDownLatch2 = this.f8603a.d;
                countDownLatch2.countDown();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f8603a.qmJ = null;
    }
}
