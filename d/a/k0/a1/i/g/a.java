package d.a.k0.a1.i.g;

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
import d.a.j0.r.f0.g;
import d.a.k0.j2.i;
import d.a.k0.q0.d1;
import d.a.k0.x.t;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f51742a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.a1.i.c f51743b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f51744c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f51745d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f51746e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f51747f;

    /* renamed from: g  reason: collision with root package name */
    public g f51748g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f51749h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedHeaderView f51750i;
    public i j;
    public d.a.k0.a1.i.a k;
    public boolean l = true;
    public BdListView.p m = new C1193a();
    public RecyclerView.OnScrollListener n = new b();
    public View.OnClickListener o = new c();

    /* renamed from: d.a.k0.a1.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1193a implements BdListView.p {
        public C1193a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f51746e != null) {
                a.this.f51746e.stopScroll();
            }
            a.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f51752a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (a.this.j != null) {
                    a.this.j.n(a.this.f51746e.getFirstVisiblePosition(), a.this.f51746e.getLastVisiblePosition(), this.f51752a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.g())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f51752a = false;
            } else {
                this.f51752a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f51746e != null) {
                a.this.f51746e.stopScroll();
            }
            if (a.this.f51747f == null || a.this.f51743b == null || !j.z()) {
                return;
            }
            a.this.f51747f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f51747f.z(null);
            if (a.this.l) {
                a.this.f51747f.L();
                a.this.f51743b.i();
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

    public a(HomePageTabFeedFragment homePageTabFeedFragment, d.a.k0.a1.i.c cVar, ViewGroup viewGroup, String str) {
        this.f51742a = homePageTabFeedFragment;
        this.f51743b = cVar;
        f(viewGroup);
        d.a.k0.a1.i.a aVar = new d.a.k0.a1.i.a(homePageTabFeedFragment, this.f51746e);
        this.k = aVar;
        aVar.d(str);
        m(false);
    }

    public final void f(ViewGroup viewGroup) {
        this.f51744c = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f51746e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f51742a.getContext()));
        this.f51746e.setFadingEdgeLength(0);
        this.f51746e.setOverScrollMode(2);
        this.f51746e.setOnSrollToBottomListener(this.m);
        this.f51746e.addOnScrollListener(this.n);
        g gVar = new g(this.f51742a.getPageContext());
        this.f51748g = gVar;
        gVar.a(this.f51743b);
        this.f51746e.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f51746e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        PbListView pbListView = new PbListView(this.f51742a.getPageContext().getPageActivity());
        this.f51747f = pbListView;
        pbListView.b();
        this.f51747f.o(R.color.transparent);
        this.f51747f.r(l.g(this.f51742a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f51747f.v();
        this.f51747f.E(R.dimen.tbfontsize33);
        this.f51747f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f51747f.y(R.color.CAM_X0110);
        this.f51747f.q();
        this.f51747f.z(this.o);
        if (this.f51745d == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f51745d = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f51748g);
        }
        new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f51742a.getContext());
        this.f51749h = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f51742a.getContext(), R.dimen.tbds83)));
        if (this.j == null) {
            i iVar = new i(this.f51742a.getPageContext(), this.f51746e);
            this.j = iVar;
            iVar.p(1);
            this.j.t(this.f51742a.getUniqueId());
        }
    }

    public boolean g() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51746e;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f51746e.getChildAt(0).getTop() == 0;
    }

    public void h(int i2) {
        g gVar = this.f51748g;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f51747f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f51747f.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f51750i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.c(i2);
        }
        d.a.k0.a1.i.a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f51749h;
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

    public void j(d.a.k0.a1.i.e.c cVar) {
        m(false);
        if (cVar == null || this.k == null || this.f51746e == null || this.f51747f == null) {
            return;
        }
        this.l = cVar.f51738c;
        if (cVar.f51739d == null && cVar.f51740e == null) {
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f51750i;
            if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                this.f51746e.removeHeaderView(this.f51750i);
                this.f51750i = null;
            }
        } else {
            if (this.f51750i == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f51742a.getContext());
                this.f51750i = homePageTabFeedHeaderView2;
                this.f51746e.s(homePageTabFeedHeaderView2);
            }
            this.f51750i.setData(cVar);
        }
        if (cVar.f51737b > 0) {
            int firstVisiblePosition = this.f51746e.getFirstVisiblePosition();
            View childAt = this.f51746e.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f51746e.getLayoutManager();
            int i2 = firstVisiblePosition - cVar.f51737b;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f51746e.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                this.f51746e.A();
            }
        }
        this.k.c(cVar.f51736a);
        this.k.b();
        i iVar = this.j;
        if (iVar != null) {
            iVar.n(this.f51746e.getFirstVisiblePosition(), this.f51746e.getLastVisiblePosition(), false, true);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f51746e;
            if (bdTypeRecyclerView != null) {
                this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f51746e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void m(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f51745d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f51745d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void o() {
        if (this.f51747f == null || this.f51743b == null) {
            return;
        }
        if (j.z()) {
            this.f51746e.setNextPage(this.f51747f);
            this.f51747f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f51747f.z(null);
            if (this.l) {
                this.f51747f.L();
                this.f51743b.i();
                return;
            }
            this.f51747f.A(this.f51742a.getResources().getString(R.string.list_has_no_more));
            this.f51747f.f();
            return;
        }
        this.f51746e.setNextPage(null);
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51746e;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }
}
