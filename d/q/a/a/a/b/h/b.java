package d.q.a.a.a.b.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public final class b implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f67330e;

    public b(a aVar) {
        this.f67330e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f67330e.f67325a = com.yxcorp.kuaishou.addfp.a.b.g.b.a(iBinder);
            countDownLatch = this.f67330e.f67328d;
            if (countDownLatch != null) {
                countDownLatch2 = this.f67330e.f67328d;
                countDownLatch2.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f67330e.f67325a = null;
    }
}
