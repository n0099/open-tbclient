package d.q.a.a.a.b.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public final class b implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f67335e;

    public b(a aVar) {
        this.f67335e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f67335e.f67330a = com.yxcorp.kuaishou.addfp.a.b.g.b.a(iBinder);
            countDownLatch = this.f67335e.f67333d;
            if (countDownLatch != null) {
                countDownLatch2 = this.f67335e.f67333d;
                countDownLatch2.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f67335e.f67330a = null;
    }
}
