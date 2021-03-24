package d.b.i0.c2.p;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.s.g.f;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f53308a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f53309b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53310c = false;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f53311d = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f53310c = true;
            int b2 = f.b();
            if (b2 > 0) {
                ViewGroup.LayoutParams layoutParams = d.this.f53308a.getLayoutParams();
                int g2 = l.g(d.this.f53308a.getContext(), R.dimen.tbds62);
                layoutParams.height = g2;
                layoutParams.width = g2;
                d.this.f53308a.setLayoutParams(layoutParams);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(d.this.f53308a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (d.this.f53309b != null) {
                    d.this.f53309b.start();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Interpolator {
        public b(d dVar) {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            double d2 = f2;
            Double.isNaN(d2);
            return (float) ((Math.sin((d2 * 18.84955592153876d) - 1.5707963267948966d) * 0.075d) + 1.075d);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (d.this.f53308a != null) {
                d.this.f53308a.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                d.this.f53308a.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    public d(ImageView imageView) {
        this.f53308a = imageView;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f53309b = valueAnimator;
        valueAnimator.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        this.f53309b.setFloatValues(0.0f, 1.0f);
        this.f53309b.setInterpolator(new b(this));
        this.f53309b.addUpdateListener(new c());
    }

    public void d() {
        if (TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c()) {
            return;
        }
        d.b.b.e.m.e.a().removeCallbacks(this.f53311d);
        long a2 = TbSingleton.getInstance().getSharePanelConfData().a() * 1000;
        if (a2 <= 0) {
            a2 = 3000;
        }
        d.b.b.e.m.e.a().postDelayed(this.f53311d, a2);
    }

    public boolean e() {
        return this.f53310c;
    }

    public void f() {
        int b2;
        if (!this.f53310c || TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().c() || (b2 = f.b()) <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f53308a.getLayoutParams();
        int g2 = l.g(this.f53308a.getContext(), R.dimen.tbds62);
        layoutParams.height = g2;
        layoutParams.width = g2;
        this.f53308a.setLayoutParams(layoutParams);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f53308a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void g() {
        d.b.b.e.m.e.a().removeCallbacks(this.f53311d);
        ValueAnimator valueAnimator = this.f53309b;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f53309b.removeAllUpdateListeners();
            this.f53309b.cancel();
        }
    }

    public void h(boolean z) {
        this.f53310c = z;
    }
}
