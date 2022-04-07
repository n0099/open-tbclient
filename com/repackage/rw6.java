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
public class rw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ho> b;
    public zo c;
    public qw6 d;
    public uw6 e;
    public lw6 f;
    public nw6 g;
    public mw6 h;
    public ow6 i;
    public pw6 j;

    public rw6(TbPageContext tbPageContext, zo zoVar) {
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
            arrayList.add(new tw6(this.a));
            this.b.add(new sw6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            qw6 qw6Var = new qw6(this.a);
            this.d = qw6Var;
            qw6Var.c0(this.c);
            this.b.add(this.d);
            uw6 uw6Var = new uw6(this.a);
            this.e = uw6Var;
            uw6Var.c0(this.c);
            this.b.add(this.e);
            lw6 lw6Var = new lw6(this.a);
            this.f = lw6Var;
            lw6Var.c0(this.c);
            this.b.add(this.f);
            nw6 nw6Var = new nw6(this.a);
            this.g = nw6Var;
            nw6Var.c0(this.c);
            this.b.add(this.g);
            mw6 mw6Var = new mw6(this.a);
            this.h = mw6Var;
            mw6Var.c0(this.c);
            this.b.add(this.h);
            ow6 ow6Var = new ow6(this.a);
            this.i = ow6Var;
            ow6Var.c0(this.c);
            this.b.add(this.i);
            pw6 pw6Var = new pw6(this.a);
            this.j = pw6Var;
            pw6Var.c0(this.c);
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

    public void e(lm4 lm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lm4Var) == null) {
            for (ho hoVar : this.b) {
                if (hoVar instanceof kw6) {
                    ((kw6) hoVar).b0(lm4Var);
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
