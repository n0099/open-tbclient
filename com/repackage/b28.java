package com.repackage;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
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
/* loaded from: classes5.dex */
public class b28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public NoNetworkView c;
    public NavigationBar d;
    public BdTypeListView e;
    public j18 f;
    public wt8 g;
    public View h;
    public FrameLayout i;
    public k55 j;
    public c k;
    public AbsListView.OnScrollListener l;

    /* loaded from: classes5.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b28 a;

        public a(b28 b28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b28Var;
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b28 a;

        public b(b28 b28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ni.A()) {
                this.a.e();
                if (this.a.k != null) {
                    this.a.k.a(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view2);
    }

    public b28(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.c = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f09181a);
        this.d = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f091819);
        this.i = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09122e);
        this.e = (BdTypeListView) view2.findViewById(R.id.obfuscated_res_0x7f091809);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f07026e));
        View view3 = new View(tbPageContext.getPageActivity());
        this.h = view3;
        view3.setLayoutParams(layoutParams);
        this.e.addFooterView(this.h);
        this.e.setOnScrollListener(this.l);
        this.f = new j18(this.e, tbPageContext, bdUniqueId);
        this.g = new wt8(1);
    }

    public void d() {
        j18 j18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (j18Var = this.f) == null) {
            return;
        }
        j18Var.a();
    }

    public void e() {
        k55 k55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (k55Var = this.j) == null) {
            return;
        }
        k55Var.dettachView(this.i);
        this.j = null;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.n(this.b.getPageActivity(), this.d);
            this.g.k();
            this.g.o(null);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            k55 k55Var = this.j;
            if (k55Var != null) {
                return k55Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.b();
        }
    }

    public void i(int i) {
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
        this.c.d(this.b, i);
        this.g.m(i);
        k55 k55Var = this.j;
        if (k55Var != null) {
            k55Var.onChangeSkinType();
        }
        this.a = i;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void k(o18 o18Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, o18Var) == null) || o18Var == null) {
            return;
        }
        this.f.d(o18Var.p());
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || g()) {
            return;
        }
        if (this.j == null) {
            this.j = new k55(this.b.getPageActivity(), new b(this));
        }
        this.j.attachView(this.i, false);
        this.j.p();
        this.j.onChangeSkinType();
    }

    public void n(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.g.p(i, z);
        }
    }

    public void o() {
        j18 j18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (j18Var = this.f) == null) {
            return;
        }
        j18Var.e();
    }
}
