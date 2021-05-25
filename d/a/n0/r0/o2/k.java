package d.a.n0.r0.o2;

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
import d.a.n0.r0.o;
import d.a.n0.r0.s0;
/* loaded from: classes4.dex */
public class k {
    public static int s = 5000;

    /* renamed from: a  reason: collision with root package name */
    public PullRefreshFrameLayout f59293a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f59294b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f59295c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f59296d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f59297e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f59298f;

    /* renamed from: i  reason: collision with root package name */
    public s0 f59301i;
    public o j;
    public View k;
    public int n;
    public int o;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59299g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59300h = false;
    public RelativeLayout.LayoutParams l = null;
    public int m = 0;
    public PullRefreshFrameLayout.i p = new a();
    public PullRefreshFrameLayout.h q = new b();
    public Runnable r = new c();

    /* loaded from: classes4.dex */
    public class a implements PullRefreshFrameLayout.i {

        /* renamed from: d.a.n0.r0.o2.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1531a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59303e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f59304f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f59305g;

            public C1531a(int i2, int i3, int i4) {
                this.f59303e = i2;
                this.f59304f = i3;
                this.f59305g = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                k.this.l.height = (int) (this.f59303e - (this.f59304f * animatedFraction));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j != null) {
                    k.this.j.f((int) (this.f59305g - (animatedFraction * this.f59304f)));
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
            public final /* synthetic */ int f59308e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f59309f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f59310g;

            public c(int i2, int i3, int i4) {
                this.f59308e = i2;
                this.f59309f = i3;
                this.f59310g = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                k.this.l.height = (int) (this.f59308e - (this.f59309f * floatValue));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j == null || this.f59310g <= 0) {
                    return;
                }
                k.this.j.f((int) (this.f59310g - (floatValue * this.f59309f)));
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
                k.this.f59298f = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.f59298f.setDuration(300L);
                k.this.f59298f.addUpdateListener(new c(i2, i3, a2));
                k.this.f59298f.start();
                k.this.f59298f.addListener(new d());
                if (k.this.f59301i != null) {
                    k.this.f59301i.k();
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
            k.this.f59293a.r();
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void m(int i2, double d2) {
            if (k.this.k == null || k.this.l == null || k.this.j == null) {
                return;
            }
            k.this.f59298f = ValueAnimator.ofFloat(0.0f, 1.0f);
            k.this.f59298f.setDuration(150L);
            k.this.f59298f.addUpdateListener(new C1531a(k.this.l.height, i2, k.this.j.b()));
            k.this.f59298f.addListener(new b());
            k.this.f59298f.start();
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
            if (k.this.f59300h) {
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
            if (k.this.f59300h || k.this.f59293a == null || k.this.f59293a.o()) {
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
        public final /* synthetic */ View f59317e;

        public f(View view) {
            this.f59317e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.j.c() < 0) {
                k.this.j.g(this.f59317e.getMeasuredHeight());
            }
            if (k.this.j.a() < 0) {
                k.this.j.e(this.f59317e.getMeasuredHeight());
            }
        }
    }

    public k(@NonNull FrsFragment frsFragment) {
        this.f59293a = null;
        View x2 = frsFragment.x2();
        PullRefreshFrameLayout pullRefreshFrameLayout = (PullRefreshFrameLayout) x2.findViewById(R.id.frs_content_layout);
        this.f59293a = pullRefreshFrameLayout;
        pullRefreshFrameLayout.setFromFrs();
        this.f59293a.setOnTouchCallback(this.p);
        this.f59293a.setOnPullRefreshListener(this.q);
        this.f59293a.h();
        this.f59294b = (FrsHeaderViewContainer) x2.findViewById(R.id.header_view_container);
        this.f59295c = (AppBarLayout) x2.findViewById(R.id.frs_app_bar_layout);
        this.f59296d = (BdTypeRecyclerView) x2.findViewById(R.id.frs_lv_thread);
        t();
    }

    public void A(boolean z) {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f59293a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.setEnable(z);
        }
    }

    public void B() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f59293a;
        if (pullRefreshFrameLayout != null || pullRefreshFrameLayout.n()) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f59296d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setSelection(0);
            }
            AppBarLayout appBarLayout = this.f59295c;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true);
            }
            if (this.f59300h) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f59297e = ofFloat;
            ofFloat.setDuration(300L);
            this.f59297e.addUpdateListener(new d());
            this.f59297e.addListener(new e());
            this.f59297e.start();
            this.f59293a.setRefreshing(true);
            m();
        }
    }

    public void C() {
        if (this.f59300h) {
            v();
            d.a.c.e.m.e.a().removeCallbacks(this.r);
        }
    }

    public void l() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f59293a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.i();
        }
    }

    public final void m() {
        d.a.c.e.m.e.a().postDelayed(this.r, s);
        this.f59300h = true;
        s0 s0Var = this.f59301i;
        if (s0Var != null) {
            s0Var.m();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public PullRefreshFrameLayout n() {
        return this.f59293a;
    }

    public s0 o() {
        return this.f59301i;
    }

    public int p() {
        return this.m;
    }

    public int q() {
        return this.n;
    }

    public boolean r() {
        return this.f59299g;
    }

    public void s() {
        View headBgContainer;
        FrsHeaderViewContainer frsHeaderViewContainer = this.f59294b;
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
        FrsHeaderViewContainer frsHeaderViewContainer = this.f59294b;
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
        if (this.f59300h) {
            v();
        }
        ValueAnimator valueAnimator = this.f59298f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f59298f.removeAllListeners();
            this.f59298f.removeAllUpdateListeners();
            this.f59298f = null;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.r);
    }

    public void v() {
        this.f59300h = false;
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f59293a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.p();
        }
    }

    public void w(int i2) {
        this.o = i2;
    }

    public void x(s0 s0Var) {
        this.f59301i = s0Var;
    }

    public void y(boolean z) {
        this.f59293a.setInterceptScrollDown(z);
    }

    public void z(int i2, boolean z) {
        if (i2 != this.o) {
            return;
        }
        this.f59299g = z;
        if (z) {
            B();
            return;
        }
        this.f59296d.getAdapter().notifyDataSetChanged();
        C();
    }
}
