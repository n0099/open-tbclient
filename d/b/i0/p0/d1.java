package d.b.i0.p0;

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
    public ValueAnimator f57391c;

    /* renamed from: d  reason: collision with root package name */
    public TranslateAnimation f57392d;

    /* renamed from: a  reason: collision with root package name */
    public View f57389a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f57390b = 2000;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f57393e = new a();

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
            if (d1.this.f57389a == null || valueAnimator == null) {
                return;
            }
            d1.this.f57389a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (d1.this.f57389a != null) {
                d1.this.f();
                d1.this.f57389a.setAlpha(1.0f);
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
            d.b.b.e.m.e.a().postDelayed(d1.this.f57393e, d1.this.f57390b);
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
        this.f57391c = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f57391c.setDuration(400L);
        this.f57391c.addUpdateListener(new b());
        this.f57391c.addListener(new c());
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f57392d = translateAnimation;
        translateAnimation.setDuration(400L);
        this.f57392d.setAnimationListener(new d());
    }

    public void d() {
        d.b.b.e.m.e.a().removeCallbacks(this.f57393e);
        View view = this.f57389a;
        if (view == null || view.getParent() == null || this.f57389a.getVisibility() != 0 || this.f57391c.isRunning()) {
            return;
        }
        this.f57391c.start();
    }

    public void e() {
        f();
    }

    public void f() {
        d.b.b.e.m.e.a().removeCallbacks(this.f57393e);
        if (this.f57389a != null) {
            ValueAnimator valueAnimator = this.f57391c;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f57391c.cancel();
            }
            this.f57389a.clearAnimation();
            if (this.f57389a.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f57389a.getParent()).removeView(this.f57389a);
            }
            this.f57389a.setVisibility(8);
        }
    }

    public void g(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f57389a = view;
        f();
        viewGroup.addView(this.f57389a, layoutParams);
        this.f57389a.setVisibility(0);
    }

    public void h(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f57389a = view;
        f();
        viewGroup.addView(this.f57389a, layoutParams);
        this.f57389a.setVisibility(0);
        this.f57390b = i;
        d.b.b.e.m.e.a().removeCallbacks(this.f57393e);
        d.b.b.e.m.e.a().postDelayed(this.f57393e, this.f57390b);
    }
}
