package d.a.j0.q0.o2;

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
import d.a.j0.q0.o;
import d.a.j0.q0.s0;
/* loaded from: classes4.dex */
public class k {
    public static int s = 5000;

    /* renamed from: a  reason: collision with root package name */
    public PullRefreshFrameLayout f58410a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f58411b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f58412c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f58413d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f58414e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f58415f;

    /* renamed from: i  reason: collision with root package name */
    public s0 f58418i;
    public o j;
    public View k;
    public int n;
    public int o;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58416g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58417h = false;
    public RelativeLayout.LayoutParams l = null;
    public int m = 0;
    public PullRefreshFrameLayout.i p = new a();
    public PullRefreshFrameLayout.h q = new b();
    public Runnable r = new c();

    /* loaded from: classes4.dex */
    public class a implements PullRefreshFrameLayout.i {

        /* renamed from: d.a.j0.q0.o2.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1444a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f58420e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f58421f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f58422g;

            public C1444a(int i2, int i3, int i4) {
                this.f58420e = i2;
                this.f58421f = i3;
                this.f58422g = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                k.this.l.height = (int) (this.f58420e - (this.f58421f * animatedFraction));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j != null) {
                    k.this.j.f((int) (this.f58422g - (animatedFraction * this.f58421f)));
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
            public final /* synthetic */ int f58425e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f58426f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f58427g;

            public c(int i2, int i3, int i4) {
                this.f58425e = i2;
                this.f58426f = i3;
                this.f58427g = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                k.this.l.height = (int) (this.f58425e - (this.f58426f * floatValue));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j == null || this.f58427g <= 0) {
                    return;
                }
                k.this.j.f((int) (this.f58427g - (floatValue * this.f58426f)));
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
                k.this.f58415f = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.f58415f.setDuration(300L);
                k.this.f58415f.addUpdateListener(new c(i2, i3, a2));
                k.this.f58415f.start();
                k.this.f58415f.addListener(new d());
                if (k.this.f58418i != null) {
                    k.this.f58418i.k();
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
            k.this.f58410a.r();
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void m(int i2, double d2) {
            if (k.this.k == null || k.this.l == null || k.this.j == null) {
                return;
            }
            k.this.f58415f = ValueAnimator.ofFloat(0.0f, 1.0f);
            k.this.f58415f.setDuration(150L);
            k.this.f58415f.addUpdateListener(new C1444a(k.this.l.height, i2, k.this.j.b()));
            k.this.f58415f.addListener(new b());
            k.this.f58415f.start();
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
            if (k.this.f58417h) {
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
            if (k.this.f58417h || k.this.f58410a == null || k.this.f58410a.o()) {
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
        public final /* synthetic */ View f58434e;

        public f(View view) {
            this.f58434e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.j.c() < 0) {
                k.this.j.g(this.f58434e.getMeasuredHeight());
            }
            if (k.this.j.a() < 0) {
                k.this.j.e(this.f58434e.getMeasuredHeight());
            }
        }
    }

    public k(@NonNull FrsFragment frsFragment) {
        this.f58410a = null;
        View y2 = frsFragment.y2();
        PullRefreshFrameLayout pullRefreshFrameLayout = (PullRefreshFrameLayout) y2.findViewById(R.id.frs_content_layout);
        this.f58410a = pullRefreshFrameLayout;
        pullRefreshFrameLayout.setFromFrs();
        this.f58410a.setOnTouchCallback(this.p);
        this.f58410a.setOnPullRefreshListener(this.q);
        this.f58410a.h();
        this.f58411b = (FrsHeaderViewContainer) y2.findViewById(R.id.header_view_container);
        this.f58412c = (AppBarLayout) y2.findViewById(R.id.frs_app_bar_layout);
        this.f58413d = (BdTypeRecyclerView) y2.findViewById(R.id.frs_lv_thread);
        t();
    }

    public void A(boolean z) {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f58410a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.setEnable(z);
        }
    }

    public void B() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f58410a;
        if (pullRefreshFrameLayout != null || pullRefreshFrameLayout.n()) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f58413d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setSelection(0);
            }
            AppBarLayout appBarLayout = this.f58412c;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true);
            }
            if (this.f58417h) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f58414e = ofFloat;
            ofFloat.setDuration(300L);
            this.f58414e.addUpdateListener(new d());
            this.f58414e.addListener(new e());
            this.f58414e.start();
            this.f58410a.setRefreshing(true);
            m();
        }
    }

    public void C() {
        if (this.f58417h) {
            v();
            d.a.c.e.m.e.a().removeCallbacks(this.r);
        }
    }

    public void l() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f58410a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.i();
        }
    }

    public final void m() {
        d.a.c.e.m.e.a().postDelayed(this.r, s);
        this.f58417h = true;
        s0 s0Var = this.f58418i;
        if (s0Var != null) {
            s0Var.m();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public PullRefreshFrameLayout n() {
        return this.f58410a;
    }

    public s0 o() {
        return this.f58418i;
    }

    public int p() {
        return this.m;
    }

    public int q() {
        return this.n;
    }

    public boolean r() {
        return this.f58416g;
    }

    public void s() {
        View headBgContainer;
        FrsHeaderViewContainer frsHeaderViewContainer = this.f58411b;
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
        FrsHeaderViewContainer frsHeaderViewContainer = this.f58411b;
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
        if (this.f58417h) {
            v();
        }
        ValueAnimator valueAnimator = this.f58415f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f58415f.removeAllListeners();
            this.f58415f.removeAllUpdateListeners();
            this.f58415f = null;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.r);
    }

    public void v() {
        this.f58417h = false;
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f58410a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.p();
        }
    }

    public void w(int i2) {
        this.o = i2;
    }

    public void x(s0 s0Var) {
        this.f58418i = s0Var;
    }

    public void y(boolean z) {
        this.f58410a.setInterceptScrollDown(z);
    }

    public void z(int i2, boolean z) {
        if (i2 != this.o) {
            return;
        }
        this.f58416g = z;
        if (z) {
            B();
            return;
        }
        this.f58413d.getAdapter().notifyDataSetChanged();
        C();
    }
}
