package d.a.h0.a.q1.a.f.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f43604e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f43605f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f43606g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f43607h;

    public c(WheelView3d wheelView3d, int i2) {
        this.f43607h = wheelView3d;
        this.f43606g = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f43604e == Integer.MAX_VALUE) {
            this.f43604e = this.f43606g;
        }
        int i2 = this.f43604e;
        int i3 = (int) (i2 * 0.1f);
        this.f43605f = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.f43605f = -1;
            } else {
                this.f43605f = 1;
            }
        }
        if (Math.abs(this.f43604e) <= 1) {
            this.f43607h.b();
            this.f43607h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView3d wheelView3d = this.f43607h;
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f43605f);
        if (!this.f43607h.i()) {
            float itemHeight = this.f43607h.getItemHeight();
            float itemsCount = ((this.f43607h.getItemsCount() - 1) - this.f43607h.getInitPosition()) * itemHeight;
            if (this.f43607h.getTotalScrollY() <= (-this.f43607h.getInitPosition()) * itemHeight || this.f43607h.getTotalScrollY() >= itemsCount) {
                WheelView3d wheelView3d2 = this.f43607h;
                wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f43605f);
                this.f43607h.b();
                this.f43607h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f43607h.getHandler().sendEmptyMessage(1000);
        this.f43604e -= this.f43605f;
    }
}
