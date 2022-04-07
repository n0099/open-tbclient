package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jn6 a;

    public nd6(TbPageContext tbPageContext, jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, jn6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jn6Var;
    }

    public void a(eh5 eh5Var) {
        jn6 jn6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eh5Var) == null) || (jn6Var = this.a) == null || jn6Var.b0() == null || this.a.b0().f0() == null || this.a.w0() == null || eh5Var == null || this.a.w0().c0() == null || this.a.N() == null) {
            return;
        }
        BdTypeRecyclerView c0 = this.a.w0().c0();
        int i = eh5Var.a;
        if (i != 2) {
            if (i == 3 && eh5Var.a() != null) {
                c0.removeHeaderView(eh5Var.a());
                this.a.N().e0(0);
            }
        } else if (eh5Var.a() == null) {
        } else {
            c0.removeHeaderView(eh5Var.a());
            c0.t(eh5Var.a(), c0.getHeaderViewsCount() - 1);
            this.a.N().e0(8);
        }
    }
}
