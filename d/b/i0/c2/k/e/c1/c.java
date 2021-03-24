package d.b.i0.c2.k.e.c1;

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
import d.b.b.e.m.g;
import d.b.b.e.p.l;
import d.b.h0.r.k;
import d.b.i0.c2.k.e.d0;
import d.b.i0.c2.k.e.e0;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f52648a;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52650c;

    /* renamed from: d  reason: collision with root package name */
    public View f52651d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f52652e;

    /* renamed from: f  reason: collision with root package name */
    public final View f52653f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f52654g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f52655h;
    public LinearLayout i;
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
    public boolean f52649b = false;
    public AlertDialog m = null;
    public d0 n = null;
    public float o = 0.33f;
    public boolean s = false;
    public Runnable y = new d();
    public View.OnClickListener z = new e();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.p.Q4();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnDismissListener {
        public b(c cVar) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    /* renamed from: d.b.i0.c2.k.e.c1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1152c implements Runnable {
        public RunnableC1152c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.m != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.a(c.this.m, c.this.p.getPageContext().getPageActivity()))));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d();
        }
    }

    /* loaded from: classes4.dex */
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
        double d2 = k;
        Double.isNaN(d2);
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds102) + ((int) (d2 * 0.07d));
        this.w = g3;
        if (g3 - g2 > 0) {
            this.w = g3 - g2;
        }
        this.x = (k - (this.w * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.f52648a = navigationBar;
        navigationBar.setOnClickListener(new a());
        this.f52648a.hideBottomLine();
        this.f52653f = this.f52648a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.T1);
        this.f52650c = this.f52648a.setCenterTextTitle("");
        this.f52654g = (ImageView) this.f52648a.getCenterImgBox();
        this.f52655h = (LinearLayout) this.f52648a.getCenterImgBoxLayout();
        int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.f52655h.setPadding(g4, 0, g4, 0);
        ImageView imageView = this.f52654g;
        int i = R.drawable.icon_pb_play_small;
        SkinManager.setNavbarIconSrc(imageView, i, i);
        this.f52654g.setVisibility(8);
        this.f52650c.setOnClickListener(pbFragment.T1);
        this.f52654g.setOnClickListener(pbFragment.T1);
        this.r = (ImageView) this.f52653f.findViewById(R.id.widget_navi_back_button);
        if (this.i == null) {
            LinearLayout linearLayout = (LinearLayout) this.f52648a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.pb_nav_title_forum_image);
            this.j = barImageView;
            barImageView.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.j.setStrokeColorResId(R.color.CAM_X0401);
            this.j.setOnClickListener(pbFragment.T1);
            TextView textView = (TextView) this.i.findViewById(R.id.pb_nav_title_forum_name);
            this.k = textView;
            textView.setOnClickListener(pbFragment.T1);
            if (this.i.getLayoutParams() != null && (this.i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
                int i2 = this.w;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
                this.i.setLayoutParams(marginLayoutParams);
            }
            if (this.i.getVisibility() == 8) {
                this.i.setVisibility(0);
            }
            if (this.i.getAlpha() != 1.0f) {
                this.i.setAlpha(1.0f);
            }
        }
    }

    public void A() {
        View view = this.f52651d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void B(String str, String str2) {
        if (this.p == null || this.i == null) {
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
            this.j.W(str2, 10, false);
        }
        q();
    }

    public final void C() {
        d0 d0Var = this.n;
        if (d0Var == null) {
            return;
        }
        d0Var.x();
    }

    public final void d() {
        g.c(this.t);
    }

    public void e() {
        if (this.q == null) {
            this.q = new RunnableC1152c();
        }
        d.b.b.e.m.e.a().postDelayed(this.q, 100L);
    }

    public void f() {
        AlertDialog alertDialog = this.m;
        if (alertDialog != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!g.a(alertDialog, this.p.getPageContext().getPageActivity()))));
        }
    }

    public d0 g() {
        return this.n;
    }

    public View h() {
        return this.f52654g;
    }

    public NavigationBar i() {
        return this.f52648a;
    }

    public void j() {
        if (this.y != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.y);
        }
        d();
    }

    public void k() {
        this.r.setVisibility(0);
        r(false);
        View view = this.f52651d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public boolean l() {
        AlertDialog alertDialog = this.m;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void m(int i) {
        NavigationBar navigationBar = this.f52648a;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.p.getPageContext(), i);
            SkinManager.setBackgroundResource(this.f52648a.getBarBgView(), R.color.CAM_X0207);
        }
        BarImageView barImageView = this.j;
        if (barImageView != null) {
            barImageView.invalidate();
        }
        WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.f52652e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        SkinManager.setNavbarTitleColor(this.f52650c, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        q();
        C();
    }

    public void n(int i) {
        this.f52648a.onChangeSkinType(this.p.getPageContext(), i);
        this.f52648a.getBackground().mutate().setAlpha(0);
        this.f52648a.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.f52648a.getTopCoverBgView().setVisibility(0);
        this.f52648a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
        this.f52650c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
        WebPManager.setPureDrawable(this.f52652e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void o(View view) {
    }

    public void p() {
        d0 d0Var = this.n;
        if (d0Var != null) {
            d0Var.w();
        }
        this.m = null;
        this.n = null;
        d.b.b.e.m.e.a().removeCallbacks(this.q);
    }

    public final void q() {
        if (this.i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.i);
            a2.h(R.string.J_X07);
            a2.c(R.color.CAM_X0209);
            return;
        }
        this.i.setBackgroundResource(0);
    }

    public void r(boolean z) {
        if (!this.f52649b && z && !"".equals(this.f52650c.getText().toString())) {
            this.f52650c.setVisibility(0);
        } else {
            this.f52650c.setVisibility(8);
        }
    }

    public void s(boolean z) {
        this.s = z;
    }

    public void t(boolean z) {
        if (z) {
            this.f52653f.setVisibility(0);
        } else {
            this.f52653f.setVisibility(8);
        }
        r(z);
    }

    public void u() {
        if ((!this.s || TbadkCoreApplication.isLogin()) && !d.b.h0.r.d0.b.i().g("show_share", false)) {
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
            View view = this.f52651d;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.f52651d;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void w(e0 e0Var) {
        if (this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new d0(pbFragment, pbFragment.T1);
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
        window.setContentView(this.n.u());
        window.setDimAmount(this.o);
        this.n.L(e0Var == null ? false : e0Var.f52668a);
        this.n.z(e0Var == null ? false : e0Var.f52672e);
        this.n.F(e0Var == null ? false : e0Var.i);
        this.n.A(e0Var == null ? false : e0Var.f52673f);
        this.n.O(e0Var != null ? e0Var.f52670c : true);
        this.n.K(e0Var == null ? false : e0Var.k);
        if (e0Var == null) {
            this.n.I(false, false);
            this.n.G(false, false);
        } else {
            this.n.I(e0Var.f52674g, e0Var.p);
            this.n.G(e0Var.f52675h, e0Var.o);
        }
        boolean z = e0Var == null ? false : e0Var.n;
        boolean z2 = e0Var == null ? false : e0Var.l;
        boolean z3 = e0Var == null ? false : e0Var.f52671d;
        boolean z4 = e0Var == null ? false : e0Var.f52669b;
        boolean z5 = e0Var == null ? false : e0Var.m;
        boolean z6 = e0Var == null ? false : e0Var.j;
        this.n.B(z3, z2);
        this.n.M(z4, z);
        this.n.J(z6, z5);
        if (e0Var != null) {
            d0 d0Var = this.n;
            boolean z7 = e0Var.q;
            d0Var.u = z7;
            if (z7) {
                d0Var.f().setText(R.string.report_text);
                this.n.A(false);
            }
        }
        this.n.y(e0Var == null ? false : e0Var.r);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.L() != null && this.p.L().y0() != null && this.p.L().y0().N() != null && this.p.L().y0().N().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.d().setText(R.string.have_called_fans_short);
        }
        C();
        this.n.Q(e0Var != null ? e0Var.s : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void x(String str) {
        if (!TextUtils.isEmpty(str) && !this.f52649b) {
            this.f52650c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
            r(true);
            k.c().h(str);
            return;
        }
        r(false);
    }

    public void y(boolean z) {
        NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
        this.f52649b = z;
        if (this.f52651d == null && this.f52652e == null) {
            View addCustomView = this.f52648a.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.p.T1);
            this.f52651d = addCustomView;
            this.f52652e = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int i = this.u;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.rightMargin = this.v;
            this.f52651d.setLayoutParams(layoutParams);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f52652e, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f52651d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public void z(boolean z) {
        View view = this.f52651d;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
