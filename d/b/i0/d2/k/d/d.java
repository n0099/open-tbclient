package d.b.i0.d2.k.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class d {
    public static final int m = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f53950c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f53951d;

    /* renamed from: e  reason: collision with root package name */
    public ViewStub f53952e;

    /* renamed from: f  reason: collision with root package name */
    public View f53953f;

    /* renamed from: g  reason: collision with root package name */
    public View f53954g;
    public PbLandscapeListView i;
    public NavigationBar j;
    public d.b.i0.d2.k.d.b k;
    public View l;

    /* renamed from: a  reason: collision with root package name */
    public int f53948a = 3;

    /* renamed from: b  reason: collision with root package name */
    public int f53949b = 3;

    /* renamed from: h  reason: collision with root package name */
    public View f53955h = null;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f53956e;

        public a(d dVar, Runnable runnable) {
            this.f53956e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Runnable runnable = this.f53956e;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f53956e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f53957e;

        public b(d dVar, Runnable runnable) {
            this.f53957e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Runnable runnable = this.f53957e;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f53957e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.f53950c = pbFragment;
        this.f53952e = viewStub;
    }

    public final void a(int i) {
        this.f53948a = i;
        this.f53950c.getBaseFragmentActivity().getLayoutMode().j(this.f53953f);
        this.j.onChangeSkinType(this.f53950c.getPageContext(), i);
        SkinManager.setBackgroundResource(this.l, R.color.cp_bg_line_k_alpha40);
        this.f53951d.c(this.f53950c.getPageContext(), i);
    }

    public void b(boolean z) {
        if (z) {
            this.k.P();
        } else {
            this.k.f();
        }
    }

    public View c() {
        return this.l;
    }

    public View d() {
        return this.f53955h;
    }

    public BdTypeListView e() {
        return this.i;
    }

    public d.b.i0.d2.k.d.b f() {
        return this.k;
    }

    public NavigationBar g() {
        return this.j;
    }

    public boolean h() {
        View childAt;
        PbLandscapeListView pbLandscapeListView = this.i;
        if (pbLandscapeListView == null || pbLandscapeListView.getChildCount() <= 0) {
            return true;
        }
        return this.i.getFirstVisiblePosition() <= 0 && (childAt = this.i.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    public void i() {
        if (m()) {
            this.f53953f.setVisibility(8);
            this.j.setStatusBarVisibility(8);
        }
    }

    public final void j() {
        if (m()) {
            return;
        }
        this.f53953f = this.f53952e.inflate();
        k();
        int i = this.f53948a;
        int i2 = this.f53949b;
        if (i != i2) {
            a(i2);
        }
    }

    public final void k() {
        View view = this.f53953f;
        if (view != null) {
            this.i = (PbLandscapeListView) view.findViewById(R.id.more_god_reply_list);
            this.f53954g = this.f53953f.findViewById(R.id.more_god_reply_list_content);
            l();
            this.l = this.f53953f.findViewById(R.id.more_god_reply_back_curtain);
            this.f53951d = (NoNetworkView) this.f53953f.findViewById(R.id.more_god_reply_view_no_network);
            d.b.i0.d2.k.d.b bVar = new d.b.i0.d2.k.d.b(this.f53950c.getPageContext());
            this.k = bVar;
            this.i.setNextPage(bVar);
        }
    }

    public final void l() {
        NavigationBar navigationBar = (NavigationBar) this.f53953f.findViewById(R.id.more_god_reply_nav_bar);
        this.j = navigationBar;
        this.f53955h = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.j.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f53955h.getLayoutParams();
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = g2;
            layoutParams.width = g2;
            backImageView.setLayoutParams(layoutParams);
        }
        View view = this.f53955h;
        if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f53955h.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.f53955h.setPadding(l.g(TbadkCoreApplication.getInst(), R.dimen.ds32), this.f53955h.getPaddingTop(), this.f53955h.getPaddingRight(), this.f53955h.getPaddingBottom());
            this.f53955h.setLayoutParams(layoutParams2);
        }
        if (this.j.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean m() {
        return this.f53953f != null;
    }

    public boolean n() {
        return m() && this.f53953f.getVisibility() == 0;
    }

    public void o(int i) {
        this.f53949b = i;
        if (m()) {
            a(i);
        }
    }

    public void p() {
        View view;
        j();
        if (n() || (view = this.f53953f) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void q(Runnable runnable) {
        if (m()) {
            this.f53954g.setTranslationY(l.p(this.f53950c.getContext())[1]);
            this.l.setAlpha(0.0f);
            s(m, 1.0f, runnable);
        }
    }

    public void r(Runnable runnable) {
        if (m()) {
            s(this.f53954g.getHeight(), 0.0f, runnable);
        }
    }

    public final void s(float f2, float f3, Runnable runnable) {
        if (m()) {
            this.f53954g.animate().translationY(f2).setDuration(300L).setListener(new b(this, runnable)).start();
            this.l.animate().alpha(f3).setDuration(300L).start();
        }
    }

    public void t(Runnable runnable) {
        if (m()) {
            this.j.setStatusBarVisibility(0);
            this.f53954g.animate().translationY(0.0f).setDuration(300L).setListener(new a(this, runnable)).start();
        }
    }
}
