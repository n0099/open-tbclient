package d.b.g0.a.q1.a.f.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f45533e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f45534f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f45535g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f45536h;

    public c(WheelView3d wheelView3d, int i) {
        this.f45536h = wheelView3d;
        this.f45535g = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f45533e == Integer.MAX_VALUE) {
            this.f45533e = this.f45535g;
        }
        int i = this.f45533e;
        int i2 = (int) (i * 0.1f);
        this.f45534f = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f45534f = -1;
            } else {
                this.f45534f = 1;
            }
        }
        if (Math.abs(this.f45533e) <= 1) {
            this.f45536h.b();
            this.f45536h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView3d wheelView3d = this.f45536h;
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f45534f);
        if (!this.f45536h.i()) {
            float itemHeight = this.f45536h.getItemHeight();
            float itemsCount = ((this.f45536h.getItemsCount() - 1) - this.f45536h.getInitPosition()) * itemHeight;
            if (this.f45536h.getTotalScrollY() <= (-this.f45536h.getInitPosition()) * itemHeight || this.f45536h.getTotalScrollY() >= itemsCount) {
                WheelView3d wheelView3d2 = this.f45536h;
                wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f45534f);
                this.f45536h.b();
                this.f45536h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f45536h.getHandler().sendEmptyMessage(1000);
        this.f45533e -= this.f45534f;
    }
}
