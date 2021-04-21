package d.b.h0.a.q1.a.f.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f46251e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f46252f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView3d f46253g;

    public a(WheelView3d wheelView3d, float f2) {
        this.f46253g = wheelView3d;
        this.f46252f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f46251e == 2.1474836E9f) {
            if (Math.abs(this.f46252f) > 2000.0f) {
                this.f46251e = this.f46252f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f46251e = this.f46252f;
            }
        }
        if (Math.abs(this.f46251e) >= 0.0f && Math.abs(this.f46251e) <= 20.0f) {
            this.f46253g.b();
            this.f46253g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView3d wheelView3d = this.f46253g;
        float f2 = (int) (this.f46251e / 100.0f);
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
        if (!this.f46253g.i()) {
            float itemHeight = this.f46253g.getItemHeight();
            float f3 = (-this.f46253g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f46253g.getItemsCount() - 1) - this.f46253g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f46253g.getTotalScrollY() - d2 < f3) {
                f3 = this.f46253g.getTotalScrollY() + f2;
            } else if (this.f46253g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f46253g.getTotalScrollY() + f2;
            }
            if (this.f46253g.getTotalScrollY() <= f3) {
                this.f46251e = 40.0f;
                this.f46253g.setTotalScrollY((int) f3);
            } else if (this.f46253g.getTotalScrollY() >= itemsCount) {
                this.f46253g.setTotalScrollY((int) itemsCount);
                this.f46251e = -40.0f;
            }
        }
        float f4 = this.f46251e;
        if (f4 < 0.0f) {
            this.f46251e = f4 + 20.0f;
        } else {
            this.f46251e = f4 - 20.0f;
        }
        this.f46253g.getHandler().sendEmptyMessage(1000);
    }
}
