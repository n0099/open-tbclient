package d.a.p0.j1.b.o;

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
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59046a;

    /* renamed from: b  reason: collision with root package name */
    public View f59047b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59048c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f59049d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f59050e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f59051f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f59052g;

    /* renamed from: h  reason: collision with root package name */
    public g f59053h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f59054i;
    public NoDataView j;
    public boolean k;
    public d.a.p0.j1.b.p.d l;
    public e m;
    public View.OnClickListener n;
    public final f.g o;

    /* renamed from: d.a.p0.j1.b.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1499a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59055e;

        public View$OnClickListenerC1499a(a aVar) {
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
            this.f59055e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59055e.f59054i == null || this.f59055e.m == null) {
                return;
            }
            this.f59055e.f59054i.J(0);
            this.f59055e.f59054i.z(null);
            this.f59055e.f59054i.O();
            this.f59055e.m.b();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59056e;

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
            this.f59056e = aVar;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    if (this.f59056e.m != null) {
                        this.f59056e.m.a();
                        return;
                    }
                    return;
                }
                BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f59056e.f59051f;
                if (bdSwipeRefreshLayout != null) {
                    bdSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59057e;

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
            this.f59057e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59057e.f59054i == null || this.f59057e.m == null) {
                return;
            }
            this.f59057e.f59054i.J(0);
            this.f59057e.f59054i.z(null);
            this.f59057e.f59054i.L();
            this.f59057e.m.b();
        }
    }

    /* loaded from: classes8.dex */
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
        this.n = new View$OnClickListenerC1499a(this);
        this.o = new b(this);
        this.f59046a = tbPageContext;
        this.f59047b = view.findViewById(R.id.agree_me_layout);
        g(tbPageContext);
        this.l = new d.a.p0.j1.b.p.d(tbPageContext, this.f59052g);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            g gVar = this.f59053h;
            if (gVar != null) {
                gVar.I(i2);
            }
            NoNetworkView noNetworkView = this.f59049d;
            if (noNetworkView != null) {
                noNetworkView.c(this.f59046a, i2);
            }
            PbListView pbListView = this.f59054i;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f59054i.d(i2);
            }
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.f(this.f59046a, i2);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            NavigationBar navigationBar = this.f59048c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f59046a, i2);
            }
            d.a.p0.j1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.c();
            }
            SkinManager.setBackgroundColor(this.f59047b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f59050e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f59051f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f59052g, R.color.CAM_X0204);
        }
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59050e : (RelativeLayout) invokeV.objValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f59052g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59047b : (View) invokeV.objValue;
    }

    public final void g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) || this.f59047b == null) {
            return;
        }
        if (this.f59053h == null) {
            g gVar = new g(tbPageContext);
            this.f59053h = gVar;
            gVar.a(this.o);
        }
        this.f59053h.a0(tbPageContext.getUniqueId());
        if (this.f59054i == null) {
            PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
            this.f59054i = pbListView;
            pbListView.b();
        }
        this.f59054i.o(R.color.CAM_X0205);
        this.f59054i.r(l.g(tbPageContext.getContext(), R.dimen.tbds182));
        this.f59054i.v();
        this.f59054i.E(R.dimen.tbfontsize33);
        this.f59054i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f59054i.y(R.color.CAM_X0110);
        this.f59054i.z(this.n);
        NoNetworkView noNetworkView = (NoNetworkView) this.f59047b.findViewById(R.id.no_networkview);
        this.f59049d = noNetworkView;
        noNetworkView.c(this.f59046a, TbadkCoreApplication.getInst().getSkinType());
        this.f59050e = (RelativeLayout) this.f59047b.findViewById(R.id.container);
        NavigationBar navigationBar = (NavigationBar) this.f59047b.findViewById(R.id.view_navigation_bar);
        this.f59048c = navigationBar;
        navigationBar.showBottomLine();
        this.f59048c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59048c.setCenterTextTitle(this.f59046a.getString(R.string.agree_me));
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f59047b.findViewById(R.id.agree_me_pull_refresh_layout);
        this.f59051f = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setProgressView(this.f59053h);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f59047b.findViewById(R.id.agree_me_recycler_view);
        this.f59052g = bdTypeRecyclerView;
        ((DefaultItemAnimator) bdTypeRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f59052g.setLayoutManager(new LinearLayoutManager(this.f59046a.getContext()));
        this.f59052g.setFadingEdgeLength(0);
        this.f59052g.setBackgroundColor(SkinManager.getColor(R.color.transparent));
        this.f59052g.setOverScrollMode(2);
        this.f59052g.addItemDecoration(new DeviderLineDecoration());
        this.f59052g.setRecyclerListener(new c(this));
        this.f59052g.setOnSrollToBottomListener(new d(this));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.p0.j1.b.p.d dVar = this.l;
            if (dVar != null) {
                dVar.d();
            }
            g gVar = this.f59053h;
            if (gVar != null) {
                gVar.Y();
            }
        }
    }

    public void i(w wVar) {
        d.a.p0.j1.b.p.d dVar;
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
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, arrayList) == null) || (bdSwipeRefreshLayout = this.f59051f) == null || this.f59054i == null || this.f59052g == null || this.l == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(false);
        if (z) {
            this.f59054i.J(0);
            this.f59054i.f();
            this.f59054i.z(this.n);
        } else {
            this.f59054i.J(0);
            this.f59054i.f();
            this.f59054i.A(this.f59046a.getResources().getString(R.string.list_no_more));
            this.f59054i.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.j == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f59046a.getContext(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.d(null, this.f59046a.getResources().getString(R.string.agree_me_nodata)), null);
                this.j = a2;
                a2.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            }
            if (this.j.getParent() == null && !this.k) {
                this.k = true;
                this.f59052g.t(this.j, 0);
                this.j.setVisibility(0);
                this.j.f(this.f59046a, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f59052g.setNextPage(null);
            return;
        }
        this.f59052g.removeHeaderView(this.j);
        this.k = false;
        this.f59052g.setNextPage(this.f59054i);
        this.l.f(arrayList);
        this.l.c();
    }

    public void l(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f59051f) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }
}
