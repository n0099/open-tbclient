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
public class qa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<an> a;
    public TbPageContext<?> b;
    public tn c;
    public fb5 d;
    public bb5 e;
    public ua5 f;
    public wa5 g;
    public va5 h;
    public xa5 i;
    public ya5 j;
    public ab5 k;
    public za5 l;
    public db5 m;
    public cb5 n;
    public eb5 o;
    public sa5 p;
    public ra5 q;

    public qa5(TbPageContext tbPageContext, tn tnVar) {
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
            fb5 fb5Var = new fb5(this.b);
            this.d = fb5Var;
            fb5Var.q0(this.c);
            this.a.add(this.d);
            bb5 bb5Var = new bb5(this.b);
            this.e = bb5Var;
            bb5Var.q0(this.c);
            this.a.add(this.e);
            eb5 eb5Var = new eb5(this.b);
            this.o = eb5Var;
            eb5Var.q0(this.c);
            this.a.add(this.o);
            ua5 ua5Var = new ua5(this.b);
            this.f = ua5Var;
            ua5Var.q0(this.c);
            this.a.add(this.f);
            wa5 wa5Var = new wa5(this.b);
            this.g = wa5Var;
            wa5Var.q0(this.c);
            this.a.add(this.g);
            va5 va5Var = new va5(this.b);
            this.h = va5Var;
            va5Var.q0(this.c);
            this.a.add(this.h);
            xa5 xa5Var = new xa5(this.b);
            this.i = xa5Var;
            xa5Var.q0(this.c);
            this.a.add(this.i);
            ya5 ya5Var = new ya5(this.b);
            this.j = ya5Var;
            ya5Var.q0(this.c);
            this.a.add(this.j);
            ab5 ab5Var = new ab5(this.b);
            this.k = ab5Var;
            ab5Var.q0(this.c);
            this.a.add(this.k);
            za5 za5Var = new za5(this.b);
            this.l = za5Var;
            za5Var.q0(this.c);
            this.a.add(this.l);
            db5 db5Var = new db5(this.b);
            this.m = db5Var;
            db5Var.q0(this.c);
            this.a.add(this.m);
            cb5 cb5Var = new cb5(this.b);
            this.n = cb5Var;
            cb5Var.q0(this.c);
            this.a.add(this.n);
            sa5 sa5Var = new sa5(this.b);
            this.p = sa5Var;
            sa5Var.q0(this.c);
            this.a.add(this.p);
            ra5 ra5Var = new ra5(this.b, uy5.N0);
            this.q = ra5Var;
            this.a.add(ra5Var);
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
                if (anVar instanceof ta5) {
                    ((ta5) anVar).Z(i);
                }
            }
        }
    }

    public void f(gb5 gb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gb5Var) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof ta5) {
                    ((ta5) anVar).n0(gb5Var);
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

    public void i(jm4 jm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jm4Var) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof ta5) {
                    ((ta5) anVar).o0(jm4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof ta5) {
                    ((ta5) anVar).p0(bdUniqueId);
                }
            }
        }
    }

    public void k(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tnVar) == null) {
            for (an anVar : this.a) {
                if (anVar instanceof ta5) {
                    ((ta5) anVar).q0(tnVar);
                }
            }
        }
    }
}
