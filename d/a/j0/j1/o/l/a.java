package d.a.j0.j1.o.l;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListFragment;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55781a;

    /* renamed from: b  reason: collision with root package name */
    public View f55782b;

    /* renamed from: c  reason: collision with root package name */
    public Animation f55783c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f55784d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f55785e;
    public LegoListFragment k;
    public h l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55786f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55787g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55788h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55789i = false;
    public boolean j = true;
    public View.OnClickListener m = new View$OnClickListenerC1321a();
    public Runnable n = new g();

    /* renamed from: d.a.j0.j1.o.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1321a implements View.OnClickListener {
        public View$OnClickListenerC1321a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.p() && a.this.f55782b.getAlpha() == 0.0f) {
                a.this.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (a.this.p()) {
                return;
            }
            a.this.f55788h = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016475, Boolean.FALSE));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.f55789i = false;
            a.this.r();
            if (a.this.p()) {
                return;
            }
            a.this.s(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016475, Boolean.TRUE));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f55789i = false;
            a.this.r();
            if (a.this.p()) {
                return;
            }
            a.this.s(false);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.k();
            a.this.f55786f = false;
            a.this.r();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016475, Boolean.TRUE));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Animation.AnimationListener {
        public f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.n();
            a.this.f55787g = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.k != null && a.this.k.l1() == 1) {
                a.this.r();
            } else {
                a.this.o();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a();

        void b();

        void c();
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.f55781a = tbPageContext;
        View findViewById = view.findViewById(R.id.cover_video);
        this.f55782b = findViewById;
        findViewById.setOnClickListener(this.m);
        this.f55783c = AnimationUtils.loadAnimation(this.f55781a.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.f55784d = AnimationUtils.loadAnimation(this.f55781a.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.f55785e = AnimationUtils.loadAnimation(this.f55781a.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.k = d.a.j0.j1.o.l.d.b(tbPageContext);
        d.a.j0.j1.o.l.d.c(tbPageContext);
    }

    public final void i() {
        if (p()) {
            return;
        }
        this.f55782b.clearAnimation();
        this.f55786f = false;
        this.f55787g = false;
        this.f55788h = false;
        this.f55789i = false;
    }

    public void j() {
        if (p()) {
            return;
        }
        if (!this.f55786f) {
            i();
        }
        if (this.f55786f) {
            return;
        }
        this.f55784d.setAnimationListener(new e());
        this.f55782b.startAnimation(this.f55784d);
        this.f55786f = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void k() {
        if (p()) {
            return;
        }
        i();
        this.f55782b.setAlpha(0.0f);
        s(false);
    }

    public void l() {
        if (p() || this.f55789i) {
            return;
        }
        i();
        this.f55784d.setAnimationListener(new c());
        this.f55782b.postDelayed(new d(), 200L);
        this.f55789i = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void m() {
        if (p()) {
            return;
        }
        if (!this.f55787g) {
            i();
        }
        if (this.f55787g) {
            return;
        }
        this.f55783c.setAnimationListener(new f());
        this.f55782b.setAlpha(1.0f);
        this.f55782b.startAnimation(this.f55783c);
        this.f55787g = true;
    }

    public void n() {
        if (p()) {
            return;
        }
        i();
        this.f55782b.setAlpha(1.0f);
        d.a.c.e.m.e.a().removeCallbacks(this.n);
        s(true);
    }

    public void o() {
        if (p() || this.f55788h) {
            return;
        }
        i();
        this.f55785e.setAnimationListener(new b());
        this.f55788h = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.a();
        }
        s(true);
    }

    public final boolean p() {
        return this.f55782b == null;
    }

    public void q() {
        i();
        s(false);
        this.f55782b.setAlpha(0.0f);
        d.a.c.e.m.e.a().removeCallbacks(this.n);
    }

    public void r() {
        q();
        if (this.j) {
            d.a.c.e.m.e.a().postDelayed(this.n, 3000L);
        }
    }

    public final void s(boolean z) {
        if (p()) {
            return;
        }
        this.f55782b.setClickable(z);
    }

    public void t(h hVar) {
        this.l = hVar;
    }

    public void u(boolean z) {
        this.j = z;
    }
}
