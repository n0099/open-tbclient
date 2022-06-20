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
public class n95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<an> a;
    public TbPageContext<?> b;
    public tn c;
    public ca5 d;
    public y95 e;
    public r95 f;
    public t95 g;
    public s95 h;
    public u95 i;
    public v95 j;
    public x95 k;
    public w95 l;
    public aa5 m;
    public z95 n;
    public ba5 o;
    public p95 p;
    public o95 q;

    public n95(TbPageContext tbPageContext, tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tnVar};
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
        this.c = tnVar;
        b();
    }

    public void a(List<an> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (an anVar : list) {
            if (!c(anVar.getType())) {
                this.a.add(anVar);
            }
        }
        this.c.a(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ca5 ca5Var = new ca5(this.b);
            this.d = ca5Var;
            ca5Var.q0(this.c);
            this.a.add(this.d);
            y95 y95Var = new y95(this.b);
            this.e = y95Var;
            y95Var.q0(this.c);
            this.a.add(this.e);
            ba5 ba5Var = new ba5(this.b);
            this.o = ba5Var;
            ba5Var.q0(this.c);
            this.a.add(this.o);
            r95 r95Var = new r95(this.b);
            this.f = r95Var;
            r95Var.q0(this.c);
            this.a.add(this.f);
            t95 t95Var = new t95(this.b);
            this.g = t95Var;
            t95Var.q0(this.c);
            this.a.add(this.g);
            s95 s95Var = new s95(this.b);
            this.h = s95Var;
            s95Var.q0(this.c);
            this.a.add(this.h);
            u95 u95Var = new u95(this.b);
            this.i = u95Var;
            u95Var.q0(this.c);
            this.a.add(this.i);
            v95 v95Var = new v95(this.b);
            this.j = v95Var;
            v95Var.q0(this.c);
            this.a.add(this.j);
            x95 x95Var = new x95(this.b);
            this.k = x95Var;
            x95Var.q0(this.c);
            this.a.add(this.k);
            w95 w95Var = new w95(this.b);
            this.l = w95Var;
            w95Var.q0(this.c);
            this.a.add(this.l);
            aa5 aa5Var = new aa5(this.b);
            this.m = aa5Var;
            aa5Var.q0(this.c);
            this.a.add(this.m);
            z95 z95Var = new z95(this.b);
            this.n = z95Var;
            z95Var.q0(this.c);
            this.a.add(this.n);
            p95 p95Var = new p95(this.b);
            this.p = p95Var;
            p95Var.q0(this.c);
            this.a.add(this.p);
            o95 o95Var = new o95(this.b, xx5.N0);
            this.q = o95Var;
            this.a.add(o95Var);
            this.c.a(this.a);
        }
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (an anVar : this.a) {
                    if (anVar != null && anVar.getType() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        tn tnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tnVar = this.c) == null || tnVar.getListAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof q95) {
                    ((q95) anVar).Z(i);
                }
            }
        }
    }

    public void f(da5 da5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, da5Var) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof q95) {
                    ((q95) anVar).n0(da5Var);
                }
            }
        }
    }

    public void g(List<an> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(ul4 ul4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ul4Var) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof q95) {
                    ((q95) anVar).o0(ul4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof q95) {
                    ((q95) anVar).p0(bdUniqueId);
                }
            }
        }
    }

    public void k(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tnVar) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof q95) {
                    ((q95) anVar).q0(tnVar);
                }
            }
        }
    }
}
