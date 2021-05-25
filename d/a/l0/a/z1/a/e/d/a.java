package d.a.l0.a.z1.a.e.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f46031e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f46032f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView3d f46033g;

    public a(WheelView3d wheelView3d, float f2) {
        this.f46033g = wheelView3d;
        this.f46032f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f46031e == 2.1474836E9f) {
            if (Math.abs(this.f46032f) > 2000.0f) {
                this.f46031e = this.f46032f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f46031e = this.f46032f;
            }
        }
        if (Math.abs(this.f46031e) >= 0.0f && Math.abs(this.f46031e) <= 20.0f) {
            this.f46033g.b();
            this.f46033g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView3d wheelView3d = this.f46033g;
        float f2 = (int) (this.f46031e / 100.0f);
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
        if (!this.f46033g.i()) {
            float itemHeight = this.f46033g.getItemHeight();
            float f3 = (-this.f46033g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f46033g.getItemsCount() - 1) - this.f46033g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f46033g.getTotalScrollY() - d2 < f3) {
                f3 = this.f46033g.getTotalScrollY() + f2;
            } else if (this.f46033g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f46033g.getTotalScrollY() + f2;
            }
            if (this.f46033g.getTotalScrollY() <= f3) {
                this.f46031e = 40.0f;
                this.f46033g.setTotalScrollY((int) f3);
            } else if (this.f46033g.getTotalScrollY() >= itemsCount) {
                this.f46033g.setTotalScrollY((int) itemsCount);
                this.f46031e = -40.0f;
            }
        }
        float f4 = this.f46031e;
        if (f4 < 0.0f) {
            this.f46031e = f4 + 20.0f;
        } else {
            this.f46031e = f4 - 20.0f;
        }
        this.f46033g.getHandler().sendEmptyMessage(1000);
    }
}
