package d.a.h0.a.q1.a.f.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f43600e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f43601f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView3d f43602g;

    public a(WheelView3d wheelView3d, float f2) {
        this.f43602g = wheelView3d;
        this.f43601f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f43600e == 2.1474836E9f) {
            if (Math.abs(this.f43601f) > 2000.0f) {
                this.f43600e = this.f43601f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f43600e = this.f43601f;
            }
        }
        if (Math.abs(this.f43600e) >= 0.0f && Math.abs(this.f43600e) <= 20.0f) {
            this.f43602g.b();
            this.f43602g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView3d wheelView3d = this.f43602g;
        float f2 = (int) (this.f43600e / 100.0f);
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
        if (!this.f43602g.i()) {
            float itemHeight = this.f43602g.getItemHeight();
            float f3 = (-this.f43602g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f43602g.getItemsCount() - 1) - this.f43602g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f43602g.getTotalScrollY() - d2 < f3) {
                f3 = this.f43602g.getTotalScrollY() + f2;
            } else if (this.f43602g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f43602g.getTotalScrollY() + f2;
            }
            if (this.f43602g.getTotalScrollY() <= f3) {
                this.f43600e = 40.0f;
                this.f43602g.setTotalScrollY((int) f3);
            } else if (this.f43602g.getTotalScrollY() >= itemsCount) {
                this.f43602g.setTotalScrollY((int) itemsCount);
                this.f43600e = -40.0f;
            }
        }
        float f4 = this.f43600e;
        if (f4 < 0.0f) {
            this.f43600e = f4 + 20.0f;
        } else {
            this.f43600e = f4 - 20.0f;
        }
        this.f43602g.getHandler().sendEmptyMessage(1000);
    }
}
