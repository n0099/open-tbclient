package d.a.m0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f49192e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f49193f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f49194g;

    public a(WheelView wheelView, float f2) {
        this.f49194g = wheelView;
        this.f49193f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f49192e == 2.1474836E9f) {
            if (Math.abs(this.f49193f) > 2000.0f) {
                this.f49192e = this.f49193f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f49192e = this.f49193f;
            }
        }
        if (Math.abs(this.f49192e) >= 0.0f && Math.abs(this.f49192e) <= 20.0f) {
            this.f49194g.b();
            this.f49194g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView wheelView = this.f49194g;
        float f2 = (int) (this.f49192e / 100.0f);
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
        if (!this.f49194g.i()) {
            float itemHeight = this.f49194g.getItemHeight();
            float f3 = (-this.f49194g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f49194g.getItemsCount() - 1) - this.f49194g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f49194g.getTotalScrollY() - d2 < f3) {
                f3 = this.f49194g.getTotalScrollY() + f2;
            } else if (this.f49194g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f49194g.getTotalScrollY() + f2;
            }
            if (this.f49194g.getTotalScrollY() <= f3) {
                this.f49192e = 40.0f;
                this.f49194g.setTotalScrollY((int) f3);
            } else if (this.f49194g.getTotalScrollY() >= itemsCount) {
                this.f49194g.setTotalScrollY((int) itemsCount);
                this.f49192e = -40.0f;
            }
        }
        float f4 = this.f49192e;
        if (f4 < 0.0f) {
            this.f49192e = f4 + 20.0f;
        } else {
            this.f49192e = f4 - 20.0f;
        }
        this.f49194g.getHandler().sendEmptyMessage(1000);
    }
}
