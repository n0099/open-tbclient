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
/* loaded from: classes7.dex */
public class rt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<ho> c;
    public List<uo> d;
    public tu5 e;
    public xt5 f;

    public rt5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, tu5 tu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, tu5Var};
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
        this.e = tu5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            qt5 qt5Var = new qt5(this.a);
            ut5 ut5Var = new ut5(this.a);
            vt5 vt5Var = new vt5(this.a);
            ot5 ot5Var = new ot5(this.a);
            tt5 tt5Var = new tt5(this.a);
            wt5 wt5Var = new wt5(this.a);
            st5 st5Var = new st5(this.a);
            pt5 pt5Var = new pt5(this.a);
            this.f = new xt5(this.a);
            zt5 zt5Var = new zt5(this.a, this.e);
            yt5 yt5Var = new yt5(this.a);
            this.c.add(qt5Var);
            this.c.add(this.f);
            this.c.add(ut5Var);
            this.c.add(vt5Var);
            this.c.add(ot5Var);
            this.c.add(tt5Var);
            this.c.add(wt5Var);
            this.c.add(st5Var);
            this.c.add(pt5Var);
            this.c.add(zt5Var);
            this.c.add(yt5Var);
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
        xt5 xt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (xt5Var = this.f) == null) {
            return;
        }
        xt5Var.k0(str);
    }

    public void d(String str) {
        xt5 xt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (xt5Var = this.f) == null) {
            return;
        }
        xt5Var.a(str);
    }

    public void e(String str) {
        xt5 xt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (xt5Var = this.f) == null) {
            return;
        }
        xt5Var.l0(str);
    }

    public void f(boolean z) {
        xt5 xt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (xt5Var = this.f) == null) {
            return;
        }
        xt5Var.m0(z);
    }
}
