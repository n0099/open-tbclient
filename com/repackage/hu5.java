package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<an> c;
    public List<nn> d;
    public jv5 e;
    public nu5 f;

    public hu5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, jv5 jv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, jv5Var};
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
        this.b = bdTypeListView;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = jv5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            gu5 gu5Var = new gu5(this.a);
            ku5 ku5Var = new ku5(this.a);
            lu5 lu5Var = new lu5(this.a);
            eu5 eu5Var = new eu5(this.a);
            ju5 ju5Var = new ju5(this.a);
            mu5 mu5Var = new mu5(this.a);
            iu5 iu5Var = new iu5(this.a);
            fu5 fu5Var = new fu5(this.a);
            this.f = new nu5(this.a);
            pu5 pu5Var = new pu5(this.a, this.e);
            ou5 ou5Var = new ou5(this.a);
            this.c.add(gu5Var);
            this.c.add(this.f);
            this.c.add(ku5Var);
            this.c.add(lu5Var);
            this.c.add(eu5Var);
            this.c.add(ju5Var);
            this.c.add(mu5Var);
            this.c.add(iu5Var);
            this.c.add(fu5Var);
            this.c.add(pu5Var);
            this.c.add(ou5Var);
            this.b.a(this.c);
        }
    }

    public void b(List<nn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.d.clear();
        this.d.addAll(list);
        this.b.setData(this.d);
    }

    public void c(String str) {
        nu5 nu5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (nu5Var = this.f) == null) {
            return;
        }
        nu5Var.k0(str);
    }

    public void d(String str) {
        nu5 nu5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (nu5Var = this.f) == null) {
            return;
        }
        nu5Var.a(str);
    }

    public void e(String str) {
        nu5 nu5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (nu5Var = this.f) == null) {
            return;
        }
        nu5Var.l0(str);
    }

    public void f(boolean z) {
        nu5 nu5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (nu5Var = this.f) == null) {
            return;
        }
        nu5Var.m0(z);
    }
}
