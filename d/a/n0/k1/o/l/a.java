package d.a.n0.k1.o.l;

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
    public TbPageContext<?> f56668a;

    /* renamed from: b  reason: collision with root package name */
    public View f56669b;

    /* renamed from: c  reason: collision with root package name */
    public Animation f56670c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f56671d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f56672e;
    public LegoListFragment k;
    public h l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56673f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56674g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56675h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56676i = false;
    public boolean j = true;
    public View.OnClickListener m = new View$OnClickListenerC1411a();
    public Runnable n = new g();

    /* renamed from: d.a.n0.k1.o.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1411a implements View.OnClickListener {
        public View$OnClickListenerC1411a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.p() && a.this.f56669b.getAlpha() == 0.0f) {
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
            a.this.f56675h = false;
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
            a.this.f56676i = false;
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
            a.this.f56676i = false;
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
            a.this.f56673f = false;
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
            a.this.f56674g = false;
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
        this.f56668a = tbPageContext;
        View findViewById = view.findViewById(R.id.cover_video);
        this.f56669b = findViewById;
        findViewById.setOnClickListener(this.m);
        this.f56670c = AnimationUtils.loadAnimation(this.f56668a.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.f56671d = AnimationUtils.loadAnimation(this.f56668a.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.f56672e = AnimationUtils.loadAnimation(this.f56668a.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.k = d.a.n0.k1.o.l.d.b(tbPageContext);
        d.a.n0.k1.o.l.d.c(tbPageContext);
    }

    public final void i() {
        if (p()) {
            return;
        }
        this.f56669b.clearAnimation();
        this.f56673f = false;
        this.f56674g = false;
        this.f56675h = false;
        this.f56676i = false;
    }

    public void j() {
        if (p()) {
            return;
        }
        if (!this.f56673f) {
            i();
        }
        if (this.f56673f) {
            return;
        }
        this.f56671d.setAnimationListener(new e());
        this.f56669b.startAnimation(this.f56671d);
        this.f56673f = true;
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
        this.f56669b.setAlpha(0.0f);
        s(false);
    }

    public void l() {
        if (p() || this.f56676i) {
            return;
        }
        i();
        this.f56671d.setAnimationListener(new c());
        this.f56669b.postDelayed(new d(), 200L);
        this.f56676i = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void m() {
        if (p()) {
            return;
        }
        if (!this.f56674g) {
            i();
        }
        if (this.f56674g) {
            return;
        }
        this.f56670c.setAnimationListener(new f());
        this.f56669b.setAlpha(1.0f);
        this.f56669b.startAnimation(this.f56670c);
        this.f56674g = true;
    }

    public void n() {
        if (p()) {
            return;
        }
        i();
        this.f56669b.setAlpha(1.0f);
        d.a.c.e.m.e.a().removeCallbacks(this.n);
        s(true);
    }

    public void o() {
        if (p() || this.f56675h) {
            return;
        }
        i();
        this.f56672e.setAnimationListener(new b());
        this.f56675h = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.a();
        }
        s(true);
    }

    public final boolean p() {
        return this.f56669b == null;
    }

    public void q() {
        i();
        s(false);
        this.f56669b.setAlpha(0.0f);
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
        this.f56669b.setClickable(z);
    }

    public void t(h hVar) {
        this.l = hVar;
    }

    public void u(boolean z) {
        this.j = z;
    }
}
