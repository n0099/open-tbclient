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
public class tv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<eo> b;
    public xo c;
    public sv6 d;
    public wv6 e;
    public nv6 f;
    public pv6 g;
    public ov6 h;
    public qv6 i;
    public rv6 j;

    public tv6(TbPageContext tbPageContext, xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xoVar};
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
        this.c = xoVar;
        b();
    }

    public List<ro> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new vv6(this.a));
            this.b.add(new uv6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            sv6 sv6Var = new sv6(this.a);
            this.d = sv6Var;
            sv6Var.c0(this.c);
            this.b.add(this.d);
            wv6 wv6Var = new wv6(this.a);
            this.e = wv6Var;
            wv6Var.c0(this.c);
            this.b.add(this.e);
            nv6 nv6Var = new nv6(this.a);
            this.f = nv6Var;
            nv6Var.c0(this.c);
            this.b.add(this.f);
            pv6 pv6Var = new pv6(this.a);
            this.g = pv6Var;
            pv6Var.c0(this.c);
            this.b.add(this.g);
            ov6 ov6Var = new ov6(this.a);
            this.h = ov6Var;
            ov6Var.c0(this.c);
            this.b.add(this.h);
            qv6 qv6Var = new qv6(this.a);
            this.i = qv6Var;
            qv6Var.c0(this.c);
            this.b.add(this.i);
            rv6 rv6Var = new rv6(this.a);
            this.j = rv6Var;
            rv6Var.c0(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void c() {
        xo xoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (xoVar = this.c) == null) {
            return;
        }
        xoVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(vm4 vm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vm4Var) == null) {
            for (eo eoVar : this.b) {
                if (eoVar instanceof mv6) {
                    ((mv6) eoVar).b0(vm4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (eo eoVar : this.b) {
                eoVar.X(bdUniqueId);
            }
        }
    }
}
