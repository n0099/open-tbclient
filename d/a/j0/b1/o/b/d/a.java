package d.a.j0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f49167e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f49168f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView f49169g;

    public a(WheelView wheelView, float f2) {
        this.f49169g = wheelView;
        this.f49168f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f49167e == 2.1474836E9f) {
            if (Math.abs(this.f49168f) > 2000.0f) {
                this.f49167e = this.f49168f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f49167e = this.f49168f;
            }
        }
        if (Math.abs(this.f49167e) >= 0.0f && Math.abs(this.f49167e) <= 20.0f) {
            this.f49169g.b();
            this.f49169g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView wheelView = this.f49169g;
        float f2 = (int) (this.f49167e / 100.0f);
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
        if (!this.f49169g.i()) {
            float itemHeight = this.f49169g.getItemHeight();
            float f3 = (-this.f49169g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f49169g.getItemsCount() - 1) - this.f49169g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f49169g.getTotalScrollY() - d2 < f3) {
                f3 = this.f49169g.getTotalScrollY() + f2;
            } else if (this.f49169g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f49169g.getTotalScrollY() + f2;
            }
            if (this.f49169g.getTotalScrollY() <= f3) {
                this.f49167e = 40.0f;
                this.f49169g.setTotalScrollY((int) f3);
            } else if (this.f49169g.getTotalScrollY() >= itemsCount) {
                this.f49169g.setTotalScrollY((int) itemsCount);
                this.f49167e = -40.0f;
            }
        }
        float f4 = this.f49167e;
        if (f4 < 0.0f) {
            this.f49167e = f4 + 20.0f;
        } else {
            this.f49167e = f4 - 20.0f;
        }
        this.f49169g.getHandler().sendEmptyMessage(1000);
    }
}
