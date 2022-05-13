package com.repackage;

import android.app.Activity;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.db5;
import com.repackage.fb5;
import com.repackage.pu4;
import com.repackage.ub5;
import java.util.List;
/* loaded from: classes5.dex */
public class dc5<Q extends fb5, P extends db5> extends yb5<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public da5 b;
    public fa5<Q, P> c;
    public lb5 d;
    public BdUniqueId e;
    public TbPageContext f;
    public ga5 g;
    public BdTypeRecyclerView h;
    public BdSwipeRefreshLayout i;
    public qu4 j;
    public zb5 k;
    public ac5<P> l;
    public BdListView.p m;
    public c78 n;
    public View.OnClickListener o;
    public final BdListView.p p;
    public final RecyclerView.OnScrollListener q;
    public final RecyclerView.RecyclerListener r;
    public final pu4.g s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dc5 a;

        public a(dc5 dc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dc5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vb5.b(" ----LoadMoreClickListener----");
                if (this.a.h != null) {
                    this.a.h.stopScroll();
                }
                this.a.o();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dc5 a;

        public b(dc5 dc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dc5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vb5.b(" ----onScrollToBottom----");
                if (this.a.h != null) {
                    this.a.h.stopScroll();
                }
                if (this.a.m != null) {
                    this.a.m.onScrollToBottom();
                }
                this.a.o();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ dc5 b;

        public c(dc5 dc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dc5Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                this.b.B(this.a);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dc5 a;

        public d(dc5 dc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dc5Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || viewHolder.itemView == null || this.a.n == null) {
                return;
            }
            this.a.n.k(viewHolder.itemView);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements pu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dc5 a;

        public e(dc5 dc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dc5Var;
        }

        @Override // com.repackage.pu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                vb5.b(" ----onListPullRefresh---- auto=" + z);
                this.a.p(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;
        public ac5 b;
        public zb5 c;
        public ub5.c d;
        public List<eo> e;
        public vm4<zn4> f;
        public wa5 g;
        public int h;
        public int i;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = 2;
        }

        public f a(List<eo> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                this.e = list;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f b(ub5.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.d = cVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public dc5 c(TbPageContext<?> tbPageContext) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
                this.a = tbPageContext;
                d();
                return new dc5(this, null);
            }
            return (dc5) invokeL.objValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.d == null) {
                this.d = new ub5.c();
            }
        }

        public f e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.h = i;
                return this;
            }
            return (f) invokeI.objValue;
        }

        public f f(zb5 zb5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zb5Var)) == null) {
                this.c = zb5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f g(vm4<zn4> vm4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vm4Var)) == null) {
                this.f = vm4Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f h(wa5 wa5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, wa5Var)) == null) {
                this.g = wa5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f i(ac5 ac5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ac5Var)) == null) {
                this.b = ac5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    public /* synthetic */ dc5(f fVar, a aVar) {
        this(fVar);
    }

    public void A() {
        c78 c78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c78Var = this.n) == null) {
            return;
        }
        c78Var.r(true);
        B(false);
    }

    public final void B(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        c78 c78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdTypeRecyclerView = this.h) == null || (c78Var = this.n) == null) {
            return;
        }
        c78Var.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.h.getLastVisiblePosition(), z, true);
    }

    public final void C(cb5 cb5Var) {
        List<ro> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cb5Var) == null) || cb5Var == null || (list = cb5Var.a) == null) {
            return;
        }
        J(list);
    }

    public void D(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (bdSwipeRefreshLayout = this.i) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!r()) {
                I();
            } else {
                G();
            }
        }
    }

    public final void F(P p) {
        ac5<P> ac5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, p) == null) || this.h == null || (ac5Var = this.l) == null || ac5Var.getView() == null) {
            return;
        }
        if (this.l.a(p) != null) {
            this.h.setHeaderView(this.l.getView());
        } else {
            this.h.removeHeaderView(this.l.getView());
        }
    }

    public final void G() {
        zb5 zb5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (zb5Var = this.k) == null) {
            return;
        }
        zb5Var.a();
    }

    public final void H() {
        zb5 zb5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (zb5Var = this.k) == null) {
            return;
        }
        zb5Var.b();
    }

    public final void I() {
        zb5 zb5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (zb5Var = this.k) == null) {
            return;
        }
        zb5Var.c();
    }

    public void J(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            vb5.b(" ----submitDataList--size =" + ListUtils.getCount(list));
            ga5 ga5Var = this.g;
            if (ga5Var != null) {
                ga5Var.h(list);
            }
        }
    }

    public void K() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdTypeRecyclerView = this.h) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.h.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0202);
        }
    }

    @Override // com.repackage.yb5
    public void e() {
        c78 c78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (c78Var = this.n) == null) {
            return;
        }
        c78Var.h();
    }

    @Override // com.repackage.yb5
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            x();
        }
    }

    @Override // com.repackage.yb5
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            A();
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f.getPageActivity() : (Activity) invokeV.objValue;
    }

    @Override // com.repackage.xb5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    @Override // com.repackage.yb5
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            vb5.b(" ----sendReq---- ");
            p(true);
        }
    }

    @Override // com.repackage.yb5
    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            c78 c78Var = this.n;
            if (c78Var != null) {
                c78Var.u(bdUniqueId);
            }
            lb5 lb5Var = this.d;
            if (lb5Var != null) {
                lb5Var.e(bdUniqueId);
            }
            ga5 ga5Var = this.g;
            if (ga5Var != null) {
                ga5Var.j(bdUniqueId);
            }
        }
    }

    @Override // com.repackage.yb5
    public void j(fa5 fa5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fa5Var) == null) {
            this.c = fa5Var;
            fa5Var.b(this.b);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            vb5.b(" ----loadMore---- ");
            if (r()) {
                H();
                if (u()) {
                    this.c.r();
                } else {
                    this.c.s();
                }
                this.c.g();
                return;
            }
            if (u()) {
                this.c.r();
            } else {
                this.c.s();
            }
            G();
        }
    }

    @Override // com.repackage.cc5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            zb5 zb5Var = this.k;
            if (zb5Var != null) {
                zb5Var.onChangeSkinType(i);
            }
            qu4 qu4Var = this.j;
            if (qu4Var != null) {
                qu4Var.H(i);
            }
            ac5<P> ac5Var = this.l;
            if (ac5Var != null) {
                ac5Var.onChangeSkinType(i);
            }
            L();
            v();
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            vb5.b(" ----callRefresh---- ");
            if (z) {
                if (u()) {
                    this.c.r();
                } else {
                    K();
                    D(true);
                }
            }
            this.c.f(true);
        }
    }

    public final String q(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i, objArr)) == null) ? TbadkCoreApplication.getInst().getResources().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.b.c() : invokeV.booleanValue;
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            if (i == 1 || i == 0 || i == 2) {
                c78 c78Var = new c78(this.f, this.h);
                this.n = c78Var;
                c78Var.p(i);
                this.n.u(this.e);
            }
        }
    }

    public final void t(ub5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cVar) == null) {
            this.i = new BdSwipeRefreshLayout(getActivity());
            this.h = new BdTypeRecyclerView(getActivity());
            L();
            this.i.addView(this.h);
            this.h.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.h.setFadingEdgeLength(0);
            this.h.setVerticalScrollBarEnabled(false);
            this.h.setOverScrollMode(2);
            this.h.setOnSrollToBottomListener(this.p);
            this.h.addOnScrollListener(this.q);
            this.h.setRecyclerListener(this.r);
            if (this.k == null) {
                cVar.h = this.o;
                this.k = new ec5(this.f, this.h, cVar);
            }
            qu4 qu4Var = new qu4(this.f);
            this.j = qu4Var;
            qu4Var.e(this.s);
            this.i.setProgressView(this.j);
            lb5 lb5Var = new lb5(this.h);
            this.d = lb5Var;
            lb5Var.e(this.e);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? ListUtils.isEmpty(this.h.getData()) : invokeV.booleanValue;
    }

    public void v() {
        ga5 ga5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (ga5Var = this.g) == null) {
            return;
        }
        ga5Var.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bc5
    /* renamed from: w */
    public cb5 a(P p) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, p)) == null) {
            vb5.b(" ----onBindDataToView---- ");
            D(false);
            if (p != null && p.getErrorCode() == 0) {
                vb5.b(" ----showContent---- ");
                cb5 d2 = this.d.d(this.c.e(), this.c.d());
                if (d2 != null && !ListUtils.isEmpty(d2.a)) {
                    this.c.s();
                    F(p);
                    E();
                    C(d2);
                    B(false);
                } else {
                    this.c.p(p.getErrorMsg());
                }
                return d2;
            }
            vb5.b(" ----showError---- ");
            if (!ListUtils.isEmpty(this.h.getData())) {
                E();
                return null;
            }
            this.c.q(p != null ? p.getErrorMsg() : q(R.string.obfuscated_res_0x7f0f05a5, new Object[0]));
            return null;
        }
        return (cb5) invokeL.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            y();
        }
    }

    public final void y() {
        c78 c78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (c78Var = this.n) == null) {
            return;
        }
        c78Var.y();
        this.n.r(false);
    }

    public void z(List<eo> list) {
        ga5 ga5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, list) == null) || (ga5Var = this.g) == null) {
            return;
        }
        ga5Var.g(list);
        this.g.k(this.h);
    }

    public dc5(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        TbPageContext<?> tbPageContext = fVar.a;
        this.f = tbPageContext;
        this.k = fVar.c;
        this.l = fVar.b;
        this.e = tbPageContext.getUniqueId();
        this.b = new da5();
        t(fVar.d);
        s(fVar.i);
        ga5 ga5Var = new ga5(this.f, this.h);
        this.g = ga5Var;
        ga5Var.a(fVar.e);
        this.g.k(this.h);
        this.g.i(fVar.f);
        this.g.f(fVar.g);
        this.g.e(fVar.h);
    }
}
