package d.a.o0.w3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import d.a.o0.w3.a;
import d.a.o0.w3.g;
/* loaded from: classes5.dex */
public class d extends d.a.o0.w3.g {

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f66561h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f66562i;
    public float j;
    public float k;
    public ValueAnimator l;
    public ValueAnimator m;
    public AnimatorSet n;
    public ValueAnimator o;
    public ValueAnimator p;
    public float q;
    public float r;
    public float s;
    public int t;
    public a.c u;
    public d.a.o0.w.d v;

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
            d.a.o0.w.e eVar = new d.a.o0.w.e(d.this.s);
            eVar.d(0.5f);
            eVar.f(800.0f);
            d dVar = d.this;
            d.a.o0.w.d dVar2 = new d.a.o0.w.d(d.this.u.C, d.a.o0.w.b.m);
            dVar2.l(eVar);
            dVar.v = dVar2;
            d.this.v.g();
            d.this.u.C.setTranslationY(0.0f);
            d dVar3 = d.this;
            dVar3.f66600e = 2;
            g.a aVar = dVar3.f66599d;
            if (aVar != null) {
                aVar.a(2);
            }
            d.this.u.q.setClickable(true);
            d.this.u.n.setClickable(true);
            d.this.u.k.setClickable(true);
            d.this.u.f66535h.setClickable(true);
            d.this.u.s.setClickable(true);
            d.this.u.v.setClickable(true);
            d.this.u.y.setClickable(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.u.q.setClickable(false);
            d.this.u.n.setClickable(false);
            d.this.u.k.setClickable(false);
            d.this.u.f66535h.setClickable(false);
            d.this.u.s.setClickable(false);
            d.this.u.v.setClickable(false);
            d.this.u.y.setClickable(false);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                d.this.u.C.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                d.this.u.C.setTranslationY(d.this.r * valueAnimator.getAnimatedFraction());
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
            d.this.u.C.setAlpha(0.0f);
            d.this.u.C.setTranslationY(d.this.r);
            d.this.y();
            d.this.u.q.setClickable(true);
            d.this.u.n.setClickable(true);
            d.this.u.k.setClickable(true);
            d.this.u.f66535h.setClickable(true);
            d.this.u.s.setClickable(true);
            d.this.u.v.setClickable(true);
            d.this.u.y.setClickable(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.u.q.setClickable(false);
            d.this.u.n.setClickable(false);
            d.this.u.k.setClickable(false);
            d.this.u.f66535h.setClickable(false);
            d.this.u.s.setClickable(false);
            d.this.u.v.setClickable(false);
            d.this.u.y.setClickable(false);
        }
    }

    /* renamed from: d.a.o0.w3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1771d implements Runnable {
        public RunnableC1771d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.f66601f != null && dVar.j == 0.0f && d.this.k == 0.0f) {
                d.this.u.B.getGlobalVisibleRect(d.this.f66602g);
                d dVar2 = d.this;
                dVar2.j = dVar2.f66601f.centerX() - d.this.f66602g.centerX();
                d dVar3 = d.this;
                dVar3.k = dVar3.f66601f.centerY() - d.this.f66602g.centerY();
            }
            d.this.u.B.setVisibility(0);
            d.this.u.B.setTranslationX(d.this.j);
            d.this.u.B.setTranslationY(d.this.k);
            d dVar4 = d.this;
            View view = dVar4.f66598c;
            if (view instanceof OvalActionButton) {
                ((OvalActionButton) view).b(dVar4.u.B);
            }
            d.this.f66561h.start();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!(d.this.j == 0.0f && d.this.k == 0.0f) && valueAnimator.isRunning()) {
                d.this.u.B.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                d.this.u.B.setTranslationX(d.this.j - (d.this.j * valueAnimator.getAnimatedFraction()));
                d.this.u.B.setTranslationY(d.this.k - (d.this.k * valueAnimator.getAnimatedFraction()));
                d.this.u.B.setRotation(valueAnimator.getAnimatedFraction() * (-90.0f));
            }
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
            d.this.u.B.setTranslationX(0.0f);
            d.this.u.B.setTranslationY(0.0f);
            d.this.u.B.setRotation(-90.0f);
            d.this.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, d.this.t, "webp");
            d.this.u.B.setCrossFade(1.0f, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = d.this.f66598c;
            if (view != null) {
                view.setVisibility(4);
                d.this.f66598c.setAlpha(0.0f);
            }
            d.this.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, d.this.t, "webp");
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!(d.this.j == 0.0f && d.this.k == 0.0f) && valueAnimator.isRunning()) {
                d.this.u.B.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                d.this.u.B.setTranslationX(d.this.j * valueAnimator.getAnimatedFraction());
                d.this.u.B.setTranslationY(d.this.k * valueAnimator.getAnimatedFraction());
                d.this.u.B.setRotation((valueAnimator.getAnimatedFraction() * 90.0f) - 90.0f);
            }
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
            d.this.u.B.setTranslationX(d.this.j);
            d.this.u.B.setTranslationY(d.this.k);
            d.this.u.B.setRotation(0.0f);
            d.this.u.B.setEndIcon(0, 0, "");
            d.this.u.B.setCrossFade(1.0f, true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, d.this.t, "webp");
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                d.this.u.C.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                d.this.u.f66532e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                d.this.u.f66533f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            d.this.u.C.setAlpha(1.0f);
            d.this.u.f66532e.setAlpha(1.0f);
            d.this.u.f66533f.setAlpha(1.0f);
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
                d.this.u.f66532e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                d.this.u.f66533f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            d.this.u.f66532e.setAlpha(0.0f);
            d.this.u.f66533f.setAlpha(0.0f);
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
            if (valueAnimator.isRunning()) {
                d.this.u.C.setTranslationY(d.this.q - (d.this.q * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    public d(Context context, a.c cVar) {
        super(context, cVar);
        d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.u = cVar;
        this.t = d.a.c.e.p.l.g(this.f66596a, R.dimen.tbds0);
        x();
    }

    @Override // d.a.o0.w3.g
    public void c() {
        y();
    }

    @Override // d.a.o0.w3.g
    public void d() {
        v();
    }

    @Override // d.a.o0.w3.g
    public void g() {
        if (this.f66600e != 4) {
            return;
        }
        this.f66600e = 1;
        g.a aVar = this.f66599d;
        if (aVar != null) {
            aVar.a(1);
        }
        v();
        z(0);
        this.l.start();
        this.n.start();
        w();
    }

    @Override // d.a.o0.w3.g
    public void h() {
        if (this.f66600e != 2) {
            return;
        }
        this.f66600e = 3;
        g.a aVar = this.f66599d;
        if (aVar != null) {
            aVar.a(3);
        }
        v();
        this.m.start();
        this.f66562i.start();
        this.p.start();
    }

    public final void v() {
        this.f66561h.cancel();
        this.f66562i.cancel();
        this.m.cancel();
        this.l.cancel();
    }

    public final void w() {
        this.u.B.post(new RunnableC1771d());
    }

    public final void x() {
        this.n = new AnimatorSet();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f66561h = ofFloat;
        ofFloat.setDuration(450L);
        this.f66561h.setInterpolator(new OvershootInterpolator());
        this.f66561h.addUpdateListener(new e());
        this.f66561h.addListener(new f());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f66562i = ofFloat2;
        ofFloat2.setDuration(450L);
        this.f66562i.setInterpolator(new AccelerateInterpolator());
        this.f66562i.addUpdateListener(new g());
        this.f66562i.addListener(new h());
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.l = ofFloat3;
        ofFloat3.setDuration(416L);
        this.l.addUpdateListener(new i());
        this.l.addListener(new j());
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.m = ofFloat4;
        ofFloat4.setDuration(200L);
        this.m.addUpdateListener(new k());
        this.m.addListener(new l());
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.o = ofFloat5;
        ofFloat5.setDuration(240L);
        this.o.addUpdateListener(new m());
        this.n.addListener(new a());
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.p = ofFloat6;
        ofFloat6.setDuration(200L);
        this.p.addUpdateListener(new b());
        this.p.addListener(new c());
        this.u.j.setVisibility(0);
        this.u.f66534g.setVisibility(0);
        this.u.m.setVisibility(0);
        this.u.p.setVisibility(TbSingleton.getInstance().isShowStartLiveEntry() ? 0 : 8);
        this.u.s.setVisibility(0);
        if (this.u.v.getVisibility() != 8) {
            this.u.v.setVisibility(0);
        }
        this.q = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.s = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.r = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.n.play(this.o);
    }

    public final void y() {
        View view = this.f66598c;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f66600e = 4;
        v();
        z(8);
        this.u.B.setVisibility(4);
        View view2 = this.f66598c;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f66598c.setAlpha(1.0f);
        }
        g.a aVar = this.f66599d;
        if (aVar != null) {
            aVar.a(this.f66600e);
        }
    }

    public final void z(int i2) {
        this.u.f66533f.setVisibility(i2);
        this.u.f66532e.setVisibility(i2);
        this.u.C.setVisibility(i2);
    }
}
