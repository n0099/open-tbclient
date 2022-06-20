package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vl6 a;

    public kc6(TbPageContext tbPageContext, vl6 vl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, vl6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vl6Var;
    }

    public void a(oh5 oh5Var) {
        vl6 vl6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oh5Var) == null) || (vl6Var = this.a) == null || vl6Var.K0() == null || this.a.K0().g0() == null || this.a.k1() == null || oh5Var == null || this.a.k1().c0() == null || this.a.o0() == null) {
            return;
        }
        BdTypeRecyclerView c0 = this.a.k1().c0();
        int i = oh5Var.a;
        if (i != 2) {
            if (i == 3 && oh5Var.a() != null) {
                c0.removeHeaderView(oh5Var.a());
                this.a.o0().g0(0);
            }
        } else if (oh5Var.a() == null) {
        } else {
            c0.removeHeaderView(oh5Var.a());
            c0.t(oh5Var.a(), c0.getHeaderViewsCount() - 1);
            this.a.o0().g0(8);
        }
    }
}
