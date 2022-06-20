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
public class l56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public x56 c;
    public o56 d;
    public q56 e;
    public p56 f;
    public r56 g;
    public y56 h;
    public t56 i;
    public v56 j;
    public u56 k;
    public s56 l;
    public w56 m;
    public n56 n;
    public z56 o;
    public List<an> p;

    public l56(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            x56 x56Var = new x56(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.c = x56Var;
            x56Var.d0(this.b);
            this.p.add(this.c);
            o56 o56Var = new o56(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.t1());
            this.d = o56Var;
            o56Var.e0(this.b);
            this.p.add(this.d);
            q56 q56Var = new q56(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.e = q56Var;
            q56Var.d0(this.b);
            this.p.add(this.e);
            p56 p56Var = new p56(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.t1());
            this.f = p56Var;
            p56Var.d0(this.b);
            this.p.add(this.f);
            r56 r56Var = new r56(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.g = r56Var;
            r56Var.d0(this.b);
            this.p.add(this.g);
            y56 y56Var = new y56(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.t1());
            this.h = y56Var;
            y56Var.g0(this.b);
            this.p.add(this.h);
            t56 t56Var = new t56(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.t1());
            this.i = t56Var;
            t56Var.b0(this.b);
            this.p.add(this.i);
            v56 v56Var = new v56(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.t1());
            this.j = v56Var;
            v56Var.d0(this.b);
            this.p.add(this.j);
            u56 u56Var = new u56(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.t1());
            this.k = u56Var;
            u56Var.b0(this.b);
            this.p.add(this.k);
            s56 s56Var = new s56(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.t1());
            this.l = s56Var;
            s56Var.d0(this.b);
            this.p.add(this.l);
            w56 w56Var = new w56(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.m = w56Var;
            w56Var.d0(this.b);
            this.p.add(this.m);
            n56 n56Var = new n56(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.t1());
            this.n = n56Var;
            n56Var.e0(this.b);
            this.p.add(this.n);
            z56 z56Var = new z56(this.a.getPageContext(), up4.d, this.a.getUniqueId(), this.a.t1());
            this.o = z56Var;
            z56Var.c0(this.b);
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
            o56 o56Var = this.d;
            if (o56Var != null) {
                o56Var.setFromCDN(z);
            }
            p56 p56Var = this.f;
            if (p56Var != null) {
                p56Var.setFromCDN(z);
            }
            q56 q56Var = this.e;
            if (q56Var != null) {
                q56Var.setFromCDN(z);
            }
        }
    }
}
