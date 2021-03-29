package d.b.i0.i0.m;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.GuidePopupWindow;
import d.b.b.e.g.d;
import d.b.b.j.e.c;
import d.b.h0.r.f0.f;
import d.b.h0.r.q.o1;
import d.b.h0.r.q.p1;
import d.b.h0.r.q.w;
import d.b.i0.i0.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements EnterForumAdView.c {
    public static boolean M = false;
    public View H;
    public float I;
    public ImageView J;
    public boolean L;

    /* renamed from: a  reason: collision with root package name */
    public Context f55754a;

    /* renamed from: b  reason: collision with root package name */
    public final EnterForumFragment f55755b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.r.f0.g f55756c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f55757d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.i0.c.a f55758e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.i0.d.f> f55759f;

    /* renamed from: g  reason: collision with root package name */
    public o1 f55760g;

    /* renamed from: h  reason: collision with root package name */
    public ViewEventCenter f55761h;
    public CommonTipView i;
    public View j;
    public d.b.h0.d0.h k;
    public View l;
    public EnterForumAdView m;
    public View n;
    public GuidePopupWindow o;
    public d.b.b.e.g.c p;
    public int q;
    public d.b.i0.i0.m.e r;
    public d.b.i0.i0.d.c s;
    public int u;
    public int v;
    public int w;
    public f.g x;
    public boolean t = true;
    public f.g y = new a();
    public AbsListView.OnScrollListener z = new m();
    public View.OnClickListener A = new n();
    public int B = 0;
    public int C = 0;
    public CustomMessageListener D = new o(2921474);
    public boolean E = false;
    public boolean F = false;
    public Runnable G = new r();
    public boolean K = false;

    /* loaded from: classes4.dex */
    public class a implements f.g {

        /* renamed from: d.b.i0.i0.m.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1295a implements Runnable {
            public RunnableC1295a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f55757d.setSelection(0);
            }
        }

        public a() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (b.this.K) {
                return;
            }
            d.b.i0.b3.c.g().j(b.this.f55755b.getUniqueId());
            if (b.this.x != null) {
                b.this.x.onListPullRefresh(z);
            }
            if (z) {
                b bVar = b.this;
                if (bVar.E || bVar.s == null || !b.this.s.f55477a) {
                    return;
                }
                if (b.this.s.f55479c > 0) {
                    b.this.f55757d.E(0, 0, 0);
                    b.this.i0();
                    return;
                }
                d.b.b.e.m.e.a().post(new RunnableC1295a());
            }
        }
    }

    /* renamed from: d.b.i0.i0.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1296b implements d.a {
        public C1296b(b bVar) {
        }

        @Override // d.b.b.e.g.d.a
        public void onDismiss() {
        }

        @Override // d.b.b.e.g.d.a
        public void onShown() {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.p != null) {
                b.this.p.d();
                b.this.p = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EnterForumAdView.c(b.this.f55755b.getPageContext().getUniqueId(), b.this.f55754a);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public float f55766e = 0.0f;

        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                b.this.I = motionEvent.getRawY();
            } else if (action == 1) {
                if (b.this.I <= (b.this.f55754a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.I) {
                    b.this.h0();
                    if (this.f55766e < 50.0f) {
                        b.this.H.performClick();
                    }
                } else {
                    b.this.c0();
                }
                b.this.I = 0.0f;
                this.f55766e = 0.0f;
            } else if (action != 2) {
                if (b.this.I <= (b.this.f55754a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.I) {
                    b.this.h0();
                } else {
                    b.this.c0();
                }
                b.this.I = 0.0f;
                this.f55766e = 0.0f;
            } else {
                if (motionEvent.getRawY() < b.this.I) {
                    b.this.l0(motionEvent.getRawY() - b.this.I);
                    if (b.this.J != null) {
                        b.this.J.setVisibility(8);
                    }
                }
                if (Math.abs(motionEvent.getRawY() - b.this.I) > this.f55766e) {
                    this.f55766e = Math.abs(motionEvent.getRawY() - b.this.I);
                }
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.c0();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55769e;

        public g(int i) {
            this.f55769e = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup viewGroup;
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (b.this.m != null) {
                ViewGroup.LayoutParams layoutParams = b.this.m.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    b.this.I();
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(0, intValue, 0, 0);
                    b.this.m.setLayoutParams(marginLayoutParams);
                    if (intValue / this.f55769e < 0.2d) {
                        if (b.this.m.getParent() != b.this.m.getRootView() && (viewGroup = (ViewGroup) b.this.m.getRootView()) != null) {
                            ((ViewGroup) b.this.m.getParent()).removeView(b.this.m);
                            if (b.this.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                viewGroup.addView(b.this.m, marginLayoutParams2);
                            }
                            viewGroup.bringChildToFront(b.this.H);
                            viewGroup.bringChildToFront(b.this.J);
                        }
                    } else if (b.this.m.getParent() == b.this.m.getRootView()) {
                        if (b.this.m.getParent() != null) {
                            ViewGroup viewGroup2 = (ViewGroup) b.this.m.getRootView();
                            ((ViewGroup) b.this.m.getParent()).removeView(b.this.m);
                        }
                        if (b.this.m.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                            b.this.f55755b.G0().addView(b.this.m, 0, marginLayoutParams3);
                        }
                    }
                }
            }
            b.this.K = false;
            b.this.p0(((intValue - this.f55769e) * 2) + 0);
            b.this.K = true;
            float abs = Math.abs(intValue / this.f55769e);
            b.this.f55757d.setAlpha(abs);
            View y = b.this.f55755b.I0().y();
            if (y != null) {
                y.setAlpha(abs);
            }
            View findViewById = b.this.f55755b.G0().getRootView().findViewById(R.id.tabcontainer_wrapper);
            if (findViewById != null) {
                findViewById.setAlpha(abs);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55771e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f55772f;

        public h(int i, View view) {
            this.f55771e = i;
            this.f55772f = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.m != null) {
                ViewGroup.LayoutParams layoutParams = b.this.m.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    b.this.I();
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.setMargins(0, 0, 0, 0);
                    b.this.m.setLayoutParams(layoutParams2);
                }
            }
            b.this.f55756c.A();
            b.this.f55757d.z();
            b.this.f55756c.D(0, -b.this.f55756c.q(), 0, 0);
            b.this.K = false;
            b.this.p0(0 - (this.f55771e * 2));
            b.this.K = true;
            b.this.f55757d.setVisibility(8);
            b.this.H.setEnabled(true);
            FrameLayout frameLayout = (FrameLayout) this.f55772f;
            if (b.this.H.getParent() == null) {
                frameLayout.addView(b.this.H, new FrameLayout.LayoutParams(-1, -1));
            }
            if (b.this.J.getParent() == null) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams3.bottomMargin = b.this.f55754a.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                layoutParams3.gravity = 81;
                frameLayout.addView(b.this.J, layoutParams3);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.l0(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Animator.AnimatorListener {
        public j() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.l0(0.0f);
            b.this.f55756c.A();
            b.this.f55757d.z();
            b.this.f55756c.D(0, -b.this.f55756c.q(), 0, 0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public k() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.l0(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Animator.AnimatorListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: d.b.i0.i0.m.b$l$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC1297a implements Runnable {
                public RunnableC1297a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b.this.K = false;
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) b.this.H.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(b.this.H);
                    viewGroup.removeView(b.this.J);
                }
                b.this.J.setVisibility(0);
                b.this.K = false;
                b.this.k0();
                b.this.C = 0;
                b.this.p0(0);
                b.this.K = true;
                b.this.f55756c.A();
                b.this.f55757d.z();
                b.this.f55756c.D(0, -b.this.f55756c.q(), 0, 0);
                d.b.b.e.m.e.a().postDelayed(new RunnableC1297a(), 0L);
                b.this.f55757d.setVisibility(0);
            }
        }

        public l() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.b.b.e.m.e.a().post(new a());
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class m implements AbsListView.OnScrollListener {

        /* renamed from: e  reason: collision with root package name */
        public int f55780e = -1;

        public m() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.f55755b.isPrimary() && this.f55780e != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.f55757d.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof w)) {
                        w wVar = (w) itemAtPosition;
                        if (wVar.z() == 1 && b.this.f55757d.getItemAtPosition(i4) == ListUtils.getItem(b.this.f55759f, 0)) {
                            b.this.v0(wVar, b.this.f55757d.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.r.onScroll(absListView, i, i2, i3);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.r.onScrollStateChanged(absListView, i);
            if (this.f55780e != i) {
                this.f55780e = i;
                if (i == 1) {
                    if (b.this.s == null || !b.this.s.f55477a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
                    }
                    b.this.N();
                    return;
                }
                b.this.E();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.s == null || !b.this.s.f55477a) {
                return;
            }
            b bVar = b.this;
            if (bVar.E) {
                EnterForumAdView unused = bVar.m;
                EnterForumAdView.c(b.this.f55755b.getUniqueId(), b.this.f55755b.getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {
        public o(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.u0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements e.c {
        public p() {
        }

        @Override // d.b.i0.i0.m.e.c
        public void a(AbsListView absListView, int i, int i2) {
            if (b.this.K) {
                return;
            }
            b.this.B = -i;
            b bVar = b.this;
            if (bVar.E) {
                bVar.d0();
            } else if (bVar.s == null || !b.this.s.f55477a) {
            } else {
                b.this.k0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements c.a {
        public q() {
        }

        @Override // d.b.b.j.e.c.a
        public void a(d.b.b.j.e.c cVar, int i, int i2, int i3, int i4) {
            b.this.C = i3;
            b bVar = b.this;
            if (bVar.E || bVar.s == null || !b.this.s.f55477a || b.this.K) {
                return;
            }
            b.this.k0();
            if (i3 > b.this.w) {
                b.this.C = 0;
                b bVar2 = b.this;
                bVar2.t0(bVar2.f55755b.I0().w());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.d0();
        }
    }

    /* loaded from: classes4.dex */
    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.O();
            b.this.x0();
        }
    }

    /* loaded from: classes4.dex */
    public class t implements d.b.b.e.g.b {
        public t() {
        }

        @Override // d.b.b.e.g.b
        public int a() {
            return 4;
        }

        @Override // d.b.b.e.g.b
        public View b(LayoutInflater layoutInflater) {
            View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.q);
            b.this.f55755b.getPageContext().getLayoutMode().j(inflate);
            return inflate;
        }

        @Override // d.b.b.e.g.b
        public int c() {
            return 16;
        }

        @Override // d.b.b.e.g.b
        public int getXOffset() {
            return 0;
        }

        @Override // d.b.b.e.g.b
        public int getYOffset() {
            return 0;
        }
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.f55755b = enterForumFragment;
        this.u = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + d.b.b.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.v = d.b.b.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.w = d.b.b.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.f55761h = viewEventCenter;
        R(view);
        d.b.i0.i0.c.a aVar = new d.b.i0.i0.c.a(this.f55755b.getPageContext(), this.f55761h, recentlyVisitedForumModel, enterForumModel, this);
        this.f55758e = aVar;
        this.f55757d.setAdapter((ListAdapter) aVar);
        W(TbadkCoreApplication.getInst().getSkinType());
        f0();
        this.o = new GuidePopupWindow(this.f55755b.getFragmentActivity());
    }

    public final void E() {
        if (U()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
            return;
        }
        d.b.i0.i0.d.c cVar = this.s;
        if (cVar != null && cVar.f55477a) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
        }
    }

    public boolean F() {
        d.b.i0.i0.c.a aVar = this.f55758e;
        if (aVar == null) {
            return false;
        }
        return aVar.f();
    }

    public void G() {
        if (this.E) {
            this.F = true;
            return;
        }
        this.F = false;
        this.f55757d.A(0L);
    }

    public final int H() {
        return this.E ? -this.f55754a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I();
    }

    public final int I() {
        return this.f55754a.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    public final int J() {
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public BdListView K() {
        return this.f55757d;
    }

    public final int L() {
        return (this.u - this.v) - (EnterForumDelegateStatic.f15393c.x() != null ? this.f55754a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    public d.b.h0.d0.h M() {
        return this.k;
    }

    public void N() {
        d.b.b.e.g.c cVar = this.p;
        if (cVar != null) {
            cVar.d();
            this.p = null;
        }
    }

    public void O() {
        d.b.h0.d0.h hVar = this.k;
        if (hVar != null) {
            hVar.dettachView(this.l);
            this.k = null;
            this.l = null;
        }
        this.f55757d.setVisibility(0);
        if (this.f55755b.I0() != null) {
            this.f55755b.I0().M();
            this.f55755b.I0().Q();
        }
    }

    public final void P() {
        d.b.b.e.p.l.g(this.f55754a, R.dimen.tbds240);
        View view = new View(this.f55754a);
        this.H = view;
        view.setOnClickListener(new d());
        this.H.setOnTouchListener(new e());
        ImageView imageView = new ImageView(this.f55754a);
        this.J = imageView;
        imageView.setOnClickListener(new f());
    }

    public void Q(View view) {
        EnterForumAdView enterForumAdView = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        this.m = enterForumAdView;
        if (enterForumAdView != null) {
            k0();
            this.m.setTag(this.f55755b.getUniqueId());
            this.m.setAdData();
            this.m.setEventCenter(this.f55761h);
            this.m.setOnBackPressedListener(this);
        }
    }

    public final void R(View view) {
        this.f55754a = view.getContext();
        d.b.i0.i0.m.e eVar = new d.b.i0.i0.m.e();
        this.r = eVar;
        eVar.a(new p());
        this.f55757d = (BdListView) view.findViewById(R.id.listview);
        p0(0);
        this.f55757d.setBackgroundColor(0);
        this.f55757d.setVerticalScrollBarEnabled(false);
        this.f55757d.setOnScrollListener(this.z);
        this.f55757d.setFastScrollEnabled(false);
        this.f55757d.setMaxHeight(this.f55754a.getResources().getDisplayMetrics().heightPixels);
        BdListView.D(1.0f);
        if (this.f55755b.I0() != null) {
            this.f55755b.I0().T(this);
        }
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f55755b.getPageContext());
        this.f55756c = gVar;
        gVar.C(new q());
        this.f55756c.Y(true);
        this.f55756c.b(this.y);
        d.b.h0.r.f0.g gVar2 = this.f55756c;
        if (gVar2 != null) {
            gVar2.Z(this.f55755b.getUniqueId());
        }
        this.f55757d.setPullRefresh(this.f55756c);
        FrameLayout frameLayout = new FrameLayout(this.f55755b.getPageContext().getPageActivity());
        View view2 = new View(this.f55755b.getPageContext().getPageActivity());
        this.n = view2;
        frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, this.v));
        this.f55757d.getAdapter2().g(frameLayout, 0);
        this.j = new View(this.f55755b.getActivity());
        this.j.setLayoutParams(new AbsListView.LayoutParams(-1, d.b.b.e.p.l.g(this.f55755b.getActivity(), R.dimen.ds50)));
        this.j.setBackgroundResource(R.color.CAM_X0201);
        this.f55756c.R(this.A);
        this.f55756c.getView().setOnClickListener(this.A);
        this.n.setOnClickListener(this.A);
        P();
    }

    public boolean S() {
        return ListUtils.isEmpty(this.f55759f);
    }

    public final boolean T() {
        return TbadkCoreApplication.isLogin() && !d.b.h0.r.d0.b.i().g("has_guide_popup_window_been_shown", false);
    }

    public boolean U() {
        BdListView bdListView = this.f55757d;
        return bdListView == null || bdListView.getChildCount() == 0 || this.f55757d.getChildAt(0).getTop() == 0;
    }

    public void V(boolean z) {
        this.f55758e.notifyDataSetChanged();
        View view = this.j;
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        if (z) {
            this.j.getLayoutParams().height = d.b.b.e.p.l.g(this.f55754a, R.dimen.ds50);
            return;
        }
        this.j.getLayoutParams().height = d.b.b.e.p.l.g(this.f55754a, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    public void W(int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.f55757d.removeFooterView(this.j);
            this.f55757d.addFooterView(this.j);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.f55757d.removeFooterView(this.j);
        }
        d.b.h0.r.f0.g gVar = this.f55756c;
        if (gVar != null) {
            gVar.I(i2);
        }
        d.b.h0.d0.h hVar = this.k;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        GuidePopupWindow guidePopupWindow = this.o;
        if (guidePopupWindow != null) {
            guidePopupWindow.j();
        }
        SkinManager.setBackgroundResource(this.j, R.color.CAM_X0201);
    }

    public void X() {
        CommonTipView commonTipView = this.i;
        if (commonTipView != null) {
            commonTipView.i();
        }
        d.b.i0.i0.c.a aVar = this.f55758e;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void Y() {
        N();
    }

    public void Z() {
        if (this.f55755b.isAdded() && this.f55755b.isPrimary()) {
            M = false;
            d.b.i0.i0.c.a aVar = this.f55758e;
            if (aVar != null) {
                aVar.h();
                BdListView bdListView = this.f55757d;
                if (bdListView != null) {
                    Object itemAtPosition = this.f55757d.getItemAtPosition(bdListView.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof w) && ((w) itemAtPosition).z() == 5) {
                        this.f55758e.m();
                    }
                }
            }
            if (this.K) {
                this.m.requestFocus();
                this.m.requestFocusFromTouch();
                return;
            }
            return;
        }
        N();
    }

    public void a0(int i2) {
        this.f55758e.i(i2);
    }

    public void b0() {
        EnterForumFragment enterForumFragment;
        if (TbadkCoreApplication.getCurrentAccount() != null || !d.b.h0.r.d0.b.i().g("enter_forum_login_tip", true) || (enterForumFragment = this.f55755b) == null || enterForumFragment.getActivity() == null || this.f55755b.H0() == null) {
            return;
        }
        if (this.i == null) {
            this.i = new CommonTipView(this.f55755b.getActivity());
        }
        this.i.setText(R.string.enter_forum_login_tip);
        this.i.k(this.f55755b.H0(), TbadkCoreApplication.getInst().getSkinType());
        d.b.h0.r.d0.b.i().s("enter_forum_login_tip", false);
    }

    public final void c0() {
        this.H.setEnabled(false);
        int H = H();
        Math.abs(H / (L() - H));
        this.J.setVisibility(8);
        int i2 = ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(J(), H);
        ofInt.addUpdateListener(new k());
        ofInt.addListener(new l());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    public final void d0() {
        this.E = false;
        k0();
        p0(0);
        if (this.F) {
            this.f55757d.A(0L);
        }
        this.F = false;
    }

    public void e0(List<d.b.i0.i0.d.f> list, o1 o1Var, boolean z) {
        this.m.setAdData();
        EnterForumDelegateStatic.f15393c.z(this.f55754a);
        this.f55759f = list;
        this.f55760g = o1Var;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !ListUtils.isEmpty(list);
        boolean z3 = !ListUtils.isEmpty(list);
        w wVar = new w();
        wVar.A(4);
        arrayList.add(wVar);
        if (z3) {
            arrayList.add(new d.b.i0.i0.d.a(true));
            arrayList.add(new d.b.i0.i0.d.e(this.f55754a.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(o1Var);
        } else {
            if (TbadkCoreApplication.isLogin()) {
                arrayList.add(new d.b.i0.i0.d.e(this.f55754a.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkCoreApplication.isLogin()) {
                w wVar2 = new w();
                wVar2.A(11);
                arrayList.add(wVar2);
            } else {
                w wVar3 = new w();
                wVar3.A(3);
                arrayList.add(wVar3);
            }
            if (TbadkCoreApplication.isLogin()) {
                arrayList.add(new p1(this.f55754a.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkCoreApplication.isLogin()) {
                arrayList.addAll(o1Var.B());
            }
            if (TbadkCoreApplication.isLogin()) {
                arrayList.add(new d.b.i0.i0.d.a(false));
            }
        }
        if (z) {
            w wVar4 = new w();
            wVar4.A(5);
            arrayList.add(wVar4);
        }
        O();
        this.f55758e.k(arrayList, z);
    }

    public final void f0() {
        this.f55755b.registerListener(this.D);
    }

    public void g0(d.b.i0.i0.d.f fVar, boolean z) {
        this.f55759f.remove(fVar);
        e0(this.f55759f, this.f55760g, z);
        V(z);
    }

    public final void h0() {
        ImageView imageView = this.J;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(J(), 0);
        ofInt.addUpdateListener(new i());
        ofInt.addListener(new j());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    public void i0() {
        int dimensionPixelSize;
        if (this.K) {
            return;
        }
        this.E = true;
        k0();
        int dimensionPixelOffset = this.f55754a.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.f55756c.q();
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            if (!enterForumAdView.f()) {
                dimensionPixelSize = this.f55754a.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.f55754a.getResources().getDimensionPixelSize(R.dimen.tbds134);
            } else if (!this.m.e()) {
                dimensionPixelSize = this.f55754a.getResources().getDimensionPixelSize(R.dimen.tbds370);
            }
            dimensionPixelOffset += dimensionPixelSize;
        }
        p0(dimensionPixelOffset);
        d.b.b.e.m.e.a().removeCallbacks(this.G);
        d.b.b.e.m.e.a().postDelayed(this.G, 3000L);
    }

    public void j0(d.b.i0.i0.d.c cVar) {
        this.s = cVar;
        d.b.i0.i0.c.a aVar = this.f55758e;
        if (aVar != null) {
            aVar.j(cVar);
        }
        if (cVar != null && cVar.f55477a) {
            if (this.f55756c.getView() != null) {
                this.f55756c.getView().setScaleX(0.5f);
                this.f55756c.getView().setScaleY(0.5f);
            }
            this.f55756c.P(R.raw.ad_refresh_load);
            return;
        }
        if (this.f55756c.getView() != null) {
            this.f55756c.getView().setScaleX(1.0f);
            this.f55756c.getView().setScaleY(1.0f);
        }
        this.f55756c.P(R.raw.lottie_common_pull_refresh);
    }

    public final void k0() {
        EnterForumAdView enterForumAdView;
        if (this.K || (enterForumAdView = this.m) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            int I = I();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(0, this.E ? -this.f55754a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I, 0, 0);
            this.m.setLayoutParams(layoutParams2);
            this.m.setAdViewHeight(layoutParams2.height - I);
        }
    }

    public final void l0(float f2) {
        ViewGroup viewGroup;
        int H = H();
        int L = L() - H;
        float f3 = H;
        float abs = Math.abs(f3 / L);
        int i2 = (int) f2;
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                I();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i2, 0, 0);
                this.m.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < marginLayoutParams.height * 0.2d) {
                    if (this.m.getParent() != this.m.getRootView() && (viewGroup = (ViewGroup) this.m.getRootView()) != null) {
                        ((ViewGroup) this.m.getParent()).removeView(this.m);
                        if (this.m.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.m, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.H);
                        viewGroup.bringChildToFront(this.J);
                    }
                } else if (this.m.getParent() == this.m.getRootView()) {
                    if (this.m.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.m.getRootView();
                        ((ViewGroup) this.m.getParent()).removeView(this.m);
                    }
                    if (this.m.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.f55755b.G0().addView(this.m, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.f55757d.setVisibility(0);
        this.K = false;
        float f4 = i2;
        p0(((int) ((f4 * abs) - (abs * f3))) * 2);
        this.K = true;
        float abs2 = Math.abs(f4 / f3);
        this.f55757d.setAlpha(abs2);
        View y = this.f55755b.I0().y();
        if (y != null) {
            y.setAlpha(abs2);
        }
        View findViewById = this.f55755b.G0().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    public void m0(d.b.i0.i0.f.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (StringUtils.isNull(aVar.d())) {
            this.L = false;
        } else {
            this.L = true;
        }
        this.o.o(aVar.c());
        this.o.p(aVar.b(), aVar.e());
        this.o.l(aVar.a());
        this.o.u(aVar.d());
    }

    public void n0(boolean z) {
        if (this.t != z) {
            this.t = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f55757d.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.f55757d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.f55757d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.f55757d.setLayoutParams(marginLayoutParams);
        }
    }

    public void o0(f.g gVar) {
        this.x = gVar;
    }

    @Override // com.baidu.tieba.enterForum.view.EnterForumAdView.c
    public void onBackPressed() {
        if (this.K) {
            c0();
        }
    }

    public final void p0(int i2) {
        if (this.K) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f55757d.getLayoutParams();
        marginLayoutParams.topMargin = ((i2 + this.u) - this.v) - (EnterForumDelegateStatic.f15393c.x() != null ? this.f55754a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        this.f55757d.setLayoutParams(marginLayoutParams);
    }

    public void q0(BdUniqueId bdUniqueId) {
        d.b.i0.i0.c.a aVar = this.f55758e;
        if (aVar != null) {
            aVar.l(bdUniqueId);
        }
    }

    public void r0(boolean z) {
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            enterForumAdView.setRecentlyIsExtend(z);
        }
    }

    public void s0(boolean z) {
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            enterForumAdView.setRecentlyIsShow(z);
        }
    }

    public void t0(View view) {
        if ((view instanceof FrameLayout) && !this.K) {
            this.f55756c.w();
            this.K = true;
            this.m.getAdImageView().getLocationInWindow(new int[2]);
            SkinManager.setImageResource(this.J, R.drawable.icon_jinba_retract_n);
            int J = J();
            ValueAnimator ofInt = ValueAnimator.ofInt(J, 0);
            ofInt.addUpdateListener(new g(J));
            ofInt.addListener(new h(J, view));
            ofInt.setDuration(300L);
            ofInt.start();
            this.m.requestFocus();
            this.m.requestFocusFromTouch();
        }
    }

    public final void u0() {
        if (T() && this.L) {
            this.o.q();
            this.o.t();
            this.o.setCancelable(false);
            d.b.h0.r.d0.b.i().s("has_guide_popup_window_been_shown", true);
            d.b.b.e.m.g.i(this.o, this.f55755b.getFragmentActivity());
        }
    }

    public void v0(w wVar, View view) {
        if (!TbadkCoreApplication.isLogin() || M || this.f55755b.getActivity() == null || this.f55755b.getPageContext() == null || !(wVar instanceof d.b.i0.i0.d.f)) {
            return;
        }
        d.b.i0.i0.d.f fVar = (d.b.i0.i0.d.f) wVar;
        if (fVar.P() != 0 && fVar.O() != 0 && !d.b.h0.r.d0.b.i().o("enter_forum_new_forum_long_press_guide", "").equals(fVar.D())) {
            this.q = R.string.create_forum_guide_tip;
        } else if (d.b.h0.r.d0.b.i().k("enter_forum_long_press_guide", 0L) != 0) {
            return;
        } else {
            this.q = R.string.forum_item_guide_tip;
        }
        if (view != null) {
            M = true;
            d.b.b.e.g.d dVar = new d.b.b.e.g.d();
            dVar.j(view);
            dVar.c(0);
            dVar.i(true);
            dVar.h(false);
            dVar.d(true);
            dVar.a(new t());
            dVar.g(new C1296b(this));
            d.b.b.e.g.c b2 = dVar.b();
            this.p = b2;
            b2.l(false);
            this.p.m(true);
            this.p.n(this.f55755b.getActivity());
            int i2 = this.q;
            if (i2 == R.string.create_forum_guide_tip) {
                d.b.h0.r.d0.b.i().w("enter_forum_new_forum_long_press_guide", fVar.D());
            } else if (i2 == R.string.forum_item_guide_tip) {
                d.b.h0.r.d0.b.i().v("enter_forum_long_press_guide", 1L);
            }
            d.b.b.e.m.e.a().postDelayed(new c(), 5000L);
        }
    }

    public void w0(View view) {
        if (this.k == null) {
            this.k = new d.b.h0.d0.h(this.f55755b.getPageContext().getContext(), new s());
        }
        this.l = view;
        this.k.j(this.f55755b.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.k.attachView(view, false);
        this.k.o();
        this.f55757d.setVisibility(8);
        if (this.f55755b.I0() != null) {
            this.f55755b.I0().M();
            this.f55755b.I0().Q();
        }
    }

    public void x0() {
        this.f55757d.F();
    }
}
