package d.a.p0.q.c.b;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.g;
import d.a.c.e.p.l;
import d.a.p0.q.d.e;
import d.a.p0.q.d.h.d;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f61429a;

    /* renamed from: b  reason: collision with root package name */
    public View f61430b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseWebViewActivity f61431c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61432d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61433e;

    /* renamed from: f  reason: collision with root package name */
    public View f61434f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f61435g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f61436h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f61437i;
    public LinearLayout j;
    public TextView k;
    public NoDataView l;
    public View.OnClickListener m;
    public View n;
    public MorePopupWindow o;
    public ApkDownloadBannerView p;
    public DownloadCacheKey q;
    public d r;
    public boolean s;
    public String t;
    public String u;
    public d.a.p0.q.c.b.d.a v;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61438e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61438e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f61438e.f61431c == null || this.f61438e.f61431c.webViewGoBack()) {
                return;
            }
            this.f61438e.f61431c.finish();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61439e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61439e = cVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f61439e.q();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f61439e.H();
            }
        }
    }

    public c(AdBaseWebViewActivity adBaseWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adBaseWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61429a = null;
        this.q = null;
        this.r = null;
        this.s = true;
        this.f61431c = adBaseWebViewActivity;
        k();
    }

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void B(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (view = this.f61430b) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
        this.o.refresh();
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.s = z;
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.setVisibility(0);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.l == null) {
                this.l = NoDataViewFactory.a(this.f61431c.getPageContext().getPageActivity(), this.f61429a, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.e.d(null, this.f61431c.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f61431c.getResources().getString(R.string.refresh), this.m)));
            }
            this.l.f(this.f61431c.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.j.setVisibility(8);
            this.l.setVisibility(0);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void G(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, shareItem) == null) || shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.f61431c.getPageContext().getPageActivity(), "share", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.f61431c.getPageContext().getPageActivity(), shareItem, true, f())));
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            e.c().q(this.q, this.r);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdDownloadData b2 = e.c().b(this.q);
            b2.setPage("LANDING_PAGE");
            b2.setExtInfo(this.t);
            b2.setDeeplinkUrl(this.u);
            if (this.r == null) {
                d.a.p0.q.c.b.d.a aVar = new d.a.p0.q.c.b.d.a(this.p, b2);
                this.v = aVar;
                this.r = new d.a.p0.q.d.h.b(aVar);
                if (b2.extra().getPercent() > 0) {
                    this.v.e(b2);
                }
            }
            H();
            q();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g.d(this.o, this.f61431c.getPageContext().getPageActivity());
        }
    }

    public final SparseArray<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            sparseArray.put(2, "pb_wx_timeline");
            sparseArray.put(3, "pb_wx_friend");
            sparseArray.put(4, "pb_qq_zone");
            sparseArray.put(5, "pb_tencent_weibo");
            sparseArray.put(6, "pb_sina_weibo");
            sparseArray.put(7, "pb_renren");
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.k.setVisibility(8);
        }
    }

    public void h() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (noDataView = this.l) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.j.setVisibility(0);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            UtilHelper.getStatusBarHeight();
            l.g(this.f61431c.getPageContext().getPageActivity(), R.dimen.ds98);
            int i2 = l.q(this.f61431c.getPageContext().getPageActivity()).heightPixels;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f61431c.setContentView(R.layout.base_ad_webview_activity);
            this.f61429a = this.f61431c.findViewById(R.id.root_view);
            this.f61432d = (NavigationBar) this.f61431c.findViewById(R.id.view_navigation_bar);
            z("");
            this.j = (LinearLayout) this.f61431c.findViewById(R.id.webview_container);
            this.p = (ApkDownloadBannerView) this.f61431c.findViewById(R.id.web_banner_download);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.addRule(3, R.id.view_navigation_bar);
            this.j.setLayoutParams(layoutParams);
            this.k = (TextView) this.f61431c.findViewById(R.id.webview_crash_tip);
            View addCustomView = this.f61432d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new a(this));
            this.f61434f = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
            this.f61435g = imageView;
            imageView.setContentDescription(this.f61431c.getResources().getString(R.string.back));
            this.f61429a.addOnAttachStateChangeListener(new b(this));
            j();
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                this.j.addView(this.f61431c.createWebView());
                this.k.setVisibility(8);
                if (this.s) {
                    return true;
                }
                this.f61432d.setStatusBarVisibility(8);
                return true;
            } catch (Exception e2) {
                this.k.setVisibility(0);
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void m(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadCacheKey) == null) {
            this.q = downloadCacheKey;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            NavigationBar navigationBar = this.f61432d;
            return navigationBar != null && navigationBar.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            NavigationBar navigationBar = this.f61432d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f61431c.getPageContext(), i2);
            }
            MorePopupWindow morePopupWindow = this.o;
            if (morePopupWindow != null) {
                morePopupWindow.onChangeSkinType(this.f61431c, i2, SkinManager.getDrawable(R.drawable.bg_pull_down_right_n));
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.f(this.f61431c.getPageContext(), i2);
            }
            SkinManager.setNavbarIconSrc(this.f61435g, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i2);
            SkinManager.setNavbarIconSrc(this.f61436h, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i2);
            SkinManager.setNavbarIconSrc(this.f61437i, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i2);
        }
    }

    public void p() {
        d.a.p0.q.c.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aVar = this.v) == null) {
            return;
        }
        aVar.m();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.q == null || this.r == null) {
            return;
        }
        e.c().i(this.q, this.r);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            LinearLayout linearLayout = this.j;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            NavigationBar navigationBar = this.f61432d;
            if (navigationBar != null) {
                navigationBar.release();
            }
            MorePopupWindow morePopupWindow = this.o;
            if (morePopupWindow != null) {
                g.d(morePopupWindow, this.f61431c.getPageContext().getPageActivity());
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.addRule(3, R.id.view_navigation_bar);
            this.j.setLayoutParams(layoutParams);
            this.f61435g.setBackgroundDrawable(null);
            this.f61436h.setBackgroundDrawable(null);
            this.f61437i.setBackgroundDrawable(null);
            this.f61432d.showBottomLine(true);
            this.f61431c.getWindow().clearFlags(1024);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.u = str;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.p.setDownloadWarningVisible(z);
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.t = str;
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.height = -1;
            this.j.setLayoutParams(layoutParams);
            this.f61432d.getBackground().mutate().setAlpha(0);
            this.f61432d.showBottomLine(false);
            SkinManager.setBackgroundResource(this.f61435g, R.drawable.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.f61436h, R.drawable.frs_star_navigation_bg);
            SkinManager.setBackgroundResource(this.f61437i, R.drawable.frs_star_navigation_bg);
            z("");
            this.f61431c.getWindow().setFlags(1024, 1024);
        }
    }

    public void x(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (view = this.n) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (z) {
                this.f61432d.setVisibility(0);
            } else {
                this.f61432d.setVisibility(8);
            }
            this.j.getLayoutParams().height = -1;
        }
    }

    public void z(String str) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.f61433e = this.f61432d.setCenterTextTitle(str);
            ImageView imageView2 = this.f61435g;
            if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.f61436h) != null && imageView.getVisibility() == 0) {
                this.f61433e.setMaxWidth(l.g(this.f61431c.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            SkinManager.setNavbarTitleColor(this.f61433e, R.color.CAM_X0105, R.color.s_navbar_title_color);
        }
    }
}
