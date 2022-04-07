package com.repackage;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class n07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public j17 c;
    public c17 d;
    public x07 e;
    public z07 f;
    public y07 g;
    public a17 h;
    public k17 i;
    public b17 j;
    public e17 k;
    public g17 l;
    public f17 m;
    public i17 n;
    public v07 o;
    public t07 p;
    public s07 q;
    public u07 r;
    public d17 s;
    public h17 t;
    public w07 u;
    public l17 v;
    public List<ho> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n07 a;

        public a(n07 n07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.C(0) instanceof m17)) {
                    this.a.b.E(0);
                }
            }
        }
    }

    public n07(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new LinkedList();
        this.a = homePageTabFeedFragment;
        this.b = bdTypeRecyclerView;
        c();
    }

    public final View.OnClickListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (View.OnClickListener) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j17 j17Var = new j17(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.O0(), this.a.N0());
            this.c = j17Var;
            j17Var.d0(this.b);
            this.w.add(this.c);
            c17 c17Var = new c17(this.a.getPageContext());
            this.d = c17Var;
            c17Var.c0(this.b);
            this.w.add(this.d);
            x07 x07Var = new x07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.O0());
            this.e = x07Var;
            x07Var.e0(this.b);
            this.w.add(this.e);
            z07 z07Var = new z07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.O0());
            this.f = z07Var;
            z07Var.d0(this.b);
            this.w.add(this.f);
            y07 y07Var = new y07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.O0());
            this.g = y07Var;
            y07Var.d0(this.b);
            this.w.add(this.g);
            a17 a17Var = new a17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.O0());
            this.h = a17Var;
            a17Var.d0(this.b);
            this.w.add(this.h);
            k17 k17Var = new k17(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.O0());
            this.i = k17Var;
            k17Var.g0(this.b);
            this.w.add(this.i);
            b17 b17Var = new b17(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.O0());
            this.j = b17Var;
            b17Var.d0(this.b);
            if ("fashion".equals(this.a.N0()) || "local".equals(this.a.N0())) {
                this.w.add(this.j);
            }
            e17 e17Var = new e17(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.O0());
            this.k = e17Var;
            e17Var.b0(this.b);
            this.w.add(this.k);
            g17 g17Var = new g17(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.O0());
            this.l = g17Var;
            g17Var.c0(this.b);
            this.w.add(this.l);
            f17 f17Var = new f17(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.O0());
            this.m = f17Var;
            f17Var.b0(this.b);
            this.w.add(this.m);
            i17 i17Var = new i17(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.O0());
            this.n = i17Var;
            i17Var.c0(this.b);
            this.w.add(this.n);
            v07 v07Var = new v07(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.O0());
            this.o = v07Var;
            v07Var.e0(this.b);
            this.w.add(this.o);
            u07 u07Var = new u07(this.a.getPageContext(), cy5.N0, this.a.O0());
            this.r = u07Var;
            this.w.add(u07Var);
            t07 t07Var = new t07(this.a.getPageContext(), jq4.e);
            this.p = t07Var;
            t07Var.c0(this.b);
            this.w.add(this.p);
            s07 s07Var = new s07(this.a.getPageContext(), oo4.b);
            this.q = s07Var;
            s07Var.f0(this.b);
            this.w.add(this.q);
            d17 d17Var = new d17(this.a.getPageContext());
            this.s = d17Var;
            d17Var.b0(this.b);
            this.w.add(this.s);
            h17 h17Var = new h17(this.a.getPageContext());
            this.t = h17Var;
            h17Var.b0(this.b);
            this.w.add(this.t);
            w07 w07Var = new w07(this.a.getPageContext(), b());
            this.u = w07Var;
            this.w.add(w07Var);
            l17 l17Var = new l17(this.a.getPageContext());
            this.v = l17Var;
            this.w.add(l17Var);
            this.b.a(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        l17 l17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (l17Var = this.v) == null) {
            return;
        }
        l17Var.b0(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (ho hoVar : this.w) {
                if (hoVar instanceof p07) {
                    ((p07) hoVar).h(str);
                }
            }
        }
    }
}
