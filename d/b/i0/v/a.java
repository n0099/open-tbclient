package d.b.i0.v;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CandidateSearchActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.BarVoteActivity;
import com.baidu.tieba.barselect.VoteAdapter;
import com.baidu.tieba.barselect.view.FloatMyRecordCard;
import com.baidu.tieba.barselect.view.SearchView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.barselect.view.VoteStatusCard;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.d0.h;
import d.b.h0.r.s.a;
import tbclient.ElectionInfo.NoticeContent;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class a {
    public SelectRuleView A;
    public SearchView B;
    public VoteAdapter C;
    public FloatMyRecordCard D;
    public TextView E;
    public int F;
    public PbListView G;
    public NoNetworkView H;
    public NoDataView I;
    public h J;
    public ViewGroup K;
    public View.OnClickListener L;
    public boolean N;

    /* renamed from: a  reason: collision with root package name */
    public int f61881a;

    /* renamed from: b  reason: collision with root package name */
    public BarVoteActivity f61882b;

    /* renamed from: g  reason: collision with root package name */
    public int f61887g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.v.b.f f61888h;
    public LinearLayoutManager i;
    public RelativeLayout j;
    public View k;
    public ViewGroup l;
    public TbImageView m;
    public View n;
    public View o;
    public NavigationBar p;
    public View q;
    public TextView r;
    public BdRecyclerView s;
    public VoteStatusCard t;
    public View u;
    public TextView v;
    public TextView w;
    public VoteCandidateCard x;
    public View y;
    public TextView z;

    /* renamed from: c  reason: collision with root package name */
    public int f61883c = 3;

    /* renamed from: d  reason: collision with root package name */
    public int f61884d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f61885e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f61886f = 0.0f;
    public View.OnClickListener M = new View$OnClickListenerC1631a();
    public VoteStatusCard.b O = new b();
    public RecyclerView.OnScrollListener P = new c();
    public BdListView.p Q = new d();

    /* renamed from: d.b.i0.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1631a implements View.OnClickListener {
        public View$OnClickListenerC1631a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                if (a.this.J != null) {
                    a.this.J.dettachView(a.this.k);
                    a.this.J = null;
                }
                a.this.f61882b.reload();
                if (a.this.s != null) {
                    a.this.s.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements VoteStatusCard.b {
        public b() {
        }

        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.b
        public void onRefresh() {
            if (a.this.f61882b != null) {
                a.this.f61882b.refresh();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            a.this.f61887g = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if ((a.this.f61887g != 1 && a.this.f61887g != 2) || a.this.l == null || a.this.p == null || a.this.p.getBarBgView() == null || a.this.p.getBackImageView() == null) {
                return;
            }
            a aVar = a.this;
            aVar.f61886f = Math.abs(aVar.l.getTop()) / a.this.f61881a;
            a.this.p.getBarBgView().setAlpha(a.this.f61886f);
            a.this.q.setAlpha(a.this.f61886f);
            if (a.this.f61886f > 0.5d) {
                if (a.this.f61885e == 0) {
                    SkinManager.setImageResource(a.this.p.getBackImageView(), R.drawable.icon_return_bg_s, a.this.f61883c);
                    SkinManager.setViewTextColor(a.this.r, R.color.CAM_X0105, 1, a.this.f61883c);
                    SkinManager.setViewTextColor(a.this.p.mCenterText, R.color.CAM_X0105, 1, a.this.f61883c);
                    a.this.f61885e = 1;
                }
                a.this.p.getBackImageView().setAlpha((a.this.f61886f * 2.0f) - 1.0f);
                a.this.r.setAlpha((a.this.f61886f * 2.0f) - 1.0f);
                a.this.p.mCenterText.setAlpha((a.this.f61886f * 2.0f) - 1.0f);
            } else if (a.this.f61886f <= 0.5d) {
                if (a.this.f61885e == 1) {
                    SkinManager.setImageResource(a.this.p.getBackImageView(), R.drawable.icon_return_bg, a.this.f61883c);
                    SkinManager.setViewTextColor(a.this.r, R.color.CAM_X0101, 1, a.this.f61883c);
                    SkinManager.setViewTextColor(a.this.p.mCenterText, R.color.CAM_X0101, 1, a.this.f61883c);
                    a.this.f61885e = 0;
                }
                a.this.p.getBackImageView().setAlpha(1.0f - (a.this.f61886f * 2.0f));
                a.this.r.setAlpha(1.0f - (a.this.f61886f * 2.0f));
                a.this.p.mCenterText.setAlpha(1.0f - (a.this.f61886f * 2.0f));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.s != null) {
                a.this.s.stopScroll();
            }
            if (a.this.G == null || a.this.f61882b == null) {
                return;
            }
            if (j.z()) {
                if (a.this.f61884d == d.b.i0.v.e.d.f61960c) {
                    a.this.G.J(l.g(a.this.f61882b, R.dimen.tbds152));
                }
                a.this.s.setNextPage(a.this.G);
                a.this.G.z(null);
                if (a.this.N) {
                    a.this.G.L();
                    a.this.f61882b.loadmore();
                    return;
                }
                a.this.G.A(a.this.f61882b.getResources().getString(R.string.list_has_no_more));
                a.this.G.f();
                return;
            }
            a.this.s.setNextPage(null);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d.b.i0.v.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1632a implements a.e {
            public C1632a(e eVar) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(a.this.f61882b);
            View inflate = LayoutInflater.from(a.this.f61882b.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
            textView.setText(a.this.f61882b.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + a.this.f61882b.getResources().getString(R.string.vote_ueg_tip_detail_2));
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            aVar.setContentView(inflate);
            aVar.setNegativeButton(R.string.know, new C1632a(this));
            aVar.create(a.this.f61882b.getPageContext());
            ViewGroup realView = aVar.getRealView();
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int i = R.color.CAM_X0201;
            SkinManager.setBackgroundShapeDrawable(realView, g2, i, i);
            aVar.show();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BarVoteActivity barVoteActivity = a.this.f61882b;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(barVoteActivity, a.this.f61882b.fid + "")));
        }
    }

    public a(BarVoteActivity barVoteActivity) {
        this.f61882b = barVoteActivity;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(barVoteActivity.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.j = relativeLayout;
        this.f61882b.addContentView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        BarVoteActivity barVoteActivity2 = this.f61882b;
        barVoteActivity2.showLoadingView(this.j, false, l.g(barVoteActivity2, R.dimen.ds400));
        this.k = this.j.findViewById(R.id.list_container);
        this.K = (ViewGroup) this.j.findViewById(R.id.no_data_container);
        this.o = this.j.findViewById(R.id.nav_bar_container);
        View findViewById = this.j.findViewById(R.id.nav_bar_shadow);
        this.q = findViewById;
        findViewById.setAlpha(0.0f);
        NavigationBar navigationBar = (NavigationBar) this.j.findViewById(R.id.vote_navigation_bar);
        this.p = navigationBar;
        navigationBar.setCenterTextTitle(this.f61882b.getResources().getString(R.string.bar_manager_recruit));
        if (this.p.getBarBgView() != null) {
            this.p.getBarBgView().setAlpha(0.0f);
        }
        this.f61881a = l.g(this.f61882b, R.dimen.tbds402);
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView textView = (TextView) this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f61882b).findViewById(R.id.right_textview);
        this.r = textView;
        textView.setText(R.string.bar_election_rule);
        this.r.setOnClickListener(this.f61882b);
        this.s = (BdRecyclerView) this.j.findViewById(R.id.vote_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f61882b);
        this.i = linearLayoutManager;
        this.s.setLayoutManager(linearLayoutManager);
        VoteAdapter voteAdapter = new VoteAdapter(barVoteActivity.getPageContext());
        this.C = voteAdapter;
        this.s.setAdapter(voteAdapter);
        this.l = (ViewGroup) LayoutInflater.from(this.f61882b).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.m = (TbImageView) this.l.findViewById(R.id.head_main_iv);
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.k(this.f61882b) * 884) / 1076));
        this.s.s(this.l);
        this.s.addOnScrollListener(this.P);
        this.s.setOnSrollToBottomListener(this.Q);
        this.F = this.f61882b.getResources().getDimensionPixelSize(R.dimen.tbds134);
        View view = new View(this.f61882b);
        this.n = view;
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.F));
        this.n.setVisibility(4);
        this.s.r(this.n);
        this.t = (VoteStatusCard) this.l.findViewById(R.id.vote_status_card);
        View findViewById2 = this.l.findViewById(R.id.vote_ueg_tip_container);
        this.u = findViewById2;
        findViewById2.setOnClickListener(new e());
        this.v = (TextView) this.l.findViewById(R.id.vote_ueg_tip_tv);
        this.w = (TextView) this.l.findViewById(R.id.vote_ueg_tip_img);
        this.t.setOnRefreshListener(this.O);
        this.y = this.l.findViewById(R.id.bar_select_rule_bg);
        this.z = (TextView) this.l.findViewById(R.id.bar_select_rule_main_title);
        SelectRuleView selectRuleView = (SelectRuleView) this.l.findViewById(R.id.bar_select_rule_container);
        this.A = selectRuleView;
        selectRuleView.setType(1);
        this.x = (VoteCandidateCard) this.l.findViewById(R.id.vote_for_mine);
        SearchView searchView = (SearchView) this.l.findViewById(R.id.vote_search_view);
        this.B = searchView;
        searchView.a(new f());
        this.D = (FloatMyRecordCard) this.j.findViewById(R.id.float_my_record_card);
        this.E = (TextView) this.l.findViewById(R.id.vote_tip);
        PbListView pbListView = new PbListView(this.f61882b);
        this.G = pbListView;
        pbListView.b();
        this.G.o(R.color.CAM_X0204);
        this.G.r(l.g(this.f61882b, R.dimen.tbds182));
        this.G.v();
        this.G.E(R.dimen.tbfontsize33);
        this.G.C(SkinManager.getColor(R.color.CAM_X0107));
        this.G.y(R.color.CAM_X0110);
        this.G.q();
        this.H = (NoNetworkView) this.j.findViewById(R.id.no_network_view);
    }

    public void A(int i, boolean z) {
        if (z || this.f61883c != i) {
            this.f61883c = i;
            h hVar = this.J;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201, i);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i);
            NavigationBar navigationBar = this.p;
            if (navigationBar != null) {
                SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207, i);
                float f2 = this.f61886f;
                if (f2 > 0.5d) {
                    SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
                    SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i);
                } else if (f2 <= 0.5d) {
                    d.b.i0.v.b.f fVar = this.f61888h;
                    if (fVar != null && fVar.a() != null && this.f61888h.a().g() <= 2 && this.f61888h.a().g() >= 1) {
                        SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg, i);
                        SkinManager.setViewTextColor(this.r, R.color.CAM_X0101, 1, i);
                        SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0101, 1, i);
                    } else {
                        SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
                        SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i);
                    }
                }
                SkinManager.setBackgroundResource(this.q, R.drawable.top_view_shadow, i);
            }
            SkinManager.setImageResource(this.m, R.drawable.pic_bg_recruit, i);
            this.t.f(i);
            this.x.c(i);
            this.B.d(i);
            SkinManager.setBackgroundResource(this.y, R.drawable.bar_select_bg_shadow_and_radius, i);
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
            SelectRuleView selectRuleView = this.A;
            if (selectRuleView != null) {
                selectRuleView.d(i);
            }
            SkinManager.setViewTextColor(this.E, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0108, 1, i);
            SkinManager.setBackgroundResource(this.w, R.drawable.icon_common_explain12_gray66, i);
            this.D.d(i);
            PbListView pbListView = this.G;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(i, R.color.CAM_X0107));
                this.G.d(i);
            }
            this.H.c(this.f61882b.getPageContext(), i);
            VoteAdapter voteAdapter = this.C;
            if (voteAdapter != null) {
                voteAdapter.notifyDataSetChanged();
            }
        }
    }

    public void B() {
        if (this.f61884d == d.b.i0.v.e.d.f61960c) {
            this.G.J(l.g(this.f61882b, R.dimen.tbds152));
        }
        this.G.z(this.f61882b);
        this.s.setNextPage(this.G);
        if (this.N) {
            this.G.K();
            return;
        }
        this.G.A(this.f61882b.getResources().getString(R.string.list_has_no_more));
        this.G.f();
    }

    public void C(d.b.i0.v.b.f fVar) {
        d.b.i0.v.b.e a2;
        if (fVar == null) {
            return;
        }
        this.N = fVar.d();
        if (fVar.a() != null && (a2 = fVar.a()) != null) {
            int g2 = a2.g();
            this.f61884d = g2;
            if (g2 == d.b.i0.v.e.d.f61960c) {
                this.B.setVisibility(8);
                this.E.setVisibility(8);
                this.x.setVisibility(8);
            }
            NoticeContent e2 = a2.e();
            if (e2 != null && !TextUtils.isEmpty(e2.public_notice)) {
                G(e2.public_notice + "占");
            } else {
                G(this.f61882b.getResources().getString(R.string.vote_ueg_tip) + "占");
            }
        }
        this.t.setData(fVar);
        VoteAdapter voteAdapter = this.C;
        if (voteAdapter != null) {
            this.f61888h = fVar;
            voteAdapter.p(fVar);
        }
        int i = this.f61884d;
        if (i == d.b.i0.v.e.d.f61960c) {
            this.D.setVisibility(0);
            this.D.setData(fVar);
            this.u.setVisibility(0);
            this.y.setVisibility(8);
        } else if (i == d.b.i0.v.e.d.f61959b) {
            this.x.setData(VoteCandidateCard.E, fVar);
            this.D.setVisibility(8);
            this.u.setVisibility(8);
            this.B.setRank(fVar.a().b());
            if (fVar.e() != null) {
                ManagerElection e3 = fVar.e();
                if (ListUtils.isEmpty(e3.vote_condition_pic) && ListUtils.isEmpty(e3.vote_condition_title) && ListUtils.isEmpty(e3.vote_condition)) {
                    this.y.setVisibility(8);
                } else {
                    this.y.setVisibility(0);
                    this.A.setData(e3.vote_condition_pic, e3.vote_condition_title, e3.vote_condition);
                }
            } else {
                this.y.setVisibility(8);
            }
        } else {
            this.D.setVisibility(8);
            this.u.setVisibility(8);
            this.y.setVisibility(8);
        }
        B();
        A(TbadkCoreApplication.getInst().getSkinType(), true);
    }

    public void D(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void E() {
        BdRecyclerView bdRecyclerView = this.s;
        if (bdRecyclerView != null) {
            bdRecyclerView.setVisibility(8);
        }
        this.f61882b.hideLoadingView(w());
        if (this.I != null) {
            x();
        }
        if (this.J == null) {
            this.J = new h(this.f61882b, this.M);
        }
        this.J.j(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds340));
        this.J.l(TbadkCoreApplication.getInst().getString(R.string.neterror));
        this.J.attachView(this.k, true);
        this.J.o();
        this.J.onChangeSkinType();
    }

    public void F(String str) {
        h hVar = this.J;
        if (hVar != null) {
            hVar.dettachView(this.k);
            this.J = null;
        }
        this.f61882b.hideLoadingView(w());
        if (this.I == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f61882b, this.K, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.e.c(str), null);
            this.I = a2;
            a2.setOnClickListener(this.L);
        }
        this.I.setTextOption(NoDataViewFactory.e.c(str));
        this.I.f(this.f61882b.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.I.setVisibility(0);
    }

    public final void G(String str) {
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_common_explain12_gray66);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
        d.b.b.j.b bVar = new d.b.b.j.b(drawable, 0);
        bVar.b(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
        this.v.setText(spannableString);
    }

    public BdRecyclerView u() {
        return this.s;
    }

    public PbListView v() {
        return this.G;
    }

    public View w() {
        return this.j;
    }

    public void x() {
        NoDataView noDataView = this.I;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public void y() {
        VoteStatusCard voteStatusCard = this.t;
        if (voteStatusCard != null) {
            voteStatusCard.e();
        }
    }

    public void z(int i) {
        A(i, false);
    }
}
