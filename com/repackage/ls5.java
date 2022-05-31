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
public class ls5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<wm> c;
    public List<jn> d;
    public nt5 e;
    public rs5 f;

    public ls5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, nt5 nt5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, nt5Var};
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
        this.e = nt5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ks5 ks5Var = new ks5(this.a);
            os5 os5Var = new os5(this.a);
            ps5 ps5Var = new ps5(this.a);
            is5 is5Var = new is5(this.a);
            ns5 ns5Var = new ns5(this.a);
            qs5 qs5Var = new qs5(this.a);
            ms5 ms5Var = new ms5(this.a);
            js5 js5Var = new js5(this.a);
            this.f = new rs5(this.a);
            ts5 ts5Var = new ts5(this.a, this.e);
            ss5 ss5Var = new ss5(this.a);
            this.c.add(ks5Var);
            this.c.add(this.f);
            this.c.add(os5Var);
            this.c.add(ps5Var);
            this.c.add(is5Var);
            this.c.add(ns5Var);
            this.c.add(qs5Var);
            this.c.add(ms5Var);
            this.c.add(js5Var);
            this.c.add(ts5Var);
            this.c.add(ss5Var);
            this.b.a(this.c);
        }
    }

    public void b(List<jn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.d.clear();
        this.d.addAll(list);
        this.b.setData(this.d);
    }

    public void c(String str) {
        rs5 rs5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (rs5Var = this.f) == null) {
            return;
        }
        rs5Var.k0(str);
    }

    public void d(String str) {
        rs5 rs5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (rs5Var = this.f) == null) {
            return;
        }
        rs5Var.a(str);
    }

    public void e(String str) {
        rs5 rs5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (rs5Var = this.f) == null) {
            return;
        }
        rs5Var.l0(str);
    }

    public void f(boolean z) {
        rs5 rs5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (rs5Var = this.f) == null) {
            return;
        }
        rs5Var.m0(z);
    }
}
