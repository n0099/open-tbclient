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
public class pb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<bn> a;
    public TbPageContext<?> b;
    public un c;
    public ec5 d;
    public ac5 e;
    public tb5 f;
    public vb5 g;
    public ub5 h;
    public wb5 i;
    public xb5 j;
    public zb5 k;
    public yb5 l;
    public cc5 m;
    public bc5 n;
    public dc5 o;
    public rb5 p;
    public qb5 q;

    public pb5(TbPageContext tbPageContext, un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, unVar};
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
        this.c = unVar;
        b();
    }

    public void a(List<bn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (bn bnVar : list) {
            if (!c(bnVar.getType())) {
                this.a.add(bnVar);
            }
        }
        this.c.a(this.a);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ec5 ec5Var = new ec5(this.b);
            this.d = ec5Var;
            ec5Var.K(this.c);
            this.a.add(this.d);
            ac5 ac5Var = new ac5(this.b);
            this.e = ac5Var;
            ac5Var.K(this.c);
            this.a.add(this.e);
            dc5 dc5Var = new dc5(this.b);
            this.o = dc5Var;
            dc5Var.K(this.c);
            this.a.add(this.o);
            tb5 tb5Var = new tb5(this.b);
            this.f = tb5Var;
            tb5Var.K(this.c);
            this.a.add(this.f);
            vb5 vb5Var = new vb5(this.b);
            this.g = vb5Var;
            vb5Var.K(this.c);
            this.a.add(this.g);
            ub5 ub5Var = new ub5(this.b);
            this.h = ub5Var;
            ub5Var.K(this.c);
            this.a.add(this.h);
            wb5 wb5Var = new wb5(this.b);
            this.i = wb5Var;
            wb5Var.K(this.c);
            this.a.add(this.i);
            xb5 xb5Var = new xb5(this.b);
            this.j = xb5Var;
            xb5Var.K(this.c);
            this.a.add(this.j);
            zb5 zb5Var = new zb5(this.b);
            this.k = zb5Var;
            zb5Var.K(this.c);
            this.a.add(this.k);
            yb5 yb5Var = new yb5(this.b);
            this.l = yb5Var;
            yb5Var.K(this.c);
            this.a.add(this.l);
            cc5 cc5Var = new cc5(this.b);
            this.m = cc5Var;
            cc5Var.K(this.c);
            this.a.add(this.m);
            bc5 bc5Var = new bc5(this.b);
            this.n = bc5Var;
            bc5Var.K(this.c);
            this.a.add(this.n);
            rb5 rb5Var = new rb5(this.b);
            this.p = rb5Var;
            rb5Var.K(this.c);
            this.a.add(this.p);
            qb5 qb5Var = new qb5(this.b, m06.N0);
            this.q = qb5Var;
            this.a.add(qb5Var);
            this.c.a(this.a);
        }
    }

    public boolean c(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId)) == null) {
            if (bdUniqueId != null && !ListUtils.isEmpty(this.a)) {
                for (bn bnVar : this.a) {
                    if (bnVar != null && bnVar.getType() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        un unVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (unVar = this.c) == null || unVar.getListAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (bn bnVar : this.a) {
                if (bnVar instanceof sb5) {
                    ((sb5) bnVar).s(i);
                }
            }
        }
    }

    public void f(fc5 fc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fc5Var) == null) {
            for (bn bnVar : this.a) {
                if (bnVar instanceof sb5) {
                    ((sb5) bnVar).G(fc5Var);
                }
            }
        }
    }

    public void g(List<bn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.clear();
        this.c.a(this.a);
    }

    public void h(List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void i(bn4 bn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bn4Var) == null) {
            for (bn bnVar : this.a) {
                if (bnVar instanceof sb5) {
                    ((sb5) bnVar).H(bn4Var);
                }
            }
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            for (bn bnVar : this.a) {
                if (bnVar instanceof sb5) {
                    ((sb5) bnVar).J(bdUniqueId);
                }
            }
        }
    }

    public void k(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, unVar) == null) {
            for (bn bnVar : this.a) {
                if (bnVar instanceof sb5) {
                    ((sb5) bnVar).K(unVar);
                }
            }
        }
    }
}
