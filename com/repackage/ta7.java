package com.repackage;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pu4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ta7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public NavigationBar c;
    public NoNetworkView d;
    public RelativeLayout e;
    public BdSwipeRefreshLayout f;
    public BdTypeRecyclerView g;
    public qu4 h;
    public PbListView i;
    public NoDataView j;
    public boolean k;
    public cb7 l;
    public e m;
    public View.OnClickListener n;
    public final pu4.g o;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta7 a;

        public a(ta7 ta7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i == null || this.a.m == null) {
                return;
            }
            this.a.i.L(0);
            this.a.i.B(null);
            this.a.i.Q();
            this.a.m.b();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements pu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta7 a;

        public b(ta7 ta7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta7Var;
        }

        @Override // com.repackage.pu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (ki.z()) {
                    if (this.a.m != null) {
                        this.a.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.a.f;
                if (bdSwipeRefreshLayout != null) {
                    bdSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ta7 ta7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta7 a;

        public d(ta7 ta7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i == null || this.a.m == null) {
                return;
            }
            this.a.i.L(0);
            this.a.i.B(null);
            this.a.i.N();
            this.a.m.b();
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a();

        void b();
    }

    public ta7(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.o = new b(this);
        this.a = tbPageContext;
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f090152);
        g(tbPageContext);
        this.l = new cb7(tbPageContext, this.g);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            qu4 qu4Var = this.h;
            if (qu4Var != null) {
                qu4Var.H(i);
            }
            NoNetworkView noNetworkView = this.d;
            if (noNetworkView != null) {
                noNetworkView.c(this.a, i);
            }
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.i.d(i);
            }
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.f(this.a, i);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i);
            }
            cb7 cb7Var = this.l;
            if (cb7Var != null) {
                cb7Var.c();
            }
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (RelativeLayout) invokeV.objValue;
    }

    public List<ro> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.g;
            if (bdTypeRecyclerView == null) {
                return null;
            }
            return bdTypeRecyclerView.getData();
        }
        return (List) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.b == null) {
            return;
        }
        if (this.h == null) {
            qu4 qu4Var = new qu4(tbPageContext);
            this.h = qu4Var;
            qu4Var.e(this.o);
        }
        this.h.a0(tbPageContext.getUniqueId());
        if (this.i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.i = pbListView;
            pbListView.b();
        }
        this.i.p(R.color.CAM_X0205);
        this.i.t(mi.f(tbPageContext.getContext(), R.dimen.tbds182));
        this.i.x();
        this.i.G(R.dimen.tbfontsize33);
        this.i.E(SkinManager.getColor(R.color.CAM_X0109));
        this.i.A(R.color.CAM_X0110);
        this.i.B(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f0915ae);
        this.d = noNetworkView;
        noNetworkView.c(this.a, TbadkCoreApplication.getInst().getSkinType());
        this.e = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0906cd);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f0923fd);
        this.c = navigationBar;
        navigationBar.showBottomLine();
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f00de));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090154);
        this.f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.b.findViewById(R.id.obfuscated_res_0x7f090155);
        this.g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.g.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.g.setFadingEdgeLength(0);
        this.g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.g.setOverScrollMode(2);
        this.g.addItemDecoration(new DeviderLineDecoration());
        this.g.setRecyclerListener(new c(this));
        this.g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            cb7 cb7Var = this.l;
            if (cb7Var != null) {
                cb7Var.d();
            }
            qu4 qu4Var = this.h;
            if (qu4Var != null) {
                qu4Var.Y();
            }
        }
    }

    public void i(bp bpVar) {
        cb7 cb7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bpVar) == null) || (cb7Var = this.l) == null) {
            return;
        }
        cb7Var.e(bpVar);
    }

    public void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void k(boolean z, ArrayList<ro> arrayList) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f) == null || this.i == null || this.g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.i.L(0);
            this.i.f();
            this.i.B(this.n);
        } else {
            this.i.L(0);
            this.i.f();
            this.i.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ee));
            this.i.B(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f00df)), null);
                this.j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.g.t(this.j, 0);
                this.j.setVisibility(0);
                this.j.f(this.a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.g.setNextPage(null);
            return;
        }
        this.g.removeHeaderView(this.j);
        this.k = false;
        this.g.setNextPage(this.i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
