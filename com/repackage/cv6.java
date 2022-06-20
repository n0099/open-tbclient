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
/* loaded from: classes5.dex */
public class cv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<an> b;
    public tn c;
    public bv6 d;
    public fv6 e;
    public wu6 f;
    public yu6 g;
    public xu6 h;
    public zu6 i;
    public av6 j;

    public cv6(TbPageContext tbPageContext, tn tnVar) {
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
            arrayList.add(new ev6(this.a));
            this.b.add(new dv6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            bv6 bv6Var = new bv6(this.a);
            this.d = bv6Var;
            bv6Var.c0(this.c);
            this.b.add(this.d);
            fv6 fv6Var = new fv6(this.a);
            this.e = fv6Var;
            fv6Var.c0(this.c);
            this.b.add(this.e);
            wu6 wu6Var = new wu6(this.a);
            this.f = wu6Var;
            wu6Var.c0(this.c);
            this.b.add(this.f);
            yu6 yu6Var = new yu6(this.a);
            this.g = yu6Var;
            yu6Var.c0(this.c);
            this.b.add(this.g);
            xu6 xu6Var = new xu6(this.a);
            this.h = xu6Var;
            xu6Var.c0(this.c);
            this.b.add(this.h);
            zu6 zu6Var = new zu6(this.a);
            this.i = zu6Var;
            zu6Var.c0(this.c);
            this.b.add(this.i);
            av6 av6Var = new av6(this.a);
            this.j = av6Var;
            av6Var.c0(this.c);
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

    public void e(ul4 ul4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ul4Var) == null) {
            for (an anVar : this.b) {
                if (anVar instanceof vu6) {
                    ((vu6) anVar).b0(ul4Var);
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
