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
public class l46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public BdTypeRecyclerView b;
    public x46 c;
    public o46 d;
    public q46 e;
    public p46 f;
    public r46 g;
    public y46 h;
    public t46 i;
    public v46 j;
    public u46 k;
    public s46 l;
    public w46 m;
    public n46 n;
    public z46 o;
    public List<wm> p;

    public l46(EnterForumTabFeedFragment enterForumTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            x46 x46Var = new x46(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.G0());
            this.c = x46Var;
            x46Var.d0(this.b);
            this.p.add(this.c);
            o46 o46Var = new o46(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.G0());
            this.d = o46Var;
            o46Var.e0(this.b);
            this.p.add(this.d);
            q46 q46Var = new q46(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.G0());
            this.e = q46Var;
            q46Var.d0(this.b);
            this.p.add(this.e);
            p46 p46Var = new p46(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.G0());
            this.f = p46Var;
            p46Var.d0(this.b);
            this.p.add(this.f);
            r46 r46Var = new r46(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.G0());
            this.g = r46Var;
            r46Var.d0(this.b);
            this.p.add(this.g);
            y46 y46Var = new y46(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.G0());
            this.h = y46Var;
            y46Var.g0(this.b);
            this.p.add(this.h);
            t46 t46Var = new t46(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.G0());
            this.i = t46Var;
            t46Var.b0(this.b);
            this.p.add(this.i);
            v46 v46Var = new v46(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.G0());
            this.j = v46Var;
            v46Var.d0(this.b);
            this.p.add(this.j);
            u46 u46Var = new u46(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.G0());
            this.k = u46Var;
            u46Var.b0(this.b);
            this.p.add(this.k);
            s46 s46Var = new s46(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.G0());
            this.l = s46Var;
            s46Var.d0(this.b);
            this.p.add(this.l);
            w46 w46Var = new w46(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.G0());
            this.m = w46Var;
            w46Var.d0(this.b);
            this.p.add(this.m);
            n46 n46Var = new n46(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.G0());
            this.n = n46Var;
            n46Var.e0(this.b);
            this.p.add(this.n);
            z46 z46Var = new z46(this.a.getPageContext(), kp4.d, this.a.getUniqueId(), this.a.G0());
            this.o = z46Var;
            z46Var.c0(this.b);
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

    public void c(ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            o46 o46Var = this.d;
            if (o46Var != null) {
                o46Var.setFromCDN(z);
            }
            p46 p46Var = this.f;
            if (p46Var != null) {
                p46Var.setFromCDN(z);
            }
            q46 q46Var = this.e;
            if (q46Var != null) {
                q46Var.setFromCDN(z);
            }
        }
    }
}
