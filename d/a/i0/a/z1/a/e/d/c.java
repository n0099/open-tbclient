package d.a.i0.a.z1.a.e.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f45859e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f45860f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f45861g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f45862h;

    public c(WheelView3d wheelView3d, int i2) {
        this.f45862h = wheelView3d;
        this.f45861g = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f45859e == Integer.MAX_VALUE) {
            this.f45859e = this.f45861g;
        }
        int i2 = this.f45859e;
        int i3 = (int) (i2 * 0.1f);
        this.f45860f = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.f45860f = -1;
            } else {
                this.f45860f = 1;
            }
        }
        if (Math.abs(this.f45859e) <= 1) {
            this.f45862h.b();
            this.f45862h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView3d wheelView3d = this.f45862h;
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f45860f);
        if (!this.f45862h.i()) {
            float itemHeight = this.f45862h.getItemHeight();
            float itemsCount = ((this.f45862h.getItemsCount() - 1) - this.f45862h.getInitPosition()) * itemHeight;
            if (this.f45862h.getTotalScrollY() <= (-this.f45862h.getInitPosition()) * itemHeight || this.f45862h.getTotalScrollY() >= itemsCount) {
                WheelView3d wheelView3d2 = this.f45862h;
                wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f45860f);
                this.f45862h.b();
                this.f45862h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f45862h.getHandler().sendEmptyMessage(1000);
        this.f45859e -= this.f45860f;
    }
}
