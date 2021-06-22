package d.a.o0.w3;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import d.a.o0.w3.a;
import d.a.o0.w3.g;
/* loaded from: classes5.dex */
public class e extends g {

    /* renamed from: h  reason: collision with root package name */
    public a.b f66576h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f66577i;
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
        this.f66576h = bVar;
        this.f66577i = AnimationUtils.loadAnimation(this.f66596a, R.anim.ubs_test_in_anim);
        this.j = AnimationUtils.loadAnimation(this.f66596a, R.anim.ubs_test_out_anim);
        this.f66577i.setAnimationListener(new a());
        this.j.setAnimationListener(new b());
    }

    @Override // d.a.o0.w3.g
    public void c() {
        l();
    }

    @Override // d.a.o0.w3.g
    public void d() {
        k();
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
        k();
        this.f66576h.f66522f.startAnimation(this.f66577i);
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
        k();
        this.f66576h.f66522f.startAnimation(this.j);
    }

    public final void k() {
        this.f66577i.cancel();
        this.j.cancel();
        this.f66576h.f66522f.clearAnimation();
    }

    public final void l() {
        this.f66576h.f66521e.setClickable(false);
        this.f66600e = 4;
        g.a aVar = this.f66599d;
        if (aVar != null) {
            aVar.a(4);
        }
    }

    public final void m() {
        this.f66576h.f66521e.setClickable(true);
        this.f66600e = 2;
        g.a aVar = this.f66599d;
        if (aVar != null) {
            aVar.a(2);
        }
    }
}
