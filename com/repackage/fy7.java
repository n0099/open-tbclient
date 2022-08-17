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
public class fy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public o08 b;
    public n08 c;
    public boolean d;

    public fy7(PbFragment pbFragment) {
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
        o08 o08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (o08Var = this.b) == null) {
            return;
        }
        o08Var.O();
    }

    public void b() {
        o08 o08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (o08Var = this.b) == null) {
            return;
        }
        o08Var.f0();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            o08 o08Var = this.b;
            if (o08Var != null) {
                return o08Var.P();
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
            o08 o08Var = this.b;
            if (o08Var != null) {
                return o08Var.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            o08 o08Var = this.b;
            return o08Var != null && o08Var.X();
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            o08 o08Var = this.b;
            if (o08Var != null) {
                return o08Var.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(int i) {
        n08 n08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (n08Var = this.c) == null) {
            return;
        }
        n08Var.c(i);
    }

    public void i(int i) {
        o08 o08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (o08Var = this.b) == null) {
            return;
        }
        o08Var.c0(i);
    }

    public void j(Configuration configuration) {
        o08 o08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (o08Var = this.b) == null) {
            return;
        }
        o08Var.d0(configuration);
    }

    public boolean k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            o08 o08Var = this.b;
            if (o08Var != null) {
                return o08Var.e0(i);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void l() {
        o08 o08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (o08Var = this.b) == null) {
            return;
        }
        o08Var.f0();
    }

    public void m() {
        o08 o08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (o08Var = this.b) == null) {
            return;
        }
        o08Var.g0();
    }

    public void n(AbsListView absListView, int i, int i2, int i3) {
        o08 o08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i, i2, i3) == null) || (o08Var = this.b) == null) {
            return;
        }
        o08Var.h0(absListView, i);
    }

    public void o(AbsListView absListView, int i) {
        o08 o08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, absListView, i) == null) || (o08Var = this.b) == null) {
            return;
        }
        o08Var.i0(absListView, i);
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        o08 o08Var = this.b;
        if (o08Var != null) {
            bdTypeListView.removeHeaderView(o08Var.R());
        }
        n08 n08Var = this.c;
        if (n08Var != null) {
            n08Var.e(bdTypeListView);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i) == null) || pbLandscapeListView == null) {
            return;
        }
        o08 o08Var = this.b;
        if (o08Var == null || o08Var.P() == null) {
            o08 o08Var2 = this.b;
            if (o08Var2 != null) {
                pbLandscapeListView.removeHeaderView(o08Var2.R());
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
        o08 o08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) || (o08Var = this.b) == null) {
            return;
        }
        o08Var.r0(onClickListener);
    }

    public void t() {
        o08 o08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (o08Var = this.b) == null) {
            return;
        }
        o08Var.s0();
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

    public void v(et7 et7Var, PostData postData, BdTypeListView bdTypeListView, ey7 ey7Var, FrameLayout frameLayout, mz7 mz7Var, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{et7Var, postData, bdTypeListView, ey7Var, frameLayout, mz7Var, str, Long.valueOf(j)}) == null) && et7Var != null && et7Var.u0()) {
            o08 o08Var = this.b;
            if (o08Var == null) {
                o08 o08Var2 = new o08(this.a, mz7Var, et7Var.O().getThreadVideoInfo(), j);
                this.b = o08Var2;
                o08Var2.U(et7Var.O().getThreadVideoInfo(), et7Var.O(), et7Var.m());
                this.b.v0();
            } else if (this.d) {
                o08Var.U(et7Var.O().getThreadVideoInfo(), et7Var.O(), et7Var.m());
                this.b.v0();
            } else {
                o08Var.w0(et7Var.m());
            }
            h08.d(this.a.getUniqueId(), et7Var, postData, 1, 1);
            if (et7Var.K() != null && et7Var.K().size() >= 1) {
                ThreadData threadData = et7Var.K().get(0);
                this.b.p0(threadData);
                this.b.q0(threadData.getTitle());
            }
            this.b.k0(postData, et7Var.O(), et7Var.S());
            this.d = false;
            bdTypeListView.removeHeaderView(this.b.R());
            bdTypeListView.x(this.b.R(), 0);
            if (this.b.P() != null && this.b.P().getParent() == null) {
                frameLayout.addView(this.b.P());
            }
            if (this.c == null) {
                this.c = new n08(this.a.getBaseFragmentActivity());
            }
            this.c.d(et7Var, str);
            bdTypeListView.removeHeaderView(this.c.b());
            bdTypeListView.x(this.c.b(), 1);
            ey7Var.B(bdTypeListView);
            ey7Var.n(bdTypeListView, 2);
            if (this.b != null) {
                mz7Var.I(false);
                this.b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
