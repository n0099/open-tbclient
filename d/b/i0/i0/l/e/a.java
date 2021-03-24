package d.b.i0.i0.l.e;

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
import d.b.b.e.p.j;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.q.n1;
import d.b.h0.r.q.o1;
import d.b.i0.i2.i;
import d.b.i0.p0.d1;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f55717a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.i0.l.b f55718b;

    /* renamed from: c  reason: collision with root package name */
    public String f55719c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f55720d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f55721e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f55722f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f55723g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.r.f0.g f55724h;
    public d1 i;
    public SmartBubbleAnimatedView j;
    public d.b.i0.i0.l.e.b k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public i p;
    public d.b.i0.i0.l.a q;
    public BdListView.p r = new C1292a();
    public RecyclerView.OnScrollListener s = new b();
    public View.OnClickListener t = new c();
    public d.b.h0.m.f u = new d();
    public View.OnClickListener v = new e();
    public PullLeftRefreshLayout.f w = new f();

    /* renamed from: d.b.i0.i0.l.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1292a implements BdListView.p {
        public C1292a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f55722f != null) {
                a.this.f55722f.stopScroll();
            }
            if (a.this.f55723g == null || a.this.f55718b == null) {
                return;
            }
            if (j.z()) {
                a.this.f55722f.setNextPage(a.this.f55723g);
                a.this.f55723g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.f55723g.z(null);
                if (a.this.o) {
                    a.this.f55723g.L();
                    a.this.f55718b.j();
                    return;
                }
                a.this.f55723g.A(a.this.f55717a.getResources().getString(R.string.list_has_no_more));
                a.this.f55723g.f();
                return;
            }
            a.this.f55722f.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f55726a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.p != null) {
                    a.this.p.n(a.this.f55722f.getFirstVisiblePosition(), a.this.f55722f.getLastVisiblePosition(), this.f55726a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.k())));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.f55726a = false;
            } else {
                this.f55726a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55722f != null) {
                a.this.f55722f.stopScroll();
            }
            if (a.this.f55723g == null || a.this.f55718b == null || !j.z()) {
                return;
            }
            a.this.f55723g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f55723g.z(null);
            if (a.this.o) {
                a.this.f55723g.L();
                a.this.f55718b.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b.h0.m.f<n1> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i, long j) {
            if (n1Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13642");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", n1Var.C());
            if (a.this.n.r != 0) {
                if (a.this.n.r == 1) {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, a.this.f55719c);
                }
            } else {
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", a.this.n.t ? 3 : 1);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i, long j) {
            if (n1Var == null) {
                d.b.i0.i0.b.a(a.this.f55717a.getPageContext(), a.this.f55719c);
                if (a.this.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", a.this.n.t ? 5 : 1);
                statisticItem.param("obj_source", 5);
                TiebaStatic.log(statisticItem);
            } else if (n1Var == null || a.this.f55717a == null) {
            } else {
                String D = n1Var.D();
                if (k.isForumName(D)) {
                    a.this.f55717a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f55717a.getFragmentActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.n == null) {
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13643");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", n1Var.C());
                    if (a.this.n.r != 0) {
                        if (a.this.n.r == 1) {
                            statisticItem2.param("obj_locate", 2);
                            statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, a.this.f55719c);
                        }
                    } else {
                        statisticItem2.param("obj_locate", 1);
                        statisticItem2.param("obj_type", a.this.n.t ? 4 : 1);
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
            d.b.i0.i0.b.a(a.this.f55717a.getPageContext(), a.this.f55719c);
            if (a.this.n == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13645");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", a.this.n.t ? 5 : 1);
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
            d.b.i0.i0.b.a(a.this.f55717a.getPageContext(), a.this.f55719c);
            StatisticItem statisticItem = new StatisticItem("c13645");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", a.this.n.t ? 5 : 1);
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

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, d.b.i0.i0.l.b bVar, ViewGroup viewGroup, String str) {
        this.f55717a = enterForumTabFeedFragment;
        this.f55718b = bVar;
        this.f55719c = str;
        i(viewGroup);
        this.q = new d.b.i0.i0.l.a(enterForumTabFeedFragment, this.f55722f);
        q(false);
    }

    public final void i(ViewGroup viewGroup) {
        this.f55720d = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f55722f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f55717a.getContext()));
        this.f55722f.setFadingEdgeLength(0);
        this.f55722f.setOverScrollMode(2);
        this.f55722f.setOnSrollToBottomListener(this.r);
        this.f55722f.addOnScrollListener(this.s);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f55717a.getPageContext());
        this.f55724h = gVar;
        gVar.b(this.f55718b);
        this.f55722f.setRecyclerListener(new g());
        PbListView pbListView = new PbListView(this.f55717a.getPageContext().getPageActivity());
        this.f55723g = pbListView;
        pbListView.b();
        this.f55723g.o(R.color.CAM_X0205);
        this.f55723g.r(l.g(this.f55717a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f55723g.v();
        this.f55723g.E(R.dimen.tbfontsize33);
        this.f55723g.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f55723g.y(R.color.CAM_X0110);
        this.f55723g.q();
        this.f55723g.z(this.t);
        if (this.f55721e == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f55721e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f55724h);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f55721e.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f55717a.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.f55721e.setLayoutParams(marginLayoutParams);
        }
        this.i = new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f55717a.getContext());
        this.j = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f55717a.getContext(), R.dimen.tbds83)));
        if (this.p == null) {
            i iVar = new i(this.f55717a.getPageContext(), this.f55722f);
            this.p = iVar;
            iVar.p(1);
            this.p.t(this.f55717a.getUniqueId());
        }
        d.b.i0.i0.l.e.b bVar = new d.b.i0.i0.l.e.b(this.f55717a.getPageContext());
        this.k = bVar;
        bVar.g(this.f55719c);
    }

    public final void j() {
        if (this.m == null) {
            TextView textView = new TextView(this.f55717a.getContext());
            this.m = textView;
            textView.setPadding(l.g(this.f55717a.getContext(), R.dimen.tbds44), l.g(this.f55717a.getContext(), R.dimen.tbds60), 0, l.g(this.f55717a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.tab_feed_title);
            this.m.setTextSize(0, l.g(this.f55717a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f55722f.removeHeaderView(this.m);
            this.f55722f.t(this.m, 0);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        }
    }

    public boolean k() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55722f;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f55722f.getChildAt(0).getTop() == 0;
    }

    public void l(int i) {
        d.b.h0.r.f0.g gVar = this.f55724h;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.f55723g;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55723g.d(i);
        }
        d.b.i0.i0.l.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
        TextView textView = this.m;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        d.b.i0.i0.l.e.b bVar = this.k;
        if (bVar != null) {
            bVar.e();
        }
        RecommendForumLayout recommendForumLayout = this.n;
        if (recommendForumLayout != null) {
            recommendForumLayout.c();
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
        if (smartBubbleAnimatedView != null) {
            smartBubbleAnimatedView.e(i);
        }
    }

    public void m(d.b.i0.i0.l.d.b bVar) {
        if (bVar != null) {
            this.o = bVar.f55708c;
        }
        q(false);
        if (bVar == null || this.q == null || this.f55722f == null || this.f55723g == null) {
            return;
        }
        j();
        u(bVar);
        v(bVar);
        if (bVar.f55710e > 0) {
            int firstVisiblePosition = this.f55722f.getFirstVisiblePosition();
            View childAt = this.f55722f.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f55722f.getLayoutManager();
            int i = firstVisiblePosition - bVar.f55710e;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f55722f.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                this.f55722f.A();
            }
            bVar.f55710e = 0;
        }
        this.q.d(bVar.f55709d);
        this.q.c(bVar.f55707b);
        this.q.b();
        if (bVar.f55713h) {
            s(bVar.f55711f);
        }
        i iVar = this.p;
        if (iVar != null) {
            iVar.n(this.f55722f.getFirstVisiblePosition(), this.f55722f.getLastVisiblePosition(), false, true);
        }
    }

    public void n() {
        i iVar = this.p;
        if (iVar != null) {
            iVar.x();
            this.p.q(false);
        }
    }

    public void o(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55722f;
        if (bdTypeRecyclerView == null || i >= i2) {
            return;
        }
        bdTypeRecyclerView.E(i, i2);
    }

    public void p() {
        i iVar = this.p;
        if (iVar != null) {
            iVar.q(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.f55722f;
            if (bdTypeRecyclerView != null) {
                this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f55722f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55721e;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55721e;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public final void s(int i) {
        String string;
        if (i < 0) {
            return;
        }
        this.i.f();
        if (i > 0) {
            string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
        }
        if (TextUtils.isEmpty(string) || !j.z()) {
            return;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
        smartBubbleAnimatedView.f16109e = string;
        smartBubbleAnimatedView.f16110f = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f55717a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.f55720d;
        if (viewGroup != null) {
            viewGroup.removeView(this.j);
            this.f55720d.addView(this.j, layoutParams);
            this.j.g();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55722f;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    public final void u(d.b.i0.i0.l.d.b bVar) {
        List<ShortUserInfo> list;
        d.b.i0.i0.l.d.c cVar = bVar.f55712g;
        if (cVar != null && (list = cVar.f55714a) != null && list.size() > 0 && !TextUtils.isEmpty(bVar.f55712g.f55715b)) {
            this.k.f(bVar.f55712g);
            if (this.k.d().getParent() != null || this.l) {
                return;
            }
            this.l = true;
            this.f55722f.t(this.k.d(), 0);
            StatisticItem statisticItem = new StatisticItem("c13656");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f55719c);
            TiebaStatic.log(statisticItem);
            return;
        }
        this.l = false;
        this.f55722f.removeHeaderView(this.k.d());
    }

    public final void v(d.b.i0.i0.l.d.b bVar) {
        if (bVar == null || this.f55722f == null || this.f55717a == null || !bVar.f55713h) {
            return;
        }
        o1 o1Var = bVar.f55706a;
        if (!((o1Var == null || ListUtils.isEmpty(o1Var.B())) ? false : true)) {
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                this.f55722f.removeHeaderView(recommendForumLayout);
                return;
            }
            return;
        }
        if (this.n == null) {
            RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.f55717a.getPageContext());
            this.n = recommendForumLayout2;
            recommendForumLayout2.setShowMore(true);
            this.n.setSquareEntranceAtStart(true);
            this.n.setTabName(this.f55719c);
            this.n.setFrom(1);
        }
        this.n.setOnClickRightArrowListener(this.v);
        this.n.setOnRullOkCallbackr(this.w);
        this.n.setOnItemCoverListener(this.u);
        this.n.a(bVar.f55706a);
        this.f55722f.removeHeaderView(this.n);
        this.f55722f.t(this.n, 0);
        StatisticItem statisticItem = new StatisticItem("c13641");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 2);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f55719c);
        TiebaStatic.log(statisticItem);
    }
}
