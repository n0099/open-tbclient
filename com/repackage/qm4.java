package com.repackage;

import android.content.Context;
import android.util.SparseArray;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.InvateAnswerSettingActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
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
import com.repackage.fs4;
import com.repackage.kw8;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class qm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mm4 A;
    public BaseWebViewActivity a;
    public ViewGroup b;
    public NavigationBar c;
    public TextView d;
    public ImageView e;
    public View f;
    public ImageView g;
    public View h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public LinearLayout l;
    public TextView m;
    public ContinuousAnimationView n;
    public NoDataView o;
    public View.OnClickListener p;
    public View q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public i28 w;
    public ds4 x;
    public boolean y;
    public View z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm4 a;

        public a(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                new StatisticItem(CommonStatisticKey.KEY_QUESTION_DETAIL_HELP).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a, "", qi.P(TbConfig.QUESTION_THREAD_RULE, "refer=1"), true)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm4 a;

        public b(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm4Var;
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

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm4 a;

        public c(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm4Var;
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

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm4 a;

        public d(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.v) {
                    new StatisticItem(CommonStatisticKey.KEY_QUESTION_DETAIL_MORE).addParam("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InvateAnswerSettingActivityConfig(this.a.a)));
                } else if (this.a.i()) {
                    this.a.L();
                } else if (this.a.k.getVisibility() == 0) {
                } else {
                    this.a.O();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements fs4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm4 a;

        public e(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm4Var;
        }

        @Override // com.repackage.fs4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.x == null) {
                return;
            }
            this.a.x.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements fs4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm4 a;

        public f(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm4Var;
        }

        @Override // com.repackage.fs4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.x == null || this.a.a == null) {
                return;
            }
            this.a.x.dismiss();
            this.a.a.shareFriend();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements fs4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm4 a;

        public g(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm4Var;
        }

        @Override // com.repackage.fs4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.x == null || this.a.a == null) {
                return;
            }
            this.a.x.dismiss();
            this.a.a.copyLink();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements fs4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm4 a;

        public h(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm4Var;
        }

        @Override // com.repackage.fs4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.x == null || this.a.a == null) {
                return;
            }
            this.a.x.dismiss();
            this.a.a.openInBrowser();
        }
    }

    /* loaded from: classes7.dex */
    public class i implements kw8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm4 a;

        public i(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm4Var;
        }

        @Override // com.repackage.kw8.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.w == null || this.a.a == null) {
                return;
            }
            this.a.w.dismiss();
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.a).createNormalCfg(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f14db), null);
            createNormalCfg.setCallFrom(12);
            this.a.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes7.dex */
    public class j implements kw8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm4 a;

        public j(qm4 qm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm4Var;
        }

        @Override // com.repackage.kw8.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.w == null) {
                return;
            }
            this.a.w.dismiss();
        }
    }

    public qm4(BaseWebViewActivity baseWebViewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseWebViewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.n = null;
        this.r = true;
        this.s = true;
        this.t = false;
        this.u = false;
        this.v = false;
        this.y = false;
        this.a = baseWebViewActivity;
        o();
    }

    public void A(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (view2 = this.q) == null) {
            return;
        }
        if (z) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.l.getLayoutParams().height = -1;
                this.c.setVisibility(0);
                return;
            }
            this.l.getLayoutParams().height = -1;
            this.c.setVisibility(8);
        }
    }

    public void C(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.c == null || (imageView = this.j) == null) {
            return;
        }
        imageView.setVisibility(i2);
    }

    public void D() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.c == null || (imageView = this.j) == null || this.k == null) {
            return;
        }
        imageView.setVisibility(8);
        this.k.setVisibility(0);
        this.k.setOnClickListener(this.a);
    }

    public void E(String str) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                this.d = navigationBar.setCenterTextTitle(str);
                ImageView imageView2 = this.g;
                if (imageView2 != null && imageView2.getVisibility() == 0 && (imageView = this.i) != null && imageView.getVisibility() == 0) {
                    this.d.setMaxWidth(qi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07024e) * 2);
                }
                if (!this.y) {
                    SkinManager.setNavbarTitleColor(this.d, R.color.CAM_X0105, R.color.s_navbar_title_color);
                } else {
                    this.d.setTextColor(-1);
                }
                if (this.u) {
                    ImageView imageView3 = (ImageView) this.c.getCenterImgBox();
                    this.e = imageView3;
                    imageView3.setOnClickListener(new a(this));
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
                    layoutParams.rightMargin = qi.f(this.a.getActivity(), R.dimen.M_W_X002);
                    this.d.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
                    layoutParams2.height = qi.f(this.a.getActivity(), R.dimen.tbds42);
                    layoutParams2.width = qi.f(this.a.getActivity(), R.dimen.tbds42);
                    this.e.setLayoutParams(layoutParams2);
                    this.e.setVisibility(0);
                }
            }
            mm4 mm4Var = this.A;
            if (mm4Var != null) {
                mm4Var.g();
            }
        }
    }

    public void F(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.r == z) {
            return;
        }
        this.r = z;
        this.x = null;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.y = true;
            I();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar == null || this.j == null || this.k == null) {
                return;
            }
            navigationBar.setBackgroundDrawable(null);
            this.c.setBackgroundColor(R.color.transparent);
            this.c.setBackgroundResource(R.drawable.obfuscated_res_0x7f081210);
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            this.k.setOnClickListener(this.a);
            this.d.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.width = qi.f(this.a, R.dimen.tbds100);
            layoutParams.height = qi.f(this.a, R.dimen.tbds100);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f0809f4, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f080612, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080a09, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.s = z;
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.m.setVisibility(0);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.w == null) {
                kw8 kw8Var = new kw8(this.a);
                ArrayList arrayList = new ArrayList();
                kw8.b bVar = new kw8.b(this.a.getString(R.string.obfuscated_res_0x7f0f0ff7), kw8Var);
                bVar.h(new i(this));
                arrayList.add(bVar);
                kw8Var.g(new j(this));
                kw8Var.f(arrayList);
                i28 i28Var = new i28(this.a, kw8Var.b());
                this.w = i28Var;
                i28Var.a(0.7f);
            }
            this.w.show();
        }
    }

    public void M() {
        NavigationBar navigationBar;
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (navigationBar = this.c) == null || navigationBar.getVisibility() != 0 || (imageView = this.i) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            if (this.o == null) {
                this.o = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.e.d(null, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f14d5)), NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb7), this.p)));
            }
            if (!oi.A()) {
                this.o.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, a2), this.a.getPageContext());
            } else {
                this.o.g(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, a2), this.a.getPageContext());
            }
            this.l.setVisibility(8);
            this.o.setVisibility(0);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.x == null) {
                fs4 fs4Var = new fs4(this.a);
                fs4Var.m(new e(this));
                ArrayList arrayList = new ArrayList();
                if (this.r) {
                    bs4 bs4Var = new bs4(fs4Var);
                    bs4Var.n(this.a.getString(R.string.obfuscated_res_0x7f0f1160));
                    bs4Var.m(new f(this));
                    arrayList.add(bs4Var);
                }
                bs4 bs4Var2 = new bs4(fs4Var);
                bs4Var2.n(this.a.getString(R.string.obfuscated_res_0x7f0f044f));
                bs4Var2.m(new g(this));
                arrayList.add(bs4Var2);
                bs4 bs4Var3 = new bs4(fs4Var);
                bs4Var3.n(this.a.getString(R.string.obfuscated_res_0x7f0f0cfb));
                bs4Var3.m(new h(this));
                arrayList.add(bs4Var3);
                fs4Var.j(arrayList);
                this.x = new ds4(this.a.getPageContext(), fs4Var);
            }
            this.x.show();
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.n.setVisibility(0);
            this.n.playAnimation();
        }
    }

    public void Q(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, shareItem) == null) || shareItem == null) {
            return;
        }
        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.w);
        statisticItem.param("obj_type", 0);
        TiebaStatic.log(statisticItem);
        if (shareItem.p) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.a, shareItem, true, (SparseArray<String>) null);
            shareDialogConfig.mShowMoreForumShare = true;
            p16.c().l(shareDialogConfig);
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.a, shareItem, true, j())));
    }

    public void R(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048593, this, z, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.a);
            bdTopToast.h(z);
            bdTopToast.g(str);
            bdTopToast.i(this.b);
        }
    }

    public void h() {
        ds4 ds4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (ds4Var = this.x) == null) {
            return;
        }
        ds4Var.cancel();
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public final SparseArray<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
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

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.m.setVisibility(8);
        }
    }

    public void l() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (noDataView = this.o) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.l.setVisibility(0);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.n.setVisibility(8);
            this.n.cancelAnimation();
        }
    }

    public void n(String str) {
        mm4 mm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, str) == null) || (mm4Var = this.A) == null) {
            return;
        }
        mm4Var.e(str);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d013f);
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091c31);
            this.c = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f09255c);
            this.z = this.a.findViewById(R.id.obfuscated_res_0x7f09168d);
            this.c.showBottomLine();
            E("");
            if (this.a.isTranslucent()) {
                SkinManager.setBackgroundColor(this.b, this.a.getResources().getColor(R.color.black_alpha0));
                this.b.setOnClickListener(this.a);
                this.c.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0925f2);
            this.l = linearLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f09255c);
            this.l.setLayoutParams(layoutParams);
            this.m = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0925f4);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.a.findViewById(R.id.obfuscated_res_0x7f0925ff);
            this.n = continuousAnimationView;
            SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
            View addCustomView = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d08ff, new b(this));
            this.f = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f092615);
            this.g = imageView;
            imageView.setContentDescription(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02c9));
            View addCustomView2 = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d0902, new c(this));
            this.h = addCustomView2;
            ImageView imageView2 = (ImageView) addCustomView2.findViewById(R.id.obfuscated_res_0x7f092615);
            this.i = imageView2;
            imageView2.setContentDescription(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03f3));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams2.leftMargin = qi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070224);
            this.i.setLayoutParams(layoutParams2);
            View addCustomView3 = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0903, new d(this));
            this.q = addCustomView3;
            this.j = (ImageView) addCustomView3.findViewById(R.id.obfuscated_res_0x7f092616);
            this.k = (ImageView) this.q.findViewById(R.id.obfuscated_res_0x7f092617);
            mm4 mm4Var = new mm4(this.c, this.l);
            this.A = mm4Var;
            mm4Var.a(new lm4(this.g, R.drawable.obfuscated_res_0x7f080612), new lm4(this.i, R.drawable.obfuscated_res_0x7f0809f4), new lm4(this.j, R.drawable.icon_pure_topbar_more44_svg), new lm4(this.k, R.drawable.obfuscated_res_0x7f080a09), new lm4(this.c.getCenterText(), 0));
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            try {
                this.l.addView(this.a.createWebView());
                this.m.setVisibility(8);
                if (this.s) {
                    return true;
                }
                this.c.setStatusBarVisibility(8);
                return true;
            } catch (Exception e2) {
                this.m.setVisibility(0);
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            NavigationBar navigationBar = this.c;
            return navigationBar != null && navigationBar.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            ContinuousAnimationView continuousAnimationView = this.n;
            if (continuousAnimationView != null) {
                SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_full_screen_refresh);
            }
            NoDataView noDataView = this.o;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i2);
            }
            if (!this.y) {
                NavigationBar navigationBar = this.c;
                if (navigationBar != null) {
                    navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.obfuscated_res_0x7f080612, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f0809f4, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.obfuscated_res_0x7f080a09, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (i2 == 1) {
                this.z.setVisibility(0);
            }
            mm4 mm4Var = this.A;
            if (mm4Var != null) {
                mm4Var.f(i2);
            }
            ImageView imageView = this.e;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f0811e7, R.color.CAM_X0105, null);
            }
        }
    }

    public void s(int i2, int i3, int i4, int i5) {
        mm4 mm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048605, this, i2, i3, i4, i5) == null) || (mm4Var = this.A) == null) {
            return;
        }
        mm4Var.h(i2, i3, i4, i5);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.release();
            }
            h();
            mm4 mm4Var = this.A;
            if (mm4Var != null) {
                mm4Var.j();
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f09255c);
            this.l.setLayoutParams(layoutParams);
            ImageView imageView = this.g;
            if (imageView != null) {
                imageView.setBackgroundDrawable(null);
            }
            ImageView imageView2 = this.i;
            if (imageView2 != null) {
                imageView2.setBackgroundDrawable(null);
            }
            ImageView imageView3 = this.j;
            if (imageView3 != null) {
                imageView3.setBackgroundDrawable(null);
            }
            ImageView imageView4 = this.k;
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

    public void v(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z) == null) || (view2 = this.h) == null) {
            return;
        }
        if (z) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.height = -1;
            this.l.setLayoutParams(layoutParams);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.getBackground().mutate().setAlpha(0);
                this.c.showBottomLine(false);
            }
            SkinManager.setBackgroundResource(this.g, R.drawable.obfuscated_res_0x7f08058c);
            SkinManager.setBackgroundResource(this.i, R.drawable.obfuscated_res_0x7f08058c);
            SkinManager.setBackgroundResource(this.j, R.drawable.obfuscated_res_0x7f08058c);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f08058c);
            E("");
            this.a.getWindow().setFlags(1024, 1024);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.v = z;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.t = z;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.u = z;
        }
    }
}
