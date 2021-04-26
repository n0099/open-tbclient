package d.a.i0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f48339e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f48340f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f48341g;

    public a(WheelView wheelView, float f2) {
        this.f48341g = wheelView;
        this.f48340f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f48339e == 2.1474836E9f) {
            if (Math.abs(this.f48340f) > 2000.0f) {
                this.f48339e = this.f48340f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f48339e = this.f48340f;
            }
        }
        if (Math.abs(this.f48339e) >= 0.0f && Math.abs(this.f48339e) <= 20.0f) {
            this.f48341g.b();
            this.f48341g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView wheelView = this.f48341g;
        float f2 = (int) (this.f48339e / 100.0f);
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
        if (!this.f48341g.i()) {
            float itemHeight = this.f48341g.getItemHeight();
            float f3 = (-this.f48341g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f48341g.getItemsCount() - 1) - this.f48341g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f48341g.getTotalScrollY() - d2 < f3) {
                f3 = this.f48341g.getTotalScrollY() + f2;
            } else if (this.f48341g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f48341g.getTotalScrollY() + f2;
            }
            if (this.f48341g.getTotalScrollY() <= f3) {
                this.f48339e = 40.0f;
                this.f48341g.setTotalScrollY((int) f3);
            } else if (this.f48341g.getTotalScrollY() >= itemsCount) {
                this.f48341g.setTotalScrollY((int) itemsCount);
                this.f48339e = -40.0f;
            }
        }
        float f4 = this.f48339e;
        if (f4 < 0.0f) {
            this.f48339e = f4 + 20.0f;
        } else {
            this.f48339e = f4 - 20.0f;
        }
        this.f48341g.getHandler().sendEmptyMessage(1000);
    }
}
