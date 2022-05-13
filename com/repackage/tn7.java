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
/* loaded from: classes7.dex */
public class tn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public rn7 d;
    public kn7 e;
    public mn7 f;
    public ln7 g;
    public nn7 h;
    public sn7 i;
    public on7 j;
    public pn7 k;
    public jn7 l;
    public un7 m;
    public qn7 n;
    public List<eo> o;

    public tn7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            rn7 rn7Var = new rn7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = rn7Var;
            rn7Var.h0(this.c);
            this.o.add(this.d);
            kn7 kn7Var = new kn7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = kn7Var;
            kn7Var.i0(this.c);
            this.o.add(this.e);
            mn7 mn7Var = new mn7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = mn7Var;
            mn7Var.h0(this.c);
            this.o.add(this.f);
            ln7 ln7Var = new ln7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = ln7Var;
            ln7Var.h0(this.c);
            this.o.add(this.g);
            nn7 nn7Var = new nn7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = nn7Var;
            nn7Var.h0(this.c);
            this.o.add(this.h);
            sn7 sn7Var = new sn7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = sn7Var;
            sn7Var.k0(this.c);
            this.o.add(this.i);
            on7 on7Var = new on7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = on7Var;
            on7Var.h0(this.c);
            this.o.add(this.j);
            pn7 pn7Var = new pn7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = pn7Var;
            pn7Var.h0(this.c);
            this.o.add(this.k);
            jn7 jn7Var = new jn7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = jn7Var;
            jn7Var.i0(this.c);
            this.o.add(this.l);
            un7 un7Var = new un7(this.a, xo4.b);
            this.m = un7Var;
            un7Var.g0(this.c);
            this.o.add(this.m);
            qn7 qn7Var = new qn7(this.a, gy5.r0);
            this.n = qn7Var;
            this.o.add(qn7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (eo eoVar : this.o) {
                if (eoVar instanceof in7) {
                    ((in7) eoVar).b0(z);
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

    public void d(List<? extends ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }
}
