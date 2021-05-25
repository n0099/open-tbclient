package d.a.n0.e2.p;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f53928a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f53929b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53930c = false;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f53931d = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f53930c = true;
            int b2 = d.a.m0.s.g.f.b();
            if (b2 > 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(h.this.f53928a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (h.this.f53929b != null) {
                    h.this.f53929b.start();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Interpolator {
        public b(h hVar) {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (float) ((Math.sin((f2 * 18.84955592153876d) - 1.5707963267948966d) * 0.075d) + 1.075d);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (h.this.f53928a != null) {
                h.this.f53928a.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                h.this.f53928a.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    public h(ImageView imageView) {
        this.f53928a = imageView;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f53929b = valueAnimator;
        valueAnimator.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        this.f53929b.setFloatValues(0.0f, 1.0f);
        this.f53929b.setInterpolator(new b(this));
        this.f53929b.addUpdateListener(new c());
    }

    public void d() {
        if (TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c()) {
            return;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.f53931d);
        long a2 = TbSingleton.getInstance().getSharePanelConfData().a() * 1000;
        if (a2 <= 0) {
            a2 = 3000;
        }
        d.a.c.e.m.e.a().postDelayed(this.f53931d, a2);
    }

    public boolean e() {
        return this.f53930c;
    }

    public void f() {
        int b2;
        if (!this.f53930c || TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c() || (b2 = d.a.m0.s.g.f.b()) <= 0) {
            return;
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f53928a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void g() {
        d.a.c.e.m.e.a().removeCallbacks(this.f53931d);
        ValueAnimator valueAnimator = this.f53929b;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f53929b.removeAllUpdateListeners();
            this.f53929b.cancel();
        }
    }

    public void h(boolean z) {
        this.f53930c = z;
    }
}
