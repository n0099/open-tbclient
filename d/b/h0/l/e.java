package d.b.h0.l;

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
import d.b.c.e.m.g;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.u3.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public BaseWebViewActivity f50664a;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f50666c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f50667d;

    /* renamed from: e  reason: collision with root package name */
    public View f50668e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f50669f;

    /* renamed from: g  reason: collision with root package name */
    public View f50670g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f50671h;
    public ImageView i;
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
    public d.b.i0.f2.e w;
    public View y;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f50665b = null;
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
            if (e.this.f50664a != null) {
                if (((e.this.f50664a instanceof TbWebViewActivity) && ((TbWebViewActivity) e.this.f50664a).isDisableGoBack && ((TbWebViewActivity) e.this.f50664a).needDealClickGoBack()) || e.this.f50664a.webViewGoBack()) {
                    return;
                }
                e.this.f50664a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f50664a != null) {
                e.this.f50664a.finish();
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

    /* renamed from: d.b.h0.l.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1081e implements a.d {
        public C1081e() {
        }

        @Override // d.b.i0.u3.a.d
        public void onClick() {
            if (e.this.w == null || e.this.f50664a == null) {
                return;
            }
            e.this.w.dismiss();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(e.this.f50664a).createNormalCfg(e.this.f50664a.getResources().getString(R.string.user_feedback), null);
            createNormalCfg.setCallFrom(12);
            e.this.f50664a.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.c {
        public f() {
        }

        @Override // d.b.i0.u3.a.c
        public void onClick() {
            if (e.this.w == null) {
                return;
            }
            e.this.w.dismiss();
        }
    }

    public e(BaseWebViewActivity baseWebViewActivity) {
        this.f50664a = baseWebViewActivity;
        k();
    }

    public void A() {
        LinearLayout linearLayout = this.k;
        if (linearLayout != null) {
            linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        NavigationBar navigationBar = this.f50666c;
        if (navigationBar == null || this.i == null || this.j == null) {
            return;
        }
        navigationBar.setBackgroundDrawable(null);
        this.f50666c.setBackgroundColor(R.color.transparent);
        this.f50666c.setBackgroundResource(R.drawable.transparent_bg);
        this.i.setVisibility(8);
        this.j.setVisibility(0);
        this.j.setOnClickListener(this.f50664a);
        this.f50667d.setTextColor(-1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.width = l.g(this.f50664a, R.dimen.tbds100);
        layoutParams.height = l.g(this.f50664a, R.dimen.tbds100);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50671h, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50669f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
            d.b.i0.u3.a aVar = new d.b.i0.u3.a(this.f50664a);
            ArrayList arrayList = new ArrayList();
            a.b bVar = new a.b(this.f50664a.getString(R.string.report_text), aVar);
            bVar.h(new C1081e());
            arrayList.add(bVar);
            aVar.h(new f());
            aVar.g(arrayList);
            d.b.i0.f2.e eVar = new d.b.i0.f2.e(this.f50664a, aVar.b());
            this.w = eVar;
            eVar.a(0.7f);
        }
        this.w.show();
    }

    public void E() {
        ImageView imageView;
        NavigationBar navigationBar = this.f50666c;
        if (navigationBar == null || navigationBar.getVisibility() != 0 || (imageView = this.f50671h) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void F() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.n == null) {
            this.n = NoDataViewFactory.a(this.f50664a.getPageContext().getPageActivity(), this.f50665b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.e.d(null, this.f50664a.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f50664a.getResources().getString(R.string.refresh), this.o)));
        }
        if (!j.A()) {
            this.n.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, a2), this.f50664a.getPageContext());
        } else {
            this.n.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), this.f50664a.getPageContext());
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
        TiebaStatic.eventStat(this.f50664a.getPageContext().getPageActivity(), "share", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        if (shareItem.m) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f50664a, shareItem, true, (SparseArray<String>) null);
            shareDialogConfig.mShowMoreForumShare = true;
            d.b.i0.b0.f.b().k(shareDialogConfig);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.f50664a, shareItem, true, g())));
    }

    public void J(boolean z, String str) {
        BdTopToast bdTopToast = new BdTopToast(this.f50664a);
        bdTopToast.i(z);
        bdTopToast.h(str);
        bdTopToast.j(this.f50665b);
    }

    public void e() {
        g.d(this.q, this.f50664a.getPageContext().getPageActivity());
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
        this.f50664a.setContentView(R.layout.base_webview_activity_new);
        this.f50665b = (ViewGroup) this.f50664a.findViewById(R.id.root_view);
        this.f50666c = (NavigationBar) this.f50664a.findViewById(R.id.view_navigation_bar);
        this.y = this.f50664a.findViewById(R.id.night_mode_overlay);
        this.f50666c.showBottomLine();
        w("");
        if (this.f50664a.isTranslucent()) {
            SkinManager.setBackgroundColor(this.f50665b, this.f50664a.getResources().getColor(R.color.black_alpha0));
            this.f50665b.setOnClickListener(this.f50664a);
            this.f50666c.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) this.f50664a.findViewById(R.id.webview_container);
        this.k = linearLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.k.setLayoutParams(layoutParams);
        this.l = (TextView) this.f50664a.findViewById(R.id.webview_crash_tip);
        ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.f50664a.findViewById(R.id.webview_progress);
        this.m = continuousAnimationView;
        SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
        View addCustomView = this.f50666c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new a());
        this.f50668e = addCustomView;
        ImageView imageView = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
        this.f50669f = imageView;
        imageView.setContentDescription(this.f50664a.getResources().getString(R.string.back));
        View addCustomView2 = this.f50666c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new b());
        this.f50670g = addCustomView2;
        ImageView imageView2 = (ImageView) addCustomView2.findViewById(R.id.widget_navi_back_button);
        this.f50671h = imageView2;
        imageView2.setContentDescription(this.f50664a.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f50671h.getLayoutParams();
        layoutParams2.leftMargin = l.g(this.f50664a.getPageContext().getPageActivity(), R.dimen.ds4);
        this.f50671h.setLayoutParams(layoutParams2);
        View addCustomView3 = this.f50666c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new c());
        this.p = addCustomView3;
        this.i = (ImageView) addCustomView3.findViewById(R.id.widget_navi_more_button);
        this.j = (ImageView) this.p.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.f50664a.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.q = new MorePopupWindow(this.f50664a.getPageContext().getPageActivity(), inflate, this.f50666c, this.f50664a.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new d());
        View findViewById = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.r = findViewById;
        findViewById.setOnClickListener(this.f50664a);
        if (d.b.h0.s.g.g.e(this.f50664a.getPageContext().getPageActivity())) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
        this.q.refresh();
        View findViewById2 = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.t = findViewById2;
        findViewById2.setOnClickListener(this.f50664a);
        View findViewById3 = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.s = findViewById3;
        findViewById3.setOnClickListener(this.f50664a);
    }

    public boolean l() {
        try {
            this.k.addView(this.f50664a.createWebView());
            this.l.setVisibility(8);
            if (this.u) {
                return true;
            }
            this.f50666c.setStatusBarVisibility(8);
            return true;
        } catch (Exception e2) {
            this.l.setVisibility(0);
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean m() {
        NavigationBar navigationBar = this.f50666c;
        return navigationBar != null && navigationBar.getVisibility() == 0;
    }

    public void n(int i) {
        ContinuousAnimationView continuousAnimationView = this.m;
        if (continuousAnimationView != null) {
            SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
        }
        MorePopupWindow morePopupWindow = this.q;
        if (morePopupWindow != null) {
            morePopupWindow.onChangeSkinType(this.f50664a, i, SkinManager.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        NoDataView noDataView = this.n;
        if (noDataView != null) {
            noDataView.f(this.f50664a.getPageContext(), i);
        }
        if (this.x) {
            if (i == 1) {
                this.y.setVisibility(0);
                return;
            }
            return;
        }
        NavigationBar navigationBar = this.f50666c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f50664a.getPageContext(), i);
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50669f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50671h, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void o() {
        LinearLayout linearLayout = this.k;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        NavigationBar navigationBar = this.f50666c;
        if (navigationBar != null) {
            navigationBar.release();
        }
        MorePopupWindow morePopupWindow = this.q;
        if (morePopupWindow != null) {
            g.d(morePopupWindow, this.f50664a.getPageContext().getPageActivity());
        }
    }

    public void p() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.k.setLayoutParams(layoutParams);
        ImageView imageView = this.f50669f;
        if (imageView != null) {
            imageView.setBackgroundDrawable(null);
        }
        ImageView imageView2 = this.f50671h;
        if (imageView2 != null) {
            imageView2.setBackgroundDrawable(null);
        }
        ImageView imageView3 = this.i;
        if (imageView3 != null) {
            imageView3.setBackgroundDrawable(null);
        }
        ImageView imageView4 = this.j;
        if (imageView4 != null) {
            imageView4.setBackgroundDrawable(null);
        }
        NavigationBar navigationBar = this.f50666c;
        if (navigationBar != null) {
            navigationBar.showBottomLine(true);
        }
        BaseWebViewActivity baseWebViewActivity = this.f50664a;
        if (baseWebViewActivity != null) {
            baseWebViewActivity.getWindow().clearFlags(1024);
        }
    }

    public void q() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.k.setLayoutParams(layoutParams);
        NavigationBar navigationBar = this.f50666c;
        if (navigationBar != null) {
            navigationBar.getBackground().mutate().setAlpha(0);
            this.f50666c.showBottomLine(false);
        }
        SkinManager.setBackgroundResource(this.f50669f, R.drawable.frs_star_navigation_bg);
        SkinManager.setBackgroundResource(this.f50671h, R.drawable.frs_star_navigation_bg);
        SkinManager.setBackgroundResource(this.i, R.drawable.frs_star_navigation_bg);
        SkinManager.setBackgroundResource(this.j, R.drawable.frs_star_navigation_bg);
        w("");
        this.f50664a.getWindow().setFlags(1024, 1024);
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
            this.f50666c.setVisibility(0);
            return;
        }
        this.k.getLayoutParams().height = -1;
        this.f50666c.setVisibility(8);
    }

    public void u(int i) {
        ImageView imageView;
        if (this.f50666c == null || (imageView = this.i) == null) {
            return;
        }
        imageView.setVisibility(i);
    }

    public void v() {
        ImageView imageView;
        if (this.f50666c == null || (imageView = this.i) == null || this.j == null) {
            return;
        }
        imageView.setVisibility(8);
        this.j.setVisibility(0);
        this.j.setOnClickListener(this.f50664a);
    }

    public void w(String str) {
        ImageView imageView;
        NavigationBar navigationBar = this.f50666c;
        if (navigationBar != null) {
            this.f50667d = navigationBar.setCenterTextTitle(str);
            ImageView imageView2 = this.f50669f;
            if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.f50671h) != null && imageView.getVisibility() == 0) {
                this.f50667d.setMaxWidth(l.g(this.f50664a.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.x) {
                SkinManager.setNavbarTitleColor(this.f50667d, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                this.f50667d.setTextColor(-1);
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
