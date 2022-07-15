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
public class mw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<an> b;
    public tn c;
    public lw6 d;
    public qw6 e;
    public kw6 f;
    public ow6 g;
    public nw6 h;
    public pw6 i;
    public rw6 j;

    public mw6(TbPageContext tbPageContext, tn tnVar) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            lw6 lw6Var = new lw6(this.a);
            this.d = lw6Var;
            lw6Var.c0(this.c);
            this.b.add(this.d);
            qw6 qw6Var = new qw6(this.a);
            this.e = qw6Var;
            qw6Var.c0(this.c);
            this.b.add(this.e);
            kw6 kw6Var = new kw6(this.a);
            this.f = kw6Var;
            kw6Var.c0(this.c);
            this.b.add(this.f);
            ow6 ow6Var = new ow6(this.a);
            this.g = ow6Var;
            ow6Var.c0(this.c);
            this.b.add(this.g);
            nw6 nw6Var = new nw6(this.a);
            this.h = nw6Var;
            nw6Var.c0(this.c);
            this.b.add(this.h);
            pw6 pw6Var = new pw6(this.a);
            this.i = pw6Var;
            pw6Var.c0(this.c);
            this.b.add(this.i);
            rw6 rw6Var = new rw6(this.a);
            this.j = rw6Var;
            rw6Var.c0(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        tn tnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tnVar = this.c) == null) {
            return;
        }
        tnVar.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<nn> list) {
        tn tnVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (tnVar = this.c) == null) {
            return;
        }
        tnVar.setData(list);
        b();
    }

    public void d(jm4 jm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jm4Var) == null) {
            for (an anVar : this.b) {
                if (anVar instanceof jw6) {
                    ((jw6) anVar).b0(jm4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (an anVar : this.b) {
                anVar.X(bdUniqueId);
            }
        }
    }
}
