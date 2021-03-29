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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f63283a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.z0.i.c f63284b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f63285c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f63286d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f63287e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f63288f;

    /* renamed from: g  reason: collision with root package name */
    public g f63289g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f63290h;
    public HomePageTabFeedHeaderView i;
    public i j;
    public d.b.i0.z0.i.a k;
    public boolean l = true;
    public BdListView.p m = new C1707a();
    public RecyclerView.OnScrollListener n = new b();
    public View.OnClickListener o = new c();

    /* renamed from: d.b.i0.z0.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1707a implements BdListView.p {
        public C1707a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f63287e != null) {
                a.this.f63287e.stopScroll();
            }
            a.this.o();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f63292a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.j != null) {
                    a.this.j.n(a.this.f63287e.getFirstVisiblePosition(), a.this.f63287e.getLastVisiblePosition(), this.f63292a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.g())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.f63292a = false;
            } else {
                this.f63292a = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f63287e != null) {
                a.this.f63287e.stopScroll();
            }
            if (a.this.f63288f == null || a.this.f63284b == null || !j.z()) {
                return;
            }
            a.this.f63288f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f63288f.z(null);
            if (a.this.l) {
                a.this.f63288f.L();
                a.this.f63284b.j();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f63283a = homePageTabFeedFragment;
        this.f63284b = cVar;
        f(viewGroup);
        d.b.i0.z0.i.a aVar = new d.b.i0.z0.i.a(homePageTabFeedFragment, this.f63287e);
        this.k = aVar;
        aVar.d(str);
        m(false);
    }

    public final void f(ViewGroup viewGroup) {
        this.f63285c = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f63287e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f63283a.getContext()));
        this.f63287e.setFadingEdgeLength(0);
        this.f63287e.setOverScrollMode(2);
        this.f63287e.setOnSrollToBottomListener(this.m);
        this.f63287e.addOnScrollListener(this.n);
        g gVar = new g(this.f63283a.getPageContext());
        this.f63289g = gVar;
        gVar.b(this.f63284b);
        this.f63287e.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f63287e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        PbListView pbListView = new PbListView(this.f63283a.getPageContext().getPageActivity());
        this.f63288f = pbListView;
        pbListView.b();
        this.f63288f.o(R.color.transparent);
        this.f63288f.r(l.g(this.f63283a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f63288f.v();
        this.f63288f.E(R.dimen.tbfontsize33);
        this.f63288f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f63288f.y(R.color.CAM_X0110);
        this.f63288f.q();
        this.f63288f.z(this.o);
        if (this.f63286d == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f63286d = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f63289g);
        }
        new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f63283a.getContext());
        this.f63290h = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f63283a.getContext(), R.dimen.tbds83)));
        if (this.j == null) {
            i iVar = new i(this.f63283a.getPageContext(), this.f63287e);
            this.j = iVar;
            iVar.p(1);
            this.j.t(this.f63283a.getUniqueId());
        }
    }

    public boolean g() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f63287e;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f63287e.getChildAt(0).getTop() == 0;
    }

    public void h(int i) {
        g gVar = this.f63289g;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.f63288f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f63288f.d(i);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.c(i);
        }
        d.b.i0.z0.i.a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f63290h;
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
        if (cVar == null || this.k == null || this.f63287e == null || this.f63288f == null) {
            return;
        }
        this.l = cVar.f63279c;
        if (cVar.f63280d == null && cVar.f63281e == null) {
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
            if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                this.f63287e.removeHeaderView(this.i);
                this.i = null;
            }
        } else {
            if (this.i == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f63283a.getContext());
                this.i = homePageTabFeedHeaderView2;
                this.f63287e.s(homePageTabFeedHeaderView2);
            }
            this.i.setData(cVar);
        }
        if (cVar.f63278b > 0) {
            int firstVisiblePosition = this.f63287e.getFirstVisiblePosition();
            View childAt = this.f63287e.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f63287e.getLayoutManager();
            int i = firstVisiblePosition - cVar.f63278b;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f63287e.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                this.f63287e.A();
            }
        }
        this.k.c(cVar.f63277a);
        this.k.b();
        i iVar = this.j;
        if (iVar != null) {
            iVar.n(this.f63287e.getFirstVisiblePosition(), this.f63287e.getLastVisiblePosition(), false, true);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f63287e;
            if (bdTypeRecyclerView != null) {
                this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f63287e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void m(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f63286d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f63286d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void o() {
        if (this.f63288f == null || this.f63284b == null) {
            return;
        }
        if (j.z()) {
            this.f63287e.setNextPage(this.f63288f);
            this.f63288f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f63288f.z(null);
            if (this.l) {
                this.f63288f.L();
                this.f63284b.j();
                return;
            }
            this.f63288f.A(this.f63283a.getResources().getString(R.string.list_has_no_more));
            this.f63288f.f();
            return;
        }
        this.f63287e.setNextPage(null);
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f63287e;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }
}
