package d.a.s0.e1.j.k;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.f0.g;
import d.a.s0.a0.t;
import d.a.s0.e1.j.e;
import d.a.s0.n2.i;
import d.a.s0.u0.c1;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f58989a;

    /* renamed from: b  reason: collision with root package name */
    public e f58990b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f58991c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f58992d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f58993e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f58994f;

    /* renamed from: g  reason: collision with root package name */
    public g f58995g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f58996h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedHeaderView f58997i;
    public i j;
    public d.a.s0.e1.j.b k;
    public String l;
    public boolean m;
    public int n;
    public BdListView.p o;
    public RecyclerView.OnScrollListener p;
    public View.OnClickListener q;

    /* renamed from: d.a.s0.e1.j.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1396a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58998e;

        public C1396a(a aVar) {
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
            this.f58998e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f58998e.f58993e != null) {
                    this.f58998e.f58993e.stopScroll();
                }
                this.f58998e.p();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f58999a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f59000b;

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
            this.f59000b = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f59000b.j != null) {
                    this.f59000b.j.n(this.f59000b.f58993e.getFirstVisiblePosition(), this.f59000b.f58993e.getLastVisiblePosition(), this.f58999a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f59000b.h())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.f58999a = false;
                } else {
                    this.f58999a = true;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59001e;

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
            this.f59001e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f59001e.f58993e != null) {
                    this.f59001e.f58993e.stopScroll();
                }
                if (this.f59001e.f58994f == null || this.f59001e.f58990b == null || !j.z()) {
                    return;
                }
                this.f59001e.f58994f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f59001e.f58994f.z(null);
                if (this.f59001e.m) {
                    this.f59001e.f58994f.L();
                    this.f59001e.f58990b.j();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59002a;

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
            this.f59002a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f59002a.j == null) {
                return;
            }
            this.f59002a.j.k(view);
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
        this.o = new C1396a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.f58989a = homePageTabFeedFragment;
        this.f58990b = eVar;
        this.l = str;
        g(viewGroup);
        d.a.s0.e1.j.b bVar = new d.a.s0.e1.j.b(homePageTabFeedFragment, this.f58993e);
        this.k = bVar;
        bVar.d(str);
        n(false);
    }

    public BdTypeRecyclerView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58993e : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void g(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            this.f58991c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f58993e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f58989a.getContext()));
            this.f58993e.setFadingEdgeLength(0);
            this.f58993e.setOverScrollMode(2);
            this.f58993e.setOnSrollToBottomListener(this.o);
            this.f58993e.addOnScrollListener(this.p);
            g gVar = new g(this.f58989a.getPageContext());
            this.f58995g = gVar;
            gVar.a(this.f58990b);
            this.f58993e.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f58993e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.f58989a.getPageContext().getPageActivity());
            this.f58994f = pbListView;
            pbListView.b();
            this.f58994f.o(R.color.transparent);
            this.f58994f.r(l.g(this.f58989a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f58994f.v();
            this.f58994f.E(R.dimen.tbfontsize33);
            this.f58994f.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f58994f.y(R.color.CAM_X0110);
            this.f58994f.q();
            this.f58994f.z(this.q);
            if (this.f58992d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f58992d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f58995g);
            }
            new c1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f58989a.getContext());
            this.f58996h = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f58989a.getContext(), R.dimen.tbds83)));
            if (this.j == null) {
                i iVar = new i(this.f58989a.getPageContext(), this.f58993e);
                this.j = iVar;
                iVar.p(1);
                this.j.t(this.f58989a.getUniqueId());
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f58993e;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f58993e.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.n == i2) {
            return;
        }
        g gVar = this.f58995g;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f58994f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f58994f.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f58997i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.d(i2);
        }
        d.a.s0.e1.j.b bVar = this.k;
        if (bVar != null) {
            bVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f58996h;
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

    public void k(d.a.s0.e1.j.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            n(false);
            if (cVar == null || this.k == null || this.f58993e == null || this.f58994f == null) {
                return;
            }
            this.m = cVar.f58982c;
            if (cVar.f58984e == null && cVar.f58985f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f58997i;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f58993e.removeHeaderView(this.f58997i);
                    this.f58997i = null;
                }
            } else {
                if (this.f58997i == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f58989a.getContext());
                    this.f58997i = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.l);
                    this.f58993e.s(this.f58997i);
                }
                this.f58997i.setData(cVar);
            }
            if (cVar.f58981b > 0) {
                int firstVisiblePosition = this.f58993e.getFirstVisiblePosition();
                View childAt = this.f58993e.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f58993e.getLayoutManager();
                int i2 = firstVisiblePosition - cVar.f58981b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f58993e.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f58993e.A();
                }
            }
            this.k.c(cVar.f58980a);
            this.k.b();
            i iVar = this.j;
            if (iVar != null) {
                iVar.n(this.f58993e.getFirstVisiblePosition(), this.f58993e.getLastVisiblePosition(), false, true);
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f58993e;
        if (bdTypeRecyclerView != null) {
            this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f58993e.getLastVisiblePosition(), false, true);
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdSwipeRefreshLayout = this.f58992d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void o(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f58992d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f58994f == null || this.f58990b == null) {
            return;
        }
        if (j.z()) {
            this.f58993e.setNextPage(this.f58994f);
            this.f58994f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f58994f.z(null);
            if (this.m) {
                this.f58994f.L();
                this.f58990b.j();
                return;
            }
            this.f58994f.A(this.f58989a.getResources().getString(R.string.list_has_no_more));
            this.f58994f.f();
            return;
        }
        this.f58993e.setNextPage(null);
    }

    public void q() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bdTypeRecyclerView = this.f58993e) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }
}
