package d.a.o0.e2.k.d;

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
/* loaded from: classes5.dex */
public class d {
    public static final int m = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);

    /* renamed from: c  reason: collision with root package name */
    public PbFragment f56878c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f56879d;

    /* renamed from: e  reason: collision with root package name */
    public ViewStub f56880e;

    /* renamed from: f  reason: collision with root package name */
    public View f56881f;

    /* renamed from: g  reason: collision with root package name */
    public View f56882g;

    /* renamed from: i  reason: collision with root package name */
    public PbLandscapeListView f56884i;
    public NavigationBar j;
    public d.a.o0.e2.k.d.b k;
    public View l;

    /* renamed from: a  reason: collision with root package name */
    public int f56876a = 3;

    /* renamed from: b  reason: collision with root package name */
    public int f56877b = 3;

    /* renamed from: h  reason: collision with root package name */
    public View f56883h = null;

    /* loaded from: classes5.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f56885e;

        public a(d dVar, Runnable runnable) {
            this.f56885e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Runnable runnable = this.f56885e;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f56885e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f56886e;

        public b(d dVar, Runnable runnable) {
            this.f56886e = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Runnable runnable = this.f56886e;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f56886e;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.f56878c = pbFragment;
        this.f56880e = viewStub;
    }

    public final void a(int i2) {
        this.f56876a = i2;
        this.f56878c.getBaseFragmentActivity().getLayoutMode().j(this.f56881f);
        this.j.onChangeSkinType(this.f56878c.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.l, R.color.cp_bg_line_k_alpha40);
        this.f56879d.c(this.f56878c.getPageContext(), i2);
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
        return this.f56883h;
    }

    public BdTypeListView e() {
        return this.f56884i;
    }

    public d.a.o0.e2.k.d.b f() {
        return this.k;
    }

    public NavigationBar g() {
        return this.j;
    }

    public boolean h() {
        View childAt;
        PbLandscapeListView pbLandscapeListView = this.f56884i;
        if (pbLandscapeListView == null || pbLandscapeListView.getChildCount() <= 0) {
            return true;
        }
        return this.f56884i.getFirstVisiblePosition() <= 0 && (childAt = this.f56884i.getChildAt(0)) != null && childAt.getTop() == 0;
    }

    public void i() {
        if (m()) {
            this.f56881f.setVisibility(8);
            this.j.setStatusBarVisibility(8);
        }
    }

    public final void j() {
        if (m()) {
            return;
        }
        this.f56881f = this.f56880e.inflate();
        k();
        int i2 = this.f56876a;
        int i3 = this.f56877b;
        if (i2 != i3) {
            a(i3);
        }
    }

    public final void k() {
        View view = this.f56881f;
        if (view != null) {
            this.f56884i = (PbLandscapeListView) view.findViewById(R.id.more_god_reply_list);
            this.f56882g = this.f56881f.findViewById(R.id.more_god_reply_list_content);
            l();
            this.l = this.f56881f.findViewById(R.id.more_god_reply_back_curtain);
            this.f56879d = (NoNetworkView) this.f56881f.findViewById(R.id.more_god_reply_view_no_network);
            d.a.o0.e2.k.d.b bVar = new d.a.o0.e2.k.d.b(this.f56878c.getPageContext());
            this.k = bVar;
            this.f56884i.setNextPage(bVar);
        }
    }

    public final void l() {
        NavigationBar navigationBar = (NavigationBar) this.f56881f.findViewById(R.id.more_god_reply_nav_bar);
        this.j = navigationBar;
        this.f56883h = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.j.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f56883h.getLayoutParams();
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = g2;
            layoutParams.width = g2;
            backImageView.setLayoutParams(layoutParams);
        }
        View view = this.f56883h;
        if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f56883h.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.f56883h.setPadding(l.g(TbadkCoreApplication.getInst(), R.dimen.ds32), this.f56883h.getPaddingTop(), this.f56883h.getPaddingRight(), this.f56883h.getPaddingBottom());
            this.f56883h.setLayoutParams(layoutParams2);
        }
        if (this.j.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean m() {
        return this.f56881f != null;
    }

    public boolean n() {
        return m() && this.f56881f.getVisibility() == 0;
    }

    public void o(int i2) {
        this.f56877b = i2;
        if (m()) {
            a(i2);
        }
    }

    public void p() {
        View view;
        j();
        if (n() || (view = this.f56881f) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void q(Runnable runnable) {
        if (m()) {
            this.f56882g.setTranslationY(l.p(this.f56878c.getContext())[1]);
            this.l.setAlpha(0.0f);
            s(m, 1.0f, runnable);
        }
    }

    public void r(Runnable runnable) {
        if (m()) {
            s(this.f56882g.getHeight(), 0.0f, runnable);
        }
    }

    public final void s(float f2, float f3, Runnable runnable) {
        if (m()) {
            this.f56882g.animate().translationY(f2).setDuration(300L).setListener(new b(this, runnable)).start();
            this.l.animate().alpha(f3).setDuration(300L).start();
        }
    }

    public void t(Runnable runnable) {
        if (m()) {
            this.j.setStatusBarVisibility(0);
            this.f56882g.animate().translationY(0.0f).setDuration(300L).setListener(new a(this, runnable)).start();
        }
    }
}
