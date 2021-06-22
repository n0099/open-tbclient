package d.a.o0.j0.l.e;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.r.q.n1;
import d.a.n0.r.q.o1;
import d.a.o0.k2.i;
import d.a.o0.r0.d1;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f59899a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.j0.l.b f59900b;

    /* renamed from: c  reason: collision with root package name */
    public String f59901c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59902d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f59903e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f59904f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f59905g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.r.f0.g f59906h;

    /* renamed from: i  reason: collision with root package name */
    public d1 f59907i;
    public SmartBubbleAnimatedView j;
    public d.a.o0.j0.l.e.b k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public i p;
    public d.a.o0.j0.l.a q;
    public BdListView.p r = new C1443a();
    public RecyclerView.OnScrollListener s = new b();
    public View.OnClickListener t = new c();
    public d.a.n0.m.f u = new d();
    public View.OnClickListener v = new e();
    public PullLeftRefreshLayout.f w = new f();

    /* renamed from: d.a.o0.j0.l.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1443a implements BdListView.p {
        public C1443a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f59904f != null) {
                a.this.f59904f.stopScroll();
            }
            if (a.this.f59905g == null || a.this.f59900b == null) {
                return;
            }
            if (j.z()) {
                a.this.f59904f.setNextPage(a.this.f59905g);
                a.this.f59905g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.f59905g.z(null);
                if (a.this.o) {
                    a.this.f59905g.L();
                    a.this.f59900b.j();
                    return;
                }
                a.this.f59905g.A(a.this.f59899a.getResources().getString(R.string.list_has_no_more));
                a.this.f59905g.f();
                return;
            }
            a.this.f59904f.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f59909a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (a.this.p != null) {
                    a.this.p.n(a.this.f59904f.getFirstVisiblePosition(), a.this.f59904f.getLastVisiblePosition(), this.f59909a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.k())));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f59909a = false;
            } else {
                this.f59909a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f59904f != null) {
                a.this.f59904f.stopScroll();
            }
            if (a.this.f59905g == null || a.this.f59900b == null || !j.z()) {
                return;
            }
            a.this.f59905g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f59905g.z(null);
            if (a.this.o) {
                a.this.f59905g.L();
                a.this.f59900b.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.n0.m.f<n1> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13642");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", n1Var.C());
            if (a.this.n.p != 0) {
                if (a.this.n.p == 1) {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, a.this.f59901c);
                }
            } else {
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", a.this.n.r ? 3 : 1);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                d.a.o0.j0.b.a(a.this.f59899a.getPageContext(), a.this.f59901c);
                if (a.this.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", a.this.n.r ? 5 : 1);
                statisticItem.param("obj_source", 5);
                TiebaStatic.log(statisticItem);
            } else if (n1Var == null || a.this.f59899a == null) {
            } else {
                String D = n1Var.D();
                if (k.isForumName(D)) {
                    a.this.f59899a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f59899a.getFragmentActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.n == null) {
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13643");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", n1Var.C());
                    if (a.this.n.p != 0) {
                        if (a.this.n.p == 1) {
                            statisticItem2.param("obj_locate", 2);
                            statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, a.this.f59901c);
                        }
                    } else {
                        statisticItem2.param("obj_locate", 1);
                        statisticItem2.param("obj_type", a.this.n.r ? 4 : 1);
                    }
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.o0.j0.b.a(a.this.f59899a.getPageContext(), a.this.f59901c);
            if (a.this.n == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13645");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", a.this.n.r ? 5 : 1);
            statisticItem.param("obj_source", 2);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements PullLeftRefreshLayout.f {
        public f() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            d.a.o0.j0.b.a(a.this.f59899a.getPageContext(), a.this.f59901c);
            StatisticItem statisticItem = new StatisticItem("c13645");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", a.this.n.r ? 5 : 1);
            statisticItem.param("obj_source", 4);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements RecyclerView.RecyclerListener {
        public g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view == null || a.this.p == null) {
                return;
            }
            a.this.p.k(view);
        }
    }

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, d.a.o0.j0.l.b bVar, ViewGroup viewGroup, String str) {
        this.f59899a = enterForumTabFeedFragment;
        this.f59900b = bVar;
        this.f59901c = str;
        i(viewGroup);
        this.q = new d.a.o0.j0.l.a(enterForumTabFeedFragment, this.f59904f);
        q(false);
    }

    public final void i(ViewGroup viewGroup) {
        this.f59902d = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f59904f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f59899a.getContext()));
        this.f59904f.setFadingEdgeLength(0);
        this.f59904f.setOverScrollMode(2);
        this.f59904f.setOnSrollToBottomListener(this.r);
        this.f59904f.addOnScrollListener(this.s);
        d.a.n0.r.f0.g gVar = new d.a.n0.r.f0.g(this.f59899a.getPageContext());
        this.f59906h = gVar;
        gVar.a(this.f59900b);
        this.f59904f.setRecyclerListener(new g());
        PbListView pbListView = new PbListView(this.f59899a.getPageContext().getPageActivity());
        this.f59905g = pbListView;
        pbListView.b();
        this.f59905g.o(R.color.CAM_X0205);
        this.f59905g.r(l.g(this.f59899a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f59905g.v();
        this.f59905g.E(R.dimen.tbfontsize33);
        this.f59905g.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f59905g.y(R.color.CAM_X0110);
        this.f59905g.q();
        this.f59905g.z(this.t);
        if (this.f59903e == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f59903e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f59906h);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f59903e.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f59899a.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.f59903e.setLayoutParams(marginLayoutParams);
        }
        this.f59907i = new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f59899a.getContext());
        this.j = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f59899a.getContext(), R.dimen.tbds83)));
        if (this.p == null) {
            i iVar = new i(this.f59899a.getPageContext(), this.f59904f);
            this.p = iVar;
            iVar.p(1);
            this.p.t(this.f59899a.getUniqueId());
        }
        d.a.o0.j0.l.e.b bVar = new d.a.o0.j0.l.e.b(this.f59899a.getPageContext());
        this.k = bVar;
        bVar.g(this.f59901c);
    }

    public final void j() {
        if (this.m == null) {
            TextView textView = new TextView(this.f59899a.getContext());
            this.m = textView;
            textView.setPadding(l.g(this.f59899a.getContext(), R.dimen.tbds44), l.g(this.f59899a.getContext(), R.dimen.tbds60), 0, l.g(this.f59899a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.tab_feed_title);
            this.m.setTextSize(0, l.g(this.f59899a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f59904f.removeHeaderView(this.m);
            this.f59904f.t(this.m, 0);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        }
    }

    public boolean k() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59904f;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f59904f.getChildAt(0).getTop() == 0;
    }

    public void l(int i2) {
        d.a.n0.r.f0.g gVar = this.f59906h;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f59905g;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f59905g.d(i2);
        }
        d.a.o0.j0.l.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
        TextView textView = this.m;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        d.a.o0.j0.l.e.b bVar = this.k;
        if (bVar != null) {
            bVar.e();
        }
        RecommendForumLayout recommendForumLayout = this.n;
        if (recommendForumLayout != null) {
            recommendForumLayout.c();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i2);
        }
    }

    public void m(d.a.o0.j0.l.d.b bVar) {
        if (bVar != null) {
            this.o = bVar.f59890c;
        }
        q(false);
        if (bVar == null || this.q == null || this.f59904f == null || this.f59905g == null) {
            return;
        }
        j();
        u(bVar);
        v(bVar);
        if (bVar.f59892e > 0) {
            int firstVisiblePosition = this.f59904f.getFirstVisiblePosition();
            View childAt = this.f59904f.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f59904f.getLayoutManager();
            int i2 = firstVisiblePosition - bVar.f59892e;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f59904f.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                this.f59904f.A();
            }
            bVar.f59892e = 0;
        }
        this.q.d(bVar.f59891d);
        this.q.c(bVar.f59889b);
        this.q.b();
        if (bVar.f59895h) {
            s(bVar.f59893f);
        }
        i iVar = this.p;
        if (iVar != null) {
            iVar.n(this.f59904f.getFirstVisiblePosition(), this.f59904f.getLastVisiblePosition(), false, true);
        }
    }

    public void n() {
        i iVar = this.p;
        if (iVar != null) {
            iVar.x();
            this.p.q(false);
        }
    }

    public void o(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59904f;
        if (bdTypeRecyclerView == null || i2 >= i3) {
            return;
        }
        bdTypeRecyclerView.E(i2, i3);
    }

    public void p() {
        i iVar = this.p;
        if (iVar != null) {
            iVar.q(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.f59904f;
            if (bdTypeRecyclerView != null) {
                this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f59904f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f59903e;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f59903e;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public final void s(int i2) {
        String string;
        if (i2 < 0) {
            return;
        }
        this.f59907i.f();
        if (i2 > 0) {
            string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
        }
        if (TextUtils.isEmpty(string) || !j.z()) {
            return;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
        smartBubbleAnimatedView.f15318e = string;
        smartBubbleAnimatedView.f15319f = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f59899a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.f59902d;
        if (viewGroup != null) {
            viewGroup.removeView(this.j);
            this.f59902d.addView(this.j, layoutParams);
            this.j.g();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f59904f;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    public final void u(d.a.o0.j0.l.d.b bVar) {
        List<ShortUserInfo> list;
        d.a.o0.j0.l.d.c cVar = bVar.f59894g;
        if (cVar != null && (list = cVar.f59896a) != null && list.size() > 0 && !TextUtils.isEmpty(bVar.f59894g.f59897b)) {
            this.k.f(bVar.f59894g);
            if (this.k.d().getParent() != null || this.l) {
                return;
            }
            this.l = true;
            this.f59904f.t(this.k.d(), 0);
            StatisticItem statisticItem = new StatisticItem("c13656");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f59901c);
            TiebaStatic.log(statisticItem);
            return;
        }
        this.l = false;
        this.f59904f.removeHeaderView(this.k.d());
    }

    public final void v(d.a.o0.j0.l.d.b bVar) {
        if (bVar == null || this.f59904f == null || this.f59899a == null || !bVar.f59895h) {
            return;
        }
        o1 o1Var = bVar.f59888a;
        if (!((o1Var == null || ListUtils.isEmpty(o1Var.B())) ? false : true)) {
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                this.f59904f.removeHeaderView(recommendForumLayout);
                return;
            }
            return;
        }
        if (this.n == null) {
            RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.f59899a.getPageContext());
            this.n = recommendForumLayout2;
            recommendForumLayout2.setShowMore(true);
            this.n.setSquareEntranceAtStart(true);
            this.n.setTabName(this.f59901c);
            this.n.setFrom(1);
        }
        this.n.setOnClickRightArrowListener(this.v);
        this.n.setOnRullOkCallbackr(this.w);
        this.n.setOnItemCoverListener(this.u);
        this.n.a(bVar.f59888a);
        this.f59904f.removeHeaderView(this.n);
        this.f59904f.t(this.n, 0);
        StatisticItem statisticItem = new StatisticItem("c13641");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 2);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f59901c);
        TiebaStatic.log(statisticItem);
    }
}
