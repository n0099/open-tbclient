package d.b.i0.i1.o.l;

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
    public TbPageContext<?> f55946a;

    /* renamed from: b  reason: collision with root package name */
    public View f55947b;

    /* renamed from: c  reason: collision with root package name */
    public Animation f55948c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f55949d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f55950e;
    public LegoListFragment k;
    public h l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55951f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55952g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55953h = false;
    public boolean i = false;
    public boolean j = true;
    public View.OnClickListener m = new View$OnClickListenerC1302a();
    public Runnable n = new g();

    /* renamed from: d.b.i0.i1.o.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1302a implements View.OnClickListener {
        public View$OnClickListenerC1302a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.p() && a.this.f55947b.getAlpha() == 0.0f) {
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
            a.this.f55953h = false;
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
            a.this.f55951f = false;
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
            a.this.f55952g = false;
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
        this.f55946a = tbPageContext;
        View findViewById = view.findViewById(R.id.cover_video);
        this.f55947b = findViewById;
        findViewById.setOnClickListener(this.m);
        this.f55948c = AnimationUtils.loadAnimation(this.f55946a.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.f55949d = AnimationUtils.loadAnimation(this.f55946a.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.f55950e = AnimationUtils.loadAnimation(this.f55946a.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.k = d.b.i0.i1.o.l.d.b(tbPageContext);
        d.b.i0.i1.o.l.d.c(tbPageContext);
    }

    public final void i() {
        if (p()) {
            return;
        }
        this.f55947b.clearAnimation();
        this.f55951f = false;
        this.f55952g = false;
        this.f55953h = false;
        this.i = false;
    }

    public void j() {
        if (p()) {
            return;
        }
        if (!this.f55951f) {
            i();
        }
        if (this.f55951f) {
            return;
        }
        this.f55949d.setAnimationListener(new e());
        this.f55947b.startAnimation(this.f55949d);
        this.f55951f = true;
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
        this.f55947b.setAlpha(0.0f);
        s(false);
    }

    public void l() {
        if (p() || this.i) {
            return;
        }
        i();
        this.f55949d.setAnimationListener(new c());
        this.f55947b.postDelayed(new d(), 200L);
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
        if (!this.f55952g) {
            i();
        }
        if (this.f55952g) {
            return;
        }
        this.f55948c.setAnimationListener(new f());
        this.f55947b.setAlpha(1.0f);
        this.f55947b.startAnimation(this.f55948c);
        this.f55952g = true;
    }

    public void n() {
        if (p()) {
            return;
        }
        i();
        this.f55947b.setAlpha(1.0f);
        d.b.b.e.m.e.a().removeCallbacks(this.n);
        s(true);
    }

    public void o() {
        if (p() || this.f55953h) {
            return;
        }
        i();
        this.f55950e.setAnimationListener(new b());
        this.f55953h = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.b();
        }
        s(true);
    }

    public final boolean p() {
        return this.f55947b == null;
    }

    public void q() {
        i();
        s(false);
        this.f55947b.setAlpha(0.0f);
        d.b.b.e.m.e.a().removeCallbacks(this.n);
    }

    public void r() {
        q();
        if (this.j) {
            d.b.b.e.m.e.a().postDelayed(this.n, 3000L);
        }
    }

    public final void s(boolean z) {
        if (p()) {
            return;
        }
        this.f55947b.setClickable(z);
    }

    public void t(h hVar) {
        this.l = hVar;
    }

    public void u(boolean z) {
        this.j = z;
    }
}
