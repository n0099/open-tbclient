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
public class pc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<on> b;
    public List<bn> c;
    public lc7 d;
    public lc7 e;
    public lc7 f;
    public nc7 g;
    public nc7 h;
    public nc7 i;

    public pc7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            lc7 lc7Var = new lc7(tbPageContext, jc7.A);
            this.d = lc7Var;
            lc7Var.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            lc7 lc7Var2 = new lc7(tbPageContext, jc7.B);
            this.e = lc7Var2;
            lc7Var2.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            lc7 lc7Var3 = new lc7(tbPageContext, jc7.C);
            this.f = lc7Var3;
            lc7Var3.u(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            nc7 nc7Var = new nc7(tbPageContext, jc7.F);
            this.g = nc7Var;
            nc7Var.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            nc7 nc7Var2 = new nc7(tbPageContext, jc7.E);
            this.h = nc7Var2;
            nc7Var2.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            nc7 nc7Var3 = new nc7(tbPageContext, jc7.D);
            this.i = nc7Var3;
            nc7Var3.u(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (bn bnVar : this.c) {
            }
        }
    }

    public void e(yn ynVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ynVar) == null) {
            for (bn bnVar : this.c) {
                if (bnVar != null) {
                    bnVar.setOnAdapterItemClickListener(ynVar);
                }
            }
        }
    }

    public void f(ArrayList<on> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(zn znVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, znVar) == null) {
            for (bn bnVar : this.c) {
                if (bnVar != null) {
                    bnVar.setOnAdapterItemLongClickListener(znVar);
                }
            }
        }
    }

    public void h(b06 b06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b06Var) == null) {
            this.i.v(b06Var);
            this.h.v(b06Var);
            this.g.v(b06Var);
        }
    }
}
