package d.a.n0.b1.i.g;

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
import d.a.m0.r.f0.g;
import d.a.n0.k2.i;
import d.a.n0.r0.d1;
import d.a.n0.z.t;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f51909a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b1.i.c f51910b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f51911c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f51912d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f51913e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f51914f;

    /* renamed from: g  reason: collision with root package name */
    public g f51915g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f51916h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedHeaderView f51917i;
    public i j;
    public d.a.n0.b1.i.a k;
    public boolean l = true;
    public int m = 3;
    public BdListView.p n = new C1210a();
    public RecyclerView.OnScrollListener o = new b();
    public View.OnClickListener p = new c();

    /* renamed from: d.a.n0.b1.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1210a implements BdListView.p {
        public C1210a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f51913e != null) {
                a.this.f51913e.stopScroll();
            }
            a.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f51919a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (a.this.j != null) {
                    a.this.j.n(a.this.f51913e.getFirstVisiblePosition(), a.this.f51913e.getLastVisiblePosition(), this.f51919a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.g())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f51919a = false;
            } else {
                this.f51919a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f51913e != null) {
                a.this.f51913e.stopScroll();
            }
            if (a.this.f51914f == null || a.this.f51910b == null || !j.z()) {
                return;
            }
            a.this.f51914f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f51914f.z(null);
            if (a.this.l) {
                a.this.f51914f.L();
                a.this.f51910b.i();
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

    public a(HomePageTabFeedFragment homePageTabFeedFragment, d.a.n0.b1.i.c cVar, ViewGroup viewGroup, String str) {
        this.f51909a = homePageTabFeedFragment;
        this.f51910b = cVar;
        f(viewGroup);
        d.a.n0.b1.i.a aVar = new d.a.n0.b1.i.a(homePageTabFeedFragment, this.f51913e);
        this.k = aVar;
        aVar.d(str);
        m(false);
    }

    public final void f(ViewGroup viewGroup) {
        this.f51911c = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f51913e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f51909a.getContext()));
        this.f51913e.setFadingEdgeLength(0);
        this.f51913e.setOverScrollMode(2);
        this.f51913e.setOnSrollToBottomListener(this.n);
        this.f51913e.addOnScrollListener(this.o);
        g gVar = new g(this.f51909a.getPageContext());
        this.f51915g = gVar;
        gVar.a(this.f51910b);
        this.f51913e.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f51913e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        PbListView pbListView = new PbListView(this.f51909a.getPageContext().getPageActivity());
        this.f51914f = pbListView;
        pbListView.b();
        this.f51914f.o(R.color.transparent);
        this.f51914f.r(l.g(this.f51909a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f51914f.v();
        this.f51914f.E(R.dimen.tbfontsize33);
        this.f51914f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f51914f.y(R.color.CAM_X0110);
        this.f51914f.q();
        this.f51914f.z(this.p);
        if (this.f51912d == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f51912d = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f51915g);
        }
        new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f51909a.getContext());
        this.f51916h = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f51909a.getContext(), R.dimen.tbds83)));
        if (this.j == null) {
            i iVar = new i(this.f51909a.getPageContext(), this.f51913e);
            this.j = iVar;
            iVar.p(1);
            this.j.t(this.f51909a.getUniqueId());
        }
    }

    public boolean g() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51913e;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f51913e.getChildAt(0).getTop() == 0;
    }

    public void h(int i2) {
        if (this.m == i2) {
            return;
        }
        g gVar = this.f51915g;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f51914f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f51914f.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f51917i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.c(i2);
        }
        d.a.n0.b1.i.a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f51916h;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i2);
        }
        this.m = i2;
    }

    public void i() {
        i iVar = this.j;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void j(d.a.n0.b1.i.e.c cVar) {
        m(false);
        if (cVar == null || this.k == null || this.f51913e == null || this.f51914f == null) {
            return;
        }
        this.l = cVar.f51905c;
        if (cVar.f51906d == null && cVar.f51907e == null) {
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f51917i;
            if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                this.f51913e.removeHeaderView(this.f51917i);
                this.f51917i = null;
            }
        } else {
            if (this.f51917i == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f51909a.getContext());
                this.f51917i = homePageTabFeedHeaderView2;
                this.f51913e.s(homePageTabFeedHeaderView2);
            }
            this.f51917i.setData(cVar);
        }
        if (cVar.f51904b > 0) {
            int firstVisiblePosition = this.f51913e.getFirstVisiblePosition();
            View childAt = this.f51913e.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f51913e.getLayoutManager();
            int i2 = firstVisiblePosition - cVar.f51904b;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f51913e.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                this.f51913e.A();
            }
        }
        this.k.c(cVar.f51903a);
        this.k.b();
        i iVar = this.j;
        if (iVar != null) {
            iVar.n(this.f51913e.getFirstVisiblePosition(), this.f51913e.getLastVisiblePosition(), false, true);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f51913e;
            if (bdTypeRecyclerView != null) {
                this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f51913e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void m(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f51912d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f51912d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void o() {
        if (this.f51914f == null || this.f51910b == null) {
            return;
        }
        if (j.z()) {
            this.f51913e.setNextPage(this.f51914f);
            this.f51914f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f51914f.z(null);
            if (this.l) {
                this.f51914f.L();
                this.f51910b.i();
                return;
            }
            this.f51914f.A(this.f51909a.getResources().getString(R.string.list_has_no_more));
            this.f51914f.f();
            return;
        }
        this.f51913e.setNextPage(null);
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51913e;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }
}
