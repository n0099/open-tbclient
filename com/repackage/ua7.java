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
public class ua7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<nn> b;
    public List<an> c;
    public qa7 d;
    public qa7 e;
    public qa7 f;
    public sa7 g;
    public sa7 h;
    public sa7 i;

    public ua7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            qa7 qa7Var = new qa7(tbPageContext, oa7.A);
            this.d = qa7Var;
            qa7Var.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            qa7 qa7Var2 = new qa7(tbPageContext, oa7.B);
            this.e = qa7Var2;
            qa7Var2.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            qa7 qa7Var3 = new qa7(tbPageContext, oa7.C);
            this.f = qa7Var3;
            qa7Var3.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            sa7 sa7Var = new sa7(tbPageContext, oa7.F);
            this.g = sa7Var;
            sa7Var.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            sa7 sa7Var2 = new sa7(tbPageContext, oa7.E);
            this.h = sa7Var2;
            sa7Var2.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            sa7 sa7Var3 = new sa7(tbPageContext, oa7.D);
            this.i = sa7Var3;
            sa7Var3.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            this.c.add(this.d);
            this.c.add(this.e);
            this.c.add(this.g);
            this.c.add(this.h);
            this.c.add(this.i);
            this.c.add(this.f);
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

    public void h(jy5 jy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jy5Var) == null) {
            this.i.c0(jy5Var);
            this.h.c0(jy5Var);
            this.g.c0(jy5Var);
        }
    }
}
