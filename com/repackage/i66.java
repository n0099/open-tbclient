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
public class i66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public u66 c;
    public l66 d;
    public n66 e;
    public m66 f;
    public o66 g;
    public v66 h;
    public q66 i;
    public s66 j;
    public r66 k;
    public p66 l;
    public t66 m;
    public k66 n;
    public w66 o;
    public List<an> p;

    public i66(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            u66 u66Var = new u66(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.u1());
            this.c = u66Var;
            u66Var.d0(this.b);
            this.p.add(this.c);
            l66 l66Var = new l66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.u1());
            this.d = l66Var;
            l66Var.e0(this.b);
            this.p.add(this.d);
            n66 n66Var = new n66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.u1());
            this.e = n66Var;
            n66Var.d0(this.b);
            this.p.add(this.e);
            m66 m66Var = new m66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.u1());
            this.f = m66Var;
            m66Var.d0(this.b);
            this.p.add(this.f);
            o66 o66Var = new o66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.u1());
            this.g = o66Var;
            o66Var.d0(this.b);
            this.p.add(this.g);
            v66 v66Var = new v66(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.u1());
            this.h = v66Var;
            v66Var.g0(this.b);
            this.p.add(this.h);
            q66 q66Var = new q66(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.u1());
            this.i = q66Var;
            q66Var.b0(this.b);
            this.p.add(this.i);
            s66 s66Var = new s66(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.u1());
            this.j = s66Var;
            s66Var.d0(this.b);
            this.p.add(this.j);
            r66 r66Var = new r66(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.u1());
            this.k = r66Var;
            r66Var.b0(this.b);
            this.p.add(this.k);
            p66 p66Var = new p66(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.u1());
            this.l = p66Var;
            p66Var.d0(this.b);
            this.p.add(this.l);
            t66 t66Var = new t66(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.u1());
            this.m = t66Var;
            t66Var.d0(this.b);
            this.p.add(this.m);
            k66 k66Var = new k66(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.u1());
            this.n = k66Var;
            k66Var.e0(this.b);
            this.p.add(this.n);
            w66 w66Var = new w66(this.a.getPageContext(), jq4.d, this.a.getUniqueId(), this.a.u1());
            this.o = w66Var;
            w66Var.c0(this.b);
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

    public void c(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            l66 l66Var = this.d;
            if (l66Var != null) {
                l66Var.setFromCDN(z);
            }
            m66 m66Var = this.f;
            if (m66Var != null) {
                m66Var.setFromCDN(z);
            }
            n66 n66Var = this.e;
            if (n66Var != null) {
                n66Var.setFromCDN(z);
            }
        }
    }
}
