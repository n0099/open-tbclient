package d.a.n0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f52977e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f52978f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f52979g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f52980h;

    public c(WheelView wheelView, int i2) {
        this.f52980h = wheelView;
        this.f52979g = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f52977e == Integer.MAX_VALUE) {
            this.f52977e = this.f52979g;
        }
        int i2 = this.f52977e;
        int i3 = (int) (i2 * 0.1f);
        this.f52978f = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.f52978f = -1;
            } else {
                this.f52978f = 1;
            }
        }
        if (Math.abs(this.f52977e) <= 1) {
            this.f52980h.b();
            this.f52980h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f52980h;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f52978f);
        if (!this.f52980h.i()) {
            float itemHeight = this.f52980h.getItemHeight();
            float itemsCount = ((this.f52980h.getItemsCount() - 1) - this.f52980h.getInitPosition()) * itemHeight;
            if (this.f52980h.getTotalScrollY() <= (-this.f52980h.getInitPosition()) * itemHeight || this.f52980h.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f52980h;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f52978f);
                this.f52980h.b();
                this.f52980h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f52980h.getHandler().sendEmptyMessage(1000);
        this.f52977e -= this.f52978f;
    }
}
