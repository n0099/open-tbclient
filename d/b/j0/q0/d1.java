package d.b.j0.q0;

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
    public ValueAnimator f59511c;

    /* renamed from: d  reason: collision with root package name */
    public TranslateAnimation f59512d;

    /* renamed from: a  reason: collision with root package name */
    public View f59509a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f59510b = 2000;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f59513e = new a();

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
            if (d1.this.f59509a == null || valueAnimator == null) {
                return;
            }
            d1.this.f59509a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            if (d1.this.f59509a != null) {
                d1.this.f();
                d1.this.f59509a.setAlpha(1.0f);
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
            d.b.c.e.m.e.a().postDelayed(d1.this.f59513e, d1.this.f59510b);
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
        this.f59511c = valueAnimator;
        valueAnimator.setFloatValues(1.0f, 0.0f);
        this.f59511c.setDuration(400L);
        this.f59511c.addUpdateListener(new b());
        this.f59511c.addListener(new c());
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f59512d = translateAnimation;
        translateAnimation.setDuration(400L);
        this.f59512d.setAnimationListener(new d());
    }

    public void d() {
        d.b.c.e.m.e.a().removeCallbacks(this.f59513e);
        View view = this.f59509a;
        if (view == null || view.getParent() == null || this.f59509a.getVisibility() != 0 || this.f59511c.isRunning()) {
            return;
        }
        this.f59511c.start();
    }

    public void e() {
        f();
    }

    public void f() {
        d.b.c.e.m.e.a().removeCallbacks(this.f59513e);
        if (this.f59509a != null) {
            ValueAnimator valueAnimator = this.f59511c;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f59511c.cancel();
            }
            this.f59509a.clearAnimation();
            if (this.f59509a.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f59509a.getParent()).removeView(this.f59509a);
            }
            this.f59509a.setVisibility(8);
        }
    }

    public void g(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f59509a = view;
        f();
        viewGroup.addView(this.f59509a, layoutParams);
        this.f59509a.setVisibility(0);
    }

    public void h(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup == null || view == null) {
            return;
        }
        this.f59509a = view;
        f();
        viewGroup.addView(this.f59509a, layoutParams);
        this.f59509a.setVisibility(0);
        this.f59510b = i;
        d.b.c.e.m.e.a().removeCallbacks(this.f59513e);
        d.b.c.e.m.e.a().postDelayed(this.f59513e, this.f59510b);
    }
}
