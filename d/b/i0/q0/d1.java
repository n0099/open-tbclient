package d.b.i0.q0;

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
    public ValueAnimator f59090c;

    /* renamed from: d  reason: collision with root package name */
    public TranslateAnimation f59091d;

    /* renamed from: a  reason: collision with root package name */
    public View f59088a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f59089b = 2000;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f59092e = new a();

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
            if (d1.this.f59088a == null || valueAnimator == null) {
                return;
            }
            d1.this.f59088a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (d1.this.f59088a != null) {
                d1.this.f();
                d1.this.f59088a.setAlpha(1.0f);
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
            d.b.c.e.m.e.a().postDelayed(d1.this.f59092e, d1.this.f59089b);
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
        this.f59090c = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f59090c.setDuration(400L);
        this.f59090c.addUpdateListener(new b());
        this.f59090c.addListener(new c());
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f59091d = translateAnimation;
        translateAnimation.setDuration(400L);
        this.f59091d.setAnimationListener(new d());
    }

    public void d() {
        d.b.c.e.m.e.a().removeCallbacks(this.f59092e);
        View view = this.f59088a;
        if (view == null || view.getParent() == null || this.f59088a.getVisibility() != 0 || this.f59090c.isRunning()) {
            return;
        }
        this.f59090c.start();
    }

    public void e() {
        f();
    }

    public void f() {
        d.b.c.e.m.e.a().removeCallbacks(this.f59092e);
        if (this.f59088a != null) {
            ValueAnimator valueAnimator = this.f59090c;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f59090c.cancel();
            }
            this.f59088a.clearAnimation();
            if (this.f59088a.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f59088a.getParent()).removeView(this.f59088a);
            }
            this.f59088a.setVisibility(8);
        }
    }

    public void g(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f59088a = view;
        f();
        viewGroup.addView(this.f59088a, layoutParams);
        this.f59088a.setVisibility(0);
    }

    public void h(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f59088a = view;
        f();
        viewGroup.addView(this.f59088a, layoutParams);
        this.f59088a.setVisibility(0);
        this.f59089b = i;
        d.b.c.e.m.e.a().removeCallbacks(this.f59092e);
        d.b.c.e.m.e.a().postDelayed(this.f59092e, this.f59089b);
    }
}
