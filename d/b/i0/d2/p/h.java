package d.b.i0.d2.p;

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
    public ImageView f54751a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f54752b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54753c = false;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f54754d = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f54753c = true;
            int b2 = d.b.h0.s.g.f.b();
            if (b2 > 0) {
                ViewGroup.LayoutParams layoutParams = h.this.f54751a.getLayoutParams();
                int g2 = l.g(h.this.f54751a.getContext(), R.dimen.tbds62);
                layoutParams.height = g2;
                layoutParams.width = g2;
                h.this.f54751a.setLayoutParams(layoutParams);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(h.this.f54751a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (h.this.f54752b != null) {
                    h.this.f54752b.start();
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
            if (h.this.f54751a != null) {
                h.this.f54751a.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                h.this.f54751a.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    public h(ImageView imageView) {
        this.f54751a = imageView;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f54752b = valueAnimator;
        valueAnimator.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        this.f54752b.setFloatValues(0.0f, 1.0f);
        this.f54752b.setInterpolator(new b(this));
        this.f54752b.addUpdateListener(new c());
    }

    public void d() {
        if (TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c()) {
            return;
        }
        d.b.c.e.m.e.a().removeCallbacks(this.f54754d);
        long a2 = TbSingleton.getInstance().getSharePanelConfData().a() * 1000;
        if (a2 <= 0) {
            a2 = 3000;
        }
        d.b.c.e.m.e.a().postDelayed(this.f54754d, a2);
    }

    public boolean e() {
        return this.f54753c;
    }

    public void f() {
        int b2;
        if (!this.f54753c || TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c() || (b2 = d.b.h0.s.g.f.b()) <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f54751a.getLayoutParams();
        int g2 = l.g(this.f54751a.getContext(), R.dimen.tbds62);
        layoutParams.height = g2;
        layoutParams.width = g2;
        this.f54751a.setLayoutParams(layoutParams);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f54751a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void g() {
        d.b.c.e.m.e.a().removeCallbacks(this.f54754d);
        ValueAnimator valueAnimator = this.f54752b;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f54752b.removeAllUpdateListeners();
            this.f54752b.cancel();
        }
    }

    public void h(boolean z) {
        this.f54753c = z;
    }
}
