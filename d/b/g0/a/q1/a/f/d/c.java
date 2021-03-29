package d.b.g0.a.q1.a.f.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f45534e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f45535f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f45536g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView3d f45537h;

    public c(WheelView3d wheelView3d, int i) {
        this.f45537h = wheelView3d;
        this.f45536g = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f45534e == Integer.MAX_VALUE) {
            this.f45534e = this.f45536g;
        }
        int i = this.f45534e;
        int i2 = (int) (i * 0.1f);
        this.f45535f = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f45535f = -1;
            } else {
                this.f45535f = 1;
            }
        }
        if (Math.abs(this.f45534e) <= 1) {
            this.f45537h.b();
            this.f45537h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView3d wheelView3d = this.f45537h;
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() + this.f45535f);
        if (!this.f45537h.i()) {
            float itemHeight = this.f45537h.getItemHeight();
            float itemsCount = ((this.f45537h.getItemsCount() - 1) - this.f45537h.getInitPosition()) * itemHeight;
            if (this.f45537h.getTotalScrollY() <= (-this.f45537h.getInitPosition()) * itemHeight || this.f45537h.getTotalScrollY() >= itemsCount) {
                WheelView3d wheelView3d2 = this.f45537h;
                wheelView3d2.setTotalScrollY(wheelView3d2.getTotalScrollY() - this.f45535f);
                this.f45537h.b();
                this.f45537h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f45537h.getHandler().sendEmptyMessage(1000);
        this.f45534e -= this.f45535f;
    }
}
