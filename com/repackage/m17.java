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
public class m17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public i27 c;
    public b27 d;
    public w17 e;
    public y17 f;
    public x17 g;
    public z17 h;
    public j27 i;
    public a27 j;
    public d27 k;
    public f27 l;
    public e27 m;
    public h27 n;
    public u17 o;
    public s17 p;
    public r17 q;
    public t17 r;
    public c27 s;
    public g27 t;
    public v17 u;
    public k27 v;
    public List<bn> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m17 a;

        public a(m17 m17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m17Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof l27)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public m17(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            i27 i27Var = new i27(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.F1(), this.a.E1());
            this.c = i27Var;
            i27Var.w(this.b);
            this.w.add(this.c);
            b27 b27Var = new b27(this.a.getPageContext());
            this.d = b27Var;
            b27Var.v(this.b);
            this.w.add(this.d);
            w17 w17Var = new w17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.F1());
            this.e = w17Var;
            w17Var.x(this.b);
            this.w.add(this.e);
            y17 y17Var = new y17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.f = y17Var;
            y17Var.w(this.b);
            this.w.add(this.f);
            x17 x17Var = new x17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.F1());
            this.g = x17Var;
            x17Var.w(this.b);
            this.w.add(this.g);
            z17 z17Var = new z17(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.h = z17Var;
            z17Var.w(this.b);
            this.w.add(this.h);
            j27 j27Var = new j27(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.F1());
            this.i = j27Var;
            j27Var.z(this.b);
            this.w.add(this.i);
            a27 a27Var = new a27(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.F1());
            this.j = a27Var;
            a27Var.w(this.b);
            if ("fashion".equals(this.a.E1()) || "local".equals(this.a.E1())) {
                this.w.add(this.j);
            }
            d27 d27Var = new d27(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.F1());
            this.k = d27Var;
            d27Var.u(this.b);
            this.w.add(this.k);
            f27 f27Var = new f27(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.F1());
            this.l = f27Var;
            f27Var.v(this.b);
            this.w.add(this.l);
            e27 e27Var = new e27(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.F1());
            this.m = e27Var;
            e27Var.u(this.b);
            this.w.add(this.m);
            h27 h27Var = new h27(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.n = h27Var;
            h27Var.v(this.b);
            this.w.add(this.n);
            u17 u17Var = new u17(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.F1());
            this.o = u17Var;
            u17Var.x(this.b);
            this.w.add(this.o);
            t17 t17Var = new t17(this.a.getPageContext(), m06.N0, this.a.F1());
            this.r = t17Var;
            this.w.add(t17Var);
            s17 s17Var = new s17(this.a.getPageContext(), zq4.e);
            this.p = s17Var;
            s17Var.v(this.b);
            this.w.add(this.p);
            r17 r17Var = new r17(this.a.getPageContext(), dp4.b);
            this.q = r17Var;
            r17Var.y(this.b);
            this.w.add(this.q);
            c27 c27Var = new c27(this.a.getPageContext());
            this.s = c27Var;
            c27Var.u(this.b);
            this.w.add(this.s);
            g27 g27Var = new g27(this.a.getPageContext());
            this.t = g27Var;
            g27Var.u(this.b);
            this.w.add(this.t);
            v17 v17Var = new v17(this.a.getPageContext(), b());
            this.u = v17Var;
            this.w.add(v17Var);
            k27 k27Var = new k27(this.a.getPageContext());
            this.v = k27Var;
            this.w.add(k27Var);
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
        k27 k27Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (k27Var = this.v) == null) {
            return;
        }
        k27Var.u(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (bn bnVar : this.w) {
                if (bnVar instanceof o17) {
                    ((o17) bnVar).h(str);
                }
            }
        }
    }
}
