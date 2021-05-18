package d.a.k0.d2.p;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f53715a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f53716b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53717c = false;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f53718d = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f53717c = true;
            int b2 = d.a.j0.s.g.f.b();
            if (b2 > 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(h.this.f53715a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (h.this.f53716b != null) {
                    h.this.f53716b.start();
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
            if (h.this.f53715a != null) {
                h.this.f53715a.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                h.this.f53715a.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    public h(ImageView imageView) {
        this.f53715a = imageView;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f53716b = valueAnimator;
        valueAnimator.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        this.f53716b.setFloatValues(0.0f, 1.0f);
        this.f53716b.setInterpolator(new b(this));
        this.f53716b.addUpdateListener(new c());
    }

    public void d() {
        if (TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c()) {
            return;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.f53718d);
        long a2 = TbSingleton.getInstance().getSharePanelConfData().a() * 1000;
        if (a2 <= 0) {
            a2 = 3000;
        }
        d.a.c.e.m.e.a().postDelayed(this.f53718d, a2);
    }

    public boolean e() {
        return this.f53717c;
    }

    public void f() {
        int b2;
        if (!this.f53717c || TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c() || (b2 = d.a.j0.s.g.f.b()) <= 0) {
            return;
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f53715a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void g() {
        d.a.c.e.m.e.a().removeCallbacks(this.f53718d);
        ValueAnimator valueAnimator = this.f53716b;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f53716b.removeAllUpdateListeners();
            this.f53716b.cancel();
        }
    }

    public void h(boolean z) {
        this.f53717c = z;
    }
}
