package d.b.h0.b1.o.b.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes3.dex */
public final class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WheelView f50041a;

    public b(WheelView wheelView) {
        this.f50041a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f50041a.invalidate();
        } else if (i == 2000) {
            this.f50041a.r(WheelView.ACTION.FLING);
        } else if (i != 3000) {
        } else {
            this.f50041a.n();
        }
    }
}
