package d.b.g0.a.q1.a.f.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes2.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WheelView3d f45533a;

    public b(WheelView3d wheelView3d) {
        this.f45533a = wheelView3d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f45533a.invalidate();
        } else if (i == 2000) {
            this.f45533a.r(WheelView3d.ACTION.FLING);
        } else if (i != 3000) {
        } else {
            this.f45533a.n();
        }
    }
}
