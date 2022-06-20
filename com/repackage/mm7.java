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
public class mm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public km7 d;
    public dm7 e;
    public fm7 f;
    public em7 g;
    public gm7 h;
    public lm7 i;
    public hm7 j;
    public im7 k;
    public cm7 l;
    public nm7 m;
    public jm7 n;
    public List<an> o;

    public mm7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            km7 km7Var = new km7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = km7Var;
            km7Var.h0(this.c);
            this.o.add(this.d);
            dm7 dm7Var = new dm7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = dm7Var;
            dm7Var.i0(this.c);
            this.o.add(this.e);
            fm7 fm7Var = new fm7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = fm7Var;
            fm7Var.h0(this.c);
            this.o.add(this.f);
            em7 em7Var = new em7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = em7Var;
            em7Var.h0(this.c);
            this.o.add(this.g);
            gm7 gm7Var = new gm7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = gm7Var;
            gm7Var.h0(this.c);
            this.o.add(this.h);
            lm7 lm7Var = new lm7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = lm7Var;
            lm7Var.k0(this.c);
            this.o.add(this.i);
            hm7 hm7Var = new hm7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = hm7Var;
            hm7Var.h0(this.c);
            this.o.add(this.j);
            im7 im7Var = new im7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = im7Var;
            im7Var.h0(this.c);
            this.o.add(this.k);
            cm7 cm7Var = new cm7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = cm7Var;
            cm7Var.i0(this.c);
            this.o.add(this.l);
            nm7 nm7Var = new nm7(this.a, wn4.b);
            this.m = nm7Var;
            nm7Var.g0(this.c);
            this.o.add(this.m);
            jm7 jm7Var = new jm7(this.a, yx5.r0);
            this.n = jm7Var;
            this.o.add(jm7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (an anVar : this.o) {
                if (anVar instanceof bm7) {
                    ((bm7) anVar).b0(z);
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
