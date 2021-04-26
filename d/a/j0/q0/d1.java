package d.a.j0.q0;

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
    public ValueAnimator f57554c;

    /* renamed from: d  reason: collision with root package name */
    public TranslateAnimation f57555d;

    /* renamed from: a  reason: collision with root package name */
    public View f57552a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f57553b = 2000;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f57556e = new a();

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
            if (d1.this.f57552a == null || valueAnimator == null) {
                return;
            }
            d1.this.f57552a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (d1.this.f57552a != null) {
                d1.this.f();
                d1.this.f57552a.setAlpha(1.0f);
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
            d.a.c.e.m.e.a().postDelayed(d1.this.f57556e, d1.this.f57553b);
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
        this.f57554c = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f57554c.setDuration(400L);
        this.f57554c.addUpdateListener(new b());
        this.f57554c.addListener(new c());
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f57555d = translateAnimation;
        translateAnimation.setDuration(400L);
        this.f57555d.setAnimationListener(new d());
    }

    public void d() {
        d.a.c.e.m.e.a().removeCallbacks(this.f57556e);
        View view = this.f57552a;
        if (view == null || view.getParent() == null || this.f57552a.getVisibility() != 0 || this.f57554c.isRunning()) {
            return;
        }
        this.f57554c.start();
    }

    public void e() {
        f();
    }

    public void f() {
        d.a.c.e.m.e.a().removeCallbacks(this.f57556e);
        if (this.f57552a != null) {
            ValueAnimator valueAnimator = this.f57554c;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f57554c.cancel();
            }
            this.f57552a.clearAnimation();
            if (this.f57552a.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f57552a.getParent()).removeView(this.f57552a);
            }
            this.f57552a.setVisibility(8);
        }
    }

    public void g(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f57552a = view;
        f();
        viewGroup.addView(this.f57552a, layoutParams);
        this.f57552a.setVisibility(0);
    }

    public void h(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i2) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f57552a = view;
        f();
        viewGroup.addView(this.f57552a, layoutParams);
        this.f57552a.setVisibility(0);
        this.f57553b = i2;
        d.a.c.e.m.e.a().removeCallbacks(this.f57556e);
        d.a.c.e.m.e.a().postDelayed(this.f57556e, this.f57553b);
    }
}
