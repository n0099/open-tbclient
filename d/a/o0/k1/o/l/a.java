package d.a.o0.k1.o.l;

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
    public TbPageContext<?> f60482a;

    /* renamed from: b  reason: collision with root package name */
    public View f60483b;

    /* renamed from: c  reason: collision with root package name */
    public Animation f60484c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f60485d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f60486e;
    public LegoListFragment k;
    public h l;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60487f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60488g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60489h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60490i = false;
    public boolean j = true;
    public View.OnClickListener m = new View$OnClickListenerC1471a();
    public Runnable n = new g();

    /* renamed from: d.a.o0.k1.o.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1471a implements View.OnClickListener {
        public View$OnClickListenerC1471a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.p() && a.this.f60483b.getAlpha() == 0.0f) {
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
            a.this.f60489h = false;
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
            a.this.f60490i = false;
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
            a.this.f60490i = false;
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
            a.this.f60487f = false;
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
            a.this.f60488g = false;
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
            if (a.this.k != null && a.this.k.n1() == 1) {
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
        this.f60482a = tbPageContext;
        View findViewById = view.findViewById(R.id.cover_video);
        this.f60483b = findViewById;
        findViewById.setOnClickListener(this.m);
        this.f60484c = AnimationUtils.loadAnimation(this.f60482a.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.f60485d = AnimationUtils.loadAnimation(this.f60482a.getPageActivity(), R.anim.card_anim_alpha_1_to_0_duration_200_offset_200);
        this.f60486e = AnimationUtils.loadAnimation(this.f60482a.getPageActivity(), R.anim.card_anim_alpha_0_to_1_duration_2000);
        this.k = d.a.o0.k1.o.l.d.b(tbPageContext);
        d.a.o0.k1.o.l.d.c(tbPageContext);
    }

    public final void i() {
        if (p()) {
            return;
        }
        this.f60483b.clearAnimation();
        this.f60487f = false;
        this.f60488g = false;
        this.f60489h = false;
        this.f60490i = false;
    }

    public void j() {
        if (p()) {
            return;
        }
        if (!this.f60487f) {
            i();
        }
        if (this.f60487f) {
            return;
        }
        this.f60485d.setAnimationListener(new e());
        this.f60483b.startAnimation(this.f60485d);
        this.f60487f = true;
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
        this.f60483b.setAlpha(0.0f);
        s(false);
    }

    public void l() {
        if (p() || this.f60490i) {
            return;
        }
        i();
        this.f60485d.setAnimationListener(new c());
        this.f60483b.postDelayed(new d(), 200L);
        this.f60490i = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void m() {
        if (p()) {
            return;
        }
        if (!this.f60488g) {
            i();
        }
        if (this.f60488g) {
            return;
        }
        this.f60484c.setAnimationListener(new f());
        this.f60483b.setAlpha(1.0f);
        this.f60483b.startAnimation(this.f60484c);
        this.f60488g = true;
    }

    public void n() {
        if (p()) {
            return;
        }
        i();
        this.f60483b.setAlpha(1.0f);
        d.a.c.e.m.e.a().removeCallbacks(this.n);
        s(true);
    }

    public void o() {
        if (p() || this.f60489h) {
            return;
        }
        i();
        this.f60486e.setAnimationListener(new b());
        this.f60489h = true;
        h hVar = this.l;
        if (hVar != null) {
            hVar.a();
        }
        s(true);
    }

    public final boolean p() {
        return this.f60483b == null;
    }

    public void q() {
        i();
        s(false);
        this.f60483b.setAlpha(0.0f);
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
        this.f60483b.setClickable(z);
    }

    public void t(h hVar) {
        this.l = hVar;
    }

    public void u(boolean z) {
        this.j = z;
    }
}
