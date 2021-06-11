package d.a.n0.e2.k.e.f1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import d.a.m0.r.k;
import d.a.n0.e2.k.e.f0;
import d.a.n0.e2.k.e.g0;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f57012a;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57014c;

    /* renamed from: d  reason: collision with root package name */
    public View f57015d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57016e;

    /* renamed from: f  reason: collision with root package name */
    public final View f57017f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f57018g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f57019h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f57020i;
    public BarImageView j;
    public TextView k;
    public String l;
    public PbFragment p;
    public Runnable q;
    public ImageView r;
    public PopupWindow t;
    public int u;
    public int v;
    public int w;
    public int x;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57013b = false;
    public AlertDialog m = null;
    public f0 n = null;
    public float o = 0.33f;
    public boolean s = false;
    public Runnable y = new d();
    public View.OnClickListener z = new e();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.p.X4();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public b(c cVar) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    /* renamed from: d.a.n0.e2.k.e.f1.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1325c implements Runnable {
        public RunnableC1325c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.m != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.a(c.this.m, c.this.p.getPageContext().getPageActivity()))));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.j();
        }
    }

    public c(PbFragment pbFragment, View view) {
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.p = pbFragment;
        this.u = l.g(pbFragment.getContext(), R.dimen.ds88);
        this.v = l.g(TbadkCoreApplication.getInst(), R.dimen.ds14);
        int k = l.k(TbadkCoreApplication.getInst());
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds102) + ((int) (k * 0.07d));
        this.w = g3;
        if (g3 - g2 > 0) {
            this.w = g3 - g2;
        }
        this.x = (k - (this.w * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.f57012a = navigationBar;
        navigationBar.setOnClickListener(new a());
        this.f57012a.hideBottomLine();
        this.f57017f = this.f57012a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.V1);
        this.f57014c = this.f57012a.setCenterTextTitle("");
        this.f57018g = (ImageView) this.f57012a.getCenterImgBox();
        this.f57019h = (LinearLayout) this.f57012a.getCenterImgBoxLayout();
        int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.f57019h.setPadding(g4, 0, g4, 0);
        ImageView imageView = this.f57018g;
        int i2 = R.drawable.icon_pb_play_small;
        SkinManager.setNavbarIconSrc(imageView, i2, i2);
        this.f57018g.setVisibility(8);
        this.f57014c.setOnClickListener(pbFragment.V1);
        this.f57018g.setOnClickListener(pbFragment.V1);
        this.r = (ImageView) this.f57017f.findViewById(R.id.widget_navi_back_button);
        if (this.f57020i == null) {
            LinearLayout linearLayout = (LinearLayout) this.f57012a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.f57020i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.pb_nav_title_forum_image);
            this.j = barImageView;
            barImageView.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.j.setStrokeColorResId(R.color.CAM_X0401);
            this.j.setOnClickListener(pbFragment.V1);
            TextView textView = (TextView) this.f57020i.findViewById(R.id.pb_nav_title_forum_name);
            this.k = textView;
            textView.setOnClickListener(pbFragment.V1);
            if (this.f57020i.getLayoutParams() != null && (this.f57020i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f57020i.getLayoutParams();
                int i3 = this.w;
                marginLayoutParams.leftMargin = i3;
                marginLayoutParams.rightMargin = i3;
                this.f57020i.setLayoutParams(marginLayoutParams);
            }
            if (this.f57020i.getVisibility() == 8) {
                this.f57020i.setVisibility(0);
            }
            if (this.f57020i.getAlpha() != 1.0f) {
                this.f57020i.setAlpha(1.0f);
            }
        }
    }

    public void A() {
        View view = this.f57015d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void B(String str, String str2) {
        if (this.p == null || this.f57020i == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.j.setVisibility(8);
            this.k.setText("贴吧动态");
            this.l = null;
        } else {
            this.j.setVisibility(0);
            this.l = str;
            ThreadCardUtils.cutAndSetTextByMaxLine(this.k, str, R.string.forum, R.dimen.tbds0, 1, this.x, false);
            k.c().h(str);
            this.j.U(str2, 10, false);
        }
        q();
    }

    public final void C() {
        f0 f0Var = this.n;
        if (f0Var == null) {
            return;
        }
        f0Var.v();
    }

    public final void d() {
        g.c(this.t);
    }

    public void e() {
        if (this.q == null) {
            this.q = new RunnableC1325c();
        }
        d.a.c.e.m.e.a().postDelayed(this.q, 100L);
    }

    public void f() {
        AlertDialog alertDialog = this.m;
        if (alertDialog != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.a(alertDialog, this.p.getPageContext().getPageActivity()))));
        }
    }

    public f0 g() {
        return this.n;
    }

    public View h() {
        return this.f57018g;
    }

    public NavigationBar i() {
        return this.f57012a;
    }

    public void j() {
        if (this.y != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.y);
        }
        d();
    }

    public void k() {
        this.r.setVisibility(0);
        r(false);
        View view = this.f57015d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public boolean l() {
        AlertDialog alertDialog = this.m;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void m(int i2) {
        NavigationBar navigationBar = this.f57012a;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.p.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f57012a.getBarBgView(), R.color.CAM_X0207);
        }
        BarImageView barImageView = this.j;
        if (barImageView != null) {
            barImageView.invalidate();
        }
        WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.f57016e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.f57014c, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        q();
        C();
    }

    public void n(int i2) {
        this.f57012a.onChangeSkinType(this.p.getPageContext(), i2);
        this.f57012a.getBackground().mutate().setAlpha(0);
        this.f57012a.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.f57012a.getTopCoverBgView().setVisibility(0);
        this.f57012a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        this.f57014c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
        WebPManager.setPureDrawable(this.f57016e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void o(View view) {
    }

    public void p() {
        f0 f0Var = this.n;
        if (f0Var != null) {
            f0Var.u();
        }
        this.m = null;
        this.n = null;
        d.a.c.e.m.e.a().removeCallbacks(this.q);
    }

    public final void q() {
        if (this.f57020i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f57020i);
            d2.m(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            return;
        }
        this.f57020i.setBackgroundResource(0);
    }

    public void r(boolean z) {
        if (!this.f57013b && z && !"".equals(this.f57014c.getText().toString())) {
            this.f57014c.setVisibility(0);
        } else {
            this.f57014c.setVisibility(8);
        }
    }

    public void s(boolean z) {
        this.s = z;
    }

    public void t(boolean z) {
        if (z) {
            this.f57017f.setVisibility(0);
        } else {
            this.f57017f.setVisibility(8);
        }
        r(z);
    }

    public void u() {
        if ((!this.s || TbadkCoreApplication.isLogin()) && !d.a.m0.r.d0.b.j().g("show_share", false)) {
            View inflate = LayoutInflater.from(this.p.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = l.g(this.p.getContext(), R.dimen.ds28);
            } else {
                layoutParams.rightMargin = l.g(this.p.getContext(), R.dimen.ds128);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.z);
            this.t = new PopupWindow(inflate, -2, -2);
        }
    }

    public void v(boolean z) {
        this.r.setVisibility(0);
        r(z);
        if (TbadkCoreApplication.isLogin()) {
            View view = this.f57015d;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.f57015d;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void w(g0 g0Var) {
        if (this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new f0(pbFragment, pbFragment.V1);
        AlertDialog create = new AlertDialog.Builder(this.p.getContext(), R.style.DialogTheme).create();
        this.m = create;
        create.setCanceledOnTouchOutside(true);
        this.m.setOnDismissListener(new b(this));
        g.i(this.m, this.p.getFragmentActivity());
        Window window = this.m.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.n.s());
        window.setDimAmount(this.o);
        this.n.J(g0Var == null ? false : g0Var.f57025a);
        this.n.x(g0Var == null ? false : g0Var.f57029e);
        this.n.B(g0Var == null ? false : g0Var.f57033i);
        this.n.y(g0Var == null ? false : g0Var.f57030f);
        this.n.L(g0Var != null ? g0Var.f57027c : true);
        this.n.I(g0Var == null ? false : g0Var.k);
        if (g0Var == null) {
            this.n.G(false, false);
            this.n.F(false, false);
        } else {
            this.n.G(g0Var.f57031g, g0Var.q);
            this.n.F(g0Var.f57032h, g0Var.p);
        }
        boolean z = g0Var == null ? false : g0Var.o;
        boolean z2 = g0Var == null ? false : g0Var.m;
        boolean z3 = g0Var == null ? false : g0Var.f57028d;
        boolean z4 = g0Var == null ? false : g0Var.f57026b;
        boolean z5 = g0Var == null ? false : g0Var.n;
        boolean z6 = g0Var == null ? false : g0Var.j;
        boolean z7 = g0Var == null ? false : g0Var.l;
        this.n.z(z3, z2);
        this.n.K(z4, z);
        this.n.H(z6, z5);
        this.n.O(z7);
        if (g0Var != null) {
            f0 f0Var = this.n;
            boolean z8 = g0Var.r;
            f0Var.u = z8;
            if (z8) {
                f0Var.f().setText(R.string.report_text);
                this.n.y(false);
            }
        }
        this.n.w(g0Var == null ? false : g0Var.s);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.A() != null && this.p.A().C0() != null && this.p.A().C0().N() != null && this.p.A().C0().N().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.d().setText(R.string.have_called_fans_short);
        }
        C();
        this.n.P(g0Var != null ? g0Var.t : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void x(String str) {
        if (!TextUtils.isEmpty(str) && !this.f57013b) {
            this.f57014c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            r(true);
            k.c().h(str);
            return;
        }
        r(false);
    }

    public void y(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.f57013b = z;
        if (this.f57015d == null && this.f57016e == null) {
            View addCustomView = this.f57012a.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.p.V1);
            this.f57015d = addCustomView;
            this.f57016e = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int i2 = this.u;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            layoutParams.rightMargin = this.v;
            this.f57015d.setLayoutParams(layoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57016e, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f57015d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void z(boolean z) {
        View view = this.f57015d;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
