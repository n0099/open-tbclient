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
public class ix6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ho> b;
    public zo c;
    public hx6 d;
    public mx6 e;
    public gx6 f;
    public kx6 g;
    public jx6 h;
    public lx6 i;
    public nx6 j;

    public ix6(TbPageContext tbPageContext, zo zoVar) {
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
            hx6 hx6Var = new hx6(this.a);
            this.d = hx6Var;
            hx6Var.c0(this.c);
            this.b.add(this.d);
            mx6 mx6Var = new mx6(this.a);
            this.e = mx6Var;
            mx6Var.c0(this.c);
            this.b.add(this.e);
            gx6 gx6Var = new gx6(this.a);
            this.f = gx6Var;
            gx6Var.c0(this.c);
            this.b.add(this.f);
            kx6 kx6Var = new kx6(this.a);
            this.g = kx6Var;
            kx6Var.c0(this.c);
            this.b.add(this.g);
            jx6 jx6Var = new jx6(this.a);
            this.h = jx6Var;
            jx6Var.c0(this.c);
            this.b.add(this.h);
            lx6 lx6Var = new lx6(this.a);
            this.i = lx6Var;
            lx6Var.c0(this.c);
            this.b.add(this.i);
            nx6 nx6Var = new nx6(this.a);
            this.j = nx6Var;
            nx6Var.c0(this.c);
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

    public void d(lm4 lm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lm4Var) == null) {
            for (ho hoVar : this.b) {
                if (hoVar instanceof fx6) {
                    ((fx6) hoVar).b0(lm4Var);
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
