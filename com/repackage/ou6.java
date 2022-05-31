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
public class ou6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<wm> b;
    public pn c;
    public nu6 d;
    public su6 e;
    public mu6 f;
    public qu6 g;
    public pu6 h;
    public ru6 i;
    public tu6 j;

    public ou6(TbPageContext tbPageContext, pn pnVar) {
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
        this.a = tbPageContext;
        this.c = pnVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            nu6 nu6Var = new nu6(this.a);
            this.d = nu6Var;
            nu6Var.c0(this.c);
            this.b.add(this.d);
            su6 su6Var = new su6(this.a);
            this.e = su6Var;
            su6Var.c0(this.c);
            this.b.add(this.e);
            mu6 mu6Var = new mu6(this.a);
            this.f = mu6Var;
            mu6Var.c0(this.c);
            this.b.add(this.f);
            qu6 qu6Var = new qu6(this.a);
            this.g = qu6Var;
            qu6Var.c0(this.c);
            this.b.add(this.g);
            pu6 pu6Var = new pu6(this.a);
            this.h = pu6Var;
            pu6Var.c0(this.c);
            this.b.add(this.h);
            ru6 ru6Var = new ru6(this.a);
            this.i = ru6Var;
            ru6Var.c0(this.c);
            this.b.add(this.i);
            tu6 tu6Var = new tu6(this.a);
            this.j = tu6Var;
            tu6Var.c0(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        pn pnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pnVar = this.c) == null) {
            return;
        }
        pnVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<jn> list) {
        pn pnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (pnVar = this.c) == null) {
            return;
        }
        pnVar.setData(list);
        b();
    }

    public void d(kl4 kl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kl4Var) == null) {
            for (wm wmVar : this.b) {
                if (wmVar instanceof lu6) {
                    ((lu6) wmVar).b0(kl4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (wm wmVar : this.b) {
                wmVar.X(bdUniqueId);
            }
        }
    }
}
