package com.repackage;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iw8;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class bm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseWebViewActivity a;
    public ViewGroup b;
    public NavigationBar c;
    public TextView d;
    public View e;
    public ImageView f;
    public View g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public LinearLayout k;
    public TextView l;
    public ContinuousAnimationView m;
    public NoDataView n;
    public View.OnClickListener o;
    public View p;
    public MorePopupWindow q;
    public View r;
    public View s;
    public View t;
    public boolean u;
    public boolean v;
    public v08 w;
    public boolean x;
    public View y;
    public yl4 z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm4 a;

        public a(bm4 bm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            if (((this.a.a instanceof TbWebViewActivity) && ((TbWebViewActivity) this.a.a).isDisableGoBack && ((TbWebViewActivity) this.a.a).needDealClickGoBack()) || this.a.a.webViewGoBack()) {
                return;
            }
            this.a.a.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm4 a;

        public b(bm4 bm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            this.a.a.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm4 a;

        public c(bm4 bm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f()) {
                    this.a.G();
                } else if (this.a.j.getVisibility() == 0) {
                } else {
                    this.a.J();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm4 a;

        public d(bm4 bm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm4Var;
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J();
            }
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements iw8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm4 a;

        public e(bm4 bm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm4Var;
        }

        @Override // com.repackage.iw8.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.w == null || this.a.a == null) {
                return;
            }
            this.a.w.dismiss();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.a).createNormalCfg(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f14ac), null);
            createNormalCfg.setCallFrom(12);
            this.a.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements iw8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm4 a;

        public f(bm4 bm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm4Var;
        }

        @Override // com.repackage.iw8.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.w == null) {
                return;
            }
            this.a.w.dismiss();
        }
    }

    public bm4(BaseWebViewActivity baseWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.m = null;
        this.u = true;
        this.v = false;
        this.x = false;
        this.a = baseWebViewActivity;
        l();
    }

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void B(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (view2 = this.r) == null) {
            return;
        }
        if (z) {
            view2.setVisibility(0);
            v(true);
        } else {
            view2.setVisibility(8);
            v(false);
        }
        this.q.refresh();
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.x = true;
            D();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout linearLayout = this.k;
            if (linearLayout != null) {
                linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar == null || this.i == null || this.j == null) {
                return;
            }
            navigationBar.setBackgroundDrawable(null);
            this.c.setBackgroundColor(R.color.transparent);
            this.c.setBackgroundResource(R.drawable.obfuscated_res_0x7f081207);
            this.i.setVisibility(8);
            this.j.setVisibility(0);
            this.j.setOnClickListener(this.a);
            this.d.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = oi.f(this.a, R.dimen.tbds100);
            layoutParams.height = oi.f(this.a, R.dimen.tbds100);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.obfuscated_res_0x7f0809b7, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f080623, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f0809ca, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.u = z;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.w == null) {
                iw8 iw8Var = new iw8(this.a);
                ArrayList arrayList = new ArrayList();
                iw8.b bVar = new iw8.b(this.a.getString(R.string.obfuscated_res_0x7f0f0fa9), iw8Var);
                bVar.h(new e(this));
                arrayList.add(bVar);
                iw8Var.g(new f(this));
                iw8Var.f(arrayList);
                v08 v08Var = new v08(this.a, iw8Var.b());
                this.w = v08Var;
                v08Var.a(0.7f);
            }
            this.w.show();
        }
    }

    public void H() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (navigationBar = this.c) == null || navigationBar.getVisibility() != 0 || (imageView = this.h) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            if (this.n == null) {
                this.n = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.e.d(null, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f14a1)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f67), this.o)));
            }
            if (!mi.A()) {
                this.n.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, a2), this.a.getPageContext());
            } else {
                this.n.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), this.a.getPageContext());
            }
            this.k.setVisibility(8);
            this.n.setVisibility(0);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.q.showWindowInRightBottomOfHost();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.m.setVisibility(0);
            this.m.playAnimation();
        }
    }

    public void L(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, shareItem) == null) || shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        if (shareItem.m) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.a, shareItem, true, (SparseArray<String>) null);
            shareDialogConfig.mShowMoreForumShare = true;
            mz5.c().l(shareDialogConfig);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.a, shareItem, true, g())));
    }

    public void M(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.a);
            bdTopToast.i(z);
            bdTopToast.h(str);
            bdTopToast.j(this.b);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            rg.d(this.q, this.a.getPageContext().getPageActivity());
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public final SparseArray<String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.l.setVisibility(8);
        }
    }

    public void i() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (noDataView = this.n) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.k.setVisibility(0);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.m.setVisibility(8);
            this.m.cancelAnimation();
        }
    }

    public void k(String str) {
        yl4 yl4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (yl4Var = this.z) == null) {
            return;
        }
        yl4Var.e(str);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0146);
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091add);
            this.c = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923ab);
            this.y = this.a.findViewById(R.id.obfuscated_res_0x7f091576);
            this.c.showBottomLine();
            z("");
            if (this.a.isTranslucent()) {
                SkinManager.setBackgroundColor(this.b, this.a.getResources().getColor(R.color.black_alpha0));
                this.b.setOnClickListener(this.a);
                this.c.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092427);
            this.k = linearLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f0923ab);
            this.k.setLayoutParams(layoutParams);
            this.l = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092429);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f092434);
            this.m = continuousAnimationView;
            SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
            View addCustomView = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d08c2, new a(this));
            this.e = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09244a);
            this.f = imageView;
            imageView.setContentDescription(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02bb));
            View addCustomView2 = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d08c5, new b(this));
            this.g = addCustomView2;
            ImageView imageView2 = (ImageView) addCustomView2.findViewById(R.id.obfuscated_res_0x7f09244a);
            this.h = imageView2;
            imageView2.setContentDescription(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03e8));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams2.leftMargin = oi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070224);
            this.h.setLayoutParams(layoutParams2);
            View addCustomView3 = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d08c6, new c(this));
            this.p = addCustomView3;
            this.i = (ImageView) addCustomView3.findViewById(R.id.obfuscated_res_0x7f09244b);
            this.j = (ImageView) this.p.findViewById(R.id.obfuscated_res_0x7f09244c);
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d080e, (ViewGroup) null);
            this.q = new MorePopupWindow(this.a.getPageContext().getPageActivity(), inflate, this.c, this.a.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new d(this));
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f092431);
            this.r = findViewById;
            findViewById.setOnClickListener(this.a);
            if (sy4.f(this.a.getPageContext().getPageActivity())) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
            this.q.refresh();
            View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f09242f);
            this.t = findViewById2;
            findViewById2.setOnClickListener(this.a);
            View findViewById3 = inflate.findViewById(R.id.obfuscated_res_0x7f09242d);
            this.s = findViewById3;
            findViewById3.setOnClickListener(this.a);
            yl4 yl4Var = new yl4(this.c, this.k);
            this.z = yl4Var;
            yl4Var.a(new xl4(this.f, R.drawable.obfuscated_res_0x7f080623), new xl4(this.h, R.drawable.obfuscated_res_0x7f0809b7), new xl4(this.i, R.drawable.icon_pure_topbar_more44_svg), new xl4(this.j, R.drawable.obfuscated_res_0x7f0809ca), new xl4(this.c.getCenterText(), 0));
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            try {
                this.k.addView(this.a.createWebView());
                this.l.setVisibility(8);
                if (this.u) {
                    return true;
                }
                this.c.setStatusBarVisibility(8);
                return true;
            } catch (Exception e2) {
                this.l.setVisibility(0);
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            NavigationBar navigationBar = this.c;
            return navigationBar != null && navigationBar.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            ContinuousAnimationView continuousAnimationView = this.m;
            if (continuousAnimationView != null) {
                SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
            }
            MorePopupWindow morePopupWindow = this.q;
            if (morePopupWindow != null) {
                morePopupWindow.onChangeSkinType(this.a, i, SkinManager.getDrawable(R.drawable.bg_pull_down_right_n));
            }
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i);
            }
            if (!this.x) {
                NavigationBar navigationBar = this.c;
                if (navigationBar != null) {
                    navigationBar.onChangeSkinType(this.a.getPageContext(), i);
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f080623, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.obfuscated_res_0x7f0809b7, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.obfuscated_res_0x7f0809ca, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (i == 1) {
                this.y.setVisibility(0);
            }
            yl4 yl4Var = this.z;
            if (yl4Var != null) {
                yl4Var.f(i);
            }
        }
    }

    public void p(int i, int i2, int i3, int i4) {
        yl4 yl4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048600, this, i, i2, i3, i4) == null) || (yl4Var = this.z) == null) {
            return;
        }
        yl4Var.h(i, i2, i3, i4);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            LinearLayout linearLayout = this.k;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.release();
            }
            MorePopupWindow morePopupWindow = this.q;
            if (morePopupWindow != null) {
                rg.d(morePopupWindow, this.a.getPageContext().getPageActivity());
            }
            yl4 yl4Var = this.z;
            if (yl4Var != null) {
                yl4Var.j();
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f0923ab);
            this.k.setLayoutParams(layoutParams);
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setBackgroundDrawable(null);
            }
            ImageView imageView2 = this.h;
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
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.showBottomLine(true);
            }
            BaseWebViewActivity baseWebViewActivity = this.a;
            if (baseWebViewActivity != null) {
                baseWebViewActivity.getWindow().clearFlags(1024);
            }
        }
    }

    public void s(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z) == null) || (view2 = this.g) == null) {
            return;
        }
        if (z) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.height = -1;
            this.k.setLayoutParams(layoutParams);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.getBackground().mutate().setAlpha(0);
                this.c.showBottomLine(false);
            }
            SkinManager.setBackgroundResource(this.f, R.drawable.obfuscated_res_0x7f08059d);
            SkinManager.setBackgroundResource(this.h, R.drawable.obfuscated_res_0x7f08059d);
            SkinManager.setBackgroundResource(this.i, R.drawable.obfuscated_res_0x7f08059d);
            SkinManager.setBackgroundResource(this.j, R.drawable.obfuscated_res_0x7f08059d);
            z("");
            this.a.getWindow().setFlags(1024, 1024);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.v = z;
        }
    }

    public void v(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (view2 = this.p) == null) {
            return;
        }
        if (z) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (z) {
                this.k.getLayoutParams().height = -1;
                this.c.setVisibility(0);
                return;
            }
            this.k.getLayoutParams().height = -1;
            this.c.setVisibility(8);
        }
    }

    public void x(int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048608, this, i) == null) || this.c == null || (imageView = this.i) == null) {
            return;
        }
        imageView.setVisibility(i);
    }

    public void y() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.c == null || (imageView = this.i) == null || this.j == null) {
            return;
        }
        imageView.setVisibility(8);
        this.j.setVisibility(0);
        this.j.setOnClickListener(this.a);
    }

    public void z(String str) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                this.d = navigationBar.setCenterTextTitle(str);
                ImageView imageView2 = this.f;
                if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.h) != null && imageView.getVisibility() == 0) {
                    this.d.setMaxWidth(oi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070251) * 2);
                }
                if (!this.x) {
                    SkinManager.setNavbarTitleColor(this.d, R.color.CAM_X0105, R.color.s_navbar_title_color);
                } else {
                    this.d.setTextColor(-1);
                }
            }
            yl4 yl4Var = this.z;
            if (yl4Var != null) {
                yl4Var.g();
            }
        }
    }
}
