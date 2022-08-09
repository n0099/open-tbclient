package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ze6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lo6 a;

    public ze6(TbPageContext tbPageContext, lo6 lo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, lo6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lo6Var;
    }

    public void a(ek5 ek5Var) {
        lo6 lo6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ek5Var) == null) || (lo6Var = this.a) == null || lo6Var.K0() == null || this.a.K0().g0() == null || this.a.k1() == null || ek5Var == null || this.a.k1().d0() == null || this.a.o0() == null) {
            return;
        }
        BdTypeRecyclerView d0 = this.a.k1().d0();
        int i = ek5Var.a;
        if (i != 2) {
            if (i == 3 && ek5Var.a() != null) {
                d0.removeHeaderView(ek5Var.a());
                this.a.o0().h0(0);
            }
        } else if (ek5Var.a() == null) {
        } else {
            d0.removeHeaderView(ek5Var.a());
            d0.t(ek5Var.a(), d0.getHeaderViewsCount() - 1);
            this.a.o0().h0(8);
        }
    }
}
