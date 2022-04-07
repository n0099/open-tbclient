package com.repackage;

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
/* loaded from: classes5.dex */
public class ej5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public AdBaseWebViewActivity c;
    public NavigationBar d;
    public TextView e;
    public View f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public LinearLayout j;
    public TextView k;
    public NoDataView l;
    public View.OnClickListener m;
    public View n;
    public MorePopupWindow o;
    public ApkDownloadBannerView p;
    public DownloadCacheKey q;
    public tj5 r;
    public boolean s;
    public String t;
    public String u;
    public pj5 v;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej5 a;

        public a(ej5 ej5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.c == null || this.a.c.webViewGoBack()) {
                return;
            }
            this.a.c.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej5 a;

        public b(ej5 ej5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej5Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.H();
            }
        }
    }

    public ej5(AdBaseWebViewActivity adBaseWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adBaseWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.q = null;
        this.r = null;
        this.s = true;
        this.c = adBaseWebViewActivity;
        k();
    }

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void B(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (view2 = this.b) == null) {
            return;
        }
        if (z) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
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
                this.l = NoDataViewFactory.a(this.c.getPageContext().getPageActivity(), this.a, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.e.d(null, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f14a1)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0f67), this.m)));
            }
            this.l.f(this.c.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
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
        TiebaStatic.eventStat(this.c.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.c.getPageContext().getPageActivity(), shareItem, true, f())));
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            lj5.d().r(this.q, this.r);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdDownloadData b2 = lj5.d().b(this.q);
            b2.setPage("LANDING_PAGE");
            b2.setExtInfo(this.t);
            b2.setDeeplinkUrl(this.u);
            if (this.r == null) {
                lj5 d = lj5.d();
                ApkDownloadBannerView apkDownloadBannerView = this.p;
                pj5 c = d.c(apkDownloadBannerView, apkDownloadBannerView, b2);
                this.v = c;
                this.r = new rj5(c);
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
            rg.d(this.o, this.c.getPageContext().getPageActivity());
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
            oi.f(this.c.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070282);
            int i = oi.q(this.c.getPageContext().getPageActivity()).heightPixels;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.c.setContentView(R.layout.obfuscated_res_0x7f0d0143);
            this.a = this.c.findViewById(R.id.obfuscated_res_0x7f091add);
            this.d = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f0923ab);
            z("");
            this.j = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092427);
            this.p = (ApkDownloadBannerView) this.c.findViewById(R.id.obfuscated_res_0x7f092421);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f0923ab);
            this.j.setLayoutParams(layoutParams);
            this.k = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092429);
            View addCustomView = this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d08c2, new a(this));
            this.f = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09244a);
            this.g = imageView;
            imageView.setContentDescription(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f02bb));
            this.a.addOnAttachStateChangeListener(new b(this));
            j();
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                this.j.addView(this.c.createWebView());
                this.k.setVisibility(8);
                if (this.s) {
                    return true;
                }
                this.d.setStatusBarVisibility(8);
                return true;
            } catch (Exception e) {
                this.k.setVisibility(0);
                BdLog.e(e.getMessage());
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
            NavigationBar navigationBar = this.d;
            return navigationBar != null && navigationBar.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.c.getPageContext(), i);
            }
            MorePopupWindow morePopupWindow = this.o;
            if (morePopupWindow != null) {
                morePopupWindow.onChangeSkinType(this.c, i, SkinManager.getDrawable(R.drawable.bg_pull_down_right_n));
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.f(this.c.getPageContext(), i);
            }
            SkinManager.setNavbarIconSrc(this.g, R.drawable.selector_web_topbar_return_black, R.drawable.selector_web_topbar_return_white, i);
            SkinManager.setNavbarIconSrc(this.h, R.drawable.selector_web_topbar_close_black, R.drawable.selector_web_topbar_close_white, i);
            SkinManager.setNavbarIconSrc(this.i, R.drawable.selector_web_topbar_more_black, R.drawable.selector_web_topbar_more_white, i);
        }
    }

    public void p() {
        pj5 pj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (pj5Var = this.v) == null) {
            return;
        }
        pj5Var.b();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.q == null || this.r == null) {
            return;
        }
        lj5.d().j(this.q, this.r);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            LinearLayout linearLayout = this.j;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.release();
            }
            MorePopupWindow morePopupWindow = this.o;
            if (morePopupWindow != null) {
                rg.d(morePopupWindow, this.c.getPageContext().getPageActivity());
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f0923ab);
            this.j.setLayoutParams(layoutParams);
            this.g.setBackgroundDrawable(null);
            this.h.setBackgroundDrawable(null);
            this.i.setBackgroundDrawable(null);
            this.d.showBottomLine(true);
            this.c.getWindow().clearFlags(1024);
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
            this.d.getBackground().mutate().setAlpha(0);
            this.d.showBottomLine(false);
            SkinManager.setBackgroundResource(this.g, R.drawable.obfuscated_res_0x7f08059d);
            SkinManager.setBackgroundResource(this.h, R.drawable.obfuscated_res_0x7f08059d);
            SkinManager.setBackgroundResource(this.i, R.drawable.obfuscated_res_0x7f08059d);
            z("");
            this.c.getWindow().setFlags(1024, 1024);
        }
    }

    public void x(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (view2 = this.n) == null) {
            return;
        }
        if (z) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (z) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
            this.j.getLayoutParams().height = -1;
        }
    }

    public void z(String str) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.e = this.d.setCenterTextTitle(str);
            ImageView imageView2 = this.g;
            if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.h) != null && imageView.getVisibility() == 0) {
                this.e.setMaxWidth(oi.f(this.c.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070251) * 2);
            }
            SkinManager.setNavbarTitleColor(this.e, R.color.CAM_X0105, R.color.s_navbar_title_color);
        }
    }
}
