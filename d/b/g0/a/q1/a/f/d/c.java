package d.b.g0.a.q1.a.f.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f45926e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f45927f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f45928g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f45929h;

    public c(WheelView3d wheelView3d, int i) {
        this.f45929h = wheelView3d;
        this.f45928g = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f45926e == Integer.MAX_VALUE) {
            this.f45926e = this.f45928g;
        }
        int i = this.f45926e;
        int i2 = (int) (i * 0.1f);
        this.f45927f = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f45927f = -1;
            } else {
                this.f45927f = 1;
            }
        }
        if (Math.abs(this.f45926e) <= 1) {
            this.f45929h.b();
            this.f45929h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView3d wheelView3d = this.f45929h;
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f45927f);
        if (!this.f45929h.i()) {
            float itemHeight = this.f45929h.getItemHeight();
            float itemsCount = ((this.f45929h.getItemsCount() - 1) - this.f45929h.getInitPosition()) * itemHeight;
            if (this.f45929h.getTotalScrollY() <= (-this.f45929h.getInitPosition()) * itemHeight || this.f45929h.getTotalScrollY() >= itemsCount) {
                WheelView3d wheelView3d2 = this.f45929h;
                wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f45927f);
                this.f45929h.b();
                this.f45929h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f45929h.getHandler().sendEmptyMessage(1000);
        this.f45926e -= this.f45927f;
    }
}
