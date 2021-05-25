package d.a.m0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f49196e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f49197f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f49198g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f49199h;

    public c(WheelView wheelView, int i2) {
        this.f49199h = wheelView;
        this.f49198g = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f49196e == Integer.MAX_VALUE) {
            this.f49196e = this.f49198g;
        }
        int i2 = this.f49196e;
        int i3 = (int) (i2 * 0.1f);
        this.f49197f = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.f49197f = -1;
            } else {
                this.f49197f = 1;
            }
        }
        if (Math.abs(this.f49196e) <= 1) {
            this.f49199h.b();
            this.f49199h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f49199h;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f49197f);
        if (!this.f49199h.i()) {
            float itemHeight = this.f49199h.getItemHeight();
            float itemsCount = ((this.f49199h.getItemsCount() - 1) - this.f49199h.getInitPosition()) * itemHeight;
            if (this.f49199h.getTotalScrollY() <= (-this.f49199h.getInitPosition()) * itemHeight || this.f49199h.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f49199h;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f49197f);
                this.f49199h.b();
                this.f49199h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f49199h.getHandler().sendEmptyMessage(1000);
        this.f49196e -= this.f49197f;
    }
}
