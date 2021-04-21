package d.r.a.a.a.b.d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public final class b implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f68446e;

    public b(a aVar) {
        this.f68446e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f68446e.f68442b = com.yxcorp.kuaishou.addfp.a.b.c.b.a(iBinder);
            countDownLatch = this.f68446e.f68444d;
            if (countDownLatch != null) {
                countDownLatch2 = this.f68446e.f68444d;
                countDownLatch2.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f68446e.f68442b = null;
    }
}
