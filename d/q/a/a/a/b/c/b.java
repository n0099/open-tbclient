package d.q.a.a.a.b.c;

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
    public /* synthetic */ a f71334e;

    public b(a aVar) {
        this.f71334e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d eVar;
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        try {
            a aVar = this.f71334e;
            if (iBinder == null) {
                eVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof com.yxcorp.kuaishou.addfp.a.b.a.b)) {
                    eVar = (d) queryLocalInterface;
                }
                eVar = new e(iBinder);
            }
            aVar.f71330c = eVar;
            countDownLatch = this.f71334e.f71331d;
            if (countDownLatch != null) {
                countDownLatch2 = this.f71334e.f71331d;
                countDownLatch2.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f71334e.f71330c = null;
    }
}
