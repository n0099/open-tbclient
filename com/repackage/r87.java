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
public class r87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<jn> b;
    public List<wm> c;
    public n87 d;
    public n87 e;
    public p87 f;
    public p87 g;
    public p87 h;

    public r87(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            n87 n87Var = new n87(tbPageContext, l87.x);
            this.d = n87Var;
            n87Var.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            n87 n87Var2 = new n87(tbPageContext, l87.y);
            this.e = n87Var2;
            n87Var2.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            p87 p87Var = new p87(tbPageContext, l87.B);
            this.f = p87Var;
            p87Var.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            p87 p87Var2 = new p87(tbPageContext, l87.A);
            this.g = p87Var2;
            p87Var2.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            p87 p87Var3 = new p87(tbPageContext, l87.z);
            this.h = p87Var3;
            p87Var3.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (wm wmVar : this.c) {
            }
        }
    }

    public void e(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tnVar) == null) {
            for (wm wmVar : this.c) {
                if (wmVar != null) {
                    wmVar.V(tnVar);
                }
            }
        }
    }

    public void f(ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, unVar) == null) {
            for (wm wmVar : this.c) {
                if (wmVar != null) {
                    wmVar.W(unVar);
                }
            }
        }
    }

    public void h(nw5 nw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nw5Var) == null) {
            this.h.c0(nw5Var);
            this.g.c0(nw5Var);
            this.f.c0(nw5Var);
        }
    }
}
