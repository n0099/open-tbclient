package d.a.s0.j1.b.o;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62281a;

    /* renamed from: b  reason: collision with root package name */
    public View f62282b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62283c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f62284d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f62285e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f62286f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f62287g;

    /* renamed from: h  reason: collision with root package name */
    public g f62288h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f62289i;
    public NoDataView j;
    public boolean k;
    public d.a.s0.j1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: d.a.s0.j1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1543a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62290e;

        public View$OnClickListenerC1543a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62290e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f62290e.f62289i == null || this.f62290e.m == null) {
                return;
            }
            this.f62290e.f62289i.J(0);
            this.f62290e.f62289i.z(null);
            this.f62290e.f62289i.O();
            this.f62290e.m.b();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62291e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62291e = aVar;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    if (this.f62291e.m != null) {
                        this.f62291e.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f62291e.f62286f;
                if (bdSwipeRefreshLayout != null) {
                    bdSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62292e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62292e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62292e.f62289i == null || this.f62292e.m == null) {
                return;
            }
            this.f62292e.f62289i.J(0);
            this.f62292e.f62289i.z(null);
            this.f62292e.f62289i.L();
            this.f62292e.m.b();
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a();

        void b();
    }

    public a(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new View$OnClickListenerC1543a(this);
        this.o = new b(this);
        this.f62281a = tbPageContext;
        this.f62282b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new d.a.s0.j1.b.p.d(tbPageContext, this.f62287g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            g gVar = this.f62288h;
            if (gVar != null) {
                gVar.I(i2);
            }
            NoNetworkView noNetworkView = this.f62284d;
            if (noNetworkView != null) {
                noNetworkView.c(this.f62281a, i2);
            }
            PbListView pbListView = this.f62289i;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f62289i.d(i2);
            }
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.f(this.f62281a, i2);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f62283c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f62281a, i2);
            }
            d.a.s0.j1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f62282b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f62285e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f62286f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f62287g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62285e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f62287g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62282b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f62282b == null) {
            return;
        }
        if (this.f62288h == null) {
            g gVar = new g(tbPageContext);
            this.f62288h = gVar;
            gVar.a(this.o);
        }
        this.f62288h.a0(tbPageContext.getUniqueId());
        if (this.f62289i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f62289i = pbListView;
            pbListView.b();
        }
        this.f62289i.o(R.color.CAM_X0205);
        this.f62289i.r(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f62289i.v();
        this.f62289i.E(R.dimen.tbfontsize33);
        this.f62289i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f62289i.y(R.color.CAM_X0110);
        this.f62289i.z(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f62282b.findViewById(R.id.no_networkview);
        this.f62284d = noNetworkView;
        noNetworkView.c(this.f62281a, TbadkCoreApplication.getInst().getSkinType());
        this.f62285e = (RelativeLayout) this.f62282b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f62282b.findViewById(R.id.view_navigation_bar);
        this.f62283c = navigationBar;
        navigationBar.showBottomLine();
        this.f62283c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62283c.setCenterTextTitle(this.f62281a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f62282b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f62286f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f62288h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f62282b.findViewById(R.id.agree_me_recycler_view);
        this.f62287g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f62287g.setLayoutManager(new LinearLayoutManager(this.f62281a.getContext()));
        this.f62287g.setFadingEdgeLength(0);
        this.f62287g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f62287g.setOverScrollMode(2);
        this.f62287g.addItemDecoration(new DeviderLineDecoration());
        this.f62287g.setRecyclerListener(new c(this));
        this.f62287g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.s0.j1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f62288h;
            if (gVar != null) {
                gVar.Y();
            }
        }
    }

    public void i(w wVar) {
        d.a.s0.j1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, wVar) == null) || (dVar = this.l) == null) {
            return;
        }
        dVar.e(wVar);
    }

    public void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void k(boolean z, ArrayList<n> arrayList) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f62286f) == null || this.f62289i == null || this.f62287g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f62289i.J(0);
            this.f62289i.f();
            this.f62289i.z(this.n);
        } else {
            this.f62289i.J(0);
            this.f62289i.f();
            this.f62289i.A(this.f62281a.getResources().getString(R.string.list_no_more));
            this.f62289i.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f62281a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f62281a.getResources().getString(R.string.agree_me_nodata)), null);
                this.j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.f62287g.t(this.j, 0);
                this.j.setVisibility(0);
                this.j.f(this.f62281a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f62287g.setNextPage(null);
            return;
        }
        this.f62287g.removeHeaderView(this.j);
        this.k = false;
        this.f62287g.setNextPage(this.f62289i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f62286f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
