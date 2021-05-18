package d.q.a.a.a.b.g;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public final class b implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f67533e;

    public b(a aVar) {
        this.f67533e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f67533e.f67525a = com.yxcorp.kuaishou.addfp.a.b.f.b.a(iBinder);
            countDownLatch = this.f67533e.f67530f;
            if (countDownLatch != null) {
                countDownLatch2 = this.f67533e.f67530f;
                countDownLatch2.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f67533e.f67525a = null;
    }
}
