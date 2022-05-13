package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mm6 a;

    public uc6(TbPageContext tbPageContext, mm6 mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, mm6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mm6Var;
    }

    public void a(xh5 xh5Var) {
        mm6 mm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, xh5Var) == null) || (mm6Var = this.a) == null || mm6Var.b0() == null || this.a.b0().f0() == null || this.a.w0() == null || xh5Var == null || this.a.w0().c0() == null || this.a.N() == null) {
            return;
        }
        BdTypeRecyclerView c0 = this.a.w0().c0();
        int i = xh5Var.a;
        if (i != 2) {
            if (i == 3 && xh5Var.a() != null) {
                c0.removeHeaderView(xh5Var.a());
                this.a.N().f0(0);
            }
        } else if (xh5Var.a() == null) {
        } else {
            c0.removeHeaderView(xh5Var.a());
            c0.t(xh5Var.a(), c0.getHeaderViewsCount() - 1);
            this.a.N().f0(8);
        }
    }
}
