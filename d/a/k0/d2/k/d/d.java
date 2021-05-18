package d.a.k0.d2.k.d;

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
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class d {
    public static final int m = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f52858c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f52859d;

    /* renamed from: e  reason: collision with root package name */
    public ViewStub f52860e;

    /* renamed from: f  reason: collision with root package name */
    public View f52861f;

    /* renamed from: g  reason: collision with root package name */
    public View f52862g;

    /* renamed from: i  reason: collision with root package name */
    public PbLandscapeListView f52864i;
    public NavigationBar j;
    public d.a.k0.d2.k.d.b k;
    public View l;

    /* renamed from: a  reason: collision with root package name */
    public int f52856a = 3;

    /* renamed from: b  reason: collision with root package name */
    public int f52857b = 3;

    /* renamed from: h  reason: collision with root package name */
    public View f52863h = null;

    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f52865e;

        public a(d dVar, Runnable runnable) {
            this.f52865e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Runnable runnable = this.f52865e;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f52865e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f52866e;

        public b(d dVar, Runnable runnable) {
            this.f52866e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Runnable runnable = this.f52866e;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f52866e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.f52858c = pbFragment;
        this.f52860e = viewStub;
    }

    public final void a(int i2) {
        this.f52856a = i2;
        this.f52858c.getBaseFragmentActivity().getLayoutMode().j(this.f52861f);
        this.j.onChangeSkinType(this.f52858c.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.l, R.color.cp_bg_line_k_alpha40);
        this.f52859d.c(this.f52858c.getPageContext(), i2);
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
        return this.f52863h;
    }

    public BdTypeListView e() {
        return this.f52864i;
    }

    public d.a.k0.d2.k.d.b f() {
        return this.k;
    }

    public NavigationBar g() {
        return this.j;
    }

    public boolean h() {
        View childAt;
        PbLandscapeListView pbLandscapeListView = this.f52864i;
        if (pbLandscapeListView == null || pbLandscapeListView.getChildCount() <= 0) {
            return true;
        }
        return this.f52864i.getFirstVisiblePosition() <= 0 && (childAt = this.f52864i.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    public void i() {
        if (m()) {
            this.f52861f.setVisibility(8);
            this.j.setStatusBarVisibility(8);
        }
    }

    public final void j() {
        if (m()) {
            return;
        }
        this.f52861f = this.f52860e.inflate();
        k();
        int i2 = this.f52856a;
        int i3 = this.f52857b;
        if (i2 != i3) {
            a(i3);
        }
    }

    public final void k() {
        View view = this.f52861f;
        if (view != null) {
            this.f52864i = (PbLandscapeListView) view.findViewById(R.id.more_god_reply_list);
            this.f52862g = this.f52861f.findViewById(R.id.more_god_reply_list_content);
            l();
            this.l = this.f52861f.findViewById(R.id.more_god_reply_back_curtain);
            this.f52859d = (NoNetworkView) this.f52861f.findViewById(R.id.more_god_reply_view_no_network);
            d.a.k0.d2.k.d.b bVar = new d.a.k0.d2.k.d.b(this.f52858c.getPageContext());
            this.k = bVar;
            this.f52864i.setNextPage(bVar);
        }
    }

    public final void l() {
        NavigationBar navigationBar = (NavigationBar) this.f52861f.findViewById(R.id.more_god_reply_nav_bar);
        this.j = navigationBar;
        this.f52863h = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.j.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f52863h.getLayoutParams();
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = g2;
            layoutParams.width = g2;
            backImageView.setLayoutParams(layoutParams);
        }
        View view = this.f52863h;
        if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f52863h.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.f52863h.setPadding(l.g(TbadkCoreApplication.getInst(), R.dimen.ds32), this.f52863h.getPaddingTop(), this.f52863h.getPaddingRight(), this.f52863h.getPaddingBottom());
            this.f52863h.setLayoutParams(layoutParams2);
        }
        if (this.j.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean m() {
        return this.f52861f != null;
    }

    public boolean n() {
        return m() && this.f52861f.getVisibility() == 0;
    }

    public void o(int i2) {
        this.f52857b = i2;
        if (m()) {
            a(i2);
        }
    }

    public void p() {
        View view;
        j();
        if (n() || (view = this.f52861f) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void q(Runnable runnable) {
        if (m()) {
            this.f52862g.setTranslationY(l.p(this.f52858c.getContext())[1]);
            this.l.setAlpha(0.0f);
            s(m, 1.0f, runnable);
        }
    }

    public void r(Runnable runnable) {
        if (m()) {
            s(this.f52862g.getHeight(), 0.0f, runnable);
        }
    }

    public final void s(float f2, float f3, Runnable runnable) {
        if (m()) {
            this.f52862g.animate().translationY(f2).setDuration(300L).setListener(new b(this, runnable)).start();
            this.l.animate().alpha(f3).setDuration(300L).start();
        }
    }

    public void t(Runnable runnable) {
        if (m()) {
            this.j.setStatusBarVisibility(0);
            this.f52862g.animate().translationY(0.0f).setDuration(300L).setListener(new a(this, runnable)).start();
        }
    }
}
