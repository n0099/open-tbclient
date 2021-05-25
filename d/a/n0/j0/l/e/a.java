package d.a.n0.j0.l.e;

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
import d.a.m0.r.q.n1;
import d.a.m0.r.q.o1;
import d.a.n0.k2.i;
import d.a.n0.r0.d1;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EnterForumTabFeedFragment f56085a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.j0.l.b f56086b;

    /* renamed from: c  reason: collision with root package name */
    public String f56087c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56088d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f56089e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f56090f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f56091g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.r.f0.g f56092h;

    /* renamed from: i  reason: collision with root package name */
    public d1 f56093i;
    public SmartBubbleAnimatedView j;
    public d.a.n0.j0.l.e.b k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public i p;
    public d.a.n0.j0.l.a q;
    public BdListView.p r = new C1383a();
    public RecyclerView.OnScrollListener s = new b();
    public View.OnClickListener t = new c();
    public d.a.m0.m.f u = new d();
    public View.OnClickListener v = new e();
    public PullLeftRefreshLayout.f w = new f();

    /* renamed from: d.a.n0.j0.l.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1383a implements BdListView.p {
        public C1383a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f56090f != null) {
                a.this.f56090f.stopScroll();
            }
            if (a.this.f56091g == null || a.this.f56086b == null) {
                return;
            }
            if (j.z()) {
                a.this.f56090f.setNextPage(a.this.f56091g);
                a.this.f56091g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.f56091g.z(null);
                if (a.this.o) {
                    a.this.f56091g.L();
                    a.this.f56086b.i();
                    return;
                }
                a.this.f56091g.A(a.this.f56085a.getResources().getString(R.string.list_has_no_more));
                a.this.f56091g.f();
                return;
            }
            a.this.f56090f.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f56095a;

        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                if (a.this.p != null) {
                    a.this.p.n(a.this.f56090f.getFirstVisiblePosition(), a.this.f56090f.getLastVisiblePosition(), this.f56095a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ a.this.k())));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (i3 > 0) {
                this.f56095a = false;
            } else {
                this.f56095a = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f56090f != null) {
                a.this.f56090f.stopScroll();
            }
            if (a.this.f56091g == null || a.this.f56086b == null || !j.z()) {
                return;
            }
            a.this.f56091g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f56091g.z(null);
            if (a.this.o) {
                a.this.f56091g.L();
                a.this.f56086b.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.m0.m.f<n1> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
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
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, a.this.f56087c);
                }
            } else {
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", a.this.n.r ? 3 : 1);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                d.a.n0.j0.b.a(a.this.f56085a.getPageContext(), a.this.f56087c);
                if (a.this.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_type", a.this.n.r ? 5 : 1);
                statisticItem.param("obj_source", 5);
                TiebaStatic.log(statisticItem);
            } else if (n1Var == null || a.this.f56085a == null) {
            } else {
                String D = n1Var.D();
                if (k.isForumName(D)) {
                    a.this.f56085a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f56085a.getFragmentActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.n == null) {
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13643");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", n1Var.C());
                    if (a.this.n.p != 0) {
                        if (a.this.n.p == 1) {
                            statisticItem2.param("obj_locate", 2);
                            statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, a.this.f56087c);
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
            d.a.n0.j0.b.a(a.this.f56085a.getPageContext(), a.this.f56087c);
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
            d.a.n0.j0.b.a(a.this.f56085a.getPageContext(), a.this.f56087c);
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

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, d.a.n0.j0.l.b bVar, ViewGroup viewGroup, String str) {
        this.f56085a = enterForumTabFeedFragment;
        this.f56086b = bVar;
        this.f56087c = str;
        i(viewGroup);
        this.q = new d.a.n0.j0.l.a(enterForumTabFeedFragment, this.f56090f);
        q(false);
    }

    public final void i(ViewGroup viewGroup) {
        this.f56088d = viewGroup;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.f56090f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f56085a.getContext()));
        this.f56090f.setFadingEdgeLength(0);
        this.f56090f.setOverScrollMode(2);
        this.f56090f.setOnSrollToBottomListener(this.r);
        this.f56090f.addOnScrollListener(this.s);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(this.f56085a.getPageContext());
        this.f56092h = gVar;
        gVar.a(this.f56086b);
        this.f56090f.setRecyclerListener(new g());
        PbListView pbListView = new PbListView(this.f56085a.getPageContext().getPageActivity());
        this.f56091g = pbListView;
        pbListView.b();
        this.f56091g.o(R.color.CAM_X0205);
        this.f56091g.r(l.g(this.f56085a.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.f56091g.v();
        this.f56091g.E(R.dimen.tbfontsize33);
        this.f56091g.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f56091g.y(R.color.CAM_X0110);
        this.f56091g.q();
        this.f56091g.z(this.t);
        if (this.f56089e == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.f56089e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f56092h);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f56089e.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f56085a.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.f56089e.setLayoutParams(marginLayoutParams);
        }
        this.f56093i = new d1();
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.f56085a.getContext());
        this.j = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, l.g(this.f56085a.getContext(), R.dimen.tbds83)));
        if (this.p == null) {
            i iVar = new i(this.f56085a.getPageContext(), this.f56090f);
            this.p = iVar;
            iVar.p(1);
            this.p.t(this.f56085a.getUniqueId());
        }
        d.a.n0.j0.l.e.b bVar = new d.a.n0.j0.l.e.b(this.f56085a.getPageContext());
        this.k = bVar;
        bVar.g(this.f56087c);
    }

    public final void j() {
        if (this.m == null) {
            TextView textView = new TextView(this.f56085a.getContext());
            this.m = textView;
            textView.setPadding(l.g(this.f56085a.getContext(), R.dimen.tbds44), l.g(this.f56085a.getContext(), R.dimen.tbds60), 0, l.g(this.f56085a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.tab_feed_title);
            this.m.setTextSize(0, l.g(this.f56085a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f56090f.removeHeaderView(this.m);
            this.f56090f.t(this.m, 0);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        }
    }

    public boolean k() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f56090f;
        return bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f56090f.getChildAt(0).getTop() == 0;
    }

    public void l(int i2) {
        d.a.m0.r.f0.g gVar = this.f56092h;
        if (gVar != null) {
            gVar.I(i2);
        }
        PbListView pbListView = this.f56091g;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f56091g.d(i2);
        }
        d.a.n0.j0.l.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
        TextView textView = this.m;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        d.a.n0.j0.l.e.b bVar = this.k;
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

    public void m(d.a.n0.j0.l.d.b bVar) {
        if (bVar != null) {
            this.o = bVar.f56076c;
        }
        q(false);
        if (bVar == null || this.q == null || this.f56090f == null || this.f56091g == null) {
            return;
        }
        j();
        u(bVar);
        v(bVar);
        if (bVar.f56078e > 0) {
            int firstVisiblePosition = this.f56090f.getFirstVisiblePosition();
            View childAt = this.f56090f.getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = this.f56090f.getLayoutManager();
            int i2 = firstVisiblePosition - bVar.f56078e;
            if (layoutManager instanceof LinearLayoutManager) {
                this.f56090f.z();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                this.f56090f.A();
            }
            bVar.f56078e = 0;
        }
        this.q.d(bVar.f56077d);
        this.q.c(bVar.f56075b);
        this.q.b();
        if (bVar.f56081h) {
            s(bVar.f56079f);
        }
        i iVar = this.p;
        if (iVar != null) {
            iVar.n(this.f56090f.getFirstVisiblePosition(), this.f56090f.getLastVisiblePosition(), false, true);
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f56090f;
        if (bdTypeRecyclerView == null || i2 >= i3) {
            return;
        }
        bdTypeRecyclerView.E(i2, i3);
    }

    public void p() {
        i iVar = this.p;
        if (iVar != null) {
            iVar.q(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.f56090f;
            if (bdTypeRecyclerView != null) {
                this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f56090f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f56089e;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f56089e;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(z ? 0 : 8);
        }
    }

    public final void s(int i2) {
        String string;
        if (i2 < 0) {
            return;
        }
        this.f56093i.f();
        if (i2 > 0) {
            string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
        }
        if (TextUtils.isEmpty(string) || !j.z()) {
            return;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
        smartBubbleAnimatedView.f15174e = string;
        smartBubbleAnimatedView.f15175f = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.g(this.f56085a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.f56088d;
        if (viewGroup != null) {
            viewGroup.removeView(this.j);
            this.f56088d.addView(this.j, layoutParams);
            this.j.g();
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f56090f;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    public final void u(d.a.n0.j0.l.d.b bVar) {
        List<ShortUserInfo> list;
        d.a.n0.j0.l.d.c cVar = bVar.f56080g;
        if (cVar != null && (list = cVar.f56082a) != null && list.size() > 0 && !TextUtils.isEmpty(bVar.f56080g.f56083b)) {
            this.k.f(bVar.f56080g);
            if (this.k.d().getParent() != null || this.l) {
                return;
            }
            this.l = true;
            this.f56090f.t(this.k.d(), 0);
            StatisticItem statisticItem = new StatisticItem("c13656");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f56087c);
            TiebaStatic.log(statisticItem);
            return;
        }
        this.l = false;
        this.f56090f.removeHeaderView(this.k.d());
    }

    public final void v(d.a.n0.j0.l.d.b bVar) {
        if (bVar == null || this.f56090f == null || this.f56085a == null || !bVar.f56081h) {
            return;
        }
        o1 o1Var = bVar.f56074a;
        if (!((o1Var == null || ListUtils.isEmpty(o1Var.B())) ? false : true)) {
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                this.f56090f.removeHeaderView(recommendForumLayout);
                return;
            }
            return;
        }
        if (this.n == null) {
            RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.f56085a.getPageContext());
            this.n = recommendForumLayout2;
            recommendForumLayout2.setShowMore(true);
            this.n.setSquareEntranceAtStart(true);
            this.n.setTabName(this.f56087c);
            this.n.setFrom(1);
        }
        this.n.setOnClickRightArrowListener(this.v);
        this.n.setOnRullOkCallbackr(this.w);
        this.n.setOnItemCoverListener(this.u);
        this.n.a(bVar.f56074a);
        this.f56090f.removeHeaderView(this.n);
        this.f56090f.t(this.n, 0);
        StatisticItem statisticItem = new StatisticItem("c13641");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", 2);
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f56087c);
        TiebaStatic.log(statisticItem);
    }
}
