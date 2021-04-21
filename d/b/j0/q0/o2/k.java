package d.b.j0.q0.o2;

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
import d.b.j0.q0.o;
import d.b.j0.q0.s0;
/* loaded from: classes4.dex */
public class k {
    public static int s = 5000;

    /* renamed from: a  reason: collision with root package name */
    public PullRefreshFrameLayout f60319a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f60320b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f60321c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f60322d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f60323e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f60324f;
    public s0 i;
    public o j;
    public View k;
    public int n;
    public int o;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60325g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60326h = false;
    public RelativeLayout.LayoutParams l = null;
    public int m = 0;
    public PullRefreshFrameLayout.i p = new a();
    public PullRefreshFrameLayout.h q = new b();
    public Runnable r = new c();

    /* loaded from: classes4.dex */
    public class a implements PullRefreshFrameLayout.i {

        /* renamed from: d.b.j0.q0.o2.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1505a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f60328e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f60329f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f60330g;

            public C1505a(int i, int i2, int i3) {
                this.f60328e = i;
                this.f60329f = i2;
                this.f60330g = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                k.this.l.height = (int) (this.f60328e - (this.f60329f * animatedFraction));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j != null) {
                    k.this.j.f((int) (this.f60330g - (animatedFraction * this.f60329f)));
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
            public final /* synthetic */ int f60333e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f60334f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f60335g;

            public c(int i, int i2, int i3) {
                this.f60333e = i;
                this.f60334f = i2;
                this.f60335g = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                k.this.l.height = (int) (this.f60333e - (this.f60334f * floatValue));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j == null || this.f60335g <= 0) {
                    return;
                }
                k.this.j.f((int) (this.f60335g - (floatValue * this.f60334f)));
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
        public void o() {
            if (k.this.l == null) {
                return;
            }
            int i = k.this.l.height;
            int i2 = k.this.l.height - k.this.m;
            int a2 = k.this.j != null ? k.this.j.a() : 0;
            if (i2 > 0) {
                k.this.f60324f = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.f60324f.setDuration(300L);
                k.this.f60324f.addUpdateListener(new c(i, i2, a2));
                k.this.f60324f.start();
                k.this.f60324f.addListener(new d());
                if (k.this.i != null) {
                    k.this.i.o();
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void p(double d2) {
            if (k.this.k == null || k.this.l == null) {
                return;
            }
            k.this.l.height = (int) (k.this.m + (PullRefreshFrameLayout.E * d2));
            k.this.k.setLayoutParams(k.this.l);
            if (k.this.j != null) {
                k.this.j.d(d2);
            }
            k.this.f60319a.r();
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void q(int i, double d2) {
            if (k.this.k == null || k.this.l == null || k.this.j == null) {
                return;
            }
            k.this.f60324f = ValueAnimator.ofFloat(0.0f, 1.0f);
            k.this.f60324f.setDuration(150L);
            k.this.f60324f.addUpdateListener(new C1505a(k.this.l.height, i, k.this.j.b()));
            k.this.f60324f.addListener(new b());
            k.this.f60324f.start();
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
            if (k.this.f60326h) {
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
            if (k.this.f60326h || k.this.f60319a == null || k.this.f60319a.o()) {
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
        public final /* synthetic */ View f60342e;

        public f(View view) {
            this.f60342e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.j.c() < 0) {
                k.this.j.g(this.f60342e.getMeasuredHeight());
            }
            if (k.this.j.a() < 0) {
                k.this.j.e(this.f60342e.getMeasuredHeight());
            }
        }
    }

    public k(@NonNull FrsFragment frsFragment) {
        this.f60319a = null;
        View y2 = frsFragment.y2();
        PullRefreshFrameLayout pullRefreshFrameLayout = (PullRefreshFrameLayout) y2.findViewById(R.id.frs_content_layout);
        this.f60319a = pullRefreshFrameLayout;
        pullRefreshFrameLayout.setFromFrs();
        this.f60319a.setOnTouchCallback(this.p);
        this.f60319a.setOnPullRefreshListener(this.q);
        this.f60319a.h();
        this.f60320b = (FrsHeaderViewContainer) y2.findViewById(R.id.header_view_container);
        this.f60321c = (AppBarLayout) y2.findViewById(R.id.frs_app_bar_layout);
        this.f60322d = (BdTypeRecyclerView) y2.findViewById(R.id.frs_lv_thread);
        t();
    }

    public void A(boolean z) {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f60319a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.setEnable(z);
        }
    }

    public void B() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f60319a;
        if (pullRefreshFrameLayout != null || pullRefreshFrameLayout.n()) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f60322d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setSelection(0);
            }
            AppBarLayout appBarLayout = this.f60321c;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true);
            }
            if (this.f60326h) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f60323e = ofFloat;
            ofFloat.setDuration(300L);
            this.f60323e.addUpdateListener(new d());
            this.f60323e.addListener(new e());
            this.f60323e.start();
            this.f60319a.setRefreshing(true);
            m();
        }
    }

    public void C() {
        if (this.f60326h) {
            v();
            d.b.c.e.m.e.a().removeCallbacks(this.r);
        }
    }

    public void l() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f60319a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.i();
        }
    }

    public final void m() {
        d.b.c.e.m.e.a().postDelayed(this.r, s);
        this.f60326h = true;
        s0 s0Var = this.i;
        if (s0Var != null) {
            s0Var.m();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public PullRefreshFrameLayout n() {
        return this.f60319a;
    }

    public s0 o() {
        return this.i;
    }

    public int p() {
        return this.m;
    }

    public int q() {
        return this.n;
    }

    public boolean r() {
        return this.f60325g;
    }

    public void s() {
        View headBgContainer;
        FrsHeaderViewContainer frsHeaderViewContainer = this.f60320b;
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
        FrsHeaderViewContainer frsHeaderViewContainer = this.f60320b;
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
        if (this.f60326h) {
            v();
        }
        ValueAnimator valueAnimator = this.f60324f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f60324f.removeAllListeners();
            this.f60324f.removeAllUpdateListeners();
            this.f60324f = null;
        }
        d.b.c.e.m.e.a().removeCallbacks(this.r);
    }

    public void v() {
        this.f60326h = false;
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f60319a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.p();
        }
    }

    public void w(int i) {
        this.o = i;
    }

    public void x(s0 s0Var) {
        this.i = s0Var;
    }

    public void y(boolean z) {
        this.f60319a.setInterceptScrollDown(z);
    }

    public void z(int i, boolean z) {
        if (i != this.o) {
            return;
        }
        this.f60325g = z;
        if (z) {
            B();
            return;
        }
        this.f60322d.getAdapter().notifyDataSetChanged();
        C();
    }
}
