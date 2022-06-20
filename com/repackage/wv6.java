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
/* loaded from: classes7.dex */
public class wv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<an> b;
    public tn c;
    public vv6 d;
    public aw6 e;
    public uv6 f;
    public yv6 g;
    public xv6 h;
    public zv6 i;
    public bw6 j;

    public wv6(TbPageContext tbPageContext, tn tnVar) {
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
            vv6 vv6Var = new vv6(this.a);
            this.d = vv6Var;
            vv6Var.c0(this.c);
            this.b.add(this.d);
            aw6 aw6Var = new aw6(this.a);
            this.e = aw6Var;
            aw6Var.c0(this.c);
            this.b.add(this.e);
            uv6 uv6Var = new uv6(this.a);
            this.f = uv6Var;
            uv6Var.c0(this.c);
            this.b.add(this.f);
            yv6 yv6Var = new yv6(this.a);
            this.g = yv6Var;
            yv6Var.c0(this.c);
            this.b.add(this.g);
            xv6 xv6Var = new xv6(this.a);
            this.h = xv6Var;
            xv6Var.c0(this.c);
            this.b.add(this.h);
            zv6 zv6Var = new zv6(this.a);
            this.i = zv6Var;
            zv6Var.c0(this.c);
            this.b.add(this.i);
            bw6 bw6Var = new bw6(this.a);
            this.j = bw6Var;
            bw6Var.c0(this.c);
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

    public void d(ul4 ul4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ul4Var) == null) {
            for (an anVar : this.b) {
                if (anVar instanceof tv6) {
                    ((tv6) anVar).b0(ul4Var);
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
