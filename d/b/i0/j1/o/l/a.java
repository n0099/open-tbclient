package d.b.i0.j1.o.l;

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
    public TbPageContext<?> f57394a;

    /* renamed from: b  reason: collision with root package name */
    public View f57395b;

    /* renamed from: c  reason: collision with root package name */
    public Animation f57396c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f57397d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f57398e;
    public LegoListFragment k;
    public h l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57399f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57400g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57401h = false;
    public boolean i = false;
    public boolean j = true;
    public View.OnClickListener m = new View$OnClickListenerC1359a();
    public Runnable n = new g();

    /* renamed from: d.b.i0.j1.o.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1359a implements View.OnClickListener {
        public View$OnClickListenerC1359a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.p() && a.this.f57395b.getAlpha() == 0.0f) {
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
            a.this.f57401h = false;
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
            a.this.i = false;
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
            a.this.i = false;
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
            a.this.f57399f = false;
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
            a.this.f57400g = false;
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
        this.f57394a = tbPageContext;
        View findViewById = view.findViewById(R.id.cover_video);
        this.f57395b = findViewById;
        findViewById.setOnClickListener(this.m);
        this.f57396c = AnimationUtils.loadAnimation(this.f57394a.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.f57397d = AnimationUtils.loadAnimation(this.f57394a.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.f57398e = AnimationUtils.loadAnimation(this.f57394a.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.k = d.b.i0.j1.o.l.d.b(tbPageContext);
        d.b.i0.j1.o.l.d.c(tbPageContext);
    }

    public final void i() {
        if (p()) {
            return;
        }
        this.f57395b.clearAnimation();
        this.f57399f = false;
        this.f57400g = false;
        this.f57401h = false;
        this.i = false;
    }

    public void j() {
        if (p()) {
            return;
        }
        if (!this.f57399f) {
            i();
        }
        if (this.f57399f) {
            return;
        }
        this.f57397d.setAnimationListener(new e());
        this.f57395b.startAnimation(this.f57397d);
        this.f57399f = true;
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
        this.f57395b.setAlpha(0.0f);
        s(false);
    }

    public void l() {
        if (p() || this.i) {
            return;
        }
        i();
        this.f57397d.setAnimationListener(new c());
        this.f57395b.postDelayed(new d(), 200L);
        this.i = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void m() {
        if (p()) {
            return;
        }
        if (!this.f57400g) {
            i();
        }
        if (this.f57400g) {
            return;
        }
        this.f57396c.setAnimationListener(new f());
        this.f57395b.setAlpha(1.0f);
        this.f57395b.startAnimation(this.f57396c);
        this.f57400g = true;
    }

    public void n() {
        if (p()) {
            return;
        }
        i();
        this.f57395b.setAlpha(1.0f);
        d.b.c.e.m.e.a().removeCallbacks(this.n);
        s(true);
    }

    public void o() {
        if (p() || this.f57401h) {
            return;
        }
        i();
        this.f57398e.setAnimationListener(new b());
        this.f57401h = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.b();
        }
        s(true);
    }

    public final boolean p() {
        return this.f57395b == null;
    }

    public void q() {
        i();
        s(false);
        this.f57395b.setAlpha(0.0f);
        d.b.c.e.m.e.a().removeCallbacks(this.n);
    }

    public void r() {
        q();
        if (this.j) {
            d.b.c.e.m.e.a().postDelayed(this.n, 3000L);
        }
    }

    public final void s(boolean z) {
        if (p()) {
            return;
        }
        this.f57395b.setClickable(z);
    }

    public void t(h hVar) {
        this.l = hVar;
    }

    public void u(boolean z) {
        this.j = z;
    }
}
