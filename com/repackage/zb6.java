package com.repackage;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.forumSquare.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class zb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public RelativeLayout c;
    public ForumHeaderView d;
    public NavigationBar e;
    public TextView f;
    public View g;
    public gc6 h;
    public RelativeLayout i;
    public g45 j;
    public h45 k;
    public NoDataView l;
    public View.OnClickListener m;
    public final TbPageContext n;
    public CustomMessageListener o;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zb6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zb6 zb6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zb6Var, Integer.valueOf(i)};
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
            this.a = zb6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.a(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public zb6(Context context, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this, 2001304);
        this.a = context;
        this.n = tbPageContext;
        this.b = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02d3, (ViewGroup) null);
        l();
        k();
    }

    public void A(BdListView.p pVar) {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.v(pVar);
    }

    public void B(String str) {
        ForumHeaderView forumHeaderView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (forumHeaderView = this.d) == null) {
            return;
        }
        forumHeaderView.setSearchHint(str);
    }

    public void C(String str) {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.x(str);
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h();
            i();
            j();
            gc6 gc6Var = this.h;
            if (gc6Var != null) {
                gc6Var.y(true);
                this.h.w(8);
            }
        }
    }

    public boolean F(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                if (mi.z()) {
                    p();
                    return true;
                }
                q();
                return true;
            }
            o();
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i();
            j();
            H(true);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || m()) {
            return;
        }
        if (this.j == null) {
            g45 g45Var = new g45(this.a);
            this.j = g45Var;
            g45Var.s(oi.f(this.a, R.dimen.obfuscated_res_0x7f07028b));
        }
        this.j.onChangeSkinType();
        this.j.attachView(this.i, z);
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || n()) {
            return;
        }
        if (this.k == null) {
            h45 h45Var = new h45(this.a, this.m);
            this.k = h45Var;
            h45Var.k(oi.f(this.a, R.dimen.obfuscated_res_0x7f07028b));
        }
        this.k.attachView(this.i, z);
        this.k.p();
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            j();
            I(true);
            gc6 gc6Var = this.h;
            if (gc6Var != null) {
                gc6Var.s(8);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
            i();
            j();
            gc6 gc6Var = this.h;
            if (gc6Var != null) {
                gc6Var.f();
                this.h.s(0);
            }
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            ForumHeaderView forumHeaderView = this.d;
            if (forumHeaderView != null) {
                forumHeaderView.b();
            }
            NavigationBar navigationBar = this.e;
            if (navigationBar != null && this.a != null) {
                navigationBar.onChangeSkinType(this.n, i);
            }
            gc6 gc6Var = this.h;
            if (gc6Var != null) {
                gc6Var.m(i);
            }
            g45 g45Var = this.j;
            if (g45Var != null) {
                g45Var.onChangeSkinType();
            }
            h45 h45Var = this.k;
            if (h45Var != null) {
                h45Var.onChangeSkinType();
            }
            NoDataView noDataView = this.l;
            if (noDataView != null && this.a != null) {
                noDataView.setSubTitleTextColor(R.color.CAM_X0105);
                this.l.f(this.n, i);
            }
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207, i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.setVisibility(8);
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            ((LinearLayout.LayoutParams) this.i.getLayoutParams()).bottomMargin = oi.f(this.n.getPageActivity(), R.dimen.tbds22);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int statusBarHeight = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + oi.f(this.a, R.dimen.tbds238);
            RelativeLayout relativeLayout = this.i;
            if (relativeLayout == null || relativeLayout.getLayoutParams() == null) {
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, statusBarHeight, layoutParams.rightMargin, layoutParams.bottomMargin);
        }
    }

    public Pair<Integer, Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            gc6 gc6Var = this.h;
            return gc6Var != null ? gc6Var.c() : new Pair<>(0, 0);
        }
        return (Pair) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.h.d() : (String) invokeV.objValue;
    }

    public void g() {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.e();
    }

    public void h() {
        g45 g45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (g45Var = this.j) == null) {
            return;
        }
        g45Var.dettachView(this.i);
        this.j = null;
    }

    public void i() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (h45Var = this.k) == null) {
            return;
        }
        h45Var.dettachView(this.i);
        this.k = null;
    }

    public void j() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (noDataView = this.l) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void k() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (tbPageContext = this.n) == null) {
            return;
        }
        tbPageContext.registerListener(this.o);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f091514);
            this.e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.e.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f06a3));
            View addCustomView = this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05e6, (View.OnClickListener) null);
            this.g = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091aa8);
            this.f = textView;
            textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f06a4));
            this.c = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090a4f);
            ForumHeaderView forumHeaderView = (ForumHeaderView) this.b.findViewById(R.id.obfuscated_res_0x7f090a50);
            this.d = forumHeaderView;
            forumHeaderView.setFrom(1);
            this.d.setSearchHint(TbSingleton.getInstance().getHotSearch());
            this.h = new gc6(this.n, this.b);
            this.i = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0911c6);
            a(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            g45 g45Var = this.j;
            if (g45Var != null) {
                return g45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            h45 h45Var = this.k;
            if (h45Var != null) {
                return h45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o() {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.j();
    }

    public void p() {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.k();
    }

    public void q() {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.l();
    }

    public void r(int i, int i2) {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048604, this, i, i2) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.n(i, i2);
    }

    public void s(String str, List<String> list, boolean z) {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048605, this, str, list, z) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.o(str, list, z);
    }

    public void t(List<uo> list) {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, list) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.p(list);
    }

    public void u(List<uo> list, int i) {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048607, this, list, i) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.q(list, i);
    }

    public void v() {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.r();
    }

    public void w(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) || (textView = this.f) == null) {
            return;
        }
        textView.setOnClickListener(onClickListener);
    }

    public void x(LeftAdapter.b bVar) {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.t(bVar);
    }

    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void z(RecyclerView.OnScrollListener onScrollListener) {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, onScrollListener) == null) || (gc6Var = this.h) == null) {
            return;
        }
        gc6Var.u(onScrollListener);
    }
}
