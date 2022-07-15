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
/* loaded from: classes6.dex */
public class na7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<nn> b;
    public List<an> c;
    public pa7 d;
    public pa7 e;
    public pa7 f;

    public na7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
        bdTypeRecyclerView.D(i);
    }

    public final void b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            pa7 pa7Var = new pa7(tbPageContext, oa7.F);
            this.d = pa7Var;
            pa7Var.b0(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            pa7 pa7Var2 = new pa7(tbPageContext, oa7.E);
            this.e = pa7Var2;
            pa7Var2.b0(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            pa7 pa7Var3 = new pa7(tbPageContext, oa7.D);
            this.f = pa7Var3;
            pa7Var3.b0(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
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

    public void d(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xnVar) == null) {
            for (an anVar : this.c) {
                if (anVar != null) {
                    anVar.V(xnVar);
                }
            }
        }
    }

    public void e(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void f(yn ynVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ynVar) == null) {
            for (an anVar : this.c) {
                if (anVar != null) {
                    anVar.W(ynVar);
                }
            }
        }
    }

    public void g(jy5 jy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jy5Var) == null) {
            this.f.c0(jy5Var);
            this.e.c0(jy5Var);
            this.d.c0(jy5Var);
        }
    }
}
