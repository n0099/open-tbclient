package d.b.j0.i0.l.e;

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
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.q.n1;
import d.b.i0.r.q.o1;
import d.b.j0.j2.i;
import d.b.j0.q0.d1;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f57262a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.i0.l.b f57263b;

    /* renamed from: c  reason: collision with root package name */
    public String f57264c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f57265d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f57266e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f57267f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f57268g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.r.f0.g f57269h;
    public d1 i;
    public SmartBubbleAnimatedView j;
    public d.b.j0.i0.l.e.b k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public i p;
    public d.b.j0.i0.l.a q;
    public BdListView.p r = new C1354a();
    public RecyclerView.OnScrollListener s = new b();
    public View.OnClickListener t = new c();
    public d.b.i0.m.f u = new d();
    public View.OnClickListener v = new e();
    public PullLeftRefreshLayout.f w = new f();

    /* renamed from: d.b.j0.i0.l.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1354a implements BdListView.p {
        public C1354a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f57267f != null) {
                a.this.f57267f.stopScroll();
            }
            if (a.this.f57268g == null || a.this.f57263b == null) {
                return;
            }
            if (j.z()) {
                a.this.f57267f.setNextPage(a.this.f57268g);
                a.this.f57268g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.f57268g.z(null);
                if (a.this.o) {
                    a.this.f57268g.L();
                    a.this.f57263b.j();
                    return;
                }
                a.this.f57268g.A(a.this.f57262a.getResources().getString(R.string.list_has_no_more));
                a.this.f57268g.f();
                return;
            }
            a.this.f57267f.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f57271a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.p != null) {
                    a.this.p.n(a.this.f57267f.getFirstVisiblePosition(), a.this.f57267f.getLastVisiblePosition(), this.f57271a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.k())));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.f57271a = false;
            } else {
                this.f57271a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57267f != null) {
                a.this.f57267f.stopScroll();
            }
            if (a.this.f57268g == null || a.this.f57263b == null || !j.z()) {
                return;
            }
            a.this.f57268g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f57268g.z(null);
            if (a.this.o) {
                a.this.f57268g.L();
                a.this.f57263b.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b.i0.m.f<n1> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
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
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, a.this.f57264c);
                }
            } else {
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", a.this.n.t ? 3 : 1);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i, long j) {
            if (n1Var == null) {
                d.b.j0.i0.b.a(a.this.f57262a.getPageContext(), a.this.f57264c);
                if (a.this.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", a.this.n.t ? 5 : 1);
                statisticItem.param("obj_source", 5);
                TiebaStatic.log(statisticItem);
            } else if (n1Var == null || a.this.f57262a == null) {
            } else {
                String D = n1Var.D();
                if (k.isForumName(D)) {
                    a.this.f57262a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f57262a.getFragmentActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.n == null) {
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13643");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", n1Var.C());
                    if (a.this.n.r != 0) {
                        if (a.this.n.r == 1) {
                            statisticItem2.param("obj_locate", 2);
                            statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, a.this.f57264c);
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
            d.b.j0.i0.b.a(a.this.f57262a.getPageContext(), a.this.f57264c);
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
            d.b.j0.i0.b.a(a.this.f57262a.getPageContext(), a.this.f57264c);
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

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, d.b.j0.i0.l.b bVar, ViewGroup viewGroup, String str) {
        this.f57262a = enterForumTabFeedFragment;
        this.f57263b = bVar;
        this.f57264c = str;
        i(viewGroup);
        this.q = new d.b.j0.i0.l.a(enterForumTabFeedFragment, this.f57267f);
        q(false);
    }

    public final void i(ViewGroup viewGroup) {
        this.f57265d = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f57267f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f57262a.getContext()));
        this.f57267f.setFadingEdgeLength(0);
        this.f57267f.setOverScrollMode(2);
        this.f57267f.setOnSrollToBottomListener(this.r);
        this.f57267f.addOnScrollListener(this.s);
        d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(this.f57262a.getPageContext());
        this.f57269h = gVar;
        gVar.b(this.f57263b);
        this.f57267f.setRecyclerListener(new g());
        PbListView pbListView = new PbListView(this.f57262a.getPageContext().getPageActivity());
        this.f57268g = pbListView;
        pbListView.b();
        this.f57268g.o(R.color.CAM_X0205);
        this.f57268g.r(l.g(this.f57262a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f57268g.v();
        this.f57268g.E(R.dimen.tbfontsize33);
        this.f57268g.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f57268g.y(R.color.CAM_X0110);
        this.f57268g.q();
        this.f57268g.z(this.t);
        if (this.f57266e == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f57266e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f57269h);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f57266e.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f57262a.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.f57266e.setLayoutParams(marginLayoutParams);
        }
        this.i = new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f57262a.getContext());
        this.j = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f57262a.getContext(), R.dimen.tbds83)));
        if (this.p == null) {
            i iVar = new i(this.f57262a.getPageContext(), this.f57267f);
            this.p = iVar;
            iVar.p(1);
            this.p.t(this.f57262a.getUniqueId());
        }
        d.b.j0.i0.l.e.b bVar = new d.b.j0.i0.l.e.b(this.f57262a.getPageContext());
        this.k = bVar;
        bVar.g(this.f57264c);
    }

    public final void j() {
        if (this.m == null) {
            TextView textView = new TextView(this.f57262a.getContext());
            this.m = textView;
            textView.setPadding(l.g(this.f57262a.getContext(), R.dimen.tbds44), l.g(this.f57262a.getContext(), R.dimen.tbds60), 0, l.g(this.f57262a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.tab_feed_title);
            this.m.setTextSize(0, l.g(this.f57262a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f57267f.removeHeaderView(this.m);
            this.f57267f.t(this.m, 0);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        }
    }

    public boolean k() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57267f;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f57267f.getChildAt(0).getTop() == 0;
    }

    public void l(int i) {
        d.b.i0.r.f0.g gVar = this.f57269h;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.f57268g;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f57268g.d(i);
        }
        d.b.j0.i0.l.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
        TextView textView = this.m;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        d.b.j0.i0.l.e.b bVar = this.k;
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

    public void m(d.b.j0.i0.l.d.b bVar) {
        if (bVar != null) {
            this.o = bVar.f57253c;
        }
        q(false);
        if (bVar == null || this.q == null || this.f57267f == null || this.f57268g == null) {
            return;
        }
        j();
        u(bVar);
        v(bVar);
        if (bVar.f57255e > 0) {
            int firstVisiblePosition = this.f57267f.getFirstVisiblePosition();
            View childAt = this.f57267f.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f57267f.getLayoutManager();
            int i = firstVisiblePosition - bVar.f57255e;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f57267f.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                this.f57267f.A();
            }
            bVar.f57255e = 0;
        }
        this.q.d(bVar.f57254d);
        this.q.c(bVar.f57252b);
        this.q.b();
        if (bVar.f57258h) {
            s(bVar.f57256f);
        }
        i iVar = this.p;
        if (iVar != null) {
            iVar.n(this.f57267f.getFirstVisiblePosition(), this.f57267f.getLastVisiblePosition(), false, true);
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f57267f;
        if (bdTypeRecyclerView == null || i >= i2) {
            return;
        }
        bdTypeRecyclerView.E(i, i2);
    }

    public void p() {
        i iVar = this.p;
        if (iVar != null) {
            iVar.q(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.f57267f;
            if (bdTypeRecyclerView != null) {
                this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f57267f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f57266e;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f57266e;
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
        smartBubbleAnimatedView.f15779e = string;
        smartBubbleAnimatedView.f15780f = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f57262a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.f57265d;
        if (viewGroup != null) {
            viewGroup.removeView(this.j);
            this.f57265d.addView(this.j, layoutParams);
            this.j.g();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f57267f;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    public final void u(d.b.j0.i0.l.d.b bVar) {
        List<ShortUserInfo> list;
        d.b.j0.i0.l.d.c cVar = bVar.f57257g;
        if (cVar != null && (list = cVar.f57259a) != null && list.size() > 0 && !TextUtils.isEmpty(bVar.f57257g.f57260b)) {
            this.k.f(bVar.f57257g);
            if (this.k.d().getParent() != null || this.l) {
                return;
            }
            this.l = true;
            this.f57267f.t(this.k.d(), 0);
            StatisticItem statisticItem = new StatisticItem("c13656");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f57264c);
            TiebaStatic.log(statisticItem);
            return;
        }
        this.l = false;
        this.f57267f.removeHeaderView(this.k.d());
    }

    public final void v(d.b.j0.i0.l.d.b bVar) {
        if (bVar == null || this.f57267f == null || this.f57262a == null || !bVar.f57258h) {
            return;
        }
        o1 o1Var = bVar.f57251a;
        if (!((o1Var == null || ListUtils.isEmpty(o1Var.B())) ? false : true)) {
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                this.f57267f.removeHeaderView(recommendForumLayout);
                return;
            }
            return;
        }
        if (this.n == null) {
            RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.f57262a.getPageContext());
            this.n = recommendForumLayout2;
            recommendForumLayout2.setShowMore(true);
            this.n.setSquareEntranceAtStart(true);
            this.n.setTabName(this.f57264c);
            this.n.setFrom(1);
        }
        this.n.setOnClickRightArrowListener(this.v);
        this.n.setOnRullOkCallbackr(this.w);
        this.n.setOnItemCoverListener(this.u);
        this.n.a(bVar.f57251a);
        this.f57267f.removeHeaderView(this.n);
        this.f57267f.t(this.n, 0);
        StatisticItem statisticItem = new StatisticItem("c13641");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 2);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f57264c);
        TiebaStatic.log(statisticItem);
    }
}
