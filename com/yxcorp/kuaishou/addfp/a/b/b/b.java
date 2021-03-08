package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.util.concurrent.CountDownLatch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b implements ServiceConnection {
    private /* synthetic */ a qmI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.qmI = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d eVar;
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            a aVar = this.qmI;
            if (iBinder == null) {
                eVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                eVar = (queryLocalInterface == null || !(queryLocalInterface instanceof com.yxcorp.kuaishou.addfp.a.b.a.b)) ? new e(iBinder) : (d) queryLocalInterface;
            }
            aVar.qmG = eVar;
            countDownLatch = this.qmI.d;
            if (countDownLatch != null) {
                countDownLatch2 = this.qmI.d;
                countDownLatch2.countDown();
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.qmI.qmG = null;
    }
}
