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
public class pt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<ho> c;
    public List<uo> d;
    public ru5 e;
    public vt5 f;

    public pt5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ru5 ru5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, ru5Var};
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
        this.e = ru5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ot5 ot5Var = new ot5(this.a);
            st5 st5Var = new st5(this.a);
            tt5 tt5Var = new tt5(this.a);
            mt5 mt5Var = new mt5(this.a);
            rt5 rt5Var = new rt5(this.a);
            ut5 ut5Var = new ut5(this.a);
            qt5 qt5Var = new qt5(this.a);
            nt5 nt5Var = new nt5(this.a);
            this.f = new vt5(this.a);
            xt5 xt5Var = new xt5(this.a, this.e);
            wt5 wt5Var = new wt5(this.a);
            this.c.add(ot5Var);
            this.c.add(this.f);
            this.c.add(st5Var);
            this.c.add(tt5Var);
            this.c.add(mt5Var);
            this.c.add(rt5Var);
            this.c.add(ut5Var);
            this.c.add(qt5Var);
            this.c.add(nt5Var);
            this.c.add(xt5Var);
            this.c.add(wt5Var);
            this.b.a(this.c);
        }
    }

    public void b(List<uo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.d.clear();
        this.d.addAll(list);
        this.b.setData(this.d);
    }

    public void c(String str) {
        vt5 vt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (vt5Var = this.f) == null) {
            return;
        }
        vt5Var.k0(str);
    }

    public void d(String str) {
        vt5 vt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (vt5Var = this.f) == null) {
            return;
        }
        vt5Var.a(str);
    }

    public void e(String str) {
        vt5 vt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (vt5Var = this.f) == null) {
            return;
        }
        vt5Var.l0(str);
    }

    public void f(boolean z) {
        vt5 vt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (vt5Var = this.f) == null) {
            return;
        }
        vt5Var.m0(z);
    }
}
