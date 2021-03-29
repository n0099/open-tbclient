package d.b.i0.u3;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import d.b.i0.u3.a;
import d.b.i0.u3.h;
/* loaded from: classes5.dex */
public class d extends d.b.i0.u3.h {

    /* renamed from: h  reason: collision with root package name */
    public boolean f61489h;
    public boolean i;
    public boolean j;
    public ValueAnimator k;
    public ValueAnimator l;
    public ValueAnimator m;
    public ValueAnimator n;
    public a.c o;
    public ValueAnimator.AnimatorUpdateListener p;
    public Animator.AnimatorListener q;
    public ValueAnimator.AnimatorUpdateListener r;
    public Animator.AnimatorListener s;

    /* loaded from: classes5.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = d.this.f61536b;
            if (view != null) {
                view.setAlpha(1.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            if (valueAnimator.isRunning() && (view = d.this.f61536b) != null) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = d.this.f61536b;
            if (view != null) {
                view.setAlpha(0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: d.b.i0.u3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1611d implements Runnable {
        public RunnableC1611d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l.start();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (d.this.f61489h || animatedFraction < 0.6923f || !d.this.o.f61456g.isAnimating()) {
                if (d.this.j || animatedFraction < 0.38461f || !d.this.o.f61456g.isAnimating()) {
                    return;
                }
                d.this.j = true;
                return;
            }
            d.this.f61489h = true;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Animator.AnimatorListener {
        public f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.w();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (d.this.i || animatedFraction < 0.57142f || !d.this.o.f61456g.isAnimating()) {
                return;
            }
            d.this.i = true;
            d.this.x();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Animator.AnimatorListener {
        public h() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.v();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                d.this.o.f61455f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Animator.AnimatorListener {
        public j() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.o.f61455f.setAlpha(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public k() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                d.this.o.f61455f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Animator.AnimatorListener {
        public l() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.o.f61455f.setAlpha(0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public m() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            if (valueAnimator.isRunning() && (view = d.this.f61536b) != null) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    public d(Context context, a.c cVar) {
        super(context, cVar);
        this.f61489h = false;
        this.i = false;
        this.j = false;
        this.p = new e();
        this.q = new f();
        this.r = new g();
        this.s = new h();
        this.o = cVar;
        u();
    }

    @Override // d.b.i0.u3.h
    public void c() {
        v();
    }

    @Override // d.b.i0.u3.h
    public void d() {
        t();
        this.o.f61456g.cancelAnimation();
    }

    @Override // d.b.i0.u3.h
    public void g() {
        if (this.f61539e != 4) {
            return;
        }
        this.f61539e = 1;
        h.a aVar = this.f61538d;
        if (aVar != null) {
            aVar.a(1);
        }
        t();
        y(0);
        this.o.f61456g.setVisibility(0);
        this.k.start();
        this.n.start();
        this.o.f61456g.removeAnimatorListener(this.s);
        this.o.f61456g.removeUpdateListener(this.r);
        this.o.f61456g.addAnimatorUpdateListener(this.p);
        this.o.f61456g.addAnimatorListener(this.q);
        this.o.f61456g.setMinAndMaxProgress(0.0f, 1.0f);
        this.o.f61456g.setProgress(0.0f);
        this.o.f61456g.setSpeed(1.4f);
        this.o.f61456g.playAnimation();
    }

    @Override // d.b.i0.u3.h
    public void h() {
        if (this.f61539e != 2) {
            return;
        }
        this.o.e(false);
        this.f61539e = 3;
        h.a aVar = this.f61538d;
        if (aVar != null) {
            aVar.a(3);
        }
        this.o.f61456g.setVisibility(0);
        d.b.b.e.m.e.a().postDelayed(new RunnableC1611d(), 300L);
        this.o.d(false);
        this.o.f61456g.removeAnimatorListener(this.q);
        this.o.f61456g.removeUpdateListener(this.p);
        this.o.f61456g.addAnimatorUpdateListener(this.r);
        this.o.f61456g.addAnimatorListener(this.s);
        this.o.f61456g.setMinAndMaxProgress(0.0f, 1.0f);
        this.o.f61456g.setProgress(1.0f);
        this.o.f61456g.setSpeed(-1.68f);
        this.o.f61456g.playAnimation();
    }

    public final void t() {
        this.k.cancel();
        this.l.cancel();
        this.m.cancel();
        this.n.cancel();
    }

    public final void u() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.k = ofFloat;
        ofFloat.setDuration(451L);
        this.k.addUpdateListener(new i());
        this.k.addListener(new j());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.l = ofFloat2;
        ofFloat2.setDuration(485L);
        this.l.addUpdateListener(new k());
        this.l.addListener(new l());
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.m = ofFloat3;
        ofFloat3.setDuration(104L);
        this.m.addUpdateListener(new m());
        this.m.addListener(new a());
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.n = ofFloat4;
        ofFloat4.setDuration(208L);
        this.n.addUpdateListener(new b());
        this.n.addListener(new c());
    }

    public final void v() {
        this.f61489h = false;
        this.j = false;
        this.i = false;
        this.o.d(false);
        View view = this.f61537c;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.f61536b;
        if (view2 != null) {
            view2.setAlpha(1.0f);
            this.f61536b.setVisibility(0);
        }
        t();
        y(8);
        this.f61539e = 4;
        h.a aVar = this.f61538d;
        if (aVar != null) {
            aVar.a(4);
        }
    }

    public final void w() {
        this.o.f61456g.setVisibility(0);
        this.o.d(true);
        this.f61539e = 2;
        h.a aVar = this.f61538d;
        if (aVar != null) {
            aVar.a(2);
        }
    }

    public final void x() {
        this.m.start();
    }

    public final void y(int i2) {
        this.o.f61454e.setVisibility(i2);
        this.o.f61455f.setVisibility(i2);
        this.o.f61457h.setVisibility(i2);
    }
}
