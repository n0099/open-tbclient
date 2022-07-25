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
/* loaded from: classes7.dex */
public class tz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public p07 c;
    public i07 d;
    public d07 e;
    public f07 f;
    public e07 g;
    public g07 h;
    public q07 i;
    public h07 j;
    public k07 k;
    public m07 l;
    public l07 m;
    public o07 n;
    public b07 o;
    public zz6 p;
    public yz6 q;
    public a07 r;
    public j07 s;
    public n07 t;
    public c07 u;
    public r07 v;
    public List<an> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz6 a;

        public a(tz6 tz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.B(0) instanceof s07)) {
                    this.a.b.D(0);
                }
            }
        }
    }

    public tz6(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            p07 p07Var = new p07(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.G1(), this.a.F1());
            this.c = p07Var;
            p07Var.d0(this.b);
            this.w.add(this.c);
            i07 i07Var = new i07(this.a.getPageContext());
            this.d = i07Var;
            i07Var.c0(this.b);
            this.w.add(this.d);
            d07 d07Var = new d07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.G1());
            this.e = d07Var;
            d07Var.e0(this.b);
            this.w.add(this.e);
            f07 f07Var = new f07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.f = f07Var;
            f07Var.d0(this.b);
            this.w.add(this.f);
            e07 e07Var = new e07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.G1());
            this.g = e07Var;
            e07Var.d0(this.b);
            this.w.add(this.g);
            g07 g07Var = new g07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.h = g07Var;
            g07Var.d0(this.b);
            this.w.add(this.h);
            q07 q07Var = new q07(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.G1());
            this.i = q07Var;
            q07Var.g0(this.b);
            this.w.add(this.i);
            h07 h07Var = new h07(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.G1());
            this.j = h07Var;
            h07Var.d0(this.b);
            if ("fashion".equals(this.a.F1()) || "local".equals(this.a.F1())) {
                this.w.add(this.j);
            }
            k07 k07Var = new k07(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.G1());
            this.k = k07Var;
            k07Var.b0(this.b);
            this.w.add(this.k);
            m07 m07Var = new m07(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.G1());
            this.l = m07Var;
            m07Var.c0(this.b);
            this.w.add(this.l);
            l07 l07Var = new l07(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.G1());
            this.m = l07Var;
            l07Var.b0(this.b);
            this.w.add(this.m);
            o07 o07Var = new o07(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.G1());
            this.n = o07Var;
            o07Var.c0(this.b);
            this.w.add(this.n);
            b07 b07Var = new b07(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.G1());
            this.o = b07Var;
            b07Var.e0(this.b);
            this.w.add(this.o);
            a07 a07Var = new a07(this.a.getPageContext(), uy5.N0, this.a.G1());
            this.r = a07Var;
            this.w.add(a07Var);
            zz6 zz6Var = new zz6(this.a.getPageContext(), iq4.e);
            this.p = zz6Var;
            zz6Var.c0(this.b);
            this.w.add(this.p);
            yz6 yz6Var = new yz6(this.a.getPageContext(), mo4.b);
            this.q = yz6Var;
            yz6Var.f0(this.b);
            this.w.add(this.q);
            j07 j07Var = new j07(this.a.getPageContext());
            this.s = j07Var;
            j07Var.b0(this.b);
            this.w.add(this.s);
            n07 n07Var = new n07(this.a.getPageContext());
            this.t = n07Var;
            n07Var.b0(this.b);
            this.w.add(this.t);
            c07 c07Var = new c07(this.a.getPageContext(), b());
            this.u = c07Var;
            this.w.add(c07Var);
            r07 r07Var = new r07(this.a.getPageContext());
            this.v = r07Var;
            this.w.add(r07Var);
            this.b.a(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        r07 r07Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (r07Var = this.v) == null) {
            return;
        }
        r07Var.b0(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (an anVar : this.w) {
                if (anVar instanceof vz6) {
                    ((vz6) anVar).h(str);
                }
            }
        }
    }
}
