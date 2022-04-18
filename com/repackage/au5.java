package com.repackage;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class au5 implements uu5, tu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaPersonCenterModel a;
    public du5 b;
    public rt5 c;
    public TbPageContext d;
    public NavigationBar e;
    public BdTypeListView f;
    public View g;
    public NoNetworkView h;
    public g45 i;
    public boolean j;
    public boolean k;
    public int l;
    public ImageView m;
    public TextView n;
    public boolean o;
    public String p;
    public h45 q;
    public boolean r;
    public boolean s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au5 a;

        public a(au5 au5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(au5 au5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.a == null) {
                return;
            }
            this.a.a.loadData();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au5 a;

        public c(au5 au5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.d.getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au5 a;

        public d(au5 au5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au5Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                this.a.v();
                this.a.u();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
            }
        }
    }

    public au5(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
        this.l = 0;
        this.o = false;
        this.r = false;
        this.s = false;
        new b(this, AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH);
        this.d = tbPageContext;
        this.o = z;
        this.l = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702be);
        AlaPersonCenterModel alaPersonCenterModel = new AlaPersonCenterModel(tbPageContext);
        this.a = alaPersonCenterModel;
        alaPersonCenterModel.z(this);
        n(tbPageContext.getPageActivity());
    }

    @Override // com.repackage.tu5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 1) {
            this.s = true;
        }
    }

    @Override // com.repackage.uu5
    public void b(int i, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, obj) == null) {
            g45 g45Var = this.i;
            if (g45Var != null) {
                g45Var.dettachView(this.g);
            }
            this.f.setVisibility(0);
            BdTypeListView bdTypeListView = this.f;
            if (bdTypeListView == null || !ListUtils.isEmpty(bdTypeListView.getData())) {
                return;
            }
            w();
        }
    }

    @Override // com.repackage.uu5
    public void c(Object obj, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) == null) || obj == null) {
            return;
        }
        j();
        if ((obj instanceof du5) && i == 1) {
            du5 du5Var = (du5) obj;
            this.b = du5Var;
            du5Var.e(this.j);
            this.i.dettachView(this.g);
            this.f.setVisibility(0);
            h();
        }
    }

    public void h() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.b == null) {
            return;
        }
        if (this.j) {
            arrayList = new ArrayList(10);
            gu5 gu5Var = new gu5();
            gu5Var.g(this.b);
            arrayList.add(gu5Var);
            if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                nu5 nu5Var = new nu5();
                nu5Var.g(this.b);
                arrayList.add(nu5Var);
            }
            ku5 ku5Var = new ku5();
            ku5Var.g(this.b);
            arrayList.add(ku5Var);
            lu5 lu5Var = new lu5();
            lu5Var.g(this.b);
            arrayList.add(lu5Var);
            if (this.b.h != null) {
                eu5 eu5Var = new eu5();
                eu5Var.g(this.b);
                arrayList.add(eu5Var);
            }
            iu5 iu5Var = new iu5();
            iu5Var.g(this.b);
            arrayList.add(iu5Var);
            mu5 mu5Var = new mu5();
            mu5Var.g(this.b);
            arrayList.add(mu5Var);
            hu5 hu5Var = new hu5();
            hu5Var.g(this.b);
            arrayList.add(hu5Var);
            fu5 fu5Var = new fu5();
            fu5Var.g(this.b);
            arrayList.add(fu5Var);
            pu5 pu5Var = new pu5();
            pu5Var.g(this.b);
            arrayList.add(pu5Var);
            ou5 ou5Var = new ou5();
            ou5Var.g(this.b);
            arrayList.add(ou5Var);
        } else {
            arrayList = new ArrayList(4);
            gu5 gu5Var2 = new gu5();
            gu5Var2.g(this.b);
            arrayList.add(gu5Var2);
        }
        this.c.b(arrayList);
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (View) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h45 h45Var = this.q;
            if (h45Var != null && h45Var.b().getParent() != null) {
                ((ViewGroup) this.q.b().getParent()).removeView(this.q.b());
            }
            this.r = false;
        }
    }

    public void k(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.a.setUid(str);
            this.j = z;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.loadData();
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.e.onChangeSkinType(this.d, i);
            this.e.getBackground().mutate().setAlpha(0);
            SkinManager.setNavbarTitleColor(this.e.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
            SkinManager.setNavbarIconSrc(this.m, R.drawable.selector_topbar_return_white, R.drawable.obfuscated_res_0x7f0810a3);
            this.f.setDivider(SkinManager.getDrawable(i, (int) R.color.CAM_X0204));
            this.f.setDividerHeight(this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            if (this.f.getAdapter2() instanceof lo) {
                this.f.getAdapter2().notifyDataSetChanged();
                g45 g45Var = this.i;
                if (g45Var != null) {
                    g45Var.onChangeSkinType();
                }
                this.h.c(this.d, i);
                if (i == 1) {
                    this.e.getBarBgView().setBackgroundColor(this.d.getResources().getColor(R.color.CAM_X0207_1));
                    this.e.getTopCoverBgView().setBackgroundColor(this.d.getResources().getColor(R.color.CAM_X0201_1));
                } else if (i == 0) {
                    this.e.getBarBgView().setBackgroundColor(this.d.getResources().getColor(R.color.CAM_X0207));
                    this.e.getTopCoverBgView().setBackgroundColor(this.d.getResources().getColor(R.color.CAM_X0201));
                }
            }
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d0107, null);
            this.g = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f090214);
            this.e = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.o) {
                addSystemImageButton.setOnClickListener(new c(this));
            }
            this.m = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09244b);
            this.e.showBottomLine(false);
            if (!this.o) {
                this.n = this.e.setCenterTextTitle(this.d.getString(R.string.obfuscated_res_0x7f0f021c));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0643));
                this.n = this.e.setCenterTextTitle(sb.toString());
            }
            this.h = (NoNetworkView) this.g.findViewById(R.id.obfuscated_res_0x7f090215);
            BdTypeListView bdTypeListView = (BdTypeListView) this.g.findViewById(R.id.obfuscated_res_0x7f090213);
            this.f = bdTypeListView;
            bdTypeListView.setItemsCanFocus(true);
            this.f.setVisibility(8);
            rt5 rt5Var = new rt5(this.d, this.f, this);
            this.c = rt5Var;
            rt5Var.f(this.o);
            if (this.o) {
                this.g.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            g45 g45Var = new g45(this.d.getPageActivity());
            this.i = g45Var;
            g45Var.attachView(this.g, false);
            this.f.setOnScrollListener(new d(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g45 g45Var = this.i;
            if (g45Var != null) {
                g45Var.n();
                this.i.dettachView(this.g);
            }
            AlaPersonCenterModel alaPersonCenterModel = this.a;
            if (alaPersonCenterModel != null) {
                alaPersonCenterModel.destory();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.s) {
            this.s = false;
            l();
        }
    }

    public void q(float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            if (!z && !this.r) {
                SkinManager.setNavbarIconSrc(this.m, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg_s);
                SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                SkinManager.setNavbarIconSrc(this.m, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg_s);
                SkinManager.setNavbarTitleColor(this.n, R.color.CAM_X0105, R.color.s_navbar_title_color);
            }
            this.n.setAlpha(f);
            this.m.setAlpha(f);
        }
    }

    public void r(String str) {
        rt5 rt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (rt5Var = this.c) == null) {
            return;
        }
        rt5Var.c(str);
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.p = str;
            rt5 rt5Var = this.c;
            if (rt5Var != null) {
                rt5Var.d(str);
            }
            if (!this.o) {
                this.n = this.e.setCenterTextTitle(this.d.getString(R.string.obfuscated_res_0x7f0f021c));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0643));
            this.n = this.e.setCenterTextTitle(sb.toString());
        }
    }

    public void t(String str) {
        rt5 rt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (rt5Var = this.c) == null) {
            return;
        }
        rt5Var.e(str);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || 2 == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        float alpha = this.e.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.k) {
                this.k = true;
            }
        } else if (this.k) {
            this.k = false;
        }
        q(alpha, !this.k);
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || Build.VERSION.SDK_INT < 11 || this.f.getChildAt(0) == null) {
            return;
        }
        int dimension = (int) this.d.getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        int i = this.l - (-this.f.getChildAt(0).getTop());
        if (i < dimension) {
            if (this.e.getBarBgView().getAlpha() != 1.0f) {
                this.e.getBarBgView().setAlpha(1.0f);
                this.e.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= dimension && i <= dimension * 2) {
            float f = 1.0f - (((i - dimension) * 1.0f) / dimension);
            this.e.getBarBgView().setAlpha(f);
            this.e.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > dimension * 2 && this.e.getBarBgView().getAlpha() != 0.0f) {
            this.e.getBarBgView().setAlpha(0.0f);
            this.e.getTopCoverBgView().setAlpha(1.0f);
        }
        if (this.f.getFirstVisiblePosition() <= 0 || this.e.getBarBgView().getAlpha() == 1.0f) {
            return;
        }
        this.e.getBarBgView().setAlpha(1.0f);
        this.e.getTopCoverBgView().setAlpha(0.0f);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.q == null) {
                h45 h45Var = new h45(this.d.getPageActivity(), new a(this));
                this.q = h45Var;
                h45Var.n(null);
                this.q.g(null);
                this.q.k(this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a8));
                this.q.p();
                this.q.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.q.m(null);
            this.q.n(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0f69));
            this.q.onChangeSkinType();
            if (!this.r) {
                ((ViewGroup) this.g).addView(this.q.b(), 0);
            }
            this.r = true;
        }
    }
}
