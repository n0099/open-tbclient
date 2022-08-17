package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class fy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<bn> b;
    public un c;
    public ey6 d;
    public jy6 e;
    public dy6 f;
    public hy6 g;
    public gy6 h;
    public iy6 i;
    public ky6 j;

    public fy6(TbPageContext tbPageContext, un unVar) {
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
        this.a = tbPageContext;
        this.c = unVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            ey6 ey6Var = new ey6(this.a);
            this.d = ey6Var;
            ey6Var.v(this.c);
            this.b.add(this.d);
            jy6 jy6Var = new jy6(this.a);
            this.e = jy6Var;
            jy6Var.v(this.c);
            this.b.add(this.e);
            dy6 dy6Var = new dy6(this.a);
            this.f = dy6Var;
            dy6Var.v(this.c);
            this.b.add(this.f);
            hy6 hy6Var = new hy6(this.a);
            this.g = hy6Var;
            hy6Var.v(this.c);
            this.b.add(this.g);
            gy6 gy6Var = new gy6(this.a);
            this.h = gy6Var;
            gy6Var.v(this.c);
            this.b.add(this.h);
            iy6 iy6Var = new iy6(this.a);
            this.i = iy6Var;
            iy6Var.v(this.c);
            this.b.add(this.i);
            ky6 ky6Var = new ky6(this.a);
            this.j = ky6Var;
            ky6Var.v(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        un unVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (unVar = this.c) == null) {
            return;
        }
        unVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<on> list) {
        un unVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (unVar = this.c) == null) {
            return;
        }
        unVar.setData(list);
        b();
    }

    public void d(bn4 bn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bn4Var) == null) {
            for (bn bnVar : this.b) {
                if (bnVar instanceof cy6) {
                    ((cy6) bnVar).u(bn4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (bn bnVar : this.b) {
                bnVar.setPageId(bdUniqueId);
            }
        }
    }
}
