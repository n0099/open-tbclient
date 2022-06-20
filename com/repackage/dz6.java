package com.repackage;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.core.ForHostApp;
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
/* loaded from: classes5.dex */
public class dz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public zz6 c;
    public sz6 d;
    public nz6 e;
    public pz6 f;
    public oz6 g;
    public qz6 h;
    public a07 i;
    public rz6 j;
    public uz6 k;
    public wz6 l;
    public vz6 m;
    public yz6 n;
    public lz6 o;
    public jz6 p;
    public iz6 q;
    public kz6 r;
    public tz6 s;
    public xz6 t;
    public mz6 u;
    public b07 v;
    public List<an> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dz6 a;

        public a(dz6 dz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dz6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.C(0) instanceof c07)) {
                    this.a.b.E(0);
                }
            }
        }
    }

    public dz6(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            zz6 zz6Var = new zz6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.F1(), this.a.E1());
            this.c = zz6Var;
            zz6Var.d0(this.b);
            this.w.add(this.c);
            sz6 sz6Var = new sz6(this.a.getPageContext());
            this.d = sz6Var;
            sz6Var.c0(this.b);
            this.w.add(this.d);
            nz6 nz6Var = new nz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.F1());
            this.e = nz6Var;
            nz6Var.e0(this.b);
            this.w.add(this.e);
            pz6 pz6Var = new pz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.f = pz6Var;
            pz6Var.d0(this.b);
            this.w.add(this.f);
            oz6 oz6Var = new oz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.F1());
            this.g = oz6Var;
            oz6Var.d0(this.b);
            this.w.add(this.g);
            qz6 qz6Var = new qz6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.h = qz6Var;
            qz6Var.d0(this.b);
            this.w.add(this.h);
            a07 a07Var = new a07(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.F1());
            this.i = a07Var;
            a07Var.g0(this.b);
            this.w.add(this.i);
            rz6 rz6Var = new rz6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.F1());
            this.j = rz6Var;
            rz6Var.d0(this.b);
            if ("fashion".equals(this.a.E1()) || ForHostApp.KEY_NAME_LOCAL.equals(this.a.E1())) {
                this.w.add(this.j);
            }
            uz6 uz6Var = new uz6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.F1());
            this.k = uz6Var;
            uz6Var.b0(this.b);
            this.w.add(this.k);
            wz6 wz6Var = new wz6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.F1());
            this.l = wz6Var;
            wz6Var.c0(this.b);
            this.w.add(this.l);
            vz6 vz6Var = new vz6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.F1());
            this.m = vz6Var;
            vz6Var.b0(this.b);
            this.w.add(this.m);
            yz6 yz6Var = new yz6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.F1());
            this.n = yz6Var;
            yz6Var.c0(this.b);
            this.w.add(this.n);
            lz6 lz6Var = new lz6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.F1());
            this.o = lz6Var;
            lz6Var.e0(this.b);
            this.w.add(this.o);
            kz6 kz6Var = new kz6(this.a.getPageContext(), xx5.N0, this.a.F1());
            this.r = kz6Var;
            this.w.add(kz6Var);
            jz6 jz6Var = new jz6(this.a.getPageContext(), sp4.e);
            this.p = jz6Var;
            jz6Var.c0(this.b);
            this.w.add(this.p);
            iz6 iz6Var = new iz6(this.a.getPageContext(), wn4.b);
            this.q = iz6Var;
            iz6Var.f0(this.b);
            this.w.add(this.q);
            tz6 tz6Var = new tz6(this.a.getPageContext());
            this.s = tz6Var;
            tz6Var.b0(this.b);
            this.w.add(this.s);
            xz6 xz6Var = new xz6(this.a.getPageContext());
            this.t = xz6Var;
            xz6Var.b0(this.b);
            this.w.add(this.t);
            mz6 mz6Var = new mz6(this.a.getPageContext(), b());
            this.u = mz6Var;
            this.w.add(mz6Var);
            b07 b07Var = new b07(this.a.getPageContext());
            this.v = b07Var;
            this.w.add(b07Var);
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
        b07 b07Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (b07Var = this.v) == null) {
            return;
        }
        b07Var.b0(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (an anVar : this.w) {
                if (anVar instanceof fz6) {
                    ((fz6) anVar).h(str);
                }
            }
        }
    }
}
