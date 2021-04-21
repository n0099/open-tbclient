package d.b.i0.b1.o.b.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes3.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WheelView f50771a;

    public b(WheelView wheelView) {
        this.f50771a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f50771a.invalidate();
        } else if (i == 2000) {
            this.f50771a.r(WheelView.ACTION.FLING);
        } else if (i != 3000) {
        } else {
            this.f50771a.n();
        }
    }
}
