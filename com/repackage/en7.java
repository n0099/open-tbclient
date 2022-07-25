package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class en7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public cn7 d;
    public vm7 e;
    public xm7 f;
    public wm7 g;
    public ym7 h;
    public dn7 i;
    public zm7 j;
    public an7 k;
    public um7 l;
    public fn7 m;
    public bn7 n;
    public List<an> o;

    public en7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new LinkedList();
        this.a = tbPageContext;
        this.b = bdUniqueId;
        this.c = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            cn7 cn7Var = new cn7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = cn7Var;
            cn7Var.h0(this.c);
            this.o.add(this.d);
            vm7 vm7Var = new vm7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = vm7Var;
            vm7Var.i0(this.c);
            this.o.add(this.e);
            xm7 xm7Var = new xm7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = xm7Var;
            xm7Var.h0(this.c);
            this.o.add(this.f);
            wm7 wm7Var = new wm7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = wm7Var;
            wm7Var.h0(this.c);
            this.o.add(this.g);
            ym7 ym7Var = new ym7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = ym7Var;
            ym7Var.h0(this.c);
            this.o.add(this.h);
            dn7 dn7Var = new dn7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = dn7Var;
            dn7Var.k0(this.c);
            this.o.add(this.i);
            zm7 zm7Var = new zm7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = zm7Var;
            zm7Var.h0(this.c);
            this.o.add(this.j);
            an7 an7Var = new an7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = an7Var;
            an7Var.h0(this.c);
            this.o.add(this.k);
            um7 um7Var = new um7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = um7Var;
            um7Var.i0(this.c);
            this.o.add(this.l);
            fn7 fn7Var = new fn7(this.a, mo4.b);
            this.m = fn7Var;
            fn7Var.g0(this.c);
            this.o.add(this.m);
            bn7 bn7Var = new bn7(this.a, vy5.r0);
            this.n = bn7Var;
            this.o.add(bn7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (an anVar : this.o) {
                if (anVar instanceof tm7) {
                    ((tm7) anVar).b0(z);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.getAdapter().notifyDataSetChanged();
        }
    }

    public void d(List<? extends nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }
}
