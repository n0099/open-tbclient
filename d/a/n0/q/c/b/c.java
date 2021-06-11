package d.a.n0.q.c.b;

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
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import d.a.n0.q.d.e;
import d.a.n0.q.d.h.d;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public View f61877b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseWebViewActivity f61878c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61879d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61880e;

    /* renamed from: f  reason: collision with root package name */
    public View f61881f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f61882g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f61883h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f61884i;
    public LinearLayout j;
    public TextView k;
    public NoDataView l;
    public View.OnClickListener m;
    public View n;
    public MorePopupWindow o;
    public ApkDownloadBannerView p;
    public String t;
    public String u;
    public d.a.n0.q.c.b.d.a v;

    /* renamed from: a  reason: collision with root package name */
    public View f61876a = null;
    public DownloadCacheKey q = null;
    public d r = null;
    public boolean s = true;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f61878c == null || c.this.f61878c.webViewGoBack()) {
                return;
            }
            c.this.f61878c.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c.this.p();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            c.this.F();
        }
    }

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        this.f61878c = adBaseWebViewActivity;
        j();
    }

    public void A(boolean z) {
        this.s = z;
    }

    public void B() {
        this.k.setVisibility(0);
    }

    public void C() {
        if (this.l == null) {
            this.l = NoDataViewFactory.a(this.f61878c.getPageContext().getPageActivity(), this.f61876a, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.e.d(null, this.f61878c.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f61878c.getResources().getString(R.string.refresh), this.m)));
        }
        this.l.f(this.f61878c.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.j.setVisibility(8);
        this.l.setVisibility(0);
    }

    public void D() {
    }

    public void E(ShareItem shareItem) {
        if (shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.f61878c.getPageContext().getPageActivity(), "share", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.f61878c.getPageContext().getPageActivity(), shareItem, true, e())));
    }

    public final void F() {
        e.c().q(this.q, this.r);
    }

    public void d() {
        g.d(this.o, this.f61878c.getPageContext().getPageActivity());
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
        l.g(this.f61878c.getPageContext().getPageActivity(), R.dimen.ds98);
        int i2 = l.q(this.f61878c.getPageContext().getPageActivity()).heightPixels;
    }

    public final void j() {
        this.f61878c.setContentView(R.layout.base_ad_webview_activity);
        this.f61876a = this.f61878c.findViewById(R.id.root_view);
        this.f61879d = (NavigationBar) this.f61878c.findViewById(R.id.view_navigation_bar);
        x("");
        this.j = (LinearLayout) this.f61878c.findViewById(R.id.webview_container);
        this.p = (ApkDownloadBannerView) this.f61878c.findViewById(R.id.web_banner_download);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.j.setLayoutParams(layoutParams);
        this.k = (TextView) this.f61878c.findViewById(R.id.webview_crash_tip);
        View addCustomView = this.f61879d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new a());
        this.f61881f = addCustomView;
        ImageView imageView = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
        this.f61882g = imageView;
        imageView.setContentDescription(this.f61878c.getResources().getString(R.string.back));
        this.f61876a.addOnAttachStateChangeListener(new b());
        i();
    }

    public boolean k() {
        try {
            this.j.addView(this.f61878c.createWebView());
            this.k.setVisibility(8);
            if (this.s) {
                return true;
            }
            this.f61879d.setStatusBarVisibility(8);
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
            AdDownloadData b2 = e.c().b(downloadCacheKey);
            b2.setPage("LANDING_PAGE");
            b2.setExtInfo(this.t);
            b2.setDeeplinkUrl(this.u);
            d.a.n0.q.c.b.d.a aVar = new d.a.n0.q.c.b.d.a(this.p, b2);
            this.v = aVar;
            this.r = new d.a.n0.q.d.h.b(aVar);
            if (b2.extra().getPercent() > 0) {
                this.v.e(b2);
            }
        }
        p();
    }

    public boolean m() {
        NavigationBar navigationBar = this.f61879d;
        return navigationBar != null && navigationBar.getVisibility() == 0;
    }

    public void n(int i2) {
        NavigationBar navigationBar = this.f61879d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f61878c.getPageContext(), i2);
        }
        MorePopupWindow morePopupWindow = this.o;
        if (morePopupWindow != null) {
            morePopupWindow.onChangeSkinType(this.f61878c, i2, SkinManager.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        NoDataView noDataView = this.l;
        if (noDataView != null) {
            noDataView.f(this.f61878c.getPageContext(), i2);
        }
        SkinManager.setNavbarIconSrc(this.f61882g, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i2);
        SkinManager.setNavbarIconSrc(this.f61883h, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i2);
        SkinManager.setNavbarIconSrc(this.f61884i, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i2);
    }

    public void o() {
        d.a.n0.q.c.b.d.a aVar = this.v;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void p() {
        if (this.q == null || this.r == null) {
            return;
        }
        e.c().i(this.q, this.r);
    }

    public void q() {
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        NavigationBar navigationBar = this.f61879d;
        if (navigationBar != null) {
            navigationBar.release();
        }
        MorePopupWindow morePopupWindow = this.o;
        if (morePopupWindow != null) {
            g.d(morePopupWindow, this.f61878c.getPageContext().getPageActivity());
        }
    }

    public void r() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.j.setLayoutParams(layoutParams);
        this.f61882g.setBackgroundDrawable(null);
        this.f61883h.setBackgroundDrawable(null);
        this.f61884i.setBackgroundDrawable(null);
        this.f61879d.showBottomLine(true);
        this.f61878c.getWindow().clearFlags(1024);
    }

    public void s(String str) {
        this.u = str;
    }

    public void t(String str) {
        this.t = str;
    }

    public void u() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.j.setLayoutParams(layoutParams);
        this.f61879d.getBackground().mutate().setAlpha(0);
        this.f61879d.showBottomLine(false);
        SkinManager.setBackgroundResource(this.f61882g, R.drawable.frs_star_navigation_bg);
        SkinManager.setBackgroundResource(this.f61883h, R.drawable.frs_star_navigation_bg);
        SkinManager.setBackgroundResource(this.f61884i, R.drawable.frs_star_navigation_bg);
        x("");
        this.f61878c.getWindow().setFlags(1024, 1024);
    }

    public void v(boolean z) {
        View view = this.n;
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void w(boolean z) {
        if (z) {
            this.f61879d.setVisibility(0);
        } else {
            this.f61879d.setVisibility(8);
        }
        this.j.getLayoutParams().height = -1;
    }

    public void x(String str) {
        ImageView imageView;
        this.f61880e = this.f61879d.setCenterTextTitle(str);
        ImageView imageView2 = this.f61882g;
        if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.f61883h) != null && imageView.getVisibility() == 0) {
            this.f61880e.setMaxWidth(l.g(this.f61878c.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        SkinManager.setNavbarTitleColor(this.f61880e, R.color.CAM_X0105, R.color.s_navbar_title_color);
    }

    public void y(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void z(boolean z) {
        View view = this.f61877b;
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
}
