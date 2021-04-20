package d.b.h0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f50432e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f50433f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f50434g;

    public a(WheelView wheelView, float f2) {
        this.f50434g = wheelView;
        this.f50433f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f50432e == 2.1474836E9f) {
            if (Math.abs(this.f50433f) > 2000.0f) {
                this.f50432e = this.f50433f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f50432e = this.f50433f;
            }
        }
        if (Math.abs(this.f50432e) >= 0.0f && Math.abs(this.f50432e) <= 20.0f) {
            this.f50434g.b();
            this.f50434g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView wheelView = this.f50434g;
        float f2 = (int) (this.f50432e / 100.0f);
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
        if (!this.f50434g.i()) {
            float itemHeight = this.f50434g.getItemHeight();
            float f3 = (-this.f50434g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f50434g.getItemsCount() - 1) - this.f50434g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f50434g.getTotalScrollY() - d2 < f3) {
                f3 = this.f50434g.getTotalScrollY() + f2;
            } else if (this.f50434g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f50434g.getTotalScrollY() + f2;
            }
            if (this.f50434g.getTotalScrollY() <= f3) {
                this.f50432e = 40.0f;
                this.f50434g.setTotalScrollY((int) f3);
            } else if (this.f50434g.getTotalScrollY() >= itemsCount) {
                this.f50434g.setTotalScrollY((int) itemsCount);
                this.f50432e = -40.0f;
            }
        }
        float f4 = this.f50432e;
        if (f4 < 0.0f) {
            this.f50432e = f4 + 20.0f;
        } else {
            this.f50432e = f4 - 20.0f;
        }
        this.f50434g.getHandler().sendEmptyMessage(1000);
    }
}
