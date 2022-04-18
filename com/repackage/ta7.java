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
public class ta7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public ArrayList<uo> b;
    public List<ho> c;
    public pa7 d;
    public pa7 e;
    public ra7 f;
    public ra7 g;
    public ra7 h;

    public ta7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
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
            pa7 pa7Var = new pa7(tbPageContext, oa7.x);
            this.d = pa7Var;
            pa7Var.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            pa7 pa7Var2 = new pa7(tbPageContext, oa7.y);
            this.e = pa7Var2;
            pa7Var2.b0(VideoRecommentPlayActivityConfig.FROM_AGREE_PAGE);
            ra7 ra7Var = new ra7(tbPageContext, oa7.B);
            this.f = ra7Var;
            ra7Var.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            ra7 ra7Var2 = new ra7(tbPageContext, oa7.A);
            this.g = ra7Var2;
            ra7Var2.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            ra7 ra7Var3 = new ra7(tbPageContext, oa7.z);
            this.h = ra7Var3;
            ra7Var3.b0(VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
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
            for (ho hoVar : this.c) {
            }
        }
    }

    public void e(dp dpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dpVar) == null) {
            for (ho hoVar : this.c) {
                if (hoVar != null) {
                    hoVar.V(dpVar);
                }
            }
        }
    }

    public void f(ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            this.a.setData(arrayList);
            this.b = arrayList;
        }
    }

    public void g(ep epVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, epVar) == null) {
            for (ho hoVar : this.c) {
                if (hoVar != null) {
                    hoVar.W(epVar);
                }
            }
        }
    }

    public void h(tx5 tx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tx5Var) == null) {
            this.h.c0(tx5Var);
            this.g.c0(tx5Var);
            this.f.c0(tx5Var);
        }
    }
}
