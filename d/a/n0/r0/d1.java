package d.a.n0.r0;

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
    public ValueAnimator f58437c;

    /* renamed from: d  reason: collision with root package name */
    public TranslateAnimation f58438d;

    /* renamed from: a  reason: collision with root package name */
    public View f58435a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f58436b = 2000;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f58439e = new a();

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
            if (d1.this.f58435a == null || valueAnimator == null) {
                return;
            }
            d1.this.f58435a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (d1.this.f58435a != null) {
                d1.this.f();
                d1.this.f58435a.setAlpha(1.0f);
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
            d.a.c.e.m.e.a().postDelayed(d1.this.f58439e, d1.this.f58436b);
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
        this.f58437c = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f58437c.setDuration(400L);
        this.f58437c.addUpdateListener(new b());
        this.f58437c.addListener(new c());
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f58438d = translateAnimation;
        translateAnimation.setDuration(400L);
        this.f58438d.setAnimationListener(new d());
    }

    public void d() {
        d.a.c.e.m.e.a().removeCallbacks(this.f58439e);
        View view = this.f58435a;
        if (view == null || view.getParent() == null || this.f58435a.getVisibility() != 0 || this.f58437c.isRunning()) {
            return;
        }
        this.f58437c.start();
    }

    public void e() {
        f();
    }

    public void f() {
        d.a.c.e.m.e.a().removeCallbacks(this.f58439e);
        if (this.f58435a != null) {
            ValueAnimator valueAnimator = this.f58437c;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f58437c.cancel();
            }
            this.f58435a.clearAnimation();
            if (this.f58435a.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f58435a.getParent()).removeView(this.f58435a);
            }
            this.f58435a.setVisibility(8);
        }
    }

    public void g(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f58435a = view;
        f();
        viewGroup.addView(this.f58435a, layoutParams);
        this.f58435a.setVisibility(0);
    }

    public void h(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i2) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f58435a = view;
        f();
        viewGroup.addView(this.f58435a, layoutParams);
        this.f58435a.setVisibility(0);
        this.f58436b = i2;
        d.a.c.e.m.e.a().removeCallbacks(this.f58439e);
        d.a.c.e.m.e.a().postDelayed(this.f58439e, this.f58436b);
    }
}
