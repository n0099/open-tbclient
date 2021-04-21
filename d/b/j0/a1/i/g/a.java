package d.b.j0.a1.i.g;

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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.r.f0.g;
import d.b.j0.j2.i;
import d.b.j0.q0.d1;
import d.b.j0.x.t;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f53323a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.a1.i.c f53324b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f53325c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f53326d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f53327e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f53328f;

    /* renamed from: g  reason: collision with root package name */
    public g f53329g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f53330h;
    public HomePageTabFeedHeaderView i;
    public i j;
    public d.b.j0.a1.i.a k;
    public boolean l = true;
    public BdListView.p m = new C1182a();
    public RecyclerView.OnScrollListener n = new b();
    public View.OnClickListener o = new c();

    /* renamed from: d.b.j0.a1.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1182a implements BdListView.p {
        public C1182a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f53327e != null) {
                a.this.f53327e.stopScroll();
            }
            a.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f53332a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.j != null) {
                    a.this.j.n(a.this.f53327e.getFirstVisiblePosition(), a.this.f53327e.getLastVisiblePosition(), this.f53332a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.g())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.f53332a = false;
            } else {
                this.f53332a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f53327e != null) {
                a.this.f53327e.stopScroll();
            }
            if (a.this.f53328f == null || a.this.f53324b == null || !j.z()) {
                return;
            }
            a.this.f53328f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f53328f.z(null);
            if (a.this.l) {
                a.this.f53328f.L();
                a.this.f53324b.j();
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

    public a(HomePageTabFeedFragment homePageTabFeedFragment, d.b.j0.a1.i.c cVar, ViewGroup viewGroup, String str) {
        this.f53323a = homePageTabFeedFragment;
        this.f53324b = cVar;
        f(viewGroup);
        d.b.j0.a1.i.a aVar = new d.b.j0.a1.i.a(homePageTabFeedFragment, this.f53327e);
        this.k = aVar;
        aVar.d(str);
        m(false);
    }

    public final void f(ViewGroup viewGroup) {
        this.f53325c = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f53327e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f53323a.getContext()));
        this.f53327e.setFadingEdgeLength(0);
        this.f53327e.setOverScrollMode(2);
        this.f53327e.setOnSrollToBottomListener(this.m);
        this.f53327e.addOnScrollListener(this.n);
        g gVar = new g(this.f53323a.getPageContext());
        this.f53329g = gVar;
        gVar.b(this.f53324b);
        this.f53327e.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f53327e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        PbListView pbListView = new PbListView(this.f53323a.getPageContext().getPageActivity());
        this.f53328f = pbListView;
        pbListView.b();
        this.f53328f.o(R.color.transparent);
        this.f53328f.r(l.g(this.f53323a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f53328f.v();
        this.f53328f.E(R.dimen.tbfontsize33);
        this.f53328f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f53328f.y(R.color.CAM_X0110);
        this.f53328f.q();
        this.f53328f.z(this.o);
        if (this.f53326d == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f53326d = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f53329g);
        }
        new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f53323a.getContext());
        this.f53330h = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f53323a.getContext(), R.dimen.tbds83)));
        if (this.j == null) {
            i iVar = new i(this.f53323a.getPageContext(), this.f53327e);
            this.j = iVar;
            iVar.p(1);
            this.j.t(this.f53323a.getUniqueId());
        }
    }

    public boolean g() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53327e;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f53327e.getChildAt(0).getTop() == 0;
    }

    public void h(int i) {
        g gVar = this.f53329g;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.f53328f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f53328f.d(i);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.c(i);
        }
        d.b.j0.a1.i.a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f53330h;
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

    public void j(d.b.j0.a1.i.e.c cVar) {
        m(false);
        if (cVar == null || this.k == null || this.f53327e == null || this.f53328f == null) {
            return;
        }
        this.l = cVar.f53319c;
        if (cVar.f53320d == null && cVar.f53321e == null) {
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
            if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                this.f53327e.removeHeaderView(this.i);
                this.i = null;
            }
        } else {
            if (this.i == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f53323a.getContext());
                this.i = homePageTabFeedHeaderView2;
                this.f53327e.s(homePageTabFeedHeaderView2);
            }
            this.i.setData(cVar);
        }
        if (cVar.f53318b > 0) {
            int firstVisiblePosition = this.f53327e.getFirstVisiblePosition();
            View childAt = this.f53327e.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f53327e.getLayoutManager();
            int i = firstVisiblePosition - cVar.f53318b;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f53327e.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                this.f53327e.A();
            }
        }
        this.k.c(cVar.f53317a);
        this.k.b();
        i iVar = this.j;
        if (iVar != null) {
            iVar.n(this.f53327e.getFirstVisiblePosition(), this.f53327e.getLastVisiblePosition(), false, true);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f53327e;
            if (bdTypeRecyclerView != null) {
                this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f53327e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void m(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f53326d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f53326d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void o() {
        if (this.f53328f == null || this.f53324b == null) {
            return;
        }
        if (j.z()) {
            this.f53327e.setNextPage(this.f53328f);
            this.f53328f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f53328f.z(null);
            if (this.l) {
                this.f53328f.L();
                this.f53324b.j();
                return;
            }
            this.f53328f.A(this.f53323a.getResources().getString(R.string.list_has_no_more));
            this.f53328f.f();
            return;
        }
        this.f53327e.setNextPage(null);
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53327e;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }
}
