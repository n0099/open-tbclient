package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class q66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public c76 c;
    public t66 d;
    public v66 e;
    public u66 f;
    public w66 g;
    public d76 h;
    public y66 i;
    public a76 j;
    public z66 k;
    public x66 l;
    public b76 m;
    public s66 n;
    public e76 o;
    public List<ho> p;

    public q66(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new LinkedList();
        this.a = enterForumTabFeedFragment;
        this.b = bdTypeRecyclerView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c76 c76Var = new c76(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.D0());
            this.c = c76Var;
            c76Var.d0(this.b);
            this.p.add(this.c);
            t66 t66Var = new t66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.D0());
            this.d = t66Var;
            t66Var.e0(this.b);
            this.p.add(this.d);
            v66 v66Var = new v66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.D0());
            this.e = v66Var;
            v66Var.d0(this.b);
            this.p.add(this.e);
            u66 u66Var = new u66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.D0());
            this.f = u66Var;
            u66Var.d0(this.b);
            this.p.add(this.f);
            w66 w66Var = new w66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.D0());
            this.g = w66Var;
            w66Var.d0(this.b);
            this.p.add(this.g);
            d76 d76Var = new d76(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.D0());
            this.h = d76Var;
            d76Var.g0(this.b);
            this.p.add(this.h);
            y66 y66Var = new y66(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.D0());
            this.i = y66Var;
            y66Var.b0(this.b);
            this.p.add(this.i);
            a76 a76Var = new a76(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.D0());
            this.j = a76Var;
            a76Var.d0(this.b);
            this.p.add(this.j);
            z66 z66Var = new z66(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.D0());
            this.k = z66Var;
            z66Var.b0(this.b);
            this.p.add(this.k);
            x66 x66Var = new x66(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.D0());
            this.l = x66Var;
            x66Var.d0(this.b);
            this.p.add(this.l);
            b76 b76Var = new b76(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.D0());
            this.m = b76Var;
            b76Var.d0(this.b);
            this.p.add(this.m);
            s66 s66Var = new s66(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.D0());
            this.n = s66Var;
            s66Var.e0(this.b);
            this.p.add(this.n);
            e76 e76Var = new e76(this.a.getPageContext(), kq4.d, this.a.getUniqueId(), this.a.D0());
            this.o = e76Var;
            e76Var.c0(this.b);
            this.p.add(this.o);
            this.b.a(this.p);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void c(ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            t66 t66Var = this.d;
            if (t66Var != null) {
                t66Var.setFromCDN(z);
            }
            u66 u66Var = this.f;
            if (u66Var != null) {
                u66Var.setFromCDN(z);
            }
            v66 v66Var = this.e;
            if (v66Var != null) {
                v66Var.setFromCDN(z);
            }
        }
    }
}
