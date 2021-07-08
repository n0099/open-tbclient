package d.a.p0.x;

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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.o0.d0.h;
import d.a.o0.r.s.a;
import tbclient.ElectionInfo.NoticeContent;
import tbclient.ManagerElection;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public View.OnClickListener M;
    public boolean N;
    public VoteStatusCard.b O;
    public RecyclerView.OnScrollListener P;
    public BdListView.p Q;

    /* renamed from: a  reason: collision with root package name */
    public int f66093a;

    /* renamed from: b  reason: collision with root package name */
    public BarVoteActivity f66094b;

    /* renamed from: c  reason: collision with root package name */
    public int f66095c;

    /* renamed from: d  reason: collision with root package name */
    public int f66096d;

    /* renamed from: e  reason: collision with root package name */
    public int f66097e;

    /* renamed from: f  reason: collision with root package name */
    public float f66098f;

    /* renamed from: g  reason: collision with root package name */
    public int f66099g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.x.b.f f66100h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f66101i;
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

    /* renamed from: d.a.p0.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1839a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66102e;

        public View$OnClickListenerC1839a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66102e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                if (this.f66102e.J != null) {
                    this.f66102e.J.dettachView(this.f66102e.k);
                    this.f66102e.J = null;
                }
                this.f66102e.f66094b.reload();
                if (this.f66102e.s != null) {
                    this.f66102e.s.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements VoteStatusCard.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66103a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66103a = aVar;
        }

        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.b
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f66103a.f66094b == null) {
                return;
            }
            this.f66103a.f66094b.refresh();
        }
    }

    /* loaded from: classes8.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66104a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66104a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                this.f66104a.f66099g = i2;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if ((this.f66104a.f66099g != 1 && this.f66104a.f66099g != 2) || this.f66104a.l == null || this.f66104a.p == null || this.f66104a.p.getBarBgView() == null || this.f66104a.p.getBackImageView() == null) {
                    return;
                }
                a aVar = this.f66104a;
                aVar.f66098f = Math.abs(aVar.l.getTop()) / this.f66104a.f66093a;
                this.f66104a.p.getBarBgView().setAlpha(this.f66104a.f66098f);
                this.f66104a.q.setAlpha(this.f66104a.f66098f);
                if (this.f66104a.f66098f > 0.5d) {
                    if (this.f66104a.f66097e == 0) {
                        SkinManager.setImageResource(this.f66104a.p.getBackImageView(), R.drawable.icon_return_bg_s, this.f66104a.f66095c);
                        SkinManager.setViewTextColor(this.f66104a.r, R.color.CAM_X0105, 1, this.f66104a.f66095c);
                        SkinManager.setViewTextColor(this.f66104a.p.mCenterText, R.color.CAM_X0105, 1, this.f66104a.f66095c);
                        this.f66104a.f66097e = 1;
                    }
                    this.f66104a.p.getBackImageView().setAlpha((this.f66104a.f66098f * 2.0f) - 1.0f);
                    this.f66104a.r.setAlpha((this.f66104a.f66098f * 2.0f) - 1.0f);
                    this.f66104a.p.mCenterText.setAlpha((this.f66104a.f66098f * 2.0f) - 1.0f);
                } else if (this.f66104a.f66098f <= 0.5d) {
                    if (this.f66104a.f66097e == 1) {
                        SkinManager.setImageResource(this.f66104a.p.getBackImageView(), R.drawable.icon_return_bg, this.f66104a.f66095c);
                        SkinManager.setViewTextColor(this.f66104a.r, R.color.CAM_X0101, 1, this.f66104a.f66095c);
                        SkinManager.setViewTextColor(this.f66104a.p.mCenterText, R.color.CAM_X0101, 1, this.f66104a.f66095c);
                        this.f66104a.f66097e = 0;
                    }
                    this.f66104a.p.getBackImageView().setAlpha(1.0f - (this.f66104a.f66098f * 2.0f));
                    this.f66104a.r.setAlpha(1.0f - (this.f66104a.f66098f * 2.0f));
                    this.f66104a.p.mCenterText.setAlpha(1.0f - (this.f66104a.f66098f * 2.0f));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66105e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66105e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f66105e.s != null) {
                    this.f66105e.s.stopScroll();
                }
                if (this.f66105e.G == null || this.f66105e.f66094b == null) {
                    return;
                }
                if (j.z()) {
                    if (this.f66105e.f66096d == d.a.p0.x.e.c.f66176c) {
                        this.f66105e.G.J(l.g(this.f66105e.f66094b, R.dimen.tbds152));
                    }
                    this.f66105e.s.setNextPage(this.f66105e.G);
                    this.f66105e.G.z(null);
                    if (this.f66105e.N) {
                        this.f66105e.G.L();
                        this.f66105e.f66094b.loadmore();
                        return;
                    }
                    this.f66105e.G.A(this.f66105e.f66094b.getResources().getString(R.string.list_has_no_more));
                    this.f66105e.G.f();
                    return;
                }
                this.f66105e.s.setNextPage(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66106e;

        /* renamed from: d.a.p0.x.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1840a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1840a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66106e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f66106e.f66094b);
                View inflate = LayoutInflater.from(this.f66106e.f66094b.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.bdalert_content);
                textView.setText(this.f66106e.f66094b.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + this.f66106e.f66094b.getResources().getString(R.string.vote_ueg_tip_detail_2));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                aVar.setContentView(inflate);
                aVar.setNegativeButton(R.string.know, new C1840a(this));
                aVar.create(this.f66106e.f66094b.getPageContext());
                ViewGroup realView = aVar.getRealView();
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
                int i2 = R.color.CAM_X0201;
                SkinManager.setBackgroundShapeDrawable(realView, g2, i2, i2);
                aVar.show();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66107e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66107e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BarVoteActivity barVoteActivity = this.f66107e.f66094b;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(barVoteActivity, this.f66107e.f66094b.fid + "")));
            }
        }
    }

    public a(BarVoteActivity barVoteActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {barVoteActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66095c = 3;
        this.f66096d = -1;
        this.f66097e = 0;
        this.f66098f = 0.0f;
        this.M = new View$OnClickListenerC1839a(this);
        this.O = new b(this);
        this.P = new c(this);
        this.Q = new d(this);
        this.f66094b = barVoteActivity;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(barVoteActivity.getPageContext().getPageActivity()).inflate(R.layout.bar_vote_activity, (ViewGroup) null);
        this.j = relativeLayout;
        this.f66094b.addContentView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        BarVoteActivity barVoteActivity2 = this.f66094b;
        barVoteActivity2.showLoadingView(this.j, false, l.g(barVoteActivity2, R.dimen.ds400));
        this.k = this.j.findViewById(R.id.list_container);
        this.K = (ViewGroup) this.j.findViewById(R.id.no_data_container);
        this.o = this.j.findViewById(R.id.nav_bar_container);
        View findViewById = this.j.findViewById(R.id.nav_bar_shadow);
        this.q = findViewById;
        findViewById.setAlpha(0.0f);
        NavigationBar navigationBar = (NavigationBar) this.j.findViewById(R.id.vote_navigation_bar);
        this.p = navigationBar;
        navigationBar.setCenterTextTitle(this.f66094b.getResources().getString(R.string.bar_manager_recruit));
        if (this.p.getBarBgView() != null) {
            this.p.getBarBgView().setAlpha(0.0f);
        }
        this.f66093a = l.g(this.f66094b, R.dimen.tbds402);
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView textView = (TextView) this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f66094b).findViewById(R.id.right_textview);
        this.r = textView;
        textView.setText(R.string.bar_election_rule);
        this.r.setOnClickListener(this.f66094b);
        this.s = (BdRecyclerView) this.j.findViewById(R.id.vote_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f66094b);
        this.f66101i = linearLayoutManager;
        this.s.setLayoutManager(linearLayoutManager);
        VoteAdapter voteAdapter = new VoteAdapter(barVoteActivity.getPageContext());
        this.C = voteAdapter;
        this.s.setAdapter(voteAdapter);
        this.l = (ViewGroup) LayoutInflater.from(this.f66094b).inflate(R.layout.vote_header_view, (ViewGroup) null, false);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.m = (TbImageView) this.l.findViewById(R.id.head_main_iv);
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, (l.k(this.f66094b) * 884) / 1076));
        this.s.s(this.l);
        this.s.addOnScrollListener(this.P);
        this.s.setOnSrollToBottomListener(this.Q);
        this.F = this.f66094b.getResources().getDimensionPixelSize(R.dimen.tbds134);
        View view = new View(this.f66094b);
        this.n = view;
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.F));
        this.n.setVisibility(4);
        this.s.r(this.n);
        this.t = (VoteStatusCard) this.l.findViewById(R.id.vote_status_card);
        View findViewById2 = this.l.findViewById(R.id.vote_ueg_tip_container);
        this.u = findViewById2;
        findViewById2.setOnClickListener(new e(this));
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
        searchView.a(new f(this));
        this.D = (FloatMyRecordCard) this.j.findViewById(R.id.float_my_record_card);
        this.E = (TextView) this.l.findViewById(R.id.vote_tip);
        PbListView pbListView = new PbListView(this.f66094b);
        this.G = pbListView;
        pbListView.b();
        this.G.o(R.color.CAM_X0204);
        this.G.r(l.g(this.f66094b, R.dimen.tbds182));
        this.G.v();
        this.G.E(R.dimen.tbfontsize33);
        this.G.C(SkinManager.getColor(R.color.CAM_X0107));
        this.G.y(R.color.CAM_X0110);
        this.G.q();
        this.H = (NoNetworkView) this.j.findViewById(R.id.no_network_view);
    }

    public void A(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z || this.f66095c != i2) {
                this.f66095c = i2;
                h hVar = this.J;
                if (hVar != null) {
                    hVar.onChangeSkinType();
                }
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201, i2);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i2);
                NavigationBar navigationBar = this.p;
                if (navigationBar != null) {
                    SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207, i2);
                    float f2 = this.f66098f;
                    if (f2 > 0.5d) {
                        SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i2);
                        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i2);
                        SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i2);
                    } else if (f2 <= 0.5d) {
                        d.a.p0.x.b.f fVar = this.f66100h;
                        if (fVar != null && fVar.a() != null && this.f66100h.a().g() <= 2 && this.f66100h.a().g() >= 1) {
                            SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg, i2);
                            SkinManager.setViewTextColor(this.r, R.color.CAM_X0101, 1, i2);
                            SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0101, 1, i2);
                        } else {
                            SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i2);
                            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i2);
                            SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i2);
                        }
                    }
                    SkinManager.setBackgroundResource(this.q, R.drawable.top_view_shadow, i2);
                }
                SkinManager.setImageResource(this.m, R.drawable.pic_bg_recruit, i2);
                this.t.f(i2);
                this.x.c(i2);
                this.B.d(i2);
                SkinManager.setBackgroundResource(this.y, R.drawable.bar_select_bg_shadow_and_radius, i2);
                SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
                SelectRuleView selectRuleView = this.A;
                if (selectRuleView != null) {
                    selectRuleView.d(i2);
                }
                SkinManager.setViewTextColor(this.E, R.color.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0108, 1, i2);
                SkinManager.setBackgroundResource(this.w, R.drawable.icon_common_explain12_gray66, i2);
                this.D.d(i2);
                PbListView pbListView = this.G;
                if (pbListView != null) {
                    pbListView.C(SkinManager.getColor(i2, R.color.CAM_X0107));
                    this.G.d(i2);
                }
                this.H.c(this.f66094b.getPageContext(), i2);
                VoteAdapter voteAdapter = this.C;
                if (voteAdapter != null) {
                    voteAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f66096d == d.a.p0.x.e.c.f66176c) {
                this.G.J(l.g(this.f66094b, R.dimen.tbds152));
            }
            this.G.z(this.f66094b);
            this.s.setNextPage(this.G);
            if (this.N) {
                this.G.K();
                return;
            }
            this.G.A(this.f66094b.getResources().getString(R.string.list_has_no_more));
            this.G.f();
        }
    }

    public void C(d.a.p0.x.b.f fVar) {
        d.a.p0.x.b.e a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || fVar == null) {
            return;
        }
        this.N = fVar.d();
        if (fVar.a() != null && (a2 = fVar.a()) != null) {
            int g2 = a2.g();
            this.f66096d = g2;
            if (g2 == d.a.p0.x.e.c.f66176c) {
                this.B.setVisibility(8);
                this.E.setVisibility(8);
                this.x.setVisibility(8);
            }
            NoticeContent e2 = a2.e();
            if (e2 != null && !TextUtils.isEmpty(e2.public_notice)) {
                G(e2.public_notice + "占");
            } else {
                G(this.f66094b.getResources().getString(R.string.vote_ueg_tip) + "占");
            }
        }
        this.t.setData(fVar);
        VoteAdapter voteAdapter = this.C;
        if (voteAdapter != null) {
            this.f66100h = fVar;
            voteAdapter.g(fVar);
        }
        int i2 = this.f66096d;
        if (i2 == d.a.p0.x.e.c.f66176c) {
            this.D.setVisibility(0);
            this.D.setData(fVar);
            this.u.setVisibility(0);
            this.y.setVisibility(8);
        } else if (i2 == d.a.p0.x.e.c.f66175b) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.L = onClickListener;
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdRecyclerView bdRecyclerView = this.s;
            if (bdRecyclerView != null) {
                bdRecyclerView.setVisibility(8);
            }
            this.f66094b.hideLoadingView(w());
            if (this.I != null) {
                x();
            }
            if (this.J == null) {
                this.J = new h(this.f66094b, this.M);
            }
            this.J.j(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds340));
            this.J.l(TbadkCoreApplication.getInst().getString(R.string.neterror));
            this.J.attachView(this.k, true);
            this.J.o();
            this.J.onChangeSkinType();
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            h hVar = this.J;
            if (hVar != null) {
                hVar.dettachView(this.k);
                this.J = null;
            }
            this.f66094b.hideLoadingView(w());
            if (this.I == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f66094b, this.K, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.e.c(str), null);
                this.I = a2;
                a2.setOnClickListener(this.L);
            }
            this.I.setTextOption(NoDataViewFactory.e.c(str));
            this.I.f(this.f66094b.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.I.setVisibility(0);
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_common_explain12_gray66);
            drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
            d.a.c.k.b bVar = new d.a.c.k.b(drawable, 0);
            bVar.b(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
            spannableString.setSpan(bVar, str.length() - 1, str.length(), 17);
            this.v.setText(spannableString);
        }
    }

    public BdRecyclerView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : (BdRecyclerView) invokeV.objValue;
    }

    public PbListView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.G : (PbListView) invokeV.objValue;
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void x() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (noDataView = this.I) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public void y() {
        VoteStatusCard voteStatusCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (voteStatusCard = this.t) == null) {
            return;
        }
        voteStatusCard.e();
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            A(i2, false);
        }
    }
}
