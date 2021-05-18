package d.a.i0.a.z1.a.e.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes3.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WheelView3d f45858a;

    public b(WheelView3d wheelView3d) {
        this.f45858a = wheelView3d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1000) {
            this.f45858a.invalidate();
        } else if (i2 == 2000) {
            this.f45858a.r(WheelView3d.ACTION.FLING);
        } else if (i2 != 3000) {
        } else {
            this.f45858a.n();
        }
    }
}
