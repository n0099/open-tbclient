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
public class ga5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<eo> a;
    public TbPageContext<?> b;
    public xo c;
    public va5 d;
    public ra5 e;
    public ka5 f;
    public ma5 g;
    public la5 h;
    public na5 i;
    public oa5 j;
    public qa5 k;
    public pa5 l;
    public ta5 m;
    public sa5 n;
    public ua5 o;
    public ia5 p;
    public ha5 q;

    public ga5(TbPageContext tbPageContext, xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xoVar};
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
        this.c = xoVar;
        b();
    }

    public void a(List<eo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (eo eoVar : list) {
            if (!c(eoVar.getType())) {
                this.a.add(eoVar);
            }
        }
        this.c.a(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            va5 va5Var = new va5(this.b);
            this.d = va5Var;
            va5Var.q0(this.c);
            this.a.add(this.d);
            ra5 ra5Var = new ra5(this.b);
            this.e = ra5Var;
            ra5Var.q0(this.c);
            this.a.add(this.e);
            ua5 ua5Var = new ua5(this.b);
            this.o = ua5Var;
            ua5Var.q0(this.c);
            this.a.add(this.o);
            ka5 ka5Var = new ka5(this.b);
            this.f = ka5Var;
            ka5Var.q0(this.c);
            this.a.add(this.f);
            ma5 ma5Var = new ma5(this.b);
            this.g = ma5Var;
            ma5Var.q0(this.c);
            this.a.add(this.g);
            la5 la5Var = new la5(this.b);
            this.h = la5Var;
            la5Var.q0(this.c);
            this.a.add(this.h);
            na5 na5Var = new na5(this.b);
            this.i = na5Var;
            na5Var.q0(this.c);
            this.a.add(this.i);
            oa5 oa5Var = new oa5(this.b);
            this.j = oa5Var;
            oa5Var.q0(this.c);
            this.a.add(this.j);
            qa5 qa5Var = new qa5(this.b);
            this.k = qa5Var;
            qa5Var.q0(this.c);
            this.a.add(this.k);
            pa5 pa5Var = new pa5(this.b);
            this.l = pa5Var;
            pa5Var.q0(this.c);
            this.a.add(this.l);
            ta5 ta5Var = new ta5(this.b);
            this.m = ta5Var;
            ta5Var.q0(this.c);
            this.a.add(this.m);
            sa5 sa5Var = new sa5(this.b);
            this.n = sa5Var;
            sa5Var.q0(this.c);
            this.a.add(this.n);
            ia5 ia5Var = new ia5(this.b);
            this.p = ia5Var;
            ia5Var.q0(this.c);
            this.a.add(this.p);
            ha5 ha5Var = new ha5(this.b, fy5.N0);
            this.q = ha5Var;
            this.a.add(ha5Var);
            this.c.a(this.a);
        }
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (eo eoVar : this.a) {
                    if (eoVar != null && eoVar.getType() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        xo xoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (xoVar = this.c) == null || xoVar.getListAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (eo eoVar : this.a) {
                if (eoVar instanceof ja5) {
                    ((ja5) eoVar).Z(i);
                }
            }
        }
    }

    public void f(wa5 wa5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wa5Var) == null) {
            for (eo eoVar : this.a) {
                if (eoVar instanceof ja5) {
                    ((ja5) eoVar).n0(wa5Var);
                }
            }
        }
    }

    public void g(List<eo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(vm4 vm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vm4Var) == null) {
            for (eo eoVar : this.a) {
                if (eoVar instanceof ja5) {
                    ((ja5) eoVar).o0(vm4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (eo eoVar : this.a) {
                if (eoVar instanceof ja5) {
                    ((ja5) eoVar).p0(bdUniqueId);
                }
            }
        }
    }

    public void k(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xoVar) == null) {
            for (eo eoVar : this.a) {
                if (eoVar instanceof ja5) {
                    ((ja5) eoVar).q0(xoVar);
                }
            }
        }
    }
}
