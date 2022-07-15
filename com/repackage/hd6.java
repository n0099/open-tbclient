package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sm6 a;

    public hd6(TbPageContext tbPageContext, sm6 sm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sm6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sm6Var;
    }

    public void a(ri5 ri5Var) {
        sm6 sm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ri5Var) == null) || (sm6Var = this.a) == null || sm6Var.L0() == null || this.a.L0().h0() == null || this.a.l1() == null || ri5Var == null || this.a.l1().d0() == null || this.a.p0() == null) {
            return;
        }
        BdTypeRecyclerView d0 = this.a.l1().d0();
        int i = ri5Var.a;
        if (i != 2) {
            if (i == 3 && ri5Var.a() != null) {
                d0.removeHeaderView(ri5Var.a());
                this.a.p0().f0(0);
            }
        } else if (ri5Var.a() == null) {
        } else {
            d0.removeHeaderView(ri5Var.a());
            d0.t(ri5Var.a(), d0.getHeaderViewsCount() - 1);
            this.a.p0().f0(8);
        }
    }
}
