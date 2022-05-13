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
public class qz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public m07 c;
    public f07 d;
    public a07 e;
    public c07 f;
    public b07 g;
    public d07 h;
    public n07 i;
    public e07 j;
    public h07 k;
    public j07 l;
    public i07 m;
    public l07 n;
    public yz6 o;
    public wz6 p;
    public vz6 q;
    public xz6 r;
    public g07 s;
    public k07 t;
    public zz6 u;
    public o07 v;
    public List<eo> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz6 a;

        public a(qz6 qz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.C(0) instanceof p07)) {
                    this.a.b.E(0);
                }
            }
        }
    }

    public qz6(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            m07 m07Var = new m07(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.P0(), this.a.O0());
            this.c = m07Var;
            m07Var.d0(this.b);
            this.w.add(this.c);
            f07 f07Var = new f07(this.a.getPageContext());
            this.d = f07Var;
            f07Var.c0(this.b);
            this.w.add(this.d);
            a07 a07Var = new a07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.P0());
            this.e = a07Var;
            a07Var.e0(this.b);
            this.w.add(this.e);
            c07 c07Var = new c07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.P0());
            this.f = c07Var;
            c07Var.d0(this.b);
            this.w.add(this.f);
            b07 b07Var = new b07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.P0());
            this.g = b07Var;
            b07Var.d0(this.b);
            this.w.add(this.g);
            d07 d07Var = new d07(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.P0());
            this.h = d07Var;
            d07Var.d0(this.b);
            this.w.add(this.h);
            n07 n07Var = new n07(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.P0());
            this.i = n07Var;
            n07Var.g0(this.b);
            this.w.add(this.i);
            e07 e07Var = new e07(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.P0());
            this.j = e07Var;
            e07Var.d0(this.b);
            if ("fashion".equals(this.a.O0()) || "local".equals(this.a.O0())) {
                this.w.add(this.j);
            }
            h07 h07Var = new h07(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.P0());
            this.k = h07Var;
            h07Var.b0(this.b);
            this.w.add(this.k);
            j07 j07Var = new j07(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.P0());
            this.l = j07Var;
            j07Var.c0(this.b);
            this.w.add(this.l);
            i07 i07Var = new i07(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.P0());
            this.m = i07Var;
            i07Var.b0(this.b);
            this.w.add(this.m);
            l07 l07Var = new l07(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.P0());
            this.n = l07Var;
            l07Var.c0(this.b);
            this.w.add(this.n);
            yz6 yz6Var = new yz6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.P0());
            this.o = yz6Var;
            yz6Var.e0(this.b);
            this.w.add(this.o);
            xz6 xz6Var = new xz6(this.a.getPageContext(), fy5.N0, this.a.P0());
            this.r = xz6Var;
            this.w.add(xz6Var);
            wz6 wz6Var = new wz6(this.a.getPageContext(), tq4.e);
            this.p = wz6Var;
            wz6Var.c0(this.b);
            this.w.add(this.p);
            vz6 vz6Var = new vz6(this.a.getPageContext(), xo4.b);
            this.q = vz6Var;
            vz6Var.f0(this.b);
            this.w.add(this.q);
            g07 g07Var = new g07(this.a.getPageContext());
            this.s = g07Var;
            g07Var.b0(this.b);
            this.w.add(this.s);
            k07 k07Var = new k07(this.a.getPageContext());
            this.t = k07Var;
            k07Var.b0(this.b);
            this.w.add(this.t);
            zz6 zz6Var = new zz6(this.a.getPageContext(), b());
            this.u = zz6Var;
            this.w.add(zz6Var);
            o07 o07Var = new o07(this.a.getPageContext());
            this.v = o07Var;
            this.w.add(o07Var);
            this.b.a(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        o07 o07Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (o07Var = this.v) == null) {
            return;
        }
        o07Var.b0(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (eo eoVar : this.w) {
                if (eoVar instanceof sz6) {
                    ((sz6) eoVar).h(str);
                }
            }
        }
    }
}
