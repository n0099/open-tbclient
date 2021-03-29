package d.b.i0.p0.n2;

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
import d.b.i0.p0.o;
import d.b.i0.p0.s0;
/* loaded from: classes4.dex */
public class k {
    public static int s = 5000;

    /* renamed from: a  reason: collision with root package name */
    public PullRefreshFrameLayout f58202a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f58203b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f58204c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f58205d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f58206e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f58207f;
    public s0 i;
    public o j;
    public View k;
    public int n;
    public int o;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58208g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58209h = false;
    public RelativeLayout.LayoutParams l = null;
    public int m = 0;
    public PullRefreshFrameLayout.i p = new a();
    public PullRefreshFrameLayout.h q = new b();
    public Runnable r = new c();

    /* loaded from: classes4.dex */
    public class a implements PullRefreshFrameLayout.i {

        /* renamed from: d.b.i0.p0.n2.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1416a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f58211e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f58212f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f58213g;

            public C1416a(int i, int i2, int i3) {
                this.f58211e = i;
                this.f58212f = i2;
                this.f58213g = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                k.this.l.height = (int) (this.f58211e - (this.f58212f * animatedFraction));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j != null) {
                    k.this.j.f((int) (this.f58213g - (animatedFraction * this.f58212f)));
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
            public final /* synthetic */ int f58216e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f58217f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f58218g;

            public c(int i, int i2, int i3) {
                this.f58216e = i;
                this.f58217f = i2;
                this.f58218g = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                k.this.l.height = (int) (this.f58216e - (this.f58217f * floatValue));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j == null || this.f58218g <= 0) {
                    return;
                }
                k.this.j.f((int) (this.f58218g - (floatValue * this.f58217f)));
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
                k.this.f58207f = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.f58207f.setDuration(300L);
                k.this.f58207f.addUpdateListener(new c(i, i2, a2));
                k.this.f58207f.start();
                k.this.f58207f.addListener(new d());
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
            k.this.f58202a.r();
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void q(int i, double d2) {
            if (k.this.k == null || k.this.l == null || k.this.j == null) {
                return;
            }
            k.this.f58207f = ValueAnimator.ofFloat(0.0f, 1.0f);
            k.this.f58207f.setDuration(150L);
            k.this.f58207f.addUpdateListener(new C1416a(k.this.l.height, i, k.this.j.b()));
            k.this.f58207f.addListener(new b());
            k.this.f58207f.start();
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
            if (k.this.f58209h) {
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
            if (k.this.f58209h || k.this.f58202a == null || k.this.f58202a.o()) {
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
        public final /* synthetic */ View f58225e;

        public f(View view) {
            this.f58225e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.j.c() < 0) {
                k.this.j.g(this.f58225e.getMeasuredHeight());
            }
            if (k.this.j.a() < 0) {
                k.this.j.e(this.f58225e.getMeasuredHeight());
            }
        }
    }

    public k(@NonNull FrsFragment frsFragment) {
        this.f58202a = null;
        View y2 = frsFragment.y2();
        PullRefreshFrameLayout pullRefreshFrameLayout = (PullRefreshFrameLayout) y2.findViewById(R.id.frs_content_layout);
        this.f58202a = pullRefreshFrameLayout;
        pullRefreshFrameLayout.setFromFrs();
        this.f58202a.setOnTouchCallback(this.p);
        this.f58202a.setOnPullRefreshListener(this.q);
        this.f58202a.h();
        this.f58203b = (FrsHeaderViewContainer) y2.findViewById(R.id.header_view_container);
        this.f58204c = (AppBarLayout) y2.findViewById(R.id.frs_app_bar_layout);
        this.f58205d = (BdTypeRecyclerView) y2.findViewById(R.id.frs_lv_thread);
        t();
    }

    public void A(boolean z) {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f58202a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.setEnable(z);
        }
    }

    public void B() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f58202a;
        if (pullRefreshFrameLayout != null || pullRefreshFrameLayout.n()) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f58205d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setSelection(0);
            }
            AppBarLayout appBarLayout = this.f58204c;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true);
            }
            if (this.f58209h) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f58206e = ofFloat;
            ofFloat.setDuration(300L);
            this.f58206e.addUpdateListener(new d());
            this.f58206e.addListener(new e());
            this.f58206e.start();
            this.f58202a.setRefreshing(true);
            m();
        }
    }

    public void C() {
        if (this.f58209h) {
            v();
            d.b.b.e.m.e.a().removeCallbacks(this.r);
        }
    }

    public void l() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f58202a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.i();
        }
    }

    public final void m() {
        d.b.b.e.m.e.a().postDelayed(this.r, s);
        this.f58209h = true;
        s0 s0Var = this.i;
        if (s0Var != null) {
            s0Var.m();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public PullRefreshFrameLayout n() {
        return this.f58202a;
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
        return this.f58208g;
    }

    public void s() {
        View headBgContainer;
        FrsHeaderViewContainer frsHeaderViewContainer = this.f58203b;
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
        FrsHeaderViewContainer frsHeaderViewContainer = this.f58203b;
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
        if (this.f58209h) {
            v();
        }
        ValueAnimator valueAnimator = this.f58207f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f58207f.removeAllListeners();
            this.f58207f.removeAllUpdateListeners();
            this.f58207f = null;
        }
        d.b.b.e.m.e.a().removeCallbacks(this.r);
    }

    public void v() {
        this.f58209h = false;
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f58202a;
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
        this.f58202a.setInterceptScrollDown(z);
    }

    public void z(int i, boolean z) {
        if (i != this.o) {
            return;
        }
        this.f58208g = z;
        if (z) {
            B();
            return;
        }
        this.f58205d.getAdapter().notifyDataSetChanged();
        C();
    }
}
