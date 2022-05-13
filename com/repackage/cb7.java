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
/* loaded from: classes5.dex */
public class cb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<ro> b;
    public List<eo> c;
    public ya7 d;
    public ya7 e;
    public ab7 f;
    public ab7 g;
    public ab7 h;

    public cb7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            ya7 ya7Var = new ya7(tbPageContext, wa7.x);
            this.d = ya7Var;
            ya7Var.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            ya7 ya7Var2 = new ya7(tbPageContext, wa7.y);
            this.e = ya7Var2;
            ya7Var2.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            ab7 ab7Var = new ab7(tbPageContext, wa7.B);
            this.f = ab7Var;
            ab7Var.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            ab7 ab7Var2 = new ab7(tbPageContext, wa7.A);
            this.g = ab7Var2;
            ab7Var2.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            ab7 ab7Var3 = new ab7(tbPageContext, wa7.z);
            this.h = ab7Var3;
            ab7Var3.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.f);
            this.c.add(this.g);
            this.c.add(this.h);
            this.a.a(this.c);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.getAdapter().notifyDataSetChanged();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (eo eoVar : this.c) {
            }
        }
    }

    public void e(bp bpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bpVar) == null) {
            for (eo eoVar : this.c) {
                if (eoVar != null) {
                    eoVar.V(bpVar);
                }
            }
        }
    }

    public void f(ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(cp cpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cpVar) == null) {
            for (eo eoVar : this.c) {
                if (eoVar != null) {
                    eoVar.W(cpVar);
                }
            }
        }
    }

    public void h(ux5 ux5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ux5Var) == null) {
            this.h.c0(ux5Var);
            this.g.c0(ux5Var);
            this.f.c0(ux5Var);
        }
    }
}
