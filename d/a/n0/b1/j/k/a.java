package d.a.n0.b1.j.k;

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
import d.a.n0.b1.j.e;
import d.a.n0.k2.i;
import d.a.n0.r0.d1;
import d.a.n0.z.t;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f55598a;

    /* renamed from: b  reason: collision with root package name */
    public e f55599b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f55600c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f55601d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f55602e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f55603f;

    /* renamed from: g  reason: collision with root package name */
    public g f55604g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f55605h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedHeaderView f55606i;
    public i j;
    public d.a.n0.b1.j.b k;
    public String l;
    public boolean m = true;
    public int n = 3;
    public BdListView.p o = new C1266a();
    public RecyclerView.OnScrollListener p = new b();
    public View.OnClickListener q = new c();

    /* renamed from: d.a.n0.b1.j.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1266a implements BdListView.p {
        public C1266a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f55602e != null) {
                a.this.f55602e.stopScroll();
            }
            a.this.p();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f55608a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (a.this.j != null) {
                    a.this.j.n(a.this.f55602e.getFirstVisiblePosition(), a.this.f55602e.getLastVisiblePosition(), this.f55608a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.h())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f55608a = false;
            } else {
                this.f55608a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55602e != null) {
                a.this.f55602e.stopScroll();
            }
            if (a.this.f55603f == null || a.this.f55599b == null || !j.z()) {
                return;
            }
            a.this.f55603f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f55603f.z(null);
            if (a.this.m) {
                a.this.f55603f.L();
                a.this.f55599b.j();
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

    public a(HomePageTabFeedFragment homePageTabFeedFragment, e eVar, ViewGroup viewGroup, String str) {
        this.f55598a = homePageTabFeedFragment;
        this.f55599b = eVar;
        this.l = str;
        g(viewGroup);
        d.a.n0.b1.j.b bVar = new d.a.n0.b1.j.b(homePageTabFeedFragment, this.f55602e);
        this.k = bVar;
        bVar.d(str);
        n(false);
    }

    public BdTypeRecyclerView f() {
        return this.f55602e;
    }

    public final void g(ViewGroup viewGroup) {
        this.f55600c = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f55602e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f55598a.getContext()));
        this.f55602e.setFadingEdgeLength(0);
        this.f55602e.setOverScrollMode(2);
        this.f55602e.setOnSrollToBottomListener(this.o);
        this.f55602e.addOnScrollListener(this.p);
        g gVar = new g(this.f55598a.getPageContext());
        this.f55604g = gVar;
        gVar.a(this.f55599b);
        this.f55602e.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f55602e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        PbListView pbListView = new PbListView(this.f55598a.getPageContext().getPageActivity());
        this.f55603f = pbListView;
        pbListView.b();
        this.f55603f.o(R.color.transparent);
        this.f55603f.r(l.g(this.f55598a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f55603f.v();
        this.f55603f.E(R.dimen.tbfontsize33);
        this.f55603f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f55603f.y(R.color.CAM_X0110);
        this.f55603f.q();
        this.f55603f.z(this.q);
        if (this.f55601d == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f55601d = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f55604g);
        }
        new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f55598a.getContext());
        this.f55605h = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f55598a.getContext(), R.dimen.tbds83)));
        if (this.j == null) {
            i iVar = new i(this.f55598a.getPageContext(), this.f55602e);
            this.j = iVar;
            iVar.p(1);
            this.j.t(this.f55598a.getUniqueId());
        }
    }

    public boolean h() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55602e;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f55602e.getChildAt(0).getTop() == 0;
    }

    public void i(int i2) {
        if (this.n == i2) {
            return;
        }
        g gVar = this.f55604g;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f55603f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55603f.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f55606i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.d(i2);
        }
        d.a.n0.b1.j.b bVar = this.k;
        if (bVar != null) {
            bVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f55605h;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i2);
        }
        this.n = i2;
    }

    public void j() {
        i iVar = this.j;
        if (iVar != null) {
            iVar.h();
        }
    }

    public void k(d.a.n0.b1.j.h.c cVar) {
        n(false);
        if (cVar == null || this.k == null || this.f55602e == null || this.f55603f == null) {
            return;
        }
        this.m = cVar.f55591c;
        if (cVar.f55593e == null && cVar.f55594f == null) {
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f55606i;
            if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                this.f55602e.removeHeaderView(this.f55606i);
                this.f55606i = null;
            }
        } else {
            if (this.f55606i == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f55598a.getContext());
                this.f55606i = homePageTabFeedHeaderView2;
                homePageTabFeedHeaderView2.setTabCode(this.l);
                this.f55602e.s(this.f55606i);
            }
            this.f55606i.setData(cVar);
        }
        if (cVar.f55590b > 0) {
            int firstVisiblePosition = this.f55602e.getFirstVisiblePosition();
            View childAt = this.f55602e.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f55602e.getLayoutManager();
            int i2 = firstVisiblePosition - cVar.f55590b;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f55602e.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                this.f55602e.A();
            }
        }
        this.k.c(cVar.f55589a);
        this.k.b();
        i iVar = this.j;
        if (iVar != null) {
            iVar.n(this.f55602e.getFirstVisiblePosition(), this.f55602e.getLastVisiblePosition(), false, true);
        }
    }

    public void l() {
        i iVar = this.j;
        if (iVar != null) {
            iVar.x();
            this.j.q(false);
        }
    }

    public void m() {
        i iVar = this.j;
        if (iVar != null) {
            iVar.q(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.f55602e;
            if (bdTypeRecyclerView != null) {
                this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f55602e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55601d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void o(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55601d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void p() {
        if (this.f55603f == null || this.f55599b == null) {
            return;
        }
        if (j.z()) {
            this.f55602e.setNextPage(this.f55603f);
            this.f55603f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f55603f.z(null);
            if (this.m) {
                this.f55603f.L();
                this.f55599b.j();
                return;
            }
            this.f55603f.A(this.f55598a.getResources().getString(R.string.list_has_no_more));
            this.f55603f.f();
            return;
        }
        this.f55602e.setNextPage(null);
    }

    public void q() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55602e;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }
}
