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
public class zo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public BdUniqueId b;
    public BdTypeRecyclerView c;
    public xo7 d;
    public qo7 e;
    public so7 f;
    public ro7 g;
    public to7 h;
    public yo7 i;
    public uo7 j;
    public vo7 k;
    public po7 l;
    public ap7 m;
    public wo7 n;
    public List<bn> o;

    public zo7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdTypeRecyclerView bdTypeRecyclerView) {
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
            xo7 xo7Var = new xo7(this.a, ThreadData.TYPE_USER_NORMAL, this.b);
            this.d = xo7Var;
            xo7Var.A(this.c);
            this.o.add(this.d);
            qo7 qo7Var = new qo7(this.a, ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.b);
            this.e = qo7Var;
            qo7Var.B(this.c);
            this.o.add(this.e);
            so7 so7Var = new so7(this.a, ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.b);
            this.f = so7Var;
            so7Var.A(this.c);
            this.o.add(this.f);
            ro7 ro7Var = new ro7(this.a, ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.b);
            this.g = ro7Var;
            ro7Var.A(this.c);
            this.o.add(this.g);
            to7 to7Var = new to7(this.a, ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.b);
            this.h = to7Var;
            to7Var.A(this.c);
            this.o.add(this.h);
            yo7 yo7Var = new yo7(this.a, ThreadData.TYPE_VIDEO, this.b);
            this.i = yo7Var;
            yo7Var.D(this.c);
            this.o.add(this.i);
            uo7 uo7Var = new uo7(this.a, ThreadData.TYPE_ENTER_FORUM, this.b);
            this.j = uo7Var;
            uo7Var.A(this.c);
            this.o.add(this.j);
            vo7 vo7Var = new vo7(this.a, ThreadData.TYPE_BOTTOM_NORMAL, this.b);
            this.k = vo7Var;
            vo7Var.A(this.c);
            this.o.add(this.k);
            po7 po7Var = new po7(this.a, ThreadData.TYPE_ARTICLE, this.b);
            this.l = po7Var;
            po7Var.B(this.c);
            this.o.add(this.l);
            ap7 ap7Var = new ap7(this.a, dp4.b);
            this.m = ap7Var;
            ap7Var.z(this.c);
            this.o.add(this.m);
            wo7 wo7Var = new wo7(this.a, n06.r0);
            this.n = wo7Var;
            this.o.add(wo7Var);
            this.c.a(this.o);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            for (bn bnVar : this.o) {
                if (bnVar instanceof oo7) {
                    ((oo7) bnVar).u(z);
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

    public void d(List<? extends on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }
}
