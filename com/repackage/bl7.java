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
/* loaded from: classes5.dex */
public class bl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public zk7 d;
    public sk7 e;
    public uk7 f;
    public tk7 g;
    public vk7 h;
    public al7 i;
    public wk7 j;
    public xk7 k;
    public rk7 l;
    public cl7 m;
    public yk7 n;
    public List<wm> o;

    public bl7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            zk7 zk7Var = new zk7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = zk7Var;
            zk7Var.h0(this.c);
            this.o.add(this.d);
            sk7 sk7Var = new sk7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = sk7Var;
            sk7Var.i0(this.c);
            this.o.add(this.e);
            uk7 uk7Var = new uk7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = uk7Var;
            uk7Var.h0(this.c);
            this.o.add(this.f);
            tk7 tk7Var = new tk7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = tk7Var;
            tk7Var.h0(this.c);
            this.o.add(this.g);
            vk7 vk7Var = new vk7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = vk7Var;
            vk7Var.h0(this.c);
            this.o.add(this.h);
            al7 al7Var = new al7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = al7Var;
            al7Var.k0(this.c);
            this.o.add(this.i);
            wk7 wk7Var = new wk7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = wk7Var;
            wk7Var.h0(this.c);
            this.o.add(this.j);
            xk7 xk7Var = new xk7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = xk7Var;
            xk7Var.h0(this.c);
            this.o.add(this.k);
            rk7 rk7Var = new rk7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = rk7Var;
            rk7Var.i0(this.c);
            this.o.add(this.l);
            cl7 cl7Var = new cl7(this.a, mn4.b);
            this.m = cl7Var;
            cl7Var.g0(this.c);
            this.o.add(this.m);
            yk7 yk7Var = new yk7(this.a, zw5.r0);
            this.n = yk7Var;
            this.o.add(yk7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (wm wmVar : this.o) {
                if (wmVar instanceof qk7) {
                    ((qk7) wmVar).b0(z);
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

    public void d(List<? extends jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }
}
