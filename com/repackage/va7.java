package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class va7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<ro> b;
    public List<eo> c;
    public xa7 d;
    public xa7 e;
    public xa7 f;

    public va7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        if (tbPageContext == null || bdTypeRecyclerView == null) {
            return;
        }
        this.a = bdTypeRecyclerView;
        b(tbPageContext);
    }

    public void a(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (bdTypeRecyclerView = this.a) == null) {
            return;
        }
        bdTypeRecyclerView.E(i);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            xa7 xa7Var = new xa7(tbPageContext, wa7.B);
            this.d = xa7Var;
            xa7Var.b0(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            xa7 xa7Var2 = new xa7(tbPageContext, wa7.A);
            this.e = xa7Var2;
            xa7Var2.b0(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            xa7 xa7Var3 = new xa7(tbPageContext, wa7.z);
            this.f = xa7Var3;
            xa7Var3.b0(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            this.c.add(this.f);
            this.c.add(this.e);
            this.c.add(this.d);
            this.a.a(this.c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(bp bpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bpVar) == null) {
            for (eo eoVar : this.c) {
                if (eoVar != null) {
                    eoVar.V(bpVar);
                }
            }
        }
    }

    public void e(ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void f(cp cpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cpVar) == null) {
            for (eo eoVar : this.c) {
                if (eoVar != null) {
                    eoVar.W(cpVar);
                }
            }
        }
    }

    public void g(ux5 ux5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ux5Var) == null) {
            this.f.c0(ux5Var);
            this.e.c0(ux5Var);
            this.d.c0(ux5Var);
        }
    }
}
