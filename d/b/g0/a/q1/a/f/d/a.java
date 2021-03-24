package d.b.g0.a.q1.a.f.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f45529e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f45530f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView3d f45531g;

    public a(WheelView3d wheelView3d, float f2) {
        this.f45531g = wheelView3d;
        this.f45530f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f45529e == 2.1474836E9f) {
            if (Math.abs(this.f45530f) > 2000.0f) {
                this.f45529e = this.f45530f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f45529e = this.f45530f;
            }
        }
        if (Math.abs(this.f45529e) >= 0.0f && Math.abs(this.f45529e) <= 20.0f) {
            this.f45531g.b();
            this.f45531g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView3d wheelView3d = this.f45531g;
        float f2 = (int) (this.f45529e / 100.0f);
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
        if (!this.f45531g.i()) {
            float itemHeight = this.f45531g.getItemHeight();
            float f3 = (-this.f45531g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f45531g.getItemsCount() - 1) - this.f45531g.getInitPosition()) * itemHeight;
            double totalScrollY = this.f45531g.getTotalScrollY();
            double d2 = itemHeight;
            Double.isNaN(d2);
            double d3 = d2 * 0.25d;
            Double.isNaN(totalScrollY);
            if (totalScrollY - d3 < f3) {
                f3 = this.f45531g.getTotalScrollY() + f2;
            } else {
                double totalScrollY2 = this.f45531g.getTotalScrollY();
                Double.isNaN(totalScrollY2);
                if (totalScrollY2 + d3 > itemsCount) {
                    itemsCount = this.f45531g.getTotalScrollY() + f2;
                }
            }
            if (this.f45531g.getTotalScrollY() <= f3) {
                this.f45529e = 40.0f;
                this.f45531g.setTotalScrollY((int) f3);
            } else if (this.f45531g.getTotalScrollY() >= itemsCount) {
                this.f45531g.setTotalScrollY((int) itemsCount);
                this.f45529e = -40.0f;
            }
        }
        float f4 = this.f45529e;
        if (f4 < 0.0f) {
            this.f45529e = f4 + 20.0f;
        } else {
            this.f45529e = f4 - 20.0f;
        }
        this.f45531g.getHandler().sendEmptyMessage(1000);
    }
}
