package d.a.p0.e1.j.k;

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
import d.a.o0.r.f0.g;
import d.a.p0.a0.t;
import d.a.p0.e1.j.e;
import d.a.p0.n2.i;
import d.a.p0.u0.c1;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f55734a;

    /* renamed from: b  reason: collision with root package name */
    public e f55735b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f55736c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f55737d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f55738e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f55739f;

    /* renamed from: g  reason: collision with root package name */
    public g f55740g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f55741h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedHeaderView f55742i;
    public i j;
    public d.a.p0.e1.j.b k;
    public String l;
    public boolean m;
    public int n;
    public BdListView.p o;
    public RecyclerView.OnScrollListener p;
    public View.OnClickListener q;

    /* renamed from: d.a.p0.e1.j.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1350a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55743e;

        public C1350a(a aVar) {
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
            this.f55743e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f55743e.f55738e != null) {
                    this.f55743e.f55738e.stopScroll();
                }
                this.f55743e.p();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f55744a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f55745b;

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
            this.f55745b = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) && i2 == 0) {
                if (this.f55745b.j != null) {
                    this.f55745b.j.n(this.f55745b.f55738e.getFirstVisiblePosition(), this.f55745b.f55738e.getLastVisiblePosition(), this.f55744a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.f55745b.h())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 > 0) {
                    this.f55744a = false;
                } else {
                    this.f55744a = true;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55746e;

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
            this.f55746e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f55746e.f55738e != null) {
                    this.f55746e.f55738e.stopScroll();
                }
                if (this.f55746e.f55739f == null || this.f55746e.f55735b == null || !j.z()) {
                    return;
                }
                this.f55746e.f55739f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f55746e.f55739f.z(null);
                if (this.f55746e.m) {
                    this.f55746e.f55739f.L();
                    this.f55746e.f55735b.i();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f55747a;

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
            this.f55747a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view = viewHolder.itemView) == null || this.f55747a.j == null) {
                return;
            }
            this.f55747a.j.k(view);
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
        this.o = new C1350a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.f55734a = homePageTabFeedFragment;
        this.f55735b = eVar;
        this.l = str;
        g(viewGroup);
        d.a.p0.e1.j.b bVar = new d.a.p0.e1.j.b(homePageTabFeedFragment, this.f55738e);
        this.k = bVar;
        bVar.d(str);
        n(false);
    }

    public BdTypeRecyclerView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55738e : (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void g(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            this.f55736c = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
            this.f55738e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f55734a.getContext()));
            this.f55738e.setFadingEdgeLength(0);
            this.f55738e.setOverScrollMode(2);
            this.f55738e.setOnSrollToBottomListener(this.o);
            this.f55738e.addOnScrollListener(this.p);
            g gVar = new g(this.f55734a.getPageContext());
            this.f55740g = gVar;
            gVar.a(this.f55735b);
            this.f55738e.setRecyclerListener(new d(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f55738e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            PbListView pbListView = new PbListView(this.f55734a.getPageContext().getPageActivity());
            this.f55739f = pbListView;
            pbListView.b();
            this.f55739f.o(R.color.transparent);
            this.f55739f.r(l.g(this.f55734a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.f55739f.v();
            this.f55739f.E(R.dimen.tbfontsize33);
            this.f55739f.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55739f.y(R.color.CAM_X0110);
            this.f55739f.q();
            this.f55739f.z(this.q);
            if (this.f55737d == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
                this.f55737d = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.f55740g);
            }
            new c1();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f55734a.getContext());
            this.f55741h = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f55734a.getContext(), R.dimen.tbds83)));
            if (this.j == null) {
                i iVar = new i(this.f55734a.getPageContext(), this.f55738e);
                this.j = iVar;
                iVar.p(1);
                this.j.t(this.f55734a.getUniqueId());
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f55738e;
            return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f55738e.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.n == i2) {
            return;
        }
        g gVar = this.f55740g;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f55739f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55739f.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f55742i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.d(i2);
        }
        d.a.p0.e1.j.b bVar = this.k;
        if (bVar != null) {
            bVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f55741h;
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

    public void k(d.a.p0.e1.j.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            n(false);
            if (cVar == null || this.k == null || this.f55738e == null || this.f55739f == null) {
                return;
            }
            this.m = cVar.f55727c;
            if (cVar.f55729e == null && cVar.f55730f == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f55742i;
                if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                    this.f55738e.removeHeaderView(this.f55742i);
                    this.f55742i = null;
                }
            } else {
                if (this.f55742i == null) {
                    HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f55734a.getContext());
                    this.f55742i = homePageTabFeedHeaderView2;
                    homePageTabFeedHeaderView2.setTabCode(this.l);
                    this.f55738e.s(this.f55742i);
                }
                this.f55742i.setData(cVar);
            }
            if (cVar.f55726b > 0) {
                int firstVisiblePosition = this.f55738e.getFirstVisiblePosition();
                View childAt = this.f55738e.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.f55738e.getLayoutManager();
                int i2 = firstVisiblePosition - cVar.f55726b;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.f55738e.z();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                    this.f55738e.A();
                }
            }
            this.k.c(cVar.f55725a);
            this.k.b();
            i iVar = this.j;
            if (iVar != null) {
                iVar.n(this.f55738e.getFirstVisiblePosition(), this.f55738e.getLastVisiblePosition(), false, true);
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f55738e;
        if (bdTypeRecyclerView != null) {
            this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f55738e.getLastVisiblePosition(), false, true);
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (bdSwipeRefreshLayout = this.f55737d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    public void o(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdSwipeRefreshLayout = this.f55737d) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f55739f == null || this.f55735b == null) {
            return;
        }
        if (j.z()) {
            this.f55738e.setNextPage(this.f55739f);
            this.f55739f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f55739f.z(null);
            if (this.m) {
                this.f55739f.L();
                this.f55735b.i();
                return;
            }
            this.f55739f.A(this.f55734a.getResources().getString(R.string.list_has_no_more));
            this.f55739f.f();
            return;
        }
        this.f55738e.setNextPage(null);
    }

    public void q() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bdTypeRecyclerView = this.f55738e) == null) {
            return;
        }
        bdTypeRecyclerView.scrollToPosition(0);
    }
}
