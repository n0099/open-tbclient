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
import com.repackage.ft4;
import com.repackage.oa5;
import com.repackage.x95;
import com.repackage.z95;
import java.util.List;
/* loaded from: classes7.dex */
public class xa5<Q extends z95, P extends x95> extends sa5<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x85 b;
    public z85<Q, P> c;
    public fa5 d;
    public BdUniqueId e;
    public TbPageContext f;
    public a95 g;
    public BdTypeRecyclerView h;
    public BdSwipeRefreshLayout i;
    public gt4 j;
    public ta5 k;
    public ua5<P> l;
    public BdListView.p m;
    public j48 n;
    public View.OnClickListener o;
    public final BdListView.p p;
    public final RecyclerView.OnScrollListener q;
    public final RecyclerView.RecyclerListener r;
    public final ft4.g s;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa5 a;

        public a(xa5 xa5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                pa5.b(" ----LoadMoreClickListener----");
                if (this.a.h != null) {
                    this.a.h.stopScroll();
                }
                this.a.o();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa5 a;

        public b(xa5 xa5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pa5.b(" ----onScrollToBottom----");
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

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ xa5 b;

        public c(xa5 xa5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa5Var;
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

    /* loaded from: classes7.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa5 a;

        public d(xa5 xa5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa5Var;
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

    /* loaded from: classes7.dex */
    public class e implements ft4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa5 a;

        public e(xa5 xa5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa5Var;
        }

        @Override // com.repackage.ft4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                pa5.b(" ----onListPullRefresh---- auto=" + z);
                this.a.p(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbPageContext<?> a;
        public ua5 b;
        public ta5 c;
        public oa5.c d;
        public List<wm> e;
        public kl4<om4> f;
        public q95 g;
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

        public f a(List<wm> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                this.e = list;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f b(oa5.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                this.d = cVar;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public xa5 c(TbPageContext<?> tbPageContext) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
                this.a = tbPageContext;
                d();
                return new xa5(this, null);
            }
            return (xa5) invokeL.objValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.d == null) {
                this.d = new oa5.c();
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

        public f f(ta5 ta5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ta5Var)) == null) {
                this.c = ta5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f g(kl4<om4> kl4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, kl4Var)) == null) {
                this.f = kl4Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f h(q95 q95Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, q95Var)) == null) {
                this.g = q95Var;
                return this;
            }
            return (f) invokeL.objValue;
        }

        public f i(ua5 ua5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ua5Var)) == null) {
                this.b = ua5Var;
                return this;
            }
            return (f) invokeL.objValue;
        }
    }

    public /* synthetic */ xa5(f fVar, a aVar) {
        this(fVar);
    }

    public void A() {
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (j48Var = this.n) == null) {
            return;
        }
        j48Var.r(true);
        B(false);
    }

    public final void B(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdTypeRecyclerView = this.h) == null || (j48Var = this.n) == null) {
            return;
        }
        j48Var.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.h.getLastVisiblePosition(), z, true);
    }

    public final void C(w95 w95Var) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w95Var) == null) || w95Var == null || (list = w95Var.a) == null) {
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
        ua5<P> ua5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, p) == null) || this.h == null || (ua5Var = this.l) == null || ua5Var.getView() == null) {
            return;
        }
        if (this.l.a(p) != null) {
            this.h.setHeaderView(this.l.getView());
        } else {
            this.h.removeHeaderView(this.l.getView());
        }
    }

    public final void G() {
        ta5 ta5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ta5Var = this.k) == null) {
            return;
        }
        ta5Var.a();
    }

    public final void H() {
        ta5 ta5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (ta5Var = this.k) == null) {
            return;
        }
        ta5Var.b();
    }

    public final void I() {
        ta5 ta5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (ta5Var = this.k) == null) {
            return;
        }
        ta5Var.c();
    }

    public void J(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            pa5.b(" ----submitDataList--size =" + ListUtils.getCount(list));
            a95 a95Var = this.g;
            if (a95Var != null) {
                a95Var.h(list);
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

    @Override // com.repackage.sa5
    public void e() {
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (j48Var = this.n) == null) {
            return;
        }
        j48Var.h();
    }

    @Override // com.repackage.sa5
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            x();
        }
    }

    @Override // com.repackage.sa5
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

    @Override // com.repackage.ra5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    @Override // com.repackage.sa5
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            pa5.b(" ----sendReq---- ");
            p(true);
        }
    }

    @Override // com.repackage.sa5
    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            j48 j48Var = this.n;
            if (j48Var != null) {
                j48Var.u(bdUniqueId);
            }
            fa5 fa5Var = this.d;
            if (fa5Var != null) {
                fa5Var.e(bdUniqueId);
            }
            a95 a95Var = this.g;
            if (a95Var != null) {
                a95Var.j(bdUniqueId);
            }
        }
    }

    @Override // com.repackage.sa5
    public void j(z85 z85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, z85Var) == null) {
            this.c = z85Var;
            z85Var.b(this.b);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            pa5.b(" ----loadMore---- ");
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

    @Override // com.repackage.wa5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            ta5 ta5Var = this.k;
            if (ta5Var != null) {
                ta5Var.onChangeSkinType(i);
            }
            gt4 gt4Var = this.j;
            if (gt4Var != null) {
                gt4Var.H(i);
            }
            ua5<P> ua5Var = this.l;
            if (ua5Var != null) {
                ua5Var.onChangeSkinType(i);
            }
            L();
            v();
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            pa5.b(" ----callRefresh---- ");
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
                j48 j48Var = new j48(this.f, this.h);
                this.n = j48Var;
                j48Var.p(i);
                this.n.u(this.e);
            }
        }
    }

    public final void t(oa5.c cVar) {
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
                this.k = new ya5(this.f, this.h, cVar);
            }
            gt4 gt4Var = new gt4(this.f);
            this.j = gt4Var;
            gt4Var.e(this.s);
            this.i.setProgressView(this.j);
            fa5 fa5Var = new fa5(this.h);
            this.d = fa5Var;
            fa5Var.e(this.e);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? ListUtils.isEmpty(this.h.getData()) : invokeV.booleanValue;
    }

    public void v() {
        a95 a95Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (a95Var = this.g) == null) {
            return;
        }
        a95Var.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.va5
    /* renamed from: w */
    public w95 a(P p) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, p)) == null) {
            pa5.b(" ----onBindDataToView---- ");
            D(false);
            if (p != null && p.getErrorCode() == 0) {
                pa5.b(" ----showContent---- ");
                w95 d2 = this.d.d(this.c.e(), this.c.d());
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
            pa5.b(" ----showError---- ");
            if (!ListUtils.isEmpty(this.h.getData())) {
                E();
                return null;
            }
            this.c.q(p != null ? p.getErrorMsg() : q(R.string.obfuscated_res_0x7f0f05ac, new Object[0]));
            return null;
        }
        return (w95) invokeL.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            y();
        }
    }

    public final void y() {
        j48 j48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (j48Var = this.n) == null) {
            return;
        }
        j48Var.y();
        this.n.r(false);
    }

    public void z(List<wm> list) {
        a95 a95Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, list) == null) || (a95Var = this.g) == null) {
            return;
        }
        a95Var.g(list);
        this.g.k(this.h);
    }

    public xa5(f fVar) {
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
        this.b = new x85();
        t(fVar.d);
        s(fVar.i);
        a95 a95Var = new a95(this.f, this.h);
        this.g = a95Var;
        a95Var.a(fVar.e);
        this.g.k(this.h);
        this.g.i(fVar.f);
        this.g.f(fVar.g);
        this.g.e(fVar.h);
    }
}
