package d.a.m0.l;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import d.a.c.e.m.g;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.n0.v3.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public BaseWebViewActivity f53130a;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f53132c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53133d;

    /* renamed from: e  reason: collision with root package name */
    public View f53134e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f53135f;

    /* renamed from: g  reason: collision with root package name */
    public View f53136g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f53137h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f53138i;
    public ImageView j;
    public LinearLayout k;
    public TextView l;
    public NoDataView n;
    public View.OnClickListener o;
    public View p;
    public MorePopupWindow q;
    public View r;
    public View s;
    public View t;
    public d.a.n0.g2.e w;
    public View y;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f53131b = null;
    public ContinuousAnimationView m = null;
    public boolean u = true;
    public boolean v = false;
    public boolean x = false;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f53130a != null) {
                if (((e.this.f53130a instanceof TbWebViewActivity) && ((TbWebViewActivity) e.this.f53130a).isDisableGoBack && ((TbWebViewActivity) e.this.f53130a).needDealClickGoBack()) || e.this.f53130a.webViewGoBack()) {
                    return;
                }
                e.this.f53130a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f53130a != null) {
                e.this.f53130a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f()) {
                e.this.D();
            } else if (e.this.j.getVisibility() == 0) {
            } else {
                e.this.G();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements KeyEventDealContainerView.a {
        public d() {
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void a() {
            e.this.G();
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void b() {
        }
    }

    /* renamed from: d.a.m0.l.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1183e implements a.d {
        public C1183e() {
        }

        @Override // d.a.n0.v3.a.d
        public void onClick() {
            if (e.this.w == null || e.this.f53130a == null) {
                return;
            }
            e.this.w.dismiss();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(e.this.f53130a).createNormalCfg(e.this.f53130a.getResources().getString(R.string.user_feedback), null);
            createNormalCfg.setCallFrom(12);
            e.this.f53130a.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.c {
        public f() {
        }

        @Override // d.a.n0.v3.a.c
        public void onClick() {
            if (e.this.w == null) {
                return;
            }
            e.this.w.dismiss();
        }
    }

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.f53130a = baseWebViewActivity;
        k();
    }

    public void A() {
        LinearLayout linearLayout = this.k;
        if (linearLayout != null) {
            linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        NavigationBar navigationBar = this.f53132c;
        if (navigationBar == null || this.f53138i == null || this.j == null) {
            return;
        }
        navigationBar.setBackgroundDrawable(null);
        this.f53132c.setBackgroundColor(R.color.transparent);
        this.f53132c.setBackgroundResource(R.drawable.transparent_bg);
        this.f53138i.setVisibility(8);
        this.j.setVisibility(0);
        this.j.setOnClickListener(this.f53130a);
        this.f53133d.setTextColor(-1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.width = l.g(this.f53130a, R.dimen.tbds100);
        layoutParams.height = l.g(this.f53130a, R.dimen.tbds100);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f53137h, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f53135f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void B(boolean z) {
        this.u = z;
    }

    public void C() {
        this.l.setVisibility(0);
    }

    public final void D() {
        if (this.w == null) {
            d.a.n0.v3.a aVar = new d.a.n0.v3.a(this.f53130a);
            ArrayList arrayList = new ArrayList();
            a.b bVar = new a.b(this.f53130a.getString(R.string.report_text), aVar);
            bVar.h(new C1183e());
            arrayList.add(bVar);
            aVar.h(new f());
            aVar.g(arrayList);
            d.a.n0.g2.e eVar = new d.a.n0.g2.e(this.f53130a, aVar.b());
            this.w = eVar;
            eVar.a(0.7f);
        }
        this.w.show();
    }

    public void E() {
        ImageView imageView;
        NavigationBar navigationBar = this.f53132c;
        if (navigationBar == null || navigationBar.getVisibility() != 0 || (imageView = this.f53137h) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void F() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.n == null) {
            this.n = NoDataViewFactory.a(this.f53130a.getPageContext().getPageActivity(), this.f53131b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.e.d(null, this.f53130a.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f53130a.getResources().getString(R.string.refresh), this.o)));
        }
        if (!j.A()) {
            this.n.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, a2), this.f53130a.getPageContext());
        } else {
            this.n.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), this.f53130a.getPageContext());
        }
        this.k.setVisibility(8);
        this.n.setVisibility(0);
    }

    public void G() {
        this.q.showWindowInRightBottomOfHost();
    }

    public void H() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.m.setVisibility(0);
            this.m.playAnimation();
        }
    }

    public void I(ShareItem shareItem) {
        if (shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.f53130a.getPageContext().getPageActivity(), "share", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        if (shareItem.m) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f53130a, shareItem, true, (SparseArray<String>) null);
            shareDialogConfig.mShowMoreForumShare = true;
            d.a.n0.d0.f.b().k(shareDialogConfig);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.f53130a, shareItem, true, g())));
    }

    public void J(boolean z, String str) {
        BdTopToast bdTopToast = new BdTopToast(this.f53130a);
        bdTopToast.i(z);
        bdTopToast.h(str);
        bdTopToast.j(this.f53131b);
    }

    public void e() {
        g.d(this.q, this.f53130a.getPageContext().getPageActivity());
    }

    public boolean f() {
        return this.v;
    }

    public final SparseArray<String> g() {
        SparseArray<String> sparseArray = new SparseArray<>(8);
        sparseArray.put(2, "pb_wx_timeline");
        sparseArray.put(3, "pb_wx_friend");
        sparseArray.put(4, "pb_qq_zone");
        sparseArray.put(5, "pb_tencent_weibo");
        sparseArray.put(6, "pb_sina_weibo");
        sparseArray.put(7, "pb_renren");
        return sparseArray;
    }

    public void h() {
        this.l.setVisibility(8);
    }

    public void i() {
        NoDataView noDataView = this.n;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.k.setVisibility(0);
        }
    }

    public void j() {
        this.m.setVisibility(8);
        this.m.cancelAnimation();
    }

    public final void k() {
        this.f53130a.setContentView(R.layout.base_webview_activity_new);
        this.f53131b = (ViewGroup) this.f53130a.findViewById(R.id.root_view);
        this.f53132c = (NavigationBar) this.f53130a.findViewById(R.id.view_navigation_bar);
        this.y = this.f53130a.findViewById(R.id.night_mode_overlay);
        this.f53132c.showBottomLine();
        w("");
        if (this.f53130a.isTranslucent()) {
            SkinManager.setBackgroundColor(this.f53131b, this.f53130a.getResources().getColor(R.color.black_alpha0));
            this.f53131b.setOnClickListener(this.f53130a);
            this.f53132c.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) this.f53130a.findViewById(R.id.webview_container);
        this.k = linearLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.k.setLayoutParams(layoutParams);
        this.l = (TextView) this.f53130a.findViewById(R.id.webview_crash_tip);
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.f53130a.findViewById(R.id.webview_progress);
        this.m = continuousAnimationView;
        SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
        View addCustomView = this.f53132c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new a());
        this.f53134e = addCustomView;
        ImageView imageView = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
        this.f53135f = imageView;
        imageView.setContentDescription(this.f53130a.getResources().getString(R.string.back));
        View addCustomView2 = this.f53132c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new b());
        this.f53136g = addCustomView2;
        ImageView imageView2 = (ImageView) addCustomView2.findViewById(R.id.widget_navi_back_button);
        this.f53137h = imageView2;
        imageView2.setContentDescription(this.f53130a.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f53137h.getLayoutParams();
        layoutParams2.leftMargin = l.g(this.f53130a.getPageContext().getPageActivity(), R.dimen.ds4);
        this.f53137h.setLayoutParams(layoutParams2);
        View addCustomView3 = this.f53132c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new c());
        this.p = addCustomView3;
        this.f53138i = (ImageView) addCustomView3.findViewById(R.id.widget_navi_more_button);
        this.j = (ImageView) this.p.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.f53130a.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.q = new MorePopupWindow(this.f53130a.getPageContext().getPageActivity(), inflate, this.f53132c, this.f53130a.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new d());
        View findViewById = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.r = findViewById;
        findViewById.setOnClickListener(this.f53130a);
        if (d.a.m0.s.g.g.e(this.f53130a.getPageContext().getPageActivity())) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
        this.q.refresh();
        View findViewById2 = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.t = findViewById2;
        findViewById2.setOnClickListener(this.f53130a);
        View findViewById3 = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.s = findViewById3;
        findViewById3.setOnClickListener(this.f53130a);
    }

    public boolean l() {
        try {
            this.k.addView(this.f53130a.createWebView());
            this.l.setVisibility(8);
            if (this.u) {
                return true;
            }
            this.f53132c.setStatusBarVisibility(8);
            return true;
        } catch (Exception e2) {
            this.l.setVisibility(0);
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean m() {
        NavigationBar navigationBar = this.f53132c;
        return navigationBar != null && navigationBar.getVisibility() == 0;
    }

    public void n(int i2) {
        ContinuousAnimationView continuousAnimationView = this.m;
        if (continuousAnimationView != null) {
            SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
        }
        MorePopupWindow morePopupWindow = this.q;
        if (morePopupWindow != null) {
            morePopupWindow.onChangeSkinType(this.f53130a, i2, SkinManager.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        NoDataView noDataView = this.n;
        if (noDataView != null) {
            noDataView.f(this.f53130a.getPageContext(), i2);
        }
        if (this.x) {
            if (i2 == 1) {
                this.y.setVisibility(0);
                return;
            }
            return;
        }
        NavigationBar navigationBar = this.f53132c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f53130a.getPageContext(), i2);
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f53135f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f53137h, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f53138i, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void o() {
        LinearLayout linearLayout = this.k;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        NavigationBar navigationBar = this.f53132c;
        if (navigationBar != null) {
            navigationBar.release();
        }
        MorePopupWindow morePopupWindow = this.q;
        if (morePopupWindow != null) {
            g.d(morePopupWindow, this.f53130a.getPageContext().getPageActivity());
        }
    }

    public void p() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.k.setLayoutParams(layoutParams);
        ImageView imageView = this.f53135f;
        if (imageView != null) {
            imageView.setBackgroundDrawable(null);
        }
        ImageView imageView2 = this.f53137h;
        if (imageView2 != null) {
            imageView2.setBackgroundDrawable(null);
        }
        ImageView imageView3 = this.f53138i;
        if (imageView3 != null) {
            imageView3.setBackgroundDrawable(null);
        }
        ImageView imageView4 = this.j;
        if (imageView4 != null) {
            imageView4.setBackgroundDrawable(null);
        }
        NavigationBar navigationBar = this.f53132c;
        if (navigationBar != null) {
            navigationBar.showBottomLine(true);
        }
        BaseWebViewActivity baseWebViewActivity = this.f53130a;
        if (baseWebViewActivity != null) {
            baseWebViewActivity.getWindow().clearFlags(1024);
        }
    }

    public void q() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.k.setLayoutParams(layoutParams);
        NavigationBar navigationBar = this.f53132c;
        if (navigationBar != null) {
            navigationBar.getBackground().mutate().setAlpha(0);
            this.f53132c.showBottomLine(false);
        }
        SkinManager.setBackgroundResource(this.f53135f, R.drawable.frs_star_navigation_bg);
        SkinManager.setBackgroundResource(this.f53137h, R.drawable.frs_star_navigation_bg);
        SkinManager.setBackgroundResource(this.f53138i, R.drawable.frs_star_navigation_bg);
        SkinManager.setBackgroundResource(this.j, R.drawable.frs_star_navigation_bg);
        w("");
        this.f53130a.getWindow().setFlags(1024, 1024);
    }

    public void r(boolean z) {
        this.v = z;
    }

    public void s(boolean z) {
        View view = this.p;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void t(boolean z) {
        if (z) {
            this.k.getLayoutParams().height = -1;
            this.f53132c.setVisibility(0);
            return;
        }
        this.k.getLayoutParams().height = -1;
        this.f53132c.setVisibility(8);
    }

    public void u(int i2) {
        ImageView imageView;
        if (this.f53132c == null || (imageView = this.f53138i) == null) {
            return;
        }
        imageView.setVisibility(i2);
    }

    public void v() {
        ImageView imageView;
        if (this.f53132c == null || (imageView = this.f53138i) == null || this.j == null) {
            return;
        }
        imageView.setVisibility(8);
        this.j.setVisibility(0);
        this.j.setOnClickListener(this.f53130a);
    }

    public void w(String str) {
        ImageView imageView;
        NavigationBar navigationBar = this.f53132c;
        if (navigationBar != null) {
            this.f53133d = navigationBar.setCenterTextTitle(str);
            ImageView imageView2 = this.f53135f;
            if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.f53137h) != null && imageView.getVisibility() == 0) {
                this.f53133d.setMaxWidth(l.g(this.f53130a.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.x) {
                SkinManager.setNavbarTitleColor(this.f53133d, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                this.f53133d.setTextColor(-1);
            }
        }
    }

    public void x(View.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    public void y(boolean z) {
        View view = this.r;
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
            s(true);
        } else {
            view.setVisibility(8);
            s(false);
        }
        this.q.refresh();
    }

    public void z() {
        this.x = true;
        A();
    }
}
