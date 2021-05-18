package d.a.k0.q0.o2;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.google.android.material.appbar.AppBarLayout;
import d.a.k0.q0.o;
import d.a.k0.q0.s0;
/* loaded from: classes4.dex */
public class k {
    public static int s = 5000;

    /* renamed from: a  reason: collision with root package name */
    public PullRefreshFrameLayout f59152a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f59153b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f59154c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f59155d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f59156e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f59157f;

    /* renamed from: i  reason: collision with root package name */
    public s0 f59160i;
    public o j;
    public View k;
    public int n;
    public int o;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59158g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59159h = false;
    public RelativeLayout.LayoutParams l = null;
    public int m = 0;
    public PullRefreshFrameLayout.i p = new a();
    public PullRefreshFrameLayout.h q = new b();
    public Runnable r = new c();

    /* loaded from: classes4.dex */
    public class a implements PullRefreshFrameLayout.i {

        /* renamed from: d.a.k0.q0.o2.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1518a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59162e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f59163f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f59164g;

            public C1518a(int i2, int i3, int i4) {
                this.f59162e = i2;
                this.f59163f = i3;
                this.f59164g = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                k.this.l.height = (int) (this.f59162e - (this.f59163f * animatedFraction));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j != null) {
                    k.this.j.f((int) (this.f59164g - (animatedFraction * this.f59163f)));
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                k kVar = k.this;
                kVar.n = kVar.l.height;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        /* loaded from: classes4.dex */
        public class c implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59167e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f59168f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f59169g;

            public c(int i2, int i3, int i4) {
                this.f59167e = i2;
                this.f59168f = i3;
                this.f59169g = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                k.this.l.height = (int) (this.f59167e - (this.f59168f * floatValue));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j == null || this.f59169g <= 0) {
                    return;
                }
                k.this.j.f((int) (this.f59169g - (floatValue * this.f59168f)));
            }
        }

        /* loaded from: classes4.dex */
        public class d implements Animator.AnimatorListener {
            public d() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                k.this.n = 0;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public a() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void k() {
            if (k.this.l == null) {
                return;
            }
            int i2 = k.this.l.height;
            int i3 = k.this.l.height - k.this.m;
            int a2 = k.this.j != null ? k.this.j.a() : 0;
            if (i3 > 0) {
                k.this.f59157f = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.f59157f.setDuration(300L);
                k.this.f59157f.addUpdateListener(new c(i2, i3, a2));
                k.this.f59157f.start();
                k.this.f59157f.addListener(new d());
                if (k.this.f59160i != null) {
                    k.this.f59160i.k();
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void l(double d2) {
            if (k.this.k == null || k.this.l == null) {
                return;
            }
            k.this.l.height = (int) (k.this.m + (PullRefreshFrameLayout.E * d2));
            k.this.k.setLayoutParams(k.this.l);
            if (k.this.j != null) {
                k.this.j.d(d2);
            }
            k.this.f59152a.r();
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void m(int i2, double d2) {
            if (k.this.k == null || k.this.l == null || k.this.j == null) {
                return;
            }
            k.this.f59157f = ValueAnimator.ofFloat(0.0f, 1.0f);
            k.this.f59157f.setDuration(150L);
            k.this.f59157f.addUpdateListener(new C1518a(k.this.l.height, i2, k.this.j.b()));
            k.this.f59157f.addListener(new b());
            k.this.f59157f.start();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullRefreshFrameLayout.h {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.h
        public void m() {
            k.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f59159h) {
                k.this.v();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (k.this.l != null) {
                k.this.l.height = (int) (k.this.m + (PullRefreshFrameLayout.D * floatValue));
                k.this.k.setLayoutParams(k.this.l);
            }
            if (k.this.j != null) {
                k.this.j.f((int) (k.this.j.c() + (floatValue * PullRefreshFrameLayout.D)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (k.this.f59159h || k.this.f59152a == null || k.this.f59152a.o()) {
                return;
            }
            k.this.v();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f59176e;

        public f(View view) {
            this.f59176e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.j.c() < 0) {
                k.this.j.g(this.f59176e.getMeasuredHeight());
            }
            if (k.this.j.a() < 0) {
                k.this.j.e(this.f59176e.getMeasuredHeight());
            }
        }
    }

    public k(@NonNull FrsFragment frsFragment) {
        this.f59152a = null;
        View x2 = frsFragment.x2();
        PullRefreshFrameLayout pullRefreshFrameLayout = (PullRefreshFrameLayout) x2.findViewById(R.id.frs_content_layout);
        this.f59152a = pullRefreshFrameLayout;
        pullRefreshFrameLayout.setFromFrs();
        this.f59152a.setOnTouchCallback(this.p);
        this.f59152a.setOnPullRefreshListener(this.q);
        this.f59152a.h();
        this.f59153b = (FrsHeaderViewContainer) x2.findViewById(R.id.header_view_container);
        this.f59154c = (AppBarLayout) x2.findViewById(R.id.frs_app_bar_layout);
        this.f59155d = (BdTypeRecyclerView) x2.findViewById(R.id.frs_lv_thread);
        t();
    }

    public void A(boolean z) {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f59152a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.setEnable(z);
        }
    }

    public void B() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f59152a;
        if (pullRefreshFrameLayout != null || pullRefreshFrameLayout.n()) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f59155d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setSelection(0);
            }
            AppBarLayout appBarLayout = this.f59154c;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true);
            }
            if (this.f59159h) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f59156e = ofFloat;
            ofFloat.setDuration(300L);
            this.f59156e.addUpdateListener(new d());
            this.f59156e.addListener(new e());
            this.f59156e.start();
            this.f59152a.setRefreshing(true);
            m();
        }
    }

    public void C() {
        if (this.f59159h) {
            v();
            d.a.c.e.m.e.a().removeCallbacks(this.r);
        }
    }

    public void l() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f59152a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.i();
        }
    }

    public final void m() {
        d.a.c.e.m.e.a().postDelayed(this.r, s);
        this.f59159h = true;
        s0 s0Var = this.f59160i;
        if (s0Var != null) {
            s0Var.m();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public PullRefreshFrameLayout n() {
        return this.f59152a;
    }

    public s0 o() {
        return this.f59160i;
    }

    public int p() {
        return this.m;
    }

    public int q() {
        return this.n;
    }

    public boolean r() {
        return this.f59158g;
    }

    public void s() {
        View headBgContainer;
        FrsHeaderViewContainer frsHeaderViewContainer = this.f59153b;
        if (frsHeaderViewContainer == null || (headBgContainer = frsHeaderViewContainer.getHeadBgContainer()) == null) {
            return;
        }
        if (this.j == null) {
            this.j = new o(headBgContainer);
        }
        if (this.j.a() > 0) {
            o oVar = this.j;
            oVar.f(oVar.a());
        }
        headBgContainer.post(new f(headBgContainer));
    }

    public void t() {
        FrsHeaderViewContainer frsHeaderViewContainer = this.f59153b;
        if (frsHeaderViewContainer == null) {
            return;
        }
        View headerEmptyView = frsHeaderViewContainer.getHeaderEmptyView();
        this.k = headerEmptyView;
        if (headerEmptyView != null) {
            this.m = 0;
            this.l = (RelativeLayout.LayoutParams) headerEmptyView.getLayoutParams();
            if (this.k.getHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams = this.l;
                layoutParams.height = this.m;
                this.k.setLayoutParams(layoutParams);
            }
        }
    }

    public void u() {
        if (this.f59159h) {
            v();
        }
        ValueAnimator valueAnimator = this.f59157f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f59157f.removeAllListeners();
            this.f59157f.removeAllUpdateListeners();
            this.f59157f = null;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.r);
    }

    public void v() {
        this.f59159h = false;
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f59152a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.p();
        }
    }

    public void w(int i2) {
        this.o = i2;
    }

    public void x(s0 s0Var) {
        this.f59160i = s0Var;
    }

    public void y(boolean z) {
        this.f59152a.setInterceptScrollDown(z);
    }

    public void z(int i2, boolean z) {
        if (i2 != this.o) {
            return;
        }
        this.f59158g = z;
        if (z) {
            B();
            return;
        }
        this.f59155d.getAdapter().notifyDataSetChanged();
        C();
    }
}
