package d.b.i0.a1.i.g;

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
import d.b.h0.r.f0.g;
import d.b.i0.j2.i;
import d.b.i0.q0.d1;
import d.b.i0.x.t;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public HomePageTabFeedFragment f52902a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.a1.i.c f52903b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f52904c;

    /* renamed from: d  reason: collision with root package name */
    public BdSwipeRefreshLayout f52905d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeRecyclerView f52906e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f52907f;

    /* renamed from: g  reason: collision with root package name */
    public g f52908g;

    /* renamed from: h  reason: collision with root package name */
    public SmartBubbleAnimatedView f52909h;
    public HomePageTabFeedHeaderView i;
    public i j;
    public d.b.i0.a1.i.a k;
    public boolean l = true;
    public BdListView.p m = new C1159a();
    public RecyclerView.OnScrollListener n = new b();
    public View.OnClickListener o = new c();

    /* renamed from: d.b.i0.a1.i.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1159a implements BdListView.p {
        public C1159a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f52906e != null) {
                a.this.f52906e.stopScroll();
            }
            a.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f52911a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.j != null) {
                    a.this.j.n(a.this.f52906e.getFirstVisiblePosition(), a.this.f52906e.getLastVisiblePosition(), this.f52911a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.g())));
                t.b().c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.f52911a = false;
            } else {
                this.f52911a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f52906e != null) {
                a.this.f52906e.stopScroll();
            }
            if (a.this.f52907f == null || a.this.f52903b == null || !j.z()) {
                return;
            }
            a.this.f52907f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f52907f.z(null);
            if (a.this.l) {
                a.this.f52907f.L();
                a.this.f52903b.j();
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

    public a(HomePageTabFeedFragment homePageTabFeedFragment, d.b.i0.a1.i.c cVar, ViewGroup viewGroup, String str) {
        this.f52902a = homePageTabFeedFragment;
        this.f52903b = cVar;
        f(viewGroup);
        d.b.i0.a1.i.a aVar = new d.b.i0.a1.i.a(homePageTabFeedFragment, this.f52906e);
        this.k = aVar;
        aVar.d(str);
        m(false);
    }

    public final void f(ViewGroup viewGroup) {
        this.f52904c = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f52906e = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f52902a.getContext()));
        this.f52906e.setFadingEdgeLength(0);
        this.f52906e.setOverScrollMode(2);
        this.f52906e.setOnSrollToBottomListener(this.m);
        this.f52906e.addOnScrollListener(this.n);
        g gVar = new g(this.f52902a.getPageContext());
        this.f52908g = gVar;
        gVar.b(this.f52903b);
        this.f52906e.setRecyclerListener(new d());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f52906e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        PbListView pbListView = new PbListView(this.f52902a.getPageContext().getPageActivity());
        this.f52907f = pbListView;
        pbListView.b();
        this.f52907f.o(R.color.transparent);
        this.f52907f.r(l.g(this.f52902a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f52907f.v();
        this.f52907f.E(R.dimen.tbfontsize33);
        this.f52907f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f52907f.y(R.color.CAM_X0110);
        this.f52907f.q();
        this.f52907f.z(this.o);
        if (this.f52905d == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f52905d = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f52908g);
        }
        new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f52902a.getContext());
        this.f52909h = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f52902a.getContext(), R.dimen.tbds83)));
        if (this.j == null) {
            i iVar = new i(this.f52902a.getPageContext(), this.f52906e);
            this.j = iVar;
            iVar.p(1);
            this.j.t(this.f52902a.getUniqueId());
        }
    }

    public boolean g() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52906e;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f52906e.getChildAt(0).getTop() == 0;
    }

    public void h(int i) {
        g gVar = this.f52908g;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.f52907f;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f52907f.d(i);
        }
        HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
        if (homePageTabFeedHeaderView != null) {
            homePageTabFeedHeaderView.c(i);
        }
        d.b.i0.a1.i.a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.f52909h;
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

    public void j(d.b.i0.a1.i.e.c cVar) {
        m(false);
        if (cVar == null || this.k == null || this.f52906e == null || this.f52907f == null) {
            return;
        }
        this.l = cVar.f52898c;
        if (cVar.f52899d == null && cVar.f52900e == null) {
            HomePageTabFeedHeaderView homePageTabFeedHeaderView = this.i;
            if (homePageTabFeedHeaderView != null && homePageTabFeedHeaderView.getParent() != null) {
                this.f52906e.removeHeaderView(this.i);
                this.i = null;
            }
        } else {
            if (this.i == null) {
                HomePageTabFeedHeaderView homePageTabFeedHeaderView2 = new HomePageTabFeedHeaderView(this.f52902a.getContext());
                this.i = homePageTabFeedHeaderView2;
                this.f52906e.s(homePageTabFeedHeaderView2);
            }
            this.i.setData(cVar);
        }
        if (cVar.f52897b > 0) {
            int firstVisiblePosition = this.f52906e.getFirstVisiblePosition();
            View childAt = this.f52906e.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f52906e.getLayoutManager();
            int i = firstVisiblePosition - cVar.f52897b;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f52906e.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                this.f52906e.A();
            }
        }
        this.k.c(cVar.f52896a);
        this.k.b();
        i iVar = this.j;
        if (iVar != null) {
            iVar.n(this.f52906e.getFirstVisiblePosition(), this.f52906e.getLastVisiblePosition(), false, true);
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f52906e;
            if (bdTypeRecyclerView != null) {
                this.j.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f52906e.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void m(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f52905d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void n(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f52905d;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void o() {
        if (this.f52907f == null || this.f52903b == null) {
            return;
        }
        if (j.z()) {
            this.f52906e.setNextPage(this.f52907f);
            this.f52907f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f52907f.z(null);
            if (this.l) {
                this.f52907f.L();
                this.f52903b.j();
                return;
            }
            this.f52907f.A(this.f52902a.getResources().getString(R.string.list_has_no_more));
            this.f52907f.f();
            return;
        }
        this.f52906e.setNextPage(null);
    }

    public void p() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52906e;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }
}
