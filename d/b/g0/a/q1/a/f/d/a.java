package d.b.g0.a.q1.a.f.d;

import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {

    /* renamed from: e  reason: collision with root package name */
    public float f45922e = 2.1474836E9f;

    /* renamed from: f  reason: collision with root package name */
    public final float f45923f;

    /* renamed from: g  reason: collision with root package name */
    public final WheelView3d f45924g;

    public a(WheelView3d wheelView3d, float f2) {
        this.f45924g = wheelView3d;
        this.f45923f = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f45922e == 2.1474836E9f) {
            if (Math.abs(this.f45923f) > 2000.0f) {
                this.f45922e = this.f45923f <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f45922e = this.f45923f;
            }
        }
        if (Math.abs(this.f45922e) >= 0.0f && Math.abs(this.f45922e) <= 20.0f) {
            this.f45924g.b();
            this.f45924g.getHandler().sendEmptyMessage(2000);
            return;
        }
        WheelView3d wheelView3d = this.f45924g;
        float f2 = (int) (this.f45922e / 100.0f);
        wheelView3d.setTotalScrollY(wheelView3d.getTotalScrollY() - f2);
        if (!this.f45924g.i()) {
            float itemHeight = this.f45924g.getItemHeight();
            float f3 = (-this.f45924g.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f45924g.getItemsCount() - 1) - this.f45924g.getInitPosition()) * itemHeight;
            double d2 = itemHeight * 0.25d;
            if (this.f45924g.getTotalScrollY() - d2 < f3) {
                f3 = this.f45924g.getTotalScrollY() + f2;
            } else if (this.f45924g.getTotalScrollY() + d2 > itemsCount) {
                itemsCount = this.f45924g.getTotalScrollY() + f2;
            }
            if (this.f45924g.getTotalScrollY() <= f3) {
                this.f45922e = 40.0f;
                this.f45924g.setTotalScrollY((int) f3);
            } else if (this.f45924g.getTotalScrollY() >= itemsCount) {
                this.f45924g.setTotalScrollY((int) itemsCount);
                this.f45922e = -40.0f;
            }
        }
        float f4 = this.f45922e;
        if (f4 < 0.0f) {
            this.f45922e = f4 + 20.0f;
        } else {
            this.f45922e = f4 - 20.0f;
        }
        this.f45924g.getHandler().sendEmptyMessage(1000);
    }
}
