package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class p95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ho> a;
    public TbPageContext<?> b;
    public zo c;
    public ea5 d;
    public aa5 e;
    public t95 f;
    public v95 g;
    public u95 h;
    public w95 i;
    public x95 j;
    public z95 k;
    public y95 l;
    public ca5 m;
    public ba5 n;
    public da5 o;
    public r95 p;
    public q95 q;

    public p95(TbPageContext tbPageContext, zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, zoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.b = tbPageContext;
        this.c = zoVar;
        b();
    }

    public void a(List<ho> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (ho hoVar : list) {
            if (!c(hoVar.getType())) {
                this.a.add(hoVar);
            }
        }
        this.c.a(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ea5 ea5Var = new ea5(this.b);
            this.d = ea5Var;
            ea5Var.q0(this.c);
            this.a.add(this.d);
            aa5 aa5Var = new aa5(this.b);
            this.e = aa5Var;
            aa5Var.q0(this.c);
            this.a.add(this.e);
            da5 da5Var = new da5(this.b);
            this.o = da5Var;
            da5Var.q0(this.c);
            this.a.add(this.o);
            t95 t95Var = new t95(this.b);
            this.f = t95Var;
            t95Var.q0(this.c);
            this.a.add(this.f);
            v95 v95Var = new v95(this.b);
            this.g = v95Var;
            v95Var.q0(this.c);
            this.a.add(this.g);
            u95 u95Var = new u95(this.b);
            this.h = u95Var;
            u95Var.q0(this.c);
            this.a.add(this.h);
            w95 w95Var = new w95(this.b);
            this.i = w95Var;
            w95Var.q0(this.c);
            this.a.add(this.i);
            x95 x95Var = new x95(this.b);
            this.j = x95Var;
            x95Var.q0(this.c);
            this.a.add(this.j);
            z95 z95Var = new z95(this.b);
            this.k = z95Var;
            z95Var.q0(this.c);
            this.a.add(this.k);
            y95 y95Var = new y95(this.b);
            this.l = y95Var;
            y95Var.q0(this.c);
            this.a.add(this.l);
            ca5 ca5Var = new ca5(this.b);
            this.m = ca5Var;
            ca5Var.q0(this.c);
            this.a.add(this.m);
            ba5 ba5Var = new ba5(this.b);
            this.n = ba5Var;
            ba5Var.q0(this.c);
            this.a.add(this.n);
            r95 r95Var = new r95(this.b);
            this.p = r95Var;
            r95Var.q0(this.c);
            this.a.add(this.p);
            q95 q95Var = new q95(this.b, cy5.N0);
            this.q = q95Var;
            this.a.add(q95Var);
            this.c.a(this.a);
        }
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (ho hoVar : this.a) {
                    if (hoVar != null && hoVar.getType() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        zo zoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (zoVar = this.c) == null || zoVar.getListAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (ho hoVar : this.a) {
                if (hoVar instanceof s95) {
                    ((s95) hoVar).Z(i);
                }
            }
        }
    }

    public void f(fa5 fa5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fa5Var) == null) {
            for (ho hoVar : this.a) {
                if (hoVar instanceof s95) {
                    ((s95) hoVar).n0(fa5Var);
                }
            }
        }
    }

    public void g(List<ho> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(lm4 lm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lm4Var) == null) {
            for (ho hoVar : this.a) {
                if (hoVar instanceof s95) {
                    ((s95) hoVar).o0(lm4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (ho hoVar : this.a) {
                if (hoVar instanceof s95) {
                    ((s95) hoVar).p0(bdUniqueId);
                }
            }
        }
    }

    public void k(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zoVar) == null) {
            for (ho hoVar : this.a) {
                if (hoVar instanceof s95) {
                    ((s95) hoVar).q0(zoVar);
                }
            }
        }
    }
}
