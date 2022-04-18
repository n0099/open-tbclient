package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class tw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ho> b;
    public zo c;
    public sw6 d;
    public ww6 e;
    public nw6 f;
    public pw6 g;
    public ow6 h;
    public qw6 i;
    public rw6 j;

    public tw6(TbPageContext tbPageContext, zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, zoVar};
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
        this.c = zoVar;
        b();
    }

    public List<uo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new vw6(this.a));
            this.b.add(new uw6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            sw6 sw6Var = new sw6(this.a);
            this.d = sw6Var;
            sw6Var.c0(this.c);
            this.b.add(this.d);
            ww6 ww6Var = new ww6(this.a);
            this.e = ww6Var;
            ww6Var.c0(this.c);
            this.b.add(this.e);
            nw6 nw6Var = new nw6(this.a);
            this.f = nw6Var;
            nw6Var.c0(this.c);
            this.b.add(this.f);
            pw6 pw6Var = new pw6(this.a);
            this.g = pw6Var;
            pw6Var.c0(this.c);
            this.b.add(this.g);
            ow6 ow6Var = new ow6(this.a);
            this.h = ow6Var;
            ow6Var.c0(this.c);
            this.b.add(this.h);
            qw6 qw6Var = new qw6(this.a);
            this.i = qw6Var;
            qw6Var.c0(this.c);
            this.b.add(this.i);
            rw6 rw6Var = new rw6(this.a);
            this.j = rw6Var;
            rw6Var.c0(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void c() {
        zo zoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (zoVar = this.c) == null) {
            return;
        }
        zoVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(km4 km4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, km4Var) == null) {
            for (ho hoVar : this.b) {
                if (hoVar instanceof mw6) {
                    ((mw6) hoVar).b0(km4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (ho hoVar : this.b) {
                hoVar.X(bdUniqueId);
            }
        }
    }
}
