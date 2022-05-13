package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class kw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<eo> b;
    public xo c;
    public jw6 d;
    public ow6 e;
    public iw6 f;
    public mw6 g;
    public lw6 h;
    public nw6 i;
    public pw6 j;

    public kw6(TbPageContext tbPageContext, xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xoVar};
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
        this.c = xoVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            jw6 jw6Var = new jw6(this.a);
            this.d = jw6Var;
            jw6Var.c0(this.c);
            this.b.add(this.d);
            ow6 ow6Var = new ow6(this.a);
            this.e = ow6Var;
            ow6Var.c0(this.c);
            this.b.add(this.e);
            iw6 iw6Var = new iw6(this.a);
            this.f = iw6Var;
            iw6Var.c0(this.c);
            this.b.add(this.f);
            mw6 mw6Var = new mw6(this.a);
            this.g = mw6Var;
            mw6Var.c0(this.c);
            this.b.add(this.g);
            lw6 lw6Var = new lw6(this.a);
            this.h = lw6Var;
            lw6Var.c0(this.c);
            this.b.add(this.h);
            nw6 nw6Var = new nw6(this.a);
            this.i = nw6Var;
            nw6Var.c0(this.c);
            this.b.add(this.i);
            pw6 pw6Var = new pw6(this.a);
            this.j = pw6Var;
            pw6Var.c0(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        xo xoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (xoVar = this.c) == null) {
            return;
        }
        xoVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<ro> list) {
        xo xoVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (xoVar = this.c) == null) {
            return;
        }
        xoVar.setData(list);
        b();
    }

    public void d(vm4 vm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vm4Var) == null) {
            for (eo eoVar : this.b) {
                if (eoVar instanceof hw6) {
                    ((hw6) eoVar).b0(vm4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (eo eoVar : this.b) {
                eoVar.X(bdUniqueId);
            }
        }
    }
}
