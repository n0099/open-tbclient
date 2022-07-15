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
public class sv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<an> b;
    public tn c;
    public rv6 d;
    public vv6 e;
    public mv6 f;
    public ov6 g;
    public nv6 h;
    public pv6 i;
    public qv6 j;

    public sv6(TbPageContext tbPageContext, tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tnVar};
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
        this.c = tnVar;
        b();
    }

    public List<nn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new uv6(this.a));
            this.b.add(new tv6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            rv6 rv6Var = new rv6(this.a);
            this.d = rv6Var;
            rv6Var.c0(this.c);
            this.b.add(this.d);
            vv6 vv6Var = new vv6(this.a);
            this.e = vv6Var;
            vv6Var.c0(this.c);
            this.b.add(this.e);
            mv6 mv6Var = new mv6(this.a);
            this.f = mv6Var;
            mv6Var.c0(this.c);
            this.b.add(this.f);
            ov6 ov6Var = new ov6(this.a);
            this.g = ov6Var;
            ov6Var.c0(this.c);
            this.b.add(this.g);
            nv6 nv6Var = new nv6(this.a);
            this.h = nv6Var;
            nv6Var.c0(this.c);
            this.b.add(this.h);
            pv6 pv6Var = new pv6(this.a);
            this.i = pv6Var;
            pv6Var.c0(this.c);
            this.b.add(this.i);
            qv6 qv6Var = new qv6(this.a);
            this.j = qv6Var;
            qv6Var.c0(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void c() {
        tn tnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tnVar = this.c) == null) {
            return;
        }
        tnVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(jm4 jm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jm4Var) == null) {
            for (an anVar : this.b) {
                if (anVar instanceof lv6) {
                    ((lv6) anVar).b0(jm4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (an anVar : this.b) {
                anVar.X(bdUniqueId);
            }
        }
    }
}
