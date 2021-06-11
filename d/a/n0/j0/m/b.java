package d.a.n0.j0.m;

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
import d.a.c.e.g.d;
import d.a.c.k.e.c;
import d.a.m0.r.f0.f;
import d.a.m0.r.q.o1;
import d.a.m0.r.q.p1;
import d.a.m0.r.q.w;
import d.a.n0.j0.m.e;
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
    public Context f59813a;

    /* renamed from: b  reason: collision with root package name */
    public final EnterForumFragment f59814b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.r.f0.g f59815c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f59816d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.j0.c.a f59817e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.n0.j0.d.f> f59818f;

    /* renamed from: g  reason: collision with root package name */
    public o1 f59819g;

    /* renamed from: h  reason: collision with root package name */
    public ViewEventCenter f59820h;

    /* renamed from: i  reason: collision with root package name */
    public CommonTipView f59821i;
    public View j;
    public d.a.m0.d0.h k;
    public View l;
    public EnterForumAdView m;
    public View n;
    public GuidePopupWindow o;
    public d.a.c.e.g.c p;
    public int q;
    public d.a.n0.j0.m.e r;
    public d.a.n0.j0.d.c s;
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

        /* renamed from: d.a.n0.j0.m.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1441a implements Runnable {
            public RunnableC1441a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f59816d.setSelection(0);
            }
        }

        public a() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (b.this.K) {
                return;
            }
            d.a.n0.d3.c.g().j(b.this.f59814b.getUniqueId());
            if (b.this.x != null) {
                b.this.x.onListPullRefresh(z);
            }
            if (z) {
                b bVar = b.this;
                if (bVar.E || bVar.s == null || !b.this.s.f59524a) {
                    return;
                }
                if (b.this.s.f59526c > 0) {
                    b.this.f59816d.E(0, 0, 0);
                    b.this.i0();
                    return;
                }
                d.a.c.e.m.e.a().post(new RunnableC1441a());
            }
        }
    }

    /* renamed from: d.a.n0.j0.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1442b implements d.a {
        public C1442b(b bVar) {
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
        }

        @Override // d.a.c.e.g.d.a
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
            EnterForumAdView.c(b.this.f59814b.getPageContext().getUniqueId(), b.this.f59813a);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public float f59826e = 0.0f;

        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                b.this.I = motionEvent.getRawY();
            } else if (action == 1) {
                if (b.this.I <= (b.this.f59813a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.I) {
                    b.this.h0();
                    if (this.f59826e < 50.0f) {
                        b.this.H.performClick();
                    }
                } else {
                    b.this.c0();
                }
                b.this.I = 0.0f;
                this.f59826e = 0.0f;
            } else if (action != 2) {
                if (b.this.I <= (b.this.f59813a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.I) {
                    b.this.h0();
                } else {
                    b.this.c0();
                }
                b.this.I = 0.0f;
                this.f59826e = 0.0f;
            } else {
                if (motionEvent.getRawY() < b.this.I) {
                    b.this.l0(motionEvent.getRawY() - b.this.I);
                    if (b.this.J != null) {
                        b.this.J.setVisibility(8);
                    }
                }
                if (Math.abs(motionEvent.getRawY() - b.this.I) > this.f59826e) {
                    this.f59826e = Math.abs(motionEvent.getRawY() - b.this.I);
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
        public final /* synthetic */ int f59829e;

        public g(int i2) {
            this.f59829e = i2;
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
                    if (intValue / this.f59829e < 0.2d) {
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
                            b.this.f59814b.I0().addView(b.this.m, 0, marginLayoutParams3);
                        }
                    }
                }
            }
            b.this.K = false;
            b.this.p0(((intValue - this.f59829e) * 2) + 0);
            b.this.K = true;
            float abs = Math.abs(intValue / this.f59829e);
            b.this.f59816d.setAlpha(abs);
            View w = b.this.f59814b.K0().w();
            if (w != null) {
                w.setAlpha(abs);
            }
            View findViewById = b.this.f59814b.I0().getRootView().findViewById(R.id.tabcontainer_wrapper);
            if (findViewById != null) {
                findViewById.setAlpha(abs);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f59832f;

        public h(int i2, View view) {
            this.f59831e = i2;
            this.f59832f = view;
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
            b.this.f59815c.A();
            b.this.f59816d.z();
            b.this.f59815c.D(0, -b.this.f59815c.q(), 0, 0);
            b.this.K = false;
            b.this.p0(0 - (this.f59831e * 2));
            b.this.K = true;
            b.this.f59816d.setVisibility(8);
            b.this.H.setEnabled(true);
            FrameLayout frameLayout = (FrameLayout) this.f59832f;
            if (b.this.H.getParent() == null) {
                frameLayout.addView(b.this.H, new FrameLayout.LayoutParams(-1, -1));
            }
            if (b.this.J.getParent() == null) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams3.bottomMargin = b.this.f59813a.getResources().getDimensionPixelOffset(R.dimen.tbds107);
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
            b.this.f59815c.A();
            b.this.f59816d.z();
            b.this.f59815c.D(0, -b.this.f59815c.q(), 0, 0);
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

            /* renamed from: d.a.n0.j0.m.b$l$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC1443a implements Runnable {
                public RunnableC1443a() {
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
                b.this.f59815c.A();
                b.this.f59816d.z();
                b.this.f59815c.D(0, -b.this.f59815c.q(), 0, 0);
                d.a.c.e.m.e.a().postDelayed(new RunnableC1443a(), 0L);
                b.this.f59816d.setVisibility(0);
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
            d.a.c.e.m.e.a().post(new a());
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
        public int f59840e = -1;

        public m() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (b.this.f59814b.isPrimary() && this.f59840e != 1 && i2 == 0) {
                for (int i5 = i2; i5 < i2 + i3; i5++) {
                    Object itemAtPosition = b.this.f59816d.getItemAtPosition(i5);
                    if (itemAtPosition != null && (itemAtPosition instanceof w)) {
                        w wVar = (w) itemAtPosition;
                        if (wVar.z() == 1 && b.this.f59816d.getItemAtPosition(i5) == ListUtils.getItem(b.this.f59818f, 0)) {
                            b.this.v0(wVar, b.this.f59816d.getChildAt(i5).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.r.onScroll(absListView, i2, i3, i4);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            b.this.r.onScrollStateChanged(absListView, i2);
            if (this.f59840e != i2) {
                this.f59840e = i2;
                if (i2 == 1) {
                    if (b.this.s == null || !b.this.s.f59524a) {
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
            if (b.this.s == null || !b.this.s.f59524a) {
                return;
            }
            b bVar = b.this;
            if (bVar.E) {
                EnterForumAdView unused = bVar.m;
                EnterForumAdView.c(b.this.f59814b.getUniqueId(), b.this.f59814b.getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends CustomMessageListener {
        public o(int i2) {
            super(i2);
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

        @Override // d.a.n0.j0.m.e.c
        public void a(AbsListView absListView, int i2, int i3) {
            if (b.this.K) {
                return;
            }
            b.this.B = -i2;
            b bVar = b.this;
            if (bVar.E) {
                bVar.d0();
            } else if (bVar.s == null || !b.this.s.f59524a) {
            } else {
                b.this.k0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements c.a {
        public q() {
        }

        @Override // d.a.c.k.e.c.a
        public void a(d.a.c.k.e.c cVar, int i2, int i3, int i4, int i5) {
            b.this.C = i4;
            b bVar = b.this;
            if (bVar.E || bVar.s == null || !b.this.s.f59524a || b.this.K) {
                return;
            }
            b.this.k0();
            if (i4 > b.this.w) {
                b.this.C = 0;
                b bVar2 = b.this;
                bVar2.t0(bVar2.f59814b.K0().u());
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
    public class t implements d.a.c.e.g.b {
        public t() {
        }

        @Override // d.a.c.e.g.b
        public int a() {
            return 4;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            return 16;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.q);
            b.this.f59814b.getPageContext().getLayoutMode().j(inflate);
            return inflate;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            return 0;
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            return 0;
        }
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.f59814b = enterForumFragment;
        this.u = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + d.a.c.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.v = d.a.c.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.w = d.a.c.e.p.l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.f59820h = viewEventCenter;
        R(view);
        d.a.n0.j0.c.a aVar = new d.a.n0.j0.c.a(this.f59814b.getPageContext(), this.f59820h, recentlyVisitedForumModel, enterForumModel, this);
        this.f59817e = aVar;
        this.f59816d.setAdapter((ListAdapter) aVar);
        W(TbadkCoreApplication.getInst().getSkinType());
        f0();
        this.o = new GuidePopupWindow(this.f59814b.getFragmentActivity());
    }

    public final void E() {
        if (U()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
            return;
        }
        d.a.n0.j0.d.c cVar = this.s;
        if (cVar != null && cVar.f59524a) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
        }
    }

    public boolean F() {
        d.a.n0.j0.c.a aVar = this.f59817e;
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
        this.f59816d.A(0L);
    }

    public final int H() {
        return this.E ? -this.f59813a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I();
    }

    public final int I() {
        return this.f59813a.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    public final int J() {
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public BdListView K() {
        return this.f59816d;
    }

    public final int L() {
        return (this.u - this.v) - (EnterForumDelegateStatic.f14461c.B() != null ? this.f59813a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    public d.a.m0.d0.h M() {
        return this.k;
    }

    public void N() {
        d.a.c.e.g.c cVar = this.p;
        if (cVar != null) {
            cVar.d();
            this.p = null;
        }
    }

    public void O() {
        d.a.m0.d0.h hVar = this.k;
        if (hVar != null) {
            hVar.dettachView(this.l);
            this.k = null;
            this.l = null;
        }
        this.f59816d.setVisibility(0);
        if (this.f59814b.K0() != null) {
            this.f59814b.K0().K();
            this.f59814b.K0().O();
        }
    }

    public final void P() {
        d.a.c.e.p.l.g(this.f59813a, R.dimen.tbds240);
        View view = new View(this.f59813a);
        this.H = view;
        view.setOnClickListener(new d());
        this.H.setOnTouchListener(new e());
        ImageView imageView = new ImageView(this.f59813a);
        this.J = imageView;
        imageView.setOnClickListener(new f());
    }

    public void Q(View view) {
        EnterForumAdView enterForumAdView = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        this.m = enterForumAdView;
        if (enterForumAdView != null) {
            k0();
            this.m.setTag(this.f59814b.getUniqueId());
            this.m.setAdData();
            this.m.setEventCenter(this.f59820h);
            this.m.setOnBackPressedListener(this);
        }
    }

    public final void R(View view) {
        this.f59813a = view.getContext();
        d.a.n0.j0.m.e eVar = new d.a.n0.j0.m.e();
        this.r = eVar;
        eVar.a(new p());
        this.f59816d = (BdListView) view.findViewById(R.id.listview);
        p0(0);
        this.f59816d.setBackgroundColor(0);
        this.f59816d.setVerticalScrollBarEnabled(false);
        this.f59816d.setOnScrollListener(this.z);
        this.f59816d.setFastScrollEnabled(false);
        this.f59816d.setMaxHeight(this.f59813a.getResources().getDisplayMetrics().heightPixels);
        BdListView.D(1.0f);
        if (this.f59814b.K0() != null) {
            this.f59814b.K0().R(this);
        }
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(this.f59814b.getPageContext());
        this.f59815c = gVar;
        gVar.C(new q());
        this.f59815c.Y(true);
        this.f59815c.a(this.y);
        d.a.m0.r.f0.g gVar2 = this.f59815c;
        if (gVar2 != null) {
            gVar2.Z(this.f59814b.getUniqueId());
        }
        this.f59816d.setPullRefresh(this.f59815c);
        FrameLayout frameLayout = new FrameLayout(this.f59814b.getPageContext().getPageActivity());
        View view2 = new View(this.f59814b.getPageContext().getPageActivity());
        this.n = view2;
        frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, this.v));
        this.f59816d.getAdapter2().g(frameLayout, 0);
        this.j = new View(this.f59814b.getActivity());
        this.j.setLayoutParams(new AbsListView.LayoutParams(-1, d.a.c.e.p.l.g(this.f59814b.getActivity(), R.dimen.ds50)));
        this.j.setBackgroundResource(R.color.CAM_X0201);
        this.f59815c.R(this.A);
        this.f59815c.getView().setOnClickListener(this.A);
        this.n.setOnClickListener(this.A);
        P();
    }

    public boolean S() {
        return ListUtils.isEmpty(this.f59818f);
    }

    public final boolean T() {
        return TbadkCoreApplication.isLogin() && !d.a.m0.r.d0.b.j().g("has_guide_popup_window_been_shown", false);
    }

    public boolean U() {
        BdListView bdListView = this.f59816d;
        return bdListView == null || bdListView.getChildCount() == 0 || this.f59816d.getChildAt(0).getTop() == 0;
    }

    public void V(boolean z) {
        this.f59817e.notifyDataSetChanged();
        View view = this.j;
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        if (z) {
            this.j.getLayoutParams().height = d.a.c.e.p.l.g(this.f59813a, R.dimen.ds50);
            return;
        }
        this.j.getLayoutParams().height = d.a.c.e.p.l.g(this.f59813a, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
    }

    public void W(int i2) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.f59816d.removeFooterView(this.j);
            this.f59816d.addFooterView(this.j);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.f59816d.removeFooterView(this.j);
        }
        d.a.m0.r.f0.g gVar = this.f59815c;
        if (gVar != null) {
            gVar.I(i2);
        }
        d.a.m0.d0.h hVar = this.k;
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
        CommonTipView commonTipView = this.f59821i;
        if (commonTipView != null) {
            commonTipView.i();
        }
        d.a.n0.j0.c.a aVar = this.f59817e;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void Y() {
        N();
    }

    public void Z() {
        if (this.f59814b.isAdded() && this.f59814b.isPrimary()) {
            M = false;
            d.a.n0.j0.c.a aVar = this.f59817e;
            if (aVar != null) {
                aVar.h();
                BdListView bdListView = this.f59816d;
                if (bdListView != null) {
                    Object itemAtPosition = this.f59816d.getItemAtPosition(bdListView.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof w) && ((w) itemAtPosition).z() == 5) {
                        this.f59817e.m();
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
        this.f59817e.i(i2);
    }

    public void b0() {
        EnterForumFragment enterForumFragment;
        if (TbadkCoreApplication.getCurrentAccount() != null || !d.a.m0.r.d0.b.j().g("enter_forum_login_tip", true) || (enterForumFragment = this.f59814b) == null || enterForumFragment.getActivity() == null || this.f59814b.J0() == null) {
            return;
        }
        if (this.f59821i == null) {
            this.f59821i = new CommonTipView(this.f59814b.getActivity());
        }
        this.f59821i.setText(R.string.enter_forum_login_tip);
        this.f59821i.k(this.f59814b.J0(), TbadkCoreApplication.getInst().getSkinType());
        d.a.m0.r.d0.b.j().t("enter_forum_login_tip", false);
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
            this.f59816d.A(0L);
        }
        this.F = false;
    }

    public void e0(List<d.a.n0.j0.d.f> list, o1 o1Var, boolean z) {
        this.m.setAdData();
        EnterForumDelegateStatic.f14461c.D(this.f59813a);
        this.f59818f = list;
        this.f59819g = o1Var;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !ListUtils.isEmpty(list);
        boolean z3 = !ListUtils.isEmpty(list);
        w wVar = new w();
        wVar.A(4);
        arrayList.add(wVar);
        if (z3) {
            arrayList.add(new d.a.n0.j0.d.a(true));
            arrayList.add(new d.a.n0.j0.d.e(this.f59813a.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(o1Var);
        } else {
            if (TbadkCoreApplication.isLogin()) {
                arrayList.add(new d.a.n0.j0.d.e(this.f59813a.getResources().getString(R.string.my_attention_bar), z2));
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
                arrayList.add(new p1(this.f59813a.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkCoreApplication.isLogin()) {
                arrayList.addAll(o1Var.B());
            }
            if (TbadkCoreApplication.isLogin()) {
                arrayList.add(new d.a.n0.j0.d.a(false));
            }
        }
        if (z) {
            w wVar4 = new w();
            wVar4.A(5);
            arrayList.add(wVar4);
        }
        O();
        this.f59817e.k(arrayList, z);
    }

    public final void f0() {
        this.f59814b.registerListener(this.D);
    }

    public void g0(d.a.n0.j0.d.f fVar, boolean z) {
        this.f59818f.remove(fVar);
        e0(this.f59818f, this.f59819g, z);
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
        int dimensionPixelOffset = this.f59813a.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.f59815c.q();
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            if (!enterForumAdView.f()) {
                dimensionPixelSize = this.f59813a.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.f59813a.getResources().getDimensionPixelSize(R.dimen.tbds134);
            } else if (!this.m.e()) {
                dimensionPixelSize = this.f59813a.getResources().getDimensionPixelSize(R.dimen.tbds370);
            }
            dimensionPixelOffset += dimensionPixelSize;
        }
        p0(dimensionPixelOffset);
        d.a.c.e.m.e.a().removeCallbacks(this.G);
        d.a.c.e.m.e.a().postDelayed(this.G, 3000L);
    }

    public void j0(d.a.n0.j0.d.c cVar) {
        this.s = cVar;
        d.a.n0.j0.c.a aVar = this.f59817e;
        if (aVar != null) {
            aVar.j(cVar);
        }
        if (cVar != null && cVar.f59524a) {
            if (this.f59815c.getView() != null) {
                this.f59815c.getView().setScaleX(0.5f);
                this.f59815c.getView().setScaleY(0.5f);
            }
            this.f59815c.P(R.raw.ad_refresh_load);
            return;
        }
        if (this.f59815c.getView() != null) {
            this.f59815c.getView().setScaleX(1.0f);
            this.f59815c.getView().setScaleY(1.0f);
        }
        this.f59815c.P(R.raw.lottie_common_pull_refresh);
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
            layoutParams2.setMargins(0, this.E ? -this.f59813a.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.B + this.C) - I, 0, 0);
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
                        this.f59814b.I0().addView(this.m, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.f59816d.setVisibility(0);
        this.K = false;
        float f4 = i2;
        p0(((int) ((f4 * abs) - (abs * f3))) * 2);
        this.K = true;
        float abs2 = Math.abs(f4 / f3);
        this.f59816d.setAlpha(abs2);
        View w = this.f59814b.K0().w();
        if (w != null) {
            w.setAlpha(abs2);
        }
        View findViewById = this.f59814b.I0().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    public void m0(d.a.n0.j0.f.a.a aVar) {
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
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f59816d.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.f59816d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.f59816d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.f59816d.setLayoutParams(marginLayoutParams);
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
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f59816d.getLayoutParams();
        marginLayoutParams.topMargin = ((i2 + this.u) - this.v) - (EnterForumDelegateStatic.f14461c.B() != null ? this.f59813a.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
        this.f59816d.setLayoutParams(marginLayoutParams);
    }

    public void q0(BdUniqueId bdUniqueId) {
        d.a.n0.j0.c.a aVar = this.f59817e;
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
            this.f59815c.w();
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
            d.a.m0.r.d0.b.j().t("has_guide_popup_window_been_shown", true);
            d.a.c.e.m.g.i(this.o, this.f59814b.getFragmentActivity());
        }
    }

    public void v0(w wVar, View view) {
        if (!TbadkCoreApplication.isLogin() || M || this.f59814b.getActivity() == null || this.f59814b.getPageContext() == null || !(wVar instanceof d.a.n0.j0.d.f)) {
            return;
        }
        d.a.n0.j0.d.f fVar = (d.a.n0.j0.d.f) wVar;
        if (fVar.P() != 0 && fVar.O() != 0 && !d.a.m0.r.d0.b.j().p("enter_forum_new_forum_long_press_guide", "").equals(fVar.D())) {
            this.q = R.string.create_forum_guide_tip;
        } else if (d.a.m0.r.d0.b.j().l("enter_forum_long_press_guide", 0L) != 0) {
            return;
        } else {
            this.q = R.string.forum_item_guide_tip;
        }
        if (view != null) {
            M = true;
            d.a.c.e.g.d dVar = new d.a.c.e.g.d();
            dVar.j(view);
            dVar.c(0);
            dVar.i(true);
            dVar.h(false);
            dVar.d(true);
            dVar.a(new t());
            dVar.g(new C1442b(this));
            d.a.c.e.g.c b2 = dVar.b();
            this.p = b2;
            b2.l(false);
            this.p.m(true);
            this.p.n(this.f59814b.getActivity());
            int i2 = this.q;
            if (i2 == R.string.create_forum_guide_tip) {
                d.a.m0.r.d0.b.j().x("enter_forum_new_forum_long_press_guide", fVar.D());
            } else if (i2 == R.string.forum_item_guide_tip) {
                d.a.m0.r.d0.b.j().w("enter_forum_long_press_guide", 1L);
            }
            d.a.c.e.m.e.a().postDelayed(new c(), 5000L);
        }
    }

    public void w0(View view) {
        if (this.k == null) {
            this.k = new d.a.m0.d0.h(this.f59814b.getPageContext().getContext(), new s());
        }
        this.l = view;
        this.k.j(this.f59814b.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.k.attachView(view, false);
        this.k.o();
        this.f59816d.setVisibility(8);
        if (this.f59814b.K0() != null) {
            this.f59814b.K0().K();
            this.f59814b.K0().O();
        }
    }

    public void x0() {
        this.f59816d.F();
    }
}
