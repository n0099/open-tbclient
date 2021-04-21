package d.r.a.a.a.b.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import com.yxcorp.kuaishou.addfp.a.b.b.d;
import com.yxcorp.kuaishou.addfp.a.b.b.e;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public final class b implements ServiceConnection {

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ a f68440e;

    public b(a aVar) {
        this.f68440e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d eVar;
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            a aVar = this.f68440e;
            if (iBinder == null) {
                eVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof com.yxcorp.kuaishou.addfp.a.b.a.b)) {
                    eVar = (d) queryLocalInterface;
                }
                eVar = new e(iBinder);
            }
            aVar.f68436c = eVar;
            countDownLatch = this.f68440e.f68437d;
            if (countDownLatch != null) {
                countDownLatch2 = this.f68440e.f68437d;
                countDownLatch2.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f68440e.f68436c = null;
    }
}
