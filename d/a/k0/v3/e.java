package d.a.k0.v3;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import d.a.k0.v3.a;
import d.a.k0.v3.g;
/* loaded from: classes5.dex */
public class e extends g {

    /* renamed from: h  reason: collision with root package name */
    public a.b f62629h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f62630i;
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
        this.f62629h = bVar;
        this.f62630i = AnimationUtils.loadAnimation(this.f62649a, R.anim.ubs_test_in_anim);
        this.j = AnimationUtils.loadAnimation(this.f62649a, R.anim.ubs_test_out_anim);
        this.f62630i.setAnimationListener(new a());
        this.j.setAnimationListener(new b());
    }

    @Override // d.a.k0.v3.g
    public void c() {
        l();
    }

    @Override // d.a.k0.v3.g
    public void d() {
        k();
    }

    @Override // d.a.k0.v3.g
    public void g() {
        if (this.f62653e != 4) {
            return;
        }
        this.f62653e = 1;
        g.a aVar = this.f62652d;
        if (aVar != null) {
            aVar.a(1);
        }
        k();
        this.f62629h.f62575f.startAnimation(this.f62630i);
    }

    @Override // d.a.k0.v3.g
    public void h() {
        if (this.f62653e != 2) {
            return;
        }
        this.f62653e = 3;
        g.a aVar = this.f62652d;
        if (aVar != null) {
            aVar.a(3);
        }
        k();
        this.f62629h.f62575f.startAnimation(this.j);
    }

    public final void k() {
        this.f62630i.cancel();
        this.j.cancel();
        this.f62629h.f62575f.clearAnimation();
    }

    public final void l() {
        this.f62629h.f62574e.setClickable(false);
        this.f62653e = 4;
        g.a aVar = this.f62652d;
        if (aVar != null) {
            aVar.a(4);
        }
    }

    public final void m() {
        this.f62629h.f62574e.setClickable(true);
        this.f62653e = 2;
        g.a aVar = this.f62652d;
        if (aVar != null) {
            aVar.a(2);
        }
    }
}
