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
public class qn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public on7 d;
    public hn7 e;
    public jn7 f;
    public in7 g;
    public kn7 h;
    public pn7 i;
    public ln7 j;
    public mn7 k;
    public gn7 l;
    public rn7 m;
    public nn7 n;
    public List<ho> o;

    public qn7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            on7 on7Var = new on7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = on7Var;
            on7Var.h0(this.c);
            this.o.add(this.d);
            hn7 hn7Var = new hn7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = hn7Var;
            hn7Var.i0(this.c);
            this.o.add(this.e);
            jn7 jn7Var = new jn7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = jn7Var;
            jn7Var.h0(this.c);
            this.o.add(this.f);
            in7 in7Var = new in7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = in7Var;
            in7Var.h0(this.c);
            this.o.add(this.g);
            kn7 kn7Var = new kn7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = kn7Var;
            kn7Var.h0(this.c);
            this.o.add(this.h);
            pn7 pn7Var = new pn7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = pn7Var;
            pn7Var.k0(this.c);
            this.o.add(this.i);
            ln7 ln7Var = new ln7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = ln7Var;
            ln7Var.h0(this.c);
            this.o.add(this.j);
            mn7 mn7Var = new mn7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = mn7Var;
            mn7Var.h0(this.c);
            this.o.add(this.k);
            gn7 gn7Var = new gn7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = gn7Var;
            gn7Var.i0(this.c);
            this.o.add(this.l);
            rn7 rn7Var = new rn7(this.a, oo4.b);
            this.m = rn7Var;
            rn7Var.g0(this.c);
            this.o.add(this.m);
            nn7 nn7Var = new nn7(this.a, dy5.r0);
            this.n = nn7Var;
            this.o.add(nn7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (ho hoVar : this.o) {
                if (hoVar instanceof fn7) {
                    ((fn7) hoVar).b0(z);
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

    public void d(List<? extends uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }
}
