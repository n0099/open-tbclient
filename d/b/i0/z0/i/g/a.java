package d.b.i0.z0.i.g;

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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.r.f0.g;
import d.b.i0.i2.i;
import d.b.i0.p0.d1;
import d.b.i0.x.t;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f63282a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.z0.i.c f63283b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f63284c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f63285d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f63286e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f63287f;

    /* renamed from: g  reason: collision with root package name */
    public g f63288g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f63289h;
    public HomePageTabFeedHeaderView i;
    public i j;
    public d.b.i0.z0.i.a k;
    public boolean l = true;
    public BdListView.p m = new C1706a();
    public RecyclerView.OnScrollListener n = new b();
    public View.OnClickListener o = new c();

    /* renamed from: d.b.i0.z0.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1706a implements BdListView.p {
        public C1706a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f63286e != null) {
                a.this.f63286e.stopScroll();
            }
            a.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f63291a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.j != null) {
                    a.this.j.n(a.this.f63286e.getFirstVisiblePosition(), a.this.f63286e.getLastVisiblePosition(), this.f63291a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.g())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.f63291a = false;
            } else {
                this.f63291a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f63286e != null) {
                a.this.f63286e.stopScroll();
            }
            if (a.this.f63287f == null || a.this.f63283b == null || !j.z()) {
                return;
            }
            a.this.f63287f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f63287f.z(null);
            if (a.this.l) {
                a.this.f63287f.L();
                a.this.f63283b.j();
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

    public a(HomePageTabFeedFragment homePageTabFeedFragment, d.b.i0.z0.i.c cVar, ViewGroup viewGroup, String str) {
        this.f63282a = homePageTabFeedFragment;
        this.f63283b = cVar;
        f(viewGroup);
        d.b.i0.z0.i.a aVar = new d.b.i0.z0.i.a(homePageTabFeedFragment, this.f63286e);
        this.k = aVar;
        aVar.d(str);
        m(false);
    }

    public final void f(ViewGroup viewGroup) {
        this.f63284c = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f63286e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f63282a.getContext()));
        this.f63286e.setFadingEdgeLength(0);
        this.f63286e.setOverScrollMode(2);
        this.f63286e.setOnSrollToBottomListener(this.m);
        this.f63286e.addOnScrollListener(this.n);
        g gVar = new g(this.f63282a.getPageContext());
        this.f63288g = gVar;
        gVar.b(this.f63283b);
        this.f63286e.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f63286e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        PbListView pbListView = new PbListView(this.f63282a.getPageContext().getPageActivity());
        this.f63287f = pbListView;
        pbListView.b();
        this.f63287f.o(R.color.transparent);
        this.f63287f.r(l.g(this.f63282a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f63287f.v();
        this.f63287f.E(R.dimen.tbfontsize33);
        this.f63287f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f63287f.y(R.color.CAM_X0110);
        this.f63287f.q();
        this.f63287f.z(this.o);
        if (this.f63285d == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f63285d = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f63288g);
        }
        new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f63282a.getContext());
        this.f63289h = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f63282a.getContext(), R.dimen.tbds83)));
        if (this.j == null) {
            i iVar = new i(this.f63282a.getPageContext(), this.f63286e);
            this.j = iVar;
            iVar.p(1);
            this.j.t(this.f63282a.getUniqueId());
        }
    }

    public boolean g() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f63286e;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f63286e.getChildAt(0).getTop() == 0;
    }

    public void h(int i) {
        g gVar = this.f63288g;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.f63287f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f63287f.d(i);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.c(i);
        }
        d.b.i0.z0.i.a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f63289h;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i);
        }
    }

    public void i() {
        i iVar = this.j;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void j(d.b.i0.z0.i.e.c cVar) {
        m(false);
        if (cVar == null || this.k == null || this.f63286e == null || this.f63287f == null) {
            return;
        }
        this.l = cVar.f63278c;
        if (cVar.f63279d == null && cVar.f63280e == null) {
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
            if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                this.f63286e.removeHeaderView(this.i);
                this.i = null;
            }
        } else {
            if (this.i == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f63282a.getContext());
                this.i = homePageTabFeedHeaderView2;
                this.f63286e.s(homePageTabFeedHeaderView2);
            }
            this.i.setData(cVar);
        }
        if (cVar.f63277b > 0) {
            int firstVisiblePosition = this.f63286e.getFirstVisiblePosition();
            View childAt = this.f63286e.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f63286e.getLayoutManager();
            int i = firstVisiblePosition - cVar.f63277b;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f63286e.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                this.f63286e.A();
            }
        }
        this.k.c(cVar.f63276a);
        this.k.b();
        i iVar = this.j;
        if (iVar != null) {
            iVar.n(this.f63286e.getFirstVisiblePosition(), this.f63286e.getLastVisiblePosition(), false, true);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f63286e;
            if (bdTypeRecyclerView != null) {
                this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f63286e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void m(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f63285d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f63285d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void o() {
        if (this.f63287f == null || this.f63283b == null) {
            return;
        }
        if (j.z()) {
            this.f63286e.setNextPage(this.f63287f);
            this.f63287f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f63287f.z(null);
            if (this.l) {
                this.f63287f.L();
                this.f63283b.j();
                return;
            }
            this.f63287f.A(this.f63282a.getResources().getString(R.string.list_has_no_more));
            this.f63287f.f();
            return;
        }
        this.f63286e.setNextPage(null);
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f63286e;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }
}
