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
public class kt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<an> c;
    public List<nn> d;
    public mu5 e;
    public qt5 f;

    public kt5(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, mu5 mu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, mu5Var};
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
        this.e = mu5Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            jt5 jt5Var = new jt5(this.a);
            nt5 nt5Var = new nt5(this.a);
            ot5 ot5Var = new ot5(this.a);
            ht5 ht5Var = new ht5(this.a);
            mt5 mt5Var = new mt5(this.a);
            pt5 pt5Var = new pt5(this.a);
            lt5 lt5Var = new lt5(this.a);
            it5 it5Var = new it5(this.a);
            this.f = new qt5(this.a);
            st5 st5Var = new st5(this.a, this.e);
            rt5 rt5Var = new rt5(this.a);
            this.c.add(jt5Var);
            this.c.add(this.f);
            this.c.add(nt5Var);
            this.c.add(ot5Var);
            this.c.add(ht5Var);
            this.c.add(mt5Var);
            this.c.add(pt5Var);
            this.c.add(lt5Var);
            this.c.add(it5Var);
            this.c.add(st5Var);
            this.c.add(rt5Var);
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
        qt5 qt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (qt5Var = this.f) == null) {
            return;
        }
        qt5Var.k0(str);
    }

    public void d(String str) {
        qt5 qt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (qt5Var = this.f) == null) {
            return;
        }
        qt5Var.a(str);
    }

    public void e(String str) {
        qt5 qt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (qt5Var = this.f) == null) {
            return;
        }
        qt5Var.l0(str);
    }

    public void f(boolean z) {
        qt5 qt5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (qt5Var = this.f) == null) {
            return;
        }
        qt5Var.m0(z);
    }
}
