package d.b.h0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f50038e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f50039f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f50040g;

    public a(WheelView wheelView, float f2) {
        this.f50040g = wheelView;
        this.f50039f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f50038e == 2.1474836E9f) {
            if (Math.abs(this.f50039f) > 2000.0f) {
                this.f50038e = this.f50039f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f50038e = this.f50039f;
            }
        }
        if (Math.abs(this.f50038e) >= 0.0f && Math.abs(this.f50038e) <= 20.0f) {
            this.f50040g.b();
            this.f50040g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView wheelView = this.f50040g;
        float f2 = (int) (this.f50038e / 100.0f);
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
        if (!this.f50040g.i()) {
            float itemHeight = this.f50040g.getItemHeight();
            float f3 = (-this.f50040g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f50040g.getItemsCount() - 1) - this.f50040g.getInitPosition()) * itemHeight;
            double totalScrollY = this.f50040g.getTotalScrollY();
            double d2 = itemHeight;
            Double.isNaN(d2);
            double d3 = d2 * 0.25d;
            Double.isNaN(totalScrollY);
            if (totalScrollY - d3 < f3) {
                f3 = this.f50040g.getTotalScrollY() + f2;
            } else {
                double totalScrollY2 = this.f50040g.getTotalScrollY();
                Double.isNaN(totalScrollY2);
                if (totalScrollY2 + d3 > itemsCount) {
                    itemsCount = this.f50040g.getTotalScrollY() + f2;
                }
            }
            if (this.f50040g.getTotalScrollY() <= f3) {
                this.f50038e = 40.0f;
                this.f50040g.setTotalScrollY((int) f3);
            } else if (this.f50040g.getTotalScrollY() >= itemsCount) {
                this.f50040g.setTotalScrollY((int) itemsCount);
                this.f50038e = -40.0f;
            }
        }
        float f4 = this.f50038e;
        if (f4 < 0.0f) {
            this.f50038e = f4 + 20.0f;
        } else {
            this.f50038e = f4 - 20.0f;
        }
        this.f50040g.getHandler().sendEmptyMessage(1000);
    }
}
