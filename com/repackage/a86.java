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
/* loaded from: classes5.dex */
public class a86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public m86 c;
    public d86 d;
    public f86 e;
    public e86 f;
    public g86 g;
    public n86 h;
    public i86 i;
    public k86 j;
    public j86 k;
    public h86 l;
    public l86 m;
    public c86 n;
    public o86 o;
    public List<bn> p;

    public a86(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            m86 m86Var = new m86(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.c = m86Var;
            m86Var.w(this.b);
            this.p.add(this.c);
            d86 d86Var = new d86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.t1());
            this.d = d86Var;
            d86Var.x(this.b);
            this.p.add(this.d);
            f86 f86Var = new f86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.e = f86Var;
            f86Var.w(this.b);
            this.p.add(this.e);
            e86 e86Var = new e86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.t1());
            this.f = e86Var;
            e86Var.w(this.b);
            this.p.add(this.f);
            g86 g86Var = new g86(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.g = g86Var;
            g86Var.w(this.b);
            this.p.add(this.g);
            n86 n86Var = new n86(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.t1());
            this.h = n86Var;
            n86Var.z(this.b);
            this.p.add(this.h);
            i86 i86Var = new i86(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.t1());
            this.i = i86Var;
            i86Var.u(this.b);
            this.p.add(this.i);
            k86 k86Var = new k86(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.t1());
            this.j = k86Var;
            k86Var.w(this.b);
            this.p.add(this.j);
            j86 j86Var = new j86(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.t1());
            this.k = j86Var;
            j86Var.u(this.b);
            this.p.add(this.k);
            h86 h86Var = new h86(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.t1());
            this.l = h86Var;
            h86Var.w(this.b);
            this.p.add(this.l);
            l86 l86Var = new l86(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.t1());
            this.m = l86Var;
            l86Var.w(this.b);
            this.p.add(this.m);
            c86 c86Var = new c86(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.t1());
            this.n = c86Var;
            c86Var.x(this.b);
            this.p.add(this.n);
            o86 o86Var = new o86(this.a.getPageContext(), br4.d, this.a.getUniqueId(), this.a.t1());
            this.o = o86Var;
            o86Var.v(this.b);
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

    public void c(ArrayList<on> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            d86 d86Var = this.d;
            if (d86Var != null) {
                d86Var.setFromCDN(z);
            }
            e86 e86Var = this.f;
            if (e86Var != null) {
                e86Var.setFromCDN(z);
            }
            f86 f86Var = this.e;
            if (f86Var != null) {
                f86Var.setFromCDN(z);
            }
        }
    }
}
