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
public class n17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public j27 c;
    public c27 d;
    public x17 e;
    public z17 f;
    public y17 g;
    public a27 h;
    public k27 i;
    public b27 j;
    public e27 k;
    public g27 l;
    public f27 m;
    public i27 n;
    public v17 o;
    public t17 p;
    public s17 q;
    public u17 r;
    public d27 s;
    public h27 t;
    public w17 u;
    public l27 v;
    public List<bn> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n17 a;

        public a(n17 n17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n17Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof m27)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public n17(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            j27 j27Var = new j27(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.F1(), this.a.E1());
            this.c = j27Var;
            j27Var.w(this.b);
            this.w.add(this.c);
            c27 c27Var = new c27(this.a.getPageContext());
            this.d = c27Var;
            c27Var.v(this.b);
            this.w.add(this.d);
            x17 x17Var = new x17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.F1());
            this.e = x17Var;
            x17Var.x(this.b);
            this.w.add(this.e);
            z17 z17Var = new z17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.f = z17Var;
            z17Var.w(this.b);
            this.w.add(this.f);
            y17 y17Var = new y17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.F1());
            this.g = y17Var;
            y17Var.w(this.b);
            this.w.add(this.g);
            a27 a27Var = new a27(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.h = a27Var;
            a27Var.w(this.b);
            this.w.add(this.h);
            k27 k27Var = new k27(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.F1());
            this.i = k27Var;
            k27Var.z(this.b);
            this.w.add(this.i);
            b27 b27Var = new b27(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.F1());
            this.j = b27Var;
            b27Var.w(this.b);
            if ("fashion".equals(this.a.E1()) || "local".equals(this.a.E1())) {
                this.w.add(this.j);
            }
            e27 e27Var = new e27(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.F1());
            this.k = e27Var;
            e27Var.u(this.b);
            this.w.add(this.k);
            g27 g27Var = new g27(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.F1());
            this.l = g27Var;
            g27Var.v(this.b);
            this.w.add(this.l);
            f27 f27Var = new f27(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.F1());
            this.m = f27Var;
            f27Var.u(this.b);
            this.w.add(this.m);
            i27 i27Var = new i27(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.n = i27Var;
            i27Var.v(this.b);
            this.w.add(this.n);
            v17 v17Var = new v17(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.F1());
            this.o = v17Var;
            v17Var.x(this.b);
            this.w.add(this.o);
            u17 u17Var = new u17(this.a.getPageContext(), m06.N0, this.a.F1());
            this.r = u17Var;
            this.w.add(u17Var);
            t17 t17Var = new t17(this.a.getPageContext(), zq4.e);
            this.p = t17Var;
            t17Var.v(this.b);
            this.w.add(this.p);
            s17 s17Var = new s17(this.a.getPageContext(), dp4.b);
            this.q = s17Var;
            s17Var.y(this.b);
            this.w.add(this.q);
            d27 d27Var = new d27(this.a.getPageContext());
            this.s = d27Var;
            d27Var.u(this.b);
            this.w.add(this.s);
            h27 h27Var = new h27(this.a.getPageContext());
            this.t = h27Var;
            h27Var.u(this.b);
            this.w.add(this.t);
            w17 w17Var = new w17(this.a.getPageContext(), b());
            this.u = w17Var;
            this.w.add(w17Var);
            l27 l27Var = new l27(this.a.getPageContext());
            this.v = l27Var;
            this.w.add(l27Var);
            this.b.a(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<on> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        l27 l27Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (l27Var = this.v) == null) {
            return;
        }
        l27Var.u(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (bn bnVar : this.w) {
                if (bnVar instanceof p17) {
                    ((p17) bnVar).h(str);
                }
            }
        }
    }
}
