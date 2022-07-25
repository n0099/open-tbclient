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
/* loaded from: classes7.dex */
public class ra5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<an> a;
    public TbPageContext<?> b;
    public tn c;
    public gb5 d;
    public cb5 e;
    public va5 f;
    public xa5 g;
    public wa5 h;
    public ya5 i;
    public za5 j;
    public bb5 k;
    public ab5 l;
    public eb5 m;
    public db5 n;
    public fb5 o;
    public ta5 p;
    public sa5 q;

    public ra5(TbPageContext tbPageContext, tn tnVar) {
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
            gb5 gb5Var = new gb5(this.b);
            this.d = gb5Var;
            gb5Var.q0(this.c);
            this.a.add(this.d);
            cb5 cb5Var = new cb5(this.b);
            this.e = cb5Var;
            cb5Var.q0(this.c);
            this.a.add(this.e);
            fb5 fb5Var = new fb5(this.b);
            this.o = fb5Var;
            fb5Var.q0(this.c);
            this.a.add(this.o);
            va5 va5Var = new va5(this.b);
            this.f = va5Var;
            va5Var.q0(this.c);
            this.a.add(this.f);
            xa5 xa5Var = new xa5(this.b);
            this.g = xa5Var;
            xa5Var.q0(this.c);
            this.a.add(this.g);
            wa5 wa5Var = new wa5(this.b);
            this.h = wa5Var;
            wa5Var.q0(this.c);
            this.a.add(this.h);
            ya5 ya5Var = new ya5(this.b);
            this.i = ya5Var;
            ya5Var.q0(this.c);
            this.a.add(this.i);
            za5 za5Var = new za5(this.b);
            this.j = za5Var;
            za5Var.q0(this.c);
            this.a.add(this.j);
            bb5 bb5Var = new bb5(this.b);
            this.k = bb5Var;
            bb5Var.q0(this.c);
            this.a.add(this.k);
            ab5 ab5Var = new ab5(this.b);
            this.l = ab5Var;
            ab5Var.q0(this.c);
            this.a.add(this.l);
            eb5 eb5Var = new eb5(this.b);
            this.m = eb5Var;
            eb5Var.q0(this.c);
            this.a.add(this.m);
            db5 db5Var = new db5(this.b);
            this.n = db5Var;
            db5Var.q0(this.c);
            this.a.add(this.n);
            ta5 ta5Var = new ta5(this.b);
            this.p = ta5Var;
            ta5Var.q0(this.c);
            this.a.add(this.p);
            sa5 sa5Var = new sa5(this.b, uy5.N0);
            this.q = sa5Var;
            this.a.add(sa5Var);
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
                if (anVar instanceof ua5) {
                    ((ua5) anVar).Z(i);
                }
            }
        }
    }

    public void f(hb5 hb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hb5Var) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof ua5) {
                    ((ua5) anVar).n0(hb5Var);
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

    public void i(km4 km4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, km4Var) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof ua5) {
                    ((ua5) anVar).o0(km4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof ua5) {
                    ((ua5) anVar).p0(bdUniqueId);
                }
            }
        }
    }

    public void k(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tnVar) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof ua5) {
                    ((ua5) anVar).q0(tnVar);
                }
            }
        }
    }
}
