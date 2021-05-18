package d.a.j0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f49171e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f49172f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f49173g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f49174h;

    public c(WheelView wheelView, int i2) {
        this.f49174h = wheelView;
        this.f49173g = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f49171e == Integer.MAX_VALUE) {
            this.f49171e = this.f49173g;
        }
        int i2 = this.f49171e;
        int i3 = (int) (i2 * 0.1f);
        this.f49172f = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.f49172f = -1;
            } else {
                this.f49172f = 1;
            }
        }
        if (Math.abs(this.f49171e) <= 1) {
            this.f49174h.b();
            this.f49174h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f49174h;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f49172f);
        if (!this.f49174h.i()) {
            float itemHeight = this.f49174h.getItemHeight();
            float itemsCount = ((this.f49174h.getItemsCount() - 1) - this.f49174h.getInitPosition()) * itemHeight;
            if (this.f49174h.getTotalScrollY() <= (-this.f49174h.getInitPosition()) * itemHeight || this.f49174h.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f49174h;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f49172f);
                this.f49174h.b();
                this.f49174h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f49174h.getHandler().sendEmptyMessage(1000);
        this.f49171e -= this.f49172f;
    }
}
