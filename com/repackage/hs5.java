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
/* loaded from: classes6.dex */
public class hs5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b9 a;
    public BdTypeListView b;
    public final List<eo> c;
    public gs5 d;
    public ds5 e;
    public bs5 f;
    public cs5 g;

    public hs5(b9 b9Var, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, bdTypeListView, Boolean.valueOf(z)};
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
        this.a = b9Var;
        this.b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                ds5 ds5Var = new ds5((TbPageContext) this.a, xs5.c);
                this.e = ds5Var;
                this.c.add(ds5Var);
            } else {
                gs5 gs5Var = new gs5((TbPageContext) this.a, xs5.c);
                this.d = gs5Var;
                this.c.add(gs5Var);
            }
            this.f = new bs5((TbPageContext) this.a, js5.a);
            this.g = new cs5((TbPageContext) this.a, ks5.a);
            this.c.add(this.f);
            this.c.add(this.g);
            this.b.a(this.c);
        }
    }

    public void b(tn5 tn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tn5Var) == null) {
            gs5 gs5Var = this.d;
            if (gs5Var != null) {
                gs5Var.b0(tn5Var);
            }
            ds5 ds5Var = this.e;
            if (ds5Var != null) {
                ds5Var.b0(tn5Var);
            }
        }
    }

    public void c(List<ro> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeListView = this.b) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }
}
