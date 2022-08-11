package com.repackage;

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
import tbclient.ManagerElection;
/* loaded from: classes5.dex */
public class ay5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FloatMyRecordCard A;
    public TextView B;
    public int C;
    public PbListView D;
    public NoNetworkView E;
    public NoDataView F;
    public h65 G;
    public ViewGroup H;
    public View.OnClickListener I;
    public View.OnClickListener J;
    public boolean K;
    public VoteStatusCard.c L;
    public RecyclerView.OnScrollListener M;
    public BdListView.p N;
    public int a;
    public BarVoteActivity b;
    public int c;
    public int d;
    public int e;
    public float f;
    public int g;
    public gy5 h;
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
    public VoteCandidateCard u;
    public View v;
    public TextView w;
    public SelectRuleView x;
    public SearchView y;
    public VoteAdapter z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay5 a;

        public a(ay5 ay5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && oi.A()) {
                if (this.a.G != null) {
                    this.a.G.dettachView(this.a.k);
                    this.a.G = null;
                }
                this.a.b.C1();
                if (this.a.s != null) {
                    this.a.s.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements VoteStatusCard.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay5 a;

        public b(ay5 ay5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay5Var;
        }

        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.c
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.refresh();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay5 a;

        public c(ay5 ay5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay5Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                this.a.g = i;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if ((this.a.g != 1 && this.a.g != 2) || this.a.l == null || this.a.p == null || this.a.p.getBarBgView() == null || this.a.p.getBackImageView() == null) {
                    return;
                }
                ay5 ay5Var = this.a;
                ay5Var.f = Math.abs(ay5Var.l.getTop()) / this.a.a;
                this.a.p.getBarBgView().setAlpha(this.a.f);
                this.a.q.setAlpha(this.a.f);
                if (this.a.f > 0.5d) {
                    if (this.a.e == 0) {
                        SkinManager.setImageResource(this.a.p.getBackImageView(), R.drawable.icon_return_bg_s, this.a.c);
                        SkinManager.setViewTextColor(this.a.r, R.color.CAM_X0105, 1, this.a.c);
                        SkinManager.setViewTextColor(this.a.p.mCenterText, R.color.CAM_X0105, 1, this.a.c);
                        this.a.e = 1;
                    }
                    this.a.p.getBackImageView().setAlpha((this.a.f * 2.0f) - 1.0f);
                    this.a.r.setAlpha((this.a.f * 2.0f) - 1.0f);
                    this.a.p.mCenterText.setAlpha((this.a.f * 2.0f) - 1.0f);
                } else if (this.a.f <= 0.5d) {
                    if (this.a.e == 1) {
                        SkinManager.setImageResource(this.a.p.getBackImageView(), R.drawable.icon_return_bg, this.a.c);
                        SkinManager.setViewTextColor(this.a.r, R.color.CAM_X0101, 1, this.a.c);
                        SkinManager.setViewTextColor(this.a.p.mCenterText, R.color.CAM_X0101, 1, this.a.c);
                        this.a.e = 0;
                    }
                    this.a.p.getBackImageView().setAlpha(1.0f - (this.a.f * 2.0f));
                    this.a.r.setAlpha(1.0f - (this.a.f * 2.0f));
                    this.a.p.mCenterText.setAlpha(1.0f - (this.a.f * 2.0f));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay5 a;

        public d(ay5 ay5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.s != null) {
                    this.a.s.stopScroll();
                }
                if (this.a.D == null || this.a.b == null) {
                    return;
                }
                if (oi.z()) {
                    if (this.a.d == py5.c) {
                        this.a.D.L(qi.f(this.a.b, R.dimen.tbds152));
                    }
                    this.a.s.setNextPage(this.a.D);
                    this.a.D.B(null);
                    if (this.a.K) {
                        this.a.D.N();
                        this.a.b.B1();
                        return;
                    }
                    this.a.D.C(this.a.b.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
                    this.a.D.f();
                    return;
                }
                this.a.s.setNextPage(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay5 a;

        public e(ay5 ay5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BarVoteActivity barVoteActivity = this.a.b;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(barVoteActivity, this.a.b.d + "")));
            }
        }
    }

    public ay5(BarVoteActivity barVoteActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {barVoteActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 3;
        this.d = -1;
        this.e = 0;
        this.f = 0.0f;
        this.J = new a(this);
        this.L = new b(this);
        this.M = new c(this);
        this.N = new d(this);
        this.b = barVoteActivity;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(barVoteActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d013a, (ViewGroup) null);
        this.j = relativeLayout;
        this.b.addContentView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        BarVoteActivity barVoteActivity2 = this.b;
        barVoteActivity2.showLoadingView(this.j, false, qi.f(barVoteActivity2, R.dimen.obfuscated_res_0x7f0702bb));
        this.k = this.j.findViewById(R.id.obfuscated_res_0x7f09130c);
        this.H = (ViewGroup) this.j.findViewById(R.id.obfuscated_res_0x7f091693);
        this.o = this.j.findViewById(R.id.obfuscated_res_0x7f091600);
        View findViewById = this.j.findViewById(R.id.obfuscated_res_0x7f091601);
        this.q = findViewById;
        findViewById.setAlpha(0.0f);
        NavigationBar navigationBar = (NavigationBar) this.j.findViewById(R.id.obfuscated_res_0x7f0925cc);
        this.p = navigationBar;
        navigationBar.setCenterTextTitle(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f02e6));
        if (this.p.getBarBgView() != null) {
            this.p.getBarBgView().setAlpha(0.0f);
        }
        this.a = qi.f(this.b, R.dimen.tbds402);
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView textView = (TextView) this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0612, this.b).findViewById(R.id.obfuscated_res_0x7f091bf8);
        this.r = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f02dd);
        this.r.setOnClickListener(this.b);
        this.s = (BdRecyclerView) this.j.findViewById(R.id.obfuscated_res_0x7f0925ca);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b);
        this.i = linearLayoutManager;
        this.s.setLayoutManager(linearLayoutManager);
        VoteAdapter voteAdapter = new VoteAdapter(barVoteActivity.getPageContext());
        this.z = voteAdapter;
        this.s.setAdapter(voteAdapter);
        this.l = (ViewGroup) LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d08ea, (ViewGroup) null, false);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.m = (TbImageView) this.l.findViewById(R.id.obfuscated_res_0x7f090d17);
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, (qi.k(this.b) * 884) / 1076));
        this.s.s(this.l);
        this.s.addOnScrollListener(this.M);
        this.s.setOnSrollToBottomListener(this.N);
        this.C = this.b.getResources().getDimensionPixelSize(R.dimen.tbds134);
        View view2 = new View(this.b);
        this.n = view2;
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, this.C));
        this.n.setVisibility(4);
        this.s.r(this.n);
        VoteStatusCard voteStatusCard = (VoteStatusCard) this.l.findViewById(R.id.obfuscated_res_0x7f0925d0);
        this.t = voteStatusCard;
        voteStatusCard.setOnRefreshListener(this.L);
        this.v = this.l.findViewById(R.id.obfuscated_res_0x7f09033b);
        this.w = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f09033f);
        SelectRuleView selectRuleView = (SelectRuleView) this.l.findViewById(R.id.obfuscated_res_0x7f09033c);
        this.x = selectRuleView;
        selectRuleView.setType(1);
        this.u = (VoteCandidateCard) this.l.findViewById(R.id.obfuscated_res_0x7f0925c0);
        SearchView searchView = (SearchView) this.l.findViewById(R.id.obfuscated_res_0x7f0925ce);
        this.y = searchView;
        searchView.a(new e(this));
        this.A = (FloatMyRecordCard) this.j.findViewById(R.id.obfuscated_res_0x7f0909e4);
        this.B = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f0925d8);
        PbListView pbListView = new PbListView(this.b);
        this.D = pbListView;
        pbListView.b();
        this.D.p(R.color.CAM_X0204);
        this.D.t(qi.f(this.b, R.dimen.tbds182));
        this.D.x();
        this.D.G(R.dimen.tbfontsize33);
        this.D.E(SkinManager.getColor(R.color.CAM_X0107));
        this.D.A(R.color.CAM_X0110);
        this.D.s();
        this.E = (NoNetworkView) this.j.findViewById(R.id.obfuscated_res_0x7f0916a5);
    }

    public void A(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z || this.c != i) {
                this.c = i;
                h65 h65Var = this.G;
                if (h65Var != null) {
                    h65Var.onChangeSkinType();
                }
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201, i);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i);
                NavigationBar navigationBar = this.p;
                if (navigationBar != null) {
                    SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207, i);
                    float f = this.f;
                    if (f > 0.5d) {
                        SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
                        SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i);
                    } else if (f <= 0.5d) {
                        gy5 gy5Var = this.h;
                        if (gy5Var != null && gy5Var.a() != null && this.h.a().h() <= 2 && this.h.a().h() >= 1) {
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
                SkinManager.setImageResource(this.m, R.drawable.pic_recruit_firstfigure, i);
                this.t.f(i);
                this.u.c(i);
                this.y.d(i);
                SkinManager.setBackgroundResource(this.v, R.drawable.bar_select_bg_shadow_and_radius, i);
                SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
                SelectRuleView selectRuleView = this.x;
                if (selectRuleView != null) {
                    selectRuleView.d(i);
                }
                SkinManager.setViewTextColor(this.B, R.color.CAM_X0109, 1, i);
                this.A.d(i);
                PbListView pbListView = this.D;
                if (pbListView != null) {
                    pbListView.E(SkinManager.getColor(i, (int) R.color.CAM_X0107));
                    this.D.d(i);
                }
                this.E.d(this.b.getPageContext(), i);
                VoteAdapter voteAdapter = this.z;
                if (voteAdapter != null) {
                    voteAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.d == py5.c) {
                this.D.L(qi.f(this.b, R.dimen.tbds152));
            }
            this.D.B(this.b);
            this.s.setNextPage(this.D);
            if (this.K) {
                this.D.M();
                return;
            }
            this.D.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
            this.D.f();
        }
    }

    public void C(gy5 gy5Var) {
        fy5 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gy5Var) == null) || gy5Var == null) {
            return;
        }
        this.K = gy5Var.d();
        if (gy5Var.a() != null && (a2 = gy5Var.a()) != null) {
            int h = a2.h();
            this.d = h;
            if (h == py5.c) {
                this.y.setVisibility(8);
                this.B.setVisibility(8);
                this.u.setVisibility(8);
            }
        }
        this.t.setData(gy5Var);
        VoteAdapter voteAdapter = this.z;
        if (voteAdapter != null) {
            this.h = gy5Var;
            voteAdapter.g(gy5Var);
        }
        int i = this.d;
        if (i == py5.c) {
            this.A.setVisibility(0);
            this.A.setData(gy5Var);
            this.v.setVisibility(8);
        } else if (i == py5.b) {
            this.u.setData(VoteCandidateCard.A, gy5Var);
            this.A.setVisibility(8);
            this.y.setRank(gy5Var.a().c());
            if (gy5Var.e() != null) {
                ManagerElection e2 = gy5Var.e();
                if (ListUtils.isEmpty(e2.vote_condition_pic) && ListUtils.isEmpty(e2.vote_condition_title) && ListUtils.isEmpty(e2.vote_condition)) {
                    this.v.setVisibility(8);
                } else {
                    this.v.setVisibility(0);
                    this.x.setData(e2.vote_condition_pic, e2.vote_condition_title, e2.vote_condition);
                }
            } else {
                this.v.setVisibility(8);
            }
        } else {
            this.A.setVisibility(8);
            this.v.setVisibility(8);
        }
        B();
        A(TbadkCoreApplication.getInst().getSkinType(), true);
    }

    public void D(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.I = onClickListener;
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdRecyclerView bdRecyclerView = this.s;
            if (bdRecyclerView != null) {
                bdRecyclerView.setVisibility(8);
            }
            this.b.hideLoadingView(w());
            if (this.F != null) {
                x();
            }
            if (this.G == null) {
                this.G = new h65(this.b, this.J);
            }
            this.G.k(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds340));
            this.G.m(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c3c));
            this.G.attachView(this.k, true);
            this.G.p();
            this.G.onChangeSkinType();
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            h65 h65Var = this.G;
            if (h65Var != null) {
                h65Var.dettachView(this.k);
                this.G = null;
            }
            this.b.hideLoadingView(w());
            if (this.F == null) {
                NoDataView a2 = NoDataViewFactory.a(this.b, this.H, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.e.c(str), null);
                this.F = a2;
                a2.setOnClickListener(this.I);
            }
            this.F.setTextOption(NoDataViewFactory.e.c(str));
            this.F.f(this.b.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.F.setVisibility(0);
        }
    }

    public BdRecyclerView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.s : (BdRecyclerView) invokeV.objValue;
    }

    public PbListView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D : (PbListView) invokeV.objValue;
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void x() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (noDataView = this.F) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public void y() {
        VoteStatusCard voteStatusCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (voteStatusCard = this.t) == null) {
            return;
        }
        voteStatusCard.e();
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            A(i, false);
        }
    }
}
