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
public class k87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<jn> b;
    public List<wm> c;
    public m87 d;
    public m87 e;
    public m87 f;

    public k87(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            m87 m87Var = new m87(tbPageContext, l87.B);
            this.d = m87Var;
            m87Var.b0(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            m87 m87Var2 = new m87(tbPageContext, l87.A);
            this.e = m87Var2;
            m87Var2.b0(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
            m87 m87Var3 = new m87(tbPageContext, l87.z);
            this.f = m87Var3;
            m87Var3.b0(VideoRecommentPlayActivityConfig.FROM_AT_PAGE);
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

    public void d(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tnVar) == null) {
            for (wm wmVar : this.c) {
                if (wmVar != null) {
                    wmVar.V(tnVar);
                }
            }
        }
    }

    public void e(ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void f(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, unVar) == null) {
            for (wm wmVar : this.c) {
                if (wmVar != null) {
                    wmVar.W(unVar);
                }
            }
        }
    }

    public void g(nw5 nw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nw5Var) == null) {
            this.f.c0(nw5Var);
            this.e.c0(nw5Var);
            this.d.c0(nw5Var);
        }
    }
}
