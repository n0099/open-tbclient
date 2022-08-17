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
/* loaded from: classes6.dex */
public class iw5 implements cx5, bx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaPersonCenterModel a;
    public lw5 b;
    public zv5 c;
    public TbPageContext d;
    public NavigationBar e;
    public BdTypeListView f;
    public View g;
    public NoNetworkView h;
    public g65 i;
    public boolean j;
    public boolean k;
    public int l;
    public ImageView m;
    public TextView n;
    public boolean o;
    public String p;
    public h65 q;
    public boolean r;
    public boolean s;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw5 a;

        public a(iw5 iw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(iw5 iw5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw5Var, Integer.valueOf(i)};
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
            this.a = iw5Var;
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

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw5 a;

        public c(iw5 iw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw5Var;
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

    /* loaded from: classes6.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw5 a;

        public d(iw5 iw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw5Var;
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

    public iw5(TbPageContext tbPageContext, boolean z) {
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
        this.l = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702bb);
        AlaPersonCenterModel alaPersonCenterModel = new AlaPersonCenterModel(tbPageContext);
        this.a = alaPersonCenterModel;
        alaPersonCenterModel.A(this);
        n(tbPageContext.getPageActivity());
    }

    @Override // com.repackage.bx5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 1) {
            this.s = true;
        }
    }

    @Override // com.repackage.cx5
    public void b(int i, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, obj) == null) {
            g65 g65Var = this.i;
            if (g65Var != null) {
                g65Var.dettachView(this.g);
            }
            this.f.setVisibility(0);
            BdTypeListView bdTypeListView = this.f;
            if (bdTypeListView == null || !ListUtils.isEmpty(bdTypeListView.getData())) {
                return;
            }
            w();
        }
    }

    @Override // com.repackage.cx5
    public void c(Object obj, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) == null) || obj == null) {
            return;
        }
        j();
        if ((obj instanceof lw5) && i == 1) {
            lw5 lw5Var = (lw5) obj;
            this.b = lw5Var;
            lw5Var.e(this.j);
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
            ow5 ow5Var = new ow5();
            ow5Var.f(this.b);
            arrayList.add(ow5Var);
            if (TbSingleton.getInstance().isShowStartLiveEntry()) {
                vw5 vw5Var = new vw5();
                vw5Var.f(this.b);
                arrayList.add(vw5Var);
            }
            sw5 sw5Var = new sw5();
            sw5Var.f(this.b);
            arrayList.add(sw5Var);
            tw5 tw5Var = new tw5();
            tw5Var.f(this.b);
            arrayList.add(tw5Var);
            if (this.b.h != null) {
                mw5 mw5Var = new mw5();
                mw5Var.f(this.b);
                arrayList.add(mw5Var);
            }
            qw5 qw5Var = new qw5();
            qw5Var.f(this.b);
            arrayList.add(qw5Var);
            uw5 uw5Var = new uw5();
            uw5Var.f(this.b);
            arrayList.add(uw5Var);
            pw5 pw5Var = new pw5();
            pw5Var.f(this.b);
            arrayList.add(pw5Var);
            nw5 nw5Var = new nw5();
            nw5Var.f(this.b);
            arrayList.add(nw5Var);
            xw5 xw5Var = new xw5();
            xw5Var.f(this.b);
            arrayList.add(xw5Var);
            ww5 ww5Var = new ww5();
            ww5Var.f(this.b);
            arrayList.add(ww5Var);
        } else {
            arrayList = new ArrayList(4);
            ow5 ow5Var2 = new ow5();
            ow5Var2.f(this.b);
            arrayList.add(ow5Var2);
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
            h65 h65Var = this.q;
            if (h65Var != null && h65Var.b().getParent() != null) {
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
            SkinManager.setNavbarIconSrc(this.m, R.drawable.selector_topbar_return_white, R.drawable.obfuscated_res_0x7f0810a7);
            this.f.setDivider(SkinManager.getDrawable(i, (int) R.color.CAM_X0204));
            this.f.setDividerHeight(this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            if (this.f.getAdapter2() instanceof fn) {
                this.f.getAdapter2().notifyDataSetChanged();
                g65 g65Var = this.i;
                if (g65Var != null) {
                    g65Var.onChangeSkinType();
                }
                this.h.d(this.d, i);
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
            View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d0100, null);
            this.g = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f090213);
            this.e = navigationBar;
            View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.o) {
                addSystemImageButton.setOnClickListener(new c(this));
            }
            this.m = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f092615);
            this.e.showBottomLine(false);
            if (!this.o) {
                this.n = this.e.setCenterTextTitle(this.d.getString(R.string.obfuscated_res_0x7f0f0224));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.d.getResources().getString(R.string.obfuscated_res_0x7f0f065a));
                this.n = this.e.setCenterTextTitle(sb.toString());
            }
            this.h = (NoNetworkView) this.g.findViewById(R.id.obfuscated_res_0x7f090214);
            BdTypeListView bdTypeListView = (BdTypeListView) this.g.findViewById(R.id.obfuscated_res_0x7f090212);
            this.f = bdTypeListView;
            bdTypeListView.setItemsCanFocus(true);
            this.f.setVisibility(8);
            zv5 zv5Var = new zv5(this.d, this.f, this);
            this.c = zv5Var;
            zv5Var.f(this.o);
            if (this.o) {
                this.g.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            g65 g65Var = new g65(this.d.getPageActivity());
            this.i = g65Var;
            g65Var.attachView(this.g, false);
            this.f.setOnScrollListener(new d(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g65 g65Var = this.i;
            if (g65Var != null) {
                g65Var.n();
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
        zv5 zv5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (zv5Var = this.c) == null) {
            return;
        }
        zv5Var.c(str);
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.p = str;
            zv5 zv5Var = this.c;
            if (zv5Var != null) {
                zv5Var.d(str);
            }
            if (!this.o) {
                this.n = this.e.setCenterTextTitle(this.d.getString(R.string.obfuscated_res_0x7f0f0224));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.p, 5, true, true) + this.d.getResources().getString(R.string.obfuscated_res_0x7f0f065a));
            this.n = this.e.setCenterTextTitle(sb.toString());
        }
    }

    public void t(String str) {
        zv5 zv5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (zv5Var = this.c) == null) {
            return;
        }
        zv5Var.e(str);
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
                h65 h65Var = new h65(this.d.getPageActivity(), new a(this));
                this.q = h65Var;
                h65Var.n(null);
                this.q.g(null);
                this.q.k(this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a5));
                this.q.p();
                this.q.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.q.m(null);
            this.q.n(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0fba));
            this.q.onChangeSkinType();
            if (!this.r) {
                ((ViewGroup) this.g).addView(this.q.b(), 0);
            }
            this.r = true;
        }
    }
}
