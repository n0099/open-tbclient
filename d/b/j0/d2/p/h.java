package d.b.j0.d2.p;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f55172a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f55173b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55174c = false;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f55175d = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f55174c = true;
            int b2 = d.b.i0.s.g.f.b();
            if (b2 > 0) {
                ViewGroup.LayoutParams layoutParams = h.this.f55172a.getLayoutParams();
                int g2 = l.g(h.this.f55172a.getContext(), R.dimen.tbds62);
                layoutParams.height = g2;
                layoutParams.width = g2;
                h.this.f55172a.setLayoutParams(layoutParams);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(h.this.f55172a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (h.this.f55173b != null) {
                    h.this.f55173b.start();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Interpolator {
        public b(h hVar) {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (float) ((Math.sin((f2 * 18.84955592153876d) - 1.5707963267948966d) * 0.075d) + 1.075d);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (h.this.f55172a != null) {
                h.this.f55172a.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                h.this.f55172a.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    public h(ImageView imageView) {
        this.f55172a = imageView;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f55173b = valueAnimator;
        valueAnimator.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        this.f55173b.setFloatValues(0.0f, 1.0f);
        this.f55173b.setInterpolator(new b(this));
        this.f55173b.addUpdateListener(new c());
    }

    public void d() {
        if (TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c()) {
            return;
        }
        d.b.c.e.m.e.a().removeCallbacks(this.f55175d);
        long a2 = TbSingleton.getInstance().getSharePanelConfData().a() * 1000;
        if (a2 <= 0) {
            a2 = 3000;
        }
        d.b.c.e.m.e.a().postDelayed(this.f55175d, a2);
    }

    public boolean e() {
        return this.f55174c;
    }

    public void f() {
        int b2;
        if (!this.f55174c || TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c() || (b2 = d.b.i0.s.g.f.b()) <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f55172a.getLayoutParams();
        int g2 = l.g(this.f55172a.getContext(), R.dimen.tbds62);
        layoutParams.height = g2;
        layoutParams.width = g2;
        this.f55172a.setLayoutParams(layoutParams);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f55172a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void g() {
        d.b.c.e.m.e.a().removeCallbacks(this.f55175d);
        ValueAnimator valueAnimator = this.f55173b;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f55173b.removeAllUpdateListeners();
            this.f55173b.cancel();
        }
    }

    public void h(boolean z) {
        this.f55174c = z;
    }
}
