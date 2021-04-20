package d.q.a.a.a.b.g;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public final class b implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f68321e;

    public b(a aVar) {
        this.f68321e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f68321e.f68313a = com.yxcorp.kuaishou.addfp.a.b.f.b.a(iBinder);
            countDownLatch = this.f68321e.f68318f;
            if (countDownLatch != null) {
                countDownLatch2 = this.f68321e.f68318f;
                countDownLatch2.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f68321e.f68313a = null;
    }
}
