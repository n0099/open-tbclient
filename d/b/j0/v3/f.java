package d.b.j0.v3;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import d.b.j0.v3.a;
import d.b.j0.v3.h;
/* loaded from: classes5.dex */
public class f extends h {

    /* renamed from: h  reason: collision with root package name */
    public a.b f63676h;
    public Animation i;
    public Animation j;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            f.this.m();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            f.this.l();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public f(Context context, a.b bVar) {
        super(context, bVar);
        this.f63676h = bVar;
        this.i = AnimationUtils.loadAnimation(this.f63694a, R.anim.ubs_test_in_anim);
        this.j = AnimationUtils.loadAnimation(this.f63694a, R.anim.ubs_test_out_anim);
        this.i.setAnimationListener(new a());
        this.j.setAnimationListener(new b());
    }

    @Override // d.b.j0.v3.h
    public void c() {
        l();
    }

    @Override // d.b.j0.v3.h
    public void d() {
        k();
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
        k();
        this.f63676h.f63604f.startAnimation(this.i);
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
        k();
        this.f63676h.f63604f.startAnimation(this.j);
    }

    public final void k() {
        this.i.cancel();
        this.j.cancel();
        this.f63676h.f63604f.clearAnimation();
    }

    public final void l() {
        this.f63676h.f63603e.setClickable(false);
        this.f63698e = 4;
        h.a aVar = this.f63697d;
        if (aVar != null) {
            aVar.a(4);
        }
    }

    public final void m() {
        this.f63676h.f63603e.setClickable(true);
        this.f63698e = 2;
        h.a aVar = this.f63697d;
        if (aVar != null) {
            aVar.a(2);
        }
    }
}
