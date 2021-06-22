package d.a.n0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f52973e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f52974f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f52975g;

    public a(WheelView wheelView, float f2) {
        this.f52975g = wheelView;
        this.f52974f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f52973e == 2.1474836E9f) {
            if (Math.abs(this.f52974f) > 2000.0f) {
                this.f52973e = this.f52974f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f52973e = this.f52974f;
            }
        }
        if (Math.abs(this.f52973e) >= 0.0f && Math.abs(this.f52973e) <= 20.0f) {
            this.f52975g.b();
            this.f52975g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView wheelView = this.f52975g;
        float f2 = (int) (this.f52973e / 100.0f);
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
        if (!this.f52975g.i()) {
            float itemHeight = this.f52975g.getItemHeight();
            float f3 = (-this.f52975g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f52975g.getItemsCount() - 1) - this.f52975g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f52975g.getTotalScrollY() - d2 < f3) {
                f3 = this.f52975g.getTotalScrollY() + f2;
            } else if (this.f52975g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f52975g.getTotalScrollY() + f2;
            }
            if (this.f52975g.getTotalScrollY() <= f3) {
                this.f52973e = 40.0f;
                this.f52975g.setTotalScrollY((int) f3);
            } else if (this.f52975g.getTotalScrollY() >= itemsCount) {
                this.f52975g.setTotalScrollY((int) itemsCount);
                this.f52973e = -40.0f;
            }
        }
        float f4 = this.f52973e;
        if (f4 < 0.0f) {
            this.f52973e = f4 + 20.0f;
        } else {
            this.f52973e = f4 - 20.0f;
        }
        this.f52975g.getHandler().sendEmptyMessage(1000);
    }
}
