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
/* loaded from: classes5.dex */
public class a95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<wm> a;
    public TbPageContext<?> b;
    public pn c;
    public p95 d;
    public l95 e;
    public e95 f;
    public g95 g;
    public f95 h;
    public h95 i;
    public i95 j;
    public k95 k;
    public j95 l;
    public n95 m;
    public m95 n;
    public o95 o;
    public c95 p;
    public b95 q;

    public a95(TbPageContext tbPageContext, pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pnVar};
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
        this.c = pnVar;
        b();
    }

    public void a(List<wm> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (wm wmVar : list) {
            if (!c(wmVar.getType())) {
                this.a.add(wmVar);
            }
        }
        this.c.a(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p95 p95Var = new p95(this.b);
            this.d = p95Var;
            p95Var.q0(this.c);
            this.a.add(this.d);
            l95 l95Var = new l95(this.b);
            this.e = l95Var;
            l95Var.q0(this.c);
            this.a.add(this.e);
            o95 o95Var = new o95(this.b);
            this.o = o95Var;
            o95Var.q0(this.c);
            this.a.add(this.o);
            e95 e95Var = new e95(this.b);
            this.f = e95Var;
            e95Var.q0(this.c);
            this.a.add(this.f);
            g95 g95Var = new g95(this.b);
            this.g = g95Var;
            g95Var.q0(this.c);
            this.a.add(this.g);
            f95 f95Var = new f95(this.b);
            this.h = f95Var;
            f95Var.q0(this.c);
            this.a.add(this.h);
            h95 h95Var = new h95(this.b);
            this.i = h95Var;
            h95Var.q0(this.c);
            this.a.add(this.i);
            i95 i95Var = new i95(this.b);
            this.j = i95Var;
            i95Var.q0(this.c);
            this.a.add(this.j);
            k95 k95Var = new k95(this.b);
            this.k = k95Var;
            k95Var.q0(this.c);
            this.a.add(this.k);
            j95 j95Var = new j95(this.b);
            this.l = j95Var;
            j95Var.q0(this.c);
            this.a.add(this.l);
            n95 n95Var = new n95(this.b);
            this.m = n95Var;
            n95Var.q0(this.c);
            this.a.add(this.m);
            m95 m95Var = new m95(this.b);
            this.n = m95Var;
            m95Var.q0(this.c);
            this.a.add(this.n);
            c95 c95Var = new c95(this.b);
            this.p = c95Var;
            c95Var.q0(this.c);
            this.a.add(this.p);
            b95 b95Var = new b95(this.b, yw5.N0);
            this.q = b95Var;
            this.a.add(b95Var);
            this.c.a(this.a);
        }
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (wm wmVar : this.a) {
                    if (wmVar != null && wmVar.getType() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        pn pnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pnVar = this.c) == null || pnVar.getListAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (wm wmVar : this.a) {
                if (wmVar instanceof d95) {
                    ((d95) wmVar).Z(i);
                }
            }
        }
    }

    public void f(q95 q95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, q95Var) == null) {
            for (wm wmVar : this.a) {
                if (wmVar instanceof d95) {
                    ((d95) wmVar).n0(q95Var);
                }
            }
        }
    }

    public void g(List<wm> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(kl4 kl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kl4Var) == null) {
            for (wm wmVar : this.a) {
                if (wmVar instanceof d95) {
                    ((d95) wmVar).o0(kl4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (wm wmVar : this.a) {
                if (wmVar instanceof d95) {
                    ((d95) wmVar).p0(bdUniqueId);
                }
            }
        }
    }

    public void k(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pnVar) == null) {
            for (wm wmVar : this.a) {
                if (wmVar instanceof d95) {
                    ((d95) wmVar).q0(pnVar);
                }
            }
        }
    }
}
