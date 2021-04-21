package d.b.i0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f50768e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f50769f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f50770g;

    public a(WheelView wheelView, float f2) {
        this.f50770g = wheelView;
        this.f50769f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f50768e == 2.1474836E9f) {
            if (Math.abs(this.f50769f) > 2000.0f) {
                this.f50768e = this.f50769f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f50768e = this.f50769f;
            }
        }
        if (Math.abs(this.f50768e) >= 0.0f && Math.abs(this.f50768e) <= 20.0f) {
            this.f50770g.b();
            this.f50770g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView wheelView = this.f50770g;
        float f2 = (int) (this.f50768e / 100.0f);
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
        if (!this.f50770g.i()) {
            float itemHeight = this.f50770g.getItemHeight();
            float f3 = (-this.f50770g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f50770g.getItemsCount() - 1) - this.f50770g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f50770g.getTotalScrollY() - d2 < f3) {
                f3 = this.f50770g.getTotalScrollY() + f2;
            } else if (this.f50770g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f50770g.getTotalScrollY() + f2;
            }
            if (this.f50770g.getTotalScrollY() <= f3) {
                this.f50768e = 40.0f;
                this.f50770g.setTotalScrollY((int) f3);
            } else if (this.f50770g.getTotalScrollY() >= itemsCount) {
                this.f50770g.setTotalScrollY((int) itemsCount);
                this.f50768e = -40.0f;
            }
        }
        float f4 = this.f50768e;
        if (f4 < 0.0f) {
            this.f50768e = f4 + 20.0f;
        } else {
            this.f50768e = f4 - 20.0f;
        }
        this.f50770g.getHandler().sendEmptyMessage(1000);
    }
}
