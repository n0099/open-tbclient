package d.a.l0.a.z1.a.e.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f46035e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f46036f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f46037g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f46038h;

    public c(WheelView3d wheelView3d, int i2) {
        this.f46038h = wheelView3d;
        this.f46037g = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f46035e == Integer.MAX_VALUE) {
            this.f46035e = this.f46037g;
        }
        int i2 = this.f46035e;
        int i3 = (int) (i2 * 0.1f);
        this.f46036f = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.f46036f = -1;
            } else {
                this.f46036f = 1;
            }
        }
        if (Math.abs(this.f46035e) <= 1) {
            this.f46038h.b();
            this.f46038h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView3d wheelView3d = this.f46038h;
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f46036f);
        if (!this.f46038h.i()) {
            float itemHeight = this.f46038h.getItemHeight();
            float itemsCount = ((this.f46038h.getItemsCount() - 1) - this.f46038h.getInitPosition()) * itemHeight;
            if (this.f46038h.getTotalScrollY() <= (-this.f46038h.getInitPosition()) * itemHeight || this.f46038h.getTotalScrollY() >= itemsCount) {
                WheelView3d wheelView3d2 = this.f46038h;
                wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f46036f);
                this.f46038h.b();
                this.f46038h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f46038h.getHandler().sendEmptyMessage(1000);
        this.f46035e -= this.f46036f;
    }
}
