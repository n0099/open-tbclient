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
public class zv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<bn> c;
    public List<on> d;
    public bx5 e;
    public fw5 f;

    public zv5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, bx5 bx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, bx5Var};
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
        this.e = bx5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yv5 yv5Var = new yv5(this.a);
            cw5 cw5Var = new cw5(this.a);
            dw5 dw5Var = new dw5(this.a);
            wv5 wv5Var = new wv5(this.a);
            bw5 bw5Var = new bw5(this.a);
            ew5 ew5Var = new ew5(this.a);
            aw5 aw5Var = new aw5(this.a);
            xv5 xv5Var = new xv5(this.a);
            this.f = new fw5(this.a);
            hw5 hw5Var = new hw5(this.a, this.e);
            gw5 gw5Var = new gw5(this.a);
            this.c.add(yv5Var);
            this.c.add(this.f);
            this.c.add(cw5Var);
            this.c.add(dw5Var);
            this.c.add(wv5Var);
            this.c.add(bw5Var);
            this.c.add(ew5Var);
            this.c.add(aw5Var);
            this.c.add(xv5Var);
            this.c.add(hw5Var);
            this.c.add(gw5Var);
            this.b.a(this.c);
        }
    }

    public void b(List<on> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || this.b == null || ListUtils.isEmpty(list)) {
            return;
        }
        this.d.clear();
        this.d.addAll(list);
        this.b.setData(this.d);
    }

    public void c(String str) {
        fw5 fw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (fw5Var = this.f) == null) {
            return;
        }
        fw5Var.D(str);
    }

    public void d(String str) {
        fw5 fw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (fw5Var = this.f) == null) {
            return;
        }
        fw5Var.a(str);
    }

    public void e(String str) {
        fw5 fw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (fw5Var = this.f) == null) {
            return;
        }
        fw5Var.E(str);
    }

    public void f(boolean z) {
        fw5 fw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (fw5Var = this.f) == null) {
            return;
        }
        fw5Var.F(z);
    }
}
