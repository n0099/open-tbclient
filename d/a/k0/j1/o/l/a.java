package d.a.k0.j1.o.l;

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
    public TbPageContext<?> f56488a;

    /* renamed from: b  reason: collision with root package name */
    public View f56489b;

    /* renamed from: c  reason: collision with root package name */
    public Animation f56490c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f56491d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f56492e;
    public LegoListFragment k;
    public h l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56493f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56494g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56495h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56496i = false;
    public boolean j = true;
    public View.OnClickListener m = new View$OnClickListenerC1393a();
    public Runnable n = new g();

    /* renamed from: d.a.k0.j1.o.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1393a implements View.OnClickListener {
        public View$OnClickListenerC1393a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.p() && a.this.f56489b.getAlpha() == 0.0f) {
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
            a.this.f56495h = false;
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
            a.this.f56496i = false;
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
            a.this.f56496i = false;
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
            a.this.f56493f = false;
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
            a.this.f56494g = false;
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
            if (a.this.k != null && a.this.k.k1() == 1) {
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
        this.f56488a = tbPageContext;
        View findViewById = view.findViewById(R.id.cover_video);
        this.f56489b = findViewById;
        findViewById.setOnClickListener(this.m);
        this.f56490c = AnimationUtils.loadAnimation(this.f56488a.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.f56491d = AnimationUtils.loadAnimation(this.f56488a.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.f56492e = AnimationUtils.loadAnimation(this.f56488a.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.k = d.a.k0.j1.o.l.d.b(tbPageContext);
        d.a.k0.j1.o.l.d.c(tbPageContext);
    }

    public final void i() {
        if (p()) {
            return;
        }
        this.f56489b.clearAnimation();
        this.f56493f = false;
        this.f56494g = false;
        this.f56495h = false;
        this.f56496i = false;
    }

    public void j() {
        if (p()) {
            return;
        }
        if (!this.f56493f) {
            i();
        }
        if (this.f56493f) {
            return;
        }
        this.f56491d.setAnimationListener(new e());
        this.f56489b.startAnimation(this.f56491d);
        this.f56493f = true;
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
        this.f56489b.setAlpha(0.0f);
        s(false);
    }

    public void l() {
        if (p() || this.f56496i) {
            return;
        }
        i();
        this.f56491d.setAnimationListener(new c());
        this.f56489b.postDelayed(new d(), 200L);
        this.f56496i = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void m() {
        if (p()) {
            return;
        }
        if (!this.f56494g) {
            i();
        }
        if (this.f56494g) {
            return;
        }
        this.f56490c.setAnimationListener(new f());
        this.f56489b.setAlpha(1.0f);
        this.f56489b.startAnimation(this.f56490c);
        this.f56494g = true;
    }

    public void n() {
        if (p()) {
            return;
        }
        i();
        this.f56489b.setAlpha(1.0f);
        d.a.c.e.m.e.a().removeCallbacks(this.n);
        s(true);
    }

    public void o() {
        if (p() || this.f56495h) {
            return;
        }
        i();
        this.f56492e.setAnimationListener(new b());
        this.f56495h = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.a();
        }
        s(true);
    }

    public final boolean p() {
        return this.f56489b == null;
    }

    public void q() {
        i();
        s(false);
        this.f56489b.setAlpha(0.0f);
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
        this.f56489b.setClickable(z);
    }

    public void t(h hVar) {
        this.l = hVar;
    }

    public void u(boolean z) {
        this.j = z;
    }
}
