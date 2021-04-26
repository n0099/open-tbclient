package d.a.j0.v3;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import d.a.j0.v3.a;
import d.a.j0.v3.g;
/* loaded from: classes5.dex */
public class e extends g {

    /* renamed from: h  reason: collision with root package name */
    public a.b f61905h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f61906i;
    public Animation j;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            e.this.m();
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
            e.this.l();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public e(Context context, a.b bVar) {
        super(context, bVar);
        this.f61905h = bVar;
        this.f61906i = AnimationUtils.loadAnimation(this.f61925a, R.anim.ubs_test_in_anim);
        this.j = AnimationUtils.loadAnimation(this.f61925a, R.anim.ubs_test_out_anim);
        this.f61906i.setAnimationListener(new a());
        this.j.setAnimationListener(new b());
    }

    @Override // d.a.j0.v3.g
    public void c() {
        l();
    }

    @Override // d.a.j0.v3.g
    public void d() {
        k();
    }

    @Override // d.a.j0.v3.g
    public void g() {
        if (this.f61929e != 4) {
            return;
        }
        this.f61929e = 1;
        g.a aVar = this.f61928d;
        if (aVar != null) {
            aVar.a(1);
        }
        k();
        this.f61905h.f61851f.startAnimation(this.f61906i);
    }

    @Override // d.a.j0.v3.g
    public void h() {
        if (this.f61929e != 2) {
            return;
        }
        this.f61929e = 3;
        g.a aVar = this.f61928d;
        if (aVar != null) {
            aVar.a(3);
        }
        k();
        this.f61905h.f61851f.startAnimation(this.j);
    }

    public final void k() {
        this.f61906i.cancel();
        this.j.cancel();
        this.f61905h.f61851f.clearAnimation();
    }

    public final void l() {
        this.f61905h.f61850e.setClickable(false);
        this.f61929e = 4;
        g.a aVar = this.f61928d;
        if (aVar != null) {
            aVar.a(4);
        }
    }

    public final void m() {
        this.f61905h.f61850e.setClickable(true);
        this.f61929e = 2;
        g.a aVar = this.f61928d;
        if (aVar != null) {
            aVar.a(2);
        }
    }
}
