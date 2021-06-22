package d.a.m0.a.z1.a.e.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f49817e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f49818f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f49819g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f49820h;

    public c(WheelView3d wheelView3d, int i2) {
        this.f49820h = wheelView3d;
        this.f49819g = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f49817e == Integer.MAX_VALUE) {
            this.f49817e = this.f49819g;
        }
        int i2 = this.f49817e;
        int i3 = (int) (i2 * 0.1f);
        this.f49818f = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.f49818f = -1;
            } else {
                this.f49818f = 1;
            }
        }
        if (Math.abs(this.f49817e) <= 1) {
            this.f49820h.b();
            this.f49820h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView3d wheelView3d = this.f49820h;
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f49818f);
        if (!this.f49820h.i()) {
            float itemHeight = this.f49820h.getItemHeight();
            float itemsCount = ((this.f49820h.getItemsCount() - 1) - this.f49820h.getInitPosition()) * itemHeight;
            if (this.f49820h.getTotalScrollY() <= (-this.f49820h.getInitPosition()) * itemHeight || this.f49820h.getTotalScrollY() >= itemsCount) {
                WheelView3d wheelView3d2 = this.f49820h;
                wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f49818f);
                this.f49820h.b();
                this.f49820h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f49820h.getHandler().sendEmptyMessage(1000);
        this.f49817e -= this.f49818f;
    }
}
