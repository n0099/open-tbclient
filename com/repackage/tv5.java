package com.repackage;

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
import com.repackage.nr4;
import tbclient.ElectionInfo.NoticeContent;
import tbclient.ManagerElection;
/* loaded from: classes7.dex */
public class tv5 {
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
    public y45 J;
    public ViewGroup K;
    public View.OnClickListener L;
    public View.OnClickListener M;
    public boolean N;
    public VoteStatusCard.b O;
    public RecyclerView.OnScrollListener P;
    public BdListView.p Q;
    public int a;
    public BarVoteActivity b;
    public int c;
    public int d;
    public int e;
    public float f;
    public int g;
    public zv5 h;
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv5 a;

        public a(tv5 tv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ki.A()) {
                if (this.a.J != null) {
                    this.a.J.dettachView(this.a.k);
                    this.a.J = null;
                }
                this.a.b.reload();
                if (this.a.s != null) {
                    this.a.s.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements VoteStatusCard.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv5 a;

        public b(tv5 tv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv5Var;
        }

        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.b
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.refresh();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv5 a;

        public c(tv5 tv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv5Var;
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
                tv5 tv5Var = this.a;
                tv5Var.f = Math.abs(tv5Var.l.getTop()) / this.a.a;
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

    /* loaded from: classes7.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv5 a;

        public d(tv5 tv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.s != null) {
                    this.a.s.stopScroll();
                }
                if (this.a.G == null || this.a.b == null) {
                    return;
                }
                if (ki.z()) {
                    if (this.a.d == iw5.c) {
                        this.a.G.L(mi.f(this.a.b, R.dimen.tbds152));
                    }
                    this.a.s.setNextPage(this.a.G);
                    this.a.G.B(null);
                    if (this.a.N) {
                        this.a.G.N();
                        this.a.b.loadmore();
                        return;
                    }
                    this.a.G.C(this.a.b.getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
                    this.a.G.f();
                    return;
                }
                this.a.s.setNextPage(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv5 a;

        /* loaded from: classes7.dex */
        public class a implements nr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                }
            }
        }

        public e(tv5 tv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nr4 nr4Var = new nr4(this.a.b);
                View inflate = LayoutInflater.from(this.a.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d013e, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090345);
                textView.setText(this.a.b.getResources().getString(R.string.obfuscated_res_0x7f0f1571) + "\n" + this.a.b.getResources().getString(R.string.obfuscated_res_0x7f0f1572));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                nr4Var.setContentView(inflate);
                nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0988, new a(this));
                nr4Var.create(this.a.b.getPageContext());
                SkinManager.setBackgroundShapeDrawable(nr4Var.getRealView(), mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                nr4Var.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv5 a;

        public f(tv5 tv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BarVoteActivity barVoteActivity = this.a.b;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(barVoteActivity, this.a.b.fid + "")));
            }
        }
    }

    public tv5(BarVoteActivity barVoteActivity) {
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
        this.M = new a(this);
        this.O = new b(this);
        this.P = new c(this);
        this.Q = new d(this);
        this.b = barVoteActivity;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(barVoteActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d013d, (ViewGroup) null);
        this.j = relativeLayout;
        this.b.addContentView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        BarVoteActivity barVoteActivity2 = this.b;
        barVoteActivity2.showLoadingView(this.j, false, mi.f(barVoteActivity2, R.dimen.obfuscated_res_0x7f0702be));
        this.k = this.j.findViewById(R.id.obfuscated_res_0x7f09127e);
        this.K = (ViewGroup) this.j.findViewById(R.id.obfuscated_res_0x7f09159a);
        this.o = this.j.findViewById(R.id.obfuscated_res_0x7f09150f);
        View findViewById = this.j.findViewById(R.id.obfuscated_res_0x7f091510);
        this.q = findViewById;
        findViewById.setAlpha(0.0f);
        NavigationBar navigationBar = (NavigationBar) this.j.findViewById(R.id.obfuscated_res_0x7f092454);
        this.p = navigationBar;
        navigationBar.setCenterTextTitle(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f02dc));
        if (this.p.getBarBgView() != null) {
            this.p.getBarBgView().setAlpha(0.0f);
        }
        this.a = mi.f(this.b, R.dimen.tbds402);
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView textView = (TextView) this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05d9, this.b).findViewById(R.id.obfuscated_res_0x7f091af7);
        this.r = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f02d3);
        this.r.setOnClickListener(this.b);
        this.s = (BdRecyclerView) this.j.findViewById(R.id.obfuscated_res_0x7f092452);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b);
        this.i = linearLayoutManager;
        this.s.setLayoutManager(linearLayoutManager);
        VoteAdapter voteAdapter = new VoteAdapter(barVoteActivity.getPageContext());
        this.C = voteAdapter;
        this.s.setAdapter(voteAdapter);
        this.l = (ViewGroup) LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d08a2, (ViewGroup) null, false);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.m = (TbImageView) this.l.findViewById(R.id.obfuscated_res_0x7f090d18);
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, (mi.k(this.b) * 884) / 1076));
        this.s.s(this.l);
        this.s.addOnScrollListener(this.P);
        this.s.setOnSrollToBottomListener(this.Q);
        this.F = this.b.getResources().getDimensionPixelSize(R.dimen.tbds134);
        View view2 = new View(this.b);
        this.n = view2;
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, this.F));
        this.n.setVisibility(4);
        this.s.r(this.n);
        this.t = (VoteStatusCard) this.l.findViewById(R.id.obfuscated_res_0x7f092458);
        View findViewById2 = this.l.findViewById(R.id.obfuscated_res_0x7f092464);
        this.u = findViewById2;
        findViewById2.setOnClickListener(new e(this));
        this.v = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f092466);
        this.w = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f092465);
        this.t.setOnRefreshListener(this.O);
        this.y = this.l.findViewById(R.id.obfuscated_res_0x7f090323);
        this.z = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f090327);
        SelectRuleView selectRuleView = (SelectRuleView) this.l.findViewById(R.id.obfuscated_res_0x7f090324);
        this.A = selectRuleView;
        selectRuleView.setType(1);
        this.x = (VoteCandidateCard) this.l.findViewById(R.id.obfuscated_res_0x7f092448);
        SearchView searchView = (SearchView) this.l.findViewById(R.id.obfuscated_res_0x7f092456);
        this.B = searchView;
        searchView.a(new f(this));
        this.D = (FloatMyRecordCard) this.j.findViewById(R.id.obfuscated_res_0x7f0909d2);
        this.E = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f092460);
        PbListView pbListView = new PbListView(this.b);
        this.G = pbListView;
        pbListView.b();
        this.G.p(R.color.CAM_X0204);
        this.G.t(mi.f(this.b, R.dimen.tbds182));
        this.G.x();
        this.G.G(R.dimen.tbfontsize33);
        this.G.E(SkinManager.getColor(R.color.CAM_X0107));
        this.G.A(R.color.CAM_X0110);
        this.G.s();
        this.H = (NoNetworkView) this.j.findViewById(R.id.obfuscated_res_0x7f0915ac);
    }

    public void A(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z || this.c != i) {
                this.c = i;
                y45 y45Var = this.J;
                if (y45Var != null) {
                    y45Var.onChangeSkinType();
                }
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201, i);
                SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i);
                NavigationBar navigationBar = this.p;
                if (navigationBar != null) {
                    SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207, i);
                    float f2 = this.f;
                    if (f2 > 0.5d) {
                        SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
                        SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i);
                    } else if (f2 <= 0.5d) {
                        zv5 zv5Var = this.h;
                        if (zv5Var != null && zv5Var.a() != null && this.h.a().g() <= 2 && this.h.a().g() >= 1) {
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
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0105);
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
                    pbListView.E(SkinManager.getColor(i, (int) R.color.CAM_X0107));
                    this.G.d(i);
                }
                this.H.c(this.b.getPageContext(), i);
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
            if (this.d == iw5.c) {
                this.G.L(mi.f(this.b, R.dimen.tbds152));
            }
            this.G.B(this.b);
            this.s.setNextPage(this.G);
            if (this.N) {
                this.G.M();
                return;
            }
            this.G.C(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
            this.G.f();
        }
    }

    public void C(zv5 zv5Var) {
        yv5 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zv5Var) == null) || zv5Var == null) {
            return;
        }
        this.N = zv5Var.d();
        if (zv5Var.a() != null && (a2 = zv5Var.a()) != null) {
            int g = a2.g();
            this.d = g;
            if (g == iw5.c) {
                this.B.setVisibility(8);
                this.E.setVisibility(8);
                this.x.setVisibility(8);
            }
            NoticeContent e2 = a2.e();
            if (e2 != null && !TextUtils.isEmpty(e2.public_notice)) {
                G(e2.public_notice + "占");
            } else {
                G(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f1570) + "占");
            }
        }
        this.t.setData(zv5Var);
        VoteAdapter voteAdapter = this.C;
        if (voteAdapter != null) {
            this.h = zv5Var;
            voteAdapter.g(zv5Var);
        }
        int i = this.d;
        if (i == iw5.c) {
            this.D.setVisibility(0);
            this.D.setData(zv5Var);
            this.u.setVisibility(0);
            this.y.setVisibility(8);
        } else if (i == iw5.b) {
            this.x.setData(VoteCandidateCard.A, zv5Var);
            this.D.setVisibility(8);
            this.u.setVisibility(8);
            this.B.setRank(zv5Var.a().b());
            if (zv5Var.e() != null) {
                ManagerElection e3 = zv5Var.e();
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
            this.b.hideLoadingView(w());
            if (this.I != null) {
                x();
            }
            if (this.J == null) {
                this.J = new y45(this.b, this.M);
            }
            this.J.k(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds340));
            this.J.m(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c2d));
            this.J.attachView(this.k, true);
            this.J.p();
            this.J.onChangeSkinType();
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            y45 y45Var = this.J;
            if (y45Var != null) {
                y45Var.dettachView(this.k);
                this.J = null;
            }
            this.b.hideLoadingView(w());
            if (this.I == null) {
                NoDataView a2 = NoDataViewFactory.a(this.b, this.K, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.e.c(str), null);
                this.I = a2;
                a2.setOnClickListener(this.L);
            }
            this.I.setTextOption(NoDataViewFactory.e.c(str));
            this.I.f(this.b.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.I.setVisibility(0);
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_common_explain12_gray66);
            drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
            yn ynVar = new yn(drawable, 0);
            ynVar.b(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
            spannableString.setSpan(ynVar, str.length() - 1, str.length(), 17);
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

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            A(i, false);
        }
    }
}
