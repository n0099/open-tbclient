package d.b.i0.b1.o.b.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public int f50772e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f50773f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f50774g;

    /* renamed from: h  reason: collision with root package name */
    public final WheelView f50775h;

    public c(WheelView wheelView, int i) {
        this.f50775h = wheelView;
        this.f50774g = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f50772e == Integer.MAX_VALUE) {
            this.f50772e = this.f50774g;
        }
        int i = this.f50772e;
        int i2 = (int) (i * 0.1f);
        this.f50773f = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f50773f = -1;
            } else {
                this.f50773f = 1;
            }
        }
        if (Math.abs(this.f50772e) <= 1) {
            this.f50775h.b();
            this.f50775h.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f50775h;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f50773f);
        if (!this.f50775h.i()) {
            float itemHeight = this.f50775h.getItemHeight();
            float itemsCount = ((this.f50775h.getItemsCount() - 1) - this.f50775h.getInitPosition()) * itemHeight;
            if (this.f50775h.getTotalScrollY() <= (-this.f50775h.getInitPosition()) * itemHeight || this.f50775h.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f50775h;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f50773f);
                this.f50775h.b();
                this.f50775h.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f50775h.getHandler().sendEmptyMessage(1000);
        this.f50772e -= this.f50773f;
    }
}
