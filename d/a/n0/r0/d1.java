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
    public ValueAnimator f62128c;

    /* renamed from: d  reason: collision with root package name */
    public TranslateAnimation f62129d;

    /* renamed from: a  reason: collision with root package name */
    public View f62126a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f62127b = 2000;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f62130e = new a();

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
            if (d1.this.f62126a == null || valueAnimator == null) {
                return;
            }
            d1.this.f62126a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (d1.this.f62126a != null) {
                d1.this.f();
                d1.this.f62126a.setAlpha(1.0f);
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
            d.a.c.e.m.e.a().postDelayed(d1.this.f62130e, d1.this.f62127b);
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
        this.f62128c = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f62128c.setDuration(400L);
        this.f62128c.addUpdateListener(new b());
        this.f62128c.addListener(new c());
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f62129d = translateAnimation;
        translateAnimation.setDuration(400L);
        this.f62129d.setAnimationListener(new d());
    }

    public void d() {
        d.a.c.e.m.e.a().removeCallbacks(this.f62130e);
        View view = this.f62126a;
        if (view == null || view.getParent() == null || this.f62126a.getVisibility() != 0 || this.f62128c.isRunning()) {
            return;
        }
        this.f62128c.start();
    }

    public void e() {
        f();
    }

    public void f() {
        d.a.c.e.m.e.a().removeCallbacks(this.f62130e);
        if (this.f62126a != null) {
            ValueAnimator valueAnimator = this.f62128c;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f62128c.cancel();
            }
            this.f62126a.clearAnimation();
            if (this.f62126a.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f62126a.getParent()).removeView(this.f62126a);
            }
            this.f62126a.setVisibility(8);
        }
    }

    public void g(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f62126a = view;
        f();
        viewGroup.addView(this.f62126a, layoutParams);
        this.f62126a.setVisibility(0);
    }

    public void h(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i2) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f62126a = view;
        f();
        viewGroup.addView(this.f62126a, layoutParams);
        this.f62126a.setVisibility(0);
        this.f62127b = i2;
        d.a.c.e.m.e.a().removeCallbacks(this.f62130e);
        d.a.c.e.m.e.a().postDelayed(this.f62130e, this.f62127b);
    }
}
