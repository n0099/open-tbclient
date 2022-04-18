package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.template.adapter.stats.StatsType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class s95<T, V extends TypeAdapter.ViewHolder> extends ho<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public boolean j;
    public TbPageContext<?> k;
    public zo l;
    public km4 m;
    public fa5 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s95(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.j = true;
        n(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.i = i | this.i;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.n == null) {
            this.n = new fa5(this.l);
        }
    }

    public void b0(View view2, pn4 pn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, pn4Var) == null) || pn4Var == null) {
            return;
        }
        km4 km4Var = this.m;
        if (km4Var != null) {
            int i = pn4Var.position;
            km4Var.a(view2, pn4Var, i, i);
            return;
        }
        ha5.a(new ga5(StatsType.CLICK, pn4Var, view2, this.e));
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a0();
            return this.n.e;
        }
        return invokeV.intValue;
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            a0();
            return this.n.f;
        }
        return invokeV.intValue;
    }

    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            a0();
            return this.n.b;
        }
        return (String) invokeV.objValue;
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            a0();
            return this.n.g;
        }
        return invokeV.intValue;
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            a0();
            return this.n.h;
        }
        return invokeV.intValue;
    }

    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            a0();
            return this.n.a;
        }
        return invokeV.intValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            a0();
            return this.n.i;
        }
        return (String) invokeV.objValue;
    }

    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            a0();
            return this.n.c;
        }
        return (String) invokeV.objValue;
    }

    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            a0();
            return this.n.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean m0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? (i & this.i) > 0 : invokeI.booleanValue;
    }

    public void n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, tbPageContext, bdUniqueId) == null) || tbPageContext == null) {
            return;
        }
        this.a = tbPageContext.getPageActivity();
        this.k = tbPageContext;
        this.e = bdUniqueId;
    }

    public void n0(fa5 fa5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fa5Var) == null) {
            this.n = fa5Var;
        }
    }

    public void o0(km4 km4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, km4Var) == null) {
            this.m = km4Var;
        }
    }

    public void p0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            this.e = bdUniqueId;
        }
    }

    public void q0(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, zoVar) == null) {
            this.l = zoVar;
        }
    }

    public void r0(View view2, pn4 pn4Var, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{view2, pn4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) || pn4Var == null) {
            return;
        }
        km4 km4Var = this.m;
        if (km4Var != null) {
            km4Var.c(view2, pn4Var, pn4Var.position, j);
        } else {
            ha5.a(new ga5(StatsType.SHOW, pn4Var, view2, this.e));
        }
    }
}
