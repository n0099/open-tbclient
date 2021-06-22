package d.a.o0.b1.j.k;

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
import d.a.n0.r.f0.g;
import d.a.o0.b1.j.e;
import d.a.o0.k2.i;
import d.a.o0.r0.d1;
import d.a.o0.z.t;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f55723a;

    /* renamed from: b  reason: collision with root package name */
    public e f55724b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f55725c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f55726d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f55727e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f55728f;

    /* renamed from: g  reason: collision with root package name */
    public g f55729g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f55730h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedHeaderView f55731i;
    public i j;
    public d.a.o0.b1.j.b k;
    public String l;
    public boolean m = true;
    public int n = 3;
    public BdListView.p o = new C1270a();
    public RecyclerView.OnScrollListener p = new b();
    public View.OnClickListener q = new c();

    /* renamed from: d.a.o0.b1.j.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1270a implements BdListView.p {
        public C1270a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f55727e != null) {
                a.this.f55727e.stopScroll();
            }
            a.this.p();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f55733a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (a.this.j != null) {
                    a.this.j.n(a.this.f55727e.getFirstVisiblePosition(), a.this.f55727e.getLastVisiblePosition(), this.f55733a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.h())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f55733a = false;
            } else {
                this.f55733a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55727e != null) {
                a.this.f55727e.stopScroll();
            }
            if (a.this.f55728f == null || a.this.f55724b == null || !j.z()) {
                return;
            }
            a.this.f55728f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f55728f.z(null);
            if (a.this.m) {
                a.this.f55728f.L();
                a.this.f55724b.j();
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
        this.f55723a = homePageTabFeedFragment;
        this.f55724b = eVar;
        this.l = str;
        g(viewGroup);
        d.a.o0.b1.j.b bVar = new d.a.o0.b1.j.b(homePageTabFeedFragment, this.f55727e);
        this.k = bVar;
        bVar.d(str);
        n(false);
    }

    public BdTypeRecyclerView f() {
        return this.f55727e;
    }

    public final void g(ViewGroup viewGroup) {
        this.f55725c = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f55727e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f55723a.getContext()));
        this.f55727e.setFadingEdgeLength(0);
        this.f55727e.setOverScrollMode(2);
        this.f55727e.setOnSrollToBottomListener(this.o);
        this.f55727e.addOnScrollListener(this.p);
        g gVar = new g(this.f55723a.getPageContext());
        this.f55729g = gVar;
        gVar.a(this.f55724b);
        this.f55727e.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f55727e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        PbListView pbListView = new PbListView(this.f55723a.getPageContext().getPageActivity());
        this.f55728f = pbListView;
        pbListView.b();
        this.f55728f.o(R.color.transparent);
        this.f55728f.r(l.g(this.f55723a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f55728f.v();
        this.f55728f.E(R.dimen.tbfontsize33);
        this.f55728f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f55728f.y(R.color.CAM_X0110);
        this.f55728f.q();
        this.f55728f.z(this.q);
        if (this.f55726d == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f55726d = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f55729g);
        }
        new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f55723a.getContext());
        this.f55730h = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f55723a.getContext(), R.dimen.tbds83)));
        if (this.j == null) {
            i iVar = new i(this.f55723a.getPageContext(), this.f55727e);
            this.j = iVar;
            iVar.p(1);
            this.j.t(this.f55723a.getUniqueId());
        }
    }

    public boolean h() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55727e;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f55727e.getChildAt(0).getTop() == 0;
    }

    public void i(int i2) {
        if (this.n == i2) {
            return;
        }
        g gVar = this.f55729g;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f55728f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55728f.d(i2);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f55731i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.d(i2);
        }
        d.a.o0.b1.j.b bVar = this.k;
        if (bVar != null) {
            bVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f55730h;
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

    public void k(d.a.o0.b1.j.h.c cVar) {
        n(false);
        if (cVar == null || this.k == null || this.f55727e == null || this.f55728f == null) {
            return;
        }
        this.m = cVar.f55716c;
        if (cVar.f55718e == null && cVar.f55719f == null) {
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.f55731i;
            if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                this.f55727e.removeHeaderView(this.f55731i);
                this.f55731i = null;
            }
        } else {
            if (this.f55731i == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f55723a.getContext());
                this.f55731i = homePageTabFeedHeaderView2;
                homePageTabFeedHeaderView2.setTabCode(this.l);
                this.f55727e.s(this.f55731i);
            }
            this.f55731i.setData(cVar);
        }
        if (cVar.f55715b > 0) {
            int firstVisiblePosition = this.f55727e.getFirstVisiblePosition();
            View childAt = this.f55727e.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f55727e.getLayoutManager();
            int i2 = firstVisiblePosition - cVar.f55715b;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f55727e.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                this.f55727e.A();
            }
        }
        this.k.c(cVar.f55714a);
        this.k.b();
        i iVar = this.j;
        if (iVar != null) {
            iVar.n(this.f55727e.getFirstVisiblePosition(), this.f55727e.getLastVisiblePosition(), false, true);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f55727e;
            if (bdTypeRecyclerView != null) {
                this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f55727e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55726d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void o(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55726d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void p() {
        if (this.f55728f == null || this.f55724b == null) {
            return;
        }
        if (j.z()) {
            this.f55727e.setNextPage(this.f55728f);
            this.f55728f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f55728f.z(null);
            if (this.m) {
                this.f55728f.L();
                this.f55724b.j();
                return;
            }
            this.f55728f.A(this.f55723a.getResources().getString(R.string.list_has_no_more));
            this.f55728f.f();
            return;
        }
        this.f55727e.setNextPage(null);
    }

    public void q() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55727e;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }
}
