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
public class ca7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<nn> b;
    public List<an> c;
    public y97 d;
    public y97 e;
    public aa7 f;
    public aa7 g;
    public aa7 h;

    public ca7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            y97 y97Var = new y97(tbPageContext, w97.x);
            this.d = y97Var;
            y97Var.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            y97 y97Var2 = new y97(tbPageContext, w97.y);
            this.e = y97Var2;
            y97Var2.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            aa7 aa7Var = new aa7(tbPageContext, w97.B);
            this.f = aa7Var;
            aa7Var.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            aa7 aa7Var2 = new aa7(tbPageContext, w97.A);
            this.g = aa7Var2;
            aa7Var2.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            aa7 aa7Var3 = new aa7(tbPageContext, w97.z);
            this.h = aa7Var3;
            aa7Var3.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (an anVar : this.c) {
            }
        }
    }

    public void e(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xnVar) == null) {
            for (an anVar : this.c) {
                if (anVar != null) {
                    anVar.V(xnVar);
                }
            }
        }
    }

    public void f(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(yn ynVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ynVar) == null) {
            for (an anVar : this.c) {
                if (anVar != null) {
                    anVar.W(ynVar);
                }
            }
        }
    }

    public void h(mx5 mx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mx5Var) == null) {
            this.h.c0(mx5Var);
            this.g.c0(mx5Var);
            this.f.c0(mx5Var);
        }
    }
}
