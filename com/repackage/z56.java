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
public class z56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public l66 c;
    public c66 d;
    public e66 e;
    public d66 f;
    public f66 g;
    public m66 h;
    public h66 i;
    public j66 j;
    public i66 k;
    public g66 l;
    public k66 m;
    public b66 n;
    public n66 o;
    public List<eo> p;

    public z56(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            l66 l66Var = new l66(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.E0());
            this.c = l66Var;
            l66Var.d0(this.b);
            this.p.add(this.c);
            c66 c66Var = new c66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.E0());
            this.d = c66Var;
            c66Var.e0(this.b);
            this.p.add(this.d);
            e66 e66Var = new e66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.E0());
            this.e = e66Var;
            e66Var.d0(this.b);
            this.p.add(this.e);
            d66 d66Var = new d66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.E0());
            this.f = d66Var;
            d66Var.d0(this.b);
            this.p.add(this.f);
            f66 f66Var = new f66(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.E0());
            this.g = f66Var;
            f66Var.d0(this.b);
            this.p.add(this.g);
            m66 m66Var = new m66(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.E0());
            this.h = m66Var;
            m66Var.g0(this.b);
            this.p.add(this.h);
            h66 h66Var = new h66(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.E0());
            this.i = h66Var;
            h66Var.b0(this.b);
            this.p.add(this.i);
            j66 j66Var = new j66(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.E0());
            this.j = j66Var;
            j66Var.d0(this.b);
            this.p.add(this.j);
            i66 i66Var = new i66(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.E0());
            this.k = i66Var;
            i66Var.b0(this.b);
            this.p.add(this.k);
            g66 g66Var = new g66(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.E0());
            this.l = g66Var;
            g66Var.d0(this.b);
            this.p.add(this.l);
            k66 k66Var = new k66(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.E0());
            this.m = k66Var;
            k66Var.d0(this.b);
            this.p.add(this.m);
            b66 b66Var = new b66(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.E0());
            this.n = b66Var;
            b66Var.e0(this.b);
            this.p.add(this.n);
            n66 n66Var = new n66(this.a.getPageContext(), vq4.d, this.a.getUniqueId(), this.a.E0());
            this.o = n66Var;
            n66Var.c0(this.b);
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

    public void c(ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c66 c66Var = this.d;
            if (c66Var != null) {
                c66Var.setFromCDN(z);
            }
            d66 d66Var = this.f;
            if (d66Var != null) {
                d66Var.setFromCDN(z);
            }
            e66 e66Var = this.e;
            if (e66Var != null) {
                e66Var.setFromCDN(z);
            }
        }
    }
}
