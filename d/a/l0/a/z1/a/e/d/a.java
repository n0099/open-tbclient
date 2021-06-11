package d.a.l0.a.z1.a.e.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f49705e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f49706f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView3d f49707g;

    public a(WheelView3d wheelView3d, float f2) {
        this.f49707g = wheelView3d;
        this.f49706f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f49705e == 2.1474836E9f) {
            if (Math.abs(this.f49706f) > 2000.0f) {
                this.f49705e = this.f49706f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f49705e = this.f49706f;
            }
        }
        if (Math.abs(this.f49705e) >= 0.0f && Math.abs(this.f49705e) <= 20.0f) {
            this.f49707g.b();
            this.f49707g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView3d wheelView3d = this.f49707g;
        float f2 = (int) (this.f49705e / 100.0f);
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
        if (!this.f49707g.i()) {
            float itemHeight = this.f49707g.getItemHeight();
            float f3 = (-this.f49707g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f49707g.getItemsCount() - 1) - this.f49707g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f49707g.getTotalScrollY() - d2 < f3) {
                f3 = this.f49707g.getTotalScrollY() + f2;
            } else if (this.f49707g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f49707g.getTotalScrollY() + f2;
            }
            if (this.f49707g.getTotalScrollY() <= f3) {
                this.f49705e = 40.0f;
                this.f49707g.setTotalScrollY((int) f3);
            } else if (this.f49707g.getTotalScrollY() >= itemsCount) {
                this.f49707g.setTotalScrollY((int) itemsCount);
                this.f49705e = -40.0f;
            }
        }
        float f4 = this.f49705e;
        if (f4 < 0.0f) {
            this.f49705e = f4 + 20.0f;
        } else {
            this.f49705e = f4 - 20.0f;
        }
        this.f49707g.getHandler().sendEmptyMessage(1000);
    }
}
