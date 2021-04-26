package d.q.a.a.a.b.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.yxcorp.kuaishou.addfp.a.b.a.c;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public final class b implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f66812e;

    public b(a aVar) {
        this.f66812e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            this.f66812e.f66808b = c.a(iBinder);
            countDownLatch = this.f66812e.f66810d;
            if (countDownLatch != null) {
                countDownLatch2 = this.f66812e.f66810d;
                countDownLatch2.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f66812e.f66808b = null;
    }
}
