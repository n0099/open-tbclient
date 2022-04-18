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
public class kx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ho> b;
    public zo c;
    public jx6 d;
    public ox6 e;
    public ix6 f;
    public mx6 g;
    public lx6 h;
    public nx6 i;
    public px6 j;

    public kx6(TbPageContext tbPageContext, zo zoVar) {
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
        this.a = tbPageContext;
        this.c = zoVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            jx6 jx6Var = new jx6(this.a);
            this.d = jx6Var;
            jx6Var.c0(this.c);
            this.b.add(this.d);
            ox6 ox6Var = new ox6(this.a);
            this.e = ox6Var;
            ox6Var.c0(this.c);
            this.b.add(this.e);
            ix6 ix6Var = new ix6(this.a);
            this.f = ix6Var;
            ix6Var.c0(this.c);
            this.b.add(this.f);
            mx6 mx6Var = new mx6(this.a);
            this.g = mx6Var;
            mx6Var.c0(this.c);
            this.b.add(this.g);
            lx6 lx6Var = new lx6(this.a);
            this.h = lx6Var;
            lx6Var.c0(this.c);
            this.b.add(this.h);
            nx6 nx6Var = new nx6(this.a);
            this.i = nx6Var;
            nx6Var.c0(this.c);
            this.b.add(this.i);
            px6 px6Var = new px6(this.a);
            this.j = px6Var;
            px6Var.c0(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        zo zoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (zoVar = this.c) == null) {
            return;
        }
        zoVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<uo> list) {
        zo zoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (zoVar = this.c) == null) {
            return;
        }
        zoVar.setData(list);
        b();
    }

    public void d(km4 km4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, km4Var) == null) {
            for (ho hoVar : this.b) {
                if (hoVar instanceof hx6) {
                    ((hx6) hoVar).b0(km4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (ho hoVar : this.b) {
                hoVar.X(bdUniqueId);
            }
        }
    }
}
