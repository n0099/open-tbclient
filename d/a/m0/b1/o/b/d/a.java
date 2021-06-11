package d.a.m0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f52866e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f52867f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f52868g;

    public a(WheelView wheelView, float f2) {
        this.f52868g = wheelView;
        this.f52867f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f52866e == 2.1474836E9f) {
            if (Math.abs(this.f52867f) > 2000.0f) {
                this.f52866e = this.f52867f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f52866e = this.f52867f;
            }
        }
        if (Math.abs(this.f52866e) >= 0.0f && Math.abs(this.f52866e) <= 20.0f) {
            this.f52868g.b();
            this.f52868g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView wheelView = this.f52868g;
        float f2 = (int) (this.f52866e / 100.0f);
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
        if (!this.f52868g.i()) {
            float itemHeight = this.f52868g.getItemHeight();
            float f3 = (-this.f52868g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f52868g.getItemsCount() - 1) - this.f52868g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f52868g.getTotalScrollY() - d2 < f3) {
                f3 = this.f52868g.getTotalScrollY() + f2;
            } else if (this.f52868g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f52868g.getTotalScrollY() + f2;
            }
            if (this.f52868g.getTotalScrollY() <= f3) {
                this.f52866e = 40.0f;
                this.f52868g.setTotalScrollY((int) f3);
            } else if (this.f52868g.getTotalScrollY() >= itemsCount) {
                this.f52868g.setTotalScrollY((int) itemsCount);
                this.f52866e = -40.0f;
            }
        }
        float f4 = this.f52866e;
        if (f4 < 0.0f) {
            this.f52866e = f4 + 20.0f;
        } else {
            this.f52866e = f4 - 20.0f;
        }
        this.f52868g.getHandler().sendEmptyMessage(1000);
    }
}
