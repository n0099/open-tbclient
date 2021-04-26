package d.a.i0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f48343e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f48344f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f48345g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f48346h;

    public c(WheelView wheelView, int i2) {
        this.f48346h = wheelView;
        this.f48345g = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f48343e == Integer.MAX_VALUE) {
            this.f48343e = this.f48345g;
        }
        int i2 = this.f48343e;
        int i3 = (int) (i2 * 0.1f);
        this.f48344f = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.f48344f = -1;
            } else {
                this.f48344f = 1;
            }
        }
        if (Math.abs(this.f48343e) <= 1) {
            this.f48346h.b();
            this.f48346h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f48346h;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f48344f);
        if (!this.f48346h.i()) {
            float itemHeight = this.f48346h.getItemHeight();
            float itemsCount = ((this.f48346h.getItemsCount() - 1) - this.f48346h.getInitPosition()) * itemHeight;
            if (this.f48346h.getTotalScrollY() <= (-this.f48346h.getInitPosition()) * itemHeight || this.f48346h.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f48346h;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f48344f);
                this.f48346h.b();
                this.f48346h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f48346h.getHandler().sendEmptyMessage(1000);
        this.f48343e -= this.f48344f;
    }
}
