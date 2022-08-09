package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class mx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<bn> b;
    public un c;
    public kx6 d;
    public px6 e;
    public fx6 f;
    public hx6 g;
    public gx6 h;
    public ix6 i;
    public jx6 j;
    public lx6 k;

    public mx6(TbPageContext tbPageContext, un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, unVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.c = unVar;
        b();
    }

    public List<on> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new ox6(this.a));
            this.b.add(new nx6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            kx6 kx6Var = new kx6(this.a);
            this.d = kx6Var;
            kx6Var.v(this.c);
            this.b.add(this.d);
            px6 px6Var = new px6(this.a);
            this.e = px6Var;
            px6Var.v(this.c);
            this.b.add(this.e);
            fx6 fx6Var = new fx6(this.a);
            this.f = fx6Var;
            fx6Var.v(this.c);
            this.b.add(this.f);
            hx6 hx6Var = new hx6(this.a);
            this.g = hx6Var;
            hx6Var.v(this.c);
            this.b.add(this.g);
            gx6 gx6Var = new gx6(this.a);
            this.h = gx6Var;
            gx6Var.v(this.c);
            this.b.add(this.h);
            ix6 ix6Var = new ix6(this.a);
            this.i = ix6Var;
            ix6Var.v(this.c);
            this.b.add(this.i);
            jx6 jx6Var = new jx6(this.a);
            this.j = jx6Var;
            jx6Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            lx6 lx6Var = new lx6(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = lx6Var;
            lx6Var.v(this.c);
            this.b.add(this.k);
            this.c.a(this.b);
        }
    }

    public void c() {
        un unVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (unVar = this.c) == null) {
            return;
        }
        unVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(bn4 bn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bn4Var) == null) {
            for (bn bnVar : this.b) {
                if (bnVar instanceof ex6) {
                    ((ex6) bnVar).u(bn4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (bn bnVar : this.b) {
                bnVar.setPageId(bdUniqueId);
            }
        }
    }
}
