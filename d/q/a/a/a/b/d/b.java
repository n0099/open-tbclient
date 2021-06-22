package d.q.a.a.a.b.d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public final class b implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f71444e;

    public b(a aVar) {
        this.f71444e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f71444e.f71440b = com.yxcorp.kuaishou.addfp.a.b.c.b.a(iBinder);
            countDownLatch = this.f71444e.f71442d;
            if (countDownLatch != null) {
                countDownLatch2 = this.f71444e.f71442d;
                countDownLatch2.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f71444e.f71440b = null;
    }
}
