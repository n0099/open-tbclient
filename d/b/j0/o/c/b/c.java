package d.b.j0.o.c.b;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.browser.newstyle.AdBaseWebViewActivity;
import com.baidu.tieba.ad.browser.newstyle.view.ApkDownloadBannerView;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import d.b.c.e.m.g;
import d.b.c.e.p.l;
import d.b.j0.o.d.g.d;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public View f59040b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseWebViewActivity f59041c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f59042d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59043e;

    /* renamed from: f  reason: collision with root package name */
    public View f59044f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59045g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f59046h;
    public ImageView i;
    public LinearLayout j;
    public TextView k;
    public NoDataView l;
    public View.OnClickListener m;
    public View n;
    public MorePopupWindow o;
    public ApkDownloadBannerView p;
    public String t;
    public String u;

    /* renamed from: a  reason: collision with root package name */
    public View f59039a = null;
    public DownloadCacheKey q = null;
    public d r = null;
    public boolean s = true;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f59041c == null || c.this.f59041c.webViewGoBack()) {
                return;
            }
            c.this.f59041c.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c.this.o();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            c.this.E();
        }
    }

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.f59041c = adBaseWebViewActivity;
        j();
    }

    public void A() {
        this.k.setVisibility(0);
    }

    public void B() {
        if (this.l == null) {
            this.l = NoDataViewFactory.a(this.f59041c.getPageContext().getPageActivity(), this.f59039a, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.e.d(null, this.f59041c.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f59041c.getResources().getString(R.string.refresh), this.m)));
        }
        this.l.f(this.f59041c.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.j.setVisibility(8);
        this.l.setVisibility(0);
    }

    public void C() {
    }

    public void D(ShareItem shareItem) {
        if (shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.f59041c.getPageContext().getPageActivity(), "share", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.f59041c.getPageContext().getPageActivity(), shareItem, true, e())));
    }

    public final void E() {
        d.b.j0.o.d.d.c().q(this.q, this.r);
    }

    public void d() {
        g.d(this.o, this.f59041c.getPageContext().getPageActivity());
    }

    public final SparseArray<String> e() {
        SparseArray<String> sparseArray = new SparseArray<>(8);
        sparseArray.put(2, "pb_wx_timeline");
        sparseArray.put(3, "pb_wx_friend");
        sparseArray.put(4, "pb_qq_zone");
        sparseArray.put(5, "pb_tencent_weibo");
        sparseArray.put(6, "pb_sina_weibo");
        sparseArray.put(7, "pb_renren");
        return sparseArray;
    }

    public void f() {
        this.k.setVisibility(8);
    }

    public void g() {
        NoDataView noDataView = this.l;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.j.setVisibility(0);
        }
    }

    public void h() {
    }

    public final void i() {
        UtilHelper.getStatusBarHeight();
        l.g(this.f59041c.getPageContext().getPageActivity(), R.dimen.ds98);
        int i = l.q(this.f59041c.getPageContext().getPageActivity()).heightPixels;
    }

    public final void j() {
        this.f59041c.setContentView(R.layout.base_ad_webview_activity);
        this.f59039a = this.f59041c.findViewById(R.id.root_view);
        this.f59042d = (NavigationBar) this.f59041c.findViewById(R.id.view_navigation_bar);
        w("");
        this.j = (LinearLayout) this.f59041c.findViewById(R.id.webview_container);
        this.p = (ApkDownloadBannerView) this.f59041c.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.j.setLayoutParams(layoutParams);
        this.k = (TextView) this.f59041c.findViewById(R.id.webview_crash_tip);
        View addCustomView = this.f59042d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new a());
        this.f59044f = addCustomView;
        ImageView imageView = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
        this.f59045g = imageView;
        imageView.setContentDescription(this.f59041c.getResources().getString(R.string.back));
        this.f59039a.addOnAttachStateChangeListener(new b());
        i();
    }

    public boolean k() {
        try {
            this.j.addView(this.f59041c.createWebView());
            this.k.setVisibility(8);
            if (this.s) {
                return true;
            }
            this.f59042d.setStatusBarVisibility(8);
            return true;
        } catch (Exception e2) {
            this.k.setVisibility(0);
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public void l(DownloadCacheKey downloadCacheKey) {
        this.q = downloadCacheKey;
        if (this.r == null) {
            AdDownloadData b2 = d.b.j0.o.d.d.c().b(downloadCacheKey);
            b2.setPage("LANDING_PAGE");
            b2.setExtInfo(this.t);
            b2.setDeeplinkUrl(this.u);
            d.b.j0.o.c.b.d.a aVar = new d.b.j0.o.c.b.d.a(this.p, b2);
            this.r = new d.b.j0.o.d.g.b(aVar);
            if (b2.extra().getPercent() > 0) {
                aVar.d(b2);
            }
        }
        o();
    }

    public boolean m() {
        NavigationBar navigationBar = this.f59042d;
        return navigationBar != null && navigationBar.getVisibility() == 0;
    }

    public void n(int i) {
        NavigationBar navigationBar = this.f59042d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f59041c.getPageContext(), i);
        }
        MorePopupWindow morePopupWindow = this.o;
        if (morePopupWindow != null) {
            morePopupWindow.onChangeSkinType(this.f59041c, i, SkinManager.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        NoDataView noDataView = this.l;
        if (noDataView != null) {
            noDataView.f(this.f59041c.getPageContext(), i);
        }
        SkinManager.setNavbarIconSrc(this.f59045g, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
        SkinManager.setNavbarIconSrc(this.f59046h, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
        SkinManager.setNavbarIconSrc(this.i, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
    }

    public final void o() {
        if (this.q == null || this.r == null) {
            return;
        }
        d.b.j0.o.d.d.c().i(this.q, this.r);
    }

    public void p() {
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        NavigationBar navigationBar = this.f59042d;
        if (navigationBar != null) {
            navigationBar.release();
        }
        MorePopupWindow morePopupWindow = this.o;
        if (morePopupWindow != null) {
            g.d(morePopupWindow, this.f59041c.getPageContext().getPageActivity());
        }
    }

    public void q() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.j.setLayoutParams(layoutParams);
        this.f59045g.setBackgroundDrawable(null);
        this.f59046h.setBackgroundDrawable(null);
        this.i.setBackgroundDrawable(null);
        this.f59042d.showBottomLine(true);
        this.f59041c.getWindow().clearFlags(1024);
    }

    public void r(String str) {
        this.u = str;
    }

    public void s(String str) {
        this.t = str;
    }

    public void t() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.j.setLayoutParams(layoutParams);
        this.f59042d.getBackground().mutate().setAlpha(0);
        this.f59042d.showBottomLine(false);
        SkinManager.setBackgroundResource(this.f59045g, R.drawable.frs_star_navigation_bg);
        SkinManager.setBackgroundResource(this.f59046h, R.drawable.frs_star_navigation_bg);
        SkinManager.setBackgroundResource(this.i, R.drawable.frs_star_navigation_bg);
        w("");
        this.f59041c.getWindow().setFlags(1024, 1024);
    }

    public void u(boolean z) {
        View view = this.n;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void v(boolean z) {
        if (z) {
            this.f59042d.setVisibility(0);
        } else {
            this.f59042d.setVisibility(8);
        }
        this.j.getLayoutParams().height = -1;
    }

    public void w(String str) {
        ImageView imageView;
        this.f59043e = this.f59042d.setCenterTextTitle(str);
        ImageView imageView2 = this.f59045g;
        if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.f59046h) != null && imageView.getVisibility() == 0) {
            this.f59043e.setMaxWidth(l.g(this.f59041c.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        SkinManager.setNavbarTitleColor(this.f59043e, R.color.CAM_X0105, R.color.s_navbar_title_color);
    }

    public void x(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void y(boolean z) {
        View view = this.f59040b;
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
        this.o.refresh();
    }

    public void z(boolean z) {
        this.s = z;
    }
}
