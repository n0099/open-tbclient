package com.repackage;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public sx7 b;
    public rx7 c;
    public boolean d;

    public nv7(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.a = pbFragment;
    }

    public void a() {
        sx7 sx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (sx7Var = this.b) == null) {
            return;
        }
        sx7Var.O();
    }

    public void b() {
        sx7 sx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sx7Var = this.b) == null) {
            return;
        }
        sx7Var.f0();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            sx7 sx7Var = this.b;
            if (sx7Var != null) {
                return sx7Var.P();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View c = c();
            if (c != null) {
                return c.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            sx7 sx7Var = this.b;
            if (sx7Var != null) {
                return sx7Var.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            sx7 sx7Var = this.b;
            return sx7Var != null && sx7Var.X();
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            sx7 sx7Var = this.b;
            if (sx7Var != null) {
                return sx7Var.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(int i) {
        rx7 rx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (rx7Var = this.c) == null) {
            return;
        }
        rx7Var.c(i);
    }

    public void i(int i) {
        sx7 sx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (sx7Var = this.b) == null) {
            return;
        }
        sx7Var.c0(i);
    }

    public void j(Configuration configuration) {
        sx7 sx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (sx7Var = this.b) == null) {
            return;
        }
        sx7Var.d0(configuration);
    }

    public boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            sx7 sx7Var = this.b;
            if (sx7Var != null) {
                return sx7Var.e0(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void l() {
        sx7 sx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (sx7Var = this.b) == null) {
            return;
        }
        sx7Var.f0();
    }

    public void m() {
        sx7 sx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (sx7Var = this.b) == null) {
            return;
        }
        sx7Var.g0();
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        sx7 sx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i, i2, i3) == null) || (sx7Var = this.b) == null) {
            return;
        }
        sx7Var.h0(absListView, i);
    }

    public void o(AbsListView absListView, int i) {
        sx7 sx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, absListView, i) == null) || (sx7Var = this.b) == null) {
            return;
        }
        sx7Var.i0(absListView, i);
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        sx7 sx7Var = this.b;
        if (sx7Var != null) {
            bdTypeListView.removeHeaderView(sx7Var.R());
        }
        rx7 rx7Var = this.c;
        if (rx7Var != null) {
            rx7Var.e(bdTypeListView);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i) == null) || pbLandscapeListView == null) {
            return;
        }
        sx7 sx7Var = this.b;
        if (sx7Var == null || sx7Var.P() == null) {
            sx7 sx7Var2 = this.b;
            if (sx7Var2 != null) {
                pbLandscapeListView.removeHeaderView(sx7Var2.R());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.x(textView, 0);
                return;
            }
            return;
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.setTextViewAdded(false);
        }
        if (i != 1) {
            pbLandscapeListView.removeHeaderView(this.b.R());
            pbLandscapeListView.x(this.b.R(), 0);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.d = z;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        sx7 sx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) || (sx7Var = this.b) == null) {
            return;
        }
        sx7Var.r0(onClickListener);
    }

    public void t() {
        sx7 sx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (sx7Var = this.b) == null) {
            return;
        }
        sx7Var.s0();
    }

    public void u(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bdTypeListView) == null) || this.b == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
        this.b.s0();
        bdTypeListView.smoothScrollToPosition(0);
    }

    public void v(rq7 rq7Var, PostData postData, BdTypeListView bdTypeListView, mv7 mv7Var, FrameLayout frameLayout, qw7 qw7Var, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{rq7Var, postData, bdTypeListView, mv7Var, frameLayout, qw7Var, str, Long.valueOf(j)}) == null) && rq7Var != null && rq7Var.r0()) {
            sx7 sx7Var = this.b;
            if (sx7Var == null) {
                sx7 sx7Var2 = new sx7(this.a, qw7Var, rq7Var.O().getThreadVideoInfo(), j);
                this.b = sx7Var2;
                sx7Var2.U(rq7Var.O().getThreadVideoInfo(), rq7Var.O(), rq7Var.m());
                this.b.v0();
            } else if (this.d) {
                sx7Var.U(rq7Var.O().getThreadVideoInfo(), rq7Var.O(), rq7Var.m());
                this.b.v0();
            } else {
                sx7Var.w0(rq7Var.m());
            }
            lx7.d(this.a.getUniqueId(), rq7Var, postData, 1, 1);
            if (rq7Var.K() != null && rq7Var.K().size() >= 1) {
                ThreadData threadData = rq7Var.K().get(0);
                this.b.p0(threadData);
                this.b.q0(threadData.getTitle());
            }
            this.b.k0(postData, rq7Var.O(), rq7Var.S());
            this.d = false;
            bdTypeListView.removeHeaderView(this.b.R());
            bdTypeListView.x(this.b.R(), 0);
            if (this.b.P() != null && this.b.P().getParent() == null) {
                frameLayout.addView(this.b.P());
            }
            if (this.c == null) {
                this.c = new rx7(this.a.getBaseFragmentActivity());
            }
            this.c.d(rq7Var, str);
            bdTypeListView.removeHeaderView(this.c.b());
            bdTypeListView.x(this.c.b(), 1);
            mv7Var.x(bdTypeListView);
            mv7Var.k(bdTypeListView, 2);
            if (this.b != null) {
                qw7Var.G(false);
                this.b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
