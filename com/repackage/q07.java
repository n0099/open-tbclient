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
public class q07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public m17 c;
    public f17 d;
    public a17 e;
    public c17 f;
    public b17 g;
    public d17 h;
    public n17 i;
    public e17 j;
    public h17 k;
    public j17 l;
    public i17 m;
    public l17 n;
    public y07 o;
    public w07 p;
    public v07 q;
    public x07 r;
    public g17 s;
    public k17 t;
    public z07 u;
    public o17 v;
    public List<ho> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q07 a;

        public a(q07 q07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.C(0) instanceof p17)) {
                    this.a.b.E(0);
                }
            }
        }
    }

    public q07(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            m17 m17Var = new m17(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.O0(), this.a.N0());
            this.c = m17Var;
            m17Var.d0(this.b);
            this.w.add(this.c);
            f17 f17Var = new f17(this.a.getPageContext());
            this.d = f17Var;
            f17Var.c0(this.b);
            this.w.add(this.d);
            a17 a17Var = new a17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.O0());
            this.e = a17Var;
            a17Var.e0(this.b);
            this.w.add(this.e);
            c17 c17Var = new c17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.O0());
            this.f = c17Var;
            c17Var.d0(this.b);
            this.w.add(this.f);
            b17 b17Var = new b17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.O0());
            this.g = b17Var;
            b17Var.d0(this.b);
            this.w.add(this.g);
            d17 d17Var = new d17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.O0());
            this.h = d17Var;
            d17Var.d0(this.b);
            this.w.add(this.h);
            n17 n17Var = new n17(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.O0());
            this.i = n17Var;
            n17Var.g0(this.b);
            this.w.add(this.i);
            e17 e17Var = new e17(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.O0());
            this.j = e17Var;
            e17Var.d0(this.b);
            if ("fashion".equals(this.a.N0()) || "local".equals(this.a.N0())) {
                this.w.add(this.j);
            }
            h17 h17Var = new h17(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.O0());
            this.k = h17Var;
            h17Var.b0(this.b);
            this.w.add(this.k);
            j17 j17Var = new j17(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.O0());
            this.l = j17Var;
            j17Var.c0(this.b);
            this.w.add(this.l);
            i17 i17Var = new i17(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.O0());
            this.m = i17Var;
            i17Var.b0(this.b);
            this.w.add(this.m);
            l17 l17Var = new l17(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.O0());
            this.n = l17Var;
            l17Var.c0(this.b);
            this.w.add(this.n);
            y07 y07Var = new y07(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.O0());
            this.o = y07Var;
            y07Var.e0(this.b);
            this.w.add(this.o);
            x07 x07Var = new x07(this.a.getPageContext(), ey5.N0, this.a.O0());
            this.r = x07Var;
            this.w.add(x07Var);
            w07 w07Var = new w07(this.a.getPageContext(), iq4.e);
            this.p = w07Var;
            w07Var.c0(this.b);
            this.w.add(this.p);
            v07 v07Var = new v07(this.a.getPageContext(), no4.b);
            this.q = v07Var;
            v07Var.f0(this.b);
            this.w.add(this.q);
            g17 g17Var = new g17(this.a.getPageContext());
            this.s = g17Var;
            g17Var.b0(this.b);
            this.w.add(this.s);
            k17 k17Var = new k17(this.a.getPageContext());
            this.t = k17Var;
            k17Var.b0(this.b);
            this.w.add(this.t);
            z07 z07Var = new z07(this.a.getPageContext(), b());
            this.u = z07Var;
            this.w.add(z07Var);
            o17 o17Var = new o17(this.a.getPageContext());
            this.v = o17Var;
            this.w.add(o17Var);
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
        o17 o17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (o17Var = this.v) == null) {
            return;
        }
        o17Var.b0(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (ho hoVar : this.w) {
                if (hoVar instanceof s07) {
                    ((s07) hoVar).h(str);
                }
            }
        }
    }
}
