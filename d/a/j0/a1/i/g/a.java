package d.a.j0.a1.i.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.i0.r.f0.g;
import d.a.j0.j2.i;
import d.a.j0.q0.d1;
import d.a.j0.x.t;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f51043a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.a1.i.c f51044b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f51045c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f51046d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f51047e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f51048f;

    /* renamed from: g  reason: collision with root package name */
    public g f51049g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f51050h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedHeaderView f51051i;
    public i j;
    public d.a.j0.a1.i.a k;
    public boolean l = true;
    public BdListView.p m = new C1121a();
    public RecyclerView.OnScrollListener n = new b();
    public View.OnClickListener o = new c();

    /* renamed from: d.a.j0.a1.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1121a implements BdListView.p {
        public C1121a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f51047e != null) {
                a.this.f51047e.stopScroll();
            }
            a.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f51053a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (a.this.j != null) {
                    a.this.j.n(a.this.f51047e.getFirstVisiblePosition(), a.this.f51047e.getLastVisiblePosition(), this.f51053a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.g())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f51053a = false;
            } else {
                this.f51053a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f51047e != null) {
                a.this.f51047e.stopScroll();
            }
            if (a.this.f51048f == null || a.this.f51044b == null || !j.z()) {
                return;
            }
            a.this.f51048f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f51048f.z(null);
            if (a.this.l) {
                a.this.f51048f.L();
                a.this.f51044b.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements RecyclerView.RecyclerListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view == null || a.this.j == null) {
                return;
            }
            a.this.j.k(view);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, d.a.j0.a1.i.c cVar, ViewGroup viewGroup, String str) {
        this.f51043a = homePageTabFeedFragment;
        this.f51044b = cVar;
        f(viewGroup);
        d.a.j0.a1.i.a aVar = new d.a.j0.a1.i.a(homePageTabFeedFragment, this.f51047e);
        this.k = aVar;
        aVar.d(str);
        m(false);
    }

    public final void f(ViewGroup viewGroup) {
        this.f51045c = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f51047e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f51043a.getContext()));
        this.f51047e.setFadingEdgeLength(0);
        this.f51047e.setOverScrollMode(2);
        this.f51047e.setOnSrollToBottomListener(this.m);
        this.f51047e.addOnScrollListener(this.n);
        g gVar = new g(this.f51043a.getPageContext());
        this.f51049g = gVar;
        gVar.a(this.f51044b);
        this.f51047e.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f51047e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        PbListView pbListView = new PbListView(this.f51043a.getPageContext().getPageActivity());
        this.f51048f = pbListView;
        pbListView.b();
        this.f51048f.o(R.color.transparent);
        this.f51048f.r(l.g(this.f51043a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f51048f.v();
        this.f51048f.E(R.dimen.tbfontsize33);
        this.f51048f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f51048f.y(R.color.CAM_X0110);
        this.f51048f.q();
        this.f51048f.z(this.o);
        if (this.f51046d == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f51046d = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f51049g);
        }
        new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f51043a.getContext());
        this.f51050h = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f51043a.getContext(), R.dimen.tbds83)));
        if (this.j == null) {
            i iVar = new i(this.f51043a.getPageContext(), this.f51047e);
            this.j = iVar;
            iVar.p(1);
            this.j.t(this.f51043a.getUniqueId());
        }
    }

    public boolean g() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51047e;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f51047e.getChildAt(0).getTop() == 0;
    }

    public void h(int i2) {
        g gVar = this.f51049g;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f51048f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f51048f.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f51051i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.c(i2);
        }
        d.a.j0.a1.i.a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f51050h;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i2);
        }
    }

    public void i() {
        i iVar = this.j;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void j(d.a.j0.a1.i.e.c cVar) {
        m(false);
        if (cVar == null || this.k == null || this.f51047e == null || this.f51048f == null) {
            return;
        }
        this.l = cVar.f51039c;
        if (cVar.f51040d == null && cVar.f51041e == null) {
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f51051i;
            if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                this.f51047e.removeHeaderView(this.f51051i);
                this.f51051i = null;
            }
        } else {
            if (this.f51051i == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f51043a.getContext());
                this.f51051i = homePageTabFeedHeaderView2;
                this.f51047e.s(homePageTabFeedHeaderView2);
            }
            this.f51051i.setData(cVar);
        }
        if (cVar.f51038b > 0) {
            int firstVisiblePosition = this.f51047e.getFirstVisiblePosition();
            View childAt = this.f51047e.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f51047e.getLayoutManager();
            int i2 = firstVisiblePosition - cVar.f51038b;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f51047e.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                this.f51047e.A();
            }
        }
        this.k.c(cVar.f51037a);
        this.k.b();
        i iVar = this.j;
        if (iVar != null) {
            iVar.n(this.f51047e.getFirstVisiblePosition(), this.f51047e.getLastVisiblePosition(), false, true);
        }
    }

    public void k() {
        i iVar = this.j;
        if (iVar != null) {
            iVar.x();
            this.j.q(false);
        }
    }

    public void l() {
        i iVar = this.j;
        if (iVar != null) {
            iVar.q(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.f51047e;
            if (bdTypeRecyclerView != null) {
                this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f51047e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void m(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f51046d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f51046d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void o() {
        if (this.f51048f == null || this.f51044b == null) {
            return;
        }
        if (j.z()) {
            this.f51047e.setNextPage(this.f51048f);
            this.f51048f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f51048f.z(null);
            if (this.l) {
                this.f51048f.L();
                this.f51044b.i();
                return;
            }
            this.f51048f.A(this.f51043a.getResources().getString(R.string.list_has_no_more));
            this.f51048f.f();
            return;
        }
        this.f51047e.setNextPage(null);
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51047e;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }
}
