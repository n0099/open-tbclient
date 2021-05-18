package d.a.k0.q0;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d1 {

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f58296c;

    /* renamed from: d  reason: collision with root package name */
    public TranslateAnimation f58297d;

    /* renamed from: a  reason: collision with root package name */
    public View f58294a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f58295b = 2000;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f58298e = new a();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.this.d();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (d1.this.f58294a == null || valueAnimator == null) {
                return;
            }
            d1.this.f58294a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (d1.this.f58294a != null) {
                d1.this.f();
                d1.this.f58294a.setAlpha(1.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d.a.c.e.m.e.a().postDelayed(d1.this.f58298e, d1.this.f58295b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public d1() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f58296c = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f58296c.setDuration(400L);
        this.f58296c.addUpdateListener(new b());
        this.f58296c.addListener(new c());
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f58297d = translateAnimation;
        translateAnimation.setDuration(400L);
        this.f58297d.setAnimationListener(new d());
    }

    public void d() {
        d.a.c.e.m.e.a().removeCallbacks(this.f58298e);
        View view = this.f58294a;
        if (view == null || view.getParent() == null || this.f58294a.getVisibility() != 0 || this.f58296c.isRunning()) {
            return;
        }
        this.f58296c.start();
    }

    public void e() {
        f();
    }

    public void f() {
        d.a.c.e.m.e.a().removeCallbacks(this.f58298e);
        if (this.f58294a != null) {
            ValueAnimator valueAnimator = this.f58296c;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f58296c.cancel();
            }
            this.f58294a.clearAnimation();
            if (this.f58294a.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f58294a.getParent()).removeView(this.f58294a);
            }
            this.f58294a.setVisibility(8);
        }
    }

    public void g(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f58294a = view;
        f();
        viewGroup.addView(this.f58294a, layoutParams);
        this.f58294a.setVisibility(0);
    }

    public void h(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i2) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f58294a = view;
        f();
        viewGroup.addView(this.f58294a, layoutParams);
        this.f58294a.setVisibility(0);
        this.f58295b = i2;
        d.a.c.e.m.e.a().removeCallbacks(this.f58298e);
        d.a.c.e.m.e.a().postDelayed(this.f58298e, this.f58295b);
    }
}
