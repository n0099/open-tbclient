package d.q.a.a.a.b.k;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public final class b implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f66879e;

    public b(a aVar) {
        this.f66879e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f66879e.f66874a = com.yxcorp.kuaishou.addfp.a.b.j.b.a(iBinder);
            countDownLatch = this.f66879e.f66877d;
            if (countDownLatch != null) {
                countDownLatch2 = this.f66879e.f66877d;
                countDownLatch2.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f66879e.f66874a = null;
    }
}
