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
public class ux6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public qy6 c;
    public jy6 d;
    public ey6 e;
    public gy6 f;
    public fy6 g;
    public hy6 h;
    public ry6 i;
    public iy6 j;
    public ly6 k;
    public ny6 l;
    public my6 m;
    public py6 n;
    public cy6 o;
    public ay6 p;
    public zx6 q;
    public by6 r;
    public ky6 s;
    public oy6 t;
    public dy6 u;
    public sy6 v;
    public List<wm> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux6 a;

        public a(ux6 ux6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.C(0) instanceof ty6)) {
                    this.a.b.E(0);
                }
            }
        }
    }

    public ux6(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
            qy6 qy6Var = new qy6(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.R0(), this.a.Q0());
            this.c = qy6Var;
            qy6Var.d0(this.b);
            this.w.add(this.c);
            jy6 jy6Var = new jy6(this.a.getPageContext());
            this.d = jy6Var;
            jy6Var.c0(this.b);
            this.w.add(this.d);
            ey6 ey6Var = new ey6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.R0());
            this.e = ey6Var;
            ey6Var.e0(this.b);
            this.w.add(this.e);
            gy6 gy6Var = new gy6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.R0());
            this.f = gy6Var;
            gy6Var.d0(this.b);
            this.w.add(this.f);
            fy6 fy6Var = new fy6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.R0());
            this.g = fy6Var;
            fy6Var.d0(this.b);
            this.w.add(this.g);
            hy6 hy6Var = new hy6(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.R0());
            this.h = hy6Var;
            hy6Var.d0(this.b);
            this.w.add(this.h);
            ry6 ry6Var = new ry6(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.R0());
            this.i = ry6Var;
            ry6Var.g0(this.b);
            this.w.add(this.i);
            iy6 iy6Var = new iy6(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.R0());
            this.j = iy6Var;
            iy6Var.d0(this.b);
            if ("fashion".equals(this.a.Q0()) || "local".equals(this.a.Q0())) {
                this.w.add(this.j);
            }
            ly6 ly6Var = new ly6(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.R0());
            this.k = ly6Var;
            ly6Var.b0(this.b);
            this.w.add(this.k);
            ny6 ny6Var = new ny6(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.R0());
            this.l = ny6Var;
            ny6Var.c0(this.b);
            this.w.add(this.l);
            my6 my6Var = new my6(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.R0());
            this.m = my6Var;
            my6Var.b0(this.b);
            this.w.add(this.m);
            py6 py6Var = new py6(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.R0());
            this.n = py6Var;
            py6Var.c0(this.b);
            this.w.add(this.n);
            cy6 cy6Var = new cy6(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.R0());
            this.o = cy6Var;
            cy6Var.e0(this.b);
            this.w.add(this.o);
            by6 by6Var = new by6(this.a.getPageContext(), yw5.N0, this.a.R0());
            this.r = by6Var;
            this.w.add(by6Var);
            ay6 ay6Var = new ay6(this.a.getPageContext(), ip4.e);
            this.p = ay6Var;
            ay6Var.c0(this.b);
            this.w.add(this.p);
            zx6 zx6Var = new zx6(this.a.getPageContext(), mn4.b);
            this.q = zx6Var;
            zx6Var.f0(this.b);
            this.w.add(this.q);
            ky6 ky6Var = new ky6(this.a.getPageContext());
            this.s = ky6Var;
            ky6Var.b0(this.b);
            this.w.add(this.s);
            oy6 oy6Var = new oy6(this.a.getPageContext());
            this.t = oy6Var;
            oy6Var.b0(this.b);
            this.w.add(this.t);
            dy6 dy6Var = new dy6(this.a.getPageContext(), b());
            this.u = dy6Var;
            this.w.add(dy6Var);
            sy6 sy6Var = new sy6(this.a.getPageContext());
            this.v = sy6Var;
            this.w.add(sy6Var);
            this.b.a(this.w);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void e(ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        sy6 sy6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (sy6Var = this.v) == null) {
            return;
        }
        sy6Var.b0(z);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (wm wmVar : this.w) {
                if (wmVar instanceof wx6) {
                    ((wx6) wmVar).h(str);
                }
            }
        }
    }
}
