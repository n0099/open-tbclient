package d.b.h0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f50436e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f50437f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f50438g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f50439h;

    public c(WheelView wheelView, int i) {
        this.f50439h = wheelView;
        this.f50438g = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f50436e == Integer.MAX_VALUE) {
            this.f50436e = this.f50438g;
        }
        int i = this.f50436e;
        int i2 = (int) (i * 0.1f);
        this.f50437f = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f50437f = -1;
            } else {
                this.f50437f = 1;
            }
        }
        if (Math.abs(this.f50436e) <= 1) {
            this.f50439h.b();
            this.f50439h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f50439h;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f50437f);
        if (!this.f50439h.i()) {
            float itemHeight = this.f50439h.getItemHeight();
            float itemsCount = ((this.f50439h.getItemsCount() - 1) - this.f50439h.getInitPosition()) * itemHeight;
            if (this.f50439h.getTotalScrollY() <= (-this.f50439h.getInitPosition()) * itemHeight || this.f50439h.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f50439h;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f50437f);
                this.f50439h.b();
                this.f50439h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f50439h.getHandler().sendEmptyMessage(1000);
        this.f50436e -= this.f50437f;
    }
}
