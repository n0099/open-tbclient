package d.a.o0.r0.o2;

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
import d.a.o0.r0.o;
import d.a.o0.r0.s0;
/* loaded from: classes4.dex */
public class k {
    public static int s = 5000;

    /* renamed from: a  reason: collision with root package name */
    public PullRefreshFrameLayout f63109a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f63110b;

    /* renamed from: c  reason: collision with root package name */
    public AppBarLayout f63111c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f63112d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f63113e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f63114f;

    /* renamed from: i  reason: collision with root package name */
    public s0 f63117i;
    public o j;
    public View k;
    public int n;
    public int o;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63115g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63116h = false;
    public RelativeLayout.LayoutParams l = null;
    public int m = 0;
    public PullRefreshFrameLayout.i p = new a();
    public PullRefreshFrameLayout.h q = new b();
    public Runnable r = new c();

    /* loaded from: classes4.dex */
    public class a implements PullRefreshFrameLayout.i {

        /* renamed from: d.a.o0.r0.o2.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1591a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f63119e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f63120f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f63121g;

            public C1591a(int i2, int i3, int i4) {
                this.f63119e = i2;
                this.f63120f = i3;
                this.f63121g = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                k.this.l.height = (int) (this.f63119e - (this.f63120f * animatedFraction));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j != null) {
                    k.this.j.f((int) (this.f63121g - (animatedFraction * this.f63120f)));
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
            public final /* synthetic */ int f63124e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f63125f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f63126g;

            public c(int i2, int i3, int i4) {
                this.f63124e = i2;
                this.f63125f = i3;
                this.f63126g = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                k.this.l.height = (int) (this.f63124e - (this.f63125f * floatValue));
                k.this.k.setLayoutParams(k.this.l);
                if (k.this.j == null || this.f63126g <= 0) {
                    return;
                }
                k.this.j.f((int) (this.f63126g - (floatValue * this.f63125f)));
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
        public void l() {
            if (k.this.l == null) {
                return;
            }
            int i2 = k.this.l.height;
            int i3 = k.this.l.height - k.this.m;
            int a2 = k.this.j != null ? k.this.j.a() : 0;
            if (i3 > 0) {
                k.this.f63114f = ValueAnimator.ofFloat(0.0f, 1.0f);
                k.this.f63114f.setDuration(300L);
                k.this.f63114f.addUpdateListener(new c(i2, i3, a2));
                k.this.f63114f.start();
                k.this.f63114f.addListener(new d());
                if (k.this.f63117i != null) {
                    k.this.f63117i.l();
                }
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void m(double d2) {
            if (k.this.k == null || k.this.l == null) {
                return;
            }
            k.this.l.height = (int) (k.this.m + (PullRefreshFrameLayout.E * d2));
            k.this.k.setLayoutParams(k.this.l);
            if (k.this.j != null) {
                k.this.j.d(d2);
            }
            k.this.f63109a.r();
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void n(int i2, double d2) {
            if (k.this.k == null || k.this.l == null || k.this.j == null) {
                return;
            }
            k.this.f63114f = ValueAnimator.ofFloat(0.0f, 1.0f);
            k.this.f63114f.setDuration(150L);
            k.this.f63114f.addUpdateListener(new C1591a(k.this.l.height, i2, k.this.j.b()));
            k.this.f63114f.addListener(new b());
            k.this.f63114f.start();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullRefreshFrameLayout.h {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.h
        public void n() {
            k.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f63116h) {
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
            if (k.this.f63116h || k.this.f63109a == null || k.this.f63109a.o()) {
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
        public final /* synthetic */ View f63133e;

        public f(View view) {
            this.f63133e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.j.c() < 0) {
                k.this.j.g(this.f63133e.getMeasuredHeight());
            }
            if (k.this.j.a() < 0) {
                k.this.j.e(this.f63133e.getMeasuredHeight());
            }
        }
    }

    public k(@NonNull FrsFragment frsFragment) {
        this.f63109a = null;
        View A2 = frsFragment.A2();
        PullRefreshFrameLayout pullRefreshFrameLayout = (PullRefreshFrameLayout) A2.findViewById(R.id.frs_content_layout);
        this.f63109a = pullRefreshFrameLayout;
        pullRefreshFrameLayout.setFromFrs();
        this.f63109a.setOnTouchCallback(this.p);
        this.f63109a.setOnPullRefreshListener(this.q);
        this.f63109a.h();
        this.f63110b = (FrsHeaderViewContainer) A2.findViewById(R.id.header_view_container);
        this.f63111c = (AppBarLayout) A2.findViewById(R.id.frs_app_bar_layout);
        this.f63112d = (BdTypeRecyclerView) A2.findViewById(R.id.frs_lv_thread);
        t();
    }

    public void A(boolean z) {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f63109a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.setEnable(z);
        }
    }

    public void B() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f63109a;
        if (pullRefreshFrameLayout != null || pullRefreshFrameLayout.n()) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f63112d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setSelection(0);
            }
            AppBarLayout appBarLayout = this.f63111c;
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true);
            }
            if (this.f63116h) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f63113e = ofFloat;
            ofFloat.setDuration(300L);
            this.f63113e.addUpdateListener(new d());
            this.f63113e.addListener(new e());
            this.f63113e.start();
            this.f63109a.setRefreshing(true);
            m();
        }
    }

    public void C() {
        if (this.f63116h) {
            v();
            d.a.c.e.m.e.a().removeCallbacks(this.r);
        }
    }

    public void l() {
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f63109a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.i();
        }
    }

    public final void m() {
        d.a.c.e.m.e.a().postDelayed(this.r, s);
        this.f63116h = true;
        s0 s0Var = this.f63117i;
        if (s0Var != null) {
            s0Var.n();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        }
    }

    public PullRefreshFrameLayout n() {
        return this.f63109a;
    }

    public s0 o() {
        return this.f63117i;
    }

    public int p() {
        return this.m;
    }

    public int q() {
        return this.n;
    }

    public boolean r() {
        return this.f63115g;
    }

    public void s() {
        View headBgContainer;
        FrsHeaderViewContainer frsHeaderViewContainer = this.f63110b;
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
        FrsHeaderViewContainer frsHeaderViewContainer = this.f63110b;
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
        if (this.f63116h) {
            v();
        }
        ValueAnimator valueAnimator = this.f63114f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f63114f.removeAllListeners();
            this.f63114f.removeAllUpdateListeners();
            this.f63114f = null;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.r);
    }

    public void v() {
        this.f63116h = false;
        PullRefreshFrameLayout pullRefreshFrameLayout = this.f63109a;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.p();
        }
    }

    public void w(int i2) {
        this.o = i2;
    }

    public void x(s0 s0Var) {
        this.f63117i = s0Var;
    }

    public void y(boolean z) {
        this.f63109a.setInterceptScrollDown(z);
    }

    public void z(int i2, boolean z) {
        if (i2 != this.o) {
            return;
        }
        this.f63115g = z;
        if (z) {
            B();
            return;
        }
        this.f63112d.getAdapter().notifyDataSetChanged();
        C();
    }
}
