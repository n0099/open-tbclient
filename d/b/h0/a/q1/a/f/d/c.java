package d.b.h0.a.q1.a.f.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f46255e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f46256f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f46257g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f46258h;

    public c(WheelView3d wheelView3d, int i) {
        this.f46258h = wheelView3d;
        this.f46257g = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f46255e == Integer.MAX_VALUE) {
            this.f46255e = this.f46257g;
        }
        int i = this.f46255e;
        int i2 = (int) (i * 0.1f);
        this.f46256f = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f46256f = -1;
            } else {
                this.f46256f = 1;
            }
        }
        if (Math.abs(this.f46255e) <= 1) {
            this.f46258h.b();
            this.f46258h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView3d wheelView3d = this.f46258h;
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f46256f);
        if (!this.f46258h.i()) {
            float itemHeight = this.f46258h.getItemHeight();
            float itemsCount = ((this.f46258h.getItemsCount() - 1) - this.f46258h.getInitPosition()) * itemHeight;
            if (this.f46258h.getTotalScrollY() <= (-this.f46258h.getInitPosition()) * itemHeight || this.f46258h.getTotalScrollY() >= itemsCount) {
                WheelView3d wheelView3d2 = this.f46258h;
                wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f46256f);
                this.f46258h.b();
                this.f46258h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f46258h.getHandler().sendEmptyMessage(1000);
        this.f46255e -= this.f46256f;
    }
}
