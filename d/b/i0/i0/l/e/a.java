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
    public EnterForumTabFeedFragment f55718a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.i0.l.b f55719b;

    /* renamed from: c  reason: collision with root package name */
    public String f55720c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f55721d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f55722e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f55723f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f55724g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.r.f0.g f55725h;
    public d1 i;
    public SmartBubbleAnimatedView j;
    public d.b.i0.i0.l.e.b k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public i p;
    public d.b.i0.i0.l.a q;
    public BdListView.p r = new C1293a();
    public RecyclerView.OnScrollListener s = new b();
    public View.OnClickListener t = new c();
    public d.b.h0.m.f u = new d();
    public View.OnClickListener v = new e();
    public PullLeftRefreshLayout.f w = new f();

    /* renamed from: d.b.i0.i0.l.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1293a implements BdListView.p {
        public C1293a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f55723f != null) {
                a.this.f55723f.stopScroll();
            }
            if (a.this.f55724g == null || a.this.f55719b == null) {
                return;
            }
            if (j.z()) {
                a.this.f55723f.setNextPage(a.this.f55724g);
                a.this.f55724g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.f55724g.z(null);
                if (a.this.o) {
                    a.this.f55724g.L();
                    a.this.f55719b.j();
                    return;
                }
                a.this.f55724g.A(a.this.f55718a.getResources().getString(R.string.list_has_no_more));
                a.this.f55724g.f();
                return;
            }
            a.this.f55723f.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f55727a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.p != null) {
                    a.this.p.n(a.this.f55723f.getFirstVisiblePosition(), a.this.f55723f.getLastVisiblePosition(), this.f55727a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.k())));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.f55727a = false;
            } else {
                this.f55727a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55723f != null) {
                a.this.f55723f.stopScroll();
            }
            if (a.this.f55724g == null || a.this.f55719b == null || !j.z()) {
                return;
            }
            a.this.f55724g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f55724g.z(null);
            if (a.this.o) {
                a.this.f55724g.L();
                a.this.f55719b.j();
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
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, a.this.f55720c);
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
                d.b.i0.i0.b.a(a.this.f55718a.getPageContext(), a.this.f55720c);
                if (a.this.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", a.this.n.t ? 5 : 1);
                statisticItem.param("obj_source", 5);
                TiebaStatic.log(statisticItem);
            } else if (n1Var == null || a.this.f55718a == null) {
            } else {
                String D = n1Var.D();
                if (k.isForumName(D)) {
                    a.this.f55718a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f55718a.getFragmentActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.n == null) {
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13643");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", n1Var.C());
                    if (a.this.n.r != 0) {
                        if (a.this.n.r == 1) {
                            statisticItem2.param("obj_locate", 2);
                            statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, a.this.f55720c);
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
            d.b.i0.i0.b.a(a.this.f55718a.getPageContext(), a.this.f55720c);
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
            d.b.i0.i0.b.a(a.this.f55718a.getPageContext(), a.this.f55720c);
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
        this.f55718a = enterForumTabFeedFragment;
        this.f55719b = bVar;
        this.f55720c = str;
        i(viewGroup);
        this.q = new d.b.i0.i0.l.a(enterForumTabFeedFragment, this.f55723f);
        q(false);
    }

    public final void i(ViewGroup viewGroup) {
        this.f55721d = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f55723f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f55718a.getContext()));
        this.f55723f.setFadingEdgeLength(0);
        this.f55723f.setOverScrollMode(2);
        this.f55723f.setOnSrollToBottomListener(this.r);
        this.f55723f.addOnScrollListener(this.s);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f55718a.getPageContext());
        this.f55725h = gVar;
        gVar.b(this.f55719b);
        this.f55723f.setRecyclerListener(new g());
        PbListView pbListView = new PbListView(this.f55718a.getPageContext().getPageActivity());
        this.f55724g = pbListView;
        pbListView.b();
        this.f55724g.o(R.color.CAM_X0205);
        this.f55724g.r(l.g(this.f55718a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f55724g.v();
        this.f55724g.E(R.dimen.tbfontsize33);
        this.f55724g.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f55724g.y(R.color.CAM_X0110);
        this.f55724g.q();
        this.f55724g.z(this.t);
        if (this.f55722e == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f55722e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f55725h);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f55722e.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f55718a.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.f55722e.setLayoutParams(marginLayoutParams);
        }
        this.i = new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f55718a.getContext());
        this.j = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f55718a.getContext(), R.dimen.tbds83)));
        if (this.p == null) {
            i iVar = new i(this.f55718a.getPageContext(), this.f55723f);
            this.p = iVar;
            iVar.p(1);
            this.p.t(this.f55718a.getUniqueId());
        }
        d.b.i0.i0.l.e.b bVar = new d.b.i0.i0.l.e.b(this.f55718a.getPageContext());
        this.k = bVar;
        bVar.g(this.f55720c);
    }

    public final void j() {
        if (this.m == null) {
            TextView textView = new TextView(this.f55718a.getContext());
            this.m = textView;
            textView.setPadding(l.g(this.f55718a.getContext(), R.dimen.tbds44), l.g(this.f55718a.getContext(), R.dimen.tbds60), 0, l.g(this.f55718a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.tab_feed_title);
            this.m.setTextSize(0, l.g(this.f55718a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f55723f.removeHeaderView(this.m);
            this.f55723f.t(this.m, 0);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        }
    }

    public boolean k() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55723f;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f55723f.getChildAt(0).getTop() == 0;
    }

    public void l(int i) {
        d.b.h0.r.f0.g gVar = this.f55725h;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.f55724g;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f55724g.d(i);
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
            this.o = bVar.f55709c;
        }
        q(false);
        if (bVar == null || this.q == null || this.f55723f == null || this.f55724g == null) {
            return;
        }
        j();
        u(bVar);
        v(bVar);
        if (bVar.f55711e > 0) {
            int firstVisiblePosition = this.f55723f.getFirstVisiblePosition();
            View childAt = this.f55723f.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f55723f.getLayoutManager();
            int i = firstVisiblePosition - bVar.f55711e;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f55723f.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                this.f55723f.A();
            }
            bVar.f55711e = 0;
        }
        this.q.d(bVar.f55710d);
        this.q.c(bVar.f55708b);
        this.q.b();
        if (bVar.f55714h) {
            s(bVar.f55712f);
        }
        i iVar = this.p;
        if (iVar != null) {
            iVar.n(this.f55723f.getFirstVisiblePosition(), this.f55723f.getLastVisiblePosition(), false, true);
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f55723f;
        if (bdTypeRecyclerView == null || i >= i2) {
            return;
        }
        bdTypeRecyclerView.E(i, i2);
    }

    public void p() {
        i iVar = this.p;
        if (iVar != null) {
            iVar.q(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.f55723f;
            if (bdTypeRecyclerView != null) {
                this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f55723f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55722e;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55722e;
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
        smartBubbleAnimatedView.f16110e = string;
        smartBubbleAnimatedView.f16111f = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f55718a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.f55721d;
        if (viewGroup != null) {
            viewGroup.removeView(this.j);
            this.f55721d.addView(this.j, layoutParams);
            this.j.g();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f55723f;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    public final void u(d.b.i0.i0.l.d.b bVar) {
        List<ShortUserInfo> list;
        d.b.i0.i0.l.d.c cVar = bVar.f55713g;
        if (cVar != null && (list = cVar.f55715a) != null && list.size() > 0 && !TextUtils.isEmpty(bVar.f55713g.f55716b)) {
            this.k.f(bVar.f55713g);
            if (this.k.d().getParent() != null || this.l) {
                return;
            }
            this.l = true;
            this.f55723f.t(this.k.d(), 0);
            StatisticItem statisticItem = new StatisticItem("c13656");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f55720c);
            TiebaStatic.log(statisticItem);
            return;
        }
        this.l = false;
        this.f55723f.removeHeaderView(this.k.d());
    }

    public final void v(d.b.i0.i0.l.d.b bVar) {
        if (bVar == null || this.f55723f == null || this.f55718a == null || !bVar.f55714h) {
            return;
        }
        o1 o1Var = bVar.f55707a;
        if (!((o1Var == null || ListUtils.isEmpty(o1Var.B())) ? false : true)) {
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                this.f55723f.removeHeaderView(recommendForumLayout);
                return;
            }
            return;
        }
        if (this.n == null) {
            RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.f55718a.getPageContext());
            this.n = recommendForumLayout2;
            recommendForumLayout2.setShowMore(true);
            this.n.setSquareEntranceAtStart(true);
            this.n.setTabName(this.f55720c);
            this.n.setFrom(1);
        }
        this.n.setOnClickRightArrowListener(this.v);
        this.n.setOnRullOkCallbackr(this.w);
        this.n.setOnItemCoverListener(this.u);
        this.n.a(bVar.f55707a);
        this.f55723f.removeHeaderView(this.n);
        this.f55723f.t(this.n, 0);
        StatisticItem statisticItem = new StatisticItem("c13641");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 2);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f55720c);
        TiebaStatic.log(statisticItem);
    }
}
