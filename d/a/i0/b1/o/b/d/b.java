package d.a.i0.b1.o.b.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes3.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WheelView f48342a;

    public b(WheelView wheelView) {
        this.f48342a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1000) {
            this.f48342a.invalidate();
        } else if (i2 == 2000) {
            this.f48342a.r(WheelView.ACTION.FLING);
        } else if (i2 != 3000) {
        } else {
            this.f48342a.n();
        }
    }
}
