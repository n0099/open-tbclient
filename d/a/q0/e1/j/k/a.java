package d.a.q0.e1.j.k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.s.f0.g;
import d.a.q0.a0.t;
import d.a.q0.e1.j.e;
import d.a.q0.n2.i;
import d.a.q0.u0.c1;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f56278a;

    /* renamed from: b  reason: collision with root package name */
    public e f56279b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f56280c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f56281d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f56282e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f56283f;

    /* renamed from: g  reason: collision with root package name */
    public g f56284g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f56285h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedHeaderView f56286i;
    public i j;
    public d.a.q0.e1.j.b k;
    public String l;
    public boolean m;
    public int n;
    public BdListView.p o;
    public RecyclerView.OnScrollListener p;
    public View.OnClickListener q;

    /* renamed from: d.a.q0.e1.j.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1359a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f56287e;

        public C1359a(a aVar) {
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
            this.f56287e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f56287e.f56282e != null) {
                    this.f56287e.f56282e.stopScroll();
                }
                this.f56287e.p();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f56288a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f56289b;

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
            this.f56289b = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f56289b.j != null) {
                    this.f56289b.j.n(this.f56289b.f56282e.getFirstVisiblePosition(), this.f56289b.f56282e.getLastVisiblePosition(), this.f56288a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f56289b.h())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.f56288a = false;
                } else {
                    this.f56288a = true;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f56290e;

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
                    return;
                }
            }
            this.f56290e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f56290e.f56282e != null) {
                    this.f56290e.f56282e.stopScroll();
                }
                if (this.f56290e.f56283f == null || this.f56290e.f56279b == null || !j.z()) {
                    return;
                }
                this.f56290e.f56283f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f56290e.f56283f.z(null);
                if (this.f56290e.m) {
                    this.f56290e.f56283f.L();
                    this.f56290e.f56279b.i();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f56291a;

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
            this.f56291a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f56291a.j == null) {
                return;
            }
            this.f56291a.j.k(view);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, e eVar, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, eVar, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = true;
        this.n = 3;
        this.o = new C1359a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.f56278a = homePageTabFeedFragment;
        this.f56279b = eVar;
        this.l = str;
        g(viewGroup);
        d.a.q0.e1.j.b bVar = new d.a.q0.e1.j.b(homePageTabFeedFragment, this.f56282e);
        this.k = bVar;
        bVar.d(str);
        n(false);
    }

    public BdTypeRecyclerView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56282e : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void g(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            this.f56280c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f56282e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f56278a.getContext()));
            this.f56282e.setFadingEdgeLength(0);
            this.f56282e.setOverScrollMode(2);
            this.f56282e.setOnSrollToBottomListener(this.o);
            this.f56282e.addOnScrollListener(this.p);
            g gVar = new g(this.f56278a.getPageContext());
            this.f56284g = gVar;
            gVar.a(this.f56279b);
            this.f56282e.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f56282e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.f56278a.getPageContext().getPageActivity());
            this.f56283f = pbListView;
            pbListView.b();
            this.f56283f.o(R.color.transparent);
            this.f56283f.r(l.g(this.f56278a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f56283f.v();
            this.f56283f.E(R.dimen.tbfontsize33);
            this.f56283f.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f56283f.y(R.color.CAM_X0110);
            this.f56283f.q();
            this.f56283f.z(this.q);
            if (this.f56281d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f56281d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f56284g);
            }
            new c1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f56278a.getContext());
            this.f56285h = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f56278a.getContext(), R.dimen.tbds83)));
            if (this.j == null) {
                i iVar = new i(this.f56278a.getPageContext(), this.f56282e);
                this.j = iVar;
                iVar.p(1);
                this.j.t(this.f56278a.getUniqueId());
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f56282e;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f56282e.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.n == i2) {
            return;
        }
        g gVar = this.f56284g;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f56283f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f56283f.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f56286i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.d(i2);
        }
        d.a.q0.e1.j.b bVar = this.k;
        if (bVar != null) {
            bVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f56285h;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i2);
        }
        this.n = i2;
    }

    public void j() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (iVar = this.j) == null) {
            return;
        }
        iVar.h();
    }

    public void k(d.a.q0.e1.j.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            n(false);
            if (cVar == null || this.k == null || this.f56282e == null || this.f56283f == null) {
                return;
            }
            this.m = cVar.f56271c;
            if (cVar.f56273e == null && cVar.f56274f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f56286i;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f56282e.removeHeaderView(this.f56286i);
                    this.f56286i = null;
                }
            } else {
                if (this.f56286i == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f56278a.getContext());
                    this.f56286i = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.l);
                    this.f56282e.s(this.f56286i);
                }
                this.f56286i.setData(cVar);
            }
            if (cVar.f56270b > 0) {
                int firstVisiblePosition = this.f56282e.getFirstVisiblePosition();
                View childAt = this.f56282e.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f56282e.getLayoutManager();
                int i2 = firstVisiblePosition - cVar.f56270b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f56282e.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f56282e.A();
                }
            }
            this.k.c(cVar.f56269a);
            this.k.b();
            i iVar = this.j;
            if (iVar != null) {
                iVar.n(this.f56282e.getFirstVisiblePosition(), this.f56282e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void l() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (iVar = this.j) == null) {
            return;
        }
        iVar.x();
        this.j.q(false);
    }

    public void m() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (iVar = this.j) == null) {
            return;
        }
        iVar.q(true);
        BdTypeRecyclerView bdTypeRecyclerView = this.f56282e;
        if (bdTypeRecyclerView != null) {
            this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f56282e.getLastVisiblePosition(), false, true);
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdSwipeRefreshLayout = this.f56281d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void o(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f56281d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f56283f == null || this.f56279b == null) {
            return;
        }
        if (j.z()) {
            this.f56282e.setNextPage(this.f56283f);
            this.f56283f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f56283f.z(null);
            if (this.m) {
                this.f56283f.L();
                this.f56279b.i();
                return;
            }
            this.f56283f.A(this.f56278a.getResources().getString(R.string.list_has_no_more));
            this.f56283f.f();
            return;
        }
        this.f56282e.setNextPage(null);
    }

    public void q() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bdTypeRecyclerView = this.f56282e) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }
}
