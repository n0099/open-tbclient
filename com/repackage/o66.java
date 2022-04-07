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
/* loaded from: classes6.dex */
public class o66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public a76 c;
    public r66 d;
    public t66 e;
    public s66 f;
    public u66 g;
    public b76 h;
    public w66 i;
    public y66 j;
    public x66 k;
    public v66 l;
    public z66 m;
    public q66 n;
    public c76 o;
    public List<ho> p;

    public o66(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            a76 a76Var = new a76(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.D0());
            this.c = a76Var;
            a76Var.d0(this.b);
            this.p.add(this.c);
            r66 r66Var = new r66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.D0());
            this.d = r66Var;
            r66Var.e0(this.b);
            this.p.add(this.d);
            t66 t66Var = new t66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.D0());
            this.e = t66Var;
            t66Var.d0(this.b);
            this.p.add(this.e);
            s66 s66Var = new s66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.D0());
            this.f = s66Var;
            s66Var.d0(this.b);
            this.p.add(this.f);
            u66 u66Var = new u66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.D0());
            this.g = u66Var;
            u66Var.d0(this.b);
            this.p.add(this.g);
            b76 b76Var = new b76(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.D0());
            this.h = b76Var;
            b76Var.g0(this.b);
            this.p.add(this.h);
            w66 w66Var = new w66(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.D0());
            this.i = w66Var;
            w66Var.b0(this.b);
            this.p.add(this.i);
            y66 y66Var = new y66(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.D0());
            this.j = y66Var;
            y66Var.d0(this.b);
            this.p.add(this.j);
            x66 x66Var = new x66(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.D0());
            this.k = x66Var;
            x66Var.b0(this.b);
            this.p.add(this.k);
            v66 v66Var = new v66(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.D0());
            this.l = v66Var;
            v66Var.d0(this.b);
            this.p.add(this.l);
            z66 z66Var = new z66(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.D0());
            this.m = z66Var;
            z66Var.d0(this.b);
            this.p.add(this.m);
            q66 q66Var = new q66(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.D0());
            this.n = q66Var;
            q66Var.e0(this.b);
            this.p.add(this.n);
            c76 c76Var = new c76(this.a.getPageContext(), lq4.d, this.a.getUniqueId(), this.a.D0());
            this.o = c76Var;
            c76Var.c0(this.b);
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
            r66 r66Var = this.d;
            if (r66Var != null) {
                r66Var.setFromCDN(z);
            }
            s66 s66Var = this.f;
            if (s66Var != null) {
                s66Var.setFromCDN(z);
            }
            t66 t66Var = this.e;
            if (t66Var != null) {
                t66Var.setFromCDN(z);
            }
        }
    }
}
