package d.b.h0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f50042e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f50043f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f50044g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f50045h;

    public c(WheelView wheelView, int i) {
        this.f50045h = wheelView;
        this.f50044g = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f50042e == Integer.MAX_VALUE) {
            this.f50042e = this.f50044g;
        }
        int i = this.f50042e;
        int i2 = (int) (i * 0.1f);
        this.f50043f = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f50043f = -1;
            } else {
                this.f50043f = 1;
            }
        }
        if (Math.abs(this.f50042e) <= 1) {
            this.f50045h.b();
            this.f50045h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f50045h;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f50043f);
        if (!this.f50045h.i()) {
            float itemHeight = this.f50045h.getItemHeight();
            float itemsCount = ((this.f50045h.getItemsCount() - 1) - this.f50045h.getInitPosition()) * itemHeight;
            if (this.f50045h.getTotalScrollY() <= (-this.f50045h.getInitPosition()) * itemHeight || this.f50045h.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f50045h;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f50043f);
                this.f50045h.b();
                this.f50045h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f50045h.getHandler().sendEmptyMessage(1000);
        this.f50042e -= this.f50043f;
    }
}
