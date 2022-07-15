package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ws5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d9 a;
    public BdTypeListView b;
    public final List<an> c;
    public vs5 d;
    public ss5 e;
    public qs5 f;
    public rs5 g;

    public ws5(d9 d9Var, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.a = d9Var;
        this.b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                ss5 ss5Var = new ss5((TbPageContext) this.a, mt5.c);
                this.e = ss5Var;
                this.c.add(ss5Var);
            } else {
                vs5 vs5Var = new vs5((TbPageContext) this.a, mt5.c);
                this.d = vs5Var;
                this.c.add(vs5Var);
            }
            this.f = new qs5((TbPageContext) this.a, ys5.a);
            this.g = new rs5((TbPageContext) this.a, zs5.a);
            this.c.add(this.f);
            this.c.add(this.g);
            this.b.a(this.c);
        }
    }

    public void b(mo5 mo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mo5Var) == null) {
            vs5 vs5Var = this.d;
            if (vs5Var != null) {
                vs5Var.b0(mo5Var);
            }
            ss5 ss5Var = this.e;
            if (ss5Var != null) {
                ss5Var.b0(mo5Var);
            }
        }
    }

    public void c(List<nn> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
