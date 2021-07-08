package d.a.p0.a0;

import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.c2;
import d.a.o0.r.q.w0;
/* loaded from: classes7.dex */
public class v extends d.a.p0.a0.b<c2> implements Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public TbImageView B;
    public String C;
    public String D;
    public String E;
    public View F;
    public ViewGroup G;
    public final View.OnClickListener H;
    public OriginalThreadCardView.b I;
    public HeadPendantClickableView m;
    public ThreadUserInfoLayout n;
    public TextView o;
    public TextView p;
    public OriginalThreadCardView q;
    public ThreadCommentAndPraiseInfoLayout r;
    public ThreadSourceShareAndPraiseLayout s;
    public NEGFeedBackView t;
    public View u;
    public View v;
    public TbImageView w;
    public TbPageContext<?> x;
    public c2 y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f53915e;

        public a(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53915e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f53915e.h() != null) {
                    this.f53915e.h().a(view, this.f53915e.y);
                }
                if (this.f53915e.y == null || this.f53915e.y.f52610e == null) {
                    return;
                }
                m.a(this.f53915e.y.f52610e.c0());
                v vVar = this.f53915e;
                vVar.F(vVar.y.f52610e.c0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f53916e;

        public b(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53916e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f53916e.h() != null) {
                    this.f53916e.h().a(view, this.f53916e.y);
                }
                v vVar = this.f53916e;
                if (view == vVar.s.f12604e || vVar.y == null || this.f53916e.y.f52610e == null) {
                    return;
                }
                m.a(this.f53916e.y.f52610e.c0());
                v vVar2 = this.f53916e;
                vVar2.F(vVar2.y.f52610e.c0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f53917e;

        public c(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53917e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53917e.r.changeSelectStatus();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f53918a;

        public d(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53918a = vVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                SkinManager.setBackgroundColor(this.f53918a.F, z ? R.color.CAM_X0201 : R.color.transparent);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b2 f53919e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ v f53920f;

        public e(v vVar, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, b2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53920f = vVar;
            this.f53919e = b2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f53920f.x != null) {
                    this.f53920f.f53777f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.f53920f.f53777f.getContext(), "", this.f53919e.x1, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f53921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ v f53922f;

        public f(v vVar, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53922f = vVar;
            this.f53921e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.f53922f.x.getPageActivity(), this.f53921e.getCardId())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f53923e;

        public g(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53923e = vVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f53923e.h() == null) {
                return;
            }
            this.f53923e.h().a(view, this.f53923e.y);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f53924a;

        public h(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53924a = vVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || this.f53924a.y == null || this.f53924a.y.f52610e == null) {
                return;
            }
            if (this.f53924a.h() != null) {
                b0<c2> h2 = this.f53924a.h();
                v vVar = this.f53924a;
                h2.a(vVar.q, vVar.y);
            }
            String c0 = this.f53924a.y.f52610e.c0();
            m.a(c0);
            this.f53924a.F(c0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.z = true;
        this.H = new g(this);
        this.I = new h(this);
        this.x = tbPageContext;
        View k = k();
        ViewGroup viewGroup = (ViewGroup) k.findViewById(R.id.thread_content_layout_outter);
        this.G = viewGroup;
        viewGroup.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) k.findViewById(R.id.thread_user_pendant_header);
        this.m = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.m.getHeadView().setIsRound(true);
            this.m.getHeadView().setDrawBorder(false);
            this.m.getHeadView().setDefaultResource(17170445);
            this.m.getHeadView().setRadius(d.a.c.e.p.l.g(this.x.getPageActivity(), R.dimen.ds70));
            this.m.getHeadView().setPlaceHolder(1);
        }
        this.m.setHasPendantStyle();
        if (this.m.getPendantView() != null) {
            this.m.getPendantView().setIsRound(true);
            this.m.getPendantView().setDrawBorder(false);
        }
        this.n = (ThreadUserInfoLayout) k.findViewById(R.id.thread_user_info_layout);
        this.t = new NEGFeedBackView(this.x);
        this.t.l((ViewGroup) k(), d.a.c.e.p.l.g(this.f53778g, R.dimen.tbds92), d.a.c.e.p.l.g(b(), R.dimen.tbds16));
        this.o = (TextView) k.findViewById(R.id.thread_title);
        this.p = (TextView) k.findViewById(R.id.thread_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) k.findViewById(R.id.original_thread_view);
        this.q = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.I);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) k.findViewById(R.id.thread_comment_layout);
        this.r = threadCommentAndPraiseInfoLayout;
        if (threadCommentAndPraiseInfoLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.r.setLayoutParams(layoutParams);
        }
        k.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.r.setReplyTimeVisible(false);
        this.r.setShowPraiseNum(true);
        this.r.setNeedAddPraiseIcon(true);
        this.r.setNeedAddReplyIcon(true);
        this.r.setShareVisible(true);
        this.r.setForumAfterClickListener(new a(this));
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) k.findViewById(R.id.card_transmit_source_read_share_layout);
        this.s = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.f12605f.setOnClickListener(this);
        this.s.f12605f.setNeedAddReplyIcon(true);
        this.s.setForumAfterClickListener(new b(this));
        this.u = k.findViewById(R.id.divider_line_above_praise);
        this.v = k.findViewById(R.id.card_divider_line);
        this.w = (TbImageView) k.findViewById(R.id.thread_theme_card);
        this.B = (TbImageView) k.findViewById(R.id.frs_normal_item_star_view);
        View findViewById = k.findViewById(R.id.thread_multi_del_mask_view);
        this.F = findViewById;
        findViewById.setOnClickListener(new c(this));
        this.r.setOnSelectStatusChangeListener(new d(this));
    }

    public final void A() {
        c2 c2Var;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2Var = this.y) == null || (b2Var = c2Var.f52610e) == null) {
            return;
        }
        m.a(b2Var.c0());
        F(b2Var.c0());
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.x.getPageActivity()).createFromThreadCfg(b2Var, null, this.y.f52611f, 18003, true, false, false);
        createFromThreadCfg.setStartFrom(this.l);
        createFromThreadCfg.setIsShareThread(true);
        m.a(b2Var.n1());
        this.x.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: B */
    public void l(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var) == null) {
            if (c2Var != null && c2Var.f52610e != null) {
                if (k() != null) {
                    k().setVisibility(0);
                }
                this.y = c2Var;
                b2 b2Var = c2Var.f52610e;
                if (this.t != null) {
                    SparseArray<String> P = b2Var.P();
                    if (P != null && P.size() > 0 && this.z) {
                        w0 w0Var = new w0();
                        w0Var.n(b2Var.n1());
                        w0Var.k(b2Var.Q());
                        w0Var.m(b2Var.A0());
                        w0Var.j(P);
                        w0Var.f52804g = b2Var.h1;
                        this.t.setData(w0Var);
                        this.t.setFirstRowSingleColumn(true);
                        this.t.setVisibility(z(b2Var) ? 8 : 0);
                    } else {
                        this.t.setVisibility(8);
                    }
                }
                if (this.y.f52613h == 1) {
                    this.n.setFrom(3);
                    y(b2Var);
                    M(b2Var);
                }
                this.n.setIsFromConcern(this.A);
                this.n.j(b2Var);
                this.n.setUserAfterClickListener(this.H);
                if (this.n.getHeaderImg() != null) {
                    if (this.n.getIsSimpleThread()) {
                        this.n.getHeaderImg().setVisibility(8);
                        this.m.setVisibility(8);
                    } else if (b2Var.H() != null && b2Var.H().getPendantData() != null && !StringUtils.isNull(b2Var.H().getPendantData().a())) {
                        this.n.getHeaderImg().setVisibility(4);
                        this.m.setVisibility(0);
                        this.m.setData(b2Var);
                    } else {
                        this.m.setVisibility(8);
                        this.n.getHeaderImg().setVisibility(0);
                        this.n.getHeaderImg().setData(b2Var);
                    }
                }
                K(b2Var);
                this.q.f(b2Var.u1);
                L(v(1));
                J(i());
                m(this.x, TbadkCoreApplication.getInst().getSkinType());
                F(b2Var.c0());
                if (this.r.isInFrsAllThread() && (d.a.p0.u0.b.e().g() || d.a.p0.u0.a.h().j())) {
                    this.F.setVisibility(0);
                    if (!b2Var.Z1() && !b2Var.a2() && !b2Var.o2()) {
                        this.F.setBackgroundResource(R.color.transparent);
                        return;
                    } else {
                        SkinManager.setBackgroundColor(this.F, R.color.CAM_X0201);
                        return;
                    }
                }
                this.F.setVisibility(8);
            } else if (k() != null) {
                k().setVisibility(8);
            }
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            m.l(this.o, str, R.color.CAM_X0105, R.color.CAM_X0109);
            m.l(this.p, str, R.color.CAM_X0105, R.color.CAM_X0109);
            this.q.setReadState(m.k(str));
        }
    }

    public void G(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        J(bdUniqueId);
    }

    public void H(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (view = this.v) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.z = z;
        }
    }

    public final void J(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            o(bdUniqueId);
            NEGFeedBackView nEGFeedBackView = this.t;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setUniqueId(bdUniqueId);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public final void K(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, b2Var) == null) || b2Var == null) {
            return;
        }
        if (!StringUtils.isNull(this.C) && !StringUtils.isNull(this.E)) {
            b2Var.a4(this.C, this.E);
        }
        SpannableStringBuilder F2 = b2Var.F2(false, true);
        if (F2 != null && !StringUtils.isNull(F2.toString())) {
            this.o.setVisibility(0);
            this.o.setOnTouchListener(new d.a.p0.z3.i(F2));
            this.o.setText(F2);
            m.l(this.o, b2Var.c0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return;
        }
        this.o.setVisibility(8);
    }

    public void L(int i2) {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (c2Var = this.y) == null || c2Var.f52610e == null) {
            return;
        }
        if (i2 == 1) {
            this.r.setVisibility(8);
            this.s.setFrom(this.y.f52612g);
            this.s.setShareReportFrom(this.y.f52613h);
            this.s.setStType(this.y.f52611f);
            this.s.g(this.y.f52610e);
            this.n.l(false);
            return;
        }
        this.r.setFrom(c2Var.f52612g);
        this.r.setShareReportFrom(this.y.f52613h);
        this.r.setStType(this.y.f52611f);
        this.r.setData(this.y.f52610e);
        this.r.setDisPraiseFrom(this.y.f52614i);
        this.s.setVisibility(8);
        this.n.l(true);
    }

    public final void M(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, b2Var) == null) || this.B == null) {
            return;
        }
        if (this.w != null && b2Var != null) {
            if (!StringUtils.isNull(b2Var.w1) && this.w.getVisibility() != 0) {
                NEGFeedBackView nEGFeedBackView = this.t;
                if (nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0 && (this.B.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                    layoutParams.rightMargin = d.a.c.e.p.l.g(this.x.getPageActivity(), R.dimen.tbds106);
                    this.B.setLayoutParams(layoutParams);
                }
                this.B.setVisibility(0);
                this.B.setImageDrawable(null);
                this.B.M(b2Var.w1, 10, false);
                this.B.setOnClickListener(new e(this, b2Var));
                return;
            }
            this.B.setVisibility(8);
            return;
        }
        this.B.setVisibility(8);
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? R.layout.card_transmit_thread_view : invokeV.intValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, tbPageContext, i2) == null) {
            if (this.f53776e != i2) {
                SkinManager.setBackgroundResource(k(), R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
                this.r.onChangeSkinType();
                this.n.h();
                NEGFeedBackView nEGFeedBackView = this.t;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.q();
                }
                this.q.n();
                SkinManager.setBackgroundColor(this.v, R.color.CAM_X0205);
                this.s.f();
            }
            c2 c2Var = this.y;
            if (c2Var != null && (b2Var = c2Var.f52610e) != null) {
                SkinManager.setBackgroundColor(this.F, (b2Var.Z1() || this.y.f52610e.a2()) ? R.color.CAM_X0201 : R.color.transparent);
            }
            HeadPendantClickableView headPendantClickableView = this.m;
            if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.m.getHeadView() instanceof TbImageView)) {
                this.m.getHeadView().setPlaceHolder(1);
            }
            this.f53776e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (h() != null) {
                h().a(view, this.y);
            }
            if (view == k() || view.getId() == R.id.thread_content_layout_outter) {
                A();
            }
        }
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.D = str;
        }
    }

    public int v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? d.a.p0.o.d.c().b(this.D, i2) : invokeI.intValue;
    }

    public ClickableHeaderImageView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                return threadUserInfoLayout.f12610e;
            }
            return null;
        }
        return (ClickableHeaderImageView) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.n;
            if (threadUserInfoLayout != null) {
                return threadUserInfoLayout.f12612g;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void y(b2 b2Var) {
        MetaData H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, b2Var) == null) || b2Var == null || this.w == null || (H = b2Var.H()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = H.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
            this.w.setVisibility(0);
            this.w.setImageBitmap(null);
            this.w.M(themeCard.getCardImageUrlAndroid(), 10, false);
            this.w.setOnClickListener(new f(this, themeCard));
            return;
        }
        this.w.setVisibility(8);
    }

    public final boolean z(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, b2Var)) == null) {
            if (b2Var == null || b2Var.H() == null || StringUtils.isNull(b2Var.H().getUserId())) {
                return false;
            }
            return b2Var.H().getUserId().equals(TbadkCoreApplication.getCurrentAccount());
        }
        return invokeL.booleanValue;
    }
}
