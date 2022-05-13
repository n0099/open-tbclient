package com.repackage;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g55;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
/* loaded from: classes7.dex */
public class s28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public NoNetworkView c;
    public NavigationBar d;
    public BdTypeListView e;
    public z18 f;
    public pv8 g;
    public View h;
    public FrameLayout i;
    public y45 j;
    public e k;
    public AbsListView.OnScrollListener l;

    /* loaded from: classes7.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s28 a;

        public a(s28 s28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s28Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                if (i == 0) {
                    absListView.getChildAt(0);
                }
                if (i == 0 || i == 1) {
                    SkinManager.setBackgroundColor(this.a.d, R.color.CAM_X0204, this.a.a);
                } else {
                    SkinManager.setBackgroundColor(this.a.d, R.color.CAM_X0205, this.a.a);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements g55.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s28 a;

        public b(s28 s28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s28Var;
        }

        @Override // com.repackage.g55.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new NoNetworkView(this.a.b.getPageActivity()) : invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements g55.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s28 a;

        public c(s28 s28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s28Var;
        }

        @Override // com.repackage.g55.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new NavigationBar(this.a.b.getPageActivity()) : invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s28 a;

        public d(s28 s28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ki.A()) {
                this.a.f();
                if (this.a.k != null) {
                    this.a.k.a(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(View view2);
    }

    public s28(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.l = new a(this);
        if (view2 == null) {
            return;
        }
        this.b = tbPageContext;
        NoNetworkView noNetworkView = (NoNetworkView) g55.e().d(1051, new b(this));
        this.c = noNetworkView;
        noNetworkView.setVisibility(8);
        ((RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917ca)).addView(this.c);
        NavigationBar navigationBar = (NavigationBar) g55.e().d(RevenueServerConst.GetChargeCouponDiscountRequest, new c(this));
        this.d = navigationBar;
        ((RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917c9)).addView(navigationBar);
        this.i = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0911d6);
        this.e = (BdTypeListView) view2.findViewById(R.id.obfuscated_res_0x7f0917b3);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070270));
        View view3 = new View(tbPageContext.getPageActivity());
        this.h = view3;
        view3.setLayoutParams(layoutParams);
        this.e.addFooterView(this.h);
        this.e.setOnScrollListener(this.l);
        this.f = new z18(this.e, tbPageContext, bdUniqueId);
        this.g = new pv8(1);
    }

    public void e() {
        z18 z18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (z18Var = this.f) == null) {
            return;
        }
        z18Var.a();
    }

    public void f() {
        y45 y45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (y45Var = this.j) == null) {
            return;
        }
        y45Var.dettachView(this.i);
        this.j = null;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.n(this.b.getPageActivity(), this.d);
            this.g.k();
            this.g.o(null);
            j(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            y45 y45Var = this.j;
            if (y45Var != null) {
                return y45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.b();
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
        this.d.onChangeSkinType(this.b, i);
        SkinManager.setBackgroundColor(this.d.getBarBgView(), R.color.CAM_X0204, i);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204, i);
        this.f.c();
        this.c.c(this.b, i);
        this.g.m(i);
        y45 y45Var = this.j;
        if (y45Var != null) {
            y45Var.onChangeSkinType();
        }
        this.a = i;
    }

    public void k() {
        z18 z18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (z18Var = this.f) == null) {
            return;
        }
        z18Var.a();
    }

    public void l(e28 e28Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, e28Var) == null) || e28Var == null) {
            return;
        }
        this.f.d(e28Var.p());
    }

    public void m(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void n() {
        z18 z18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (z18Var = this.f) == null) {
            return;
        }
        z18Var.e();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || h()) {
            return;
        }
        if (this.j == null) {
            this.j = new y45(this.b.getPageActivity(), new d(this));
        }
        this.j.attachView(this.i, false);
        this.j.p();
        this.j.onChangeSkinType();
    }

    public void p(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.g.p(i, z);
        }
    }
}
