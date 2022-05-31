package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sk6 a;

    public kb6(TbPageContext tbPageContext, sk6 sk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sk6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sk6Var;
    }

    public void a(rg5 rg5Var) {
        sk6 sk6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rg5Var) == null) || (sk6Var = this.a) == null || sk6Var.c0() == null || this.a.c0().f0() == null || this.a.y0() == null || rg5Var == null || this.a.y0().c0() == null || this.a.N() == null) {
            return;
        }
        BdTypeRecyclerView c0 = this.a.y0().c0();
        int i = rg5Var.a;
        if (i != 2) {
            if (i == 3 && rg5Var.a() != null) {
                c0.removeHeaderView(rg5Var.a());
                this.a.N().e0(0);
            }
        } else if (rg5Var.a() == null) {
        } else {
            c0.removeHeaderView(rg5Var.a());
            c0.t(rg5Var.a(), c0.getHeaderViewsCount() - 1);
            this.a.N().e0(8);
        }
    }
}
