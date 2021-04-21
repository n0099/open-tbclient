package d.b.j0.v3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import d.b.j0.v3.a;
import d.b.j0.v3.h;
/* loaded from: classes5.dex */
public class e extends d.b.j0.v3.h {

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f63662h;
    public ValueAnimator i;
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
    public a.d u;
    public d.b.j0.u.d v;

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
            d.b.j0.u.e eVar = new d.b.j0.u.e(e.this.s);
            eVar.d(0.5f);
            eVar.f(800.0f);
            e eVar2 = e.this;
            d.b.j0.u.d dVar = new d.b.j0.u.d(e.this.u.C, d.b.j0.u.b.m);
            dVar.l(eVar);
            eVar2.v = dVar;
            e.this.v.g();
            e.this.u.C.setTranslationY(0.0f);
            e eVar3 = e.this;
            eVar3.f63698e = 2;
            h.a aVar = eVar3.f63697d;
            if (aVar != null) {
                aVar.a(2);
            }
            e.this.u.q.setClickable(true);
            e.this.u.n.setClickable(true);
            e.this.u.k.setClickable(true);
            e.this.u.f63624h.setClickable(true);
            e.this.u.s.setClickable(true);
            e.this.u.v.setClickable(true);
            e.this.u.y.setClickable(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.u.q.setClickable(false);
            e.this.u.n.setClickable(false);
            e.this.u.k.setClickable(false);
            e.this.u.f63624h.setClickable(false);
            e.this.u.s.setClickable(false);
            e.this.u.v.setClickable(false);
            e.this.u.y.setClickable(false);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                e.this.u.C.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                e.this.u.C.setTranslationY(e.this.r * valueAnimator.getAnimatedFraction());
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
            e.this.u.C.setAlpha(0.0f);
            e.this.u.C.setTranslationY(e.this.r);
            e.this.y();
            e.this.u.q.setClickable(true);
            e.this.u.n.setClickable(true);
            e.this.u.k.setClickable(true);
            e.this.u.f63624h.setClickable(true);
            e.this.u.s.setClickable(true);
            e.this.u.v.setClickable(true);
            e.this.u.y.setClickable(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.u.q.setClickable(false);
            e.this.u.n.setClickable(false);
            e.this.u.k.setClickable(false);
            e.this.u.f63624h.setClickable(false);
            e.this.u.s.setClickable(false);
            e.this.u.v.setClickable(false);
            e.this.u.y.setClickable(false);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            if (eVar.f63699f != null && eVar.j == 0.0f && e.this.k == 0.0f) {
                e.this.u.B.getGlobalVisibleRect(e.this.f63700g);
                e eVar2 = e.this;
                eVar2.j = eVar2.f63699f.centerX() - e.this.f63700g.centerX();
                e eVar3 = e.this;
                eVar3.k = eVar3.f63699f.centerY() - e.this.f63700g.centerY();
            }
            e.this.u.B.setVisibility(0);
            e.this.u.B.setTranslationX(e.this.j);
            e.this.u.B.setTranslationY(e.this.k);
            e eVar4 = e.this;
            View view = eVar4.f63696c;
            if (view instanceof OvalActionButton) {
                ((OvalActionButton) view).b(eVar4.u.B);
            }
            e.this.f63662h.start();
        }
    }

    /* renamed from: d.b.j0.v3.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1695e implements ValueAnimator.AnimatorUpdateListener {
        public C1695e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!(e.this.j == 0.0f && e.this.k == 0.0f) && valueAnimator.isRunning()) {
                e.this.u.B.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                e.this.u.B.setTranslationX(e.this.j - (e.this.j * valueAnimator.getAnimatedFraction()));
                e.this.u.B.setTranslationY(e.this.k - (e.this.k * valueAnimator.getAnimatedFraction()));
                e.this.u.B.setRotation(valueAnimator.getAnimatedFraction() * (-90.0f));
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
            e.this.u.B.setTranslationX(0.0f);
            e.this.u.B.setTranslationY(0.0f);
            e.this.u.B.setRotation(-90.0f);
            e.this.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.t, "webp");
            e.this.u.B.setCrossFade(1.0f, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = e.this.f63696c;
            if (view != null) {
                view.setVisibility(4);
                e.this.f63696c.setAlpha(0.0f);
            }
            e.this.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.t, "webp");
        }
    }

    /* loaded from: classes5.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!(e.this.j == 0.0f && e.this.k == 0.0f) && valueAnimator.isRunning()) {
                e.this.u.B.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                e.this.u.B.setTranslationX(e.this.j * valueAnimator.getAnimatedFraction());
                e.this.u.B.setTranslationY(e.this.k * valueAnimator.getAnimatedFraction());
                e.this.u.B.setRotation((valueAnimator.getAnimatedFraction() * 90.0f) - 90.0f);
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
            e.this.u.B.setTranslationX(e.this.j);
            e.this.u.B.setTranslationY(e.this.k);
            e.this.u.B.setRotation(0.0f);
            e.this.u.B.setEndIcon(0, 0, "");
            e.this.u.B.setCrossFade(1.0f, true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.u.B.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.t, "webp");
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                e.this.u.C.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                e.this.u.f63621e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                e.this.u.f63622f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            e.this.u.C.setAlpha(1.0f);
            e.this.u.f63621e.setAlpha(1.0f);
            e.this.u.f63622f.setAlpha(1.0f);
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
                e.this.u.f63621e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                e.this.u.f63622f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            e.this.u.f63621e.setAlpha(0.0f);
            e.this.u.f63622f.setAlpha(0.0f);
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
                e.this.u.C.setTranslationY(e.this.q - (e.this.q * valueAnimator.getAnimatedFraction()));
            }
        }
    }

    public e(Context context, a.d dVar) {
        super(context, dVar);
        d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.u = dVar;
        this.t = d.b.c.e.p.l.g(this.f63694a, R.dimen.tbds0);
        x();
    }

    @Override // d.b.j0.v3.h
    public void c() {
        y();
    }

    @Override // d.b.j0.v3.h
    public void d() {
        v();
    }

    @Override // d.b.j0.v3.h
    public void g() {
        if (this.f63698e != 4) {
            return;
        }
        this.f63698e = 1;
        h.a aVar = this.f63697d;
        if (aVar != null) {
            aVar.a(1);
        }
        v();
        z(0);
        this.l.start();
        this.n.start();
        w();
    }

    @Override // d.b.j0.v3.h
    public void h() {
        if (this.f63698e != 2) {
            return;
        }
        this.f63698e = 3;
        h.a aVar = this.f63697d;
        if (aVar != null) {
            aVar.a(3);
        }
        v();
        this.m.start();
        this.i.start();
        this.p.start();
    }

    public final void v() {
        this.f63662h.cancel();
        this.i.cancel();
        this.m.cancel();
        this.l.cancel();
    }

    public final void w() {
        this.u.B.post(new d());
    }

    public final void x() {
        this.n = new AnimatorSet();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f63662h = ofFloat;
        ofFloat.setDuration(450L);
        this.f63662h.setInterpolator(new OvershootInterpolator());
        this.f63662h.addUpdateListener(new C1695e());
        this.f63662h.addListener(new f());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.i = ofFloat2;
        ofFloat2.setDuration(450L);
        this.i.setInterpolator(new AccelerateInterpolator());
        this.i.addUpdateListener(new g());
        this.i.addListener(new h());
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
        this.u.f63623g.setVisibility(0);
        this.u.m.setVisibility(0);
        this.u.p.setVisibility(0);
        this.u.s.setVisibility(0);
        if (this.u.v.getVisibility() != 8) {
            this.u.v.setVisibility(0);
        }
        this.q = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.s = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.r = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.n.play(this.o);
    }

    public final void y() {
        View view = this.f63696c;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f63698e = 4;
        v();
        z(8);
        this.u.B.setVisibility(4);
        View view2 = this.f63696c;
        if (view2 != null) {
            view2.setVisibility(0);
            this.f63696c.setAlpha(1.0f);
        }
        h.a aVar = this.f63697d;
        if (aVar != null) {
            aVar.a(this.f63698e);
        }
    }

    public final void z(int i2) {
        this.u.f63622f.setVisibility(i2);
        this.u.f63621e.setVisibility(i2);
        this.u.C.setVisibility(i2);
    }
}
